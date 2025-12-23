package o1;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r1.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f50454e = "a";

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f50455f = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f50456a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private final c f50457b;

    /* renamed from: c, reason: collision with root package name */
    private final c f50458c;

    /* renamed from: d, reason: collision with root package name */
    private final g f50459d;

    private void f(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l6 = this.f50456a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l6)) {
            bVar.a(2);
            return;
        }
        if (e.b(l6, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)) {
            this.f50459d.h(new q1.c(grsBaseInfo, context), null, str, this.f50458c, -1);
        }
        bVar.a(1);
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f50455f;
        Map<String, Map<String, String>> map2 = map.get(grsParasKey);
        if (map2 != null && !map2.isEmpty()) {
            f(grsBaseInfo, bVar, context, str);
            return map2.get(str);
        }
        Logger.d(f50454e, "Cache size is: " + map.size());
        return new HashMap();
    }

    public void c(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f50457b.f(grsParasKey + "time", "0");
        this.f50456a.remove(grsParasKey + "time");
        Map<String, Map<String, Map<String, String>>> map = f50455f;
        map.remove(grsParasKey);
        Logger.d(f50454e, "Cache size is: " + map.size());
        this.f50459d.f(grsParasKey);
    }

    public void h(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a6 = this.f50457b.a(grsParasKey, "");
        String a7 = this.f50457b.a(grsParasKey + "time", "0");
        long j6 = 0;
        if (!TextUtils.isEmpty(a7) && a7.matches("\\d+")) {
            try {
                j6 = Long.parseLong(a7);
            } catch (NumberFormatException e6) {
                Logger.w(f50454e, "convert urlParamKey from String to Long catch NumberFormatException.", e6);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f50455f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.e(a6));
        Logger.d(f50454e, "Cache size is: " + map.size());
        this.f50456a.put(grsParasKey, Long.valueOf(j6));
        e(grsBaseInfo, grsParasKey, context);
    }

    private void e(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.b(this.f50456a.get(str), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)) {
            this.f50459d.h(new q1.c(grsBaseInfo, context), null, null, this.f50458c, -1);
        }
    }

    public c b() {
        return this.f50457b;
    }

    public g g() {
        return this.f50459d;
    }

    public c i() {
        return this.f50458c;
    }

    public a(c cVar, c cVar2, g gVar) {
        this.f50458c = cVar2;
        this.f50457b = cVar;
        this.f50459d = gVar;
        gVar.g(this);
    }

    public void d(GrsBaseInfo grsBaseInfo, d dVar, Context context, q1.c cVar) {
        if (dVar.t() == 2) {
            Logger.w(f50454e, "update cache from server failed");
            return;
        }
        if (cVar.e().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.B()) {
                f50455f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.e(this.f50457b.a(grsParasKey, "")));
            } else {
                this.f50457b.f(grsParasKey, dVar.y());
                f50455f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.e(dVar.y()));
            }
            if (!TextUtils.isEmpty(dVar.r())) {
                this.f50457b.f(grsParasKey + "ETag", dVar.r());
            }
            this.f50457b.f(grsParasKey + "time", dVar.a());
            this.f50456a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f50457b.f("geoipCountryCode", dVar.y());
            this.f50457b.f("geoipCountryCodetime", dVar.a());
        }
        Logger.d(f50454e, "Cache size is: " + f50455f.size());
    }
}
