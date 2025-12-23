package com.hp.hpl.sparta.xpath;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class u extends k {

    /* renamed from: a, reason: collision with root package name */
    private final String f32905a;

    public String b() {
        return this.f32905a;
    }

    protected String c(String str) {
        return "[text()" + str + "'" + this.f32905a + "']";
    }

    u(String str) {
        this.f32905a = str;
    }
}
