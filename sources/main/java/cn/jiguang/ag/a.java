package cn.jiguang.ag;

import android.content.Context;
import android.os.Build;
import cn.jiguang.bb.f;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f1506a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1507b;

    /* renamed from: c, reason: collision with root package name */
    private static String f1508c;

    private static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z5 = context != null;
        if (z5 && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e6) {
                f.i("IdProvider", "loadClass error, " + e6.getMessage());
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e7) {
            f.i("IdProvider", String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z5), e7.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e7);
        }
    }

    public static String a(Context context) {
        try {
            if (f1507b == null) {
                f1508c = "";
                f1506a = "";
                f1507b = "";
                Class<?> a6 = a(context, cn.jiguang.d.a.c("KIHhQylffktk79IAY9r8iabG5YlYSM/WswW6fWtc2r2WbTdKR65l5atPPp2u96wd"));
                Object invoke = a6.getMethod(cn.jiguang.d.a.c("Oi3ZFT8+schQHSyFZbsdUg=="), Context.class).invoke(a6.newInstance(), context);
                if (invoke instanceof String) {
                    f1507b = (String) invoke;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("joad", f1507b);
            return jSONObject.toString();
        } catch (Throwable th) {
            f.j("IdProvider", "getIds failed:" + th.getMessage());
            return "";
        }
    }
}
