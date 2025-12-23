package com.bytedance.sdk.openadsdk.core.cw;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.rn.oq;
import com.bytedance.sdk.openadsdk.core.rn.s;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private static long f28837j = -1;

    /* renamed from: r, reason: collision with root package name */
    private static volatile String f28838r;
    private static boolean xt;

    public static boolean xt() {
        if (xt) {
            return true;
        }
        if (f28837j == -1) {
            return false;
        }
        boolean z5 = SystemClock.elapsedRealtime() - f28837j > 60000;
        xt = z5;
        return z5;
    }

    public static String cw() {
        if (!TextUtils.isEmpty(f28838r)) {
            return f28838r;
        }
        String cw2 = r.j().cw((String) null);
        f28838r = cw2;
        return cw2;
    }

    public static void j() {
        if (f28837j > -1) {
            return;
        }
        f28837j = SystemClock.elapsedRealtime();
    }

    public static JSONObject j(Context context, int i6) {
        return xt(context, i6);
    }

    public static void j(JSONObject jSONObject, int i6) throws JSONException {
        if (!cw.j().j(i6)) {
            xt(jSONObject);
            return;
        }
        JSONArray i7 = r.j().i();
        if (i7 != null) {
            if (i7.length() > 0) {
                jSONObject.put("scheme_success_list", i7);
            }
            if (cw.get()) {
                return;
            }
            cw.set(true);
            ae.xt(new g("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.cw.j.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        j.xt(null);
                    } catch (Exception unused) {
                    }
                    j.cw.set(false);
                }
            });
            return;
        }
        xt(jSONObject);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(31:2|3|4|(3:154|(1:156)|157)(3:8|(1:10)|11)|12|(3:150|(1:152)|153)(3:16|(1:18)|19)|20|21|(3:146|(1:148)|149)(3:25|(1:27)|28)|29|30|(1:32)(1:145)|33|(3:141|(1:143)|144)(3:37|(1:39)|40)|41|42|(3:137|(1:139)|140)(3:46|(1:48)|49)|50|(1:52)|53|(3:132|(1:134)(1:136)|135)(3:57|(1:59)|60)|61|(3:127|(1:129)(1:131)|130)(3:65|(1:67)|68)|69|(3:122|(1:124)(1:126)|125)(3:73|(1:75)|76)|77|(3:117|(1:119)(1:121)|120)(3:81|(1:83)(1:116)|84)|85|(3:112|(1:114)|115)(1:89)|90|91)|(2:93|(9:95|96|(1:98)|99|(1:101)|102|103|104|105))|111|96|(0)|99|(0)|102|103|104|105) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0393, code lost:
    
        r1.put("device_score", -1);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0379 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0007, B:6:0x001e, B:8:0x0028, B:11:0x002f, B:14:0x0047, B:16:0x0051, B:19:0x0058, B:20:0x0069, B:23:0x0076, B:25:0x0080, B:28:0x0087, B:29:0x0098, B:32:0x00a4, B:35:0x00b7, B:37:0x00c1, B:40:0x00c8, B:41:0x00d9, B:44:0x0176, B:46:0x0180, B:49:0x0187, B:50:0x0198, B:52:0x0260, B:55:0x026d, B:57:0x0277, B:60:0x027e, B:63:0x0294, B:65:0x029e, B:68:0x02a5, B:71:0x02bb, B:73:0x02c5, B:76:0x02cc, B:79:0x02e2, B:81:0x02ec, B:84:0x02f4, B:87:0x030a, B:89:0x0314, B:90:0x0325, B:93:0x0335, B:95:0x0343, B:96:0x0352, B:98:0x0365, B:99:0x036a, B:101:0x0379, B:103:0x037e, B:104:0x0396, B:110:0x0393, B:111:0x0347, B:112:0x0318, B:115:0x0322, B:117:0x02f8, B:120:0x0303, B:122:0x02d0, B:125:0x02db, B:127:0x02a9, B:130:0x02b4, B:132:0x0282, B:135:0x028d, B:137:0x018b, B:140:0x0195, B:141:0x00cc, B:144:0x00d6, B:145:0x00ac, B:146:0x008b, B:149:0x0095, B:150:0x005c, B:153:0x0066, B:154:0x0036, B:157:0x0040), top: B:2:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0365 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0007, B:6:0x001e, B:8:0x0028, B:11:0x002f, B:14:0x0047, B:16:0x0051, B:19:0x0058, B:20:0x0069, B:23:0x0076, B:25:0x0080, B:28:0x0087, B:29:0x0098, B:32:0x00a4, B:35:0x00b7, B:37:0x00c1, B:40:0x00c8, B:41:0x00d9, B:44:0x0176, B:46:0x0180, B:49:0x0187, B:50:0x0198, B:52:0x0260, B:55:0x026d, B:57:0x0277, B:60:0x027e, B:63:0x0294, B:65:0x029e, B:68:0x02a5, B:71:0x02bb, B:73:0x02c5, B:76:0x02cc, B:79:0x02e2, B:81:0x02ec, B:84:0x02f4, B:87:0x030a, B:89:0x0314, B:90:0x0325, B:93:0x0335, B:95:0x0343, B:96:0x0352, B:98:0x0365, B:99:0x036a, B:101:0x0379, B:103:0x037e, B:104:0x0396, B:110:0x0393, B:111:0x0347, B:112:0x0318, B:115:0x0322, B:117:0x02f8, B:120:0x0303, B:122:0x02d0, B:125:0x02db, B:127:0x02a9, B:130:0x02b4, B:132:0x0282, B:135:0x028d, B:137:0x018b, B:140:0x0195, B:141:0x00cc, B:144:0x00d6, B:145:0x00ac, B:146:0x008b, B:149:0x0095, B:150:0x005c, B:153:0x0066, B:154:0x0036, B:157:0x0040), top: B:2:0x0007, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject xt(android.content.Context r14, int r15) {
        /*
            Method dump skipped, instructions count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.cw.j.xt(android.content.Context, int):org.json.JSONObject");
    }

    public static String[] j(int i6) {
        try {
            return oq.j(!xt());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String j(String str, int i6) {
        return oq.j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(JSONObject jSONObject) throws JSONException {
        Set<String> nu = v.xt().nu();
        if (nu == null || nu.size() <= 0) {
            return;
        }
        Map<String, Boolean> j6 = s.j(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : j6.entrySet()) {
            String key = entry.getKey();
            if (nu.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            r.j().j(jSONArray);
        } else {
            ae.xt(new g("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.cw.j.2
                @Override // java.lang.Runnable
                public void run() {
                    r.j().j(jSONArray);
                }
            });
        }
    }
}
