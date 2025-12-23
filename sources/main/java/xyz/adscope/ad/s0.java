package xyz.adscope.ad;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class s0 {
    public static w2 a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "complain":
                return new r0();
            case "close":
                return new q0();
            case "voiceswitch":
                return new x0();
            case "downloadInfo":
                return new u0();
            default:
                if (i6 == 0) {
                    return new t0();
                }
                if (i6 == 1) {
                    return new v0();
                }
                if (i6 != 2) {
                    return null;
                }
                return new w0();
        }
    }
}
