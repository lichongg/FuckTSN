package androidx.camera.video;

import android.net.Uri;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_OutputResults extends OutputResults {
    private final Uri outputUri;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OutputResults) {
            return this.outputUri.equals(((OutputResults) obj).getOutputUri());
        }
        return false;
    }

    @Override // androidx.camera.video.OutputResults
    @NonNull
    public Uri getOutputUri() {
        return this.outputUri;
    }

    public int hashCode() {
        return this.outputUri.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.outputUri + "}";
    }

    AutoValue_OutputResults(Uri uri) {
        if (uri != null) {
            this.outputUri = uri;
            return;
        }
        throw new NullPointerException("Null outputUri");
    }
}
