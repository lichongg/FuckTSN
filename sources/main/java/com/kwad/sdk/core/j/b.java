package com.kwad.sdk.core.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b implements c {
    private boolean aMM = false;
    private boolean Rj = false;
    private boolean Rk = false;

    protected abstract void aK();

    protected abstract void aL();

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        this.aMM = true;
        if (this.Rk) {
            return;
        }
        aK();
        this.Rk = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        if (this.aMM && !this.Rj) {
            aL();
            this.Rj = true;
        }
    }
}
