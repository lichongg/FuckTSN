package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IRemoteCreator extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IRemoteCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IRemoteCreator {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteCreator";
        static final int TRANSACTION_newRemoteDecoderDelegate = 2;
        static final int TRANSACTION_newRemoteHmsDecoderDelegate = 3;
        static final int TRANSACTION_newRemoteViewDelegate = 1;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IRemoteCreator {
            public static IRemoteCreator sDefaultImpl;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteDecoderDelegate();
                    }
                    obtain2.readException();
                    return IRemoteDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteHmsDecoderDelegate();
                    }
                    obtain2.readException();
                    return IRemoteHmsDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    IBinder iBinder2 = null;
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (iObjectWrapper2 != null) {
                        iBinder2 = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        IRemoteViewDelegate newRemoteViewDelegate = Stub.getDefaultImpl().newRemoteViewDelegate(iObjectWrapper, iObjectWrapper2);
                        obtain2.recycle();
                        obtain.recycle();
                        return newRemoteViewDelegate;
                    }
                    obtain2.readException();
                    IRemoteViewDelegate asInterface = IRemoteViewDelegate.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteViewDelegate newRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newRemoteViewDelegate != null ? newRemoteViewDelegate.asBinder() : null);
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteDecoderDelegate newRemoteDecoderDelegate = newRemoteDecoderDelegate();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newRemoteDecoderDelegate != null ? newRemoteDecoderDelegate.asBinder() : null);
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
            IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate = newRemoteHmsDecoderDelegate();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(newRemoteHmsDecoderDelegate != null ? newRemoteHmsDecoderDelegate.asBinder() : null);
            return true;
        }

        public static IRemoteCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteCreator)) ? new Proxy(iBinder) : (IRemoteCreator) queryLocalInterface;
        }

        public static IRemoteCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteCreator iRemoteCreator) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteCreator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteCreator;
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

    IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException;

    IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException;

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
