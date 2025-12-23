package com.bytedance.msdk.tl;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class i {
    public static boolean j() {
        Map<String, Object> gq = com.bytedance.msdk.core.j.qv().gq();
        Map<String, Object> la = com.bytedance.msdk.core.j.qv().la();
        if (gq != null) {
            try {
                if (gq.get("eefo") instanceof Boolean) {
                    return ((Boolean) gq.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (la == null || !(la.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) la.get("eefo")).booleanValue();
    }

    private static String xt(String str, String str2) {
        try {
            return j.j(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j(com.bytedance.msdk.api.cw cwVar) {
        if (cwVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, cwVar.g());
            jSONObject.put("custom_adn_name", cwVar.oq());
            jSONObject.put("slot_id", cwVar.qv());
            jSONObject.put("level_tag", cwVar.ws());
            jSONObject.put("ecpm", cwVar.jy());
            jSONObject.put("bidding_type", cwVar.az());
            jSONObject.put("error_msg", cwVar.av());
            jSONObject.put("request_id", cwVar.i());
            jSONObject.put("ad_rit_type", cwVar.xt());
            jSONObject.put("ad_sub_rit_type", cwVar.cw());
            jSONObject.put("segment_id", cwVar.r());
            jSONObject.put("abtest_id", cwVar.ae());
            jSONObject.put("channel", cwVar.up());
            jSONObject.put("sub_channel", cwVar.m());
            jSONObject.put("scenario_id", cwVar.tl());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        try {
            String j6 = j(16);
            String xt = xt(jSONObject2, j6);
            String j7 = j(j6, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(j7.length())) + j7 + xt;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, generatePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(int i6) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i7 = 0; i7 < i6; i7++) {
            int nextInt = secureRandom.nextInt(3);
            if (nextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (nextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (nextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
