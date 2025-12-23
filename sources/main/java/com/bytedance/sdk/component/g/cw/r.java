package com.bytedance.sdk.component.g.cw;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: r, reason: collision with root package name */
    private static final Object f26431r = new Object();
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f26432j;
    private int up;
    private cw xt = new cw();

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126 A[Catch: all -> 0x0074, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6 A[Catch: all -> 0x0074, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2 A[Catch: all -> 0x0074, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.cw.r.j(org.json.JSONObject):void");
    }

    public void xt() {
        try {
            String j6 = com.bytedance.sdk.component.g.r.r.j(this.f26432j, 1, this.up);
            if (TextUtils.isEmpty(j6)) {
                com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            cw xt = xt(new JSONObject(j6));
            StringBuilder sb = new StringBuilder("loadLocalConfigForOtherProcess, config: ");
            sb.append(xt == null ? "null" : xt.toString());
            com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", sb.toString());
            if (xt != null) {
                this.xt = xt;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public cw cw() {
        return this.xt;
    }

    public r(Context context, boolean z5, int i6) {
        this.f26432j = context;
        this.cw = z5;
        this.up = i6;
    }

    private cw xt(JSONObject jSONObject) {
        try {
            cw cwVar = new cw();
            if (jSONObject.has("local_enable")) {
                cwVar.f26420j = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                cwVar.xt = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        String string = jSONArray.getString(i6);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                cwVar.cw = hashMap;
            } else {
                cwVar.cw = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                cwVar.f26422r = hashMap2;
            } else {
                cwVar.f26422r = null;
            }
            cwVar.up = jSONObject.optInt("req_to_cnt", cwVar.up);
            cwVar.f26421m = jSONObject.optInt("req_to_api_cnt", cwVar.f26421m);
            cwVar.ae = jSONObject.optInt("req_to_ip_cnt", cwVar.ae);
            cwVar.tl = jSONObject.optInt("req_err_cnt", cwVar.tl);
            cwVar.f26419g = jSONObject.optInt("req_err_api_cnt", cwVar.f26419g);
            cwVar.oq = jSONObject.optInt("req_err_ip_cnt", cwVar.oq);
            cwVar.qv = jSONObject.optInt("update_interval", cwVar.qv);
            cwVar.vl = jSONObject.optInt("update_random_range", cwVar.vl);
            cwVar.jy = jSONObject.optString("http_code_black", cwVar.jy);
            return cwVar;
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    public void j() {
        if (this.cw) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.f26432j, ae.j().j(this.up).j(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                cw xt = xt(new JSONObject(string));
                if (xt != null) {
                    this.xt = xt;
                }
                StringBuilder sb = new StringBuilder("loadLocalConfig: ");
                sb.append(xt == null ? "null" : xt.toString());
                com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                vl.j(th);
                com.bytedance.sdk.component.g.r.cw.xt("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
