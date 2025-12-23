package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class d extends IOnLightCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnLightVisibleCallBack f33744a;

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z5) throws RemoteException {
        this.f33744a.onVisibleChanged(z5);
    }

    d(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.f33744a = onLightVisibleCallBack;
    }
}
