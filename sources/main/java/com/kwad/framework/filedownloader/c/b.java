package com.kwad.framework.filedownloader.c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.c.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface b extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a extends Binder implements b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.kwad.framework.filedownloader.c.b$a$a, reason: collision with other inner class name */
        static class C0658a implements b {
            public static b aoD;
            private IBinder mRemote;

            @Override // com.kwad.framework.filedownloader.c.b
            public final void b(com.kwad.framework.filedownloader.c.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || a.yK() == null) {
                        obtain.recycle();
                    } else {
                        a.yK().b(aVar);
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            C0658a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void a(com.kwad.framework.filedownloader.c.a aVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, null, 1) && a.yK() != null) {
                        a.yK().a(aVar);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean bQ(int i6) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.yK() != null) {
                        return a.yK().bQ(i6);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final long bR(int i6) {
                long readLong;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.yK() != null) {
                        readLong = a.yK().bR(i6);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final long bS(int i6) {
                long readLong;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.yK() != null) {
                        readLong = a.yK().bS(i6);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean bw(int i6) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.yK() != null) {
                        return a.yK().bw(i6);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final byte bx(int i6) {
                byte readByte;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.yK() != null) {
                        readByte = a.yK().bx(i6);
                    } else {
                        obtain2.readException();
                        readByte = obtain2.readByte();
                    }
                    return readByte;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean by(int i6) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    boolean z5 = false;
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.yK() != null) {
                        return a.yK().by(i6);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean isIdle() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean z5 = false;
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.yK() != null) {
                        return a.yK().isIdle();
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final void pauseAllTasks() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.yK() != null) {
                        a.yK().pauseAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void startForeground(int i6, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i6);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(12, obtain, null, 1) && a.yK() != null) {
                        a.yK().startForeground(i6, notification);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void stopForeground(boolean z5) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z5 ? 1 : 0);
                    if (!this.mRemote.transact(13, obtain, null, 1) && a.yK() != null) {
                        a.yK().stopForeground(z5);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean x(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z5 = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.yK() != null) {
                        return a.yK().x(str, str2);
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

            @Override // com.kwad.framework.filedownloader.c.b
            public final void yJ() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && a.yK() != null) {
                        a.yK().yJ();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void b(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z5 ? 1 : 0);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeInt(z6 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z7 ? 1 : 0);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.yK() != null) {
                        a.yK().b(str, str2, z5, i6, i7, i8, z6, bVar, z7);
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

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0658a(iBinder) : (b) queryLocalInterface;
        }

        public static b yK() {
            return C0658a.aoD;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1598968902) {
                parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
            switch (i6) {
                case 1:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    a(a.AbstractBinderC0656a.c(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    b(a.AbstractBinderC0656a.c(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean x5 = x(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(x5 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwad.framework.filedownloader.d.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean bw = bw(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(bw ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    pauseAllTasks();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean bQ = bQ(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(bQ ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    long bR = bR(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(bR);
                    return true;
                case 9:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    long bS = bS(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(bS);
                    return true;
                case 10:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    byte bx = bx(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(bx);
                    return true;
                case 11:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean isIdle = isIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(isIdle ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    boolean by = by(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(by ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    yJ();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i6, parcel, parcel2, i7);
            }
        }

        public a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void a(com.kwad.framework.filedownloader.c.a aVar);

    void b(com.kwad.framework.filedownloader.c.a aVar);

    void b(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7);

    boolean bQ(int i6);

    long bR(int i6);

    long bS(int i6);

    boolean bw(int i6);

    byte bx(int i6);

    boolean by(int i6);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i6, Notification notification);

    void stopForeground(boolean z5);

    boolean x(String str, String str2);

    void yJ();
}
