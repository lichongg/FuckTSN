package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends DeflatedChunksSet {
    protected byte[] aUU;
    protected byte[] aUV;
    protected final k aUW;
    final p aUX;
    protected int[] aUY;
    protected final e aUa;

    public j(String str, boolean z5, k kVar, e eVar) {
        this(str, z5, kVar, eVar, null, null);
    }

    private void el(int i6) {
        for (int i7 = 1; i7 <= i6; i7++) {
            this.aUU[i7] = this.aUt[i7];
        }
    }

    private void en(int i6) {
        int i7;
        int i8 = 1;
        while (true) {
            i7 = this.aUW.aVh;
            if (i8 > i7) {
                break;
            }
            this.aUU[i8] = this.aUt[i8];
            i8++;
        }
        int i9 = i7 + 1;
        int i10 = 1;
        while (i9 <= i6) {
            byte[] bArr = this.aUU;
            bArr[i9] = (byte) (this.aUt[i9] + bArr[i10]);
            i9++;
            i10++;
        }
    }

    private void eo(int i6) {
        for (int i7 = 1; i7 <= i6; i7++) {
            this.aUU[i7] = (byte) (this.aUt[i7] + this.aUV[i7]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aUZ;

        static {
            int[] iArr = new int[FilterType.values().length];
            aUZ = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aUZ[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aUZ[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aUZ[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aUZ[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private j(String str, boolean z5, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z5, (eVar != null ? eVar.Oo() : kVar.aVi) + 1, kVar.aVi + 1, null, null);
        this.aUY = new int[5];
        this.aUW = kVar;
        this.aUa = eVar;
        this.aUX = new p(kVar, eVar);
    }

    private void Op() {
        ej(this.aUX.aVE);
    }

    private int Oq() {
        int Oo;
        e eVar = this.aUa;
        int i6 = 0;
        if (eVar == null) {
            int Og = Og();
            k kVar = this.aUW;
            if (Og < kVar.aUH - 1) {
                Oo = kVar.aVi;
                i6 = Oo + 1;
            }
        } else if (eVar.Oh()) {
            Oo = this.aUa.Oo();
            i6 = Oo + 1;
        }
        if (!this.aUd) {
            ef(i6);
        }
        return i6;
    }

    private void ej(int i6) {
        byte[] bArr = this.aUU;
        if (bArr == null || bArr.length < this.aUt.length) {
            byte[] bArr2 = this.aUt;
            this.aUU = new byte[bArr2.length];
            this.aUV = new byte[bArr2.length];
        }
        if (this.aUX.aVB == 0) {
            Arrays.fill(this.aUU, (byte) 0);
        }
        byte[] bArr3 = this.aUU;
        this.aUU = this.aUV;
        this.aUV = bArr3;
        byte b6 = this.aUt[0];
        if (!FilterType.isValidStandard(b6)) {
            throw new PngjException("Filter type " + ((int) b6) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b6);
        int[] iArr = this.aUY;
        iArr[b6] = iArr[b6] + 1;
        this.aUU[0] = this.aUt[0];
        int i7 = AnonymousClass1.aUZ[byVal.ordinal()];
        if (i7 == 1) {
            el(i6);
            return;
        }
        if (i7 == 2) {
            en(i6);
            return;
        }
        if (i7 == 3) {
            eo(i6);
            return;
        }
        if (i7 == 4) {
            ek(i6);
        } else {
            if (i7 == 5) {
                em(i6);
                return;
            }
            throw new PngjException("Filter type " + ((int) b6) + " not implemented");
        }
    }

    private void ek(int i6) {
        int i7 = 1;
        int i8 = 1 - this.aUW.aVh;
        while (i7 <= i6) {
            this.aUU[i7] = (byte) (this.aUt[i7] + (((i8 > 0 ? this.aUU[i8] & 255 : 0) + (this.aUV[i7] & 255)) / 2));
            i7++;
            i8++;
        }
    }

    private void em(int i6) {
        int i7 = 1;
        int i8 = 1 - this.aUW.aVh;
        while (i7 <= i6) {
            int i9 = 0;
            int i10 = i8 > 0 ? this.aUU[i8] & 255 : 0;
            if (i8 > 0) {
                i9 = this.aUV[i8] & 255;
            }
            this.aUU[i7] = (byte) (this.aUt[i7] + n.b(i10, this.aUV[i7] & 255, i9));
            i7++;
            i8++;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final void Od() {
        super.Od();
        this.aUX.update(Og());
        Op();
        p pVar = this.aUX;
        pVar.h(this.aUU, pVar.aVE + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int Oe() {
        return Oq();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aUU = null;
        this.aUV = null;
    }
}
