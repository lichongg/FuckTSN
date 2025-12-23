package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v3 {

    /* renamed from: a, reason: collision with root package name */
    e3 f7463a;

    /* renamed from: b, reason: collision with root package name */
    Context f7464b;

    /* renamed from: c, reason: collision with root package name */
    Messenger f7465c = null;

    public final IBinder a(Intent intent) {
        this.f7463a.w(intent);
        this.f7463a.d(intent);
        Messenger messenger = new Messenger(this.f7463a.s());
        this.f7465c = messenger;
        return messenger.getBinder();
    }

    public final int c() {
        e3 e3Var = this.f7463a;
        return (e3Var == null || e3Var.f5990z.isSelfStartServiceEnable()) ? 3 : 2;
    }

    public final void d() {
        try {
            e3 e3Var = this.f7463a;
            if (e3Var != null) {
                e3Var.s().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }

    public v3(Context context) {
        this.f7463a = null;
        this.f7464b = null;
        this.f7464b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7463a = new e3(this.f7464b);
    }

    public final void b() {
        try {
            e3.E();
            this.f7463a.f5981q = j.b();
            this.f7463a.f5982r = j.a();
            this.f7463a.c();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }
}
