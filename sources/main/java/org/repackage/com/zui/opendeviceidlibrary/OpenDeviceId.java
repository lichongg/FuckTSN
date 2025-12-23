package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class OpenDeviceId {

    /* renamed from: c, reason: collision with root package name */
    private static String f51687c = "OpenDeviceId library";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f51688d;

    /* renamed from: b, reason: collision with root package name */
    private IDeviceidInterface f51690b;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f51691e;

    /* renamed from: a, reason: collision with root package name */
    private Context f51689a = null;

    /* renamed from: f, reason: collision with root package name */
    private CallBack f51692f = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CallBack<T> {
        void a(T t5, OpenDeviceId openDeviceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private void b(String str) {
    }

    public boolean c() {
        try {
            if (this.f51690b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f51690b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String b() {
        if (this.f51689a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f51690b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.b();
            }
            return null;
        } catch (RemoteException e6) {
            b("getUDID error, RemoteException!");
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            b("getUDID error, Exception!");
            e7.printStackTrace();
            return null;
        }
    }

    public String d() {
        Context context = this.f51689a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f51690b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a(packageName);
            }
            return null;
        } catch (RemoteException e6) {
            b("getVAID error, RemoteException!");
            e6.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.f51689a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        String str = null;
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            IDeviceidInterface iDeviceidInterface = this.f51690b;
            return (iDeviceidInterface == null || !(((str = iDeviceidInterface.b(packageName)) == null || "".equals(str)) && this.f51690b.c(packageName))) ? str : this.f51690b.b(packageName);
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return str;
        }
    }

    public void f() {
        try {
            this.f51689a.unbindService(this.f51691e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f51690b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f51689a = context;
            this.f51692f = callBack;
            this.f51691e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        OpenDeviceId.this.f51690b = IDeviceidInterface.Stub.a(iBinder);
                        if (OpenDeviceId.this.f51692f != null) {
                            OpenDeviceId.this.f51692f.a("Deviceid Service Connected", OpenDeviceId.this);
                        }
                        OpenDeviceId.this.a("Service onServiceConnected");
                    } catch (Throwable th) {
                        throw th;
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.f51690b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f51689a.bindService(intent, this.f51691e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        if (this.f51689a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f51690b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e6) {
                b("getOAID error, RemoteException!");
                e6.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z5) {
        f51688d = z5;
    }
}
