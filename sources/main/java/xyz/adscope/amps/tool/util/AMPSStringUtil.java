package xyz.adscope.amps.tool.util;

import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;
import java.util.UUID;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSStringUtil {
    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(by.f10823a).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (Exception e6) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e6);
            return "";
        }
    }

    public static String createRequestId() {
        String uuid = UUID.randomUUID().toString();
        try {
            return md5(uuid);
        } catch (Exception e6) {
            e6.printStackTrace();
            return uuid;
        }
    }
}
