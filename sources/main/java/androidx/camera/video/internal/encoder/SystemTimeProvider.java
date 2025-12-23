package androidx.camera.video.internal.encoder;

import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class SystemTimeProvider implements TimeProvider {
    @Override // androidx.camera.video.internal.encoder.TimeProvider
    public long realtimeUs() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    @Override // androidx.camera.video.internal.encoder.TimeProvider
    public long uptimeUs() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
    }
}
