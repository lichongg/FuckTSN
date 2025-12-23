package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    com.beizi.fusion.d.b.c f13379a;

    /* renamed from: b, reason: collision with root package name */
    ServiceConnection f13380b = new ServiceConnection() { // from class: com.beizi.fusion.d.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f13379a = new c.a.C0130a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private Context f13381c;

    public void a(b.a aVar) {
        com.beizi.fusion.d.b.c cVar;
        this.f13381c.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f13381c.bindService(intent, this.f13380b, 1) || (cVar = this.f13379a) == null) {
            return;
        }
        String a6 = cVar.a();
        if (aVar != null) {
            aVar.a(a6);
        }
    }

    public d(Context context) {
        this.f13381c = context;
    }
}
