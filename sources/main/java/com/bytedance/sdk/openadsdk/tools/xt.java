package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static Map<Integer, String> cw = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f31860j = "SettingRitRepertoryImpl";

    /* renamed from: r, reason: collision with root package name */
    private static long f31861r;
    private static boolean xt;

    public static String cw() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static boolean j() {
        return xt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (0 == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.Integer, java.lang.String> r() {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "_id"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.v.getContext()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            java.lang.String r5 = "setting_global_info"
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            r10 = 0
            r11 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r3 = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            if (r3 != 0) goto L25
            if (r3 == 0) goto L59
            r3.close()
            return r2
        L25:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            if (r4 == 0) goto L4a
            int r4 = r3.getColumnIndex(r1)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            int r4 = r3.getInt(r4)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            int r5 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            if (r5 != 0) goto L46
            java.lang.String r5 = ""
            goto L46
        L44:
            r0 = move-exception
            goto L50
        L46:
            r2.put(r4, r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            goto L25
        L4a:
            r3.close()
            goto L59
        L4e:
            goto L56
        L50:
            if (r3 == 0) goto L55
            r3.close()
        L55:
            throw r0
        L56:
            if (r3 == 0) goto L59
            goto L4a
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.xt.r():java.util.Map");
    }

    public static void xt() {
        xt = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(5:9|10|(1:29)(1:14)|15|(4:17|19|20|21))|24|25|26) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject cw(java.lang.String r10) throws org.json.JSONException {
        /*
            boolean r0 = j()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.v.getContext()
            java.lang.String[] r6 = new java.lang.String[]{r10}
            r8 = 0
            r9 = 0
            java.lang.String r3 = "setting_rit"
            r4 = 0
            java.lang.String r5 = "rit=?"
            r7 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r10 == 0) goto L65
            int r0 = r10.getCount()
            if (r0 > 0) goto L25
            goto L65
        L25:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L3a
            java.lang.String r0 = "preview_ads"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L38
            if (r0 < 0) goto L3a
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L38
            goto L3c
        L38:
            r0 = move-exception
            goto L53
        L3a:
            java.lang.String r0 = ""
        L3c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L4f
            java.lang.String r0 = com.bytedance.sdk.component.utils.j.cw(r0)     // Catch: java.lang.Throwable -> L38
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L38
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L38
            r10.close()     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r2
        L4f:
            r10.close()     // Catch: java.lang.Throwable -> L5f
            goto L5f
        L53:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.tools.xt.f31860j     // Catch: java.lang.Throwable -> L60
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L60
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L60
            com.bytedance.sdk.component.utils.vl.xt(r2, r3)     // Catch: java.lang.Throwable -> L60
            goto L4f
        L5f:
            return r1
        L60:
            r0 = move-exception
            r10.close()     // Catch: java.lang.Throwable -> L64
        L64:
            throw r0
        L65:
            if (r10 == 0) goto L6a
            r10.close()
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.xt.cw(java.lang.String):org.json.JSONObject");
    }

    public static String j(int i6, String str) {
        if (cw == null || System.currentTimeMillis() - f31861r > 2000) {
            f31861r = System.currentTimeMillis();
            cw = r();
        }
        Map<Integer, String> map = cw;
        if (map == null || map.containsKey(Integer.valueOf(i6))) {
            try {
                String cw2 = com.bytedance.sdk.component.utils.j.cw(map.get(Integer.valueOf(i6)));
                return "null".equals(cw2) ? "" : cw2;
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(5:9|10|(1:29)(1:14)|15|(4:17|19|20|21))|24|25|26) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject xt(java.lang.String r10) throws org.json.JSONException {
        /*
            boolean r0 = j()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.v.getContext()
            java.lang.String[] r6 = new java.lang.String[]{r10}
            r8 = 0
            r9 = 0
            java.lang.String r3 = "setting_rit"
            r4 = 0
            java.lang.String r5 = "rit=?"
            r7 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r10 == 0) goto L65
            int r0 = r10.getCount()
            if (r0 > 0) goto L25
            goto L65
        L25:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L3a
            java.lang.String r0 = "config"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L38
            if (r0 < 0) goto L3a
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L38
            goto L3c
        L38:
            r0 = move-exception
            goto L53
        L3a:
            java.lang.String r0 = ""
        L3c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L4f
            java.lang.String r0 = com.bytedance.sdk.component.utils.j.cw(r0)     // Catch: java.lang.Throwable -> L38
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L38
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L38
            r10.close()     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r2
        L4f:
            r10.close()     // Catch: java.lang.Throwable -> L5f
            goto L5f
        L53:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.tools.xt.f31860j     // Catch: java.lang.Throwable -> L60
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L60
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L60
            com.bytedance.sdk.component.utils.vl.xt(r2, r3)     // Catch: java.lang.Throwable -> L60
            goto L4f
        L5f:
            return r1
        L60:
            r0 = move-exception
            r10.close()     // Catch: java.lang.Throwable -> L64
        L64:
            throw r0
        L65:
            if (r10 == 0) goto L6a
            r10.close()
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.xt.xt(java.lang.String):org.json.JSONObject");
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.j.j.delete(v.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    public static Map<String, String> j(String str) throws JSONException {
        JSONObject xt2 = xt(str);
        if (xt2 == null) {
            return null;
        }
        String optString = xt2.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject("headers");
                if (optJSONObject == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception unused) {
                return hashMap;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0026 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean r(java.lang.String r8) {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.v.getContext()
            java.lang.String[] r4 = new java.lang.String[]{r8}
            r6 = 0
            r7 = 0
            java.lang.String r1 = "setting_rit"
            r2 = 0
            java.lang.String r3 = "rit=?"
            r5 = 0
            android.database.Cursor r8 = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r8 == 0) goto L23
            int r0 = r8.getCount()     // Catch: java.lang.Throwable -> L1e
            if (r0 <= 0) goto L23
            r0 = 1
            goto L24
        L1e:
            r0 = move-exception
            r8.close()
            throw r0
        L23:
            r0 = 0
        L24:
            if (r8 == 0) goto L29
            r8.close()
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.xt.r(java.lang.String):boolean");
    }

    public static void cw(int i6, String str) {
        if (j()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i6)}, null, null, null);
            boolean z5 = query != null && query.getCount() > 0;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
            }
            String xt2 = com.bytedance.sdk.component.utils.j.xt(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(bm.f41039d, Integer.valueOf(i6));
            contentValues.put("value", xt2);
            if (z5) {
                com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i6)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.j.j.insert(v.getContext(), "setting_global_info", contentValues);
            }
        }
    }

    public static void xt(JSONObject jSONObject, String str) throws JSONException {
        JSONObject cw2;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (cw2 = cw(str)) == null) {
            return;
        }
        if (cw2.has("image_mode")) {
            jSONObject.put("image_mode", cw2.optString("image_mode"));
        }
        if (cw2.has("preview_extra")) {
            jSONObject.put("preview_extra", cw2.optString("preview_extra"));
        }
        if (cw2.has("preview_ads")) {
            jSONObject.put("preview_ads", cw2.optJSONObject("preview_ads"));
        }
    }

    public static void j(JSONObject jSONObject, String str) throws JSONException {
        JSONObject xt2 = xt(str);
        if (xt2 == null) {
            return;
        }
        String optString = xt2.optString(CommonNetImpl.AID);
        String optString2 = xt2.optString("cid");
        String optString3 = xt2.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
        if (!TextUtils.isEmpty(optString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, optString);
        }
        if (!TextUtils.isEmpty(optString2)) {
            jSONObject.put("creative_id", optString2);
        }
        if (TextUtils.isEmpty(optString3)) {
            return;
        }
        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, optString3);
    }

    public static void xt(int i6, String str) {
        if (j()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            try {
                com.bytedance.sdk.openadsdk.core.multipro.j.j.j(v.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i6 + ", '" + com.bytedance.sdk.component.utils.j.xt(str) + "')");
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public static void j(String str, JSONObject jSONObject) {
        if (!j() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.j.j.query(v.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z5 = query != null && query.getCount() > 0;
        if (query != null) {
            try {
                query.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject j6 = com.bytedance.sdk.component.utils.j.j(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("value", j6.toString());
        if (z5) {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.j.j.insert(v.getContext(), "setting_rit", contentValues);
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (j()) {
            String r5 = xtVar.r();
            if (r(r5)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", xtVar.m());
                    jSONObject.put("img_height", xtVar.ae());
                    jSONObject.put("express_width", xtVar.tl());
                    jSONObject.put("express_height", xtVar.g());
                    jSONObject.put("ad_count", xtVar.vl());
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", r5);
                contentValues.put(InAppSlotParams.SLOT_KEY.SLOT, com.bytedance.sdk.component.utils.j.xt(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.j.j.update(v.getContext(), "setting_rit", contentValues, "rit=?", new String[]{r5});
            }
        }
    }
}
