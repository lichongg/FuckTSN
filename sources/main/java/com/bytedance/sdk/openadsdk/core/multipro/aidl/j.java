package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.ae;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.cw;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.m;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.r;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.up;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j.xt;
import com.bytedance.sdk.openadsdk.core.vl;
import com.stub.StubApp;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static volatile j cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f29524j;

    /* renamed from: r, reason: collision with root package name */
    private CountDownLatch f29526r;
    private vl xt;
    private final Object up = new Object();

    /* renamed from: m, reason: collision with root package name */
    private long f29525m = 0;
    private ServiceConnection ae = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.j.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j.this.xt = vl.j.j(iBinder);
            try {
                j.this.xt.asBinder().linkToDeath(j.this.tl, 0);
            } catch (RemoteException e6) {
                com.bytedance.sdk.component.utils.vl.cw("MultiProcess", "onServiceConnected throws :", e6);
            }
            j.this.f29526r.countDown();
            System.currentTimeMillis();
            long unused = j.this.f29525m;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.bytedance.sdk.component.utils.vl.j("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient tl = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.j.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.bytedance.sdk.component.utils.vl.xt("MultiProcess", "binder died.");
            j.this.xt.asBinder().unlinkToDeath(j.this.tl, 0);
            j.this.xt = null;
            j.this.j();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.j$j, reason: collision with other inner class name */
    public static class BinderC0465j extends vl.j {
        @Override // com.bytedance.sdk.openadsdk.core.vl
        public IBinder j(int i6) throws RemoteException {
            if (i6 == 0) {
                return ae.xt();
            }
            if (i6 == 1) {
                return up.xt();
            }
            if (i6 == 2) {
                return cw.xt();
            }
            if (i6 == 3) {
                return xt.xt();
            }
            if (i6 == 4) {
                return r.xt();
            }
            if (i6 != 5) {
                return null;
            }
            return m.xt();
        }
    }

    private j(Context context) {
        this.f29524j = StubApp.getOrigApplicationContext(context.getApplicationContext());
        j();
    }

    public static j j(Context context) {
        if (cw == null) {
            synchronized (j.class) {
                try {
                    if (cw == null) {
                        cw = new j(context);
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    public IBinder j(int i6) {
        try {
            vl vlVar = this.xt;
            if (vlVar != null) {
                return vlVar.j(i6);
            }
            return null;
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        com.bytedance.sdk.component.utils.vl.j("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f29526r = new CountDownLatch(1);
        try {
            this.f29524j.bindService(new Intent(this.f29524j, (Class<?>) BinderPoolService.class), this.ae, 1);
            this.f29525m = System.currentTimeMillis();
            this.f29526r.await();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw("MultiProcess", "connectBinderPoolService throws: ", e6);
        }
    }
}
