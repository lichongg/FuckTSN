package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface jy extends IInterface {

    public static abstract class j extends Binder implements jy {

        /* renamed from: com.bytedance.sdk.openadsdk.core.jy$j$j, reason: collision with other inner class name */
        private static class C0461j implements jy {

            /* renamed from: j, reason: collision with root package name */
            public static jy f29253j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0461j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.jy
            public void cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.r() != null) {
                        j.r().cw();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jy
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.r() != null) {
                        j.r().j();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jy
            public void xt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.r() != null) {
                        j.r().xt();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static jy j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jy)) ? new C0461j(iBinder) : (jy) queryLocalInterface;
        }

        public static jy r() {
            return C0461j.f29253j;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                j();
                parcel2.writeNoException();
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                xt();
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            cw();
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void cw() throws RemoteException;

    void j() throws RemoteException;

    void xt() throws RemoteException;
}
