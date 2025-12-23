package com.bytedance.sdk.component.tl.xt.up;

import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.tl.j.j.m;
import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.tl;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.tl.xt.cw.cw;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.tl.j.j.j<com.bytedance.sdk.component.tl.j.xt> {
    private static final SimpleDateFormat xt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private final String cw = "x-pglcypher";

    /* renamed from: j, reason: collision with root package name */
    private final boolean f26799j = xt();

    /* renamed from: r, reason: collision with root package name */
    private up f26800r;

    public static byte[] xt(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    public boolean cw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString(CrashHianalyticsData.MESSAGE).equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PublicKey cw() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public up j() {
        if (this.f26800r == null) {
            this.f26800r = com.bytedance.sdk.component.tl.xt.j.cw("csj").cw();
        }
        return this.f26800r;
    }

    private boolean m(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private Map<String, String> r(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (m(jSONObject)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    private int up(JSONObject jSONObject) {
        String optString;
        int indexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            optString = jSONObject.optString("s_sig_ts");
        } catch (Throwable unused) {
        }
        if (optString == null || (indexOf = optString.indexOf("_")) < 5) {
            return 512;
        }
        String substring = optString.substring(0, indexOf);
        String substring2 = optString.substring(indexOf + 1);
        JSONObject g6 = j().r().vl().g();
        if (j((g6 != null ? g6.optString("device_id") : "") + "_" + substring, substring2)) {
            return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(substring).longValue()) > 300 ? 513 : 0;
        }
        return 512;
    }

    private static boolean xt() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public List<com.bytedance.sdk.component.tl.j.xt> xt(List<com.bytedance.sdk.component.tl.j.xt> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject ae = xtVar.ae();
                String optString = ae.optString("label");
                if (TextUtils.isEmpty(optString)) {
                    optString = ae.optString("event");
                }
                jSONObject.putOpt("event", optString);
                long optLong = ae.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", xt.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (ae.has("params") && ae.has("event")) {
                    jSONObject2 = ae.optJSONObject("params");
                } else {
                    Iterator<String> keys = ae.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, ae.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.tl.xt.r.j.j jVar = new com.bytedance.sdk.component.tl.xt.r.j.j(xtVar.cw(), jSONObject);
                jVar.j(xtVar.r());
                jVar.xt(xtVar.up());
                arrayList.add(jVar);
            } catch (Exception e6) {
                cw.cw(e6.getMessage(), j());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.tl.j.j.j
    public com.bytedance.sdk.component.tl.xt.xt.cw.xt j(List<com.bytedance.sdk.component.tl.j.xt> list) {
        tl vl;
        com.bytedance.sdk.component.tl.xt.xt.cw.xt j6;
        String str;
        r r5 = j().r();
        if (r5 != null) {
            try {
                if (r5.r() && (vl = r5.vl()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str2 = "1streqid";
                    String str3 = "2ndreqid";
                    String str4 = "";
                    boolean z5 = false;
                    for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
                        if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW, com.bytedance.sdk.component.tl.xt.cw.j.j(xtVar, j()))) {
                            String j7 = com.bytedance.sdk.component.tl.xt.cw.j.j(xtVar.ae(), this.f26800r);
                            if (!z5) {
                                str = com.bytedance.sdk.component.tl.xt.cw.j.m(xtVar, this.f26800r);
                            } else {
                                str3 = com.bytedance.sdk.component.tl.xt.cw.j.m(xtVar, this.f26800r);
                                str = str3;
                            }
                            str4 = j7;
                            str2 = str;
                            z5 = true;
                        }
                        arrayList.add(xtVar);
                    }
                    int oq = vl.oq();
                    if (!arrayList.isEmpty()) {
                        JSONObject j8 = vl.j(xt(arrayList), this.f26799j);
                        byte[] j9 = vl.j(j8, oq);
                        if (j9 == null) {
                            JSONObject j10 = vl.j(j8);
                            j9 = xt(j10);
                            j6 = j(j9, r(j10), "application/json; charset=utf-8");
                        } else {
                            j6 = j(j9, j(oq), xt(oq));
                        }
                        if (z5) {
                            int length = j9 != null ? j9.length : 0;
                            if (j6 != null) {
                                com.bytedance.sdk.component.tl.xt.cw.j.j(j6.f26829j, j6.xt, j6.cw, str2 + Logger.f33116c + str3, length, str4);
                            }
                        }
                        return j6;
                    }
                }
                return null;
            } catch (Throwable th) {
                cw.cw("NetApiImpl", "uploadEvent error" + th.getMessage(), j());
                return new com.bytedance.sdk.component.tl.xt.xt.cw.xt(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, th.getMessage(), false, "error");
            }
        }
        return null;
    }

    private void xt(byte[] bArr, Map<String, String> map, String str) {
        up j6;
        r r5;
        tl vl;
        if (bArr == null || bArr.length == 0 || (j6 = j()) == null || (r5 = j6.r()) == null || (vl = r5.vl()) == null || !vl.j()) {
            return;
        }
        m up = vl.up();
        up.j(vl.xt());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                up.j(entry.getKey(), entry.getValue());
            }
        }
        up.j(str, bArr);
        up.j("User-Agent", r5.up());
        up.j(new com.bytedance.sdk.component.tl.j.j.cw() { // from class: com.bytedance.sdk.component.tl.xt.up.j.1
            @Override // com.bytedance.sdk.component.tl.j.j.cw
            public void j(com.bytedance.sdk.component.tl.j.j.r rVar, com.bytedance.sdk.component.tl.j.j.up upVar) {
                if (upVar == null || !upVar.j()) {
                    j.this.j();
                } else {
                    upVar.xt();
                    j.this.j();
                }
            }

            @Override // com.bytedance.sdk.component.tl.j.j.cw
            public void j(com.bytedance.sdk.component.tl.j.j.r rVar, IOException iOException) {
                iOException.getMessage();
                j.this.j();
            }
        });
    }

    private Map<String, String> j(int i6) {
        HashMap hashMap = new HashMap();
        if (i6 >= 4) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
            hashMap.put("x-pglcypher", String.valueOf(i6));
        }
        hashMap.put("Content-Type", xt(i6));
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.tl.xt.xt.cw.xt j(byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.up.j.j(byte[], java.util.Map, java.lang.String):com.bytedance.sdk.component.tl.xt.xt.cw.xt");
    }

    private String xt(int i6) {
        if (i6 >= 4) {
            return "application/octet-stream";
        }
        return "application/octet-stream;tt-data=a";
    }

    private boolean j(String str, String str2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(cw().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(generatePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        if (r2 == 60005) goto L50;
     */
    @Override // com.bytedance.sdk.component.tl.j.j.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.tl.xt.xt.cw.xt j(org.json.JSONObject r13) {
        /*
            r12 = this;
            com.bytedance.sdk.component.tl.j.up r0 = r12.j()
            com.bytedance.sdk.component.tl.j.r r0 = r0.r()
            r1 = 0
            if (r0 == 0) goto Ld2
            boolean r2 = r0.r()
            if (r2 != 0) goto L13
            goto Ld2
        L13:
            if (r13 == 0) goto Ld2
            int r2 = r13.length()
            if (r2 > 0) goto L1d
            goto Ld2
        L1d:
            com.bytedance.sdk.component.tl.j.tl r2 = r0.vl()
            if (r2 != 0) goto L24
            return r1
        L24:
            com.bytedance.sdk.component.tl.j.j.m r1 = r2.up()
            java.lang.String r3 = r2.ae()
            r1.j(r3)
            int r3 = r2.oq()
            byte[] r4 = r2.xt(r13, r3)
            if (r4 != 0) goto L45
            org.json.JSONObject r13 = r2.j(r13)
            java.lang.String r13 = r13.toString()
            r1.xt(r13)
            goto L55
        L45:
            java.lang.String r13 = r12.xt(r3)
            r1.j(r13, r4)
            java.lang.String r13 = "x-pglcypher"
            java.lang.String r2 = java.lang.String.valueOf(r3)
            r1.j(r13, r2)
        L55:
            java.lang.String r13 = "User-Agent"
            java.lang.String r0 = r0.up()
            r1.j(r13, r0)
            java.lang.String r5 = "error unknown"
            r13 = 0
            com.bytedance.sdk.component.tl.j.j.up r0 = r1.j()     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L72
            com.bytedance.sdk.component.tl.xt.xt.cw.xt r2 = new com.bytedance.sdk.component.tl.xt.xt.cw.xt     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r7 = "ignore"
            r3 = 0
            r4 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lc5
            return r2
        L72:
            boolean r1 = r0.j()     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto Laa
            java.lang.String r1 = r0.xt()     // Catch: java.lang.Throwable -> Lc5
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r1 != 0) goto Laa
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = r0.xt()     // Catch: java.lang.Throwable -> Lc5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "code"
            r3 = -1
            int r2 = r1.optInt(r2, r3)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r3 = "data"
            java.lang.String r4 = ""
            java.lang.String r5 = r1.optString(r3, r4)     // Catch: java.lang.Throwable -> Lc5
            r1 = 20000(0x4e20, float:2.8026E-41)
            r3 = 1
            if (r2 != r1) goto La1
            r1 = 1
            goto La2
        La1:
            r1 = 0
        La2:
            r4 = 60005(0xea65, float:8.4085E-41)
            if (r2 != r4) goto La8
            goto Lac
        La8:
            r3 = 0
            goto Lac
        Laa:
            r1 = 0
            goto La8
        Lac:
            int r13 = r0.cw()     // Catch: java.lang.Throwable -> Lc2
            boolean r2 = r0.j()     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto Lba
            java.lang.String r5 = r0.r()     // Catch: java.lang.Throwable -> Lbf
        Lba:
            r8 = r13
            r7 = r1
        Lbc:
            r10 = r3
            r9 = r5
            goto Lca
        Lbf:
            r0 = r13
            r13 = r1
            goto Lc7
        Lc2:
            r13 = r1
            r0 = 0
            goto Lc7
        Lc5:
            r0 = 0
            r3 = 0
        Lc7:
            r7 = r13
            r8 = r0
            goto Lbc
        Lca:
            com.bytedance.sdk.component.tl.xt.xt.cw.xt r6 = new com.bytedance.sdk.component.tl.xt.xt.cw.xt
            java.lang.String r11 = "ignore"
            r6.<init>(r7, r8, r9, r10, r11)
            return r6
        Ld2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.up.j.j(org.json.JSONObject):com.bytedance.sdk.component.tl.xt.xt.cw.xt");
    }
}
