package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class pblw extends pbly.pgla {

    /* renamed from: a, reason: collision with root package name */
    private static pblw f50377a;

    public static class pgla {

        /* renamed from: a, reason: collision with root package name */
        private long f50378a;

        /* renamed from: b, reason: collision with root package name */
        private String f50379b;

        public final void a(String str) {
            this.f50379b = str;
            this.f50378a = System.currentTimeMillis();
        }

        public final void b(String str, int i6) {
            pblw c6 = pblw.c();
            if (c6 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = this.f50378a;
            c6.d(currentTimeMillis - j6, j6, this.f50379b, str, i6);
        }

        public final void c(String str, int i6) {
            pblw c6 = pblw.c();
            if (c6 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j6 = this.f50378a;
            c6.h(currentTimeMillis - j6, j6, this.f50379b, str, i6);
        }
    }

    public abstract void d(long j6, long j7, String str, String str2, int i6);

    public abstract void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean g(String str);

    public abstract void h(long j6, long j7, String str, String str2, int i6);

    public static synchronized pblw c() {
        pblw pblwVar;
        synchronized (pblw.class) {
            pblwVar = f50377a;
        }
        return pblwVar;
    }

    public static synchronized void f(pblw pblwVar) {
        synchronized (pblw.class) {
            f50377a = pblwVar;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object a(int i6, int i7, long j6, String str, Object obj) throws Throwable {
        if (i6 == 131073) {
            if (str == null || !g(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f654b8", new byte[]{88, Ascii.US});
        }
        if (i6 == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                e(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }
}
