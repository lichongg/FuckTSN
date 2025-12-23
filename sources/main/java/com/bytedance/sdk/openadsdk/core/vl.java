package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface vl extends IInterface {

    public static abstract class j extends Binder implements vl {

        /* renamed from: com.bytedance.sdk.openadsdk.core.vl$j$j, reason: collision with other inner class name */
        private static class C0495j implements vl {

            /* renamed from: j, reason: collision with root package name */
            public static vl f31157j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0495j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.vl
            public IBinder j(int i6) throws RemoteException {
                IBinder readStrongBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        readStrongBinder = j.j().j(i6);
                    } else {
                        obtain2.readException();
                        readStrongBinder = obtain2.readStrongBinder();
                    }
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static vl j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof vl)) ? new C0495j(iBinder) : (vl) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder j6 = j(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(j6);
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static vl j() {
            return C0495j.f31157j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    IBinder j(int i6) throws RemoteException;
}
