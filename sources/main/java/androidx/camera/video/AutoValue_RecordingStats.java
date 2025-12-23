package androidx.camera.video;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_RecordingStats extends RecordingStats {
    private final AudioStats audioStats;
    private final long numBytesRecorded;
    private final long recordedDurationNanos;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RecordingStats) {
            RecordingStats recordingStats = (RecordingStats) obj;
            if (this.recordedDurationNanos == recordingStats.getRecordedDurationNanos() && this.numBytesRecorded == recordingStats.getNumBytesRecorded() && this.audioStats.equals(recordingStats.getAudioStats())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.RecordingStats
    @NonNull
    public AudioStats getAudioStats() {
        return this.audioStats;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getNumBytesRecorded() {
        return this.numBytesRecorded;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getRecordedDurationNanos() {
        return this.recordedDurationNanos;
    }

    public int hashCode() {
        long j6 = this.recordedDurationNanos;
        int i6 = (((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003;
        long j7 = this.numBytesRecorded;
        return this.audioStats.hashCode() ^ ((i6 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.recordedDurationNanos + ", numBytesRecorded=" + this.numBytesRecorded + ", audioStats=" + this.audioStats + "}";
    }

    AutoValue_RecordingStats(long j6, long j7, AudioStats audioStats) {
        this.recordedDurationNanos = j6;
        this.numBytesRecorded = j7;
        if (audioStats != null) {
            this.audioStats = audioStats;
            return;
        }
        throw new NullPointerException("Null audioStats");
    }
}
