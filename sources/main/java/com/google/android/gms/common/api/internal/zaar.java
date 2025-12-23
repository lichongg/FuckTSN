package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {
    private final WeakReference zaa;

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zabi zabiVar;
        zaaw zaawVar = (zaaw) this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        zabiVar = zaawVar.zaa;
        zabiVar.zal(new zaaq(this, zaawVar, zaawVar, zakVar));
    }

    zaar(zaaw zaawVar) {
        this.zaa = new WeakReference(zaawVar);
    }
}
