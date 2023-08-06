import React from 'react';
import NativeVideoModule from './NativeVideoModule';
import NativeVideoView from './NativeVideoView';
export function useVideoPlayer(source = null) {
    return React.useMemo(() => {
        return new NativeVideoModule.VideoPlayer(source);
    }, []);
}
export class VideoView extends React.PureComponent {
    render() {
        const { nativeRef, ...props } = this.props;
        return React.createElement(NativeVideoView, { ...props, ref: nativeRef });
    }
}
//# sourceMappingURL=VideoView.js.map