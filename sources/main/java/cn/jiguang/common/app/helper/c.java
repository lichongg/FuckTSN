package cn.jiguang.common.app.helper;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.common.app.entity.ControlGroup;
import cn.jiguang.common.app.helper.AndroidAppProcess;
import cn.jiguang.q.e;
import com.amap.api.services.core.AMapException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import xyz.adscope.common.network.cookie.db.Field;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2897a = {120, 101};

    /* renamed from: b, reason: collision with root package name */
    private static List<cn.jiguang.common.app.entity.d> f2898b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f2899c = Pattern.compile("^zygote[0-9]*$");

    private static int a(LinkedList<String> linkedList, String str, int i6) {
        int indexOf = linkedList.indexOf(str);
        if (indexOf == -1) {
            indexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return indexOf == -1 ? i6 : indexOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<cn.jiguang.common.app.entity.d> b(int i6) {
        boolean z5;
        try {
            List<String> a6 = cn.jiguang.v.c.a(new String[]{l.b(f2897a)}, 1);
            if (a6 != null && !a6.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                Map<String, Integer> a7 = a(a6.remove(0));
                Iterator<String> it = a6.iterator();
                while (it.hasNext()) {
                    cn.jiguang.common.app.entity.d a8 = a(it.next(), a7);
                    if (a8 != null) {
                        if (i6 == 3 || !b(a8.f2847c)) {
                            if (!"ps".equals(a8.f2848d)) {
                                a(a8);
                                arrayList.add(a8);
                            }
                        } else if (c(a8.f2848d)) {
                            hashSet.add(a8.f2846b);
                        }
                    }
                }
                if (i6 != 1 || hashSet.isEmpty()) {
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (boolean z6 = false; !z6; z6 = z5) {
                    Iterator it2 = arrayList.iterator();
                    z5 = true;
                    while (it2.hasNext()) {
                        cn.jiguang.common.app.entity.d dVar = (cn.jiguang.common.app.entity.d) it2.next();
                        if (hashSet.contains(dVar.f2847c)) {
                            arrayList2.add(dVar);
                            hashSet.add(dVar.f2846b);
                            it2.remove();
                            z5 = false;
                        }
                    }
                }
                return arrayList2;
            }
            cn.jiguang.bb.f.c("JProcessHelper", "execute command failed");
            return null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JProcessHelper", "getRunningProcessInfo throwable:" + th.getMessage());
            return null;
        }
    }

    private static cn.jiguang.common.app.entity.d a(String str, Map<String, Integer> map) {
        String[] split;
        int length;
        String str2;
        if (TextUtils.isEmpty(str) || (length = (split = str.split("\\s+")).length) < 3) {
            return null;
        }
        try {
            cn.jiguang.common.app.entity.d dVar = new cn.jiguang.common.app.entity.d();
            if (map != null && !map.isEmpty()) {
                dVar.f2845a = split[map.get("USER").intValue()];
                dVar.f2846b = split[map.get("PID").intValue()];
                dVar.f2847c = split[map.get("PPID").intValue()];
                str2 = split[map.get(Field.NAME).intValue()];
                dVar.f2848d = str2;
                return dVar;
            }
            dVar.f2845a = split[0];
            dVar.f2846b = split[1];
            dVar.f2847c = split[2];
            str2 = split[length - 1];
            dVar.f2848d = str2;
            return dVar;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JProcessHelper", "parseCommandResult throwable:" + th.getMessage());
            return null;
        }
    }

    private static boolean b(String str) {
        return str.equals("0") || str.equals("1") || str.equals("2");
    }

    private static boolean c(String str) {
        return f2899c.matcher(str).matches();
    }

    public static List<cn.jiguang.common.app.entity.d> a(Context context, final int i6) {
        Object a6 = cn.jiguang.q.e.a(context, AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT, new e.a() { // from class: cn.jiguang.common.app.helper.c.1
            @Override // cn.jiguang.q.e.b
            public Object a() {
                return c.f2898b;
            }

            @Override // cn.jiguang.q.e.b
            public void a(Object obj) {
                if (obj instanceof List) {
                    List unused = c.f2898b = (List) obj;
                }
            }

            @Override // cn.jiguang.q.e.b
            public Object b() {
                return c.b(i6);
            }
        });
        if (a6 instanceof List) {
            return (List) a6;
        }
        return null;
    }

    private static Map<String, Integer> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, str.split("\\s+"));
        int size = linkedList.size() - 1;
        HashMap hashMap = new HashMap();
        int a6 = a(linkedList, "USER", 0);
        int a7 = a(linkedList, "PID", 1);
        int a8 = a(linkedList, "PPID", 2);
        int a9 = a(linkedList, Field.NAME, size);
        if (a6 == 0 && a7 == 1 && a8 == 2 && a9 == size) {
            return null;
        }
        return hashMap;
    }

    private static void a(cn.jiguang.common.app.entity.d dVar) {
        String str;
        if (Build.VERSION.SDK_INT >= 24 || dVar == null) {
            return;
        }
        try {
            AndroidAppProcess androidAppProcess = new AndroidAppProcess(Integer.parseInt(dVar.f2846b));
            dVar.f2849e = androidAppProcess.f2874a ? 1 : 0;
            dVar.f2850f = String.valueOf(androidAppProcess.f().b());
            dVar.f2851g = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (androidAppProcess.f().j() * 10);
            dVar.f2852h = androidAppProcess.f().h();
            dVar.f2853i = androidAppProcess.f().i();
            dVar.f2854j = androidAppProcess.f().k();
            dVar.f2855k = androidAppProcess.f().c();
            try {
                ControlGroup a6 = androidAppProcess.b().a("cpuacct");
                ControlGroup a7 = androidAppProcess.b().a("cpu");
                dVar.f2856l = a6 != null ? a6.toString() : "";
                dVar.f2857m = a7 != null ? a7.toString() : "";
            } catch (Throwable unused) {
            }
            dVar.f2858n = androidAppProcess.f().d();
            dVar.f2859o = androidAppProcess.f().e();
            dVar.f2860p = androidAppProcess.f().f();
            dVar.f2861q = androidAppProcess.f().g();
            dVar.f2862r = androidAppProcess.f().l();
            dVar.f2863s = androidAppProcess.c();
            dVar.f2864t = androidAppProcess.d();
            dVar.f2865u = androidAppProcess.e();
        } catch (AndroidAppProcess.a unused2) {
        } catch (IOException unused3) {
            str = "Error reading from /proc/pid.";
            cn.jiguang.bb.f.i("JProcessHelper", str);
        } catch (Throwable unused4) {
            str = "process detail info from /proc file failed.";
            cn.jiguang.bb.f.i("JProcessHelper", str);
        }
    }
}
