package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class s extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f24048m;
    private final Context up;

    s(Context context, rn rnVar) {
        super(true, false);
        this.up = context;
        this.f24048m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f24048m.wq())) {
            jSONObject.put("ab_client", this.f24048m.wq());
        }
        if (!TextUtils.isEmpty(this.f24048m.mi())) {
            if (uc.xt) {
                uc.j("init config has abversion:" + this.f24048m.mi(), null);
            }
            jSONObject.put("ab_version", this.f24048m.mi());
        }
        if (!TextUtils.isEmpty(this.f24048m.uf())) {
            jSONObject.put("ab_group", this.f24048m.uf());
        }
        if (TextUtils.isEmpty(this.f24048m.ed())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f24048m.ed());
        return true;
    }
}
