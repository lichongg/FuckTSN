package cn.jiguang.ae;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.bb.f;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f1491a = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f1491a.put(iBinder);
        } catch (Throwable th) {
            f.i("SumsungSericeConnection", "service connect error: " + th.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
