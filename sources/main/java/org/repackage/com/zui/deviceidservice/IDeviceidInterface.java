package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface IDeviceidInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a, reason: collision with root package name */
        static final int f51673a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f51674b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f51675c = 3;

        /* renamed from: d, reason: collision with root package name */
        static final int f51676d = 4;

        /* renamed from: e, reason: collision with root package name */
        static final int f51677e = 5;

        /* renamed from: f, reason: collision with root package name */
        static final int f51678f = 6;

        /* renamed from: g, reason: collision with root package name */
        private static final String f51679g = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IDeviceidInterface {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f51680a;

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    this.f51680a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    this.f51680a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    this.f51680a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f51680a;
            }

            public String d() {
                return Stub.f51679g;
            }

            Proxy(IBinder iBinder) {
                this.f51680a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    obtain.writeString(str);
                    this.f51680a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    obtain.writeString(str);
                    this.f51680a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f51679g);
                    obtain.writeString(str);
                    this.f51680a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IDeviceidInterface a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f51679g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        public Stub() {
            attachInterface(this, f51679g);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface(f51679g);
                        String a6 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a6);
                        return true;
                    case 2:
                        parcel.enforceInterface(f51679g);
                        String b6 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b6);
                        return true;
                    case 3:
                        parcel.enforceInterface(f51679g);
                        boolean c6 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c6 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(f51679g);
                        String a7 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a7);
                        return true;
                    case 5:
                        parcel.enforceInterface(f51679g);
                        String b7 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b7);
                        return true;
                    case 6:
                        parcel.enforceInterface(f51679g);
                        boolean c7 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c7 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString(f51679g);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;
}
