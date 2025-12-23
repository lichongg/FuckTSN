package com.bytedance.sdk.openadsdk.core.i.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private Context f29156j;
    private n xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, Context context, n nVar) {
        iVar.j("openNewCommonWebPage", (com.bytedance.sdk.component.j.up<?, ?>) new tj(context, nVar));
    }

    public tj(Context context, n nVar) {
        this.f29156j = context;
        this.xt = nVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        try {
            String optString = jSONObject.optString("web_url");
            String optString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "";
            }
            TTDelegateActivity.r(this.f29156j, optString, optString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.r("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
