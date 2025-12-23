package com.hp.hpl.sparta.xpath;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class i extends e {

    /* renamed from: b, reason: collision with root package name */
    private final int f32882b;

    public double c() {
        return this.f32882b;
    }

    protected String d(String str) {
        return "[" + super.toString() + str + "'" + this.f32882b + "']";
    }

    i(String str, int i6) {
        super(str);
        this.f32882b = i6;
    }
}
