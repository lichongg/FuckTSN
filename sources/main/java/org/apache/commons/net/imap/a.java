package org.apache.commons.net.imap;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.net.MalformedServerReplyException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50820a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f50821b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f50822c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f50823d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f50824e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static final String f50825f = "OK";

    /* renamed from: g, reason: collision with root package name */
    private static final String f50826g = "NO";

    /* renamed from: h, reason: collision with root package name */
    private static final String f50827h = "BAD";

    /* renamed from: i, reason: collision with root package name */
    private static final String f50828i = "* ";

    /* renamed from: j, reason: collision with root package name */
    private static final String f50829j = "+";

    /* renamed from: k, reason: collision with root package name */
    private static final String f50830k = "^\\w+ (\\S+).*";

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f50831l = Pattern.compile(f50830k);

    /* renamed from: m, reason: collision with root package name */
    private static final String f50832m = "^\\* (\\S+).*";

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f50833n = Pattern.compile(f50832m);

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f50834o = Pattern.compile("\\{(\\d+)\\}$");

    public static boolean d(int i6) {
        return i6 == 3;
    }

    public static int a(String str) throws IOException {
        return b(str, f50831l);
    }

    public static int c(String str) throws IOException {
        return b(str, f50833n);
    }

    public static boolean e(String str) {
        return str.startsWith("+");
    }

    public static boolean f(int i6) {
        return i6 == 0;
    }

    public static boolean g(String str) {
        return str.startsWith(f50828i);
    }

    public static int h(String str) {
        Matcher matcher = f50834o.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }

    private a() {
    }

    private static int b(String str, Pattern pattern) throws IOException {
        if (e(str)) {
            return 3;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group.equals("OK")) {
                return 0;
            }
            if (group.equals(f50827h)) {
                return 2;
            }
            if (group.equals(f50826g)) {
                return 1;
            }
        }
        throw new MalformedServerReplyException("Received unexpected IMAP protocol response from server: '" + str + "'.");
    }
}
