package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f50419a = {"_I", "_II", "_III", "_IV", "_V"};

    c() {
    }

    static String a(String str) {
        String a6 = j.a(str);
        String b6 = j.b(str);
        try {
            com.hp.hpl.sparta.g s5 = b.a().b().s("//" + h.f50438b.a() + "[text()='" + a6 + "']");
            if (s5 == null) {
                return null;
            }
            return s5.u("../" + h.f50443g.a() + f50419a[Integer.parseInt(b6) - 1] + "/text()");
        } catch (ParseException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
