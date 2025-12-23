package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IRemoteDecoderDelegate extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IRemoteDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate";
        static final int TRANSACTION_buildBitmap = 4;
        static final int TRANSACTION_buildBitmapLog = 3;
        static final int TRANSACTION_decodeWithBitmap = 1;
        static final int TRANSACTION_decodeWithBuffer = 2;
        static final int TRANSACTION_queryDeepLinkInfo = 5;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IRemoteDecoderDelegate {
            public static IRemoteDecoderDelegate sDefaultImpl;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        IObjectWrapper buildBitmap = Stub.getDefaultImpl().buildBitmap(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return buildBitmap;
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().buildBitmapLog(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
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
                        HmsScan[] decodeWithBitmap = Stub.getDefaultImpl().decodeWithBitmap(iObjectWrapper, iObjectWrapper2);
                        obtain2.recycle();
                        obtain.recycle();
                        return decodeWithBitmap;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public HmsScanResult decodeWithBuffer(byte[] bArr, int i6, int i7, IObjectWrapper iObjectWrapper) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    HmsScanResult hmsScanResult = null;
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        HmsScanResult decodeWithBuffer = Stub.getDefaultImpl().decodeWithBuffer(bArr, i6, i7, iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return decodeWithBuffer;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        hmsScanResult = HmsScanResult.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return hmsScanResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iObjectWrapper != null) {
                        iBinder = iObjectWrapper.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        IObjectWrapper queryDeepLinkInfo = Stub.getDefaultImpl().queryDeepLinkInfo(iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return queryDeepLinkInfo;
                    }
                    obtain2.readException();
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
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

        public static IRemoteDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteDecoderDelegate)) ? new Proxy(iBinder) : (IRemoteDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteDecoderDelegate iRemoteDecoderDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteDecoderDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteDecoderDelegate;
            return true;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            IBinder iBinder = null;
                            if (i6 != 4) {
                                if (i6 != 5) {
                                    return super.onTransact(i6, parcel, parcel2, i7);
                                }
                                parcel.enforceInterface(DESCRIPTOR);
                                IObjectWrapper queryDeepLinkInfo = queryDeepLinkInfo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                if (queryDeepLinkInfo != null) {
                                    iBinder = queryDeepLinkInfo.asBinder();
                                }
                                parcel2.writeStrongBinder(iBinder);
                                return true;
                            }
                            parcel.enforceInterface(DESCRIPTOR);
                            IObjectWrapper buildBitmap = buildBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            if (buildBitmap != null) {
                                iBinder = buildBitmap.asBinder();
                            }
                            parcel2.writeStrongBinder(iBinder);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        buildBitmapLog(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    HmsScanResult decodeWithBuffer = decodeWithBuffer(parcel.createByteArray(), parcel.readInt(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (decodeWithBuffer != null) {
                        parcel2.writeInt(1);
                        decodeWithBuffer.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                HmsScan[] decodeWithBitmap = decodeWithBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decodeWithBitmap, 1);
                return true;
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException;

    void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException;

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    HmsScanResult decodeWithBuffer(byte[] bArr, int i6, int i7, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IRemoteDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public HmsScanResult decodeWithBuffer(byte[] bArr, int i6, int i7, IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
        }
    }
}
