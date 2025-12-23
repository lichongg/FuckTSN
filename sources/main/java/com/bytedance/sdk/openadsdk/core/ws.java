package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface ws extends IInterface {

    public static abstract class j extends Binder implements ws {

        /* renamed from: com.bytedance.sdk.openadsdk.core.ws$j$j, reason: collision with other inner class name */
        private static class C0498j implements ws {

            /* renamed from: j, reason: collision with root package name */
            public static ws f31299j;
            private IBinder xt;

            @Override // com.bytedance.sdk.openadsdk.core.ws
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                    } else {
                        j.xt().j();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0498j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ws
            public void j(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    obtain.writeString(str);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ws j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ws)) ? new C0498j(iBinder) : (ws) queryLocalInterface;
        }

        public static ws xt() {
            return C0498j.f31299j;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                j();
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            j(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void j() throws RemoteException;

    void j(String str) throws RemoteException;
}
