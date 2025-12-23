package cn.jiguang.ae;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1489a;

    /* renamed from: b, reason: collision with root package name */
    private String f1490b = cn.jiguang.d.a.c("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVv4Y6EB33Z8c96zLnz4UMIR2tR6ldXn18NaPke3N1cdFQ==");

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String a(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f1490b);
            this.f1489a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        return str;
    }

    public a(IBinder iBinder) {
        this.f1489a = iBinder;
    }
}
