package com.bytedance.sdk.component.g.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.component.xt.j.up;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends r {

    /* renamed from: j, reason: collision with root package name */
    az f26460j;

    public up(vl vlVar) {
        super(vlVar);
        this.f26460j = null;
    }

    public void cw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f26460j = az.j(oq.j("application/json; charset=utf-8"), str);
    }

    public void j(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = "{}";
        }
        this.f26460j = az.j(oq.j("application/json; charset=utf-8"), str);
    }

    public void j(Map<String, String> map) {
        up.j jVar = new up.j();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                jVar.j(str, map.get(str));
            }
        }
        this.f26460j = jVar.j();
    }

    public void j(String str, byte[] bArr) {
        this.f26460j = az.j(oq.j(str), bArr);
    }

    public void j(final com.bytedance.sdk.component.g.j.j jVar) {
        try {
            ws.j jVar2 = new ws.j();
            if (TextUtils.isEmpty(this.f26458m)) {
                jVar.j(this, new IOException("Url is Empty"));
                return;
            }
            jVar2.j(this.f26458m);
            if (this.f26460j == null) {
                if (jVar != null) {
                    jVar.j(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                j(jVar2);
                jVar2.j((Object) xt());
                this.cw.j(jVar2.j(this.f26460j).xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bytedance.sdk.component.g.xt.up.1
                    @Override // com.bytedance.sdk.component.xt.j.cw
                    public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar, IOException iOException) {
                        com.bytedance.sdk.component.g.j.j jVar3 = jVar;
                        if (jVar3 != null) {
                            jVar3.j(up.this, iOException);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.sdk.component.xt.j.m] */
                    /* JADX WARN: Type inference failed for: r13v5, types: [com.bytedance.sdk.component.g.j.j] */
                    /* JADX WARN: Type inference failed for: r2v0 */
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.sdk.component.g.xt] */
                    /* JADX WARN: Type inference failed for: r2v10 */
                    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v13 */
                    /* JADX WARN: Type inference failed for: r2v14 */
                    /* JADX WARN: Type inference failed for: r2v15 */
                    /* JADX WARN: Type inference failed for: r2v16 */
                    /* JADX WARN: Type inference failed for: r2v17 */
                    /* JADX WARN: Type inference failed for: r2v3 */
                    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.sdk.component.g.xt] */
                    @Override // com.bytedance.sdk.component.xt.j.cw
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onResponse(com.bytedance.sdk.component.xt.j.xt r13, com.bytedance.sdk.component.xt.j.av r14) throws java.io.IOException {
                        /*
                            Method dump skipped, instructions count: 261
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.xt.up.AnonymousClass1.onResponse(com.bytedance.sdk.component.xt.j.xt, com.bytedance.sdk.component.xt.j.av):void");
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            jVar.j(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.g.xt.r
    public com.bytedance.sdk.component.g.xt j() {
        com.bytedance.sdk.component.g.xt xtVar;
        try {
            ws.j jVar = new ws.j();
            if (TextUtils.isEmpty(this.f26458m)) {
                com.bytedance.sdk.component.g.r.up.j("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.g.xt(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            jVar.j(this.f26458m);
            if (this.f26460j == null) {
                com.bytedance.sdk.component.g.r.up.j("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.g.xt(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            j(jVar);
            jVar.j((Object) xt());
            av j6 = this.cw.j(jVar.j(this.f26460j).xt()).j();
            if (j6 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            m ae = j6.ae();
            if (ae != null) {
                for (int i6 = 0; i6 < ae.j(); i6++) {
                    String j7 = ae.j(i6);
                    String xt = ae.xt(i6);
                    hashMap.put(j7, xt);
                    if (j7 != null && j7.equalsIgnoreCase("content-type")) {
                        hashMap.put("content-type", xt == null ? "" : xt.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.g.r.j.j(hashMap)) {
                byte[] r5 = j6.m().r();
                xtVar = new com.bytedance.sdk.component.g.xt(j6.r(), j6.cw(), j6.up(), hashMap, null, j6.xt(), j6.j());
                xtVar.j(r5);
            } else if (this.ae) {
                byte[] r6 = j6.m().r();
                xtVar = new com.bytedance.sdk.component.g.xt(j6.r(), j6.cw(), j6.up(), hashMap, new String(r6, j(j(j6.m()))), j6.xt(), j6.j());
                xtVar.j(r6);
            } else {
                xtVar = new com.bytedance.sdk.component.g.xt(j6.r(), j6.cw(), j6.up(), hashMap, j6.m().xt(), j6.xt(), j6.j());
            }
            j(xtVar, j6);
            return xtVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.g.xt(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset j(oq oqVar) {
        try {
            return oqVar != null ? oqVar.j(com.bytedance.sdk.component.xt.j.xt.oq.f27325j) : com.bytedance.sdk.component.xt.j.xt.oq.f27325j;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.xt.j.xt.oq.f27325j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public oq j(i iVar) {
        try {
            return iVar.up();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.g.xt xtVar, av avVar) {
        if (xtVar == null || avVar == null) {
            return;
        }
        xtVar.j(avVar.g());
    }
}
