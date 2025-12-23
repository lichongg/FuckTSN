package com.amap.api.col.p0003l;

import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.kuaishou.weapon.p0.b;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d2 {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f5893d = {1};

    /* renamed from: a, reason: collision with root package name */
    private int f5894a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f5895b = -1;

    /* renamed from: c, reason: collision with root package name */
    List<a2> f5896c = null;

    public static b2 c(byte[] bArr) {
        b2 b2Var;
        b2 b2Var2 = null;
        try {
            b2Var = new b2();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bytes = t.f36143d.getBytes("utf-8");
            int length = bArr.length;
            int length2 = bytes.length;
            for (int i6 = 0; i6 < length; i6++) {
                bArr[i6] = (byte) (bytes[i6 % length2] ^ bArr[i6]);
            }
            b2Var.b(Convert.getString(bArr, 0, 4));
            b2Var.c(Convert.getString(bArr, 4, 32));
            b2Var.d(Convert.getString(bArr, 36, 10));
            b2Var.e(g(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
            return b2Var;
        } catch (Throwable th2) {
            th = th2;
            b2Var2 = b2Var;
            th.printStackTrace();
            return b2Var2;
        }
    }

    private static void o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i6, a2 a2Var) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt == 0) {
                return;
            }
            f(map, i6, cx.a(str), a2Var).textureId = optInt;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void p(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i6, a2 a2Var) {
        int b6;
        float f6;
        try {
            String optString = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(optString)) {
                f6 = (float) jSONObject.optDouble(str2, 1.0d);
                b6 = 0;
            } else {
                b6 = b("#".concat(String.valueOf(optString)));
                f6 = 1.0f;
            }
            if (b6 == 0 && f6 == 1.0d) {
                return;
            }
            int a6 = cx.a(str);
            StyleElement f7 = f(map, i6, a6, a2Var);
            f7.value = b6;
            f7.opacity = f6;
            String str3 = a2Var.f5623f;
            if (str3 != null && str3.equals("China")) {
                f(map, i6, a6, a2Var).opacity = 0.0f;
                return;
            }
            String str4 = a2Var.f5622e;
            if (str4 != null && str4.equals("water") && a6 == 3) {
                StyleElement f8 = f(map, i6, 2, a2Var);
                f8.value = b6;
                f8.opacity = f6;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void q(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i6) throws JSONException {
        for (String str2 : strArr) {
            if (this.f5896c == null) {
                this.f5896c = v();
            }
            for (a2 a2Var : h(str, str2)) {
                n(map, jSONObject, a2Var.f5621d, i6, a2Var);
            }
        }
    }

    private boolean s(Map<Integer, StyleItem> map, byte[] bArr) {
        Map<Integer, StyleItem> map2;
        String[] a6;
        int a7;
        int b6;
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            int i6 = 0;
            while (i6 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                String optString = optJSONObject.optString("featureType");
                if (!TextUtils.isEmpty(optString)) {
                    if ("background".equals(optString)) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                        if (optJSONObject2 != null && (b6 = b(optJSONObject2.optString("color"))) != 0) {
                            this.f5894a = b6;
                        }
                    } else {
                        String b7 = c2.b(optString);
                        if (b7 != null && (a6 = c2.a(optString)) != null && a6.length != 0) {
                            String optString2 = optJSONObject.optString("elementType");
                            if (!TextUtils.isEmpty(optString2) && (a7 = cx.a(optString2)) != -1) {
                                map2 = map;
                                q(map2, optJSONObject, b7, a6, a7);
                                i6++;
                                map = map2;
                            }
                        }
                    }
                }
                map2 = map;
                i6++;
                map = map2;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#".concat(str);
            }
            return Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static String g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(b.f35751a);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<a2> h(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        for (a2 a2Var : this.f5896c) {
            if (a2Var != null) {
                String str4 = a2Var.f5622e;
                if (str4 == null || !str4.equals(str2)) {
                    String str5 = a2Var.f5622e;
                    if (str5 != null && str5.equals(str) && (str3 = a2Var.f5623f) != null && str3.contains(str2)) {
                        arrayList.add(a2Var);
                    }
                } else {
                    arrayList.add(a2Var);
                }
            }
        }
        return arrayList;
    }

    private void j(f2 f2Var) {
        if (this.f5895b != -1) {
            Map<Integer, StyleItem> a6 = f2Var.a();
            for (a2 a2Var : h("roads", "trafficRoadBackgroundColor")) {
                f(a6, a2Var.f5621d, cx.a("fillColor"), a2Var).value = this.f5895b;
                f(a6, a2Var.f5621d, cx.a("strokeColor"), a2Var).value = this.f5895b;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r3.trim().equals("background") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r6.f5894a = b("#".concat(java.lang.String.valueOf(r1.optString("background"))));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k(com.amap.api.col.p0003l.f2 r7, byte[] r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "background"
            com.amap.api.col.3l.b2 r8 = c(r8)
            if (r8 == 0) goto L6b
            java.lang.String r1 = r8.a()
            if (r1 == 0) goto L6b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r8.a()     // Catch: java.lang.Throwable -> L35
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L35
            org.json.JSONArray r8 = r1.names()     // Catch: java.lang.Throwable -> L35
            r2 = 0
        L1c:
            int r3 = r8.length()     // Catch: java.lang.Throwable -> L35
            if (r2 >= r3) goto L6b
            java.lang.String r3 = r8.getString(r2)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L37
            java.lang.String r4 = r3.trim()     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = "sdkTextures"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L35
            if (r4 != 0) goto L65
            goto L37
        L35:
            r7 = move-exception
            goto L68
        L37:
            if (r3 == 0) goto L58
            java.lang.String r4 = r3.trim()     // Catch: java.lang.Throwable -> L35
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L58
            java.lang.String r3 = r1.optString(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = "#"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r4.concat(r3)     // Catch: java.lang.Throwable -> L35
            int r3 = b(r3)     // Catch: java.lang.Throwable -> L35
            r6.f5894a = r3     // Catch: java.lang.Throwable -> L35
            goto L65
        L58:
            org.json.JSONObject r4 = r1.optJSONObject(r3)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L65
            java.util.Map r5 = r7.a()     // Catch: java.lang.Throwable -> L35
            r6.m(r3, r5, r4, r9)     // Catch: java.lang.Throwable -> L35
        L65:
            int r2 = r2 + 1
            goto L1c
        L68:
            r7.printStackTrace()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d2.k(com.amap.api.col.3l.f2, byte[], boolean):void");
    }

    private void l(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z5) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.f5896c == null) {
            this.f5896c = v();
        }
        List<a2> h6 = h(str, str2);
        for (a2 a2Var : h6) {
            if (a2Var == null || a2Var.f5620c == -1000) {
                return;
            }
            int i6 = a2Var.f5621d;
            if (jSONObject.optBoolean("visible", true)) {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    f(map, i6, cx.a("textFillColor"), a2Var).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    f(map, i6, cx.a("textFillColor"), a2Var).opacity = 0.0f;
                    StyleElement f6 = f(map, i6, cx.a("textStrokeColor"), a2Var);
                    f6.opacity = 0.0f;
                    f6.visible = 0;
                    f6.textureId = -1;
                }
                Map<Integer, StyleItem> map2 = map;
                JSONObject jSONObject2 = jSONObject;
                p(map2, jSONObject2, "color", "opacity", i6, a2Var);
                p(map2, jSONObject2, "fillColor", "fillOpacity", i6, a2Var);
                p(map2, jSONObject2, "strokeColor", "strokeOpacity", i6, a2Var);
                p(map2, jSONObject2, "textFillColor", "textFillOpacity", i6, a2Var);
                p(map2, jSONObject2, "textStrokeColor", "textStrokeOpacity", i6, a2Var);
                p(map2, jSONObject2, "backgroundColor", "backgroundOpacity", i6, a2Var);
                if (z5) {
                    o(map2, jSONObject2, "textureName", i6, a2Var);
                }
                map = map2;
                jSONObject = jSONObject2;
            } else {
                StyleElement f7 = f(map, i6, cx.a("visible"), a2Var);
                f7.textureId = -1;
                f7.visible = 0;
            }
        }
        h6.clear();
    }

    private void m(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z5) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("subType");
        if (optJSONObject == null) {
            l(str, str, map, jSONObject, z5);
            return;
        }
        JSONArray names = optJSONObject.names();
        for (int i6 = 0; i6 < names.length(); i6++) {
            String optString = names.optString(i6);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
            if (optJSONObject2.has("detailedType")) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detailedType");
                if (optJSONObject3 != null) {
                    JSONArray names2 = optJSONObject3.names();
                    for (int i7 = 0; i7 < names2.length(); i7++) {
                        String optString2 = names2.optString(i7);
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject(optString2);
                        if (optJSONObject4 != null) {
                            l(str, optString2, map, optJSONObject4, z5);
                        }
                    }
                }
            } else {
                l(str, optString, map, optJSONObject2, z5);
            }
        }
    }

    private static void r(JSONArray jSONArray, String str, String str2, String str3, List<a2> list) {
        String str4;
        String str5;
        String str6;
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        int i6 = 0;
        while (i6 < length) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i7 = 0; i7 < length2; i7++) {
                        iArr3[i7] = optJSONArray.optInt(i7);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                str4 = str;
                str5 = str2;
                str6 = str3;
                list.add(new a2(optInt, iArr, str4, str5, str6));
            } else {
                str4 = str;
                str5 = str2;
                str6 = str3;
            }
            i6++;
            str = str4;
            str2 = str5;
            str3 = str6;
        }
    }

    private f2 u(byte[] bArr, boolean z5) {
        f2 f2Var = new f2();
        try {
            if (!s(f2Var.a(), bArr)) {
                k(f2Var, bArr, z5);
            }
            j(f2Var);
            f2Var.b();
            return f2Var;
        } catch (Throwable th) {
            th.printStackTrace();
            return f2Var;
        }
    }

    private List<a2> v() {
        JSONArray jSONArray;
        String str;
        String str2;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        int i6;
        int i7;
        String str3;
        String str4;
        JSONObject jSONObject2;
        JSONArray jSONArray3;
        int i8;
        int i9;
        JSONObject optJSONObject;
        String str5;
        JSONObject jSONObject3;
        String str6 = CommonNetImpl.NAME;
        String str7 = "subType";
        this.f5896c = new ArrayList();
        try {
            jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return this.f5896c;
        }
        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            return this.f5896c;
        }
        JSONArray names = optJSONObject2.names();
        int length = names.length();
        int i10 = 0;
        while (i10 < length) {
            String optString = names.optString(i10);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString);
            if (optJSONObject3 != null) {
                String optString2 = optJSONObject3.optString(str6);
                if (optJSONObject3.has("styleMap")) {
                    r(optJSONObject3.optJSONArray("styleMap"), optString, null, optString2, this.f5896c);
                } else if (optJSONObject3.has(str7)) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str7);
                    if (optJSONObject4 != null) {
                        JSONArray names2 = optJSONObject4.names();
                        int length2 = names2.length();
                        int i11 = 0;
                        while (i11 < length2) {
                            String optString3 = names2.optString(i11);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                            if (optJSONObject5 != null) {
                                jSONObject2 = optJSONObject2;
                                String optString4 = optJSONObject5.optString(str6);
                                jSONArray3 = names;
                                if (optJSONObject5.has("styleMap")) {
                                    i8 = length;
                                    r(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + "-" + optString4, this.f5896c);
                                } else {
                                    i8 = length;
                                    if (optJSONObject5.has(str7) && (optJSONObject = optJSONObject5.optJSONObject(str7)) != null) {
                                        JSONArray names3 = optJSONObject.names();
                                        str4 = str7;
                                        int length3 = names3.length();
                                        i9 = i10;
                                        int i12 = 0;
                                        while (i12 < length3) {
                                            int i13 = length3;
                                            String optString5 = names3.optString(i12);
                                            JSONArray jSONArray4 = names3;
                                            JSONObject optJSONObject6 = optJSONObject.optJSONObject(optString5);
                                            if (optJSONObject6 != null) {
                                                jSONObject3 = optJSONObject;
                                                String optString6 = optJSONObject6.optString(str6);
                                                if (optJSONObject6.has("styleMap")) {
                                                    str5 = str6;
                                                    r(optJSONObject6.optJSONArray("styleMap"), optString, optString3 + "-" + optString5, optString2 + "-" + optString4 + "-" + optString6, this.f5896c);
                                                } else {
                                                    str5 = str6;
                                                }
                                            } else {
                                                str5 = str6;
                                                jSONObject3 = optJSONObject;
                                            }
                                            i12++;
                                            length3 = i13;
                                            names3 = jSONArray4;
                                            optJSONObject = jSONObject3;
                                            str6 = str5;
                                        }
                                        str3 = str6;
                                        i11++;
                                        optJSONObject2 = jSONObject2;
                                        length = i8;
                                        names = jSONArray3;
                                        str7 = str4;
                                        i10 = i9;
                                        str6 = str3;
                                    }
                                }
                                str3 = str6;
                                str4 = str7;
                            } else {
                                str3 = str6;
                                str4 = str7;
                                jSONObject2 = optJSONObject2;
                                jSONArray3 = names;
                                i8 = length;
                            }
                            i9 = i10;
                            i11++;
                            optJSONObject2 = jSONObject2;
                            length = i8;
                            names = jSONArray3;
                            str7 = str4;
                            i10 = i9;
                            str6 = str3;
                        }
                    }
                }
                str = str6;
                str2 = str7;
                jSONObject = optJSONObject2;
                jSONArray2 = names;
                i6 = length;
                i7 = i10;
                this.f5896c.add(new a2(20021, f5893d, "roads", "trafficRoadBackgroundColor", null));
                i10 = i7 + 1;
                optJSONObject2 = jSONObject;
                length = i6;
                names = jSONArray2;
                str7 = str2;
                str6 = str;
            }
            str = str6;
            str2 = str7;
            jSONObject = optJSONObject2;
            jSONArray2 = names;
            i6 = length;
            i7 = i10;
            i10 = i7 + 1;
            optJSONObject2 = jSONObject;
            length = i6;
            names = jSONArray2;
            str7 = str2;
            str6 = str;
        }
        return this.f5896c;
    }

    public final int a() {
        return this.f5894a;
    }

    public final f2 d(String str, boolean z5) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return t(str, z5);
    }

    public final f2 e(byte[] bArr, boolean z5) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return u(bArr, z5);
    }

    public final void i(int i6) {
        this.f5895b = i6;
    }

    private static StyleElement f(Map<Integer, StyleItem> map, int i6, int i7, a2 a2Var) {
        StyleItem styleItem = map.get(Integer.valueOf(i6));
        if (styleItem == null) {
            styleItem = new StyleItem(a2Var.f5620c);
            styleItem.mainKey = a2Var.f5618a;
            styleItem.subKey = a2Var.f5619b;
            map.put(Integer.valueOf(i6), styleItem);
        }
        StyleElement styleElement = styleItem.get(i7);
        if (styleElement == null) {
            StyleElement styleElement2 = new StyleElement();
            styleElement2.styleElementType = i7;
            styleItem.put(i7, styleElement2);
            return styleElement2;
        }
        return styleElement;
    }

    private static void n(Map<Integer, StyleItem> map, JSONObject jSONObject, int i6, int i7, a2 a2Var) throws JSONException {
        int b6;
        StyleElement f6 = f(map, i6, i7, a2Var);
        JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
        if (optJSONObject != null && (b6 = b(optJSONObject.optString("color"))) != 0) {
            f6.value = b6;
            f6.textureId = optJSONObject.optInt("textureName", 0);
            f6.lineWidth = optJSONObject.optInt("lineWidth", 0);
            if (i6 >= 30 && i6 <= 38) {
                f(map, i6, 4, a2Var).opacity = 0.1f;
                return;
            }
            String str = a2Var.f5622e;
            if (str != null && str.equals("water") && i7 == 3) {
                f(map, i6, 2, a2Var).value = b6;
            }
        }
    }

    private f2 t(String str, boolean z5) {
        try {
            return u(FileUtil.readFileContents(str), z5);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
