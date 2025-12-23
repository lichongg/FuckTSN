package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.ae.cw.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ATS(single = true, value = {"kv_store_factory"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.component.r.r {
    private static final Set<String> cw = new HashSet();
    private static File xt;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.r.j.xt> f27606j = new ConcurrentHashMap();

    private com.bytedance.sdk.component.ae.j cw() {
        return com.bytedance.sdk.component.ae.cw.up.j() ? new com.bytedance.sdk.component.ae.cw.up(null) : new m(null);
    }

    private com.bytedance.sdk.component.r.j.xt r(String str) {
        int lc = v.xt().lc();
        com.bytedance.sdk.openadsdk.core.p.m ve = v.xt().ve();
        if (lc != 3 || Build.VERSION.SDK_INT == 27) {
            return new com.bytedance.sdk.component.ae.cw.r(v.getContext().getSharedPreferences(up(str), 0));
        }
        File cw2 = cw(str);
        return new com.bytedance.sdk.component.ae.cw.cw(cw2, j(cw2, str), j(str, ve.f29801j), ve.xt);
    }

    private static File up() {
        String name;
        File filesDir = v.getContext().getFilesDir();
        do {
            name = filesDir.getName();
            if (name == null) {
                break;
            }
            filesDir = filesDir.getParentFile();
        } while (!name.equals("files"));
        return new File(filesDir, "shared_prefs");
    }

    @Override // com.bytedance.sdk.component.r.r
    @ATSMethod(1)
    public com.bytedance.sdk.component.r.j.xt j(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.bytedance.sdk.component.r.j.xt xtVar = this.f27606j.get(str);
        if (xtVar != null) {
            return xtVar;
        }
        synchronized (this.f27606j) {
            try {
                com.bytedance.sdk.component.r.j.xt xtVar2 = this.f27606j.get(str);
                if (xtVar2 != null) {
                    return xtVar2;
                }
                com.bytedance.sdk.component.r.j.xt r5 = r(str);
                this.f27606j.put(str, r5);
                return r5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.r
    @ATSMethod(5)
    public void xt() {
        synchronized (this.f27606j) {
            this.f27606j.clear();
        }
    }

    public cw() {
        cw.add("sp_bidding_opt_libra");
    }

    public static File cw(String str) {
        if (xt == null) {
            xt = up();
        }
        return new File(xt, up(str) + ".xml");
    }

    public static com.bytedance.sdk.component.r.j.xt xt(String str) {
        return ((com.bytedance.sdk.component.r.r) AutoService.j(com.bytedance.sdk.component.r.r.class)).j(str);
    }

    private static String up(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(str) : str;
    }

    @Override // com.bytedance.sdk.component.r.r
    @ATSMethod(2)
    public com.bytedance.sdk.component.r.j.xt j(String str, int i6) {
        return j(str);
    }

    private com.bytedance.sdk.component.ae.j j(File file, String str) {
        if (cw.contains(str)) {
            return cw();
        }
        if (h.xt >= 6900) {
            j(file);
            return new com.bytedance.sdk.component.ae.cw.j(null);
        }
        return cw();
    }

    private com.bytedance.sdk.component.ae.xt r() {
        if (com.bytedance.sdk.component.ae.cw.up.j()) {
            return new com.bytedance.sdk.component.ae.cw.up(null);
        }
        return new m(null);
    }

    private com.bytedance.sdk.component.ae.xt j(String str, boolean z5) {
        if (cw.contains(str)) {
            return r();
        }
        com.bytedance.sdk.component.ae.j.j jVar = z5 ? new com.bytedance.sdk.component.ae.j.j() : null;
        if (Build.VERSION.SDK_INT != 27 && h.xt >= 6900) {
            return new com.bytedance.sdk.component.ae.cw.j(jVar);
        }
        return r();
    }

    private void j(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    @Override // com.bytedance.sdk.component.r.r
    @ATSMethod(3)
    public com.bytedance.sdk.component.r.j.j j(int i6) {
        if (i6 != 32) {
            return null;
        }
        return new com.bytedance.sdk.component.ae.j.j();
    }

    @Override // com.bytedance.sdk.component.r.r
    @ATSMethod(4)
    public void j() {
        Iterator<String> it = this.f27606j.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.r.j.xt xtVar = this.f27606j.get(it.next());
            if (xtVar != null) {
                xtVar.xt();
            }
        }
    }

    public static SharedPreferences j(@ForbidWrapParam Context context, String str, int i6) {
        return xt(str);
    }
}
