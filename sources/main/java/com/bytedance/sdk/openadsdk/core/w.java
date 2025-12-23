package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface w extends IInterface {

    public static abstract class j extends Binder implements w {

        /* renamed from: com.bytedance.sdk.openadsdk.core.w$j$j, reason: collision with other inner class name */
        private static class C0496j implements w {

            /* renamed from: j, reason: collision with root package name */
            public static w f31160j;
            private IBinder xt;

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.tl() == null) {
                        obtain2.readException();
                    } else {
                        j.tl().j();
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

            C0496j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void ae() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(9, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().ae();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().cw();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().m();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().r();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void up() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().up();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void xt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().xt();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void j(boolean z5, int i6, String str, int i7, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    obtain.writeInt(z5 ? 1 : 0);
                    obtain.writeInt(i6);
                    obtain.writeString(str);
                    obtain.writeInt(i7);
                    obtain.writeString(str2);
                    if (!this.xt.transact(7, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().j(z5, i6, str, i7, str2);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void j(boolean z5, int i6, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    obtain.writeInt(z5 ? 1 : 0);
                    obtain.writeInt(i6);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(8, obtain, obtain2, 0) && j.tl() != null) {
                        j.tl().j(z5, i6, bundle);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static w j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new C0496j(iBinder) : (w) queryLocalInterface;
        }

        public static w tl() {
            return C0496j.f31160j;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            boolean z5;
            Bundle bundle;
            if (i6 != 1598968902) {
                boolean z6 = false;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        j();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        xt();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        cw();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        r();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        up();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        m();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        if (parcel.readInt() != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        j(z5, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        if (parcel.readInt() != 0) {
                            z6 = true;
                        }
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        } else {
                            bundle = null;
                        }
                        j(z6, readInt, bundle);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        ae();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void ae() throws RemoteException;

    void cw() throws RemoteException;

    void j() throws RemoteException;

    void j(boolean z5, int i6, Bundle bundle) throws RemoteException;

    void j(boolean z5, int i6, String str, int i7, String str2) throws RemoteException;

    void m() throws RemoteException;

    void r() throws RemoteException;

    void up() throws RemoteException;

    void xt() throws RemoteException;
}
