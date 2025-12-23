package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class e extends IOnResultCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnResultCallback f33745a;

    /* renamed from: b, reason: collision with root package name */
    private String f33746b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33747c;

    @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        HmsScan hmsScan;
        o4.d("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f33747c);
        if (this.f33747c) {
            this.f33745a.onResult(hmsScanArr);
            return;
        }
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.equals(this.f33746b, hmsScan.getOriginalValue())) {
            return;
        }
        this.f33746b = hmsScanArr[0].getOriginalValue();
        o4.d("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f33747c);
        this.f33745a.onResult(hmsScanArr);
    }

    e(OnResultCallback onResultCallback, boolean z5) {
        this.f33745a = onResultCallback;
        this.f33747c = z5;
    }
}
