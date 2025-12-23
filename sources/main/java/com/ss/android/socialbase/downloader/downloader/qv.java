package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.ae.j;
import com.ss.android.socialbase.downloader.r.gx;
import com.ss.android.socialbase.downloader.r.oq;
import com.ss.android.socialbase.downloader.r.p;
import com.ss.android.socialbase.downloader.r.rn;
import com.ss.android.socialbase.downloader.r.tl;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface qv extends IInterface {

    public static abstract class j extends Binder implements qv {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.qv$j$j, reason: collision with other inner class name */
        private static class C0781j implements qv {

            /* renamed from: j, reason: collision with root package name */
            public static qv f38764j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void cw(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (this.xt.transact(5, obtain, obtain2, 0) || j.ae() == null) {
                        obtain2.readException();
                    } else {
                        j.ae().cw(i6);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(com.ss.android.socialbase.downloader.ae.j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.ae() == null) {
                        obtain2.readException();
                    } else {
                        j.ae().j(jVar);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public int m(int i6) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (this.xt.transact(9, obtain, obtain2, 0) || j.ae() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = j.ae().m(i6);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void r(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (this.xt.transact(6, obtain, obtain2, 0) || j.ae() == null) {
                        obtain2.readException();
                    } else {
                        j.ae().r(i6);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public long up(int i6) throws RemoteException {
                long readLong;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (this.xt.transact(8, obtain, obtain2, 0) || j.ae() == null) {
                        obtain2.readException();
                        readLong = obtain2.readLong();
                    } else {
                        readLong = j.ae().up(i6);
                    }
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean xt(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().xt(i6);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0781j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean ae(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.xt.transact(10, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().ae(i6);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean av(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.xt.transact(45, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().av(i6);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void az(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(41, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().az(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.xt> g(int i6) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.xt> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(13, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().g(i6);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.xt.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public p i(int i6) throws RemoteException {
                p j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(51, obtain, obtain2, 0) && j.ae() != null) {
                        j6 = j.ae().i(i6);
                    } else {
                        obtain2.readException();
                        j6 = p.j.j(obtain2.readStrongBinder());
                    }
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public int jy(int i6) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(37, obtain, obtain2, 0) && j.ae() != null) {
                        readInt = j.ae().jy(i6);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public com.ss.android.socialbase.downloader.r.tl mi(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.r.tl j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(54, obtain, obtain2, 0) && j.ae() != null) {
                        j6 = j.ae().mi(i6);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void oq(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(24, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().oq(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean qv(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.xt.transact(33, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().qv(i6);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public com.ss.android.socialbase.downloader.ae.cw tl(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw cwVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(11, obtain, obtain2, 0) && j.ae() != null) {
                        cwVar = j.ae().tl(i6);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            cwVar = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(obtain2);
                        } else {
                            cwVar = null;
                        }
                    }
                    return cwVar;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void vl(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(34, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().vl(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public rn w(int i6) throws RemoteException {
                rn j6;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(52, obtain, obtain2, 0) && j.ae() != null) {
                        j6 = j.ae().w(i6);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean ws(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.xt.transact(40, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().ws(i6);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z5 = true;
                    }
                    return z5;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.xt.transact(17, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().cw(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.xt.transact(18, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().r(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(55, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().m();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> up(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.xt.transact(32, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().up(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(15, obtain, obtain2, 0) && j.ae() != null) {
                        createFromParcel = j.ae().xt(str, str2);
                    } else {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(obtain2) : null;
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, z5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void cw(int i6, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(23, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().cw(i6, z5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(35, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().r();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void up() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(46, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().up();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.xt.transact(16, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().xt(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(7, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(31, obtain, obtain2, 0) && j.ae() != null) {
                        return j.ae().cw();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void r(int i6, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(36, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().r(i6, z5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> xt() throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xt.transact(19, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().xt();
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.xt.transact(12, obtain, obtain2, 0) && j.ae() != null) {
                        createTypedArrayList = j.ae().j(str);
                    } else {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void xt(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.xt.transact(21, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().xt(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public int j(String str, String str2) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(14, obtain, obtain2, 0) && j.ae() != null) {
                        readInt = j.ae().j(str, str2);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void xt(int i6, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(22, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().xt(i6, z5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.xt.transact(20, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void xt(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeStrongBinder(oqVar != null ? oqVar.asBinder() : null);
                    obtain.writeInt(i8);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(26, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().xt(i6, i7, oqVar, i8, z5);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeStrongBinder(oqVar != null ? oqVar.asBinder() : null);
                    obtain.writeInt(i8);
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.xt.transact(25, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7, oqVar, i8, z5);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(39, obtain, obtain2, 0) && j.ae() != null) {
                        boolean xt = j.ae().xt(cwVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return xt;
                    }
                    obtain2.readException();
                    boolean z5 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5, boolean z6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeStrongBinder(oqVar != null ? oqVar.asBinder() : null);
                    obtain.writeInt(i8);
                    obtain.writeInt(z5 ? 1 : 0);
                    obtain.writeInt(z6 ? 1 : 0);
                    if (!this.xt.transact(27, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7, oqVar, i8, z5, z6);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeTypedList(list);
                    if (!this.xt.transact(48, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().xt(i6, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(28, obtain, obtain2, 0) && j.ae() != null) {
                        boolean j6 = j.ae().j(cwVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return j6;
                    }
                    obtain2.readException();
                    boolean z5 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z5;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.xt.transact(29, obtain, null, 1) || j.ae() == null) {
                        obtain.recycle();
                    } else {
                        j.ae().j(i6, notification);
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(boolean z5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z5 ? 1 : 0);
                    if (this.xt.transact(30, obtain, null, 1) || j.ae() == null) {
                        return;
                    }
                    j.ae().j(z5);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(38, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(xtVar);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(42, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7, j6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7, int i8, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(43, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7, i8, j6);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7, int i8, int i9) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeInt(i9);
                    if (!this.xt.transact(44, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7, i8, i9);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeTypedList(list);
                    if (!this.xt.transact(47, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(gx gxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(gxVar != null ? gxVar.asBinder() : null);
                    if (!this.xt.transact(49, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(gxVar);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, int i7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.xt.transact(50, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, i7);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, p pVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (!this.xt.transact(53, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, pVar);
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

            @Override // com.ss.android.socialbase.downloader.downloader.qv
            public void j(int i6, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(56, obtain, obtain2, 0) && j.ae() != null) {
                        j.ae().j(i6, j6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static qv ae() {
            return C0781j.f38764j;
        }

        public static qv j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qv)) ? new C0781j(iBinder) : (qv) queryLocalInterface;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            if (i6 != 1598968902) {
                com.ss.android.socialbase.downloader.ae.cw cwVar = null;
                IBinder iBinder = null;
                IBinder iBinder2 = null;
                IBinder iBinder3 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar2 = null;
                com.ss.android.socialbase.downloader.ae.xt xtVar = null;
                Notification notification = null;
                boolean z11 = false;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(j.AbstractBinderC0775j.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        j(readInt, z5);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean xt = xt(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(xt ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        cw(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        r(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        long up = up(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(up);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int m6 = m(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(m6);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean ae = ae(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(ae ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        com.ss.android.socialbase.downloader.ae.cw tl = tl(parcel.readInt());
                        parcel2.writeNoException();
                        if (tl != null) {
                            parcel2.writeInt(1);
                            tl.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> j6 = j(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(j6);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.xt> g6 = g(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(g6);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int j7 = j(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(j7);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        com.ss.android.socialbase.downloader.ae.cw xt2 = xt(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (xt2 != null) {
                            parcel2.writeInt(1);
                            xt2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> xt3 = xt(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xt3);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> cw = cw(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(cw);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> r5 = r(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(r5);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> xt4 = xt();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xt4);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        xt(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        xt(readInt2, z6);
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        cw(readInt3, z7);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        oq(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt4 = parcel.readInt();
                        int readInt5 = parcel.readInt();
                        com.ss.android.socialbase.downloader.r.oq j8 = oq.j.j(parcel.readStrongBinder());
                        int readInt6 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        j(readInt4, readInt5, j8, readInt6, z8);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt7 = parcel.readInt();
                        int readInt8 = parcel.readInt();
                        com.ss.android.socialbase.downloader.r.oq j9 = oq.j.j(parcel.readStrongBinder());
                        int readInt9 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        xt(readInt7, readInt8, j9, readInt9, z9);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt10 = parcel.readInt();
                        int readInt11 = parcel.readInt();
                        com.ss.android.socialbase.downloader.r.oq j10 = oq.j.j(parcel.readStrongBinder());
                        int readInt12 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        }
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        j(readInt10, readInt11, j10, readInt12, z11, z10);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (parcel.readInt() != 0) {
                            cwVar = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        boolean j11 = j(cwVar);
                        parcel2.writeNoException();
                        parcel2.writeInt(j11 ? 1 : 0);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt13 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        }
                        j(readInt13, notification);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        }
                        j(z11);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean cw2 = cw();
                        parcel2.writeNoException();
                        parcel2.writeInt(cw2 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.ae.cw> up2 = up(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(up2);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean qv = qv(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(qv ? 1 : 0);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        vl(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean r6 = r();
                        parcel2.writeNoException();
                        parcel2.writeInt(r6 ? 1 : 0);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int readInt14 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        }
                        r(readInt14, z11);
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int jy = jy(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(jy);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (parcel.readInt() != 0) {
                            xtVar = com.ss.android.socialbase.downloader.ae.xt.CREATOR.createFromParcel(parcel);
                        }
                        j(xtVar);
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        if (parcel.readInt() != 0) {
                            cwVar2 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        boolean xt5 = xt(cwVar2);
                        parcel2.writeNoException();
                        parcel2.writeInt(xt5 ? 1 : 0);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean ws = ws(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(ws ? 1 : 0);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        az(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean av = av(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(av ? 1 : 0);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        up();
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.ae.xt.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        xt(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.ae.xt.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(gx.j.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        p i8 = i(parcel.readInt());
                        parcel2.writeNoException();
                        if (i8 != null) {
                            iBinder3 = i8.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder3);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        rn w5 = w(parcel.readInt());
                        parcel2.writeNoException();
                        if (w5 != null) {
                            iBinder2 = w5.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder2);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), p.j.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        com.ss.android.socialbase.downloader.r.tl mi = mi(parcel.readInt());
                        parcel2.writeNoException();
                        if (mi != null) {
                            iBinder = mi.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean m7 = m();
                        parcel2.writeNoException();
                        parcel2.writeInt(m7 ? 1 : 0);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    boolean ae(int i6) throws RemoteException;

    boolean av(int i6) throws RemoteException;

    void az(int i6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) throws RemoteException;

    void cw(int i6) throws RemoteException;

    void cw(int i6, boolean z5) throws RemoteException;

    boolean cw() throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.xt> g(int i6) throws RemoteException;

    p i(int i6) throws RemoteException;

    int j(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> j(String str) throws RemoteException;

    void j() throws RemoteException;

    void j(int i6) throws RemoteException;

    void j(int i6, int i7) throws RemoteException;

    void j(int i6, int i7, int i8, int i9) throws RemoteException;

    void j(int i6, int i7, int i8, long j6) throws RemoteException;

    void j(int i6, int i7, long j6) throws RemoteException;

    void j(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5) throws RemoteException;

    void j(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5, boolean z6) throws RemoteException;

    void j(int i6, long j6) throws RemoteException;

    void j(int i6, Notification notification) throws RemoteException;

    void j(int i6, p pVar) throws RemoteException;

    void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException;

    void j(int i6, boolean z5) throws RemoteException;

    void j(com.ss.android.socialbase.downloader.ae.j jVar) throws RemoteException;

    void j(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException;

    void j(gx gxVar) throws RemoteException;

    void j(List<String> list) throws RemoteException;

    void j(boolean z5) throws RemoteException;

    boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    int jy(int i6) throws RemoteException;

    int m(int i6) throws RemoteException;

    boolean m() throws RemoteException;

    com.ss.android.socialbase.downloader.r.tl mi(int i6) throws RemoteException;

    void oq(int i6) throws RemoteException;

    boolean qv(int i6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> r(String str) throws RemoteException;

    void r(int i6) throws RemoteException;

    void r(int i6, boolean z5) throws RemoteException;

    boolean r() throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw tl(int i6) throws RemoteException;

    long up(int i6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> up(String str) throws RemoteException;

    void up() throws RemoteException;

    void vl(int i6) throws RemoteException;

    rn w(int i6) throws RemoteException;

    boolean ws(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> xt() throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) throws RemoteException;

    void xt(int i6, int i7, com.ss.android.socialbase.downloader.r.oq oqVar, int i8, boolean z5) throws RemoteException;

    void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException;

    void xt(int i6, boolean z5) throws RemoteException;

    void xt(List<String> list) throws RemoteException;

    boolean xt(int i6) throws RemoteException;

    boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;
}
