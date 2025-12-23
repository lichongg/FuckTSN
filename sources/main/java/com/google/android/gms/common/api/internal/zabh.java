package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zabh extends com.google.android.gms.internal.base.zau {
    final /* synthetic */ zabi zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zabh(zabi zabiVar, Looper looper) {
        super(looper);
        this.zaa = zabiVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i6 = message.what;
        if (i6 == 1) {
            ((zabg) message.obj).zab(this.zaa);
        } else if (i6 == 2) {
            throw ((RuntimeException) message.obj);
        }
    }
}
