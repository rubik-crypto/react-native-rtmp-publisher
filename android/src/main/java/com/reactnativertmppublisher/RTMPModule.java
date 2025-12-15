package com.reactnativertmppublisher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.reactnativertmppublisher.enums.AudioInputType;
import android.util.Log;

public class RTMPModule extends ReactContextBaseJavaModule {
  private final String REACT_MODULE_NAME = "RTMPPublisher";

  public RTMPModule(@Nullable ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @NonNull
  @Override
  public String getName() {
    return REACT_MODULE_NAME;
  }

  @ReactMethod
  public void isStreaming(Promise promise) {
    try {
      boolean streamStatus = RTMPManager.publisher.isStreaming();
      promise.resolve(streamStatus);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void isCameraOnPreview(Promise promise) {
    try {
      boolean streamStatus = RTMPManager.publisher.isOnPreview();
      promise.resolve(streamStatus);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void getPublishURL(Promise promise) {
    try {
      String url = RTMPManager.publisher.getPublishURL();
      promise.resolve(url);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void hasCongestion(Promise promise) {
    try {
      boolean congestionStatus = RTMPManager.publisher.hasCongestion();
      promise.resolve(congestionStatus);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void isAudioPrepared(Promise promise) {
    try {
      boolean status = RTMPManager.publisher.isAudioPrepared();
      promise.resolve(status);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void isVideoPrepared(Promise promise) {
    try {
      boolean status = RTMPManager.publisher.isVideoPrepared();
      promise.resolve(status);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void isMuted(Promise promise) {
    try {
      boolean status = RTMPManager.publisher.isAudioMuted();
      promise.resolve(status);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void mute(Promise promise) {
    try {
      if (RTMPManager.publisher.isAudioMuted()) {
        promise.resolve(true);
        return;
      }
      RTMPManager.publisher.disableAudio();
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void unmute(Promise promise) {
    try {
      if (!RTMPManager.publisher.isAudioMuted()) {
        promise.resolve(false);
        return;
      }

      RTMPManager.publisher.enableAudio();
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void switchCamera(Promise promise) {
    try {
      RTMPManager.publisher.switchCamera();
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void startStream(String quality,Promise promise) {
    try {
      RTMPManager.publisher.startStream(quality);
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void stopStream(Promise promise) {
    try {
      RTMPManager.publisher.stopStream();
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void toggleFlash(Promise promise) {
    try {
      RTMPManager.publisher.toggleFlash();
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void setAudioInput(int audioInputType, Promise promise) {
    try {
      AudioInputType selectedType = AudioInputType.values()[audioInputType];
      RTMPManager.publisher.setAudioInput(selectedType);
      promise.resolve(true);
    } catch (Exception e) {
      promise.reject(e);
    }
  }
}
