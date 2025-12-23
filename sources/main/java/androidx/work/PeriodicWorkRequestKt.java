package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j6, TimeUnit repeatIntervalTimeUnit) {
        g0.p(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        g0.y(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j6, repeatIntervalTimeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval) {
        g0.p(repeatInterval, "repeatInterval");
        g0.y(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, repeatInterval);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j6, TimeUnit repeatIntervalTimeUnit, long j7, TimeUnit flexTimeIntervalUnit) {
        g0.p(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        g0.p(flexTimeIntervalUnit, "flexTimeIntervalUnit");
        g0.y(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, j6, repeatIntervalTimeUnit, j7, flexTimeIntervalUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval, Duration flexTimeInterval) {
        g0.p(repeatInterval, "repeatInterval");
        g0.p(flexTimeInterval, "flexTimeInterval");
        g0.y(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, repeatInterval, flexTimeInterval);
    }
}
