package com.ss.android.socialbase.downloader.r;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface oq extends IInterface {

    public static abstract class j extends Binder implements oq {

        /* renamed from: com.ss.android.socialbase.downloader.r.oq$j$j, reason: collision with other inner class name */
        private static class C0798j implements oq {

            /* renamed from: j, reason: collision with root package name */
            public static oq f38973j;
            private IBinder xt;

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.xt.transact(4, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                    } else {
                        j.xt().cw(cwVar);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public int j() throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = j.xt().j();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.xt.transact(3, obtain, obtain2, 0) || j.xt() == null) {
                        obtain2.readException();
                    } else {
                        j.xt().xt(cwVar);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0798j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void ae(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(9, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().ae(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void g(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(13, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().g(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void m(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(8, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().m(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void r(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().r(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void tl(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(10, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().tl(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void up(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(6, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().up(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(cwVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jVar != null) {
                        obtain.writeInt(1);
                        jVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(12, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().cw(cwVar, jVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jVar != null) {
                        obtain.writeInt(1);
                        jVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(11, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().xt(cwVar, jVar);
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

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cwVar != null) {
                        obtain.writeInt(1);
                        cwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jVar != null) {
                        obtain.writeInt(1);
                        jVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(7, obtain, obtain2, 0) && j.xt() != null) {
                        j.xt().j(cwVar, jVar);
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

        public static oq j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof oq)) ? new C0798j(iBinder) : (oq) queryLocalInterface;
        }

        public static oq xt() {
            return C0798j.f38973j;
        }

        public j() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            com.ss.android.socialbase.downloader.ae.cw cwVar;
            com.ss.android.socialbase.downloader.ae.cw cwVar2;
            com.ss.android.socialbase.downloader.ae.cw cwVar3;
            if (i6 != 1598968902) {
                com.ss.android.socialbase.downloader.ae.cw cwVar4 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar5 = null;
                com.ss.android.socialbase.downloader.up.j jVar = null;
                com.ss.android.socialbase.downloader.up.j jVar2 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar6 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar7 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar8 = null;
                com.ss.android.socialbase.downloader.up.j jVar3 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar9 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar10 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar11 = null;
                com.ss.android.socialbase.downloader.ae.cw cwVar12 = null;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        int j6 = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j6);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar4 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        j(cwVar4);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar12 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        xt(cwVar12);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar11 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        cw(cwVar11);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar10 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        r(cwVar10);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar9 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        up(cwVar9);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        } else {
                            cwVar = null;
                        }
                        if (parcel.readInt() != 0) {
                            jVar3 = com.ss.android.socialbase.downloader.up.j.CREATOR.createFromParcel(parcel);
                        }
                        j(cwVar, jVar3);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar8 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        m(cwVar8);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar7 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        ae(cwVar7);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar6 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        tl(cwVar6);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar2 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        } else {
                            cwVar2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            jVar2 = com.ss.android.socialbase.downloader.up.j.CREATOR.createFromParcel(parcel);
                        }
                        xt(cwVar2, jVar2);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar3 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        } else {
                            cwVar3 = null;
                        }
                        if (parcel.readInt() != 0) {
                            jVar = com.ss.android.socialbase.downloader.up.j.CREATOR.createFromParcel(parcel);
                        }
                        cw(cwVar3, jVar);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        if (parcel.readInt() != 0) {
                            cwVar5 = com.ss.android.socialbase.downloader.ae.cw.CREATOR.createFromParcel(parcel);
                        }
                        g(cwVar5);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void ae(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void cw(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException;

    void g(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    int j() throws RemoteException;

    void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException;

    void m(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void r(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void tl(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void up(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException;

    void xt(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException;
}
