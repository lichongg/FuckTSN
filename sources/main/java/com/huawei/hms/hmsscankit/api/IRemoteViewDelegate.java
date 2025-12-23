package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface IRemoteViewDelegate extends IInterface {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IRemoteViewDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteViewDelegate";
        static final int TRANSACTION_decodeWithBitmap = 12;
        static final int TRANSACTION_getLightStatus = 14;
        static final int TRANSACTION_getView = 1;
        static final int TRANSACTION_onCreate = 2;
        static final int TRANSACTION_onDestroy = 3;
        static final int TRANSACTION_onPause = 4;
        static final int TRANSACTION_onResume = 5;
        static final int TRANSACTION_onStart = 6;
        static final int TRANSACTION_onStop = 7;
        static final int TRANSACTION_pauseContinuouslyScan = 16;
        static final int TRANSACTION_resumeContinuouslyScan = 15;
        static final int TRANSACTION_setOnClickListener = 9;
        static final int TRANSACTION_setOnErrorCallback = 17;
        static final int TRANSACTION_setOnLightVisbleCallBack = 13;
        static final int TRANSACTION_setOnResultCallback = 8;
        static final int TRANSACTION_turnOffLight = 11;
        static final int TRANSACTION_turnOnLight = 10;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IRemoteViewDelegate {
            public static IRemoteViewDelegate sDefaultImpl;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
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
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public boolean getLightStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z5 = false;
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLightStatus();
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public IObjectWrapper getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getView();
                    }
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onCreate(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCreate(bundle);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDestroy();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPause();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResume();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStart();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void onStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStop();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void pauseContinuouslyScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pauseContinuouslyScan();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void resumeContinuouslyScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resumeContinuouslyScan();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException {
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
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOnClickListener(iObjectWrapper);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iOnErrorCallback != null) {
                        iBinder = iOnErrorCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOnErrorCallback(iOnErrorCallback);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iOnLightCallback != null) {
                        iBinder = iOnLightCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOnLightVisbleCallBack(iOnLightCallback);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iOnResultCallback != null) {
                        iBinder = iOnResultCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOnResultCallback(iOnResultCallback);
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void turnOffLight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().turnOffLight();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
            public void turnOnLight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().turnOnLight();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IRemoteViewDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteViewDelegate)) ? new Proxy(iBinder) : (IRemoteViewDelegate) queryLocalInterface;
        }

        public static IRemoteViewDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteViewDelegate iRemoteViewDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteViewDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteViewDelegate;
            return true;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1598968902) {
                IBinder iBinder = null;
                Bundle bundle = null;
                switch (i6) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        IObjectWrapper view = getView();
                        parcel2.writeNoException();
                        if (view != null) {
                            iBinder = view.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onCreate(bundle);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDestroy();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onPause();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onResume();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onStart();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onStop();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOnResultCallback(IOnResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOnClickListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        turnOnLight();
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        turnOffLight();
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        HmsScan[] decodeWithBitmap = decodeWithBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeTypedArray(decodeWithBitmap, 1);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOnLightVisbleCallBack(IOnLightCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean lightStatus = getLightStatus();
                        parcel2.writeNoException();
                        parcel2.writeInt(lightStatus ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        resumeContinuouslyScan();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        pauseContinuouslyScan();
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOnErrorCallback(IOnErrorCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i6, parcel, parcel2, i7);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    boolean getLightStatus() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void pauseContinuouslyScan() throws RemoteException;

    void resumeContinuouslyScan() throws RemoteException;

    void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException;

    void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException;

    void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException;

    void turnOffLight() throws RemoteException;

    void turnOnLight() throws RemoteException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IRemoteViewDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public boolean getLightStatus() throws RemoteException {
            return false;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public IObjectWrapper getView() throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onDestroy() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onPause() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onResume() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onStart() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onStop() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void pauseContinuouslyScan() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void resumeContinuouslyScan() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void turnOffLight() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void turnOnLight() throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void onCreate(Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void setOnClickListener(IObjectWrapper iObjectWrapper) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
        public void setOnResultCallback(IOnResultCallback iOnResultCallback) throws RemoteException {
        }
    }
}
