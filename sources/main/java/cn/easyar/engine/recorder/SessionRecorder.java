package cn.easyar.engine.recorder;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.CamcorderProfile;
import android.os.Build;
import android.os.Handler;
import cn.easyar.engine.EasyAR;
import cn.easyar.engine.PermissionFragment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SessionRecorder {
    private static String TAG = "EasyAR";
    static VideoSize systemQuality;
    int audioBitrate;
    int audioChannelCount;
    int audioSampleRate;
    boolean configUpdated = false;
    String file;
    int height;
    private AVRecorderConfig mAVRecorderConfig;
    Handler mHandler;
    private RecordListener mListener;
    private MicroPhoneEncoder mMicroPhoneEncoder;
    private TextureMovieEncoder mTexture2Video;
    int mode;
    private long nativeId;
    boolean rotationClip;
    int texId;
    int tex_height;
    int tex_width;
    int videoBitrate;
    int width;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum VideoSize {
        Vid480p(1),
        Vid720p(2),
        Vid1080p(4);

        private int quality;

        void custom(int flag) {
            this.quality = flag;
        }

        boolean has(int flag) {
            return (flag & this.quality) != 0;
        }

        int value() {
            return this.quality;
        }

        VideoSize(int flag) {
            this.quality = flag;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onPermissionCallback(long instanceId, int status, String value);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onStatusNotify(int status, String value);

    boolean envSetup() {
        return true;
    }

    public void releaseRecording() {
        this.mTexture2Video = null;
        this.mMicroPhoneEncoder = null;
        this.mAVRecorderConfig = null;
        this.mListener.onMessage(8, "");
    }

    static {
        VideoSize videoSize = VideoSize.Vid720p;
        systemQuality = videoSize;
        int value = CamcorderProfile.hasProfile(4) ? systemQuality.value() | VideoSize.Vid480p.value() : 0;
        if (CamcorderProfile.hasProfile(5)) {
            value = systemQuality.value() | videoSize.value();
        }
        if (CamcorderProfile.hasProfile(6)) {
            value = VideoSize.Vid1080p.value() | systemQuality.value();
        }
        systemQuality.custom(value);
    }

    public static void requestPermissions(long instanceId) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            onPermissionCallback(instanceId, 0, "");
            return;
        }
        Activity activity = EasyAR.getInitializeActivity().get();
        if (activity == null) {
            onPermissionCallback(instanceId, 2, "ContextMiss");
            return;
        }
        ArrayList arrayList = new ArrayList();
        checkSelfPermission = activity.checkSelfPermission("android.permission.RECORD_AUDIO");
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (arrayList.size() == 0) {
            onPermissionCallback(instanceId, 0, "");
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        PermissionFragment newInstance = PermissionFragment.newInstance(instanceId, (String[]) arrayList.toArray(new String[0]), new PermissionFragment.PermissionCallback() { // from class: cn.easyar.engine.recorder.SessionRecorder.1
            @Override // cn.easyar.engine.PermissionFragment.PermissionCallback
            public void invoke(long instanceId2, int status, String msg) {
                SessionRecorder.onPermissionCallback(instanceId2, status, msg);
            }
        }, fragmentManager);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(0, newInstance);
        beginTransaction.commit();
    }

    boolean compatibleValidation() {
        int i6 = this.width;
        if (i6 == 1280 && this.height == 720) {
            if (systemQuality.has(VideoSize.Vid720p.value())) {
                return true;
            }
            if (!systemQuality.has(VideoSize.Vid480p.value())) {
                this.mListener.onMessage(2048, "config_size: failed");
                return false;
            }
            this.width = PredefinedCaptureConfigurations.f35647n;
            this.height = 480;
            this.mListener.onMessage(2049, "480P");
            return true;
        }
        if (i6 != 1920 || this.height != 1080) {
            if (i6 != 720 || this.height != 480 || systemQuality.has(VideoSize.Vid480p.value())) {
                return true;
            }
            if (!systemQuality.has(VideoSize.Vid720p.value())) {
                this.mListener.onMessage(2048, "config_size: failed");
                return false;
            }
            this.width = PredefinedCaptureConfigurations.f35648o;
            this.height = PredefinedCaptureConfigurations.f35647n;
            this.mListener.onMessage(2049, "720P");
            return true;
        }
        if (systemQuality.has(VideoSize.Vid1080p.value())) {
            return true;
        }
        if (systemQuality.has(VideoSize.Vid720p.value())) {
            this.width = PredefinedCaptureConfigurations.f35648o;
            this.height = PredefinedCaptureConfigurations.f35647n;
            this.mListener.onMessage(2049, "720P");
            return true;
        }
        if (!systemQuality.has(VideoSize.Vid480p.value())) {
            this.mListener.onMessage(2048, "config_size: failed");
            return false;
        }
        this.width = PredefinedCaptureConfigurations.f35647n;
        this.height = 480;
        this.mListener.onMessage(2049, "480P");
        return true;
    }

    public void prepare() {
        this.mListener = new RecordListener() { // from class: cn.easyar.engine.recorder.SessionRecorder.2
            private boolean waitForSuccess = true;
            private boolean resendOnStop = false;

            @Override // cn.easyar.engine.recorder.RecordListener
            public void onMessage(int status, String info) {
                synchronized (SessionRecorder.TAG) {
                    if ((status >= 512 && status < 4096) || status == 1024 || status == 1025) {
                        try {
                            this.waitForSuccess = false;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!this.waitForSuccess || status != 4) {
                        SessionRecorder.this.onStatusNotify(status, info);
                        if (this.resendOnStop && (status == 1024 || status == 1025)) {
                            SessionRecorder.this.onStatusNotify(4, "");
                            this.resendOnStop = false;
                        }
                        return;
                    }
                    this.resendOnStop = true;
                }
            }
        };
        if (!compatibleValidation()) {
            this.mListener.onMessage(513, "");
        } else if (!envSetup()) {
            this.mListener.onMessage(513, "");
        } else {
            prepareRecording();
            this.mListener.onMessage(1, "");
        }
    }

    public void prepareRecording() {
        try {
            AVRecorderConfig aVRecorderConfig = new AVRecorderConfig(new AudioEncorderConfig(this.audioBitrate, this.audioChannelCount, this.audioSampleRate), new VideoEncoderConfig(this.width, this.height, this.tex_width, this.tex_height, this.videoBitrate, this.mode), this.rotationClip, this.file, this.mListener);
            this.mAVRecorderConfig = aVRecorderConfig;
            try {
                this.mMicroPhoneEncoder = new MicroPhoneEncoder(aVRecorderConfig);
                try {
                    this.mTexture2Video = new TextureMovieEncoder(this.mAVRecorderConfig);
                } catch (RuntimeException unused) {
                    this.mAVRecorderConfig = null;
                    this.mMicroPhoneEncoder.releaseRecording();
                    this.mMicroPhoneEncoder = null;
                    this.mListener.onMessage(513, "");
                }
            } catch (Exception unused2) {
                this.mAVRecorderConfig = null;
                this.mListener.onMessage(513, "");
            }
        } catch (IOException unused3) {
            this.mListener.onMessage(513, "");
        }
    }

    public void setAudioBitrate(int bitrate) {
        this.audioBitrate = bitrate;
    }

    public void setAudioSampleRate(int samplerate) {
        this.audioSampleRate = samplerate;
    }

    public void setCachedFile(String file) {
        this.file = file;
    }

    public void setChannelCount(int count) {
        this.audioChannelCount = count;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRectRotationClip(boolean rotationClip) {
        this.rotationClip = rotationClip;
    }

    public void setTexture(int texture, int tex_width, int tex_height) {
        if (this.texId != texture || this.tex_width != tex_width || this.tex_height != tex_height) {
            this.configUpdated = true;
        }
        this.texId = texture;
        this.tex_width = tex_width;
        this.tex_height = tex_height;
    }

    public void setVideoBitrate(int bitrate) {
        this.videoBitrate = bitrate;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setZoomMode(int mode) {
        this.mode = mode;
    }

    public void startRecording() {
        this.mTexture2Video.startRecording();
        try {
            this.mMicroPhoneEncoder.startRecording();
            this.mListener.onMessage(2, "");
            this.configUpdated = false;
        } catch (IllegalStateException unused) {
            this.mTexture2Video.stopRecording(null, null);
            this.mListener.onMessage(514, "startRecording failed due to illegal state");
        }
    }

    public void stopRecording() {
        this.mMicroPhoneEncoder.stopRecording();
        this.mTexture2Video.stopRecording(null, null);
        this.mListener.onMessage(4, "");
    }

    public void updateFrame() {
        updateRecording(this.texId, this.tex_width, this.tex_height);
    }

    public void updateRecording(int texId, int width, int height) {
        if (!this.configUpdated) {
            this.mTexture2Video.updateRecording(texId);
            return;
        }
        this.mAVRecorderConfig.setTextureHeight(height);
        this.mAVRecorderConfig.setTextureWidth(width);
        this.mTexture2Video.updateRecording(texId, this.tex_width, this.tex_height);
        this.configUpdated = false;
    }

    public void release() {
        releaseRecording();
    }

    public void start() {
        startRecording();
    }

    public void stop() {
        stopRecording();
    }
}
