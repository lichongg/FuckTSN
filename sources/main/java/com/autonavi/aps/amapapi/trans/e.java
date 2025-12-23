package com.autonavi.aps.amapapi.trans;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f10179a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private AMapLocationClientOption f10180b = new AMapLocationClientOption();

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.f10180b = new AMapLocationClientOption();
        } else {
            this.f10180b = aMapLocationClientOption;
        }
    }

    private static String b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a r17, byte[] r18, com.autonavi.aps.amapapi.a r19) {
        /*
            Method dump skipped, instructions count: 643
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(com.autonavi.aps.amapapi.model.a, byte[], com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void a(com.autonavi.aps.amapapi.model.a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(str, str2, sb);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            a(str7, str6, sb, aVar);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aVar.getCityCode());
        bundle.putString("desc", sb.toString());
        bundle.putString("adcode", aVar.getAdCode());
        aVar.setExtras(bundle);
        aVar.g(sb.toString());
        String adCode = aVar.getAdCode();
        if (adCode != null && adCode.trim().length() > 0 && this.f10180b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            aVar.setAddress(sb.toString().replace(" ", ""));
        } else {
            aVar.setAddress(sb.toString());
        }
    }

    private void a(String str, String str2, StringBuilder sb) {
        if (this.f10180b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            if (str2.equals(str)) {
                return;
            }
            sb.append(str2);
            sb.append(" ");
            return;
        }
        if (str.contains("市") && str.equals(str2)) {
            return;
        }
        sb.append(str2);
        sb.append(" ");
    }

    private void a(String str, String str2, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar) {
        if (!TextUtils.isEmpty(str) && this.f10180b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("靠近");
            sb.append(str2);
            sb.append(" ");
            aVar.setDescription("在" + str2 + "附近");
            return;
        }
        sb.append("Near ".concat(String.valueOf(str2)));
        aVar.setDescription("Near ".concat(String.valueOf(str2)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r3.length() <= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r2.setCity(r3);
        r5 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[Catch: all -> 0x0105, TRY_ENTER, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f1 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 0
            com.autonavi.aps.amapapi.model.a r2 = new com.autonavi.aps.amapapi.model.a     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = ""
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L105
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L105
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = "regeocode"
            org.json.JSONObject r13 = r1.optJSONObject(r13)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "addressComponent"
            org.json.JSONObject r1 = r13.optJSONObject(r1)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = "country"
            java.lang.String r3 = r1.optString(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = b(r3)     // Catch: java.lang.Throwable -> L105
            r2.setCountry(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = "province"
            java.lang.String r3 = r1.optString(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = b(r3)     // Catch: java.lang.Throwable -> L105
            r2.setProvince(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r4 = "citycode"
            java.lang.String r4 = r1.optString(r4)     // Catch: java.lang.Throwable -> L105
            java.lang.String r4 = b(r4)     // Catch: java.lang.Throwable -> L105
            r2.setCityCode(r4)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = "city"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "010"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "021"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "022"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "023"
            boolean r4 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r4 == 0) goto L67
            goto L6f
        L67:
            java.lang.String r5 = b(r5)     // Catch: java.lang.Throwable -> L105
            r2.setCity(r5)     // Catch: java.lang.Throwable -> L105
            goto L7b
        L6f:
            if (r3 == 0) goto L7b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L105
            if (r4 <= 0) goto L7b
            r2.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r5 = r3
        L7b:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L105
            if (r4 == 0) goto L86
            r2.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r4 = r3
            goto L87
        L86:
            r4 = r5
        L87:
            java.lang.String r5 = "district"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = b(r5)     // Catch: java.lang.Throwable -> L105
            r2.setDistrict(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "adcode"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r9 = b(r6)     // Catch: java.lang.Throwable -> L105
            r2.setAdCode(r9)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "streetNumber"
            org.json.JSONObject r1 = r1.optJSONObject(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "street"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = b(r6)     // Catch: java.lang.Throwable -> L105
            r2.setStreet(r6)     // Catch: java.lang.Throwable -> L105
            r2.setRoad(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r7 = "number"
            java.lang.String r1 = r1.optString(r7)     // Catch: java.lang.Throwable -> L105
            java.lang.String r7 = b(r1)     // Catch: java.lang.Throwable -> L105
            r2.setNumber(r7)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "pois"
            org.json.JSONArray r1 = r13.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r8 = r1.length()     // Catch: java.lang.Throwable -> L105
            java.lang.String r10 = "name"
            r11 = 0
            if (r8 <= 0) goto Le4
            org.json.JSONObject r1 = r1.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = r1.optString(r10)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = b(r1)     // Catch: java.lang.Throwable -> L105
            r2.setPoiName(r1)     // Catch: java.lang.Throwable -> L105
            r8 = r1
            goto Le5
        Le4:
            r8 = r0
        Le5:
            java.lang.String r1 = "aois"
            org.json.JSONArray r13 = r13.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r1 = r13.length()     // Catch: java.lang.Throwable -> L105
            if (r1 <= 0) goto L100
            org.json.JSONObject r13 = r13.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = r13.optString(r10)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = b(r13)     // Catch: java.lang.Throwable -> L105
            r2.setAoiName(r13)     // Catch: java.lang.Throwable -> L105
        L100:
            r1 = r12
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L105
            return r2
        L105:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(java.lang.String):com.autonavi.aps.amapapi.model.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0095 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #1 {all -> 0x006a, blocks: (B:11:0x0056, B:14:0x0063, B:17:0x007f, B:19:0x0095, B:26:0x006c), top: B:10:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(java.lang.String r10, android.content.Context r11, com.amap.api.col.p0003l.z6 r12, com.autonavi.aps.amapapi.a r13) {
        /*
            r9 = this;
            java.lang.String r0 = "#0701"
            java.lang.String r1 = "#0702"
            java.lang.String r2 = "status"
            com.autonavi.aps.amapapi.model.a r3 = new com.autonavi.aps.amapapi.model.a
            java.lang.String r4 = ""
            r3.<init>(r4)
            r4 = 7
            r3.setErrorCode(r4)
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r5 = 0
            java.lang.String r6 = "#SHA1AndPackage#"
            r4.append(r6)     // Catch: java.lang.Throwable -> L56
            java.lang.String r11 = com.amap.api.col.p0003l.f4.i(r11)     // Catch: java.lang.Throwable -> L56
            r4.append(r11)     // Catch: java.lang.Throwable -> L56
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11 = r12.f7801b     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = "gsid"
            java.lang.Object r11 = r11.get(r6)     // Catch: java.lang.Throwable -> L56
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Throwable -> L56
            java.lang.Object r11 = r11.get(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L56
            boolean r6 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            if (r6 != 0) goto L41
            java.lang.String r6 = "#gsid#"
            r4.append(r6)     // Catch: java.lang.Throwable -> L56
            r4.append(r11)     // Catch: java.lang.Throwable -> L56
        L41:
            java.lang.String r11 = r12.f7802c     // Catch: java.lang.Throwable -> L56
            boolean r6 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            if (r6 != 0) goto L56
            java.lang.String r6 = "#csid#"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L56
            java.lang.String r11 = r6.concat(r11)     // Catch: java.lang.Throwable -> L56
            r4.append(r11)     // Catch: java.lang.Throwable -> L56
        L56:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6a
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r6 = r11.has(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = "info"
            if (r6 == 0) goto L6c
            boolean r6 = r11.has(r7)     // Catch: java.lang.Throwable -> L6a
            if (r6 != 0) goto L7f
            goto L6c
        L6a:
            r10 = move-exception
            goto Lae
        L6c:
            r13.f(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r6 = r9.f10179a     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = "json is error:"
            r6.append(r8)     // Catch: java.lang.Throwable -> L6a
            r6.append(r10)     // Catch: java.lang.Throwable -> L6a
            r6.append(r4)     // Catch: java.lang.Throwable -> L6a
            r6.append(r1)     // Catch: java.lang.Throwable -> L6a
        L7f:
            java.lang.String r10 = r11.getString(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = r11.getString(r7)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "infocode"
            java.lang.String r11 = r11.getString(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "0"
            boolean r10 = r2.equals(r10)     // Catch: java.lang.Throwable -> L6a
            if (r10 == 0) goto Lce
            r13.f(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r10 = r9.f10179a     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "auth fail:"
            r10.append(r2)     // Catch: java.lang.Throwable -> L6a
            r10.append(r1)     // Catch: java.lang.Throwable -> L6a
            r10.append(r4)     // Catch: java.lang.Throwable -> L6a
            r10.append(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r10 = r12.f7803d     // Catch: java.lang.Throwable -> L6a
            com.autonavi.aps.amapapi.utils.h.a(r10, r11, r1)     // Catch: java.lang.Throwable -> L6a
            goto Lce
        Lae:
            java.lang.String r11 = "#0703"
            r13.f(r11)
            java.lang.StringBuilder r12 = r9.f10179a
            java.lang.String r13 = "json exception error:"
            r12.append(r13)
            java.lang.String r13 = r10.getMessage()
            r12.append(r13)
            r12.append(r4)
            r12.append(r11)
            java.lang.String r11 = "parser"
            java.lang.String r12 = "paseAuthFailurJson"
            com.autonavi.aps.amapapi.utils.b.a(r10, r11, r12)
        Lce:
            java.lang.StringBuilder r10 = r9.f10179a
            java.lang.String r10 = r10.toString()
            r3.setLocationDetail(r10)
            java.lang.StringBuilder r10 = r9.f10179a
            int r10 = r10.length()
            if (r10 <= 0) goto Le8
            java.lang.StringBuilder r10 = r9.f10179a
            int r11 = r10.length()
            r10.delete(r5, r11)
        Le8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(java.lang.String, android.content.Context, com.amap.api.col.3l.z6, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private static void a(com.autonavi.aps.amapapi.model.a aVar, short s5) {
        if (!"-1".equals(aVar.d())) {
            if (s5 == -1) {
                s5 = 0;
            } else if (s5 == 0) {
                s5 = -1;
            }
            aVar.setConScenario(s5);
            return;
        }
        if (s5 == 101) {
            s5 = 100;
        }
        aVar.setConScenario(s5);
    }
}
