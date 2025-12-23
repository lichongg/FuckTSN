package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.g;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    Context f13408a;

    /* renamed from: b, reason: collision with root package name */
    String f13409b = "com.mdid.msa";

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f13410c = new LinkedBlockingQueue<>(1);

    /* renamed from: d, reason: collision with root package name */
    ServiceConnection f13411d = new ServiceConnection() { // from class: com.beizi.fusion.d.a.l.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l.this.f13410c.put(iBinder);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private int a() {
        try {
            this.f13408a.getPackageManager().getPackageInfo(this.f13409b, 0);
            return 1;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public l(Context context) {
        this.f13408a = context;
    }

    private void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.f13409b, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f13408a.startService(intent);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(b.a aVar) {
        try {
            this.f13408a.getPackageManager().getPackageInfo(this.f13409b, 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        String packageName = this.f13408a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        if (this.f13408a.bindService(intent, this.f13411d, 1)) {
            try {
                String a6 = new g.a.C0133a(this.f13410c.take()).a();
                if (aVar != null) {
                    aVar.a(a6);
                }
                this.f13408a.unbindService(this.f13411d);
            } catch (Exception e7) {
                e7.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
