package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface i extends IInterface {

    public static abstract class j extends Binder implements i {

        /* renamed from: com.bytedance.sdk.openadsdk.core.i$j$j, reason: collision with other inner class name */
        private static class C0459j implements i {

            /* renamed from: j, reason: collision with root package name */
            public static i f29137j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0459j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.i
            public Bundle j(int i6) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        bundle = j.j().j(i6);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0459j(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            Bundle j6 = j(parcel.readInt());
            parcel2.writeNoException();
            if (j6 != null) {
                parcel2.writeInt(1);
                j6.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
        }

        public static i j() {
            return C0459j.f29137j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    Bundle j(int i6) throws RemoteException;
}
