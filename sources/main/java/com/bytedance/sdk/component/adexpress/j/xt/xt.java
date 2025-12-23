package com.bytedance.sdk.component.adexpress.j.xt;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.j.cw.j;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    static Object f25837j = new Object();

    public static String cw() {
        return m.cw();
    }

    public static com.bytedance.sdk.component.adexpress.j.cw.j r() {
        return up.xt().up();
    }

    public static boolean up() {
        return up.xt().r();
    }

    public static void xt() {
        try {
            tl.r();
            File ae = up.ae();
            if (ae == null || !ae.exists()) {
                return;
            }
            if (ae.getParentFile() != null) {
                com.bytedance.sdk.component.utils.m.cw(ae.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.m.cw(ae);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean cw(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.j r5;
        List<j.C0397j> resources;
        if (!up() || (r5 = r()) == null || (resources = r5.getResources()) == null) {
            return false;
        }
        for (j.C0397j c0397j : resources) {
            if (c0397j != null && TextUtils.equals(str, c0397j.j())) {
                return true;
            }
        }
        return false;
    }

    public static void j() {
        up.xt();
    }

    private static File r(String str) {
        if (up()) {
            Iterator<j.C0397j> it = r().getResources().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j.C0397j next = it.next();
                if (next.j() != null && next.j().equals(str)) {
                    File file = new File(up.ae(), com.bytedance.sdk.component.utils.up.xt(next.j()));
                    String j6 = com.bytedance.sdk.component.utils.up.j(file);
                    if (next.xt() == null || !next.xt().equals(j6)) {
                        break;
                    }
                    return file;
                }
            }
        }
        return null;
    }

    private static File up(String str) {
        List<Pair<String, String>> xt;
        j.xt up = r().up();
        if (up != null && (xt = up.xt()) != null && xt.size() > 0) {
            for (Pair<String, String> pair : xt) {
                Object obj = pair.second;
                if (obj != null && ((String) obj).equals(str)) {
                    return new File(up.ae(), (String) pair.first);
                }
            }
        }
        return null;
    }

    public static void j(com.bytedance.sdk.component.adexpress.j.cw.r rVar) {
        ae.j().j(rVar, rVar.f25813m);
    }

    @Deprecated
    private static String m() {
        com.bytedance.sdk.component.adexpress.j.cw.j r5 = r();
        if (r5 == null) {
            return null;
        }
        return r5.r();
    }

    public static Set<com.bytedance.sdk.component.adexpress.j.cw.xt> j(String str, boolean z5) {
        final Set<com.bytedance.sdk.component.adexpress.j.cw.xt> xt = ae.j().xt(str);
        if (xt != null && xt.size() > 0) {
            if (z5) {
                com.bytedance.sdk.component.adexpress.r.up.j(new g("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.j.xt.xt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.xt((Set<com.bytedance.sdk.component.adexpress.j.cw.xt>) xt);
                    }
                }, 5);
                return xt;
            }
            xt(xt);
        }
        return xt;
    }

    public static boolean cw(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject == null || (opt = optJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Set<com.bytedance.sdk.component.adexpress.j.cw.xt> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.j.cw.xt xtVar : set) {
                xtVar.j(Long.valueOf(System.currentTimeMillis()));
                m.j().j(xtVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.j.cw.xt j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.j.cw.xt j6 = ae.j().j(str);
        if (j6 != null) {
            j6.j(Long.valueOf(System.currentTimeMillis()));
            j(j6);
        }
        return j6;
    }

    public static String xt(String str) {
        com.bytedance.sdk.component.adexpress.j.cw.j jVar;
        com.bytedance.sdk.component.adexpress.j.cw.j r5 = r();
        if (r5 == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j6 = r5.j();
            if (j6 == null || j6.size() <= 0 || (jVar = j6.get(str)) == null) {
                return null;
            }
            return jVar.r();
        }
        return m();
    }

    private static void j(final com.bytedance.sdk.component.adexpress.j.cw.xt xtVar) {
        com.bytedance.sdk.component.adexpress.r.up.j(new g("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.j.xt.xt.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (xt.f25837j) {
                    m.j().j(xtVar, true);
                }
            }
        }, 10);
    }

    public static j j(String str, oq.j jVar, String str2, String str3) {
        File file;
        j jVar2 = new j();
        if (TextUtils.isEmpty(str3)) {
            file = null;
        } else {
            file = xt(str3, str);
            if (file != null) {
                jVar2.j(1);
            }
        }
        if (file == null && (file = up(str)) != null) {
            jVar2.j(3);
        }
        if (file == null && (file = r(str)) != null) {
            jVar2.j(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!j(str, str3)) {
                jVar2.j(4);
            }
        } else if (!cw(str)) {
            jVar2.j(6);
        }
        jVar2.getType();
        if (file != null) {
            try {
                jVar2.j(new WebResourceResponse(jVar.getType(), "utf-8", new FileInputStream(file)));
                return jVar2;
            } catch (Throwable th) {
                vl.cw("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return jVar2;
    }

    private static File xt(String str, String str2) {
        com.bytedance.sdk.component.adexpress.j.cw.j jVar;
        com.bytedance.sdk.component.adexpress.j.cw.j r5 = r();
        if (r5 != null && up()) {
            Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j6 = r5.j();
            if (j6.size() != 0 && (jVar = j6.get(str)) != null) {
                Iterator<j.C0397j> it = jVar.getResources().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    j.C0397j next = it.next();
                    if (next.j() != null && next.j().equals(str2)) {
                        File file = new File(up.ae(), com.bytedance.sdk.component.utils.up.xt(next.j()));
                        String j7 = com.bytedance.sdk.component.utils.up.j(file);
                        if (next.xt() == null || !next.xt().equals(j7)) {
                            break;
                        }
                        return file;
                    }
                }
            }
        }
        return null;
    }

    public static boolean xt(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }

    private static boolean j(String str, String str2) {
        com.bytedance.sdk.component.adexpress.j.cw.j r5;
        com.bytedance.sdk.component.adexpress.j.cw.j jVar;
        if (!up() || (r5 = r()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j6 = r5.j();
        if (j6.size() == 0 || (jVar = j6.get(str2)) == null) {
            return false;
        }
        for (j.C0397j c0397j : jVar.getResources()) {
            if (c0397j != null && TextUtils.equals(str, c0397j.j())) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }
}
