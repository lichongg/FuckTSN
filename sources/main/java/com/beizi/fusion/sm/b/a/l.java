package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static com.beizi.fusion.sm.b.c f13523a;

    public static com.beizi.fusion.sm.b.c a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.beizi.fusion.sm.b.c cVar = f13523a;
        if (cVar != null) {
            return cVar;
        }
        com.beizi.fusion.sm.b.c b6 = b(context);
        f13523a = b6;
        if (b6 == null || !b6.a()) {
            com.beizi.fusion.sm.b.c c6 = c(context);
            f13523a = c6;
            return c6;
        }
        com.beizi.fusion.sm.b.e.a("Manufacturer interface has been found: " + f13523a.getClass().getName());
        return f13523a;
    }

    private static com.beizi.fusion.sm.b.c c(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            com.beizi.fusion.sm.b.e.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.a()) {
            com.beizi.fusion.sm.b.e.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        com.beizi.fusion.sm.b.e.a("OAID was not supported: " + d.class.getName());
        return dVar;
    }

    private static com.beizi.fusion.sm.b.c b(Context context) {
        if (!com.beizi.fusion.sm.b.f.k() && !com.beizi.fusion.sm.b.f.n()) {
            if (com.beizi.fusion.sm.b.f.j()) {
                return new i(context);
            }
            if (com.beizi.fusion.sm.b.f.l()) {
                return new k(context);
            }
            if (!com.beizi.fusion.sm.b.f.e() && !com.beizi.fusion.sm.b.f.f() && !com.beizi.fusion.sm.b.f.g()) {
                if (com.beizi.fusion.sm.b.f.i()) {
                    return new o(context);
                }
                if (com.beizi.fusion.sm.b.f.d()) {
                    return new p(context);
                }
                if (com.beizi.fusion.sm.b.f.m()) {
                    return new a(context);
                }
                if (!com.beizi.fusion.sm.b.f.a() && !com.beizi.fusion.sm.b.f.b()) {
                    if (!com.beizi.fusion.sm.b.f.c() && !com.beizi.fusion.sm.b.f.h()) {
                        if (com.beizi.fusion.sm.b.f.a(context)) {
                            return new b(context);
                        }
                        if (com.beizi.fusion.sm.b.f.p()) {
                            return new c(context);
                        }
                        if (com.beizi.fusion.sm.b.f.o()) {
                            return new e(context);
                        }
                        return null;
                    }
                    return new n(context);
                }
                return new g(context);
            }
            return new q(context);
        }
        return new h(context);
    }
}
