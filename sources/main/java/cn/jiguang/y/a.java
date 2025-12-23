package cn.jiguang.y;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f3330a;

    /* renamed from: b, reason: collision with root package name */
    private String f3331b;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3330a;
    }

    public a(IBinder iBinder) {
        this.f3331b = "";
        this.f3330a = iBinder;
        this.f3331b = cn.jiguang.d.a.c("8lAhWp7NB89J3VIJU4lIGfGqvEuhZG7tBjI4IuOrU/y3j/vpb/c+G/Rylr/l3ZwQ");
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f3331b);
            this.f3330a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                f.i("AsusAdvertisingInterface", "get ids-o e: " + th.getMessage());
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
