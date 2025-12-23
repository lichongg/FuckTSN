package cn.jiguang.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.p;
import cn.jiguang.bz.v;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1482a;

    /* renamed from: b, reason: collision with root package name */
    private String f1483b;

    /* renamed from: c, reason: collision with root package name */
    private String f1484c = cn.jiguang.d.a.c("bFWKQsRzI9d+ktdqxw44MA==");

    /* renamed from: d, reason: collision with root package name */
    private String f1485d = cn.jiguang.d.a.c("vWw3rdN6/HN94yy83HO8Lw==");

    /* renamed from: e, reason: collision with root package name */
    private String f1486e = cn.jiguang.d.a.c("Ha7IUc4OlbRIQFpw3FJeZw==");

    /* renamed from: f, reason: collision with root package name */
    private String f1487f = cn.jiguang.d.a.c("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=");

    public String a(Context context) {
        return context == null ? "" : a(context.getPackageName(), b(context), this.f1484c);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    private String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f1487f);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f1482a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                f.i("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private String b(Context context) {
        if (TextUtils.isEmpty(this.f1483b)) {
            PackageInfo a6 = p.a(context, 64);
            if (a6 == null) {
                f.i("OppoAdvertisingInterface", "package get sign failed");
                return this.f1483b;
            }
            Signature[] signatureArr = a6.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(v.f2787b);
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b6 : digest) {
                            sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
                        }
                        this.f1483b = sb.toString();
                    }
                } catch (Throwable th) {
                    f.i("OppoAdvertisingInterface", "package sign error: " + th.getMessage());
                }
            }
        }
        return this.f1483b;
    }

    public a(IBinder iBinder) {
        this.f1482a = iBinder;
    }
}
