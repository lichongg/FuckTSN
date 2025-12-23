package cn.asus.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.asus.push.IAIDLCallback;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAIDLInvoke extends IInterface {

    public abstract class Stub extends Binder implements IAIDLInvoke {

        /* renamed from: a, reason: collision with root package name */
        private static final String f1077a = "cn.asus.push.IAIDLInvoke";

        /* renamed from: b, reason: collision with root package name */
        static final int f1078b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f1079c = 2;

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 == 1) {
                parcel.enforceInterface(f1077a);
                c(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i6 == 2) {
                parcel.enforceInterface(f1077a);
                d(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null, IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i6 != 1598968902) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            parcel2.writeString(f1077a);
            return true;
        }

        public static IAIDLInvoke e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1077a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLInvoke)) ? new d(iBinder) : (IAIDLInvoke) queryLocalInterface;
        }

        public static IAIDLInvoke f() {
            return d.f1088b;
        }

        public static boolean g(IAIDLInvoke iAIDLInvoke) {
            if (d.f1088b != null || iAIDLInvoke == null) {
                return false;
            }
            d.f1088b = iAIDLInvoke;
            return true;
        }

        public Stub() {
            attachInterface(this, f1077a);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void c(DataBuffer dataBuffer);

    void d(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback);

    public class Default implements IAIDLInvoke {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.asus.push.IAIDLInvoke
        public void c(DataBuffer dataBuffer) {
        }

        @Override // cn.asus.push.IAIDLInvoke
        public void d(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) {
        }
    }
}
