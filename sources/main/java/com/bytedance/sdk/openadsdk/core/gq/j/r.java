package com.bytedance.sdk.openadsdk.core.gq.j;

import com.huawei.hms.framework.common.ContainerUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private static String j(long j6) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j6);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "300012449765");
            jSONObject.put("version", "1.0");
            String j6 = j(System.currentTimeMillis());
            jSONObject.put("timestamp", j6);
            jSONObject.put("appkey", "90E4DEDAD9B1CB57EA1538871ED468A7");
            jSONObject.put("businessType", "3");
            String uuid = UUID.randomUUID().toString();
            jSONObject.put("traceId", uuid);
            jSONObject.put("msgId", uuid);
            jSONObject.put("sign", com.bytedance.sdk.component.utils.up.xt("3000124497653" + uuid + j6 + uuid + "1.090E4DEDAD9B1CB57EA1538871ED468A7"));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String j(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("?");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", "9386206798");
            jSONObject.put("clientType", "Android-30100");
            jSONObject.put(IjkMediaMeta.IJKM_KEY_FORMAT, "json");
            jSONObject.put("version", "v1.5");
            String j6 = j.j(str2.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
            jSONObject.put("paramKey", j6);
            String j7 = j.j(true, ("timeStamp=" + System.currentTimeMillis()).getBytes(), str2);
            jSONObject.put("paramStr", j7);
            String[] strArr = {"9386206798", "Android-30100", "json", j6, j7, "v1.5"};
            StringBuilder sb2 = new StringBuilder();
            for (int i6 = 0; i6 < 6; i6++) {
                sb2.append(strArr[i6]);
            }
            jSONObject.put("sign", j.j(sb2.toString(), "tgIBkg304BUpjGHLSq1wYYb0Xs77pMIm"));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                sb.append(next);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(string);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
