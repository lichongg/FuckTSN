package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends r {
    private String ae;

    /* renamed from: g, reason: collision with root package name */
    private final String f24693g;

    /* renamed from: m, reason: collision with root package name */
    private List<up> f24694m;
    private j oq;
    private final String tl;

    public void j(String str, int i6) {
        for (up upVar : qv()) {
            if (TextUtils.equals(upVar.cw(), str)) {
                upVar.xt(i6);
                return;
            }
        }
    }

    public synchronized List<up> qv() {
        ae oq;
        List<up> list = this.f24694m;
        if (list != null && list.size() != 0) {
            return this.f24694m;
        }
        this.f24694m = new ArrayList();
        if (this.ae == null && (oq = jy.j().oq(this.f24711j)) != null) {
            this.ae = oq.ae;
        }
        if (TextUtils.isEmpty(this.ae)) {
            return this.f24694m;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.ae);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                up upVar = new up();
                String string = jSONObject.getString(this.oq.cw);
                if (!TextUtils.isEmpty(string)) {
                    upVar.j(jSONObject.optInt(this.oq.f24696j));
                    upVar.j(jSONObject.optLong(this.oq.xt));
                    upVar.j(string);
                    if (jSONObject.has("count")) {
                        upVar.xt(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        upVar.xt(jSONObject.optLong("effective_time"));
                    }
                    this.f24694m.add(upVar);
                }
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (this.f24694m.size() > 0) {
            Collections.sort(this.f24694m, new Comparator<up>() { // from class: com.bytedance.msdk.core.tl.ae.1
                @Override // java.util.Comparator
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public int compare(up upVar2, up upVar3) {
                    long xt = upVar2.xt() - upVar3.xt();
                    if (xt == 0) {
                        return 0;
                    }
                    if (xt > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        return this.f24694m;
    }

    private static class j {
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public String f24696j;
        public String xt;

        public j(String str, String str2, String str3) {
            this.f24696j = str;
            this.xt = str2;
            this.cw = str3;
        }
    }

    public String g() {
        try {
            JSONArray jSONArray = new JSONArray(this.ae);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", m.j(jSONObject.getLong(this.oq.xt)));
            }
            this.ae = jSONArray.toString();
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return this.ae;
    }

    public String oq() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (up upVar : qv()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.oq.f24696j, upVar.j());
                jSONObject.put(this.oq.xt, upVar.xt());
                jSONObject.put(this.oq.cw, upVar.cw());
                jSONObject.put("count", upVar.up());
                jSONObject.put("effective_time", upVar.r());
                jSONArray.put(jSONObject);
            }
            this.ae = jSONArray.toString();
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return this.ae;
    }

    @Override // com.bytedance.msdk.core.tl.r
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f24711j + "', showRulesVersion='" + this.cw + "', timingMode=" + this.up + "}IntervalFreqctlBean{freqctlRules=" + this.f24694m + ", freqctlRulesJson='" + this.ae + "'}";
    }

    public ae(String str, String str2, String str3, String str4, int i6, String str5) {
        super(str, str2, str3, str4, i6);
        this.tl = "count";
        this.f24693g = "effective_time";
        this.ae = str5;
        if (!TextUtils.isEmpty(str2)) {
            this.oq = new j("freq", "span", "rule_id");
        } else {
            this.oq = new j("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        }
    }

    public void j(String str, long j6) {
        for (up upVar : qv()) {
            if (TextUtils.equals(upVar.cw(), str)) {
                upVar.xt(j6);
                return;
            }
        }
    }
}
