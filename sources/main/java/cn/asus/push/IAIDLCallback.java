package cn.asus.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAIDLCallback extends IInterface {

    public abstract class Stub extends Binder implements IAIDLCallback {
        private static final String DESCRIPTOR = "cn.asus.push.IAIDLCallback";
        static final int TRANSACTION_call = 1;

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLCallback)) ? new c(iBinder) : (IAIDLCallback) queryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return c.f1086b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (c.f1086b != null || iAIDLCallback == null) {
                return false;
            }
            c.f1086b = iAIDLCallback;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString(DESCRIPTOR);
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

    void call(DataBuffer dataBuffer);

    public class Default implements IAIDLCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.asus.push.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
        }
    }
}
