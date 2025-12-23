package cn.jiguang.z;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f3333a;

    /* renamed from: b, reason: collision with root package name */
    private String f3334b;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public a(IBinder iBinder) {
        this.f3334b = "";
        this.f3333a = iBinder;
        this.f3334b = cn.jiguang.d.a.c("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjKewmlEeKVcapnVp59DHSw2ZuSa3pDDty/LQ1R0HbmN4Tu7alH/m3nVMfORBLpozB8=");
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f3334b);
            this.f3333a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                f.i("AdvertisingInterface", "getId error: " + th.getMessage());
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
