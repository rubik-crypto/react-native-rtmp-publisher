import { Platform } from 'react-native';
// export { default } from './RTMPPublisher';
// export {
//   AudioInputType,
//   BluetoothDeviceStatuses, RTMPPublisherProps,
//   RTMPPublisherRefProps,
//   StreamState,
//   StreamStatus
// } from './types';

// 使用Platform.select进行条件导出
const RTMPPublisher = Platform.select({
  web: () => require('./RTMPPublisher.web').default,
  default: () => require('./RTMPPublisher').default,
})();

export default RTMPPublisher;