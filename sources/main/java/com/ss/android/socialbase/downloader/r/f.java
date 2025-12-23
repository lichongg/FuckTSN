package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface f extends IInterface {

    public static abstract class j extends Binder implements f {

        /* renamed from: com.ss.android.socialbase.downloader.r.f$j$j, reason: collision with other inner class name */
        private static class C0792j implements f {

            /* renamed from: j, reason: collision with root package name */
            public static f f38966j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.r.f
            public void j(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    obtain.writeStringList(list);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                    } else {
                        j.xt().j(list);
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

            C0792j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.f
            public boolean j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.xt() != null) {
                        return j.xt().j();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static f j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0792j(iBinder) : (f) queryLocalInterface;
        }

        public static f xt() {
            return C0792j.f38966j;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                j(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean j6 = j();
            parcel2.writeNoException();
            parcel2.writeInt(j6 ? 1 : 0);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void j(List<String> list) throws RemoteException;

    boolean j() throws RemoteException;
}
