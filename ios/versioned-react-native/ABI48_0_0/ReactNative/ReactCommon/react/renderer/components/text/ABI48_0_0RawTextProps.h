/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

#pragma once

#include <memory>

#include <ABI48_0_0React/ABI48_0_0renderer/core/Props.h>
#include <ABI48_0_0React/ABI48_0_0renderer/core/PropsParserContext.h>
#include <ABI48_0_0React/ABI48_0_0renderer/debug/DebugStringConvertible.h>

namespace ABI48_0_0facebook {
namespace ABI48_0_0React {

class RawTextProps;

using SharedRawTextProps = std::shared_ptr<const RawTextProps>;

class RawTextProps : public Props {
 public:
  RawTextProps() = default;
  RawTextProps(
      const PropsParserContext &context,
      const RawTextProps &sourceProps,
      const RawProps &rawProps);

#pragma mark - Props

  std::string text{};

#pragma mark - DebugStringConvertible

#if ABI48_0_0RN_DEBUG_STRING_CONVERTIBLE
  SharedDebugStringConvertibleList getDebugProps() const override;
#endif
};

} // namespace ABI48_0_0React
} // namespace ABI48_0_0facebook
