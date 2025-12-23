package com.bytedance.sdk.openadsdk.core.dislike.cw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends m {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private String f28866j;

    /* renamed from: r, reason: collision with root package name */
    private List<m> f28867r;
    private String xt;

    public cw(String str, String str2) {
        super(null);
        this.f28866j = str;
        this.xt = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public String j() {
        return this.f28866j;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public String xt() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public boolean cw() {
        return this.cw;
    }

    public void j(String str) {
        this.f28866j = str;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public boolean m() {
        List<m> list = this.f28867r;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public List<m> r() {
        return this.f28867r;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public boolean up() {
        return (TextUtils.isEmpty(this.f28866j) || TextUtils.isEmpty(this.xt)) ? false : true;
    }

    public void xt(String str) {
        this.xt = str;
    }

    public JSONObject ae() {
        try {
            if (up()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", j());
                jSONObject.put(CommonNetImpl.NAME, xt());
                jSONObject.put("is_selected", cw());
                if (m()) {
                    JSONArray jSONArray = new JSONArray();
                    for (m mVar : r()) {
                        if (mVar instanceof cw) {
                            jSONArray.put(((cw) mVar).ae());
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public void j(boolean z5) {
        this.cw = z5;
    }

    public cw() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.m
    public void j(m mVar) {
        if (mVar == null) {
            return;
        }
        if (this.f28867r == null) {
            this.f28867r = new ArrayList();
        }
        this.f28867r.add(mVar);
    }

    public static cw j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            cw cwVar = new cw();
            cwVar.j(jSONObject.optString("id"));
            cwVar.xt(jSONObject.optString(CommonNetImpl.NAME));
            cwVar.j(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    cw j6 = j(optJSONArray.optJSONObject(i6));
                    if (j6 != null && j6.up()) {
                        cwVar.j(j6);
                    }
                }
            }
            return cwVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
