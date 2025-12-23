package androidx.camera.video;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final double audioAmplitudeInternal;
    private final int audioState;
    private final Throwable errorCause;

    public boolean equals(Object obj) {
        Throwable th;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioStats) {
            AudioStats audioStats = (AudioStats) obj;
            if (this.audioState == audioStats.getAudioState() && Double.doubleToLongBits(this.audioAmplitudeInternal) == Double.doubleToLongBits(audioStats.getAudioAmplitudeInternal()) && ((th = this.errorCause) != null ? th.equals(audioStats.getErrorCause()) : audioStats.getErrorCause() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.AudioStats
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    double getAudioAmplitudeInternal() {
        return this.audioAmplitudeInternal;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    @Nullable
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public int hashCode() {
        int doubleToLongBits = (((this.audioState ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.audioAmplitudeInternal) >>> 32) ^ Double.doubleToLongBits(this.audioAmplitudeInternal)))) * 1000003;
        Throwable th = this.errorCause;
        return doubleToLongBits ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", audioAmplitudeInternal=" + this.audioAmplitudeInternal + ", errorCause=" + this.errorCause + "}";
    }

    AutoValue_AudioStats(int i6, double d6, @Nullable Throwable th) {
        this.audioState = i6;
        this.audioAmplitudeInternal = d6;
        this.errorCause = th;
    }
}
