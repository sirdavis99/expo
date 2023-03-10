/**
* This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
*
* Do not edit this file as changes may cause incorrect behavior and will be lost
* once the code is regenerated.
*
* @generated by codegen project: GeneratePropsJavaDelegate.js
*/

package abi48_0_0.com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import abi48_0_0.com.facebook.react.bridge.ReadableArray;
import abi48_0_0.com.facebook.react.uimanager.BaseViewManagerDelegate;
import abi48_0_0.com.facebook.react.uimanager.BaseViewManagerInterface;

public class RNSVGRadialGradientManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGRadialGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
  public RNSVGRadialGradientManagerDelegate(U viewManager) {
    super(viewManager);
  }
  @Override
  public void setProperty(T view, String propName, @Nullable Object value) {
    switch (propName) {
      case "name":
        mViewManager.setName(view, value == null ? null : (String) value);
        break;
      case "opacity":
        mViewManager.setOpacity(view, value == null ? 1f : ((Double) value).floatValue());
        break;
      case "matrix":
        mViewManager.setMatrix(view, (ReadableArray) value);
        break;
      case "mask":
        mViewManager.setMask(view, value == null ? null : (String) value);
        break;
      case "markerStart":
        mViewManager.setMarkerStart(view, value == null ? null : (String) value);
        break;
      case "markerMid":
        mViewManager.setMarkerMid(view, value == null ? null : (String) value);
        break;
      case "markerEnd":
        mViewManager.setMarkerEnd(view, value == null ? null : (String) value);
        break;
      case "clipPath":
        mViewManager.setClipPath(view, value == null ? null : (String) value);
        break;
      case "clipRule":
        mViewManager.setClipRule(view, value == null ? 0 : ((Double) value).intValue());
        break;
      case "responsible":
        mViewManager.setResponsible(view, value == null ? false : (boolean) value);
        break;
      case "display":
        mViewManager.setDisplay(view, value == null ? null : (String) value);
        break;
      case "pointerEvents":
        mViewManager.setPointerEvents(view, value == null ? null : (String) value);
        break;
      case "fx":
        if (value instanceof String) {
          mViewManager.setFx(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setFx(view, (Double) value);
        } else {
          mViewManager.setFx(view, (Double) null);
        }
        break;
      case "fy":
        if (value instanceof String) {
          mViewManager.setFy(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setFy(view, (Double) value);
        } else {
          mViewManager.setFy(view, (Double) null);
        }
        break;
      case "cx":
        if (value instanceof String) {
          mViewManager.setCx(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setCx(view, (Double) value);
        } else {
          mViewManager.setCx(view, (Double) null);
        }
        break;
      case "cy":
        if (value instanceof String) {
          mViewManager.setCy(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setCy(view, (Double) value);
        } else {
          mViewManager.setCy(view, (Double) null);
        }
        break;
      case "rx":
        if (value instanceof String) {
          mViewManager.setRx(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setRx(view, (Double) value);
        } else {
          mViewManager.setRx(view, (Double) null);
        }
        break;
      case "ry":
        if (value instanceof String) {
          mViewManager.setRy(view, (String) value);
        } else if (value instanceof Double) {
          mViewManager.setRy(view, (Double) value);
        } else {
          mViewManager.setRy(view, (Double) null);
        }
        break;
      case "gradient":
        mViewManager.setGradient(view, (ReadableArray) value);
        break;
      case "gradientUnits":
        mViewManager.setGradientUnits(view, value == null ? 0 : ((Double) value).intValue());
        break;
      case "gradientTransform":
        mViewManager.setGradientTransform(view, (ReadableArray) value);
        break;
      default:
        super.setProperty(view, propName, value);
    }
  }
}
