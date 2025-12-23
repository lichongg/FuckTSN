package com.kwad.sdk.pngencrypt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class p {
    int aUG;
    int aUJ;
    int aUK;
    int aUL;
    int aUM;
    public final k aUW;
    public final e aUa;
    int aVA;
    int aVB;
    int aVC;
    int aVD;
    int aVE;
    int aVF;
    public final boolean aVy;
    int aVz;
    byte[] buf;

    final void h(byte[] bArr, int i6) {
        this.buf = bArr;
        this.aVF = i6;
    }

    final void update(int i6) {
        this.aVz = i6;
        if (!this.aVy) {
            this.aUG = 1;
            this.aUJ = 1;
            this.aUK = 1;
            this.aUL = 0;
            this.aUM = 0;
            this.aVB = i6;
            this.aVA = i6;
            k kVar = this.aUW;
            this.aVC = kVar.aUH;
            this.aVD = kVar.aUI;
            this.aVE = kVar.aVi;
            return;
        }
        this.aUG = this.aUa.Ok();
        e eVar = this.aUa;
        this.aUK = eVar.aUK;
        this.aUJ = eVar.aUJ;
        this.aUM = eVar.aUM;
        this.aUL = eVar.aUL;
        this.aVA = eVar.Oj();
        this.aVB = this.aUa.Oi();
        this.aVC = this.aUa.Ol();
        int Om = this.aUa.Om();
        this.aVD = Om;
        this.aVE = ((this.aUW.aVg * Om) + 7) / 8;
    }

    public p(k kVar, e eVar) {
        boolean z5;
        this.aUW = kVar;
        this.aUa = eVar;
        if (eVar != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.aVy = z5;
    }
}
