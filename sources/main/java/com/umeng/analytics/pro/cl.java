package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class cl {

    /* renamed from: a, reason: collision with root package name */
    public final String f41140a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f41141b;

    /* renamed from: c, reason: collision with root package name */
    public final short f41142c;

    public cl() {
        this("", (byte) 0, (short) 0);
    }

    public cl(String str, byte b6, short s5) {
        this.f41140a = str;
        this.f41141b = b6;
        this.f41142c = s5;
    }

    public boolean a(cl clVar) {
        return this.f41141b == clVar.f41141b && this.f41142c == clVar.f41142c;
    }

    public String toString() {
        return "<TField name:'" + this.f41140a + "' type:" + ((int) this.f41141b) + " field-id:" + ((int) this.f41142c) + ">";
    }
}
