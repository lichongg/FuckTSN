package xyz.adscope.ad;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class o4 {
    public static i3 a(Context context, String str, String str2, boolean z5) {
        str2.getClass();
        switch (str2) {
            case "sensor":
                if (!z5) {
                    return null;
                }
                return new q1(context, str);
            case "opt":
                return new x4(context, str);
            case "opts":
                return new t6(context, str);
            case "optt":
                return new a7(context, str);
            case "click":
                return new r6(context, str);
            case "shake":
                if (!z5) {
                    return null;
                }
                return new p0(context, str);
            case "slide":
                return new p1(context, str);
            default:
                return null;
        }
    }
}
