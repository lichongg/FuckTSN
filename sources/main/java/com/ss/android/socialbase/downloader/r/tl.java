package com.ss.android.socialbase.downloader.r;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface tl extends IInterface {

    public static abstract class j extends Binder implements tl {

        /* renamed from: com.ss.android.socialbase.downloader.r.tl$j$j, reason: collision with other inner class name */
        private static class C0802j implements tl {

            /* renamed from: j, reason: collision with root package name */
            public static tl f38977j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0802j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.tl
            public Uri j(String str, String str2) throws RemoteException {
                Uri uri;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        uri = j.j().j(str, str2);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            uri = (Uri) Uri.CREATOR.createFromParcel(obtain2);
                        } else {
                            uri = null;
                        }
                    }
                    return uri;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static tl j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof tl)) ? new C0802j(iBinder) : (tl) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri j6 = j(parcel.readString(), parcel.readString());
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static tl j() {
            return C0802j.f38977j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    Uri j(String str, String str2) throws RemoteException;
}
