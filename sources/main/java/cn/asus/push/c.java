package cn.asus.push;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.IAIDLCallback;

/* loaded from: D:\Downloads\app\classes2.dex */
final class c implements IAIDLCallback {

    /* renamed from: b, reason: collision with root package name */
    public static IAIDLCallback f1086b;

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1087a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1087a;
    }

    c(IBinder iBinder) {
        this.f1087a = iBinder;
    }

    @Override // cn.asus.push.IAIDLCallback
    public final void call(DataBuffer dataBuffer) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLCallback");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f1087a.transact(1, obtain, null, 1) && IAIDLCallback.Stub.getDefaultImpl() != null) {
                IAIDLCallback.Stub.getDefaultImpl().call(dataBuffer);
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
