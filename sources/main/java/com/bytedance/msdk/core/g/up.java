package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.la;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends j {
    private static volatile up up;
    protected final Map<String, String> cw;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, double[]> f24466r;

    public static up r() {
        if (up == null) {
            synchronized (up.class) {
                try {
                    if (up == null) {
                        up = new up();
                    }
                } finally {
                }
            }
        }
        return up;
    }

    protected void j(int i6, double d6) {
        if (com.bytedance.msdk.core.xt.xt().hl()) {
            j(2, String.valueOf(i6), 1, d6);
        }
    }

    public Map<String, JSONObject> xt(int i6) {
        if (!com.bytedance.msdk.core.xt.xt().hl()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i6 == 2 ? this.f24466r : xt(this.cw)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> j6 = j(key, value);
                    JSONObject jSONObject3 = j6.get("config_req_label_value");
                    JSONObject jSONObject4 = j6.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        hashMap.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            hashMap.put("config_req_label_value_root", jSONObject2);
        }
        r(i6);
        return hashMap;
    }

    private up() {
        super("label_v_v_s");
        this.cw = new ConcurrentHashMap();
        this.f24466r = new ConcurrentHashMap();
        xt();
    }

    public static String cw(int i6) {
        com.bytedance.msdk.core.oq.cw cwVar;
        if (!com.bytedance.msdk.core.xt.xt().hl() || (cwVar = com.bytedance.msdk.core.xt.xt().ol().get(String.valueOf(i6))) == null) {
            return null;
        }
        return cwVar.j();
    }

    private Map<String, JSONObject> j(String str, double[] dArr) {
        JSONObject jSONObject;
        JSONException e6;
        HashMap hashMap = new HashMap();
        String j6 = j(dArr);
        JSONObject jSONObject2 = null;
        try {
        } catch (JSONException e7) {
            jSONObject = null;
            e6 = e7;
        }
        if (!j6.equals("-1")) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("input", xt(j6));
                jSONObject.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e8) {
                e6 = e8;
                vl.j(e6);
                jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("ecpm", j6);
                jSONObject4.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject3.putOpt("ecpm_info", jSONObject4);
                hashMap.put("config_req_label_value", jSONObject2);
                hashMap.put("event_label_value", jSONObject3);
                return hashMap;
            }
            jSONObject2 = jSONObject;
        }
        JSONObject jSONObject32 = new JSONObject();
        JSONObject jSONObject42 = new JSONObject();
        try {
            jSONObject42.putOpt("ecpm", j6);
            jSONObject42.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject32.putOpt("ecpm_info", jSONObject42);
        } catch (JSONException e9) {
            vl.j(e9);
        }
        hashMap.put("config_req_label_value", jSONObject2);
        hashMap.put("event_label_value", jSONObject32);
        return hashMap;
    }

    public static String up() {
        if (!com.bytedance.msdk.core.xt.xt().hl()) {
            return null;
        }
        Set<Map.Entry<String, com.bytedance.msdk.core.oq.cw>> entrySet = com.bytedance.msdk.core.xt.xt().ol().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.core.oq.cw> entry : entrySet) {
            String key = entry.getKey();
            com.bytedance.msdk.core.oq.cw value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.j());
                jSONObject2.putOpt("timestamp", value.xt());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.m()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.up()));
                jSONObject.putOpt(j.j(Integer.parseInt(key)), jSONObject2);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return jSONObject.toString();
    }

    private void r(int i6) {
        if (i6 == 2) {
            this.f24466r.clear();
            return;
        }
        this.cw.clear();
        l lVar = this.xt;
        if (lVar != null) {
            lVar.cw();
        }
    }

    public void j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.bytedance.msdk.core.xt.xt().hl() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    private Map<String, double[]> xt(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] split = value.split("_");
                        String str = split[0];
                        String str2 = split[1];
                        String str3 = split[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.bytedance.msdk.core.xt.xt().j(System.currentTimeMillis() - Long.parseLong(split[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    public void j(JSONObject jSONObject) {
        if (com.bytedance.msdk.core.xt.xt().hl()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.oq.cw> entry : com.bytedance.msdk.core.xt.xt().ol().entrySet()) {
                String key = entry.getKey();
                com.bytedance.msdk.core.oq.cw value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, j(value));
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e7) {
                vl.j(e7);
            }
        }
    }

    protected void j(boolean z5, com.bytedance.msdk.up.r rVar, JSONObject jSONObject, Map<String, Object> map) {
        rVar.j(MediationConstant.KEY_REASON, Integer.valueOf(!z5 ? 1 : 0));
        if (map != null) {
            xt(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected JSONObject j(com.bytedance.msdk.core.oq.cw cwVar) {
        if (cwVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", cwVar.j());
            jSONObject.putOpt("label_id", Integer.valueOf(cwVar.cw()));
            jSONObject.putOpt("label_version", cwVar.r());
            jSONObject.putOpt("upper_bound", Double.valueOf(cwVar.up()));
            jSONObject.putOpt("lower_bound", Double.valueOf(cwVar.m()));
            jSONObject.putOpt("timestamp", cwVar.xt());
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    private void xt(JSONObject jSONObject) {
        Map<String, com.bytedance.msdk.core.oq.cw> ol = com.bytedance.msdk.core.xt.xt().ol();
        if (ol.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.bytedance.msdk.core.oq.cw> entry : ol.entrySet()) {
            String key = entry.getKey();
            com.bytedance.msdk.core.oq.cw value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), optJSONObject);
                        optJSONObject.put("ecpm_info", new JSONObject());
                    }
                    optJSONObject.putOpt("label_info", j(value));
                    optJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.xt.xt().b()));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
    }

    public void j(Map<String, ConcurrentHashMap<String, List<ae>>> map) {
        int i6;
        ConcurrentHashMap<String, List<ae>> value;
        if (!com.bytedance.msdk.core.xt.xt().hl() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<ae>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<ae>> value2 = entry.getValue();
            if (value2 != null) {
                Iterator<Map.Entry<String, List<ae>>> it = value2.entrySet().iterator();
                while (it.hasNext()) {
                    List<ae> value3 = it.next().getValue();
                    if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).f24739j != null) {
                        i6 = value3.get(0).f24739j.om();
                        break;
                    }
                }
            }
            i6 = 0;
            com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.ae.j.cw.j().j(key, i6, 101);
            if (j6 != null && j6.m() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<ae>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<ae> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).f24739j != null) {
                        la.j(value4);
                        ae aeVar = value4.get(0);
                        xt(aeVar.f24739j.om(), aeVar.f24739j.t());
                    }
                }
            }
        }
        com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt()).j(2);
    }

    @Override // com.bytedance.msdk.core.g.j
    protected boolean xt(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.bytedance.msdk.core.oq.cw cwVar = com.bytedance.msdk.core.xt.xt().ol().get(str);
        if (cwVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", j(cwVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.xt.xt().b()));
            return true;
        } catch (JSONException e6) {
            vl.j(e6);
            return false;
        }
    }

    public void xt(int i6, double d6) {
        if (com.bytedance.msdk.core.xt.xt().hl()) {
            String valueOf = String.valueOf(i6);
            double[] dArr = this.f24466r.get(valueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d6;
            this.f24466r.put(valueOf, dArr);
        }
    }

    @Override // com.bytedance.msdk.core.g.j
    protected void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.cw.put(str, str2);
    }

    @Override // com.bytedance.msdk.core.g.j
    protected Map<String, String> j() {
        return this.cw;
    }

    @Override // com.bytedance.msdk.core.g.j
    protected void j(String str, int i6, String str2) {
        if (i6 == 2) {
            this.cw.put(str, str2);
        }
    }
}
