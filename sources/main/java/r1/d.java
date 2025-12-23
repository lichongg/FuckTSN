package r1;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f51984a = new ConcurrentHashMap(16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f51985a;

        /* renamed from: b, reason: collision with root package name */
        private final long f51986b;

        public a(long j6, long j7) {
            this.f51985a = j6;
            this.f51986b = j7;
        }

        public boolean a() {
            if (SystemClock.elapsedRealtime() - this.f51986b <= this.f51985a) {
                return true;
            }
            return false;
        }
    }

    public static a a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of get is before: ");
        Map<String, a> map = f51984a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    public static void b(String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of put is before: ");
        Map<String, a> map = f51984a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + map.size());
    }
}
