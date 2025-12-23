package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    private String f33491a;

    /* renamed from: b, reason: collision with root package name */
    private String f33492b;

    /* renamed from: c, reason: collision with root package name */
    private String f33493c;

    /* renamed from: d, reason: collision with root package name */
    private String f33494d;

    /* renamed from: e, reason: collision with root package name */
    private long f33495e;

    public void a() {
        j1.h("StreamEventHandler", "Begin to handle stream events...");
        f fVar = new f();
        fVar.e(this.f33493c);
        fVar.i(this.f33492b);
        fVar.b(this.f33494d);
        fVar.g(String.valueOf(this.f33495e));
        if ("oper".equals(this.f33492b) && r1.i(this.f33491a, "oper")) {
            v0 b6 = p1.c().b(this.f33491a, this.f33495e);
            String a6 = b6.a();
            Boolean valueOf = Boolean.valueOf(b6.f());
            fVar.k(a6);
            fVar.j(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        new j0(this.f33491a, this.f33492b, y0.m(), arrayList, replace).b();
    }

    public a0(String str, String str2, String str3, String str4, long j6) {
        this.f33491a = str;
        this.f33492b = str2;
        this.f33493c = str3;
        this.f33494d = str4;
        this.f33495e = j6;
    }
}
