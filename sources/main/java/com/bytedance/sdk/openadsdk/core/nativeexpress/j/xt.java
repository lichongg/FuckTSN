package com.bytedance.sdk.openadsdk.core.nativeexpress.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.rr;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.up;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f29668j;

    public interface j {
    }

    private void xt(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.j.j();
        jVar.cw(str).up(str3).r(str4).xt(str2).j(str5).j(Long.valueOf(System.currentTimeMillis()));
        cw.j().j(jVar, false);
        xt();
    }

    public static xt j() {
        if (f29668j == null) {
            synchronized (xt.class) {
                try {
                    if (f29668j == null) {
                        f29668j = new xt();
                    }
                } finally {
                }
            }
        }
        return f29668j;
    }

    public void j(rr rrVar, String str, String str2) {
        if (rrVar == null) {
            return;
        }
        if (TextUtils.isEmpty(rrVar.j())) {
            vl.r("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + rrVar.j();
        final String cw = rrVar.cw();
        final String xt = rrVar.xt();
        final String r5 = rrVar.r();
        if (TextUtils.isEmpty(str) && str2.equals(bi.az)) {
            str = oq.i().f();
        }
        final String str4 = str;
        ae.j(new g("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                xt.this.j(str3, cw, xt, r5, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        int zs = v.xt().zs();
        if (zs <= 0) {
            zs = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.nativeexpress.j.j> xt = cw.j().xt();
        if (xt == null || xt.isEmpty() || zs >= xt.size()) {
            if (xt != null) {
                xt.size();
                return;
            }
            return;
        }
        int size = (int) (xt.size() - (zs * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar : xt) {
            treeMap.put(jVar.r(), jVar);
        }
        HashSet hashSet = new HashSet();
        int i6 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i6 < size) {
                i6++;
                com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.j.j) entry.getValue();
                if (jVar2 != null) {
                    hashSet.add(jVar2.j());
                }
            }
        }
        j(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, String str3, String str4, String str5) {
        if (j(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            xt(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            j(str2, str, str3, str5, (j) null);
        } else {
            xt(str2, str3, str5, str4, str);
        }
    }

    private void j(final String str, final String str2, final String str3, final String str4, final j jVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.g.xt.cw cw = up.j().xt().cw();
        cw.j(str);
        cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.2
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar != null && xtVar.tl()) {
                    String r5 = xtVar.r();
                    if (TextUtils.isEmpty(r5)) {
                        return;
                    }
                    cw.j().j(new com.bytedance.sdk.openadsdk.core.nativeexpress.j.j().j(str2).xt(str3).cw(str).up(str4).r(r5).j(Long.valueOf(System.currentTimeMillis())), false);
                    xt.this.xt();
                    if (jVar != null) {
                        try {
                            new JSONObject(r5);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, IOException iOException) {
                if (jVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.bytedance.sdk.openadsdk.core.nativeexpress.j.j> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return cw.j().j(str);
    }

    public String j(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.j.j j6 = j(str + "_" + str2, str3);
        if (j6 == null) {
            return null;
        }
        j(j6);
        return j6.up();
    }

    private com.bytedance.sdk.openadsdk.core.nativeexpress.j.j j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return cw.j().j(str, str2);
    }

    private void j(final com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar) {
        jVar.j(Long.valueOf(System.currentTimeMillis()));
        ae.j(new g("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.3
            @Override // java.lang.Runnable
            public void run() {
                cw.j().j(jVar, true);
            }
        }, 10);
    }

    public void j(Set<String> set) {
        try {
            cw.j().j(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
