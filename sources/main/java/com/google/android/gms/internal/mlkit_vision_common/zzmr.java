package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzmr extends LazyInstanceMap {
    private zzmr() {
    }

    /* synthetic */ zzmr(zzmq zzmqVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzme zzmeVar = (zzme) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzmj(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzmf(StubApp.getOrigApplicationContext(MlKitContext.getInstance().getApplicationContext()), zzmeVar), zzmeVar.zzb());
    }
}
