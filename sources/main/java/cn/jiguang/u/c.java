package cn.jiguang.u;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.q.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f3277a = "";

    private static cn.jiguang.t.a a(String str, int i6, List<cn.jiguang.t.a> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (cn.jiguang.t.a aVar : list) {
                if (a(str, i6, aVar)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public static String a(final Context context) {
        Object a6 = cn.jiguang.q.d.a(context, 1012, 1800000L, 864000000L, new d.a() { // from class: cn.jiguang.u.c.1
            @Override // cn.jiguang.q.d.b
            public Object a() {
                return c.d(context);
            }

            @Override // cn.jiguang.q.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    c.f3277a = (String) obj;
                }
            }

            @Override // cn.jiguang.q.d.b
            public Object c() {
                return c.f3277a;
            }
        });
        return cn.jiguang.q.e.a(a6) ? "" : (String) a6;
    }

    public static String a(Context context, String str) {
        String d6 = cn.jiguang.bz.a.a().d(context, "");
        if (!TextUtils.isEmpty(d6)) {
            return d6;
        }
        ArrayList<cn.jiguang.t.a> b6 = b.b(context);
        if (b6 != null && !b6.isEmpty()) {
            Iterator<cn.jiguang.t.a> it = b6.iterator();
            while (it.hasNext()) {
                cn.jiguang.t.a next = it.next();
                if (!TextUtils.isEmpty(next.f3246a)) {
                    return next.f3246a;
                }
            }
        }
        return str;
    }

    public static List<cn.jiguang.t.a> b(Context context) {
        cn.jiguang.t.a a6;
        cn.jiguang.t.a a7 = b.a(context);
        ArrayList<cn.jiguang.t.a> a8 = d.a(context);
        ArrayList<cn.jiguang.t.a> b6 = b.b(context);
        if (a8 != null && !a8.isEmpty()) {
            for (int size = a8.size() - 1; size >= 0; size--) {
                if (a8.get(size).b()) {
                    a8.remove(size);
                }
            }
        }
        if (a8 != null && !a8.isEmpty()) {
            for (cn.jiguang.t.a aVar : a8) {
                if (TextUtils.isEmpty(aVar.f3246a) && !TextUtils.isEmpty(aVar.f3247b)) {
                    cn.jiguang.t.a a9 = a(aVar.f3247b, 1, b6);
                    if (a9 != null) {
                        aVar.f3246a = a9.f3246a;
                    }
                } else if (TextUtils.isEmpty(aVar.f3247b) && !TextUtils.isEmpty(aVar.f3246a) && (a6 = a(aVar.f3246a, 1, b6)) != null) {
                    aVar.f3247b = a6.f3247b;
                    aVar.f3248c = a6.f3248c;
                }
            }
            return a8;
        }
        if (a7 != null && !a7.b()) {
            if (b6 != null && b6.size() == 1) {
                if (!TextUtils.isEmpty(a7.f3246a) && a7.f3246a.equals(b6.get(0).f3246a)) {
                    if (!TextUtils.isEmpty(a7.f3247b) && !a7.f3247b.equals(b6.get(0).f3247b)) {
                        b6.add(a7);
                        return b6;
                    }
                    return b6;
                }
                if (!TextUtils.isEmpty(a7.f3247b) && a7.f3247b.equals(b6.get(0).f3247b)) {
                    a7.f3247b = "";
                    a7.f3248c = "";
                    if (!a7.b()) {
                        b6.add(a7);
                        return b6;
                    }
                    return b6;
                }
                b6.add(a7);
                return b6;
            }
            cn.jiguang.t.a a10 = a(a7.f3246a, 0, b6);
            if (a10 != null && TextUtils.isEmpty(a10.f3247b) && a(a7.f3247b, 1, b6) == null) {
                return a(a7.f3246a, 0, b6, a7);
            }
            return b6;
        }
        return b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context) {
        StringBuilder sb;
        String str;
        String d6 = cn.jiguang.bz.a.a().d(context, "");
        if (a(d6)) {
            sb = new StringBuilder();
            str = "JCommonPresenter.getImei is ";
        } else if (!TextUtils.isEmpty(d6)) {
            sb = new StringBuilder();
            str = "getMeidForM or O is ";
        } else {
            if (!a(d6)) {
                return "";
            }
            sb = new StringBuilder();
            str = "JDeviceImeiHelper.getMeid is ";
        }
        sb.append(str);
        sb.append(d6);
        f.c("JDeviceSimHelper", sb.toString());
        return d6;
    }

    private static List<cn.jiguang.t.a> a(String str, int i6, List<cn.jiguang.t.a> list, cn.jiguang.t.a aVar) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str) || aVar == null) {
            return null;
        }
        Iterator<cn.jiguang.t.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cn.jiguang.t.a next = it.next();
            if (a(str, i6, next)) {
                next.f3247b = aVar.f3247b;
                next.f3248c = aVar.f3248c;
                break;
            }
        }
        return list;
    }

    private static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.trim().length() == 0 || str.length() != 14) ? false : true;
    }

    private static boolean a(String str, int i6, cn.jiguang.t.a aVar) {
        return i6 != 0 ? i6 != 1 ? i6 == 2 && str.equals(aVar.f3248c) : str.equals(aVar.f3247b) : str.equals(aVar.f3246a);
    }
}
