package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FieldManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41616a = "cfgfd";

    /* renamed from: b, reason: collision with root package name */
    private static b f41617b = b.b();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f41618c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Object f41619d = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.config.FieldManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final FieldManager f41620a = new FieldManager(null);

        private a() {
        }
    }

    /* synthetic */ FieldManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FieldManager a() {
        return a.f41620a;
    }

    private FieldManager() {
    }

    public static boolean allow(String str) {
        synchronized (f41619d) {
            try {
                if (!f41618c) {
                    return false;
                }
                return b.a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        boolean z5;
        synchronized (f41619d) {
            z5 = f41618c;
        }
        return z5;
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0825d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f41619d) {
            try {
                Pair<Long, String> a6 = a(imprintProperty);
                if (((Long) a6.first).longValue() > 1000 && (str = (String) a6.second) != null && str.length() > 0) {
                    str2 = str;
                }
                String[] split = str2.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i6 = 0; i6 < length; i6++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i6)).a(split[i6], f41617b, d.b(strArr[i6]));
                    }
                }
                f41618c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0825d.class.getName()};
        synchronized (f41619d) {
            try {
                f41617b.a();
                if (str != null) {
                    Pair<Long, String> a6 = a(str);
                    if (((Long) a6.first).longValue() > 1000 && (str2 = (String) a6.second) != null && str2.length() > 0) {
                        str3 = str2;
                    }
                }
                String[] split = str3.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i6 = 0; i6 < length; i6++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i6)).a(split[i6], f41617b, d.b(strArr[i6]));
                    }
                }
                f41618c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length >= 2) {
                try {
                    long parseLong = Long.parseLong(split[0]);
                    return new Pair<>(Long.valueOf(parseLong), split[1]);
                } catch (Throwable unused) {
                }
            }
        }
        return pair;
    }
}
