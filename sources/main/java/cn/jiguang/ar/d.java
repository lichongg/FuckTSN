package cn.jiguang.ar;

import android.content.Context;
import cn.jiguang.au.g;
import cn.jiguang.bb.f;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1687a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.as.a f1688b;

    /* renamed from: cn.jiguang.ar.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f1689a = new d(null);
    }

    private d() {
    }

    public static d a() {
        return a.f1689a;
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f1687a = context;
        g.f1768a = true;
        return "JWakeReport";
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (this.f1688b.f1712w) {
            JSONArray b6 = cn.jiguang.au.c.b(context);
            if (b6 == null || b6.length() == 0) {
                f.c("JWakeReport", "no report wakeData");
            } else {
                f.c("JWakeReport", "report wakeData:" + b6);
                cn.jiguang.bd.f.a(context, b6);
                cn.jiguang.au.c.c(context);
                super.d(context, str);
            }
        } else {
            f.i("JWakeReport", "server set do not report wake data.");
        }
        if (!this.f1688b.f1713x) {
            f.i("JWakeReport", "server set do not report waked data.");
            return;
        }
        JSONArray a6 = g.a(context);
        if (a6 == null || a6.length() == 0) {
            f.c("JWakeReport", "no report wakedData");
            return;
        }
        f.c("JWakeReport", "report wakedData:" + a6);
        cn.jiguang.bd.f.a(context, a6);
        g.b(context);
        super.d(context, str);
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return true;
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return cn.jiguang.m.b.d(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        this.f1688b = cn.jiguang.au.b.b(context);
        super.c(context, str);
    }
}
