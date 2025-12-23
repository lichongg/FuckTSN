package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f13368a = new LinkedBlockingQueue<>(1);

    /* renamed from: b, reason: collision with root package name */
    ServiceConnection f13369b = new ServiceConnection() { // from class: com.beizi.fusion.d.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f13368a.put(iBinder);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private Context f13370c;

    public void a(b.a aVar) {
        try {
            this.f13370c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f13370c.bindService(intent, this.f13369b, 1)) {
            try {
                String a6 = new a.C0129a(this.f13368a.take()).a();
                if (aVar != null) {
                    aVar.a(a6);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public a(Context context) {
        this.f13370c = context;
    }
}
