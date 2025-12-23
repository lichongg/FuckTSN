package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f51577a;

    public b(c cVar) {
        this.f51577a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f51577a.f51578a = a.AbstractBinderC0997a.a(iBinder);
        synchronized (this.f51577a.f51581d) {
            this.f51577a.f51581d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f51577a.f51578a = null;
    }
}
