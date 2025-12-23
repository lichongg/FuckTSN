package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class s implements v {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f33637a;

    /* renamed from: b, reason: collision with root package name */
    private String f33638b;

    /* renamed from: c, reason: collision with root package name */
    private String f33639c;

    /* renamed from: d, reason: collision with root package name */
    private String f33640d;

    /* renamed from: e, reason: collision with root package name */
    private String f33641e;

    /* renamed from: f, reason: collision with root package name */
    private List<f> f33642f;

    private p0 a(Map<String, String> map) {
        return k1.a(this.f33638b, this.f33637a, map);
    }

    private Map<String, String> b() {
        return g0.g(this.f33639c, this.f33641e, this.f33640d);
    }

    private void c() {
        e.d().b(new k(this.f33642f, this.f33639c, this.f33640d, this.f33641e));
    }

    @Override // java.lang.Runnable
    public void run() {
        j1.h("hmsSdk", "send data running");
        int b6 = a(b()).b();
        if (b6 != 200) {
            c();
            return;
        }
        j1.f("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f33640d, this.f33641e, this.f33639c, Integer.valueOf(b6));
    }

    public s(byte[] bArr, String str, String str2, String str3, String str4, List<f> list) {
        this.f33637a = (byte[]) bArr.clone();
        this.f33638b = str;
        this.f33639c = str2;
        this.f33641e = str3;
        this.f33640d = str4;
        this.f33642f = list;
    }
}
