package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class co {

    /* renamed from: a, reason: collision with root package name */
    public final String f41148a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f41149b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41150c;

    public co() {
        this("", (byte) 0, 0);
    }

    public co(String str, byte b6, int i6) {
        this.f41148a = str;
        this.f41149b = b6;
        this.f41150c = i6;
    }

    public boolean a(co coVar) {
        return this.f41148a.equals(coVar.f41148a) && this.f41149b == coVar.f41149b && this.f41150c == coVar.f41150c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof co) {
            return a((co) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f41148a + "' type: " + ((int) this.f41149b) + " seqid:" + this.f41150c + ">";
    }
}
