package com.bytedance.sdk.component.adexpress.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ae f25821j;
    private AtomicBoolean xt = new AtomicBoolean(false);

    public interface j {
        void j();

        void xt();
    }

    public Set<com.bytedance.sdk.component.adexpress.j.cw.xt> xt(String str) {
        return m.j().xt(str);
    }

    public static ae j() {
        if (f25821j == null) {
            synchronized (ae.class) {
                try {
                    if (f25821j == null) {
                        f25821j = new ae();
                    }
                } finally {
                }
            }
        }
        return f25821j;
    }

    private void xt() {
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() == null) {
            return;
        }
        int j6 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().j();
        if (j6 <= 0) {
            j6 = 100;
        }
        List<com.bytedance.sdk.component.adexpress.j.cw.xt> xt = m.j().xt();
        if (xt == null || xt.isEmpty() || j6 >= xt.size()) {
            if (xt != null) {
                xt.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.j.cw.xt xtVar : xt) {
            treeMap.put(xtVar.ae(), xtVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (xt.size() - (j6 * 0.75f));
        int i6 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i6 < size) {
                i6++;
                ((Long) entry.getKey()).getClass();
                com.bytedance.sdk.component.adexpress.j.cw.xt xtVar2 = (com.bytedance.sdk.component.adexpress.j.cw.xt) entry.getValue();
                if (xtVar2 != null) {
                    hashSet.add(xtVar2.xt());
                }
            }
        }
        j(hashSet);
        this.xt.set(false);
    }

    private ae() {
    }

    private JSONObject cw(String str) {
        com.bytedance.sdk.component.adexpress.j.j.cw cw = com.bytedance.sdk.component.adexpress.j.j.j.j().cw();
        if (cw == null) {
            return null;
        }
        com.bytedance.sdk.component.g.xt.cw up = cw.up();
        up.j(str);
        com.bytedance.sdk.component.g.xt j6 = up.j();
        if (j6 != null) {
            try {
                if (j6.tl() && j6.r() != null) {
                    return new JSONObject(j6.r());
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return null;
    }

    public com.bytedance.sdk.component.adexpress.j.cw.xt j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.j().j(str);
    }

    private JSONObject j(String str, j jVar) {
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() == null) {
            jVar.xt();
            return null;
        }
        com.bytedance.sdk.component.g.xt.cw up = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().up();
        up.j(str);
        com.bytedance.sdk.component.g.xt j6 = up.j();
        if (j6 != null) {
            try {
                if (j6.tl() && j6.r() != null) {
                    return new JSONObject(j6.r());
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        jVar.xt();
        return null;
    }

    private void xt(String str, String str2, String str3, String str4, String str5, String str6) {
        m.j().j(new com.bytedance.sdk.component.adexpress.j.cw.xt().j(str).xt(str2).cw(str3).r(str4).up(str5).m(str6).j(Long.valueOf(System.currentTimeMillis())), false);
        xt();
    }

    public void j(com.bytedance.sdk.component.adexpress.j.cw.r rVar, String str) {
        String str2;
        if (rVar == null) {
            vl.r("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str3 = rVar.f25812j;
        final String str4 = rVar.cw;
        final String str5 = rVar.xt;
        final String str6 = rVar.f25814r;
        final String str7 = rVar.up;
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null) {
            str2 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().m();
        } else {
            str2 = "";
        }
        final String str8 = TextUtils.isEmpty(str) ? str2 : str;
        if (TextUtils.isEmpty(str3)) {
            vl.r("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.r.up.j(new g("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.j.xt.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    ae.this.j(str3, str4, str5, str6, str7, str8);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        try {
            try {
                if (j(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            xt(str6, str, str3, str2, str4, str7);
                        }
                    }
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4)) {
                    j(str2, str6, str);
                } else if (TextUtils.isEmpty(str3)) {
                    j(str2, str6, str);
                } else {
                    xt(str6, str, str3, str2, str4, str7);
                }
                boolean j6 = tl.j(str7);
                if (!xt.up() || j6) {
                    up.xt().j(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void j(String str, String str2, String str3) {
        JSONObject cw;
        if (TextUtils.isEmpty(str) || (cw = cw(str)) == null) {
            return;
        }
        String optString = cw.optString(TKDownloadReason.KSAD_TK_MD5);
        String optString2 = cw.optString("version");
        String optString3 = cw.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.j.cw.xt j6 = new com.bytedance.sdk.component.adexpress.j.cw.xt().j(str2).xt(str3).cw(optString).r(str).up(optString3).m(optString2).j(Long.valueOf(System.currentTimeMillis()));
        m.j().j(j6, false);
        xt();
        if (tl.j(optString2)) {
            j6.m(optString2);
            up.xt().j(true);
        }
    }

    public synchronized void j(String str, String str2, String str3, String str4, String str5, String str6, j jVar) {
        String str7;
        try {
            try {
                if (j(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            xt(str6, str, str3, str2, str4, str7);
                            jVar.j();
                        }
                    }
                    jVar.j();
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4)) {
                    j(str2, str6, str, jVar);
                } else if (TextUtils.isEmpty(str3)) {
                    j(str2, str6, str, jVar);
                } else {
                    xt(str6, str, str3, str2, str4, str7);
                    jVar.j();
                }
                boolean j6 = tl.j(str7);
                if (!xt.up() || j6) {
                    up.xt().j(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void j(String str, String str2, String str3, j jVar) {
        if (TextUtils.isEmpty(str)) {
            jVar.xt();
            return;
        }
        JSONObject j6 = j(str, jVar);
        if (j6 != null) {
            String optString = j6.optString(TKDownloadReason.KSAD_TK_MD5);
            String optString2 = j6.optString("version");
            String optString3 = j6.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                com.bytedance.sdk.component.adexpress.j.cw.xt j7 = new com.bytedance.sdk.component.adexpress.j.cw.xt().j(str2).xt(str3).cw(optString).r(str).up(optString3).m(optString2).j(Long.valueOf(System.currentTimeMillis()));
                if (j7 != null && com.bytedance.sdk.component.adexpress.j.j.j.j().xt() != null) {
                    if (TextUtils.isEmpty(j7.xt())) {
                        jVar.xt();
                        return;
                    }
                    m.j().j(j7, false);
                    xt();
                    if (tl.j(optString2)) {
                        j7.m(optString2);
                        up.xt().j(true);
                    }
                    jVar.j();
                    return;
                }
                jVar.xt();
                return;
            }
            jVar.xt();
        }
    }

    public void j(Set<String> set) {
        try {
            m.j().j(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
