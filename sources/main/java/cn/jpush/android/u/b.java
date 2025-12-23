package cn.jpush.android.u;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.a;
import cn.jpush.android.s.b;
import cn.jpush.android.s.c;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected a f3842a;

    /* renamed from: b, reason: collision with root package name */
    protected cn.jpush.android.d.d f3843b;

    /* renamed from: c, reason: collision with root package name */
    protected cn.jpush.android.t.a f3844c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f3845d;

    /* renamed from: e, reason: collision with root package name */
    protected int f3846e;

    /* renamed from: f, reason: collision with root package name */
    private cn.jpush.android.s.c f3847f;

    public interface a {
        void a(Context context, View view);

        void a(Context context, View view, Object obj);
    }

    private void c(View view) {
        view.setOnTouchListener(new cn.jpush.android.s.b(this, null, this.f3843b.aH, new b.a() { // from class: cn.jpush.android.u.b.3
            @Override // cn.jpush.android.s.b.a
            public void a(View view2, Object obj) {
                b bVar = b.this;
                a aVar = bVar.f3842a;
                if (aVar != null) {
                    aVar.a(bVar.f3845d, view2, bVar.f3843b);
                }
            }

            @Override // cn.jpush.android.s.b.a
            public boolean a(Object obj) {
                return true;
            }
        }));
    }

    public int a(int i6) {
        return m.b(this.f3845d, i6);
    }

    public int b(int i6) {
        return m.c(this.f3845d, i6);
    }

    public abstract void c();

    public abstract void d();

    public abstract View e();

    public abstract boolean f();

    public abstract void g();

    public static b a(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        if (i6 == 10 || i6 == 11) {
            return new cn.jpush.android.u.a(context, aVar, dVar, i6);
        }
        if (i6 == 20 || i6 == 21) {
            return new d(context, aVar, dVar, i6);
        }
        if (i6 == 30 || i6 == 31) {
            return new c(context, aVar, dVar, i6);
        }
        if (i6 != 40) {
            return null;
        }
        return new f(context, aVar, dVar, i6);
    }

    private void b(final View view) {
        if (this.f3847f == null) {
            this.f3847f = new cn.jpush.android.s.c();
        }
        long e6 = (long) (this.f3844c.e() + this.f3844c.f());
        Logger.d("BaseInAppWrapper", "configAutoDismiss autoTickTime: " + e6);
        this.f3847f.a(new c.a() { // from class: cn.jpush.android.u.b.2
            @Override // cn.jpush.android.s.c.a
            public void a() {
                try {
                    Logger.d("BaseInAppWrapper", "dismiss timer reach, dismiss notify inapp message");
                    cn.jpush.android.r.a.a(view, new Point(0, -m.a(b.this.f3845d, 94)), (long) b.this.f3844c.g(), new a.InterfaceC0058a() { // from class: cn.jpush.android.u.b.2.1
                        @Override // cn.jpush.android.r.a.InterfaceC0058a
                        public void a() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            b bVar = b.this;
                            a aVar = bVar.f3842a;
                            if (aVar != null) {
                                aVar.a(bVar.f3845d, view, bVar.f3843b);
                            }
                        }
                    });
                } catch (Throwable th) {
                    Logger.w("BaseInAppWrapper", "in-app slide to dismiss error." + th.getMessage());
                }
            }
        }, e6, 1000L);
    }

    public static boolean c(int i6) {
        return 10 == i6 || 11 == i6;
    }

    public void h() {
        try {
            View e6 = e();
            cn.jpush.android.t.a k6 = k();
            if (k6 != null && e6 != null) {
                a(e6);
                int i6 = this.f3846e;
                if (10 != i6 && 11 != i6 && 40 != i6) {
                    return;
                }
                c(e6);
                b(e6);
                return;
            }
            Logger.w("BaseInAppWrapper", "startViewAnimation param is null, view:" + e6 + "config:" + k6);
        } catch (Throwable th) {
            Logger.w("BaseInAppWrapper", "start in-app with animation error. " + th.getMessage());
        }
    }

    protected void i() {
        cn.jpush.android.s.c cVar = this.f3847f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public cn.jpush.android.d.d j() {
        return this.f3843b;
    }

    public cn.jpush.android.t.a k() {
        return this.f3844c;
    }

    public b(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        this.f3844c = aVar;
        this.f3843b = dVar;
        this.f3845d = context;
        this.f3846e = i6;
    }

    private void a(final View view) {
        Point point = new Point(0, -m.a(this.f3845d, 94));
        Point point2 = new Point(0, 0);
        long f6 = (long) this.f3844c.f();
        Logger.d("BaseInAppWrapper", "slideIntoView startPoint: " + point + ", endPoint: " + point2 + ", toShowTime: " + f6);
        cn.jpush.android.r.a.a(view, point, point2, f6, new a.InterfaceC0058a() { // from class: cn.jpush.android.u.b.1
            @Override // cn.jpush.android.r.a.InterfaceC0058a
            public void a() {
                Logger.d("BaseInAppWrapper", "notify inapp show animation end");
                b bVar = b.this;
                a aVar = bVar.f3842a;
                if (aVar != null) {
                    aVar.a(bVar.f3845d, view);
                }
            }
        });
    }

    public void a(a aVar) {
        this.f3842a = aVar;
    }
}
