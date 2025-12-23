package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface mi extends IInterface {

    public static abstract class j extends Binder implements mi {

        /* renamed from: com.bytedance.sdk.openadsdk.core.mi$j$j, reason: collision with other inner class name */
        private static class C0464j implements mi {

            /* renamed from: j, reason: collision with root package name */
            public static mi f29521j;
            private IBinder xt;

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
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

            C0464j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void cw(long j6, long j7, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j6);
                    obtain.writeLong(j7);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().cw(j6, j7, str, str2);
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

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void xt(long j6, long j7, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j6);
                    obtain.writeLong(j7);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().xt(j6, j7, str, str2);
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

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void j(long j6, long j7, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j6);
                    obtain.writeLong(j7);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(j6, j7, str, str2);
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

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void j(long j6, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j6);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(j6, str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.mi
            public void j(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static mi j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mi)) ? new C0464j(iBinder) : (mi) queryLocalInterface;
        }

        public static mi xt() {
            return C0464j.f29521j;
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        j();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        j(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        xt(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        cw(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        j(parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        j(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void cw(long j6, long j7, String str, String str2) throws RemoteException;

    void j() throws RemoteException;

    void j(long j6, long j7, String str, String str2) throws RemoteException;

    void j(long j6, String str, String str2) throws RemoteException;

    void j(String str, String str2) throws RemoteException;

    void xt(long j6, long j7, String str, String str2) throws RemoteException;
}
