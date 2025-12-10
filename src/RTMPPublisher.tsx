import React, { forwardRef, useImperativeHandle } from 'react';
import { NativeModules } from 'react-native';
import PublisherComponent, {
  type BluetoothDeviceStatusChangedType,
  type ConnectionFailedType,
  type ConnectionStartedType,
  type ConnectionSuccessType,
  type DisconnectType,
  type NewBitrateReceivedType,
  type StreamStateChangedType,
} from './Component';
import type {
  AudioInputType,
  RTMPPublisherProps,
  RTMPPublisherRefProps
} from './types';

const RTMPModule = NativeModules.RTMPPublisher;

const RTMPPublisher = forwardRef<RTMPPublisherRefProps, RTMPPublisherProps>(
  (
    {
      onConnectionFailed,
      onConnectionStarted,
      onConnectionSuccess,
      onDisconnect,
      onNewBitrateReceived,
      onStreamStateChanged,
      onBluetoothDeviceStatusChanged,
      ...props
    },
    ref
  ) => {
    const startStream = async () => await RTMPModule.startStream();

    const stopStream = async () => await RTMPModule.stopStream();

    const isStreaming = async () => RTMPModule.isStreaming();

    const isCameraOnPreview = async () => RTMPModule.isCameraOnPreview();

    const getPublishURL = async () => RTMPModule.getPublishURL();

    const hasCongestion = async () => RTMPModule.hasCongestion();

    const isAudioPrepared = async () => RTMPModule.isAudioPrepared();

    const isVideoPrepared = async () => RTMPModule.isVideoPrepared();

    const isMuted = async () => RTMPModule.isMuted();

    const mute = () => RTMPModule.mute();

    const unmute = () => RTMPModule.unmute();

    const switchCamera = () => RTMPModule.switchCamera();

    const toggleFlash = () => RTMPModule.toggleFlash();

    const setAudioInput = (audioInput: AudioInputType) =>
      RTMPModule.setAudioInput(audioInput);

    const handleOnConnectionFailed = (e: ConnectionFailedType) => {
      onConnectionFailed && onConnectionFailed(e.nativeEvent.data);
    };

    const handleOnConnectionStarted = (e: ConnectionStartedType) => {
      onConnectionStarted && onConnectionStarted(e.nativeEvent.data);
    };

    const handleOnConnectionSuccess = (e: ConnectionSuccessType) => {
      onConnectionSuccess && onConnectionSuccess(e.nativeEvent.data);
    };

    const handleOnDisconnect = (e: DisconnectType) => {
      onDisconnect && onDisconnect(e.nativeEvent.data);
    };

    const handleOnNewBitrateReceived = (e: NewBitrateReceivedType) => {
      onNewBitrateReceived && onNewBitrateReceived(e.nativeEvent.data);
    };

    const handleOnStreamStateChanged = (e: StreamStateChangedType) => {
      onStreamStateChanged && onStreamStateChanged(e.nativeEvent.data);
    };

    const handleBluetoothDeviceStatusChanged = (
      e: BluetoothDeviceStatusChangedType
    ) => {
      onBluetoothDeviceStatusChanged &&
        onBluetoothDeviceStatusChanged(e.nativeEvent.data);
    };

    useImperativeHandle(ref, () => ({
      startStream,
      stopStream,
      isStreaming,
      isCameraOnPreview,
      getPublishURL,
      hasCongestion,
      isAudioPrepared,
      isVideoPrepared,
      isMuted,
      mute,
      unmute,
      switchCamera,
      toggleFlash,
      setAudioInput,
    }));

    return (
      <PublisherComponent
        {...props}
        onDisconnect={handleOnDisconnect}
        onConnectionFailed={handleOnConnectionFailed}
        onConnectionStarted={handleOnConnectionStarted}
        onConnectionSuccess={handleOnConnectionSuccess}
        onNewBitrateReceived={handleOnNewBitrateReceived}
        onStreamStateChanged={handleOnStreamStateChanged}
        onBluetoothDeviceStatusChanged={handleBluetoothDeviceStatusChanged}
      />
    );
  }
);

export default RTMPPublisher;
