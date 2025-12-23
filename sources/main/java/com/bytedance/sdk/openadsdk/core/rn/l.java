package com.bytedance.sdk.openadsdk.core.rn;

import android.os.Looper;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(com.bytedance.sdk.openadsdk.core.tj.n nVar, Double d6) {
        if (nVar == null || nVar.lg() == null) {
            return;
        }
        try {
            Object obj = nVar.lg().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str = (String) nVar.lg().get("nurl");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (d6 != null) {
                    str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d6));
                }
                com.bytedance.sdk.openadsdk.core.v.j().j(j(nVar, str, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(final com.bytedance.sdk.openadsdk.core.tj.n nVar, final Double d6) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("win") { // from class: com.bytedance.sdk.openadsdk.core.rn.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.cw(nVar, d6);
                }
            });
        } else {
            cw(nVar, d6);
        }
    }

    public static void j(final com.bytedance.sdk.openadsdk.core.tj.n nVar, final Double d6, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("loss") { // from class: com.bytedance.sdk.openadsdk.core.rn.l.2
                @Override // java.lang.Runnable
                public void run() {
                    l.cw(nVar, d6, str, str2);
                }
            });
        } else {
            cw(nVar, d6, str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(com.bytedance.sdk.openadsdk.core.tj.n r3, java.lang.String r4, java.lang.String r5) throws java.lang.Exception {
        /*
            if (r3 == 0) goto L7a
            if (r4 == 0) goto L7a
            boolean r0 = r4.contains(r5)
            if (r0 != 0) goto Lb
            goto L7a
        Lb:
            java.lang.String r3 = r3.os()
            com.bytedance.sdk.openadsdk.core.cw.m r0 = com.bytedance.sdk.openadsdk.core.cw.m.j()
            r1 = 0
            android.util.Pair r3 = r0.j(r3, r1)
            java.lang.String r0 = ""
            r1 = 3
            if (r3 == 0) goto L34
            java.lang.Object r2 = r3.second
            if (r2 == 0) goto L29
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            java.lang.String r0 = "message"
            java.lang.String r0 = r2.optString(r0)
        L29:
            java.lang.Object r3 = r3.first
            if (r3 == 0) goto L34
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L35
        L34:
            r3 = 3
        L35:
            if (r3 == r1) goto L6f
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Exception -> L58
            r3.<init>(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = r3.getQuery()     // Catch: java.lang.Exception -> L58
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L58
            if (r3 == 0) goto L5a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
            r3.<init>()     // Catch: java.lang.Exception -> L58
            r3.append(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r1 = "?abort_aes=1"
            r3.append(r1)     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Exception -> L58
            goto L6f
        L58:
            r3 = move-exception
            goto L6c
        L5a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
            r3.<init>()     // Catch: java.lang.Exception -> L58
            r3.append(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r1 = "&abort_aes=1"
            r3.append(r1)     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Exception -> L58
            goto L6f
        L6c:
            com.bytedance.sdk.component.utils.vl.j(r3)
        L6f:
            java.lang.String r3 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r0, r3)
            java.lang.String r3 = r4.replace(r5, r3)
            return r3
        L7a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.l.j(com.bytedance.sdk.openadsdk.core.tj.n, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(com.bytedance.sdk.openadsdk.core.tj.n nVar, Double d6, String str, String str2) {
        if (nVar == null || nVar.lg() == null) {
            return;
        }
        try {
            Object obj = nVar.lg().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str3 = (String) nVar.lg().get("lurl");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                if (d6 != null) {
                    str3 = str3.replace("${AUCTION_PRICE}", String.valueOf(d6));
                }
                if (str != null) {
                    str3 = str3.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    str3 = str3.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.v.j().j(j(nVar, str3, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }
}
