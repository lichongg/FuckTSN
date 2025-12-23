package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.utils.AVLogger;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Locale;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class AJVoice implements AudioTrack.OnPlaybackPositionUpdateListener {
    private static final int DISCONTINGUNITY_MS = 200;
    private static final int ERROR_FORMAT_ILLEGAL = -12;
    private static final int ERROR_NULL_BUFFER = -10;
    private static final int ERROR_SIZE_ILLEGAL = -11;
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final int MAX_LATENCY_MS = 5000;
    private static final int MIN_LATENCY_CHECK_MS = 500;
    private static final int MS_UNIT = 1000;
    private static final long RELEASE_WORKAROUND_TIME_MS = 80;
    private static final int SDK_INT = Build.VERSION.SDK_INT;
    private static final int START_NO_SET = -1;
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "AJVoice";
    private static final long TIME_UNSET = -9223372036854775807L;
    private static final int kNoSettingVolume = -1;
    private static String mDeviceName;
    private static boolean mNeedReleaseWorkAround;
    private AudioTrackPositionTracker audioTrackPositionTracker;
    private byte[] mMinBytes;
    private ConditionVariable mReleasingConditionVariable;
    private AudioTrack mAudioTrack = null;
    private TTPlayer mPlayer = null;
    private int mBlockSize = 2048;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mSampleBytes = 2;
    private int mSampleFormat = 0;
    private int mFrameSamples = 0;
    private AudioManager mAudioManager = null;
    private int mChannelsLayout = 0;
    private int mAudioFormat = 2;
    private float mLeftVolume = -1.0f;
    private int mMaxVolume = 0;
    private volatile boolean mStoped = true;
    private int mSerial = -1;
    private Method getLatencyMethod = null;
    private int mTrackBufferSize = 0;
    private int mLatencyMs = 0;
    private int mBufferSizeMs = 0;
    private long mLastGetLatencyMs = 0;
    private long mWrittenPcmBytes = 0;
    private long lastRawPlaybackHeadPosition = 0;
    private long forceResetWorkaroundTimeMs = -9223372036854775807L;
    private long mStartTime = 0;
    private int mStreamType = 3;
    private int mEnableAudioTrackSmoothClock = 0;

    @Keep
    private long mNativeObject = 0;
    private int mStartMediaTimeMs = -1;

    public static int getPcmFrameSize(int i6, int i7) {
        if (i6 == 2) {
            return i7 * 2;
        }
        if (i6 == 3) {
            return i7;
        }
        throw new IllegalArgumentException();
    }

    @CalledByNative
    public int write(byte[] bArr, int i6, int i7, int i8) {
        if (bArr == null || bArr.length == 0) {
            AVLogger.e(TAG, "buffer is nullpoint");
            return -10;
        }
        int i9 = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != i8) {
            this.mSerial = i8;
            if (this.mWrittenPcmBytes > 0) {
                this.mAudioTrack.flush();
            }
        }
        try {
            int write = this.mAudioTrack.write(bArr, i6, i7);
            if (write >= 0) {
                this.mWrittenPcmBytes += write;
                if (needsReset() && reset() == 0) {
                    i9 = start();
                }
                return i9 == 0 ? write : i9;
            }
            vl.r(TAG, "write failed : ret: " + write + ", size = " + i7);
            return write;
        } catch (Exception e6) {
            vl.j(e6);
            return -1;
        }
    }

    private long getPlaybackHeadPosition() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
            if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
            }
            return this.lastRawPlaybackHeadPosition;
        }
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private long getWrittenDurationMs() {
        return ((this.mWrittenPcmBytes / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
    }

    private boolean needsReset() {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && this.mWrittenPcmBytes > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    private int reconfigure() {
        AudioManager audioManager = (AudioManager) this.mPlayer.getContext().getSystemService("audio");
        this.mAudioManager = audioManager;
        if (audioManager != null) {
            this.mMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
        }
        int audioTrackChannelConfig = getAudioTrackChannelConfig(this.mChannels);
        this.mChannelsLayout = audioTrackChannelConfig;
        if (audioTrackChannelConfig == 0) {
            AVLogger.k(TAG, String.format(Locale.US, "not supoort channel:%d", Integer.valueOf(this.mChannels)));
            return -1;
        }
        int i6 = this.mSampleBytes;
        if (i6 == 1) {
            this.mAudioFormat = 3;
        } else {
            if (i6 != 2) {
                return -12;
            }
            this.mAudioFormat = 2;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat);
        if (minBufferSize <= 0) {
            vl.r(TAG, "getMinBufferSize failed, trace: sampleRate = " + this.mSampleRate + ", mChannelsLayout = " + this.mChannelsLayout + ", mAudioFormat = " + this.mAudioFormat);
            return minBufferSize;
        }
        this.mTrackBufferSize = minBufferSize;
        try {
            this.mMinBytes = new byte[minBufferSize];
            this.mBufferSizeMs = ((minBufferSize / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
            try {
                AudioTrack audioTrack = new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, minBufferSize, 1);
                this.mAudioTrack = audioTrack;
                if (audioTrack.getState() == 1) {
                    return 0;
                }
                try {
                    this.mAudioTrack.release();
                } catch (Throwable unused) {
                }
                this.mAudioTrack = null;
                vl.r(TAG, "create audiotrack but failed to initialize");
                return -3;
            } catch (Throwable th) {
                vl.r(TAG, "create audio track failed ,detail = ".concat(String.valueOf(th)));
                return -1;
            }
        } catch (OutOfMemoryError unused2) {
            vl.r(TAG, "out of memory error when new audio buffer for audiotrack");
            return -10;
        }
    }

    private int reset() {
        this.mWrittenPcmBytes = 0L;
        this.mLatencyMs = 0;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mLeftVolume = -1.0f;
        AudioTrack audioTrack = this.mAudioTrack;
        this.mAudioTrack = null;
        try {
            audioTrack.flush();
            audioTrack.release();
            return reconfigure();
        } catch (Exception unused) {
            return reconfigure();
        } finally {
            reconfigure();
        }
    }

    @CalledByNative
    public void close() {
        final AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJVoice.1
                    @Override // java.lang.Runnable
                    public void run() {
                        vl.j(AJVoice.TAG, "start release task");
                        AJVoice.this.releaseTrack(audioTrack);
                    }
                });
            } catch (Throwable th) {
                vl.xt(TAG, "create close thread fail = ".concat(String.valueOf(th)));
                releaseTrack(audioTrack);
            }
        }
    }

    @CalledByNative
    public void flush() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.reset();
            }
            this.mStartMediaTimeMs = -1;
            this.mAudioTrack.flush();
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @CalledByNative
    public int getCurrentPositionMs() {
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        if (audioTrackPositionTracker != null) {
            return this.mStartMediaTimeMs + ((int) (audioTrackPositionTracker.getCurrentPositionUs(false) / 1000));
        }
        return 0;
    }

    @CalledByNative
    public int getMaxVolume() {
        vl.j("ttmn", "getMaxVolume:" + this.mMaxVolume);
        return this.mMaxVolume;
    }

    @CalledByNative
    public int getTrackBufferSize() {
        return this.mTrackBufferSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    @com.bykv.vk.component.ttvideo.player.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getVolume() {
        /*
            r4 = this;
            com.bykv.vk.component.ttvideo.player.TTPlayer r0 = r4.mPlayer
            r1 = 0
            if (r0 == 0) goto L23
            float r0 = r4.mLeftVolume
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L23
            android.media.AudioManager r0 = r4.mAudioManager
            if (r0 == 0) goto L23
            int r2 = r4.mStreamType     // Catch: java.lang.Exception -> L22
            int r0 = r0.getStreamMaxVolume(r2)     // Catch: java.lang.Exception -> L22
            android.media.AudioManager r2 = r4.mAudioManager     // Catch: java.lang.Exception -> L20
            int r3 = r4.mStreamType     // Catch: java.lang.Exception -> L20
            int r1 = r2.getStreamVolume(r3)     // Catch: java.lang.Exception -> L20
            goto L24
        L20:
            goto L24
        L22:
        L23:
            r0 = 0
        L24:
            if (r1 < 0) goto L28
            float r0 = (float) r1
            return r0
        L28:
            if (r0 <= 0) goto L2e
            int r0 = r0 / 4
            float r0 = (float) r0
            return r0
        L2e:
            r0 = 1092616192(0x41200000, float:10.0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJVoice.getVolume():float");
    }

    @CalledByNative
    public int open(long j6, TTPlayer tTPlayer) {
        this.mPlayer = tTPlayer;
        int reconfigure = reconfigure();
        if (reconfigure == 0) {
            float f6 = this.mLeftVolume;
            if (f6 != -1.0f) {
                setVolume(f6, f6);
            }
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return reconfigure;
    }

    @CalledByNative
    public void pause() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void releaseTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (mNeedReleaseWorkAround) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                if (elapsedRealtime <= RELEASE_WORKAROUND_TIME_MS) {
                    Thread.sleep(RELEASE_WORKAROUND_TIME_MS - elapsedRealtime);
                }
            }
        } catch (Exception unused) {
        }
        try {
            audioTrack.release();
        } catch (Exception e6) {
            vl.xt(TAG, "release in invalid state = ".concat(String.valueOf(e6)));
        }
    }

    @CalledByNative
    public void resume() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i6 = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i6, getPcmFrameSize(i6, this.mChannels), this.mTrackBufferSize);
                this.audioTrackPositionTracker.start();
            }
            this.mAudioTrack.play();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @CalledByNative
    public void setAudioTrackSmoothClock(int i6) {
        if (Util.SDK_INT >= 21) {
            this.mEnableAudioTrackSmoothClock = i6;
            if (i6 > 0) {
                this.audioTrackPositionTracker = new AudioTrackPositionTracker(null);
                this.mReleasingConditionVariable = new ConditionVariable(true);
            }
        }
    }

    @CalledByNative
    public void setSampleInfo(int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mSampleRate = i7;
        this.mChannels = i8;
        this.mBlockSize = i9;
        this.mSampleBytes = i11;
        this.mSampleFormat = i6;
        this.mFrameSamples = i10;
    }

    @CalledByNative
    public void setStreamType(int i6) {
        this.mStreamType = i6;
        if (this.mPlayer != null && reset() == 0) {
            start();
        }
    }

    @CalledByNative
    public void setTrackVolume(float f6, float f7) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.setStereoVolume(f6, f7);
        }
    }

    @CalledByNative
    public void setVolume(float f6, float f7) {
        AudioTrack audioTrack;
        try {
            int i6 = this.mMaxVolume;
            if (i6 < f6) {
                f6 = i6;
            }
            if (f7 != -1048575.0f || (audioTrack = this.mAudioTrack) == null) {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.setStreamVolume(this.mStreamType, (int) f6, 0);
                }
            } else {
                audioTrack.setStereoVolume(f6, f7);
            }
            this.mLeftVolume = f6;
        } catch (Exception unused) {
        }
    }

    @CalledByNative
    public int start() {
        if (this.mAudioTrack == null) {
            vl.r(TAG, "audiotrack start before created");
            return -2;
        }
        this.mStoped = false;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i6 = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i6, getPcmFrameSize(i6, this.mChannels), this.mTrackBufferSize);
            }
            this.mAudioTrack.play();
            this.mSerial = -1;
            if (mNeedReleaseWorkAround) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
            return 0;
        } catch (Throwable th) {
            vl.r(TAG, "audioTrack start failed = ".concat(String.valueOf(th)));
            return -3;
        }
    }

    @CalledByNative
    public void stop() {
        if (this.mStoped) {
            return;
        }
        this.mStoped = true;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @CalledByNative
    public AJVoice() {
        if (mDeviceName == null) {
            String str = Build.DEVICE;
            mDeviceName = str;
            if (str.equals("OnePlus6T")) {
                mNeedReleaseWorkAround = true;
            }
        }
    }

    public static int getAudioTrackChannelConfig(int i6) {
        switch (i6) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 0;
        }
    }

    private long getPlaybackBytes() {
        return getPlaybackHeadPosition() * getPcmFrameSize(this.mAudioFormat, this.mChannels);
    }

    private long getPlaybackPositionMs() {
        return (getPlaybackHeadPosition() * 1000) / this.mSampleRate;
    }

    @CalledByNative
    public int getEOSDelayMs() {
        long j6;
        long writtenDurationMs = getWrittenDurationMs();
        long playbackPositionMs = getPlaybackPositionMs();
        if (getLatency() > 0) {
            j6 = this.mLatencyMs - this.mBufferSizeMs;
        } else {
            j6 = 0;
        }
        return (int) ((writtenDurationMs - playbackPositionMs) + j6);
    }

    @CalledByNative
    public int getLatency() {
        getPlaybackHeadPosition();
        if (this.getLatencyMethod != null) {
            long nanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
            if (nanoTime - this.mLastGetLatencyMs > 500) {
                try {
                    int intValue = ((Integer) this.getLatencyMethod.invoke(this.mAudioTrack, null)).intValue();
                    this.mLatencyMs = intValue;
                    int max = Math.max(intValue, 0);
                    this.mLatencyMs = max;
                    if (max > 5000) {
                        vl.xt(TAG, "Ignoring impossibly large audio latency: " + this.mLatencyMs);
                        this.mLatencyMs = 0;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
                this.mLastGetLatencyMs = nanoTime;
            }
        }
        return this.mLatencyMs;
    }

    @CalledByNative
    public int write(byte[] bArr, int i6, int i7, int i8, long j6) {
        if (bArr != null && bArr.length != 0) {
            int i9 = 0;
            if (this.mStoped) {
                return 0;
            }
            if (this.mSerial != i8) {
                this.mSerial = i8;
                AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
                if (audioTrackPositionTracker == null || this.mReleasingConditionVariable == null) {
                    if (this.mWrittenPcmBytes > 0) {
                        this.mAudioTrack.flush();
                    }
                } else if (this.mWrittenPcmBytes > 0) {
                    if (audioTrackPositionTracker.isPlaying()) {
                        this.mAudioTrack.pause();
                    }
                    this.audioTrackPositionTracker.reset();
                    this.mStartMediaTimeMs = -1;
                    this.mReleasingConditionVariable.close();
                    this.mWrittenPcmBytes = 0L;
                    final AudioTrack audioTrack = this.mAudioTrack;
                    this.mAudioTrack = null;
                    AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJVoice.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String unused = AJVoice.TAG;
                                audioTrack.flush();
                                audioTrack.release();
                                String unused2 = AJVoice.TAG;
                            } finally {
                                AJVoice.this.mReleasingConditionVariable.open();
                            }
                        }
                    });
                    this.mReleasingConditionVariable.block();
                    reconfigure();
                    start();
                    this.mSerial = i8;
                }
            }
            int i10 = this.mStartMediaTimeMs;
            if (i10 == -1) {
                this.mStartMediaTimeMs = (int) Math.max(0L, j6);
            } else {
                long writtenDurationMs = i10 + getWrittenDurationMs();
                if (Math.abs(writtenDurationMs - j6) > FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
                    vl.r(TAG, "Discontinuity detected [expected " + writtenDurationMs + ", got " + j6 + "]");
                    this.mStartMediaTimeMs = (int) (((long) this.mStartMediaTimeMs) + (j6 - writtenDurationMs));
                }
            }
            try {
                int write = this.mAudioTrack.write(bArr, i6, i7);
                if (write < 0) {
                    vl.r(TAG, "write failed : ret: " + write + ", size = " + i7);
                    return write;
                }
                this.mWrittenPcmBytes += write;
                if (needsReset() && reset() == 0) {
                    i9 = start();
                    this.mSerial = i8;
                }
                return i9 == 0 ? write : i9;
            } catch (Exception e6) {
                vl.j(e6);
                return -1;
            }
        }
        AVLogger.e(TAG, "buffer is nullpoint");
        return -10;
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
    }

    @SuppressLint({"NewApi"})
    public int write(ByteBuffer byteBuffer, int i6) {
        if (byteBuffer == null) {
            AVLogger.e(TAG, "buffer is nullpoint");
            return -1;
        }
        if (this.mAudioTrack.write(byteBuffer, 0, byteBuffer.capacity()) != byteBuffer.capacity()) {
            return -1;
        }
        byteBuffer.flip();
        return 0;
    }
}
