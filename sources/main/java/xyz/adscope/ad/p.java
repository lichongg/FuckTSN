package xyz.adscope.ad;

import java.util.Map;
import xyz.adscope.ad.publish.ASNPInitConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class p {
    static boolean a(ASNPInitConfig aSNPInitConfig, String str, boolean z5) {
        Map<String, Object> extConfig;
        if (aSNPInitConfig != null && (extConfig = aSNPInitConfig.getExtConfig()) != null) {
            Object obj = extConfig.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return z5;
    }

    static String a(ASNPInitConfig aSNPInitConfig, String str) {
        Map<String, Object> extConfig;
        if (aSNPInitConfig != null && (extConfig = aSNPInitConfig.getExtConfig()) != null) {
            Object obj = extConfig.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return "";
        }
        return "";
    }
}
