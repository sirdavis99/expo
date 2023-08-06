import { VideoView, useVideoPlayer } from 'expo-video';
import React, { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import { PixelRatio, ScrollView, StyleSheet, View } from 'react-native';

import Button from '../../components/Button';
import HeadingText from '../../components/HeadingText';
import VideoPlayer from './VideoPlayer';

export default function VideoScreen() {
  // const videoItem = useMemo(() => {
  //   return new Video.VideoItem(
  //     'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4'
  //   );
  // }, []);

  // console.log(videoItem, videoItem.__expo_shared_object_id__, videoItem.duration);

  const ref = useRef<VideoView>(null);

  const enterFullscreen = useCallback(() => {
    ref.current?.enterFullscreen();
  }, [ref]);

  const player = useVideoPlayer(
    'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4'
  );

  const togglePlayer = useCallback(() => {
    if (player.isPlaying) {
      player.pause();
    } else {
      player.play();
    }
  }, [player]);

  const replaceItem = useCallback(() => {
    player.replace(
      'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4'
    );
  }, []);

  useEffect(() => {
    player.play();
  }, []);

  console.log(player.__expo_shared_object_id__);

  return (
    <ScrollView contentContainerStyle={styles.contentContainer}>
      <VideoView
        nativeRef={ref}
        style={styles.video}
        player={player.__expo_shared_object_id__}
        nativeControls={false}
        contentFit="contain"
        contentPosition={{ dx: 0, dy: 0 }}
        allowsFullscreen
        canControlPlayback
        volumeControls={false}
        showsTimecodes={false}
        requiresLinearPlayback
      />

      <VideoView
        nativeRef={ref}
        style={styles.video}
        player={player.__expo_shared_object_id__}
        nativeControls
        contentFit="contain"
        contentPosition={{ dx: 0, dy: 0 }}
        allowsFullscreen
        canControlPlayback
        volumeControls={false}
        showsTimecodes={false}
        requiresLinearPlayback
      />

      <View style={styles.buttons}>
        <Button style={styles.button} title="Toggle" onPress={togglePlayer} />
        <Button style={styles.button} title="Replace" onPress={replaceItem} />
        <Button style={styles.button} title="Enter fullscreen" onPress={enterFullscreen} />
      </View>
      {/* <HeadingText>HTTP player</HeadingText>
      <VideoPlayer
        sources={[
          { uri: 'http://d23dyxeqlo5psv.cloudfront.net/big_buck_bunny.mp4' },
          { uri: 'http://techslides.com/demos/sample-videos/small.mp4' },
          { uri: 'http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8' },
        ]}
      />
      <HeadingText>Local asset player</HeadingText>
      <VideoPlayer
        sources={[
          require('../../../assets/videos/ace.mp4'),
          require('../../../assets/videos/star.mp4'),
        ]}
      /> */}
    </ScrollView>
  );
}
VideoScreen.navigationOptions = {
  title: 'Video',
};

const styles = StyleSheet.create({
  contentContainer: {
    padding: 10,
    alignItems: 'center',
  },
  video: {
    width: 400,
    height: 300,
    borderBottomWidth: 1.0 / PixelRatio.get(),
    borderBottomColor: '#cccccc',
  },
  buttons: {
    flexDirection: 'row',
  },
  button: {
    margin: 15,
  },
});
