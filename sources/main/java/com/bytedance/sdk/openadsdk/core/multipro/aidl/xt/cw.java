package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.az;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends az.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.x.j.xt.j.j f29535j;
    private Handler xt = new Handler(Looper.getMainLooper());

    private void tl() {
        this.f29535j = null;
        this.xt = null;
    }

    private Handler g() {
        Handler handler = this.xt;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xt = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void j() throws RemoteException {
        tl();
    }

    public cw(com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar) {
        this.f29535j = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void cw() throws RemoteException {
        g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = cw.this.f29535j;
                if (jVar != null) {
                    jVar.xt();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void m() throws RemoteException {
        g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = cw.this.f29535j;
                if (jVar != null) {
                    jVar.up();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void r() throws RemoteException {
        g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = cw.this.f29535j;
                if (jVar != null) {
                    jVar.cw();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void up() throws RemoteException {
        g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = cw.this.f29535j;
                if (jVar != null) {
                    jVar.r();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.az
    public void xt() throws RemoteException {
        g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.cw.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = cw.this.f29535j;
                if (jVar != null) {
                    jVar.j();
                }
            }
        });
    }
}
