package com.hp.hpl.sparta.xpath;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class j extends o {

    /* renamed from: a, reason: collision with root package name */
    private final String f32883a;

    @Override // com.hp.hpl.sparta.xpath.o
    public boolean b() {
        return true;
    }

    public String c() {
        return this.f32883a;
    }

    public String toString() {
        return "@" + this.f32883a;
    }

    j(String str) {
        this.f32883a = str;
    }

    @Override // com.hp.hpl.sparta.xpath.o
    public void a(b0 b0Var) {
        b0Var.a(this);
    }
}
