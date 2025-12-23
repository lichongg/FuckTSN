package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.r.f;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface v extends IInterface {

    public static abstract class j extends Binder implements v {

        /* renamed from: com.ss.android.socialbase.downloader.r.v$j$j, reason: collision with other inner class name */
        private static class C0803j implements v {

            /* renamed from: j, reason: collision with root package name */
            public static v f38978j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0803j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.v
            public boolean j(f fVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z5 = false;
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        boolean j6 = j.j().j(fVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return j6;
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

        public static v j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof v)) ? new C0803j(iBinder) : (v) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean j6 = j(f.j.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(j6 ? 1 : 0);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static v j() {
            return C0803j.f38978j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    boolean j(f fVar) throws RemoteException;
}
