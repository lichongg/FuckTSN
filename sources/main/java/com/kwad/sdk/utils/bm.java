package com.kwad.sdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class bm {
    protected final int mHeight;
    protected final int mWidth;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bm) {
            bm bmVar = (bm) obj;
            if (this.mWidth == bmVar.mWidth && this.mHeight == bmVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final float RF() {
        return this.mWidth;
    }

    public final float RG() {
        return this.mHeight;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i6 = this.mHeight;
        int i7 = this.mWidth;
        return i6 ^ ((i7 >>> 16) | (i7 << 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public bm(int i6, int i7) {
        this.mWidth = i6;
        this.mHeight = i7;
    }
}
