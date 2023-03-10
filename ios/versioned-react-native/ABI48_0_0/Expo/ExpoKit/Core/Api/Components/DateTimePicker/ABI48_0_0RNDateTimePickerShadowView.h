#import <ABI48_0_0React/ABI48_0_0RCTShadowView.h>
#import "ABI48_0_0RNDateTimePicker.h"

@interface ABI48_0_0RNDateTimePickerShadowView : ABI48_0_0RCTShadowView

@property (nullable, nonatomic, strong) ABI48_0_0RNDateTimePicker *picker;
@property (nonatomic) UIDatePickerMode mode;
@property (nullable, nonatomic, strong) NSDate *date;
@property (nullable, nonatomic, strong) NSLocale *locale;
@property (nonatomic, assign) UIDatePickerStyle displayIOS API_AVAILABLE(ios(13.4));

@end
