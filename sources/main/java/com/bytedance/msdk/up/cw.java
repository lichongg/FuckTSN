package com.bytedance.msdk.up;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.msdk.tl.s;
import com.bytedance.msdk.up.xt;
import com.bytedance.sdk.component.tl.j.j;
import com.bytedance.sdk.component.utils.vl;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f25243j;
    private static final AtomicLong xt = new AtomicLong(0);

    public static void j() {
        f25243j = true;
    }

    public static boolean xt() {
        return f25243j;
    }

    public static void cw() {
        com.bytedance.sdk.component.tl.xt.j.r("csj_mediation");
    }

    public static void j(Context context) {
        int s5 = com.bytedance.msdk.core.xt.xt().s();
        com.bytedance.sdk.component.tl.xt.j.j(new j.C0417j().j(new g()).xt(com.bytedance.sdk.component.tl.xt.r.xt.j.j(s5, s5, bn.f10749e)).xt(com.bytedance.msdk.core.j.qv().jy()).j(new oq()).j(qv.f25309j).j("csj_mediation").j(context).j());
        com.bytedance.sdk.component.tl.xt.j.xt("csj_mediation");
    }

    public static void xt(Context context) {
        try {
            List<xt.j> xt2 = xt.j().xt();
            if (xt2 != null) {
                for (xt.j jVar : xt2) {
                    if (jVar != null) {
                        j(context, jVar.j(), jVar.xt());
                    }
                }
            }
            xt.j().cw();
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static void j(Context context, r rVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.xt.xt().ws()) {
            Context context2 = context == null ? com.bytedance.msdk.core.xt.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", xt.getAndIncrement());
            jSONObject.put("is_main_process", s.j(context));
            jSONObject.put("is_cypher_v4", com.bytedance.msdk.core.xt.j().j());
            if (com.bytedance.msdk.core.j.qv().g()) {
                jSONObject.put("e2e_test_flag", "1");
            }
            if (rVar != null) {
                rVar.j("event_id", UUID.randomUUID().toString());
            }
            JSONObject j6 = j.j(rVar, jSONObject);
            if (!f25243j) {
                xt.j().j(rVar, j6);
            } else {
                j(context2, rVar, j6);
            }
        }
    }

    private static void j(Context context, r rVar, JSONObject jSONObject) {
        if (com.bytedance.sdk.component.tl.xt.j.j("csj_mediation")) {
            j(context);
        }
        ae j6 = ae.j(context, rVar, jSONObject);
        com.bytedance.msdk.tl.r.xt.j(j6, true);
        com.bytedance.sdk.component.tl.xt.r.j.j jVar = new com.bytedance.sdk.component.tl.xt.r.j.j(j6.f25248j, j6);
        jVar.j((byte) 3);
        jVar.xt((byte) 2);
        com.bytedance.sdk.component.tl.xt.j.j(jVar, "csj_mediation");
    }
}
