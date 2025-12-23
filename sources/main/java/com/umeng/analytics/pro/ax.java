package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ax implements av {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40925a = "Coolpad";

    /* renamed from: b, reason: collision with root package name */
    private static final String f40926b = "com.coolpad.deviceidsupport";

    /* renamed from: c, reason: collision with root package name */
    private static final String f40927c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d, reason: collision with root package name */
    private static a f40928d;

    /* renamed from: f, reason: collision with root package name */
    private CountDownLatch f40930f;

    /* renamed from: g, reason: collision with root package name */
    private Context f40931g;

    /* renamed from: e, reason: collision with root package name */
    private String f40929e = "";

    /* renamed from: h, reason: collision with root package name */
    private final ServiceConnection f40932h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ax.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = ax.f40928d = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ax.f40928d = a.b.a(iBinder);
                ax.this.f40929e = ax.f40928d.b(ax.this.f40931g.getPackageName());
                String unused2 = ax.this.f40929e;
            } catch (RemoteException | NullPointerException e6) {
                e6.getMessage();
            }
            ax.this.f40930f.countDown();
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f40926b, f40927c));
            context.bindService(intent, this.f40932h, 1);
        } catch (Throwable th) {
            th.getMessage();
            this.f40930f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f40932h);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f40931g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f40930f = new CountDownLatch(1);
        try {
            b(context);
            this.f40930f.await(500L, TimeUnit.MILLISECONDS);
            return this.f40929e;
        } catch (InterruptedException e6) {
            e6.getMessage();
            return null;
        } finally {
            c(context);
        }
    }
}
