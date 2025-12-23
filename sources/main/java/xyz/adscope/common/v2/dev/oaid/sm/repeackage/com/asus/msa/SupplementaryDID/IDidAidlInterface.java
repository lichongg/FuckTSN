package xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IDidAidlInterface extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IDidAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getOAID() {
            return null;
        }

        @Override // xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_isSupport = 1;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IDidAidlInterface {
            public static IDidAidlInterface sDefaultImpl;
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

            @Override // xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.v2.dev.oaid.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z5 = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupport();
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

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDidAidlInterface)) ? new Proxy(iBinder) : (IDidAidlInterface) queryLocalInterface;
        }

        public static IDidAidlInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDidAidlInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDidAidlInterface;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(isSupport ? 1 : 0);
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

    String getOAID();

    boolean isSupport();
}
