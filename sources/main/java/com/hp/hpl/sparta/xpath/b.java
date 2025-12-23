package com.hp.hpl.sparta.xpath;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class b extends e {

    /* renamed from: b, reason: collision with root package name */
    private final String f32875b;

    public String c() {
        return this.f32875b;
    }

    protected String d(String str) {
        return "[" + super.toString() + str + "'" + this.f32875b + "']";
    }

    b(String str, String str2) {
        super(str);
        this.f32875b = com.hp.hpl.sparta.q.a(str2);
    }
}
