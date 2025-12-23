package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.az;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jy;
import com.bytedance.sdk.openadsdk.core.mi;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.ws;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface av extends IInterface {
    void j(String str, int i6) throws RemoteException;

    void j(String str, az azVar) throws RemoteException;

    void j(String str, i iVar) throws RemoteException;

    void j(String str, jy jyVar) throws RemoteException;

    void j(String str, mi miVar) throws RemoteException;

    void j(String str, w wVar) throws RemoteException;

    void j(String str, ws wsVar) throws RemoteException;

    void j(String str, String str2) throws RemoteException;

    void j(String str, String str2, long j6, long j7, String str3, String str4) throws RemoteException;

    void j(String str, String str2, Bundle bundle) throws RemoteException;

    Bundle xt(String str, String str2, Bundle bundle) throws RemoteException;

    void xt(String str, mi miVar) throws RemoteException;

    void xt(String str, String str2) throws RemoteException;

    public static abstract class j extends Binder implements av {

        /* renamed from: com.bytedance.sdk.openadsdk.core.av$j$j, reason: collision with other inner class name */
        private static class C0430j implements av {

            /* renamed from: j, reason: collision with root package name */
            public static av f27961j;
            private IBinder xt;

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    if (this.xt.transact(1, obtain, obtain2, 0) || j.j() == null) {
                        obtain2.readException();
                    } else {
                        j.j().j(str, wVar);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void xt(String str, mi miVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(miVar != null ? miVar.asBinder() : null);
                    if (this.xt.transact(6, obtain, obtain2, 0) || j.j() == null) {
                        obtain2.readException();
                    } else {
                        j.j().xt(str, miVar);
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

            C0430j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, str2, bundle);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void xt(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(11, obtain, obtain2, 0) && j.j() != null) {
                        j.j().xt(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public Bundle xt(String str, String str2, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.xt.transact(13, obtain, obtain2, 0) && j.j() != null) {
                        bundle2 = j.j().xt(str, str2, bundle);
                    } else {
                        obtain2.readException();
                        bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, az azVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(azVar != null ? azVar.asBinder() : null);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, azVar);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, mi miVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(miVar != null ? miVar.asBinder() : null);
                    if (!this.xt.transact(5, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, miVar);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, String str2, long j6, long j7, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j6);
                    obtain.writeLong(j7);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (!this.xt.transact(7, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, str2, j6, j7, str3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, jy jyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(jyVar != null ? jyVar.asBinder() : null);
                    if (!this.xt.transact(8, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, jyVar);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, int i6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeInt(i6);
                    if (!this.xt.transact(9, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, i6);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, ws wsVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(wsVar != null ? wsVar.asBinder() : null);
                    if (!this.xt.transact(10, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, wsVar);
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

            @Override // com.bytedance.sdk.openadsdk.core.av
            public void j(String str, i iVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (!this.xt.transact(12, obtain, obtain2, 0) && j.j() != null) {
                        j.j().j(str, iVar);
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

        public static av j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof av)) ? new C0430j(iBinder) : (av) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IListenerManager");
                return true;
            }
            switch (i6) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), w.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), az.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), mi.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    xt(parcel.readString(), mi.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), jy.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), ws.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    xt(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    j(parcel.readString(), i.j.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    Bundle xt = xt(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (xt != null) {
                        parcel2.writeInt(1);
                        xt.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i6, parcel, parcel2, i7);
            }
        }

        public j() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IListenerManager");
        }

        public static av j() {
            return C0430j.f27961j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
