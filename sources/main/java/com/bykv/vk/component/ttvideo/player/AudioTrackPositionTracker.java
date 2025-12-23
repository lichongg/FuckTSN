package com.bykv.vk.component.ttvideo.player;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.bykv.vk.component.ttvideo.utils.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j6);

        void onPositionFramesMismatch(long j6, long j7, long j8, long j9);

        void onSystemTimeUsMismatch(long j6, long j7, long j8, long j9);

        void onUnderrun(int i6, long j6);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    private @interface PlayState {
    }

    public static boolean isEncodingLinearPcm(int i6) {
        return i6 == 3 || i6 == 2 || i6 == Integer.MIN_VALUE || i6 == 1073741824 || i6 == 4;
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && this.audioTrack.getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private long getPlaybackHeadPosition() {
        AudioTrack audioTrack = this.audioTrack;
        if (this.stopTimestampUs != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.outputSampleRate) / C.MICROS_PER_SECOND));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    private void maybePollAndCheckTimestamp(long j6, long j7) {
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller.maybePollTimestamp(j6)) {
            long timestampSystemTimeUs = audioTimestampPoller.getTimestampSystemTimeUs();
            long timestampPositionFrames = audioTimestampPoller.getTimestampPositionFrames();
            if (Math.abs(timestampSystemTimeUs - j6) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j6, j7);
                audioTimestampPoller.rejectTimestamp();
            } else if (Math.abs(framesToDurationUs(timestampPositionFrames) - j7) <= 5000000) {
                audioTimestampPoller.acceptTimestamp();
            } else {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j6, j7);
                audioTimestampPoller.rejectTimestamp();
            }
        }
    }

    private void maybeUpdateLatency(long j6) {
        Method method;
        if (!this.isOutputPcm || (method = this.getLatencyMethod) == null || j6 - this.lastLatencySampleTimeUs < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) method.invoke(this.audioTrack, null)).intValue() * 1000) - this.bufferSizeUs;
            this.latencyUs = intValue;
            long max = Math.max(intValue, 0L);
            this.latencyUs = max;
            if (max > 5000000) {
                this.listener.onInvalidLatency(max);
                this.latencyUs = 0L;
            }
        } catch (Exception unused) {
            this.getLatencyMethod = null;
        }
        this.lastLatencySampleTimeUs = j6;
    }

    private static boolean needsPassthroughWorkarounds(int i6) {
        if (Util.SDK_INT < 23) {
            return i6 == 5 || i6 == 6;
        }
        return false;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
    }

    public long getCurrentPositionUs(boolean z5) {
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller.hasTimestamp()) {
            long framesToDurationUs = framesToDurationUs(audioTimestampPoller.getTimestampPositionFrames());
            return !audioTimestampPoller.isTimestampAdvancing() ? framesToDurationUs : framesToDurationUs + (nanoTime - audioTimestampPoller.getTimestampSystemTimeUs());
        }
        long playbackHeadPositionUs = this.playheadOffsetCount == 0 ? getPlaybackHeadPositionUs() : nanoTime + this.smoothedPlayheadOffsetUs;
        return !z5 ? playbackHeadPositionUs - this.latencyUs : playbackHeadPositionUs;
    }

    public boolean isPlaying() {
        return this.audioTrack.getPlayState() == 3;
    }

    public boolean isStalled(long j6) {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && j6 > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    public boolean mayHandleBuffer(long j6) {
        Listener listener;
        int playState = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            }
            if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z5 = this.hasData;
        boolean hasPendingData = hasPendingData(j6);
        this.hasData = hasPendingData;
        if (z5 && !hasPendingData && playState != 1 && (listener = this.listener) != null) {
            listener.onUnderrun(this.bufferSize, this.bufferSizeUs / 1000);
        }
        return true;
    }

    public void setAudioTrack(AudioTrack audioTrack, int i6, int i7, int i8) {
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = i7;
        this.bufferSize = i8;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack);
        this.outputSampleRate = audioTrack.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(i6);
        boolean isEncodingLinearPcm = isEncodingLinearPcm(i6);
        this.isOutputPcm = isEncodingLinearPcm;
        this.bufferSizeUs = isEncodingLinearPcm ? framesToDurationUs(i8 / i7) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0L;
    }

    public void start() {
        this.audioTimestampPoller.reset();
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.listener = listener;
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    private long framesToDurationUs(long j6) {
        return (j6 * C.MICROS_PER_SECOND) / this.outputSampleRate;
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long[] jArr = this.playheadOffsets;
                int i6 = this.nextPlayheadOffsetIndex;
                jArr[i6] = playbackHeadPositionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (i6 + 1) % 10;
                int i7 = this.playheadOffsetCount;
                if (i7 < 10) {
                    this.playheadOffsetCount = i7 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0L;
                int i8 = 0;
                while (true) {
                    int i9 = this.playheadOffsetCount;
                    if (i8 >= i9) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i8] / i9;
                    i8++;
                }
            }
            if (this.needsPassthroughWorkarounds) {
                return;
            }
            maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
            maybeUpdateLatency(nanoTime);
        }
    }

    public int getAvailableBufferSize(long j6) {
        return this.bufferSize - ((int) (j6 - (getPlaybackHeadPosition() * this.outputPcmFrameSize)));
    }

    public void handleEndOfStream(long j6) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j6;
    }

    public boolean hasPendingData(long j6) {
        if (j6 <= getPlaybackHeadPosition() && !forceHasPendingData()) {
            return false;
        }
        return true;
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs == -9223372036854775807L) {
            this.audioTimestampPoller.reset();
            return true;
        }
        return false;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }
}
