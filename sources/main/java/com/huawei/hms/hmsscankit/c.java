package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class c extends IOnErrorCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnErrorCallback f33743a;

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i6) throws RemoteException {
        if (this.f33743a != null) {
            this.f33743a.onError(i6);
        }
    }

    c(OnErrorCallback onErrorCallback) {
        this.f33743a = onErrorCallback;
    }
}
