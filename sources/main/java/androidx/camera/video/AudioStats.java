package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AudioStats {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final double AUDIO_AMPLITUDE_NONE = 0.0d;
    public static final int AUDIO_STATE_ACTIVE = 0;
    public static final int AUDIO_STATE_DISABLED = 1;
    public static final int AUDIO_STATE_ENCODER_ERROR = 3;
    public static final int AUDIO_STATE_MUTED = 5;
    public static final int AUDIO_STATE_SOURCE_ERROR = 4;
    public static final int AUDIO_STATE_SOURCE_SILENCED = 2;
    private static final Set<Integer> ERROR_STATES = Collections.unmodifiableSet(new HashSet(Arrays.asList(2, 3, 4)));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface AudioState {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    abstract double getAudioAmplitudeInternal();

    public abstract int getAudioState();

    @Nullable
    public abstract Throwable getErrorCause();

    @NonNull
    static AudioStats of(int i6, @Nullable Throwable th, double d6) {
        return new AutoValue_AudioStats(i6, d6, th);
    }

    public boolean hasError() {
        return ERROR_STATES.contains(Integer.valueOf(getAudioState()));
    }

    AudioStats() {
    }

    @OptIn(markerClass = {ExperimentalAudioApi.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public double getAudioAmplitude() {
        if (getAudioState() == 1) {
            return 0.0d;
        }
        return getAudioAmplitudeInternal();
    }

    public boolean hasAudio() {
        if (getAudioState() == 0) {
            return true;
        }
        return false;
    }
}
