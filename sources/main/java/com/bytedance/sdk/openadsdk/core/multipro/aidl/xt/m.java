package com.bytedance.sdk.openadsdk.core.multipro.aidl.xt;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.mi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends mi.j {

    /* renamed from: j, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.qv.xt.j f29545j;
    private Handler xt = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
        return jVar != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void cw(final long j6, final long j7, final String str, final String str2) throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        jVar.cw(j6, j7, str, str2);
                    }
                }
            });
        }
    }

    private Handler r() {
        Handler handler = this.xt;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xt = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void xt(final long j6, final long j7, final String str, final String str2) throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        jVar.xt(j6, j7, str, str2);
                    }
                }
            });
        }
    }

    public m(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
        this.f29545j = jVar;
    }

    public void cw() {
        this.f29545j = null;
        this.xt = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void j() throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        jVar.j();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void j(final long j6, final long j7, final String str, final String str2) throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        jVar.j(j6, j7, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void j(final long j6, final String str, final String str2) throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        jVar.j(j6, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.mi
    public void j(final String str, final String str2) throws RemoteException {
        if (this.f29545j != null) {
            r().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.qv.xt.j jVar = m.this.f29545j;
                    if (m.this.j(jVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        jVar.j(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}
