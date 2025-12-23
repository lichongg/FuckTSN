package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f7 {

    /* renamed from: a, reason: collision with root package name */
    private Context f6189a;

    /* renamed from: b, reason: collision with root package name */
    private p4 f6190b;

    /* renamed from: c, reason: collision with root package name */
    private String f6191c;

    private static String a(Context context, p4 p4Var, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(p4Var.f());
            sb.append("\",\"product\":\"");
            sb.append(p4Var.a());
            sb.append("\",\"nt\":\"");
            sb.append(i4.y(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    final byte[] b() {
        return q4.o(a(this.f6189a, this.f6190b, this.f6191c));
    }

    public f7(Context context, p4 p4Var, String str) {
        this.f6189a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6190b = p4Var;
        this.f6191c = str;
    }
}
