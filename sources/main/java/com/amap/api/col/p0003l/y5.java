package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.z5;
import com.stub.StubApp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y5 {

    /* renamed from: a, reason: collision with root package name */
    private Context f7764a;

    /* renamed from: b, reason: collision with root package name */
    private p4 f7765b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7766c = true;

    /* renamed from: d, reason: collision with root package name */
    private String f7767d = "40C27E38DCAD404B5465362914090908";

    /* renamed from: e, reason: collision with root package name */
    private b6 f7768e = new b6("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z5, String str, String str2, String str3, String[] strArr) {
        try {
            p4 c6 = new p4.a(str, str2, str).b(strArr).a(str3).c();
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f7764a = origApplicationContext;
                this.f7765b = c6;
                this.f7766c = z5;
                this.f7768e.c(origApplicationContext, c6);
            }
        } catch (fk unused) {
        }
    }

    public final void b(String str, String str2) {
        List<p4> b6 = this.f7768e.b(this.f7764a);
        z5 z5Var = z5.a.f7799a;
        z5.b(this.f7764a, str, str2, b6, this.f7766c, this.f7765b);
    }
}
