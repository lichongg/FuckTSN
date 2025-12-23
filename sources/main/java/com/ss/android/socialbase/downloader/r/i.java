package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.r.av;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface i extends IInterface {

    public static abstract class j extends Binder implements i {

        /* renamed from: com.ss.android.socialbase.downloader.r.i$j$j, reason: collision with other inner class name */
        private static class C0795j implements i {

            /* renamed from: j, reason: collision with root package name */
            public static i f38969j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0795j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.i
            public boolean j(long j6, long j7, av avVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j6);
                    obtain.writeLong(j7);
                    if (avVar != null) {
                        iBinder = avVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z5 = false;
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        boolean j8 = j.j().j(j6, j7, avVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return j8;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
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

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0795j(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean j6 = j(parcel.readLong(), parcel.readLong(), av.j.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(j6 ? 1 : 0);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static i j() {
            return C0795j.f38969j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    boolean j(long j6, long j7, av avVar) throws RemoteException;
}
