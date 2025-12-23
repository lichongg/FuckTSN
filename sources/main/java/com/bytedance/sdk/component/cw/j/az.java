package com.bytedance.sdk.component.cw.j;

/* loaded from: D:\Downloads\app\classes4.dex */
final class az {
    az ae;
    int cw;

    /* renamed from: j, reason: collision with root package name */
    final byte[] f26084j;

    /* renamed from: m, reason: collision with root package name */
    az f26085m;

    /* renamed from: r, reason: collision with root package name */
    boolean f26086r;
    boolean up;
    int xt;

    az() {
        this.f26084j = new byte[8192];
        this.up = true;
        this.f26086r = false;
    }

    final az j() {
        this.f26086r = true;
        return new az(this.f26084j, this.xt, this.cw, true, false);
    }

    public final void cw() {
        az azVar = this.ae;
        if (azVar == this) {
            throw new IllegalStateException();
        }
        if (azVar.up) {
            int i6 = this.cw - this.xt;
            if (i6 > (8192 - azVar.cw) + (azVar.f26086r ? 0 : azVar.xt)) {
                return;
            }
            j(azVar, i6);
            xt();
            av.j(this);
        }
    }

    public final az xt() {
        az azVar = this.f26085m;
        az azVar2 = azVar != this ? azVar : null;
        az azVar3 = this.ae;
        if (azVar3 != null) {
            azVar3.f26085m = azVar;
        }
        az azVar4 = this.f26085m;
        if (azVar4 != null) {
            azVar4.ae = azVar3;
        }
        this.f26085m = null;
        this.ae = null;
        return azVar2;
    }

    public final az j(az azVar) {
        azVar.ae = this;
        azVar.f26085m = this.f26085m;
        this.f26085m.ae = azVar;
        this.f26085m = azVar;
        return azVar;
    }

    az(byte[] bArr, int i6, int i7, boolean z5, boolean z6) {
        this.f26084j = bArr;
        this.xt = i6;
        this.cw = i7;
        this.f26086r = z5;
        this.up = z6;
    }

    public final az j(int i6) {
        az j6;
        if (i6 > 0 && i6 <= this.cw - this.xt) {
            if (i6 >= 1024) {
                j6 = j();
            } else {
                j6 = av.j();
                System.arraycopy(this.f26084j, this.xt, j6.f26084j, 0, i6);
            }
            j6.cw = j6.xt + i6;
            this.xt += i6;
            this.ae.j(j6);
            return j6;
        }
        throw new IllegalArgumentException();
    }

    public final void j(az azVar, int i6) {
        if (azVar.up) {
            int i7 = azVar.cw;
            if (i7 + i6 > 8192) {
                if (!azVar.f26086r) {
                    int i8 = azVar.xt;
                    if ((i7 + i6) - i8 <= 8192) {
                        byte[] bArr = azVar.f26084j;
                        System.arraycopy(bArr, i8, bArr, 0, i7 - i8);
                        azVar.cw -= azVar.xt;
                        azVar.xt = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f26084j, this.xt, azVar.f26084j, azVar.cw, i6);
            azVar.cw += i6;
            this.xt += i6;
            return;
        }
        throw new IllegalArgumentException();
    }
}
