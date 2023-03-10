// Copyright 2017-present 650 Industries. All rights reserved.

#import <ABI48_0_0EXMediaLibrary/ABI48_0_0EXMediaLibraryMediaLibraryPermissionRequester.h>

@implementation ABI48_0_0EXMediaLibraryMediaLibraryPermissionRequester

+ (NSString *)permissionType
{
  return @"mediaLibrary";
}

#ifdef __IPHONE_14_0
- (PHAccessLevel)accessLevel
{
  return PHAccessLevelReadWrite;
}
#endif

- (NSDictionary *)getPermissions
{
  ABI48_0_0EXPermissionStatus status;
  NSString *scope;
  
  PHAuthorizationStatus permissions;
#ifdef __IPHONE_14_0
  if (@available(iOS 14, *)) {
    permissions = [PHPhotoLibrary authorizationStatusForAccessLevel:[self accessLevel]];
  } else {
    permissions = [PHPhotoLibrary authorizationStatus];
  }
#else
  permissions = [PHPhotoLibrary authorizationStatus];
#endif
  
  switch (permissions) {
    case PHAuthorizationStatusAuthorized:
      status = ABI48_0_0EXPermissionStatusGranted;
      scope = @"all";
      break;
#ifdef __IPHONE_14_0
    case PHAuthorizationStatusLimited:
      status = ABI48_0_0EXPermissionStatusGranted;
      scope = @"limited";
      break;
#endif
    case PHAuthorizationStatusDenied:
    case PHAuthorizationStatusRestricted:
      status = ABI48_0_0EXPermissionStatusDenied;
      scope = @"none";
      break;
    case PHAuthorizationStatusNotDetermined:
      status = ABI48_0_0EXPermissionStatusUndetermined;
      scope = @"none";
      break;
  }

  return @{
    @"status": @(status),
    @"accessPrivileges": scope,
    @"granted": @(status == ABI48_0_0EXPermissionStatusGranted)
  };
}

- (void)requestPermissionsWithResolver:(ABI48_0_0EXPromiseResolveBlock)resolve rejecter:(ABI48_0_0EXPromiseRejectBlock)reject
{
  ABI48_0_0EX_WEAKIFY(self)
  void(^handler)(PHAuthorizationStatus) = ^(PHAuthorizationStatus status) {
    ABI48_0_0EX_STRONGIFY(self)
    resolve([self getPermissions]);
  };

#ifdef __IPHONE_14_0
  if (@available(iOS 14, *)) {
    [PHPhotoLibrary requestAuthorizationForAccessLevel:[self accessLevel] handler:handler];
  } else {
    [PHPhotoLibrary requestAuthorization:handler];
  }
#else
  [PHPhotoLibrary requestAuthorization:handler];
#endif
}

@end
