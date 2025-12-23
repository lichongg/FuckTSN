package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageCaptureLatencyEstimate {
    public static final long UNDEFINED_CAPTURE_LATENCY = -1;

    @NonNull
    public static final ImageCaptureLatencyEstimate UNDEFINED_IMAGE_CAPTURE_LATENCY = new ImageCaptureLatencyEstimate(-1, -1);
    public static final long UNDEFINED_PROCESSING_LATENCY = -1;
    public final long captureLatencyMillis;
    public final long processingLatencyMillis;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageCaptureLatencyEstimate)) {
            return false;
        }
        ImageCaptureLatencyEstimate imageCaptureLatencyEstimate = (ImageCaptureLatencyEstimate) obj;
        return this.captureLatencyMillis == imageCaptureLatencyEstimate.captureLatencyMillis && this.processingLatencyMillis == imageCaptureLatencyEstimate.processingLatencyMillis;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.captureLatencyMillis), Long.valueOf(this.processingLatencyMillis));
    }

    @NonNull
    public String toString() {
        return "captureLatencyMillis=" + this.captureLatencyMillis + ", processingLatencyMillis=" + this.processingLatencyMillis;
    }

    ImageCaptureLatencyEstimate(long j6, long j7) {
        this.captureLatencyMillis = j6;
        this.processingLatencyMillis = j7;
    }
}
