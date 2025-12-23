package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface az extends IInterface {

    public static abstract class j extends Binder implements az {

        /* renamed from: com.bytedance.sdk.openadsdk.core.az$j$j, reason: collision with other inner class name */
        private static class C0433j implements az {

            /* renamed from: j, reason: collision with root package name */
            public static az f27966j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0433j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().cw();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().m();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().r();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void up() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().up();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.az
            public void xt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().xt();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static az ae() {
            return C0433j.f27966j;
        }

        public static az j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof az)) ? new C0433j(iBinder) : (az) queryLocalInterface;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        j();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        xt();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        cw();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        r();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        up();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        m();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void cw() throws RemoteException;

    void j() throws RemoteException;

    void m() throws RemoteException;

    void r() throws RemoteException;

    void up() throws RemoteException;

    void xt() throws RemoteException;
}
