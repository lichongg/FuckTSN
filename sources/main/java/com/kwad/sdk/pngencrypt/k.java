package com.kwad.sdk.pngencrypt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k {
    public final int aUH;
    public final int aUI;
    public final int aVa;
    public final int aVb;
    public final boolean aVc;
    public final boolean aVd;
    public final boolean aVe;
    public final boolean aVf;
    public final int aVg;
    public final int aVh;
    public final int aVi;
    public final int aVj;
    public final int aVk;
    private long aVl = -1;
    private long aVm = -1;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.aVc == kVar.aVc && this.aVa == kVar.aVa && this.aUI == kVar.aUI && this.aVd == kVar.aVd && this.aVe == kVar.aVe && this.aUH == kVar.aUH;
    }

    public final int hashCode() {
        return (((((((((((this.aVc ? 1231 : 1237) + 31) * 31) + this.aVa) * 31) + this.aUI) * 31) + (this.aVd ? 1231 : 1237)) * 31) + (this.aVe ? 1231 : 1237)) * 31) + this.aUH;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aUI + ", rows=" + this.aUH + ", bitDepth=" + this.aVa + ", channels=" + this.aVb + ", alpha=" + this.aVc + ", greyscale=" + this.aVd + ", indexed=" + this.aVe + "]";
    }

    public k(int i6, int i7, int i8, boolean z5, boolean z6, boolean z7) {
        int i9;
        boolean z8;
        this.aUI = i6;
        this.aUH = i7;
        this.aVc = z5;
        this.aVe = z7;
        this.aVd = z6;
        if (z6 && z7) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        if (!z6 && !z7) {
            if (z5) {
                i9 = 4;
            } else {
                i9 = 3;
            }
        } else if (z5) {
            i9 = 2;
        } else {
            i9 = 1;
        }
        this.aVb = i9;
        this.aVa = i8;
        if (i8 < 8) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.aVf = z8;
        int i10 = i9 * i8;
        this.aVg = i10;
        this.aVh = (i10 + 7) / 8;
        int i11 = ((i10 * i6) + 7) / 8;
        this.aVi = i11;
        int i12 = i9 * i6;
        this.aVj = i12;
        this.aVk = z8 ? i11 : i12;
        if (i8 != 1 && i8 != 2 && i8 != 4) {
            if (i8 != 8) {
                if (i8 == 16) {
                    if (z7) {
                        throw new PngjException("indexed can't have bitdepth=" + i8);
                    }
                } else {
                    throw new PngjException("invalid bitdepth=" + i8);
                }
            }
        } else if (!z7 && !z6) {
            throw new PngjException("only indexed or grayscale can have bitdepth=" + i8);
        }
        if (i6 > 0 && i6 <= 16777216) {
            if (i7 > 0 && i7 <= 16777216) {
                if (i12 > 0) {
                    return;
                } else {
                    throw new PngjException("invalid image parameters (overflow?)");
                }
            } else {
                throw new PngjException("invalid rows=" + i7 + " ???");
            }
        }
        throw new PngjException("invalid cols=" + i6 + " ???");
    }
}
