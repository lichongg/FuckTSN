package com.ss.android.socialbase.downloader.ae;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.r.ae;
import com.ss.android.socialbase.downloader.r.ed;
import com.ss.android.socialbase.downloader.r.g;
import com.ss.android.socialbase.downloader.r.i;
import com.ss.android.socialbase.downloader.r.jy;
import com.ss.android.socialbase.downloader.r.m;
import com.ss.android.socialbase.downloader.r.oq;
import com.ss.android.socialbase.downloader.r.p;
import com.ss.android.socialbase.downloader.r.qv;
import com.ss.android.socialbase.downloader.r.rn;
import com.ss.android.socialbase.downloader.r.tl;
import com.ss.android.socialbase.downloader.r.v;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface j extends IInterface {

    /* renamed from: com.ss.android.socialbase.downloader.ae.j$j, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0775j extends Binder implements j {

        /* renamed from: com.ss.android.socialbase.downloader.ae.j$j$j, reason: collision with other inner class name */
        private static class C0776j implements j {

            /* renamed from: j, reason: collision with root package name */
            public static j f38618j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.ae.j
            public p cw() throws RemoteException {
                p j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.xt.transact(6, obtain, obtain2, 0) || AbstractBinderC0775j.jy() == null) {
                        obtain2.readException();
                        j6 = p.j.j(obtain2.readStrongBinder());
                    } else {
                        j6 = AbstractBinderC0775j.jy().cw();
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public cw j() throws RemoteException {
                cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.xt.transact(1, obtain, obtain2, 0) || AbstractBinderC0775j.jy() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? cw.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = AbstractBinderC0775j.jy().j();
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.m xt() throws RemoteException {
                com.ss.android.socialbase.downloader.r.m j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (this.xt.transact(2, obtain, obtain2, 0) || AbstractBinderC0775j.jy() == null) {
                        obtain2.readException();
                        j6 = m.j.j(obtain2.readStrongBinder());
                    } else {
                        j6 = AbstractBinderC0775j.jy().xt();
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0776j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public v ae() throws RemoteException {
                v j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(10, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().ae();
                    } else {
                        obtain2.readException();
                        j6 = v.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public i g() throws RemoteException {
                i j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(12, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().g();
                    } else {
                        obtain2.readException();
                        j6 = i.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.ae m() throws RemoteException {
                com.ss.android.socialbase.downloader.r.ae j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(9, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().m();
                    } else {
                        obtain2.readException();
                        j6 = ae.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public qv oq() throws RemoteException {
                qv j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(13, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().oq();
                    } else {
                        obtain2.readException();
                        j6 = qv.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public tl qv() throws RemoteException {
                tl j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(14, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().qv();
                    } else {
                        obtain2.readException();
                        j6 = tl.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public rn r() throws RemoteException {
                rn j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(7, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().r();
                    } else {
                        obtain2.readException();
                        j6 = rn.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public ed tl() throws RemoteException {
                ed j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(11, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().tl();
                    } else {
                        obtain2.readException();
                        j6 = ed.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public g up() throws RemoteException {
                g j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(8, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().up();
                    } else {
                        obtain2.readException();
                        j6 = g.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public int vl() throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xt.transact(15, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        readInt = AbstractBinderC0775j.jy().vl();
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

            @Override // com.ss.android.socialbase.downloader.ae.j
            public jy cw(int i6) throws RemoteException {
                jy j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(16, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().cw(i6);
                    } else {
                        obtain2.readException();
                        j6 = jy.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public oq xt(int i6) throws RemoteException {
                oq j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().xt(i6);
                    } else {
                        obtain2.readException();
                        j6 = oq.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public int j(int i6) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        readInt = AbstractBinderC0775j.jy().j(i6);
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

            @Override // com.ss.android.socialbase.downloader.ae.j
            public oq j(int i6, int i7) throws RemoteException {
                oq j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && AbstractBinderC0775j.jy() != null) {
                        j6 = AbstractBinderC0775j.jy().j(i6, i7);
                    } else {
                        obtain2.readException();
                        j6 = oq.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static j j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new C0776j(iBinder) : (j) queryLocalInterface;
        }

        public static j jy() {
            return C0776j.f38618j;
        }

        public AbstractBinderC0775j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                IBinder iBinder = null;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        cw j6 = j();
                        parcel2.writeNoException();
                        if (j6 != null) {
                            parcel2.writeInt(1);
                            j6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        com.ss.android.socialbase.downloader.r.m xt = xt();
                        parcel2.writeNoException();
                        if (xt != null) {
                            iBinder = xt.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int j7 = j(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(j7);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        oq j8 = j(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (j8 != null) {
                            iBinder = j8.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        oq xt2 = xt(parcel.readInt());
                        parcel2.writeNoException();
                        if (xt2 != null) {
                            iBinder = xt2.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        p cw = cw();
                        parcel2.writeNoException();
                        if (cw != null) {
                            iBinder = cw.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        rn r5 = r();
                        parcel2.writeNoException();
                        if (r5 != null) {
                            iBinder = r5.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        g up = up();
                        parcel2.writeNoException();
                        if (up != null) {
                            iBinder = up.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        com.ss.android.socialbase.downloader.r.ae m6 = m();
                        parcel2.writeNoException();
                        if (m6 != null) {
                            iBinder = m6.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        v ae = ae();
                        parcel2.writeNoException();
                        if (ae != null) {
                            iBinder = ae.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ed tl = tl();
                        parcel2.writeNoException();
                        if (tl != null) {
                            iBinder = tl.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i g6 = g();
                        parcel2.writeNoException();
                        if (g6 != null) {
                            iBinder = g6.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        qv oq = oq();
                        parcel2.writeNoException();
                        if (oq != null) {
                            iBinder = oq.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        tl qv = qv();
                        parcel2.writeNoException();
                        if (qv != null) {
                            iBinder = qv.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int vl = vl();
                        parcel2.writeNoException();
                        parcel2.writeInt(vl);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        jy cw2 = cw(parcel.readInt());
                        parcel2.writeNoException();
                        if (cw2 != null) {
                            iBinder = cw2.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    v ae() throws RemoteException;

    jy cw(int i6) throws RemoteException;

    p cw() throws RemoteException;

    i g() throws RemoteException;

    int j(int i6) throws RemoteException;

    cw j() throws RemoteException;

    oq j(int i6, int i7) throws RemoteException;

    com.ss.android.socialbase.downloader.r.ae m() throws RemoteException;

    qv oq() throws RemoteException;

    tl qv() throws RemoteException;

    rn r() throws RemoteException;

    ed tl() throws RemoteException;

    g up() throws RemoteException;

    int vl() throws RemoteException;

    com.ss.android.socialbase.downloader.r.m xt() throws RemoteException;

    oq xt(int i6) throws RemoteException;
}
