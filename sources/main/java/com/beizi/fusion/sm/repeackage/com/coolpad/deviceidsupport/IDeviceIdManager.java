package com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IDeviceIdManager extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isCoolOs = 6;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        readString = Stub.getDefaultImpl().getCoolOsVersion();
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        readString = Stub.getDefaultImpl().getOAID(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z5 = false;
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCoolOs();
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
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String oaid = getOAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i6 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i6 == 6) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isCoolOs = isCoolOs();
                parcel2.writeNoException();
                parcel2.writeInt(isCoolOs ? 1 : 0);
                return true;
            }
            if (i6 != 7) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel.enforceInterface(DESCRIPTOR);
            String coolOsVersion = getCoolOsVersion();
            parcel2.writeNoException();
            parcel2.writeString(coolOsVersion);
            return true;
        }

        public static IDeviceIdManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdManager)) ? new Proxy(iBinder) : (IDeviceIdManager) queryLocalInterface;
        }

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceIdManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdManager;
            return true;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    String getCoolOsVersion() throws RemoteException;

    String getOAID(String str) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
