package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzwu extends LazyInstanceMap {
    private zzwu() {
        throw null;
    }

    /* synthetic */ zzwu(zzwt zzwtVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzwd zzwdVar = (zzwd) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzwk(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzwe(StubApp.getOrigApplicationContext(MlKitContext.getInstance().getApplicationContext()), zzwdVar), zzwdVar.zzb());
    }
}
