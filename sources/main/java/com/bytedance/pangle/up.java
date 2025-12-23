package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.pangle.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface up extends IInterface {
    boolean bindService(Intent intent, tl tlVar, int i6, String str) throws RemoteException;

    ComponentName startService(Intent intent, String str) throws RemoteException;

    boolean stopService(Intent intent, String str) throws RemoteException;

    void unbindService(tl tlVar) throws RemoteException;

    public static abstract class j extends Binder implements up {

        /* renamed from: com.bytedance.pangle.up$j$j, reason: collision with other inner class name */
        private static class C0394j implements up {

            /* renamed from: j, reason: collision with root package name */
            public static up f25538j;
            private IBinder xt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xt;
            }

            C0394j(IBinder iBinder) {
                this.xt = iBinder;
            }

            @Override // com.bytedance.pangle.up
            public boolean bindService(Intent intent, tl tlVar, int i6, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    boolean z5 = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (tlVar != null) {
                        iBinder = tlVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i6);
                    obtain.writeString(str);
                    if (!this.xt.transact(3, obtain, obtain2, 0) && j.j() != null) {
                        boolean bindService = j.j().bindService(intent, tlVar, i6, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return bindService;
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

            @Override // com.bytedance.pangle.up
            public ComponentName startService(Intent intent, String str) throws RemoteException {
                ComponentName componentName;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.xt.transact(1, obtain, obtain2, 0) && j.j() != null) {
                        componentName = j.j().startService(intent, str);
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2);
                        } else {
                            componentName = null;
                        }
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return componentName;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.pangle.up
            public boolean stopService(Intent intent, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    boolean z5 = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.xt.transact(2, obtain, obtain2, 0) && j.j() != null) {
                        boolean stopService = j.j().stopService(intent, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return stopService;
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

            @Override // com.bytedance.pangle.up
            public void unbindService(tl tlVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (tlVar != null) {
                        iBinder = tlVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.xt.transact(4, obtain, obtain2, 0) && j.j() != null) {
                        j.j().unbindService(tlVar);
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

        public static up j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof up)) ? new C0394j(iBinder) : (up) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName startService = startService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (startService != null) {
                    parcel2.writeInt(1);
                    startService.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean stopService = stopService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(stopService ? 1 : 0);
                return true;
            }
            if (i6 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean bindService = bindService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, tl.j.j(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(bindService ? 1 : 0);
                return true;
            }
            if (i6 != 4) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            unbindService(tl.j.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public j() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static up j() {
            return C0394j.f25538j;
        }

        public IBinder asBinder() {
            return this;
        }
    }
}
