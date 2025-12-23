package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IDynamicLoader extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IDynamicLoader";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IDynamicLoader {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.feature.dynamic.IDynamicLoader
        public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i6, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IDynamicLoader {

        /* renamed from: a, reason: collision with root package name */
        public static final int f33179a = 1;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class Proxy implements IDynamicLoader {
            public static IDynamicLoader sDefaultImpl;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f33180a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33180a;
            }

            public String getInterfaceDescriptor() {
                return IDynamicLoader.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.f33180a = iBinder;
            }

            @Override // com.huawei.hms.feature.dynamic.IDynamicLoader
            public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i6, IObjectWrapper iObjectWrapper2) throws RemoteException {
                IBinder iBinder;
                IObjectWrapper asInterface;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDynamicLoader.DESCRIPTOR);
                    IBinder iBinder2 = null;
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(i6);
                    if (iObjectWrapper2 != null) {
                        iBinder2 = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    if (!this.f33180a.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        asInterface = Stub.getDefaultImpl().load(iObjectWrapper, str, i6, iObjectWrapper2);
                    } else {
                        obtain2.readException();
                        asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
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

        public static IDynamicLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDynamicLoader.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicLoader)) ? new Proxy(iBinder) : (IDynamicLoader) queryLocalInterface;
        }

        public static IDynamicLoader getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDynamicLoader iDynamicLoader) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDynamicLoader == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDynamicLoader;
            return true;
        }

        public Stub() {
            attachInterface(this, IDynamicLoader.DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            IBinder iBinder;
            if (i6 != 1598968902) {
                if (i6 != 1) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel.enforceInterface(IDynamicLoader.DESCRIPTOR);
                IObjectWrapper load = load(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (load != null) {
                    iBinder = load.asBinder();
                } else {
                    iBinder = null;
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            }
            parcel2.writeString(IDynamicLoader.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i6, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
