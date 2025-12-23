package com.bytedance.msdk.up.xt;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.tl.az;
import com.bytedance.msdk.tl.cw;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.v;
import com.bytedance.msdk.tl.x;
import com.bytedance.msdk.up.up;
import com.bytedance.sdk.component.panglearmor.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j<com.bytedance.msdk.up.j> {

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f25323j = false;
    private static volatile boolean xt = true;
    private int cw = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f25324r = 0;

    private byte[] xt(List<com.bytedance.msdk.up.j> list) {
        GZIPOutputStream gZIPOutputStream = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject cw = cw(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(cw.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        gZIPOutputStream = gZIPOutputStream2;
                        j("buildAdEventV3BodyRaw", "exception: " + e.toString());
                        vl.j(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e7) {
                                vl.j(e7);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                vl.j(e9);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.msdk.up.xt.j
    public boolean j() {
        return !com.bytedance.msdk.core.xt.xt().xt() && g.xt();
    }

    private JSONObject cw(List<com.bytedance.msdk.up.j> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", x.h());
            jSONObject.put("client_ip", x.f());
            jSONObject.put("header", v.xt());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.msdk.up.j> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().xt);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
            return jSONObject;
        } catch (JSONException e6) {
            j("getAdEventV3Json", "exception: " + e6.toString());
            vl.j(e6);
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.up.up j(java.lang.String r4, byte[] r5, boolean r6) {
        /*
            r3 = this;
            com.bytedance.msdk.r.xt r0 = com.bytedance.msdk.r.xt.j()
            com.bytedance.sdk.component.g.j r0 = r0.xt()
            com.bytedance.sdk.component.g.xt.up r0 = r0.xt()
            r0.j(r4)
            com.bytedance.msdk.core.j r4 = com.bytedance.msdk.core.j.qv()
            java.lang.String r4 = r4.tl()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.xt(r1, r4)
            java.lang.String r4 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.xt(r4, r1)
        L29:
            if (r6 == 0) goto L3c
            java.lang.String r4 = "x-pglcypher"
            java.lang.String r6 = "4"
            r0.xt(r4, r6)
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "union_sdk_encode"
            r0.xt(r4, r6)
            java.lang.String r4 = "application/octet-stream"
            goto L3e
        L3c:
            java.lang.String r4 = "application/octet-stream;tt-data=a"
        L3e:
            java.lang.String r6 = "User-Agent"
            java.lang.String r1 = com.bytedance.msdk.xt.xt.f25363j
            r0.xt(r6, r1)
            r0.j(r4, r5)
            com.bytedance.sdk.component.g.xt r4 = r0.j()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L99
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L61
            java.lang.String r1 = r4.r()     // Catch: org.json.JSONException -> L61
            r0.<init>(r1)     // Catch: org.json.JSONException -> L61
            boolean r0 = r3.j(r0)     // Catch: org.json.JSONException -> L61
            if (r0 == 0) goto L99
            r0 = 1
            goto L9a
        L61:
            r0 = move-exception
            int r1 = r3.f25324r
            int r2 = r1 + 1
            r3.f25324r = r2
            r2 = 20
            if (r1 >= r2) goto L7f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "exception: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "doUploadApplogAdEvent"
            j(r2, r1)
        L7f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ignore:"
            r1.<init>(r2)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "uploadEvent"
            com.bytedance.msdk.j.up.cw.r(r2, r1)
            com.bytedance.sdk.component.utils.vl.j(r0)
        L99:
            r0 = 0
        L9a:
            if (r4 == 0) goto La1
            int r1 = r4.j()
            goto La2
        La1:
            r1 = 0
        La2:
            if (r0 != 0) goto Lab
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto Lab
            java.lang.String r4 = "server say not success"
            goto Ld2
        Lab:
            if (r4 == 0) goto Lcf
            java.lang.String r5 = r4.xt()
            if (r0 != 0) goto Lcd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r5 = "::"
            r2.append(r5)
            java.lang.String r4 = r4.r()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        Lcb:
            r5 = 0
            goto Ld2
        Lcd:
            r4 = r5
            goto Lcb
        Lcf:
            java.lang.String r4 = "error unknown"
            goto Lcb
        Ld2:
            com.bytedance.msdk.up.up r6 = new com.bytedance.msdk.up.up
            r6.<init>(r0, r1, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.up.xt.xt.j(java.lang.String, byte[], boolean):com.bytedance.msdk.up.up");
    }

    private byte[] r(List<com.bytedance.msdk.up.j> list) {
        try {
            return j(cw.j(cw(list)).toString());
        } catch (Throwable th) {
            j("buildAdEventV3Body2", "exception: " + th.toString());
            vl.j(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.up.up j(java.lang.String r5, byte[] r6) {
        /*
            r4 = this;
            com.bytedance.msdk.r.xt r0 = com.bytedance.msdk.r.xt.j()
            com.bytedance.sdk.component.g.j r0 = r0.xt()
            com.bytedance.sdk.component.g.xt.up r0 = r0.xt()
            r0.j(r5)
            com.bytedance.msdk.core.j r5 = com.bytedance.msdk.core.j.qv()
            java.lang.String r5 = r5.tl()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.xt(r1, r5)
            java.lang.String r5 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.xt(r5, r1)
        L29:
            java.lang.String r5 = "User-Agent"
            java.lang.String r1 = com.bytedance.msdk.xt.xt.f25363j
            r0.xt(r5, r1)
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r1 = "union_sdk_encode"
            r0.xt(r5, r1)
            java.lang.String r5 = "application/json; charset=utf-8"
            r0.j(r5, r6)
            com.bytedance.sdk.component.g.xt r5 = r0.j()
            r6 = 1
            r0 = 0
            if (r5 == 0) goto L8d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            java.lang.String r2 = r5.r()     // Catch: org.json.JSONException -> L55
            r1.<init>(r2)     // Catch: org.json.JSONException -> L55
            boolean r1 = r4.j(r1)     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L8d
            r1 = 1
            goto L8e
        L55:
            r1 = move-exception
            int r2 = r4.f25324r
            int r3 = r2 + 1
            r4.f25324r = r3
            r3 = 20
            if (r2 >= r3) goto L73
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "exception: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "doUploadApplogAdEventV3"
            j(r3, r2)
        L73:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "ignore:"
            r2.<init>(r3)
            java.lang.String r3 = r1.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "uploadEvent"
            com.bytedance.msdk.j.up.cw.r(r3, r2)
            com.bytedance.sdk.component.utils.vl.j(r1)
        L8d:
            r1 = 0
        L8e:
            if (r5 == 0) goto L95
            int r2 = r5.j()
            goto L96
        L95:
            r2 = 0
        L96:
            if (r1 != 0) goto L9f
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L9f
            java.lang.String r5 = "server say not success"
            goto Lc6
        L9f:
            if (r5 == 0) goto Lc3
            java.lang.String r6 = r5.xt()
            if (r1 != 0) goto Lc1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r6 = "::"
            r3.append(r6)
            java.lang.String r5 = r5.r()
            r3.append(r5)
            java.lang.String r5 = r3.toString()
        Lbf:
            r6 = 0
            goto Lc6
        Lc1:
            r5 = r6
            goto Lbf
        Lc3:
            java.lang.String r5 = "error unknown"
            goto Lbf
        Lc6:
            com.bytedance.msdk.up.up r0 = new com.bytedance.msdk.up.up
            r0.<init>(r1, r2, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.up.xt.xt.j(java.lang.String, byte[]):com.bytedance.msdk.up.up");
    }

    @Override // com.bytedance.msdk.up.xt.j
    public up j(List<com.bytedance.msdk.up.j> list) {
        up j6;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null) {
            return null;
        }
        boolean z5 = true;
        try {
            if (list.isEmpty()) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- v3: " + list.size());
            boolean j7 = j();
            byte[] j8 = j(list, j7);
            if (j8 != null && j8.length > 0) {
                j6 = j(com.bytedance.msdk.core.cw.xt(), j8, j7);
            } else {
                j6 = j(com.bytedance.msdk.core.cw.xt(), r(list));
            }
            if (list.size() < com.bytedance.msdk.core.xt.xt().s()) {
                z5 = false;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            l.j(j6.f25319j, list.size(), j(z5), elapsedRealtime2, j6.xt + "::" + j6.cw);
            return j6;
        } catch (Throwable th) {
            int i6 = this.cw;
            this.cw = i6 + 1;
            if (i6 < 20) {
                j("uploadEvent", "exception: " + th.toString());
            }
            com.bytedance.msdk.j.up.cw.r("ReportNetApiImpl", "uploadEvent error:");
            vl.j(th);
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            l.j(false, 0, j(z5), elapsedRealtime3, "-1::" + th);
            return new up(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, "service_busy", false);
        }
    }

    private String j(boolean z5) {
        if (xt) {
            xt = false;
            return "1";
        }
        if (f25323j) {
            f25323j = false;
            return "4";
        }
        if (z5) {
            return "3";
        }
        return "2";
    }

    private byte[] j(List<com.bytedance.msdk.up.j> list, boolean z5) {
        byte[] j6;
        byte[] xt2 = xt(list);
        if (xt2 == null) {
            j("buildAdEventV3Body", "zipData is null");
        } else if (xt2.length <= 0) {
            j("buildAdEventV3Body", "zipData len 0");
        }
        if (z5) {
            j6 = g.j().j(xt2);
        } else {
            j6 = j(xt2, xt2.length);
        }
        if (j6 == null) {
            j("buildAdEventV3Body", "data is null");
            return j6;
        }
        if (j6.length <= 0) {
            j("buildAdEventV3Body", "data len 0");
        }
        return j6;
    }

    private byte[] j(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    private byte[] j(byte[] bArr, int i6) {
        if (bArr != null && i6 > 0) {
            try {
                if (bArr.length == i6) {
                    return az.j(bArr, i6);
                }
            } catch (Throwable th) {
                j("encrypt", "exception: " + th.toString());
                vl.j(th);
                return null;
            }
        }
        StringBuilder sb = new StringBuilder("inputData is ");
        sb.append(bArr == null ? "null" : "0");
        j("encrypt", sb.toString());
        return null;
    }

    public static void j(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            l.j(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private boolean j(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code") != 20000) {
                    return "success".equals(jSONObject.optString(CrashHianalyticsData.MESSAGE));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
