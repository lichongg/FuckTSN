package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface qv extends IInterface {

    public static abstract class j extends Binder implements qv {

        /* renamed from: com.ss.android.socialbase.downloader.r.qv$j$j, reason: collision with other inner class name */
        private static class C0800j implements qv {

            /* renamed from: j, reason: collision with root package name */
            public static qv f38975j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.r.qv
            public void j(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    obtain.writeString(str);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.cw() == null) {
                        obtain2.readException();
                    } else {
                        j.cw().j(str);
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

            C0800j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.qv
            public int[] xt() throws RemoteException {
                int[] createIntArray;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.cw() != null) {
                        createIntArray = j.cw().xt();
                    } else {
                        obtain2.readException();
                        createIntArray = obtain2.createIntArray();
                    }
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.qv
            public String j() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.cw() != null) {
                        readString = j.cw().j();
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

        public static qv cw() {
            return C0800j.f38975j;
        }

        public static qv j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qv)) ? new C0800j(iBinder) : (qv) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                j(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String j6 = j();
                parcel2.writeNoException();
                parcel2.writeString(j6);
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] xt = xt();
            parcel2.writeNoException();
            parcel2.writeIntArray(xt);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    String j() throws RemoteException;

    void j(String str) throws RemoteException;

    int[] xt() throws RemoteException;
}
