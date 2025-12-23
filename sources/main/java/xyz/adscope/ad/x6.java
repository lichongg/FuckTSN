package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.stub.StubApp;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class x6 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56133a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f56134b = new ArrayMap();

    public boolean a(long j6) {
        Map<String, Long> map = this.f56134b;
        if (map != null && map.containsKey("UPT")) {
            Long l6 = this.f56134b.get("UPT");
            if (System.currentTimeMillis() - (l6 != null ? l6.longValue() : 0L) < j6) {
                return true;
            }
        }
        return false;
    }

    public void b(c cVar) {
        String a6 = a(cVar);
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f56134b.put(a6, Long.valueOf(currentTimeMillis));
        b(a6, currentTimeMillis);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56135a;

        static {
            int[] iArr = new int[c.values().length];
            f56135a = iArr;
            try {
                iArr[c.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56135a[c.SPLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56135a[c.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56135a[c.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56135a[c.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void c() {
        long a6 = a("UPT", 0L);
        if (a6 == 0) {
            a6 = System.currentTimeMillis();
            b("UPT", a6);
        }
        this.f56134b.put("UPT", Long.valueOf(a6));
    }

    public x6(Context context) {
        this.f56133a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void d() {
        c();
        b();
    }

    public boolean a(c cVar, long j6) {
        Map<String, Long> map;
        String a6 = a(cVar);
        if (!TextUtils.isEmpty(a6) && (map = this.f56134b) != null && map.containsKey(a6)) {
            Long l6 = this.f56134b.get(a6);
            if (System.currentTimeMillis() - (l6 != null ? l6.longValue() : 0L) < j6) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        String[] strArr = {"SCD", "BCD", "NCD", "ICD", "VCD"};
        for (int i6 = 0; i6 < 5; i6++) {
            String str = strArr[i6];
            long a6 = a(str, 0L);
            if (a6 != 0) {
                this.f56134b.put(str, Long.valueOf(a6));
            }
        }
    }

    private String a(c cVar) {
        int i6 = a.f56135a[cVar.ordinal()];
        if (i6 == 1) {
            return "ICD";
        }
        if (i6 == 2) {
            return "SCD";
        }
        if (i6 == 3) {
            return "NCD";
        }
        if (i6 == 4) {
            return "BCD";
        }
        if (i6 != 5) {
            return null;
        }
        return "VCD";
    }

    private void b(String str, long j6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.b(this.f56133a, a(), str, j6);
    }

    private long a(String str, long j6) {
        return (TextUtils.isEmpty(str) || !i0.a(this.f56133a, a(), str)) ? j6 : i0.a(this.f56133a, a(), str, j6);
    }

    private String a() {
        return String.format("asnp_user_%s", f0.a());
    }
}
