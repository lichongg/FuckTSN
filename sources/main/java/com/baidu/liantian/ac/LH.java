package com.baidu.liantian.ac;

import android.content.Context;
import android.util.Pair;
import com.baidu.liantian.b;
import com.baidu.liantian.core.e;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LH {
    public static Pair<String, String> getId(Context context) {
        String str;
        String str2 = "";
        try {
            str = e.a(context);
            try {
                String l6 = com.baidu.liantian.b.e.l(context);
                b.a();
                str2 = new JSONObject(l6).getString("ID");
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return Pair.create(str, str2);
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return Pair.create(str, str2);
    }

    public static void init(Context context, boolean z5) {
        e.a(context, 0, z5);
    }

    private static String getVersion(Context context) {
        return "3.1.6.7";
    }

    private LH() {
    }

    public static void initDelay(Context context, int i6, boolean z5) {
        e.a(context, i6, z5);
    }

    public static Pair<String, String> getId(Context context, String str) {
        String str2;
        String str3 = "";
        try {
            str2 = e.a(context);
            try {
                String b6 = com.baidu.liantian.b.e.b(context, str);
                b.a();
                str3 = new JSONObject(b6).getString("ID");
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return Pair.create(str2, str3);
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return Pair.create(str2, str3);
    }
}
