package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface ed extends IInterface {

    public static abstract class j extends Binder implements ed {

        /* renamed from: com.ss.android.socialbase.downloader.r.ed$j$j, reason: collision with other inner class name */
        private static class C0791j implements ed {

            /* renamed from: j, reason: collision with root package name */
            public static ed f38965j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0791j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.ed
            public long j(int i6, int i7) throws RemoteException {
                long readLong;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        readLong = j.j().j(i6, i7);
                    } else {
                        obtain2.readException();
                        readLong = obtain2.readLong();
                    }
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ed j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ed)) ? new C0791j(iBinder) : (ed) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long j6 = j(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(j6);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static ed j() {
            return C0791j.f38965j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    long j(int i6, int i7) throws RemoteException;
}
