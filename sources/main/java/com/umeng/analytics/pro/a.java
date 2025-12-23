package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface a extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    public static class C0819a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String e(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() throws RemoteException {
            return false;
        }

        @Override // com.umeng.analytics.pro.a
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        static final int f40814a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f40815b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f40816c = 3;

        /* renamed from: d, reason: collision with root package name */
        static final int f40817d = 4;

        /* renamed from: e, reason: collision with root package name */
        static final int f40818e = 5;

        /* renamed from: f, reason: collision with root package name */
        static final int f40819f = 6;

        /* renamed from: g, reason: collision with root package name */
        static final int f40820g = 7;

        /* renamed from: h, reason: collision with root package name */
        private static final String f40821h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.umeng.analytics.pro.a$b$a, reason: collision with other inner class name */
        private static class C0820a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f40822a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f40823b;

            @Override // com.umeng.analytics.pro.a
            public String a(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    obtain.writeString(str);
                    if (this.f40823b.transact(1, obtain, obtain2, 0) || b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.c().a(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    obtain.writeString(str);
                    if (this.f40823b.transact(2, obtain, obtain2, 0) || b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.c().b(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.f40821h;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f40823b;
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    obtain.writeString(str);
                    if (this.f40823b.transact(3, obtain, obtain2, 0) || b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.c().c(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            C0820a(IBinder iBinder) {
                this.f40823b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    obtain.writeString(str);
                    if (!this.f40823b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        readString = b.c().d(str);
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

            @Override // com.umeng.analytics.pro.a
            public String e(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    obtain.writeString(str);
                    if (!this.f40823b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        readString = b.c().e(str);
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

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    if (!this.f40823b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f40821h);
                    if (!this.f40823b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        readString = b.c().b();
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

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f40821h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0820a(iBinder) : (a) queryLocalInterface;
        }

        public static a c() {
            return C0820a.f40822a;
        }

        public b() {
            attachInterface(this, f40821h);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface(f40821h);
                        String a6 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a6);
                        return true;
                    case 2:
                        parcel.enforceInterface(f40821h);
                        String b6 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b6);
                        return true;
                    case 3:
                        parcel.enforceInterface(f40821h);
                        String c6 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c6);
                        return true;
                    case 4:
                        parcel.enforceInterface(f40821h);
                        String d6 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d6);
                        return true;
                    case 5:
                        parcel.enforceInterface(f40821h);
                        String e6 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e6);
                        return true;
                    case 6:
                        parcel.enforceInterface(f40821h);
                        boolean a7 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a7 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(f40821h);
                        String b7 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b7);
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString(f40821h);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0820a.f40822a != null || aVar == null) {
                return false;
            }
            C0820a.f40822a = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;
}
