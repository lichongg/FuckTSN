package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.j.r;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29146j;

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
        this.f29146j = null;
    }

    public mi(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29146j = new WeakReference<>(rnVar);
    }

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("mallTopbarClick", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.mi.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new mi(com.bytedance.sdk.openadsdk.core.rn.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.oq.i().z();
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29146j;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() != null && jSONObject != null) {
            String optString = jSONObject.optString("schema");
            if (optString.isEmpty()) {
                cw();
                return;
            } else {
                j(optString, jSONObject.optBoolean("sync_auth", false));
                return;
            }
        }
        cw();
    }

    private void j(final String str, boolean z5) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.bytedance.sdk.openadsdk.core.live.xt.j().up()) {
            j(str, jSONObject);
            return;
        }
        int j6 = com.bytedance.sdk.openadsdk.core.live.xt.j().j(new com.bytedance.sdk.openadsdk.core.live.xt.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.mi.2
            @Override // com.bytedance.sdk.openadsdk.core.live.xt.xt
            protected void j(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("code")) {
                        Object obj2 = map.get("code");
                        if (obj2 instanceof String) {
                            try {
                                int parseInt = Integer.parseInt((String) obj2);
                                if (parseInt == 1) {
                                    mi.this.j(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt("code", Integer.valueOf(parseInt));
                                } catch (JSONException unused) {
                                }
                                mi.this.j(parseInt, "授权失败");
                                mi.this.j((mi) jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt("code", -1);
                } catch (JSONException unused3) {
                }
                mi.this.j(-1, "授权失败");
                mi.this.j((mi) jSONObject);
            }
        }, z5);
        jSONObject.putOpt("code", Integer.valueOf(j6));
        if (j6 != 1) {
            j(j6, "执行授权失败");
            j((mi) jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, JSONObject jSONObject) {
        int j6 = com.bytedance.sdk.openadsdk.core.live.xt.j().j(str);
        try {
            jSONObject.putOpt("code", Integer.valueOf(j6));
        } catch (JSONException unused) {
        }
        if (j6 != 1) {
            j(j6, "schema 解析失败");
        }
        j((mi) jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        com.bytedance.sdk.component.utils.vl.xt("MallTopBarClickMethod", "code = " + i6 + ", msg = " + str);
        com.bytedance.sdk.component.utils.a.j(com.bytedance.sdk.openadsdk.core.v.getContext(), "努力加载中，请稍后再试", 1);
    }
}
