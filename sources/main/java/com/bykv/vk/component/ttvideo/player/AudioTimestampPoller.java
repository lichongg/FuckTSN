package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.bykv.vk.component.ttvideo.utils.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\Downloads\app\classes3.dex */
final class AudioTimestampPoller {
    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 5000;
    private static final int INITIALIZING_DURATION_US = 500000;
    public static final int POSITION_UNSET = -1;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    public static final long TIME_UNSET = -9223372036854775807L;
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    @TargetApi(19)
    private static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp = new AudioTimestamp();
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }

        public long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000;
        }

        public boolean maybeUpdateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j6 = this.audioTimestamp.framePosition;
                if (this.lastTimestampRawPositionFrames > j6) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastTimestampRawPositionFrames = j6;
                this.lastTimestampPositionFrames = j6 + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }

        public AudioTimestampV19(AudioTrack audioTrack) {
            this.audioTrack = audioTrack;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public void rejectTimestamp() {
        updateState(4);
    }

    private void updateState(int i6) {
        this.state = i6;
        if (i6 == 0) {
            this.lastTimestampSampleTimeUs = 0L;
            this.initialTimestampPositionFrames = -1L;
            this.initializeSystemTimeUs = System.nanoTime() / 1000;
            this.sampleIntervalUs = 5000L;
            return;
        }
        if (i6 == 1) {
            this.sampleIntervalUs = 5000L;
            return;
        }
        if (i6 == 2 || i6 == 3) {
            this.sampleIntervalUs = 10000000L;
        } else {
            if (i6 != 4) {
                throw new IllegalStateException();
            }
            this.sampleIntervalUs = 500000L;
        }
    }

    public void acceptTimestamp() {
        if (this.state == 4) {
            reset();
        }
    }

    public long getTimestampPositionFrames() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampPositionFrames();
        }
        return -1L;
    }

    public long getTimestampSystemTimeUs() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampSystemTimeUs();
        }
        return -9223372036854775807L;
    }

    public boolean hasTimestamp() {
        int i6 = this.state;
        return i6 == 1 || i6 == 2;
    }

    public boolean isTimestampAdvancing() {
        return this.state == 2;
    }

    public boolean maybePollTimestamp(long j6) {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 == null || j6 - this.lastTimestampSampleTimeUs < this.sampleIntervalUs) {
            return false;
        }
        this.lastTimestampSampleTimeUs = j6;
        boolean maybeUpdateTimestamp = audioTimestampV19.maybeUpdateTimestamp();
        int i6 = this.state;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (maybeUpdateTimestamp) {
                        reset();
                        return maybeUpdateTimestamp;
                    }
                } else if (!maybeUpdateTimestamp) {
                    reset();
                    return maybeUpdateTimestamp;
                }
            } else {
                if (!maybeUpdateTimestamp) {
                    reset();
                    return maybeUpdateTimestamp;
                }
                if (this.audioTimestamp.getTimestampPositionFrames() > this.initialTimestampPositionFrames) {
                    updateState(2);
                    return maybeUpdateTimestamp;
                }
            }
        } else {
            if (maybeUpdateTimestamp) {
                if (this.audioTimestamp.getTimestampSystemTimeUs() < this.initializeSystemTimeUs) {
                    return false;
                }
                this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
                updateState(1);
                return maybeUpdateTimestamp;
            }
            if (j6 - this.initializeSystemTimeUs > 500000) {
                updateState(3);
            }
        }
        return maybeUpdateTimestamp;
    }

    public void reset() {
        if (this.audioTimestamp != null) {
            updateState(0);
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.audioTimestamp = new AudioTimestampV19(audioTrack);
            reset();
        } else {
            this.audioTimestamp = null;
            updateState(3);
        }
    }
}
