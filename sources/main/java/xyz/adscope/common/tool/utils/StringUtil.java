package xyz.adscope.common.tool.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StringUtil {
    public static String replaceStr(Context context, String str) {
        return replaceM(context, str, null);
    }

    public static String ListToString(List<String> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (i6 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(list.get(i6));
            sb.append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    public static int getRandomValue(int i6) {
        return new Random().nextInt(i6);
    }

    public static Map<String, String> mapStringToMap(String str) {
        try {
            if (!TextUtils.isEmpty(str.trim()) && str.length() >= 2) {
                String[] split = str.substring(1, str.length() - 1).split(",");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length == 2) {
                        hashMap.put(split2[0].trim(), split2[1].trim());
                    } else {
                        LogUtil.e("StringUtil", "Invalid key-value pair: " + str2);
                    }
                }
                return hashMap;
            }
        } catch (Exception e6) {
            LogUtil.e("StringUtil", "Exception: " + e6);
        }
        return null;
    }

    public static float strToFloat(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Float.parseFloat(str);
            }
            return 0.0f;
        } catch (Exception e6) {
            LogUtil.e("StringUtil", "e : " + e6);
            return 0.0f;
        }
    }

    public static int strToInt(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (Exception e6) {
            LogUtil.e("StringUtil", "e : " + e6);
            return 0;
        }
    }

    public static String replaceM(Context context, String str, String str2) {
        return str;
    }
}
