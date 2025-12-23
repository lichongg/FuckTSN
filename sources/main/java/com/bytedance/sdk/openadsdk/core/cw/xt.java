package com.bytedance.sdk.openadsdk.core.cw;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f28863j;
    private volatile SharedPreferences xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sp_dynamic_tmpl_config", 0);
    private volatile SharedPreferences cw = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sp_dynamic_tmpl_config_v3", 0);

    public static xt j() {
        if (f28863j == null) {
            synchronized (xt.class) {
                try {
                    if (f28863j == null) {
                        f28863j = new xt();
                    }
                } finally {
                }
            }
        }
        return f28863j;
    }

    public JSONArray xt(final String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!cw.j().j(i6)) {
            return j(str);
        }
        try {
            final String xt = xt(str, null, true);
            ae.xt(new g("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.cw.xt.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z5;
                    try {
                        Set<com.bytedance.sdk.openadsdk.core.nativeexpress.j.j> j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.j().j(str);
                        JSONArray jSONArray = new JSONArray();
                        if (j6 != null && j6.size() > 0) {
                            for (com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar : j6) {
                                if (jVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    String[] split = jVar.j().split("_");
                                    if (split.length == 2) {
                                        jSONObject.put("id", split[1]);
                                        jSONObject.put(TKDownloadReason.KSAD_TK_MD5, jVar.xt());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if ((xt == null && z5) || !jSONArray.toString().equals(xt)) {
                            xt.this.j(str, jSONArray.toString(), true);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            return new JSONArray(xt);
        } catch (Exception unused) {
            return null;
        }
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.j.cw.cw cwVar, boolean z5) {
        if (cwVar == null || cwVar.xt() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String xt = xt(str, null, z5);
            JSONArray jSONArray = xt == null ? new JSONArray() : new JSONArray(xt);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cwVar.xt());
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, cwVar.cw());
            jSONArray.put(jSONObject);
            j(str, jSONArray.toString(), z5);
        } catch (Exception unused) {
        }
    }

    public void delete(String str, String str2, boolean z5) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                String xt = xt(str, null, z5);
                if (!TextUtils.isEmpty(xt)) {
                    JSONArray jSONArray = new JSONArray(xt);
                    if (jSONArray.length() > 0) {
                        int i6 = 0;
                        while (true) {
                            if (i6 < jSONArray.length()) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                                if (optJSONObject != null && str2.equals(optJSONObject.getString("id"))) {
                                    break;
                                } else {
                                    i6++;
                                }
                            } else {
                                i6 = -1;
                                break;
                            }
                        }
                        if (i6 != -1) {
                            jSONArray.remove(i6);
                            j(str, jSONArray.toString(), z5);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void j(String str, String str2) {
        delete(str, str2, false);
    }

    public void j(String str, com.bytedance.sdk.component.adexpress.j.cw.cw cwVar) {
        update(str, cwVar, false);
    }

    public String xt(String str, String str2, boolean z5) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z5) {
                sharedPreferences = this.cw;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.xt;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.xt(str3, str, str2);
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public JSONArray j(final String str, int i6) {
        try {
            final String xt = xt(str, null, false);
            ae.xt(new g("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.cw.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z5;
                    try {
                        Set<com.bytedance.sdk.component.adexpress.j.cw.xt> j6 = com.bytedance.sdk.component.adexpress.j.xt.xt.j(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (j6 == null || j6.size() <= 0) {
                            z5 = false;
                        } else {
                            for (com.bytedance.sdk.component.adexpress.j.cw.xt xtVar : j6) {
                                if (xtVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", xtVar.xt());
                                    jSONObject.put(TKDownloadReason.KSAD_TK_MD5, xtVar.cw());
                                    jSONArray.put(jSONObject);
                                }
                            }
                            z5 = true;
                        }
                        if (!(xt == null && z5) && jSONArray.toString().equals(xt)) {
                            return;
                        }
                        xt.this.j(str, jSONArray.toString(), false);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            return new JSONArray(xt);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray j(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.nativeexpress.j.j> j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.j().j(str);
            if (j6 != null && j6.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.j.j jVar : j6) {
                    if (jVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        String[] split = jVar.j().split("_");
                        if (split.length == 2) {
                            jSONObject.put("id", split[1]);
                            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, jVar.xt());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e6) {
            vl.cw("BidOptTmplManager", "getUgenParentTplIds: ", e6);
            return null;
        }
    }

    public void j(String str, String str2, boolean z5) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z5) {
                sharedPreferences = this.cw;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.xt;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (cw.j().xt()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j(str3, str, str2);
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
