package cn.jiguang.h;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f2971a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2972b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f2973c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f2974d;

    /* renamed from: cn.jiguang.h.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.h.a$a, reason: collision with other inner class name */
    private static final class C0046a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2975a;

        /* renamed from: b, reason: collision with root package name */
        private static final a f2976b;

        static {
            AnonymousClass1 anonymousClass1 = null;
            f2975a = new a(false, anonymousClass1);
            f2976b = new a(true, anonymousClass1);
        }
    }

    private a(boolean z5) {
        this.f2972b = z5;
        this.f2973c = new AtomicBoolean(true);
        this.f2974d = new AtomicBoolean(true);
    }

    public static a a() {
        return C0046a.f2975a;
    }

    public static a b() {
        return C0046a.f2976b;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(this.f2972b ? 1112 : 1104)) {
            cn.jiguang.an.a.a(context, "app_active", -3);
            return;
        }
        cn.jiguang.common.app.helper.a.a().a(context, this.f2972b);
        this.f2974d.set(false);
        super.c(context, str);
    }

    /* synthetic */ a(boolean z5, AnonymousClass1 anonymousClass1) {
        this(z5);
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f2971a = context;
        return this.f2972b ? "JAppActiveWithFile" : "JAppActive";
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return this.f2973c.get() || super.b(context, str);
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        cn.jiguang.bb.f.c("JAppActive", "for googlePlay:false");
        return cn.jiguang.g.a.a().e(this.f2972b ? 1112 : 1104);
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return this.f2974d.get() || super.a(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        int i6;
        cn.jiguang.g.a a6 = cn.jiguang.g.a.a();
        if (this.f2972b) {
            i6 = 1112;
        } else {
            i6 = 1104;
        }
        if (a6.g(i6)) {
            return;
        }
        cn.jiguang.common.app.helper.a.a().a(context, str, this.f2973c, this.f2972b);
    }
}
