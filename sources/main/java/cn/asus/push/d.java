package cn.asus.push;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.IAIDLInvoke;

/* loaded from: D:\Downloads\app\classes2.dex */
final class d implements IAIDLInvoke {

    /* renamed from: b, reason: collision with root package name */
    public static IAIDLInvoke f1088b;

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1089a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1089a;
    }

    d(IBinder iBinder) {
        this.f1089a = iBinder;
    }

    @Override // cn.asus.push.IAIDLInvoke
    public final void c(DataBuffer dataBuffer) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f1089a.transact(1, obtain, obtain2, 0) && IAIDLInvoke.Stub.f() != null) {
                IAIDLInvoke.Stub.f().c(dataBuffer);
            } else {
                obtain2.readException();
            }
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // cn.asus.push.IAIDLInvoke
    public final void d(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (iAIDLCallback != null) {
                iBinder = iAIDLCallback.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (!this.f1089a.transact(2, obtain, null, 1) && IAIDLInvoke.Stub.f() != null) {
                IAIDLInvoke.Stub.f().d(dataBuffer, iAIDLCallback);
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
