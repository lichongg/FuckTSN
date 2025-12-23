package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zad extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ Activity zab;
    final /* synthetic */ int zac;

    zad(Intent intent, Activity activity, int i6) {
        this.zaa = intent;
        this.zab = activity;
        this.zac = i6;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
