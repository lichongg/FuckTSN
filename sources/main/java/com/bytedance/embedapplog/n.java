package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class n extends l {
    private final Context up;

    n(Context context) {
        super(true, true);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    @SuppressLint({"MissingPermission"})
    protected boolean j(JSONObject jSONObject) {
        wq.j(jSONObject, bi.Q, ln.j(this.up));
        return true;
    }
}
