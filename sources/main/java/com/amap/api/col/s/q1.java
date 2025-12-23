package com.amap.api.col.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f8359a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8360b;

        public final boolean b() {
            return this.f8360b;
        }

        a(String str, boolean z5) {
            this.f8359a = str;
            this.f8360b = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f8361a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f8362b;

        private b() {
            this.f8361a = false;
            this.f8362b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (this.f8361a) {
                throw new IllegalStateException();
            }
            this.f8361a = true;
            return this.f8362b.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8362b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        /* synthetic */ b(byte b6) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f8363a;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f8363a;
        }

        public c(IBinder iBinder) {
            this.f8363a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f8363a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z5 = true;
                obtain.writeInt(1);
                this.f8363a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z5 = false;
                }
                return z5;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static String a(Context context) {
        try {
            a b6 = b(context);
            if (b6 != null && !b6.b()) {
                return b6.f8359a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static a b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        b bVar = new b((byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (context.bindService(intent, bVar, 1)) {
                try {
                    c cVar = new c(bVar.a());
                    boolean b6 = cVar.b();
                    String str = "";
                    if (!b6) {
                        str = cVar.a();
                    }
                    a aVar = new a(str, b6);
                    context.unbindService(bVar);
                    return aVar;
                } catch (Exception e6) {
                    throw e6;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Throwable th) {
            context.unbindService(bVar);
            throw th;
        }
    }
}
