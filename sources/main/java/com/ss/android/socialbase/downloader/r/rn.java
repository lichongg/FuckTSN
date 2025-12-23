package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface rn extends IInterface {
    boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    public static abstract class j extends Binder implements rn {

        /* renamed from: com.ss.android.socialbase.downloader.r.rn$j$j, reason: collision with other inner class name */
        private static class C0801j implements rn {

            /* renamed from: j, reason: collision with root package name */
            public static rn f38976j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0801j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z5 = true;
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.j() != null) {
                        boolean cw = j.j().cw(cwVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return cw;
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

            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z5 = true;
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        boolean j6 = j.j().j(cwVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return j6;
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

            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
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

        public static rn j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof rn)) ? new C0801j(iBinder) : (rn) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean j6 = j(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(j6 ? 1 : 0);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean xt = xt(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(xt ? 1 : 0);
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            boolean cw = cw(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(cw ? 1 : 0);
            return true;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static rn j() {
            return C0801j.f38976j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
