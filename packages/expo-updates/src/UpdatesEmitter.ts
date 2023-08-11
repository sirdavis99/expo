import { DeviceEventEmitter } from 'expo-modules-core';
import { EventEmitter, EventSubscription } from 'fbemitter';

import type { UpdateEvent, UpdatesNativeStateChangeEvent } from './Updates.types';

let _emitter: EventEmitter | null;

function _getEmitter(): EventEmitter {
  if (!_emitter) {
    _emitter = new EventEmitter();
    DeviceEventEmitter.addListener('Expo.nativeUpdatesEvent', _emitEvent);
    DeviceEventEmitter.addListener(
      'Expo.nativeUpdatesStateChangeEvent',
      _emitNativeStateChangeEvent
    );
  }
  return _emitter;
}

// Reemits native UpdateEvents sent during the startup update check
function _emitEvent(params): void {
  if (!_emitter) {
    throw new Error(`EventEmitter must be initialized to use from its listener`);
  }
  let newParams = { ...params };
  if (typeof params === 'string') {
    newParams = JSON.parse(params);
  }
  if (newParams.manifestString) {
    newParams.manifest = JSON.parse(newParams.manifestString);
    delete newParams.manifestString;
  }
  _emitter.emit('Expo.updatesEvent', newParams);
}

// Reemits native state change events
function _emitNativeStateChangeEvent(params: any) {
  if (!_emitter) {
    throw new Error(`EventEmitter must be initialized to use from its listener`);
  }
  let newParams = { ...params };
  if (typeof params === 'string') {
    newParams = JSON.parse(params);
  }
  if (newParams.context.latestManifestString) {
    newParams.context.latestManifest = JSON.parse(newParams.context.latestManifestString);
    delete newParams.context.latestManifestString;
  }
  if (newParams.context.downloadedManifestString) {
    newParams.context.downloadedManifest = JSON.parse(newParams.context.downloadedManifestString);
    delete newParams.context.downloadedManifestString;
  }
  if (newParams.context.lastCheckForUpdateTimeString) {
    newParams.context.lastCheckForUpdateTime = new Date(
      newParams.context.lastCheckForUpdateTimeString
    );
    delete newParams.context.lastCheckForUpdateTimeString;
  }
  if (newParams.context.rollbackCommitTimeString) {
    newParams.context.rollbackCommitTime = new Date(newParams.context.rollbackCommitTimeString);
    delete newParams.context.rollbackCommitTimeString;
  }
  _emitter.emit('Expo.updatesStateChangeEvent', newParams);
}

/**
 * Adds a callback to be invoked when updates-related events occur (such as upon the initial app
 * load) due to auto-update settings chosen at build-time. See also the
 * [`useUpdateEvents`](#useupdateeventslistener) React hook.
 *
 * @param listener A function that will be invoked with an [`UpdateEvent`](#updateevent) instance
 * and should not return any value.
 * @return An `EventSubscription` object on which you can call `remove()` to unsubscribe the
 * listener.
 */
export function addListener(listener: (event: UpdateEvent) => void): EventSubscription {
  const emitter = _getEmitter();
  return emitter.addListener('Expo.updatesEvent', listener);
}

// Internal methods

/**
 * @hidden
 */
export const addUpdatesStateChangeListener = (
  listener: (event: UpdatesNativeStateChangeEvent) => void
) => {
  // Add listener for state change events
  const emitter = _getEmitter();
  return emitter.addListener('Expo.updatesStateChangeEvent', listener);
};

/**
 * @hidden
 */
export const emitStateChangeEvent = (event: UpdatesNativeStateChangeEvent) => {
  // Allows JS to emit a state change event (used in testing)
  _emitNativeStateChangeEvent(event);
};
