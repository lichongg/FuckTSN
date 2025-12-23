package io.netty.handler.ssl;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SignatureAlgorithmConverter {
    private static final Pattern PATTERN = Pattern.compile("(?:(^[a-zA-Z].+)With(.+)Encryption$)|(?:(^[a-zA-Z].+)(?:_with_|-with-|_pkcs1_|_pss_rsae_)(.+$))|(?:(^[a-zA-Z].+)_(.+$))");

    static String toJavaName(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                StringBuilder sb = new StringBuilder();
                Locale locale = Locale.ROOT;
                sb.append(group.toUpperCase(locale));
                sb.append("with");
                sb.append(matcher.group(2).toUpperCase(locale));
                return sb.toString();
            }
            if (matcher.group(3) != null) {
                StringBuilder sb2 = new StringBuilder();
                String group2 = matcher.group(4);
                Locale locale2 = Locale.ROOT;
                sb2.append(group2.toUpperCase(locale2));
                sb2.append("with");
                sb2.append(matcher.group(3).toUpperCase(locale2));
                return sb2.toString();
            }
            if (matcher.group(5) != null) {
                StringBuilder sb3 = new StringBuilder();
                String group3 = matcher.group(6);
                Locale locale3 = Locale.ROOT;
                sb3.append(group3.toUpperCase(locale3));
                sb3.append("with");
                sb3.append(matcher.group(5).toUpperCase(locale3));
                return sb3.toString();
            }
        }
        return null;
    }

    private SignatureAlgorithmConverter() {
    }
}
