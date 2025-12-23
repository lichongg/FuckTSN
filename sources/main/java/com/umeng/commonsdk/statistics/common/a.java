package com.umeng.commonsdk.statistics.common;

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
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    private static final class C0828a {

        /* renamed from: a, reason: collision with root package name */
        private final String f41905a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f41906b;

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f41905a;
        }

        public boolean a() {
            return this.f41906b;
        }

        C0828a(String str, boolean z5) {
            this.f41905a = str;
            this.f41906b = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f41907a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f41908b;

        private b() {
            this.f41907a = false;
            this.f41908b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f41907a) {
                throw new IllegalStateException();
            }
            this.f41907a = true;
            return this.f41908b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f41908b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f41909a;

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f41909a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f41909a;
        }

        public c(IBinder iBinder) {
            this.f41909a = iBinder;
        }

        public boolean a(boolean z5) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z5 ? 1 : 0);
                this.f41909a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static String a(Context context) {
        try {
            C0828a c6 = c(context);
            if (c6 != null && !c6.a()) {
                return c6.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0828a c6 = c(context);
            if (c6 == null) {
                return null;
            }
            return c6.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0828a c(Context context) throws Exception {
        AnonymousClass1 anonymousClass1 = null;
        if (Looper.myLooper() == Looper.getMainLooper() || com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
            return null;
        }
        b bVar = new b(anonymousClass1);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    c cVar = new c(bVar.a());
                    boolean a6 = cVar.a(true);
                    String str = "";
                    if (!a6) {
                        str = cVar.a();
                    }
                    C0828a c0828a = new C0828a(str, a6);
                    context.unbindService(bVar);
                    return c0828a;
                } catch (Exception e6) {
                    throw e6;
                }
            } catch (Throwable th) {
                context.unbindService(bVar);
                throw th;
            }
        }
        throw new IOException("Google Play connection failed");
    }
}
