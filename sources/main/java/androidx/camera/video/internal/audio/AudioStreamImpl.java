package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AudioStreamImpl implements AudioStream {
    private static final String TAG = "AudioStreamImpl";
    final AudioRecord mAudioRecord;

    @Nullable
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;

    @Nullable
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBufferSize;
    private final int mBytesPerFrame;

    @Nullable
    private Executor mCallbackExecutor;
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicReference<Boolean> mNotifiedSilenceState = new AtomicReference<>(null);
    private final AudioSettings mSettings;
    private long mTotalFramesRead;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    class AudioRecordingApi29Callback extends AudioManager.AudioRecordingCallback {
        AudioRecordingApi29Callback() {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            Iterator<AudioRecordingConfiguration> it = list.iterator();
            while (it.hasNext()) {
                AudioRecordingConfiguration a6 = q.a(it.next());
                if (Api24Impl.getClientAudioSessionId(a6) == AudioStreamImpl.this.mAudioRecord.getAudioSessionId()) {
                    AudioStreamImpl.this.notifySilenced(Api29Impl.isClientSilenced(a6));
                    return;
                }
            }
        }
    }

    public static boolean isSettingsSupported(int i6, int i7, int i8) {
        return i6 > 0 && i7 > 0 && getMinBufferSize(i6, i7, i8) > 0;
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private static long computeInterpolatedTimeNs(int i6, long j6, @NonNull AudioTimestamp audioTimestamp) {
        long frameCountToDurationNs = audioTimestamp.nanoTime + AudioUtils.frameCountToDurationNs(j6 - audioTimestamp.framePosition, i6);
        if (frameCountToDurationNs < 0) {
            return 0L;
        }
        return frameCountToDurationNs;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long generatePresentationTimeNs() {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            r2 = -1
            if (r0 < r1) goto L30
            boolean r0 = hasAudioTimestampQuirk()
            if (r0 != 0) goto L30
            android.media.AudioTimestamp r0 = new android.media.AudioTimestamp
            r0.<init>()
            android.media.AudioRecord r1 = r6.mAudioRecord
            r4 = 0
            int r1 = androidx.camera.video.internal.compat.Api24Impl.getTimestamp(r1, r0, r4)
            if (r1 != 0) goto L29
            androidx.camera.video.internal.audio.AudioSettings r1 = r6.mSettings
            int r1 = r1.getSampleRate()
            long r4 = r6.mTotalFramesRead
            long r0 = computeInterpolatedTimeNs(r1, r4, r0)
            goto L31
        L29:
            java.lang.String r0 = "AudioStreamImpl"
            java.lang.String r1 = "Unable to get audio timestamp"
            androidx.camera.core.Logger.w(r0, r1)
        L30:
            r0 = r2
        L31:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L39
            long r0 = java.lang.System.nanoTime()
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.audio.AudioStreamImpl.generatePresentationTimeNs():long");
    }

    private static boolean hasAudioTimestampQuirk() {
        return DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) != null;
    }

    void notifySilenced(final boolean z5) {
        Executor executor = this.mCallbackExecutor;
        final AudioStream.AudioStreamCallback audioStreamCallback = this.mAudioStreamCallback;
        if (executor == null || audioStreamCallback == null || Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z5)), Boolean.valueOf(z5))) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.p
            @Override // java.lang.Runnable
            public final void run() {
                AudioStream.AudioStreamCallback.this.onSilenceStateChanged(z5);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        if (this.mIsReleased.getAndSet(true)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && (audioRecordingCallback = this.mAudioRecordingCallback) != null) {
            Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioRecordingCallback);
        }
        this.mAudioRecord.release();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(@Nullable AudioStream.AudioStreamCallback audioStreamCallback, @Nullable Executor executor) {
        boolean z5 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = audioStreamCallback;
        this.mCallbackExecutor = executor;
        if (Build.VERSION.SDK_INT >= 29) {
            AudioManager.AudioRecordingCallback audioRecordingCallback = this.mAudioRecordingCallback;
            if (audioRecordingCallback != null) {
                Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioRecordingCallback);
            }
            if (audioStreamCallback == null) {
                return;
            }
            if (this.mAudioRecordingCallback == null) {
                this.mAudioRecordingCallback = new AudioRecordingApi29Callback();
            }
            Api29Impl.registerAudioRecordingCallback(this.mAudioRecord, executor, this.mAudioRecordingCallback);
        }
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public AudioStreamImpl(@NonNull AudioSettings audioSettings, @Nullable Context context) throws IllegalArgumentException, AudioStream.AudioStreamException {
        if (isSettingsSupported(audioSettings.getSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat())) {
            this.mSettings = audioSettings;
            this.mBytesPerFrame = audioSettings.getBytesPerFrame();
            int minBufferSize = getMinBufferSize(audioSettings.getSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat());
            Preconditions.checkState(minBufferSize > 0);
            int i6 = minBufferSize * 2;
            this.mBufferSize = i6;
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 23) {
                AudioFormat build = new AudioFormat.Builder().setSampleRate(audioSettings.getSampleRate()).setChannelMask(AudioUtils.channelCountToChannelMask(audioSettings.getChannelCount())).setEncoding(audioSettings.getAudioFormat()).build();
                AudioRecord.Builder createAudioRecordBuilder = Api23Impl.createAudioRecordBuilder();
                if (i7 >= 31 && context != null) {
                    Api31Impl.setContext(createAudioRecordBuilder, context);
                }
                Api23Impl.setAudioSource(createAudioRecordBuilder, audioSettings.getAudioSource());
                Api23Impl.setAudioFormat(createAudioRecordBuilder, build);
                Api23Impl.setBufferSizeInBytes(createAudioRecordBuilder, i6);
                this.mAudioRecord = Api23Impl.build(createAudioRecordBuilder);
            } else {
                this.mAudioRecord = new AudioRecord(audioSettings.getAudioSource(), audioSettings.getSampleRate(), AudioUtils.channelCountToChannelConfig(audioSettings.getChannelCount()), audioSettings.getAudioFormat(), i6);
            }
            if (this.mAudioRecord.getState() == 1) {
                return;
            }
            this.mAudioRecord.release();
            throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
        }
        throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", Integer.valueOf(audioSettings.getSampleRate()), Integer.valueOf(audioSettings.getChannelCount()), Integer.valueOf(audioSettings.getAudioFormat())));
    }

    private static int getMinBufferSize(int i6, int i7, int i8) {
        return AudioRecord.getMinBufferSize(i6, AudioUtils.channelCountToChannelConfig(i7), i8);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    @NonNull
    public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
        long j6;
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        int read = this.mAudioRecord.read(byteBuffer, this.mBufferSize);
        if (read > 0) {
            byteBuffer.limit(read);
            j6 = generatePresentationTimeNs();
            this.mTotalFramesRead += AudioUtils.sizeToFrameCount(read, this.mBytesPerFrame);
        } else {
            j6 = 0;
        }
        return AudioStream.PacketInfo.of(read, j6);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        checkNotReleasedOrThrow();
        boolean z5 = true;
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        this.mAudioRecord.startRecording();
        boolean z6 = false;
        if (this.mAudioRecord.getRecordingState() == 3) {
            this.mTotalFramesRead = 0L;
            this.mNotifiedSilenceState.set(null);
            if (Build.VERSION.SDK_INT >= 29) {
                AudioRecordingConfiguration activeRecordingConfiguration = Api29Impl.getActiveRecordingConfiguration(this.mAudioRecord);
                if (activeRecordingConfiguration == null || !Api29Impl.isClientSilenced(activeRecordingConfiguration)) {
                    z5 = false;
                }
                z6 = z5;
            }
            notifySilenced(z6);
            return;
        }
        this.mIsStarted.set(false);
        throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false)) {
            this.mAudioRecord.stop();
            if (this.mAudioRecord.getRecordingState() != 1) {
                Logger.w(TAG, "Failed to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
            }
        }
    }
}
