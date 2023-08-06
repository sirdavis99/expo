import React from 'react';

import NativeVideoModule from './NativeVideoModule';
import NativeVideoView from './NativeVideoView';

export function useVideoPlayer(source: string | null = null) {
  return React.useMemo(() => {
    return new NativeVideoModule.VideoPlayer(source);
  }, []);
}

export class VideoView extends React.PureComponent<any> {
  render(): React.ReactNode {
    const { nativeRef, ...props } = this.props;

    return <NativeVideoView {...props} ref={nativeRef} />;
  }
}
