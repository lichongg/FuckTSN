package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
final class h extends l {
    private final rn up;

    h(Context context, rn rnVar) {
        super(true, false);
        this.up = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        String j6 = wo.j(this.up.r());
        if (TextUtils.isEmpty(j6)) {
            return false;
        }
        jSONObject.put("cdid", j6);
        return true;
    }
}
