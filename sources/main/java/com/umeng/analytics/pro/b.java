package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface b extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String a(String str) throws RemoteException {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0821b extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        static final int f40942a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f40943b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f40944c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final String f40945d = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        private static class a implements b {

            /* renamed from: a, reason: collision with root package name */
            public static b f40946a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f40947b;

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0821b.f40945d);
                    if (this.f40947b.transact(1, obtain, obtain2, 0) || AbstractBinderC0821b.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0821b.b().a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String b() {
                return AbstractBinderC0821b.f40945d;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f40947b;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0821b.f40945d);
                    obtain.writeString(str);
                    if (this.f40947b.transact(3, obtain, obtain2, 0) || AbstractBinderC0821b.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0821b.b().b(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            a(IBinder iBinder) {
                this.f40947b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0821b.f40945d);
                    obtain.writeString(str);
                    if (!this.f40947b.transact(2, obtain, obtain2, 0) && AbstractBinderC0821b.b() != null) {
                        readString = AbstractBinderC0821b.b().a(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f40945d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static b b() {
            return a.f40946a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface(f40945d);
                String a6 = a();
                parcel2.writeNoException();
                parcel2.writeString(a6);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface(f40945d);
                String a7 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a7);
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString(f40945d);
                return true;
            }
            parcel.enforceInterface(f40945d);
            String b6 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b6);
            return true;
        }

        public AbstractBinderC0821b() {
            attachInterface(this, f40945d);
        }

        public static boolean a(b bVar) {
            if (a.f40946a != null || bVar == null) {
                return false;
            }
            a.f40946a = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;
}
