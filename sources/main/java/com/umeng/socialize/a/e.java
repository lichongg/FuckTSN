package com.umeng.socialize.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.utils.ContextUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42212a = "Prefs";

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f42213c;

    /* renamed from: b, reason: collision with root package name */
    private final Context f42214b;

    /* renamed from: d, reason: collision with root package name */
    private final a f42215d = new a("AZX");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a {

        /* renamed from: b, reason: collision with root package name */
        private final String f42217b;

        private String b(String str) {
            return this.f42217b + str;
        }

        private String c(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    return b.a().b(str, str2);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return str2;
        }

        public void a(String str, int i6) {
            d(b(str), String.valueOf(i6));
        }

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f42217b = str;
        }

        public void a(String str, long j6) {
            d(b(str), String.valueOf(j6));
        }

        public int b(String str, int i6) {
            try {
                return Integer.parseInt(c(b(str), String.valueOf(i6)));
            } catch (Exception unused) {
                return i6;
            }
        }

        private void d(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str, str2);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public void a(String str, float f6) {
            d(b(str), String.valueOf(f6));
        }

        public void a(String str, String str2) {
            d(b(str), String.valueOf(str2));
        }

        public long b(String str, long j6) {
            try {
                return Long.parseLong(c(b(str), String.valueOf(j6)));
            } catch (Exception unused) {
                return j6;
            }
        }

        public void a(String str, boolean z5) {
            d(b(str), String.valueOf(z5));
        }

        private void c(String str) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void a(String str) {
            c(b(str));
        }

        public float b(String str, float f6) {
            try {
                return Float.parseFloat(c(b(str), String.valueOf(f6)));
            } catch (Exception unused) {
                return f6;
            }
        }

        public boolean b(String str, boolean z5) {
            try {
                return Boolean.parseBoolean(c(b(str), String.valueOf(z5)));
            } catch (Exception unused) {
                return z5;
            }
        }

        public String b(String str, String str2) {
            return c(b(str), str2);
        }
    }

    public static e a(Context context) {
        if (f42213c == null) {
            synchronized (e.class) {
                try {
                    if (f42213c == null) {
                        f42213c = new e(context);
                    }
                } finally {
                }
            }
        }
        return f42213c;
    }

    public boolean b() {
        return a(com.umeng.socialize.a.a.f42201e);
    }

    private void b(String str) {
        this.f42215d.a(str + bi.aX);
        this.f42215d.a(str + "ts");
    }

    public int c() {
        return this.f42215d.b(com.umeng.socialize.a.a.f42202f, 0);
    }

    public long d() {
        return this.f42215d.b(com.umeng.socialize.a.a.f42200d, 0L);
    }

    public void e() {
        if (c.a(this.f42214b)) {
            this.f42215d.a(com.umeng.socialize.a.a.f42200d, d() + 1);
        }
    }

    private e(Context context) {
        this.f42214b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void a(long j6) {
        a(com.umeng.socialize.a.a.f42201e, j6);
    }

    public long a() {
        return this.f42215d.b("smart_ts", 0L);
    }

    public void a(int i6) {
        this.f42215d.a(com.umeng.socialize.a.a.f42202f, i6);
    }

    private void a(String str, long j6) {
        this.f42215d.a(str + bi.aX, j6);
        this.f42215d.a(str + "ts", System.currentTimeMillis());
    }

    private boolean a(String str) {
        long b6 = this.f42215d.b(str + bi.aX, 0L);
        if (b6 <= 0) {
            return true;
        }
        long abs = Math.abs(System.currentTimeMillis() - this.f42215d.b(str + "ts", 0L)) / 1000;
        boolean z5 = abs >= b6;
        if (!z5 && com.umeng.socialize.a.a.f42199c) {
            m.a(f42212a, "interval deny ", str, " config:", Long.valueOf(b6), " current:", Long.valueOf(abs));
        }
        return z5;
    }
}
