package com.snail.antifake;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IEmulatorCheck extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IEmulatorCheck {

        /* renamed from: a, reason: collision with root package name */
        private static final String f37515a = "com.snail.antifake.IEmulatorCheck";

        /* renamed from: b, reason: collision with root package name */
        static final int f37516b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f37517c = 2;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class a implements IEmulatorCheck {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f37518a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f37518a;
            }

            public String e() {
                return Stub.f37515a;
            }

            a(IBinder iBinder) {
                this.f37518a = iBinder;
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public boolean w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f37515a);
                    boolean z5 = false;
                    this.f37518a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public void x() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f37515a);
                    this.f37518a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IEmulatorCheck e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f37515a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IEmulatorCheck)) ? new a(iBinder) : (IEmulatorCheck) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface(f37515a);
                boolean w5 = w();
                parcel2.writeNoException();
                parcel2.writeInt(w5 ? 1 : 0);
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString(f37515a);
                return true;
            }
            parcel.enforceInterface(f37515a);
            x();
            parcel2.writeNoException();
            return true;
        }

        public Stub() {
            attachInterface(this, f37515a);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    boolean w() throws RemoteException;

    void x() throws RemoteException;
}
