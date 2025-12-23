package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzsr extends LazyInstanceMap {
    private zzsr() {
        throw null;
    }

    /* synthetic */ zzsr(zzsq zzsqVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzsb zzsbVar = (zzsb) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzsh(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzsc(StubApp.getOrigApplicationContext(MlKitContext.getInstance().getApplicationContext()), zzsbVar), zzsbVar.zzb());
    }
}
