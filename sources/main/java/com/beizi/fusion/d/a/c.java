package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.b;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f13375a = new LinkedBlockingQueue<>(1);

    /* renamed from: b, reason: collision with root package name */
    ServiceConnection f13376b = new ServiceConnection() { // from class: com.beizi.fusion.d.a.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.f13375a.put(iBinder);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private Context f13377c;

    public void a(b.a aVar) {
        try {
            this.f13377c.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.f13377c.bindService(intent, this.f13376b, 1)) {
                try {
                    b.a aVar2 = new b.a(this.f13375a.take());
                    String a6 = aVar2.a();
                    aVar2.b();
                    if (aVar != null) {
                        aVar.a(a6);
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        } finally {
            this.f13377c.unbindService(this.f13376b);
        }
    }

    public c(Context context) {
        this.f13377c = context;
    }
}
