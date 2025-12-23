package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RecordingStats {
    @NonNull
    static RecordingStats of(long j6, long j7, @NonNull AudioStats audioStats) {
        Preconditions.checkArgument(j6 >= 0, "duration must be positive value.");
        Preconditions.checkArgument(j7 >= 0, "bytes must be positive value.");
        return new AutoValue_RecordingStats(j6, j7, audioStats);
    }

    @NonNull
    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();

    RecordingStats() {
    }
}
