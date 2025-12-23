package xyz.adscope.common.v2.tool.roll;

import android.text.TextUtils;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class RandomProbability {
    public static boolean roll(int i6) {
        if (i6 >= ((int) (Math.random() * 100.0d)) + 1) {
            return true;
        }
        return false;
    }

    public static boolean rollByCRCString(int i6, String str) {
        if (TextUtils.isEmpty(str) || i6 < SerialUtil.generateCRCHex(str)) {
            return false;
        }
        return true;
    }
}
