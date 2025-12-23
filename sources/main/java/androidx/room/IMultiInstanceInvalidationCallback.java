package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx$room$IMultiInstanceInvalidationCallback".replace(v0.f47959c, '.');

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {
        static final int TRANSACTION_onInvalidation = 1;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class Proxy implements IMultiInstanceInvalidationCallback {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationCallback.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMultiInstanceInvalidationCallback.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static IMultiInstanceInvalidationCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationCallback)) ? new Proxy(iBinder) : (IMultiInstanceInvalidationCallback) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            String str = IMultiInstanceInvalidationCallback.DESCRIPTOR;
            if (i6 >= 1 && i6 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i6 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i6 != 1) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            onInvalidation(parcel.createStringArray());
            return true;
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void onInvalidation(String[] strArr) throws RemoteException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Default implements IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(String[] strArr) throws RemoteException {
        }
    }
}
