package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.asus.push.IAIDLInvoke;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes2.dex */
final class e implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f3667a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f3668b;

    private e(d dVar) {
        this.f3668b = dVar;
        this.f3667a = new LinkedBlockingQueue<>(1);
    }

    /* synthetic */ e(d dVar, byte b6) {
        this(dVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            a.f3665a.set(false);
            cn.jpush.android.i.b.b("ServiceConnection", "onServiceConnected:" + componentName);
            if (iBinder != null) {
                this.f3667a.put(iBinder);
            } else {
                cn.jpush.android.i.b.g("ServiceConnection", "onServiceConnected, but IBinder is null.");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a.f3665a.set(false);
        d.a(this.f3668b, (IAIDLInvoke) null);
        cn.jpush.android.i.b.g("ServiceConnection", "onServiceDisconnected:" + componentName);
    }
}
