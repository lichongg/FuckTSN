package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class g {
    g() {
    }

    static String a(String str, h hVar, h hVar2) {
        String a6 = j.a(str);
        String b6 = j.b(str);
        try {
            com.hp.hpl.sparta.g s5 = f.a().b().s("//" + hVar.a() + "[text()='" + a6 + "']");
            if (s5 == null) {
                return null;
            }
            return s5.u("../" + hVar2.a() + "/text()") + b6;
        } catch (ParseException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
