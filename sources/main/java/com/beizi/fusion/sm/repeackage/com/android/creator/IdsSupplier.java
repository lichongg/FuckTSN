package com.beizi.fusion.sm.repeackage.com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IdsSupplier extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IdsSupplier {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier
        public boolean isSupported() throws RemoteException {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IdsSupplier {
        private static final String DESCRIPTOR = "com.android.creator.IdsSupplier";
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_isSupported = 1;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IdsSupplier {
            public static IdsSupplier sDefaultImpl;
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

            @Override // com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier
            public String getOAID() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        readString = Stub.getDefaultImpl().getOAID();
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

            @Override // com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier
            public boolean isSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z5 = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupported();
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

        public static IdsSupplier asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IdsSupplier)) ? new Proxy(iBinder) : (IdsSupplier) queryLocalInterface;
        }

        public static IdsSupplier getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IdsSupplier idsSupplier) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (idsSupplier == null) {
                return false;
            }
            Proxy.sDefaultImpl = idsSupplier;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(isSupported ? 1 : 0);
                return true;
            }
            if (i6 != 3) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String oaid = getOAID();
            parcel2.writeNoException();
            parcel2.writeString(oaid);
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

    String getOAID() throws RemoteException;

    boolean isSupported() throws RemoteException;
}
