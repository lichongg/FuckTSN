package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cg {
    public static void a(final Context context, String str, String str2, boolean z5) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f35929a + cu.f35934f;
            String a6 = cv.a(context);
            if (!TextUtils.isEmpty(a6)) {
                if (!cu.a() || str2 == null) {
                    str3 = str3 + "?" + a6;
                } else {
                    str3 = str3 + "?logId=" + str2 + ContainerUtils.FIELD_DELIMITER + a6;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z5) {
                jSONObject = new JSONObject();
                String c6 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c6)) {
                    jSONObject.put("data", c6);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cg.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cg.a(context, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bn(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                    bx.a(context, string);
                    bx.b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }
}
