package q1;

import android.os.SystemClock;
import androidx.work.PeriodicWorkRequest;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f51969a;

    /* renamed from: b, reason: collision with root package name */
    private final long f51970b = SystemClock.elapsedRealtime();

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f51969a;
    }

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f51969a = future;
    }

    public boolean b() {
        if (SystemClock.elapsedRealtime() - this.f51970b <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            return true;
        }
        return false;
    }
}
