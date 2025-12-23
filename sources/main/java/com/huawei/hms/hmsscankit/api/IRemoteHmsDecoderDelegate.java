package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IRemoteHmsDecoderDelegate extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IRemoteHmsDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
        public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
        public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IRemoteHmsDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate";
        static final int TRANSACTION_decodeInBitmap = 1;
        static final int TRANSACTION_detectWithByteBuffer = 2;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IRemoteHmsDecoderDelegate {
            public static IRemoteHmsDecoderDelegate sDefaultImpl;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
            public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (detailRect != null) {
                        obtain.writeInt(1);
                        detailRect.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
                        HmsScan[] decodeInBitmap = Stub.getDefaultImpl().decodeInBitmap(detailRect, iObjectWrapper, iObjectWrapper2);
                        obtain2.recycle();
                        obtain.recycle();
                        return decodeInBitmap;
                    }
                    obtain2.readException();
                    HmsScan[] hmsScanArr = (HmsScan[]) obtain2.createTypedArray(HmsScan.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return hmsScanArr;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
            public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (detailRect != null) {
                        obtain.writeInt(1);
                        detailRect.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        HmsScan[] detectWithByteBuffer = Stub.getDefaultImpl().detectWithByteBuffer(detailRect, iObjectWrapper, iObjectWrapper2);
                        obtain2.recycle();
                        obtain.recycle();
                        return detectWithByteBuffer;
                    }
                    obtain2.readException();
                    HmsScan[] hmsScanArr = (HmsScan[]) obtain2.createTypedArray(HmsScan.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return hmsScanArr;
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
                HmsScan[] decodeInBitmap = decodeInBitmap(parcel.readInt() != 0 ? DetailRect.CREATOR.createFromParcel(parcel) : null, IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decodeInBitmap, 1);
                return true;
            }
            if (i6 != 2) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            HmsScan[] detectWithByteBuffer = detectWithByteBuffer(parcel.readInt() != 0 ? DetailRect.CREATOR.createFromParcel(parcel) : null, IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeTypedArray(detectWithByteBuffer, 1);
            return true;
        }

        public static IRemoteHmsDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteHmsDecoderDelegate)) ? new Proxy(iBinder) : (IRemoteHmsDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteHmsDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteHmsDecoderDelegate iRemoteHmsDecoderDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteHmsDecoderDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteHmsDecoderDelegate;
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

    HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
