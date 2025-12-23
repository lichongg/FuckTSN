package com.baidu.liantian.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.liantian.b.g;
import com.baidu.liantian.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {
    public static String a(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f10458b.getString("rpiiem", "");
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.f10460d.putString("rpiiem", str);
                    eVar.f10460d.commit();
                }
            }
            return str;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return str;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f10458b.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = g.f(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.f10460d.putString("rpandid", str);
                    eVar.f10460d.commit();
                }
            }
            return str;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return str;
        }
    }

    public static String c(Context context) {
        String str = "";
        try {
            e eVar = new e(context);
            str = eVar.f10458b.getString("rpmacadd", "");
            if (TextUtils.isEmpty(str)) {
                str = g.a();
                if (!TextUtils.isEmpty(str)) {
                    eVar.f10460d.putString("rpmacadd", str);
                    eVar.f10460d.commit();
                }
            }
            return str;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return str;
        }
    }
}
