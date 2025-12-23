package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.b2;
import xyz.adscope.ad.d2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class c2<C extends a2, L extends d2> {

    /* renamed from: a, reason: collision with root package name */
    protected Context f54907a;

    /* renamed from: b, reason: collision with root package name */
    protected C f54908b;

    /* renamed from: c, reason: collision with root package name */
    private final b2<C, L> f54909c;

    protected b2<C, L> a() {
        return this.f54909c;
    }

    protected abstract c b();

    protected void a(L l6) {
        this.f54909c.a((b2<C, L>) l6);
        this.f54909c.h();
    }

    protected String getRequestSessionID() {
        b2<C, L> b2Var = this.f54909c;
        return b2Var != null ? b2Var.d() : "";
    }

    public c2(Context context, C c6) {
        this.f54907a = context;
        this.f54908b = c6;
        this.f54909c = b2.b.a(b(), context, c6);
    }
}
