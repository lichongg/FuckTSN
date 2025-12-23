package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.rn.ae;
import com.bytedance.sdk.openadsdk.core.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends ws.j {

    /* renamed from: j, reason: collision with root package name */
    private Handler f29570j = new Handler(Looper.getMainLooper());
    private ae.j xt;

    @Override // com.bytedance.sdk.openadsdk.core.ws
    public void j() throws RemoteException {
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.xt.1
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.xt != null) {
                    xt.this.xt.onGranted();
                }
            }
        });
    }

    public xt(ae.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ws
    public void j(final String str) throws RemoteException {
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.xt.2
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.xt != null) {
                    xt.this.xt.onDenied(str);
                }
            }
        });
    }

    private void j(Runnable runnable) {
        if (this.f29570j == null) {
            this.f29570j = new Handler(Looper.getMainLooper());
        }
        this.f29570j.post(runnable);
    }
}
