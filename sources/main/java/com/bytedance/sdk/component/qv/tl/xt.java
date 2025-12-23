package com.bytedance.sdk.component.qv.tl;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            int indexOf = decode.indexOf(63);
            if (indexOf != -1) {
                Matcher matcher = Pattern.compile("([^&=]+)=((?:\\$\\{[^}]+\\})|[^&]+)").matcher(decode.substring(indexOf + 1));
                while (matcher.find()) {
                    jSONObject.put(matcher.group(1), matcher.group(2));
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
