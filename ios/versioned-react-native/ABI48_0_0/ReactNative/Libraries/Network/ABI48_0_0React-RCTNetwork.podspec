# Copyright (c) Meta Platforms, Inc. and affiliates.
#
# This source code is licensed under the MIT license found in the
# LICENSE file in the root directory of this source tree.

require "json"

package = JSON.parse(File.read(File.join(__dir__, "..", "..", "package.json")))
version = package['version']



folly_compiler_flags = '-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1 -Wno-comma -Wno-shorten-64-to-32'
folly_version = '2021.07.22.00'

Pod::Spec.new do |s|
  s.name                   = "ABI48_0_0React-RCTNetwork"
  s.version                = version
  s.summary                = "The networking library of React Native."
  s.homepage               = "https://reactnative.dev/"
  s.license                = package["license"]
  s.author                 = "Facebook, Inc. and its affiliates"
  s.platforms              = { :ios => "12.4" }
  s.compiler_flags         = folly_compiler_flags + ' -Wno-nullability-completeness'
  s.source                 = { :path => "." }
  s.source_files           = "*.{m,mm}"
  s.preserve_paths         = "package.json", "LICENSE", "LICENSE-docs"
  s.header_dir             = "ABI48_0_0RCTNetwork"
  s.pod_target_xcconfig    = {
                               "USE_HEADERMAP" => "YES",
                               "CLANG_CXX_LANGUAGE_STANDARD" => "c++17",
                               "HEADER_SEARCH_PATHS" => "\"$(PODS_ROOT)/RCT-Folly\" \"${PODS_ROOT}/Headers/Public/React-Codegen/react/renderer/components\" \"${PODS_CONFIGURATION_BUILD_DIR}/React-Codegen/React_Codegen.framework/Headers\""
                             }
  s.frameworks             = "MobileCoreServices"

  s.dependency "RCT-Folly", folly_version
  s.dependency "ABI48_0_0React-Codegen", version
  s.dependency "ABI48_0_0RCTTypeSafety", version
  s.dependency "ABI48_0_0ReactCommon/turbomodule/core", version
  s.dependency "ABI48_0_0React-jsi", version
  s.dependency "ABI48_0_0React-Core/RCTNetworkHeaders", version
end
