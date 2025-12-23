package com.amap.api.col.s;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e3 {

    /* renamed from: a, reason: collision with root package name */
    private Context f8064a;

    /* renamed from: b, reason: collision with root package name */
    private i1 f8065b;

    /* renamed from: c, reason: collision with root package name */
    private String f8066c;

    private static String a(Context context, i1 i1Var, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(i1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(i1Var.d());
            sb.append("\",\"nt\":\"");
            sb.append(c1.r(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    final byte[] b() {
        return j1.o(a(this.f8064a, this.f8065b, this.f8066c));
    }
}
