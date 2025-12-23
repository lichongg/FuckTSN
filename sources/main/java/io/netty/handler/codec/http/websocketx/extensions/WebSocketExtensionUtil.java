package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WebSocketExtensionUtil {
    private static final String EXTENSION_SEPARATOR = ",";
    private static final Pattern PARAMETER = Pattern.compile("^([^=]+)(=[\\\"]?([^\\\"]+)[\\\"]?)?$");
    private static final char PARAMETER_EQUAL = '=';
    private static final String PARAMETER_SEPARATOR = ";";

    static String appendExtension(String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str != null ? str.length() : str2.length() + 1);
        if (str != null && !str.trim().isEmpty()) {
            sb.append(str);
            sb.append(EXTENSION_SEPARATOR);
        }
        sb.append(str2);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(PARAMETER_SEPARATOR);
            sb.append(entry.getKey());
            if (entry.getValue() != null) {
                sb.append(PARAMETER_EQUAL);
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static List<WebSocketExtensionData> extractExtensions(String str) {
        Map map;
        String[] split = str.split(EXTENSION_SEPARATOR);
        if (split.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            String[] split2 = str2.split(PARAMETER_SEPARATOR);
            String trim = split2[0].trim();
            if (split2.length > 1) {
                map = new HashMap(split2.length - 1);
                for (int i6 = 1; i6 < split2.length; i6++) {
                    Matcher matcher = PARAMETER.matcher(split2[i6].trim());
                    if (matcher.matches() && matcher.group(1) != null) {
                        map.put(matcher.group(1), matcher.group(3));
                    }
                }
            } else {
                map = Collections.EMPTY_MAP;
            }
            arrayList.add(new WebSocketExtensionData(trim, map));
        }
        return arrayList;
    }

    static boolean isWebsocketUpgrade(HttpHeaders httpHeaders) {
        return httpHeaders.containsValue(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE, true) && httpHeaders.contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true);
    }

    private WebSocketExtensionUtil() {
    }
}
