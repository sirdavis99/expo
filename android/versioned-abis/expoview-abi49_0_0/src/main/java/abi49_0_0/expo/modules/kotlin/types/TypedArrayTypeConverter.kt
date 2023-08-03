package abi49_0_0.expo.modules.kotlin.types

import abi49_0_0.expo.modules.kotlin.AppContext
import abi49_0_0.expo.modules.kotlin.jni.CppType
import abi49_0_0.expo.modules.kotlin.jni.ExpectedType
import abi49_0_0.expo.modules.kotlin.jni.JavaScriptTypedArray
import abi49_0_0.expo.modules.kotlin.typedarray.BigInt64Array
import abi49_0_0.expo.modules.kotlin.typedarray.BigUint64Array
import abi49_0_0.expo.modules.kotlin.typedarray.Float32Array
import abi49_0_0.expo.modules.kotlin.typedarray.Float64Array
import abi49_0_0.expo.modules.kotlin.typedarray.Int16Array
import abi49_0_0.expo.modules.kotlin.typedarray.Int32Array
import abi49_0_0.expo.modules.kotlin.typedarray.Int8Array
import abi49_0_0.expo.modules.kotlin.typedarray.TypedArray
import abi49_0_0.expo.modules.kotlin.typedarray.Uint16Array
import abi49_0_0.expo.modules.kotlin.typedarray.Uint32Array
import abi49_0_0.expo.modules.kotlin.typedarray.Uint8Array
import abi49_0_0.expo.modules.kotlin.typedarray.Uint8ClampedArray

abstract class BaseTypeArrayConverter<T : TypedArray>(isOptional: Boolean) : NullAwareTypeConverter<T>(isOptional) {
  override fun convertNonOptional(value: Any, context: AppContext?): T = wrapJavaScriptTypedArray(value as JavaScriptTypedArray)
  override fun getCppRequiredTypes(): ExpectedType = ExpectedType(CppType.TYPED_ARRAY)
  override fun isTrivial() = false

  abstract fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray): T
}

class Int8ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Int8Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Int8Array(value)
}

class Int16ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Int16Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Int16Array(value)
}

class Int32ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Int32Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Int32Array(value)
}

class Uint8ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Uint8Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Uint8Array(value)
}

class Uint8ClampedArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Uint8ClampedArray>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Uint8ClampedArray(value)
}

class Uint16ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Uint16Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Uint16Array(value)
}

class Uint32ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Uint32Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Uint32Array(value)
}

class Float32ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Float32Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Float32Array(value)
}

class Float64ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<Float64Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = Float64Array(value)
}

class BigInt64ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<BigInt64Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = BigInt64Array(value)
}

class BigUint64ArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<BigUint64Array>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray) = BigUint64Array(value)
}

class TypedArrayTypeConverter(isOptional: Boolean) : BaseTypeArrayConverter<TypedArray>(isOptional) {
  override fun wrapJavaScriptTypedArray(value: JavaScriptTypedArray): TypedArray = value
  override fun isTrivial() = true
}
