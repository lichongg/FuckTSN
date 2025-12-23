package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes.dex */
final class TraceApi29Impl {
    public static void setCounter(@NonNull String str, int i6) {
        android.os.Trace.setCounter(str, i6);
    }

    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i6) {
        android.os.Trace.beginAsyncSection(str, i6);
    }

    public static void endAsyncSection(@NonNull String str, int i6) {
        android.os.Trace.endAsyncSection(str, i6);
    }
}
