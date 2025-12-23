package androidx.camera.video;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class OutputResults {
    @NonNull
    public abstract Uri getOutputUri();

    @NonNull
    static OutputResults of(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri, "OutputUri cannot be null.");
        return new AutoValue_OutputResults(uri);
    }
}
