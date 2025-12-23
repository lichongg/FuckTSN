package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.az.e;
import cn.jiguang.az.f;
import cn.jiguang.az.j;
import com.google.common.primitives.SignedBytes;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1773a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f1774b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f1775c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f1776d;

    /* renamed from: e, reason: collision with root package name */
    private static Map<Integer, Bundle> f1777e = new ConcurrentHashMap();

    public static File a(Context context, int i6) {
        try {
            return a(context, b(context, i6), true);
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("PH", "getIIf error:" + th.getMessage());
            return null;
        }
    }

    static {
        a();
        f1773a = cn.jiguang.ax.a.b(new byte[]{67, 119, 38, 102, Utf8.REPLACEMENT_BYTE, 90, 73, 126, 125, 119, Byte.MAX_VALUE, 87, 14, 83, 75, 121, 99, 85, 104, 124, 100, 102, 116, 66});
        f1774b = cn.jiguang.ax.a.b(new byte[]{117, Byte.MAX_VALUE, 30, 74, 112, 111, 99, 112, 94, 71, 55, 97, 120, 101, 85, 82, 119, 105, 122, Utf8.REPLACEMENT_BYTE, 122, 99, 118, 122, 115, 88, 94, 84, 124, 122, 120, 112, 92, 104, 124, 100, 102, 116, 66});
        f1775c = cn.jiguang.ax.a.b(new byte[]{122, 102, 56, 123, 89, 71, 108, 105, 120, 118, 30, 73, 119, 124, 115, 99, 94, 65, 117, 38, 92, 82, 95, 82, 124, SignedBytes.MAX_POWER_OF_TWO, 115, 125, SignedBytes.MAX_POWER_OF_TWO, 69, 107, 73, 117, 101, 89, 79, 119});
        f1776d = cn.jiguang.ax.a.b(new byte[]{83, 78, 55, 120, 56, 123, 89, 71, 108, 105, 120, 118, 30, 106, 90, 103, 100, 116, 115, 76, 120, 123, 101, 93, 95, 65, 125, 109, 100});
    }

    public static File a(Context context, cn.jiguang.aw.c cVar, boolean z5) {
        File a6;
        if (cVar == null) {
            return null;
        }
        try {
            a6 = b.a(context, cVar.f1831s, cVar.f1825m, cVar.f1827o);
            cn.jiguang.ay.b.b("PH", "pF:" + a6);
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("PH", "gIF error:" + th.getMessage());
        }
        if (b.a(a6, cVar, z5)) {
            return a6;
        }
        return null;
    }

    public static cn.jiguang.aw.c b(Context context, int i6) {
        return cn.jiguang.aw.c.a(e.a(context, i6, "use"));
    }

    public static String a(int i6, int i7) {
        String str;
        if (i7 == 0) {
            str = "ic";
        } else if (i7 == 1) {
            str = "if";
        } else if (i7 == 2) {
            str = "iff";
        } else if (i7 == 3) {
            str = SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR;
        } else {
            if (i7 != 4) {
                cn.jiguang.ay.b.e("PH", "unkown type:" + i7);
                return "";
            }
            str = "code";
        }
        return f1777e.containsKey(Integer.valueOf(i6)) ? f1777e.get(Integer.valueOf(i6)).getString(str) : "";
    }

    private static void a() {
        try {
            cn.jiguang.ay.b.b("PH", "[loadPinfo]");
            f1777e.putAll(f.a());
            Bundle bundle = new Bundle();
            bundle.putInt("pid", 1);
            bundle.putString("code", f.b() + "");
            bundle.putString("ic", j.a("Y24ucC5qaWd1YW5nLkpDb3JlSGVscGVy"));
            Class<?> cls = Class.forName(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUludGVybmFsSGVscGVy"));
            bundle.putString("if", cls.getCanonicalName());
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                Field field = declaredFields[i6];
                if (field.getType().getCanonicalName().equals(j.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUhlbHBlckFjdGlvbg"))) {
                    cn.jiguang.ay.b.b("PH", "find filed name:" + field.getName());
                    bundle.putString("iff", field.getName());
                    break;
                }
                i6++;
            }
            bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, j.a("Y24ucC5qaWd1YW5nLkpDb3JlQ2xhc3NMb2FkZXI"));
            f1777e.put(1, bundle);
            cn.jiguang.ay.b.b("PH", "[loadPinfo] end:" + f1777e);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i6, String str, boolean z5) {
        e.a(context, i6, "use", str, z5);
    }

    public static void a(Context context, cn.jiguang.aw.c cVar) {
        try {
            cn.jiguang.ay.b.b("PH", "clearPlugin...");
            e.a(context, cVar.f1825m, "use", "", false);
            File a6 = b.a(context, cVar.f1831s, cVar.f1825m, cVar.f1827o);
            if (a6.exists()) {
                a6.delete();
            }
        } catch (Throwable unused) {
        }
    }
}
