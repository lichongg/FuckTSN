package cn.easyar.engine.recorder;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AVRecorderConfig {
    private final String TAG = getClass().getSimpleName();
    private AudioEncorderConfig mAudioEncorderConfig;
    private Muxer mMuxer;
    private final File mOutputFile;
    private String mPath;
    private boolean mRotationClip;
    private VideoEncoderConfig mVideoEncoderConfig;

    public int getAudioBitrate() {
        return this.mAudioEncorderConfig.getBitRate();
    }

    public int getAudioSamplerate() {
        return this.mAudioEncorderConfig.getSampleRate();
    }

    public int getHeight() {
        return this.mVideoEncoderConfig.getHeight();
    }

    public Muxer getMuxer() {
        return this.mMuxer;
    }

    public int getNumAudioChannels() {
        return this.mAudioEncorderConfig.getChannel();
    }

    public String getPath() {
        return this.mPath;
    }

    public boolean getRotationClip() {
        return this.mRotationClip;
    }

    public int getTextureHeight() {
        return this.mVideoEncoderConfig.getTextureHeight();
    }

    public int getTextureWidth() {
        return this.mVideoEncoderConfig.getTextureWidth();
    }

    public int getVideoBitRate() {
        return this.mVideoEncoderConfig.getBitRate();
    }

    public int getWidth() {
        return this.mVideoEncoderConfig.getWidth();
    }

    public int getZoomMode() {
        return this.mVideoEncoderConfig.getZoomMode();
    }

    public void setHeight(int height) {
        this.mVideoEncoderConfig.setHeight(height);
    }

    public void setTextureHeight(int texHeight) {
        this.mVideoEncoderConfig.setTextureHeight(texHeight);
    }

    public void setTextureWidth(int texWidth) {
        this.mVideoEncoderConfig.setTextureWidth(texWidth);
    }

    public void setWidth(int width) {
        this.mVideoEncoderConfig.setWidth(width);
    }

    public AVRecorderConfig(AudioEncorderConfig audio, VideoEncoderConfig video, boolean rotationClip, String file, RecordListener listener) throws IOException {
        this.mAudioEncorderConfig = audio;
        this.mVideoEncoderConfig = video;
        this.mRotationClip = rotationClip;
        File file2 = new File(file);
        this.mOutputFile = file2;
        Muxer muxer = new Muxer(file2.toString(), 0);
        this.mMuxer = muxer;
        muxer.setListener(listener);
    }
}
