package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface m extends IInterface {

    public static abstract class j extends Binder implements m {

        /* renamed from: com.ss.android.socialbase.downloader.r.m$j$j, reason: collision with other inner class name */
        private static class C0797j implements m {

            /* renamed from: j, reason: collision with root package name */
            public static m f38972j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0797j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.m
            public int j(long j6) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j6);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        readInt = j.j().j(j6);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static m j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new C0797j(iBinder) : (m) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int j6 = j(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(j6);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static m j() {
            return C0797j.f38972j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    int j(long j6) throws RemoteException;
}
