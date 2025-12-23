package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface IWorkManagerImpl extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";
        static final int TRANSACTION_cancelAllWork = 6;
        static final int TRANSACTION_cancelAllWorkByTag = 4;
        static final int TRANSACTION_cancelUniqueWork = 5;
        static final int TRANSACTION_cancelWorkById = 3;
        static final int TRANSACTION_enqueueContinuation = 2;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 7;
        static final int TRANSACTION_setProgress = 8;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IWorkManagerImpl {
            public static IWorkManagerImpl sDefaultImpl;
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWork(IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(6, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAllWork(callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWorkByTag(String tag, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(tag);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAllWorkByTag(tag, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelUniqueWork(String name, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(name);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(5, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelUniqueWork(name, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelWorkById(String id, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(id);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelWorkById(id, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueContinuation(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(request);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enqueueContinuation(request, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueWorkRequests(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(request);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enqueueWorkRequests(request, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void queryWorkInfo(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(request);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(7, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().queryWorkInfo(request, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void setProgress(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(request);
                    if (callback != null) {
                        iBinder = callback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(8, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setProgress(request, callback);
                        obtain.recycle();
                    } else {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static IWorkManagerImpl asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWorkManagerImpl)) ? new Proxy(obj) : (IWorkManagerImpl) queryLocalInterface;
        }

        public static IWorkManagerImpl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IWorkManagerImpl impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1598968902) {
                switch (code) {
                    case 1:
                        data.enforceInterface(DESCRIPTOR);
                        enqueueWorkRequests(data.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 2:
                        data.enforceInterface(DESCRIPTOR);
                        enqueueContinuation(data.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 3:
                        data.enforceInterface(DESCRIPTOR);
                        cancelWorkById(data.readString(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 4:
                        data.enforceInterface(DESCRIPTOR);
                        cancelAllWorkByTag(data.readString(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 5:
                        data.enforceInterface(DESCRIPTOR);
                        cancelUniqueWork(data.readString(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 6:
                        data.enforceInterface(DESCRIPTOR);
                        cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 7:
                        data.enforceInterface(DESCRIPTOR);
                        queryWorkInfo(data.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 8:
                        data.enforceInterface(DESCRIPTOR);
                        setProgress(data.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            }
            reply.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void cancelAllWork(IWorkManagerImplCallback callback) throws RemoteException;

    void cancelAllWorkByTag(String tag, IWorkManagerImplCallback callback) throws RemoteException;

    void cancelUniqueWork(String name, IWorkManagerImplCallback callback) throws RemoteException;

    void cancelWorkById(String id, IWorkManagerImplCallback callback) throws RemoteException;

    void enqueueContinuation(byte[] request, IWorkManagerImplCallback callback) throws RemoteException;

    void enqueueWorkRequests(byte[] request, IWorkManagerImplCallback callback) throws RemoteException;

    void queryWorkInfo(byte[] request, IWorkManagerImplCallback callback) throws RemoteException;

    void setProgress(byte[] request, IWorkManagerImplCallback callback) throws RemoteException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IWorkManagerImpl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWork(IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWorkByTag(String tag, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelUniqueWork(String name, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelWorkById(String id, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueContinuation(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueWorkRequests(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void queryWorkInfo(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void setProgress(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }
    }
}
