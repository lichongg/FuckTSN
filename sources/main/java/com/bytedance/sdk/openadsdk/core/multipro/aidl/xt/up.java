package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.w;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends w.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.a.j.xt.j.j f29558j;
    private Handler xt = new Handler(Looper.getMainLooper());

    private void g() {
        this.f29558j = null;
        this.xt = null;
    }

    private Handler oq() {
        Handler handler = this.xt;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xt = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void j() throws RemoteException {
        g();
    }

    public up(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        this.f29558j = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void ae() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.m();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void cw() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.xt();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void j(final boolean z5, final int i6, final String str, final int i7, final String str2) throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.j(z5, i6, str, i7, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void m() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.up();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void r() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.cw();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void up() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.r();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void xt() throws RemoteException {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar != null) {
                    jVar.j();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.w
    public void j(final boolean z5, final int i6, final Bundle bundle) {
        oq().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.up.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = up.this.f29558j;
                if (jVar == null || h.xt < 4400) {
                    return;
                }
                try {
                    jVar.j(z5, i6, bundle);
                } catch (AbstractMethodError unused) {
                    vl.r("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}
