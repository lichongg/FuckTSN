package com.ss.android.socialbase.downloader.cw;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.cw.xt;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface cw extends IInterface {

    public static abstract class j extends Binder implements cw {

        /* renamed from: com.ss.android.socialbase.downloader.cw.cw$j$j, reason: collision with other inner class name */
        private static class C0778j implements cw {

            /* renamed from: j, reason: collision with root package name */
            public static cw f38693j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (this.xt.transact(6, obtain, obtain2, 0) || j.m() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    } else {
                        createTypedArrayList = j.m().cw(str);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.m() == null) {
                        obtain2.readException();
                    } else {
                        j.m().j();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (this.xt.transact(7, obtain, obtain2, 0) || j.m() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.ae.cw.CREATOR);
                    } else {
                        createTypedArrayList = j.m().r(str);
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean up(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(18, obtain, obtain2, 0) && j.m() != null) {
                        return j.m().up(i6);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw xt(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (this.xt.transact(3, obtain, obtain2, 0) || j.m() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = j.m().xt(i6);
                    }
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0778j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw ae(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw cwVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(21, obtain, obtain2, 0) && j.m() != null) {
                        cwVar = j.m().ae(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw g(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw cwVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(29, obtain, obtain2, 0) && j.m() != null) {
                        cwVar = j.m().g(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean m(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.xt.transact(19, obtain, obtain2, 0) && j.m() != null) {
                        return j.m().m(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw oq(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw cwVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(30, obtain, obtain2, 0) && j.m() != null) {
                        cwVar = j.m().oq(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw tl(int i6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw cwVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(25, obtain, obtain2, 0) && j.m() != null) {
                        cwVar = j.m().tl(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean j(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.m() != null) {
                        return j.m().j(i6);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.xt> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(9, obtain, obtain2, 0) && j.m() != null) {
                        createTypedArrayList = j.m().cw(i6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void r(int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    if (!this.xt.transact(10, obtain, obtain2, 0) && j.m() != null) {
                        j.m().r(i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.m() != null) {
                        createTypedArrayList = j.m().xt(str);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw up(int i6, long j6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(28, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().up(i6, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(27, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().r(i6, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xt.transact(20, obtain, obtain2, 0) && j.m() != null) {
                        j.m().cw();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.m() != null) {
                        createTypedArrayList = j.m().j(str);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public List<com.ss.android.socialbase.downloader.ae.cw> xt() throws RemoteException {
                List<com.ss.android.socialbase.downloader.ae.cw> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xt.transact(8, obtain, obtain2, 0) && j.m() != null) {
                        createTypedArrayList = j.m().xt();
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean up() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xt.transact(32, obtain, obtain2, 0) && j.m() != null) {
                        return j.m().up();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(26, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().cw(i6, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(11, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(xtVar);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (xtVar != null) {
                        obtain.writeInt(1);
                        xtVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(12, obtain, obtain2, 0) && j.m() != null) {
                        j.m().xt(xtVar);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xt.transact(31, obtain, obtain2, 0) && j.m() != null) {
                        return j.m().r();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(int i6, int i7, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(13, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(i6, i7, j6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(24, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().xt(i6, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(int i6, int i7, int i8, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(14, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(i6, i7, i8, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(33, obtain, obtain2, 0) && j.m() != null) {
                        j.m().xt(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(int i6, int i7, int i8, int i9) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeInt(i9);
                    if (!this.xt.transact(15, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(i6, i7, i8, i9);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeTypedList(list);
                    if (!this.xt.transact(35, obtain, obtain2, 0) && j.m() != null) {
                        j.m().xt(i6, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.xt.transact(16, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().j(i6, i7);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(17, obtain, obtain2, 0) && j.m() != null) {
                        boolean j6 = j.m().j(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(22, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().j(i6, j6, str, str2);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) throws RemoteException {
                com.ss.android.socialbase.downloader.ae.cw createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeLong(j6);
                    if (!this.xt.transact(23, obtain, obtain2, 0) && j.m() != null) {
                        createFromParcel = j.m().j(i6, j6);
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

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i6);
                    obtain.writeTypedList(list);
                    if (!this.xt.transact(34, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(i6, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.cw.cw
            public void j(xt xtVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(xtVar != null ? xtVar.asBinder() : null);
                    if (!this.xt.transact(36, obtain, obtain2, 0) && j.m() != null) {
                        j.m().j(xtVar);
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
        }

        public static cw j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cw)) ? new C0778j(iBinder) : (cw) queryLocalInterface;
        }

        public static cw m() {
            return C0778j.f38693j;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                com.ss.android.socialbase.downloader.ae.xt xtVar = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar2 = null;
                com.ss.android.socialbase.downloader.ae.xt xtVar2 = null;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean j6 = j(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(j6 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw xt = xt(parcel.readInt());
                        parcel2.writeNoException();
                        if (xt != null) {
                            parcel2.writeInt(1);
                            xt.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.cw> j7 = j(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(j7);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.cw> xt2 = xt(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xt2);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.cw> cw = cw(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(cw);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.cw> r5 = r(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(r5);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.cw> xt3 = xt();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xt3);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.ae.xt> cw2 = cw(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(cw2);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        r(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (parcel.readInt() != 0) {
                            xtVar = com.ss.android.socialbase.downloader.ae.xt.CREATOR.createFromParcel(parcel);
                        }
                        j(xtVar);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (parcel.readInt() != 0) {
                            xtVar2 = com.ss.android.socialbase.downloader.ae.xt.CREATOR.createFromParcel(parcel);
                        }
                        xt(xtVar2);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw j8 = j(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (j8 != null) {
                            parcel2.writeInt(1);
                            j8.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (parcel.readInt() != 0) {
                            cwVar2 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        boolean j9 = j(cwVar2);
                        parcel2.writeNoException();
                        parcel2.writeInt(j9 ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean up = up(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(up ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean m6 = m(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(m6 ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        cw();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw ae = ae(parcel.readInt());
                        parcel2.writeNoException();
                        if (ae != null) {
                            parcel2.writeInt(1);
                            ae.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw j10 = j(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (j10 != null) {
                            parcel2.writeInt(1);
                            j10.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw j11 = j(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (j11 != null) {
                            parcel2.writeInt(1);
                            j11.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw xt4 = xt(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (xt4 != null) {
                            parcel2.writeInt(1);
                            xt4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw tl = tl(parcel.readInt());
                        parcel2.writeNoException();
                        if (tl != null) {
                            parcel2.writeInt(1);
                            tl.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw cw3 = cw(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (cw3 != null) {
                            parcel2.writeInt(1);
                            cw3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw r6 = r(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (r6 != null) {
                            parcel2.writeInt(1);
                            r6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw up2 = up(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (up2 != null) {
                            parcel2.writeInt(1);
                            up2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw g6 = g(parcel.readInt());
                        parcel2.writeNoException();
                        if (g6 != null) {
                            parcel2.writeInt(1);
                            g6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        com.ss.android.socialbase.downloader.ae.cw oq = oq(parcel.readInt());
                        parcel2.writeNoException();
                        if (oq != null) {
                            parcel2.writeInt(1);
                            oq.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean r7 = r();
                        parcel2.writeNoException();
                        parcel2.writeInt(r7 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean up3 = up();
                        parcel2.writeNoException();
                        parcel2.writeInt(up3 ? 1 : 0);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        if (parcel.readInt() != 0) {
                            cwVar = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        xt(cwVar);
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.ae.xt.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        xt(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.ae.xt.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        j(xt.j.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    com.ss.android.socialbase.downloader.ae.cw ae(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) throws RemoteException;

    void cw() throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw g(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> j(String str) throws RemoteException;

    void j() throws RemoteException;

    void j(int i6, int i7, int i8, int i9) throws RemoteException;

    void j(int i6, int i7, int i8, long j6) throws RemoteException;

    void j(int i6, int i7, long j6) throws RemoteException;

    void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException;

    void j(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException;

    void j(xt xtVar) throws RemoteException;

    boolean j(int i6) throws RemoteException;

    boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    boolean m(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw oq(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> r(String str) throws RemoteException;

    void r(int i6) throws RemoteException;

    boolean r() throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw tl(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw up(int i6, long j6) throws RemoteException;

    boolean up() throws RemoteException;

    boolean up(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw xt(int i6) throws RemoteException;

    com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> xt() throws RemoteException;

    List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) throws RemoteException;

    void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws RemoteException;

    void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) throws RemoteException;
}
