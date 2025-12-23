package org.apache.commons.net.pop3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f51012a;

    /* renamed from: b, reason: collision with root package name */
    public int f51013b;

    /* renamed from: c, reason: collision with root package name */
    public String f51014c;

    public d() {
        this(0, null, 0);
    }

    public d(int i6, int i7) {
        this(i6, null, i7);
    }

    public String toString() {
        return "Number: " + this.f51012a + ". Size: " + this.f51013b + ". Id: " + this.f51014c;
    }

    public d(int i6, String str) {
        this(i6, str, -1);
    }

    private d(int i6, String str, int i7) {
        this.f51012a = i6;
        this.f51013b = i7;
        this.f51014c = str;
    }
}
