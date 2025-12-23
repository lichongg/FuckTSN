package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ak {
    private static final String A = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    private static final String B = "aW8ueHVkd29mdGVuY2VudG1t";
    private static final String C = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    private static final String D = "Y29tLnR4eS5hbnl3aGVyZQ==";
    private static final String E = "Y29tLmRpbmd3ZWkueHVuaWpp";
    private static final String F = "bWUud2Vpc2h1LmV4cA==";
    private static final String G = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    private static final String H = "ZXUuZmFpcmNvZGUueGx1YQ==";
    private static final String I = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    private static final String J = "Y29tLndpbmQuY290dGVy";
    private static final String K = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";

    /* renamed from: a, reason: collision with root package name */
    private static final String f35705a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35706b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35707c = "b3JnLmF1dG9qcy5hdXRvanM=";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35708d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35709e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";

    /* renamed from: f, reason: collision with root package name */
    private static final String f35710f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";

    /* renamed from: g, reason: collision with root package name */
    private static final String f35711g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";

    /* renamed from: h, reason: collision with root package name */
    private static final String f35712h = "Y29tLm13ci5keg==";

    /* renamed from: i, reason: collision with root package name */
    private static final String f35713i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";

    /* renamed from: j, reason: collision with root package name */
    private static final String f35714j = "Y29tLng4enMuc2FuZGJveA==";

    /* renamed from: k, reason: collision with root package name */
    private static final String f35715k = "Y29tLmYxcGxheWVy";

    /* renamed from: l, reason: collision with root package name */
    private static final String f35716l = "Y29tLmNvZmZhY2UuaXZhZGVy";

    /* renamed from: m, reason: collision with root package name */
    private static final String f35717m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";

    /* renamed from: n, reason: collision with root package name */
    private static final String f35718n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";

    /* renamed from: o, reason: collision with root package name */
    private static final String f35719o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";

    /* renamed from: p, reason: collision with root package name */
    private static final String f35720p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";

    /* renamed from: q, reason: collision with root package name */
    private static final String f35721q = "Y29tLm1pbmkubGl2ZS5saXZl";

    /* renamed from: r, reason: collision with root package name */
    private static final String f35722r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";

    /* renamed from: s, reason: collision with root package name */
    private static final String f35723s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";

    /* renamed from: t, reason: collision with root package name */
    private static final String f35724t = "dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==";

    /* renamed from: u, reason: collision with root package name */
    private static final String f35725u = "dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==";

    /* renamed from: v, reason: collision with root package name */
    private static final String f35726v = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";

    /* renamed from: w, reason: collision with root package name */
    private static final String f35727w = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";

    /* renamed from: x, reason: collision with root package name */
    private static final String f35728x = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";

    /* renamed from: y, reason: collision with root package name */
    private static final String f35729y = "Y29tLnNrLnNwcm9tb3Rlcg==";

    /* renamed from: z, reason: collision with root package name */
    private static final String f35730z = "Y29tLnNlc2FtZS5wcm94eQ==";

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(context, f35705a) ? 1 : 0);
            jSONObject.put("1", a(context, f35706b) ? 1 : 0);
            jSONObject.put("2", a(context, f35707c) ? 1 : 0);
            jSONObject.put("3", a(context, f35708d) ? 1 : 0);
            jSONObject.put("4", a(context, f35709e) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject n(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35710f)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35711g)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f35712h)) {
                jSONObject.put("2", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject o(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35705a)) {
                jSONObject.put("0", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject p(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35714j)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35715k)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject q(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35716l)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35717m)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f35718n)) {
                jSONObject.put("2", 1);
            }
            if (a(context, f35719o)) {
                jSONObject.put("3", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject r(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35720p)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35721q)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b(Context context) {
        return a(context, f35713i) ? 1 : 0;
    }

    public JSONObject h(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35722r);
            arrayList.add(f35723s);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject i(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35726v);
            arrayList.add(f35727w);
            arrayList.add(J);
            arrayList.add(K);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject j(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35728x);
            arrayList.add(f35729y);
            arrayList.add(G);
            arrayList.add(H);
            arrayList.add(I);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject k(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35730z);
            arrayList.add(A);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject l(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(B);
            arrayList.add(C);
            arrayList.add(D);
            arrayList.add(E);
            arrayList.add(F);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject m(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35724t);
            arrayList.add(f35725u);
            JSONObject a6 = a(context, arrayList);
            if (a6 == null) {
                return null;
            }
            if (a6.length() > 0) {
                return a6;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject c(Context context) {
        try {
            JSONObject o5 = o(context);
            if (o5 != null) {
                if (o5.length() > 0) {
                    return o5;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        try {
            JSONObject n6 = n(context);
            if (n6 != null) {
                if (n6.length() > 0) {
                    return n6;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e(Context context) {
        try {
            JSONObject p5 = p(context);
            if (p5 != null) {
                if (p5.length() > 0) {
                    return p5;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f(Context context) {
        try {
            JSONObject q5 = q(context);
            if (q5 != null) {
                if (q5.length() > 0) {
                    return q5;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject g(Context context) {
        try {
            JSONObject r5 = r(context);
            if (r5 != null) {
                if (r5.length() > 0) {
                    return r5;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.contains(".")) {
                str = new String(c.a(str.getBytes(), 2));
            }
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private JSONObject a(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (a(context, list.get(i6))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i6);
                    jSONObject.put(sb.toString(), 1);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
            for (int i6 = 0; i6 < 20; i6++) {
                if (new File(strArr[i6]).exists()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
