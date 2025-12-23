package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class n {
    public static boolean e(Map<String, String> map) {
        String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else {
            if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            }
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        j1.m("hmsSdk", str);
        return false;
    }

    public static boolean b(String str) {
        return !c("eventId", str, 256);
    }

    public static String a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            j1.m("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
            return str4;
        }
        if (d(str, str2, str3)) {
            return str2;
        }
        return str4;
    }

    public static boolean c(String str, String str2, int i6) {
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str3 = "checkString() Parameter is empty : ";
        } else if (str2.length() > i6) {
            sb = new StringBuilder();
            str3 = "checkString() Failure of parameter length check! Parameter:";
        } else {
            return true;
        }
        sb.append(str3);
        sb.append(str);
        j1.m("hmsSdk", sb.toString());
        return false;
    }

    public static boolean d(String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str4 = "checkString() Parameter is null! Parameter:";
        } else {
            if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            sb = new StringBuilder();
            str4 = "checkString() Parameter verification failure! Parameter:";
        }
        sb.append(str4);
        sb.append(str);
        j1.m("hmsSdk", sb.toString());
        return false;
    }
}
