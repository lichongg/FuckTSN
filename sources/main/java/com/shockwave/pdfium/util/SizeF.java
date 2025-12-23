package com.shockwave.pdfium.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SizeF {

    /* renamed from: a, reason: collision with root package name */
    private final float f37513a;

    /* renamed from: b, reason: collision with root package name */
    private final float f37514b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeF) {
            SizeF sizeF = (SizeF) obj;
            if (this.f37513a == sizeF.f37513a && this.f37514b == sizeF.f37514b) {
                return true;
            }
        }
        return false;
    }

    public float a() {
        return this.f37514b;
    }

    public float b() {
        return this.f37513a;
    }

    public Size c() {
        return new Size((int) this.f37513a, (int) this.f37514b);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f37513a) ^ Float.floatToIntBits(this.f37514b);
    }

    public String toString() {
        return this.f37513a + "x" + this.f37514b;
    }

    public SizeF(float f6, float f7) {
        this.f37513a = f6;
        this.f37514b = f7;
    }
}
