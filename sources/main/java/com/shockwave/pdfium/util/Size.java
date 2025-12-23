package com.shockwave.pdfium.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f37511a;

    /* renamed from: b, reason: collision with root package name */
    private final int f37512b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f37511a == size.f37511a && this.f37512b == size.f37512b) {
                return true;
            }
        }
        return false;
    }

    public int a() {
        return this.f37512b;
    }

    public int b() {
        return this.f37511a;
    }

    public int hashCode() {
        int i6 = this.f37512b;
        int i7 = this.f37511a;
        return i6 ^ ((i7 >>> 16) | (i7 << 16));
    }

    public String toString() {
        return this.f37511a + "x" + this.f37512b;
    }

    public Size(int i6, int i7) {
        this.f37511a = i6;
        this.f37512b = i7;
    }
}
