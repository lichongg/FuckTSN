package xyz.adscope.common.v2.tool.str;

import android.text.TextUtils;
import java.util.UUID;
import java.util.zip.CRC32;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class SerialUtil {
    public static String generateAdRequestSessionID() {
        return generateUUIDMd5();
    }

    public static int generateCRCHex(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            CRC32 crc32 = new CRC32();
            crc32.update(bytes);
            return ((int) (crc32.getValue() % 100)) + 1;
        }
        return -1;
    }

    public static String generateReportEventID() {
        return generateUUIDMd5();
    }

    public static String generateStartSerialID() {
        return generateUUIDMd5();
    }

    private static String generateUUIDMd5() {
        String uuid = UUID.randomUUID().toString();
        String md5 = MD5Util.md5(uuid);
        if (TextUtils.isEmpty(md5)) {
            return uuid;
        }
        return md5;
    }
}
