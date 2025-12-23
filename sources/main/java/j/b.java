package j;

import com.tencent.connect.common.Constants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static boolean a(String str, String str2) {
        a aVar = new a("dylanandroid2dev@163.com", "dylanandroid2dev");
        aVar.v("smtp.163.com");
        aVar.y(Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
        aVar.t(true);
        String[] E = cn.bluemobi.dylan.uncaughtexception.a.E();
        if (E != null && E.length > 0) {
            aVar.B(E);
            aVar.u("dylanandroid2dev@163.com");
            aVar.A("【" + str + "】异常崩溃");
            aVar.q(str2.toString());
            try {
                if (aVar.p()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
