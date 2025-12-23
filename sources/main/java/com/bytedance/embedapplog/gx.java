package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class gx extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f23995m;
    private final Context up;

    gx(Context context, rn rnVar) {
        super(true, false);
        this.up = context;
        this.f23995m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        String str;
        if (j.vl() != null) {
            str = j.vl().h().j();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put(bi.A, str);
            return true;
        }
        return true;
    }
}
