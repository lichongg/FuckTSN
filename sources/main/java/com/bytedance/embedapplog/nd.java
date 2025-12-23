package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
final class nd extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f24017m;
    private final Context up;

    nd(Context context, rn rnVar) {
        super(true, false);
        this.up = context;
        this.f24017m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        Map<String, String> j6 = wo.j(this.up, this.f24017m.r());
        if (j6 == null) {
            return !j.xt;
        }
        jSONObject.put("oaid", new JSONObject(j6));
        return true;
    }
}
