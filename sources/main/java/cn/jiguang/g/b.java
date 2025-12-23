package cn.jiguang.g;

import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    private static boolean f2962i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f2963j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f2964k;

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<Integer> f2954a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<Integer> f2955b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<Integer> f2956c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<Integer> f2957d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<Integer> f2958e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static int f2959f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f2960g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static int f2961h = 0;

    /* renamed from: l, reason: collision with root package name */
    private static AtomicInteger f2965l = new AtomicInteger(0);

    public static synchronized void a() {
        synchronized (b.class) {
            try {
                f2957d.clear();
                f2958e.clear();
                f2962i = b();
                f2963j = d();
                f2964k = c();
                f.c("JDataConfigManager", "updateCollectConfig isPluginJPus=" + f2962i + " isPluginJOperate=" + f2963j + " isPluginVerification=" + f2964k);
                if (f2962i) {
                    f2957d.addAll(f2954a);
                }
                if (f2963j) {
                    f2957d.addAll(f2955b);
                }
                if (f2964k) {
                    f2957d.addAll(f2956c);
                }
                f.c("JDataConfigManager", "updateCollectConfig default mDisableDatas=" + f2958e);
                f.c("JDataConfigManager", "updateCollectConfig default mEnableDatas=" + f2957d);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        f2955b.add(2002);
        f2955b.add(2001);
        f2955b.add(2000);
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_EXTRACT));
        f2955b.add(2003);
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_CAPACITY));
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_REQUEST));
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_NO_DOWNLOADER));
        f2955b.add(Integer.valueOf(PluginError.ERROR_UPD_FILE_NOT_FOUND));
        f2955b.add(2010);
        f2955b.add(Integer.valueOf(GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE));
        f2955b.add(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP));
        f2955b.add(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_MAPMODESTATE));
        f2954a.add(1001);
        f2954a.add(1000);
        f2954a.add(1007);
        f2954a.add(1003);
        f2954a.add(1005);
        f2954a.add(1008);
        f2954a.add(1006);
        f2954a.add(1010);
        f2954a.add(1012);
        f2954a.add(1013);
        f2954a.add(Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
        f2956c.add(Integer.valueOf(PluginError.ERROR_INS_INSTALL_PATH));
        f2956c.add(3008);
        f2956c.add(3003);
        f2956c.add(3002);
        f2956c.add(3004);
        f2956c.add(3001);
        f2956c.add(3012);
        f2956c.add(3013);
        f2956c.add(3000);
        f2956c.add(3007);
        f2956c.add(3005);
        f2956c.add(3011);
        f2956c.add(3010);
        f2956c.add(3009);
        f2956c.add(3014);
        f2956c.add(3015);
        f2956c.add(3016);
        f2956c.add(3017);
    }

    private static void a(int i6) {
        String valueOf = String.valueOf(i6);
        if (valueOf.startsWith(String.valueOf(1000).substring(0, 1))) {
            f2959f = i6;
        } else if (valueOf.startsWith(String.valueOf(2000).substring(0, 1))) {
            f2960g = i6;
        } else if (valueOf.startsWith(String.valueOf(3000).substring(0, 1))) {
            f2961h = i6;
        }
    }

    private static boolean b() {
        try {
            if ((f2965l.intValue() & 1) != 0) {
                return f2962i;
            }
            f2965l.addAndGet(1);
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean c() {
        try {
            if ((f2965l.intValue() & 64) != 0) {
                return f2964k;
            }
            f2965l.addAndGet(64);
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean d() {
        try {
            if ((f2965l.intValue() & 2048) != 0) {
                return f2963j;
            }
            f2965l.addAndGet(2048);
            Class.forName("cn.jiguang.joperate.api.JOperateInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static synchronized void a(List<Integer> list, List<Integer> list2) {
        synchronized (b.class) {
            if (list2 == null) {
                try {
                    list2 = new ArrayList<>();
                } catch (Throwable unused) {
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            HashSet<Integer> hashSet = new HashSet(list2);
            HashSet<Integer> hashSet2 = new HashSet(list);
            if (f2957d.isEmpty() && f2958e.isEmpty()) {
                if (f2962i) {
                    hashSet.addAll(f2954a);
                }
                if (f2963j) {
                    hashSet.addAll(f2955b);
                }
                if (f2964k) {
                    hashSet.addAll(f2956c);
                }
            } else {
                hashSet.addAll(f2957d);
                hashSet2.addAll(f2958e);
            }
            f2957d.clear();
            f2958e.clear();
            for (Integer num : hashSet2) {
                num.intValue();
                if (!list2.contains(num)) {
                    f2958e.add(num);
                }
            }
            for (Integer num2 : hashSet) {
                num2.intValue();
                if (!list.contains(num2)) {
                    f2957d.add(num2);
                }
            }
        }
    }

    public static synchronized boolean a(Object obj) {
        synchronized (b.class) {
            try {
                f2959f = -1;
                f2960g = -1;
                f2961h = -1;
                if (obj instanceof List) {
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        a(((Integer) it.next()).intValue());
                    }
                } else {
                    a(((Integer) obj).intValue());
                }
                if (f2962i && !f2954a.contains(Integer.valueOf(f2959f))) {
                    f.a(10000, "JDataConfigManager", "isPluginJPush is true,not can control");
                    return false;
                }
                if (f2963j && !f2955b.contains(Integer.valueOf(f2960g))) {
                    f.a(10000, "JDataConfigManager", "isIsPluginJOperate is true,not can control");
                    return false;
                }
                if (!f2964k || f2956c.contains(Integer.valueOf(f2961h))) {
                    return true;
                }
                f.a(10000, "JDataConfigManager", "isPluginVerification is true,not can control");
                return false;
            } catch (Throwable th) {
                f.c("JDataConfigManager", "isUserCanControlData throwable=" + th);
                return false;
            }
        }
    }
}
