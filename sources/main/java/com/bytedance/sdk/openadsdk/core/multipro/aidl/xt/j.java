package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.jy;
import com.bytedance.sdk.openadsdk.core.rn.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends jy.j {

    /* renamed from: j, reason: collision with root package name */
    private Handler f29541j = new Handler(Looper.getMainLooper());
    private m.j xt;

    @Override // com.bytedance.sdk.openadsdk.core.jy
    public void cw() throws RemoteException {
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.xt != null) {
                    j.this.xt.onDialogCancel();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.jy
    public void j() throws RemoteException {
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.xt != null) {
                    j.this.xt.onDialogBtnYes();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.jy
    public void xt() throws RemoteException {
        j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.j.2
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.xt != null) {
                    j.this.xt.onDialogBtnNo();
                }
            }
        });
    }

    public j(m.j jVar) {
        this.xt = jVar;
    }

    private void j(Runnable runnable) {
        this.f29541j.post(runnable);
    }
}
