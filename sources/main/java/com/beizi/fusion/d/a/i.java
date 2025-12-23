package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.f;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f13397a = new LinkedBlockingQueue<>(1);

    /* renamed from: b, reason: collision with root package name */
    ServiceConnection f13398b = new ServiceConnection() { // from class: com.beizi.fusion.d.a.i.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                i.this.f13397a.put(iBinder);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private Context f13399c;

    public void a(b.a aVar) {
        try {
            this.f13399c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f13399c.bindService(intent, this.f13398b, 1)) {
            try {
                String a6 = new f.a(this.f13397a.take()).a();
                if (aVar != null) {
                    aVar.a(a6);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public i(Context context) {
        this.f13399c = context;
    }
}
