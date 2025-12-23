package cn.jiguang.aa;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1462a;

    /* renamed from: b, reason: collision with root package name */
    private String f1463b = cn.jiguang.d.a.c("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==");

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public a(IBinder iBinder) {
        this.f1462a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(this.f1463b);
                this.f1462a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Exception e6) {
                f.i("HuaweiAdvertisingInterface", "getIds error: " + e6.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
