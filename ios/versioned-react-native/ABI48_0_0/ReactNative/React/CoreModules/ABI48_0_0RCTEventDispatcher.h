/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

#import <UIKit/UIKit.h>

#import <ABI48_0_0React/ABI48_0_0RCTBridge.h>
#import <ABI48_0_0React/ABI48_0_0RCTEventDispatcherProtocol.h>
#import <ABI48_0_0React/ABI48_0_0RCTInitializing.h>
/**
 * This class wraps the -[ABI48_0_0RCTBridge enqueueJSCall:args:] method, and
 * provides some convenience methods for generating event calls.
 */
@interface ABI48_0_0RCTEventDispatcher : NSObject <ABI48_0_0RCTEventDispatcherProtocol, ABI48_0_0RCTInitializing>
@end
