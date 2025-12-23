package cn.jiguang.bn;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.bb.f;
import cn.jiguang.bz.j;
import cn.jiguang.bz.q;
import cn.jiguang.bz.w;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f2400a;

    public static String a(Context context) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aj());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (a(str)) {
            return str;
        }
        String b6 = b(context);
        if (!TextUtils.isEmpty(b6)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aj().a((cn.jiguang.e.a<String>) Base64.encodeToString(b6.getBytes(), 2))});
        }
        return b6;
    }

    static {
        ArrayList arrayList = new ArrayList();
        f2400a = arrayList;
        arrayList.add("358673013795895");
        f2400a.add("004999010640000");
        f2400a.add("00000000000000");
        f2400a.add("000000000000000");
    }

    private static boolean a(String str) {
        if (!w.h(str) || str.length() < 10) {
            return false;
        }
        Iterator<String> it = f2400a.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static String b(Context context) {
        try {
            String str = a.a(context).f2384p;
            if (a(str)) {
                return str;
            }
            String str2 = a.a(context).f2377i;
            if (a(str2) && !"9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                return str2;
            }
            String c6 = c(context);
            return a(c6) ? c6 : "";
        } catch (Exception e6) {
            f.d("UDIDUtils", "", e6);
            String d6 = d(context);
            return a(d6) ? d6 : "";
        }
    }

    private static String d(Context context) {
        f.c("UDIDUtils", "Action:getSavedUuid");
        String str = (String) cn.jiguang.e.b.b(context, cn.jiguang.e.a.az());
        if (!w.a(str)) {
            return str;
        }
        if (!cn.jiguang.bz.a.d()) {
            return g(context);
        }
        String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ak());
        return TextUtils.isEmpty(str2) ? Build.VERSION.SDK_INT < 23 ? e(context) : (q.a(context, g.f36050j) && q.a(context, g.f36049i)) ? e(context) : g(context) : str2;
    }

    private static String c(Context context) {
        String d6 = d(context);
        if (d6 == null) {
            return " ";
        }
        return d6;
    }

    private static String e(Context context) {
        File file;
        String f6 = f(context);
        if (!w.a(f6)) {
            file = new File(f6);
        } else {
            file = null;
        }
        String c6 = j.c(file);
        if (!TextUtils.isEmpty(c6)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ak().a((cn.jiguang.e.a<String>) c6)});
            f.f("UDIDUtils", "Got sdcard file saved udid - " + c6);
            return c6;
        }
        String k6 = w.k(UUID.nameUUIDFromBytes((System.currentTimeMillis() + "").getBytes()).toString());
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ak().a((cn.jiguang.e.a<String>) k6)});
        j.b(file, k6);
        return k6;
    }

    private static String f(Context context) {
        String g6 = cn.jiguang.bz.a.g(context);
        if (TextUtils.isEmpty(g6)) {
            return null;
        }
        return g6 + ".push_udid";
    }

    private static String g(Context context) {
        cn.jiguang.e.a<String> az = cn.jiguang.e.a.az();
        String str = (String) cn.jiguang.e.b.b(context, az);
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{az.a((cn.jiguang.e.a<String>) uuid)});
            return uuid;
        }
        return str;
    }
}
