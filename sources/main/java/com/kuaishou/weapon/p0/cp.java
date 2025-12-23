package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cp {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, String str, final String str2, final boolean z5, boolean z6) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f35929a + cu.f35933e;
            String a6 = cv.a(context);
            if (!TextUtils.isEmpty(a6)) {
                if (!cu.a() || str2 == null) {
                    str3 = str3 + "?" + a6;
                } else {
                    str3 = str3 + "?logId=" + str2 + ContainerUtils.FIELD_DELIMITER + a6;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z6) {
                jSONObject = new JSONObject();
                String c6 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c6)) {
                    jSONObject.put("data", c6);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a7 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a7.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        if (str2.equals(ck.f35869b)) {
                            df.a(context).a(System.currentTimeMillis());
                            return;
                        }
                        if (str2.equals(ck.f35870c)) {
                            df.a(context).a(df.bj, System.currentTimeMillis());
                            return;
                        }
                        if (str2.equals(ck.f35871d)) {
                            df.a(context).a(df.bi, System.currentTimeMillis());
                        } else if (str2.equals(ck.f35874g)) {
                            df.a(context).a(df.bm, System.currentTimeMillis());
                        } else if (str2.equals(ck.f35876i)) {
                            df.a(context).a(df.bh, System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z5) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
