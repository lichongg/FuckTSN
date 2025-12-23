package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface jy extends IInterface {
    void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    public static abstract class j extends Binder implements jy {

        /* renamed from: com.ss.android.socialbase.downloader.r.jy$j$j, reason: collision with other inner class name */
        private static class C0796j implements jy {

            /* renamed from: j, reason: collision with root package name */
            public static jy f38971j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0796j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.jy
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.jy
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    boolean z5 = true;
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        boolean xt = j.j().xt(cwVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return xt;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z5 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static jy j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jy)) ? new C0796j(iBinder) : (jy) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                j(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            boolean xt = xt(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(xt ? 1 : 0);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
        }

        public static jy j() {
            return C0796j.f38971j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
