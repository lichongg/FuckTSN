package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.w5;
import com.stub.StubApp;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b5 {

    /* renamed from: a, reason: collision with root package name */
    private Context f5702a;

    /* renamed from: b, reason: collision with root package name */
    private p4 f5703b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5704c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5705d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5706e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5707f = false;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f5708g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private d5 f5709h = new d5((byte) 0);

    /* renamed from: i, reason: collision with root package name */
    private d5 f5710i = new d5();

    /* renamed from: j, reason: collision with root package name */
    private w5.d f5711j = new a();

    /* renamed from: k, reason: collision with root package name */
    private w5.d f5712k = new b();

    /* renamed from: l, reason: collision with root package name */
    private Handler f5713l = null;

    /* renamed from: m, reason: collision with root package name */
    private c7 f5714m = null;

    /* renamed from: n, reason: collision with root package name */
    private c7 f5715n = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements w5.d {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.amap.api.col.3l.b5$a$a, reason: collision with other inner class name */
        final class RunnableC0088a implements Runnable {
            RunnableC0088a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b5.this.s(false);
            }
        }

        a() {
        }

        @Override // com.amap.api.col.3l.w5.d
        public final void a(int i6) {
            if (i6 > 0 && b5.b(b5.this) != null) {
                ((c5) b5.this.p().f5854f).f(i6);
                b5.i(b5.this, "error", String.valueOf(((c5) b5.this.p().f5854f).h()));
                b5.b(b5.this).postDelayed(new RunnableC0088a(), 660000L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements w5.d {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b5.this.v(false);
            }
        }

        b() {
        }

        @Override // com.amap.api.col.3l.w5.d
        public final void a(int i6) {
            if (i6 <= 0) {
                return;
            }
            ((c5) b5.this.w().f5854f).f(i6);
            b5.i(b5.this, "info", String.valueOf(((c5) b5.this.w().f5854f).h()));
            if (b5.b(b5.this) == null) {
                return;
            }
            b5.b(b5.this).postDelayed(new a(), 660000L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, b5> f5720a = new HashMap();
    }

    private static String d(Context context, String str, p4 p4Var) {
        String d6;
        if (context == null) {
            return null;
        }
        if (p4Var != null) {
            try {
                if (!TextUtils.isEmpty(p4Var.a())) {
                    d6 = m4.d(p4Var.a());
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir().getAbsolutePath());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb.append(str2);
                    sb.append(str);
                    sb.append(str2);
                    sb.append(d6);
                    return sb.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        d6 = "a";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        String str22 = File.separator;
        sb2.append(str22);
        sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb2.append(str22);
        sb2.append(str);
        sb2.append(str22);
        sb2.append(d6);
        return sb2.toString();
    }

    private String A() {
        Context context = this.f5702a;
        if (context == null) {
            return null;
        }
        return d(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f5703b);
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return Long.parseLong(e5.a(this.f5703b).c(this.f5702a, "", "", format + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    static /* synthetic */ Handler b(b5 b5Var) {
        Context context = b5Var.f5702a;
        if (context == null || context == null) {
            return null;
        }
        if (b5Var.f5713l == null) {
            b5Var.f5713l = new Handler(b5Var.f5702a.getMainLooper());
        }
        return b5Var.f5713l;
    }

    public static b5 c(p4 p4Var) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        if (c.f5720a.get(p4Var.a()) == null) {
            c.f5720a.put(p4Var.a(), new b5(p4Var));
        }
        return c.f5720a.get(p4Var.a());
    }

    static /* synthetic */ void i(b5 b5Var, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            e5.a(b5Var.f5703b).d(b5Var.f5702a, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }

    private d5 l(int i6) {
        return i6 == a5.f5627f ? this.f5710i : this.f5709h;
    }

    private boolean o() {
        return this.f5702a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c7 p() {
        c7 c7Var = this.f5715n;
        if (c7Var != null) {
            return c7Var;
        }
        t();
        return this.f5715n;
    }

    private c7 q(int i6) {
        if (i6 == a5.f5627f) {
            if (this.f5715n == null) {
                this.f5715n = p();
            }
            return this.f5715n;
        }
        if (this.f5714m == null) {
            this.f5714m = w();
        }
        return this.f5714m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z5) {
        c7 q5 = q(a5.f5627f);
        if (z5) {
            ((c5) q5.f5854f).g(z5);
        }
        Context context = this.f5702a;
        if (context == null) {
            return;
        }
        w5.i(context, q5, this.f5711j);
    }

    private c7 t() {
        if (this.f5702a == null) {
            return null;
        }
        c7 c7Var = new c7();
        this.f5715n = c7Var;
        c7Var.f5849a = A();
        c7 c7Var2 = this.f5715n;
        c7Var2.f5850b = 512000000L;
        c7Var2.f5852d = 12500;
        c7Var2.f5851c = "1";
        c7Var2.f5856h = -1;
        c7Var2.f5857i = "elkey";
        long a6 = a("error");
        this.f5715n.f5854f = new c5(true, new y7(this.f5702a, this.f5705d), a6, 10000000);
        c7 c7Var3 = this.f5715n;
        c7Var3.f5855g = null;
        return c7Var3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z5) {
        c7 q5 = q(a5.f5626e);
        if (z5) {
            ((c5) q5.f5854f).g(z5);
        }
        Context context = this.f5702a;
        if (context == null) {
            return;
        }
        w5.i(context, q5, this.f5712k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c7 w() {
        c7 c7Var = this.f5714m;
        if (c7Var != null) {
            return c7Var;
        }
        y();
        return this.f5714m;
    }

    private c7 y() {
        if (this.f5702a == null) {
            return null;
        }
        c7 c7Var = new c7();
        this.f5714m = c7Var;
        c7Var.f5849a = z();
        c7 c7Var2 = this.f5714m;
        c7Var2.f5850b = 512000000L;
        c7Var2.f5852d = 12500;
        c7Var2.f5851c = "1";
        c7Var2.f5856h = -1;
        c7Var2.f5857i = "inlkey";
        long a6 = a("info");
        this.f5714m.f5854f = new c5(this.f5707f, new y7(this.f5702a, this.f5705d), a6, 30000000);
        c7 c7Var3 = this.f5714m;
        c7Var3.f5855g = null;
        return c7Var3;
    }

    private String z() {
        Context context = this.f5702a;
        if (context == null) {
            return null;
        }
        return d(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f5703b);
    }

    public final void k(boolean z5, boolean z6, boolean z7, boolean z8, List<String> list) {
        this.f5704c = z5;
        this.f5705d = z6;
        this.f5706e = z7;
        this.f5707f = z8;
        this.f5708g = list;
        t();
        y();
    }

    private b5(p4 p4Var) {
        this.f5703b = p4Var;
    }

    private void f(int i6) {
        Context context;
        d5 l6 = l(i6);
        String d6 = a5.d(l6.a());
        if (!TextUtils.isEmpty(d6) && !"[]".equals(d6) && (context = this.f5702a) != null) {
            w5.h(context, this.f5703b, a5.c(i6), q(i6), d6);
            l6.d();
        }
    }

    private void n(boolean z5) {
        s(z5);
        v(z5);
    }

    public final void e() {
        if (!o()) {
            return;
        }
        f(a5.f5627f);
        f(a5.f5626e);
    }

    public final void g(Context context) {
        this.f5702a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final void h(a5 a5Var) {
        if (!o() || !this.f5704c || !a5.e(a5Var) || a5Var == null) {
            return;
        }
        List<String> list = this.f5708g;
        if (list != null && list.size() != 0) {
            for (int i6 = 0; i6 < this.f5708g.size(); i6++) {
                if (!TextUtils.isEmpty(this.f5708g.get(i6)) && a5Var.g().contains(this.f5708g.get(i6))) {
                    return;
                }
            }
        }
        if (this.f5706e || a5Var.a() != a5.f5626e) {
            d5 l6 = l(a5Var.a());
            if (l6.c(a5Var.g())) {
                String d6 = a5.d(l6.a());
                if (this.f5702a != null && !TextUtils.isEmpty(d6) && !"[]".equals(d6)) {
                    w5.h(this.f5702a, this.f5703b, a5Var.i(), q(a5Var.a()), d6);
                    n(false);
                    l6.d();
                } else {
                    return;
                }
            }
            l6.b(a5Var);
        }
    }

    public final void j(boolean z5) {
        if (!o()) {
            return;
        }
        n(z5);
    }
}
