package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private x4.b f50411a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: net.sourceforge.pinyin4j.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0978a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c {

        /* renamed from: b, reason: collision with root package name */
        static final String f50413b = "(";

        /* renamed from: c, reason: collision with root package name */
        static final String f50414c = ")";

        /* renamed from: d, reason: collision with root package name */
        static final String f50415d = ",";

        c() {
        }
    }

    /* synthetic */ a(C0978a c0978a) {
        this();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final a f50412a = new a(null);

        private b() {
        }
    }

    private a() {
        this.f50411a = null;
        f();
    }

    static a d() {
        return b.f50412a;
    }

    private void f() {
        try {
            i(new x4.b());
            e().d(i.a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
            e().e(i.a("/pinyindb/multi_pinyin.txt"));
            e().f();
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    private boolean g(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    private void i(x4.b bVar) {
        this.f50411a = bVar;
    }

    x4.b e() {
        return this.f50411a;
    }

    String[] h(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).split(",");
    }

    private String a(char c6) {
        String str;
        x4.b a6 = e().a(Integer.toHexString(c6).toUpperCase());
        if (a6 != null) {
            str = a6.c();
        } else {
            str = null;
        }
        if (!g(str)) {
            return null;
        }
        return str;
    }

    String[] b(char c6) {
        return h(a(c6));
    }

    x4.b c(char c6) {
        return e().a(Integer.toHexString(c6).toUpperCase());
    }
}
