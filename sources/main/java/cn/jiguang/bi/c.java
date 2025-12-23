package cn.jiguang.bi;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    public static boolean a(Context context) {
        String c6 = c(context);
        String e6 = cn.jiguang.d.a.e(context);
        cn.jiguang.bb.f.c("InitHelper", "appkey=" + e6 + " last=" + c6);
        if (!w.a(c6) && !"null".equals(c6) && c6.equalsIgnoreCase(e6)) {
            return false;
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ah().a((cn.jiguang.e.a<String>) v.a(e6, cn.jiguang.a.a.f1451i))});
        cn.jiguang.bb.f.d("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
        cn.jiguang.be.b.a(context);
        return true;
    }

    public static void b(Context context) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aa());
        if (!TextUtils.isEmpty(str)) {
            str.startsWith("1.");
        }
        if (!TextUtils.isEmpty(str) && "5.2.2".equals(str)) {
            return;
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aa().a((cn.jiguang.e.a<String>) "5.2.2")});
    }

    private static String c(Context context) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ah());
        if (!TextUtils.isEmpty(str)) {
            return v.b(str, cn.jiguang.a.a.f1451i);
        }
        String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ai());
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ah().a((cn.jiguang.e.a<String>) v.a(str2, cn.jiguang.a.a.f1451i))});
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ai().a((cn.jiguang.e.a<String>) "")});
        return str2;
    }
}
