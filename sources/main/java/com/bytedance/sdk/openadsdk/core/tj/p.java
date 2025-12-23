package com.bytedance.sdk.openadsdk.core.tj;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class p {
    private static final List<cw> xt = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public static boolean f30389j = false;

    public static class cw {
        private final List<r> cw = new ArrayList();

        /* renamed from: j, reason: collision with root package name */
        private final String f30391j;
        private final String xt;

        public r cw() {
            if (this.cw.isEmpty()) {
                return null;
            }
            return this.cw.get(0);
        }

        public List<r> getResources() {
            return this.cw;
        }

        public String j() {
            return this.f30391j;
        }

        public String r() {
            String str = this.f30391j;
            if (cw() == null) {
                return str;
            }
            return str + "$" + com.bytedance.sdk.component.utils.up.xt(cw().xt());
        }

        public JSONObject up() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.f30391j);
                jSONObject.put("prefix", this.xt);
                JSONArray jSONArray = new JSONArray();
                Iterator<r> it = this.cw.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().r());
                }
                jSONObject.put("resource", jSONArray);
                return jSONObject;
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return jSONObject;
            }
        }

        public String xt() {
            return this.xt;
        }

        public cw(JSONObject jSONObject) {
            this.f30391j = jSONObject.optString("channel");
            this.xt = jSONObject.optString("prefix");
            JSONArray optJSONArray = jSONObject.optJSONArray("resource");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        this.cw.add(new r(optJSONObject));
                    }
                }
            }
        }
    }

    public interface j {
        void j(cw cwVar);

        void xt(cw cwVar);
    }

    public static class r {
        private final List<xt> cw = new ArrayList();

        /* renamed from: j, reason: collision with root package name */
        private final String f30392j;
        private final String xt;

        public List<xt> cw() {
            return this.cw;
        }

        public String j() {
            return this.f30392j;
        }

        public JSONObject r() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.f30392j);
                jSONObject.put("content_hash", this.xt);
                JSONArray jSONArray = new JSONArray();
                Iterator<xt> it = this.cw.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().cw());
                }
                jSONObject.put("channel_resource_list", jSONArray);
                return jSONObject;
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return jSONObject;
            }
        }

        public String xt() {
            return this.xt;
        }

        public r(JSONObject jSONObject) {
            this.f30392j = jSONObject.optString("resource_url");
            this.xt = jSONObject.optString("content_hash");
            JSONArray optJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        this.cw.add(new xt(optJSONObject));
                    }
                }
            }
        }
    }

    public static class xt {
        private final String cw;

        /* renamed from: j, reason: collision with root package name */
        private final long f30393j;

        /* renamed from: m, reason: collision with root package name */
        private final String f30394m;

        /* renamed from: r, reason: collision with root package name */
        private final String f30395r;
        private final String up;
        private final String xt;

        public JSONObject cw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.f30393j);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.xt);
                jSONObject.put("content_hash", this.cw);
                jSONObject.put("mime_type", this.up);
                jSONObject.put("file_name", this.f30394m);
                jSONObject.put("url", this.f30395r);
                return jSONObject;
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return jSONObject;
            }
        }

        public String j() {
            return this.up;
        }

        public String xt() {
            return this.f30394m;
        }

        public xt(JSONObject jSONObject) {
            this.f30393j = jSONObject.optLong("size", 0L);
            this.xt = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.cw = jSONObject.optString("content_hash");
            this.f30395r = jSONObject.optString("url");
            this.up = jSONObject.optString("mime_type");
            this.f30394m = jSONObject.optString("file_name");
        }
    }

    public static void j(JSONObject jSONObject, j jVar) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.n.j().j(jVar);
        f30389j = jSONObject.optBoolean("h5_cache_resources_enable", false);
        xt(jSONObject, jVar);
    }

    private static void xt(JSONObject jSONObject, final j jVar) {
        if (f30389j) {
            final ArrayList arrayList = new ArrayList();
            String str = "h5_cache_resources";
            JSONArray optJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        arrayList.add(new cw(optJSONObject));
                    }
                }
            }
            com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g(str) { // from class: com.bytedance.sdk.openadsdk.core.tj.p.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.rn.n.j().j(arrayList, jVar);
                }
            });
        }
    }

    public static List<cw> j() {
        return xt;
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        try {
            f30389j = xtVar.xt("h5_cache_resources_enable", false);
            JSONArray jSONArray = new JSONArray(xtVar.xt("h5_cache_resources", ""));
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    xt.add(new cw(optJSONObject));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        xtVar.j("h5_cache_resources_enable", f30389j);
    }

    public static synchronized void xt(com.bytedance.sdk.component.r.j.xt xtVar, cw cwVar) {
        synchronized (p.class) {
            try {
                List<cw> list = xt;
                list.remove(cwVar);
                JSONArray jSONArray = new JSONArray();
                Iterator<cw> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().up());
                }
                xtVar.j("h5_cache_resources", jSONArray.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void j(com.bytedance.sdk.component.r.j.xt xtVar, cw cwVar) {
        synchronized (p.class) {
            try {
                List<cw> list = xt;
                list.add(cwVar);
                JSONArray jSONArray = new JSONArray();
                Iterator<cw> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().up());
                }
                xtVar.j("h5_cache_resources", jSONArray.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
