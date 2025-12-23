package com.kwad.sdk.core.network.idc.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private final long aFD;
    private volatile boolean aFE = false;

    public final a bq(boolean z5) {
        this.aFE = true;
        return this;
    }

    public final boolean HJ() {
        return this.aFE;
    }

    public final long HK() {
        return this.aFD;
    }

    public a(long j6, boolean z5) {
        this.aFD = j6;
    }
}
