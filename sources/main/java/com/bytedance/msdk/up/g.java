package com.bytedance.msdk.up;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.tl.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements com.bytedance.sdk.component.tl.j.qv {

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.msdk.up.xt.j<j> f25245j;
    private static final Handler xt = new Handler(com.bytedance.msdk.j.up.m.xt());
    private static final Runnable cw = new Runnable() { // from class: com.bytedance.msdk.up.g.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.j.up.cw.j("TMe", "--==--- upload event routine");
            com.bytedance.sdk.component.tl.xt.j.r("csj_mediation");
            g.xt();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt() {
        Handler handler = xt;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(cw, com.bytedance.msdk.core.xt.xt().a());
    }

    private void xt(JSONObject jSONObject, int i6, long j6, int i7, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject != null) {
                    j(optJSONObject, i6, j6, i7, jSONObject2 != null ? jSONObject2.optJSONObject("params") : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.qv
    public void j(final List<com.bytedance.sdk.component.tl.j.xt> list, @Nullable final com.bytedance.sdk.component.tl.j.oq oqVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
        JSONObject jSONObject = null;
        int i6 = 0;
        while (true) {
            JSONObject jSONObject2 = jSONObject;
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.tl.j.xt next = it.next();
            jSONObject = next.ae();
            byte up = next.up();
            byte r5 = next.r();
            if (up == 2 && r5 == 3) {
                xt(jSONObject, list.size(), currentTimeMillis, i6, jSONObject2);
                arrayList.add(new ae(next.cw(), jSONObject));
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("not_v3", jSONObject);
                    jSONObject3.putOpt("batchId", Long.valueOf(currentTimeMillis));
                    jSONObject3.putOpt("batchIndex", Integer.valueOf(i6));
                    l.j(jSONObject3);
                } catch (Throwable unused) {
                }
            }
            i6++;
        }
        if (arrayList.size() > 0) {
            com.bytedance.msdk.j.up.m.ae().execute(new Runnable() { // from class: com.bytedance.msdk.up.g.1
                @Override // java.lang.Runnable
                public void run() {
                    up j6 = g.this.j(arrayList);
                    if (oqVar == null || j6 == null) {
                        return;
                    }
                    com.bytedance.sdk.component.tl.xt.xt.cw.xt xtVar = new com.bytedance.sdk.component.tl.xt.xt.cw.xt(j6.f25319j, j6.xt, j6.cw, j6.f25320r, "");
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new com.bytedance.sdk.component.tl.xt.xt.cw.j(xtVar, list));
                    oqVar.j(arrayList2);
                    if (j6.f25319j) {
                        g.xt();
                    }
                }
            });
        }
    }

    private void j(JSONObject jSONObject, int i6, long j6, int i7, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(optString);
                jSONObject3.putOpt("size", Integer.valueOf(i6));
                jSONObject3.putOpt("batchId", Long.valueOf(j6));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i7));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : "-1");
                jSONObject.put("event_extra", jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public up j(List<j> list) {
        try {
            if (this.f25245j == null) {
                this.f25245j = com.bytedance.msdk.core.xt.j();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.up.xt.j<j> jVar = this.f25245j;
        if (jVar == null) {
            return null;
        }
        return jVar.j(list);
    }
}
