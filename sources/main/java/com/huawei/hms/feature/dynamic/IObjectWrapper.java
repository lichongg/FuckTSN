package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IObjectWrapper extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IObjectWrapper";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IObjectWrapper {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IObjectWrapper {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class Proxy implements IObjectWrapper {
            public static IObjectWrapper sDefaultImpl;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f33181a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33181a;
            }

            public String getInterfaceDescriptor() {
                return IObjectWrapper.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.f33181a = iBinder;
            }
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IObjectWrapper.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        public static IObjectWrapper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IObjectWrapper iObjectWrapper) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iObjectWrapper == null) {
                return false;
            }
            Proxy.sDefaultImpl = iObjectWrapper;
            return true;
        }

        public Stub() {
            attachInterface(this, IObjectWrapper.DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString(IObjectWrapper.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
