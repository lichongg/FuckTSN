package y;

import net.sourceforge.pinyin4j.e;
import net.sourceforge.pinyin4j.format.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static StringBuffer f56767a = new StringBuffer();

    public static String a(String str) {
        f56767a.setLength(0);
        char[] charArray = str.toCharArray();
        net.sourceforge.pinyin4j.format.b bVar = new net.sourceforge.pinyin4j.format.b();
        bVar.e(net.sourceforge.pinyin4j.format.a.f50425c);
        bVar.f(c.f50431c);
        for (char c6 : charArray) {
            if (c6 > 128) {
                try {
                    f56767a.append(e.h(c6, bVar)[0]);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } else {
                f56767a.append(c6);
            }
        }
        return f56767a.toString();
    }

    public static String b(String str) {
        f56767a.setLength(0);
        char charAt = str.charAt(0);
        String[] g6 = e.g(charAt);
        if (g6 != null) {
            f56767a.append(g6[0].charAt(0));
        } else {
            f56767a.append(charAt);
        }
        return f56767a.toString();
    }

    public static String c(String str) {
        f56767a.setLength(0);
        char[] charArray = str.toCharArray();
        net.sourceforge.pinyin4j.format.b bVar = new net.sourceforge.pinyin4j.format.b();
        bVar.e(net.sourceforge.pinyin4j.format.a.f50425c);
        bVar.f(c.f50431c);
        for (char c6 : charArray) {
            if (c6 > 128) {
                try {
                    f56767a.append(e.h(c6, bVar)[0].charAt(0));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } else {
                f56767a.append(c6);
            }
        }
        return f56767a.toString();
    }
}
