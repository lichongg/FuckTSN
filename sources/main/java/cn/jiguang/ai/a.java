package cn.jiguang.ai;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1515a;

    /* renamed from: b, reason: collision with root package name */
    private String f1516b = cn.jiguang.d.a.c("Mpy0fkBSw1N+kug2cBPj2Z07jpK2SYpu9oSV4B2lEuO7ZdtoaGwNjuH9BjHR80mN");

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public a(IBinder iBinder) {
        this.f1515a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f1516b);
            this.f1515a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                f.i("ZuiAdvertisingInterface", "get Ids-o error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
