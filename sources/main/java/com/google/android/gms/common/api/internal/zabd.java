package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zabd extends zabw {
    private final WeakReference zaa;

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.zaa.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }

    zabd(zabe zabeVar) {
        this.zaa = new WeakReference(zabeVar);
    }
}
