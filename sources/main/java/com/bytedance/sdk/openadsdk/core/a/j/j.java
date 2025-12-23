package com.bytedance.sdk.openadsdk.core.a.j;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    protected boolean cw(int i6) {
        return i6 == 2 || i6 == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int j(int r4) {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.p.oq r0 = com.bytedance.sdk.openadsdk.core.v.xt()
            org.json.JSONObject r0 = r0.wf()
            if (r0 == 0) goto L25
            boolean r1 = r3.xt(r4)
            r2 = 0
            if (r1 == 0) goto L18
            java.lang.String r4 = "explicit_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L18:
            boolean r4 = r3.cw(r4)
            if (r4 == 0) goto L25
            java.lang.String r4 = "ambiguous_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L25:
            r4 = -1
        L26:
            r0 = 86400000(0x5265c00, float:7.82218E-36)
            if (r4 <= r0) goto L2c
            return r0
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.j.j.j(int):int");
    }

    protected boolean xt(int i6) {
        return i6 == 0 || i6 == 1;
    }

    protected void j(int i6, long j6, long j7) {
        com.bytedance.sdk.openadsdk.core.a.j j8 = com.bytedance.sdk.openadsdk.core.a.j.j();
        j8.j(i6);
        j8.j(j6, j7);
    }

    protected int j(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
