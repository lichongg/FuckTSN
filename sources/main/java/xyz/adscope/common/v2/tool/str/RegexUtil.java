package xyz.adscope.common.v2.tool.str;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RegexUtil {
    public static final String REGEX_API_KEY = "[\\W\\s]+";
    private static final String REGEX_MACROS = "__[A-Z_^\\d]+__";
    public static final String REGEX_RGB = "#[a-fA-F\\d]{6}";
    public static final String REGEX_RGBA = "#[a-fA-F\\d]{8}";

    public static String replaceMacros(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            Pattern compile = Pattern.compile(REGEX_MACROS);
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                if (!map.containsKey(group) || TextUtils.isEmpty(map.get(group))) {
                    str = matcher.replaceFirst(group.replace("_", "~"));
                } else {
                    String str2 = map.get(group);
                    if (str2 != null && str2.contains("\"")) {
                        str2 = str2.replaceAll("\"", "\\\\\"");
                    }
                    String quoteReplacement = Matcher.quoteReplacement(str2);
                    if (quoteReplacement.contains("\\\"")) {
                        quoteReplacement = quoteReplacement.replaceAll("\\\"", "\\\\\"");
                    }
                    str = matcher.replaceFirst(quoteReplacement);
                }
                matcher = compile.matcher(str);
            }
        }
        return str.replace("~", "_");
    }

    private RegexUtil() {
    }

    public static boolean match(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static String replaceAllChar(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile(str2).matcher(str).replaceAll(str3);
        }
        return "";
    }
}
