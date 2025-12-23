package com.bytedance.sdk.component.adexpress.j.cw;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f25807j;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, j> f25808m = new ConcurrentHashMap();

    /* renamed from: r, reason: collision with root package name */
    private List<C0397j> f25809r;
    private xt up;
    private String xt;

    /* renamed from: com.bytedance.sdk.component.adexpress.j.cw.j$j, reason: collision with other inner class name */
    public static class C0397j {
        private int cw;

        /* renamed from: j, reason: collision with root package name */
        private String f25810j;
        private String xt;

        public String j() {
            return this.f25810j;
        }

        public String xt() {
            return this.xt;
        }

        public int cw() {
            return this.cw;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0397j)) {
                return super.equals(obj);
            }
            String str2 = this.f25810j;
            if (str2 != null) {
                C0397j c0397j = (C0397j) obj;
                if (str2.equals(c0397j.j()) && (str = this.xt) != null && str.equals(c0397j.xt())) {
                    return true;
                }
            }
            return false;
        }

        public void j(String str) {
            this.f25810j = str;
        }

        public void xt(String str) {
            this.xt = str;
        }

        public void j(int i6) {
            this.cw = i6;
        }
    }

    public static class xt {
        private List<Pair<String, String>> cw;

        /* renamed from: j, reason: collision with root package name */
        private String f25811j;
        private String xt;

        public String j() {
            return this.f25811j;
        }

        public void xt(String str) {
            this.xt = str;
        }

        public void j(String str) {
            this.f25811j = str;
        }

        public List<Pair<String, String>> xt() {
            return this.cw;
        }

        public void j(List<Pair<String, String>> list) {
            this.cw = list;
        }
    }

    public String cw() {
        return this.xt;
    }

    public Map<String, j> j() {
        return this.f25808m;
    }

    public String r() {
        return this.cw;
    }

    public String xt() {
        return this.f25807j;
    }

    public static j r(String str) {
        if (str == null) {
            return null;
        }
        try {
            return j(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject ae() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(CommonNetImpl.NAME, xt());
            jSONObject.putOpt("version", cw());
            jSONObject.putOpt("main", r());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0397j c0397j : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0397j.j());
                    jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0397j.xt());
                    jSONObject2.putOpt("level", Integer.valueOf(c0397j.cw()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.f25808m.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z5 = false;
                for (String str : this.f25808m.keySet()) {
                    j jVar = this.f25808m.get(str);
                    if (jVar != null) {
                        jSONObject3.put(str, jVar.ae());
                        z5 = true;
                    }
                }
                if (z5) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            xt up = up();
            if (up != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", up.f25811j);
                jSONObject4.put(TKDownloadReason.KSAD_TK_MD5, up.xt);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> xt2 = up.xt();
                if (xt2 != null) {
                    for (Pair<String, String> pair : xt2) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void cw(String str) {
        this.cw = str;
    }

    public List<C0397j> getResources() {
        if (this.f25809r == null) {
            this.f25809r = new ArrayList();
        }
        return this.f25809r;
    }

    public void j(String str) {
        this.f25807j = str;
    }

    public xt up() {
        return this.up;
    }

    public void xt(String str) {
        this.xt = str;
    }

    public void j(xt xtVar) {
        this.up = xtVar;
    }

    public boolean m() {
        if (!TextUtils.isEmpty(r()) && !TextUtils.isEmpty(cw()) && !TextUtils.isEmpty(xt())) {
            return true;
        }
        return false;
    }

    public String tl() {
        JSONObject ae;
        if (m() && (ae = ae()) != null) {
            return ae.toString();
        }
        return null;
    }

    public void j(List<C0397j> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f25809r = list;
    }

    public static j j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.j(jSONObject.optString(CommonNetImpl.NAME));
        jVar.xt(jSONObject.optString("version"));
        jVar.cw(jSONObject.optString("main"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                C0397j c0397j = new C0397j();
                c0397j.j(optJSONObject2.optString("url"));
                c0397j.xt(optJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                c0397j.j(optJSONObject2.optInt("level"));
                arrayList.add(c0397j);
            }
        }
        jVar.j(arrayList);
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("engines");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    j j6 = j(optJSONObject3.optJSONObject(next));
                    if (j6 != null) {
                        jVar.j().put(next, j6);
                    }
                }
            }
        } catch (Exception e6) {
            e6.getMessage();
        }
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            xt xtVar = new xt();
            xtVar.j(optJSONObject.optString("url"));
            xtVar.xt(optJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("map");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList2.add(new Pair<>(next2, optJSONObject4.optString(next2)));
                }
                xtVar.j(arrayList2);
            }
            jVar.j(xtVar);
        }
        if (jVar.m()) {
            return jVar;
        }
        return null;
    }
}
