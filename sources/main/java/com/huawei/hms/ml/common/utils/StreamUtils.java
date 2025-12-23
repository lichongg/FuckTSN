package com.huawei.hms.ml.common.utils;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class StreamUtils {
    public static void closeStreams(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                    SmartLog.w("StreamUtils", "IOException closeStreams");
                } catch (RuntimeException unused2) {
                    SmartLog.w("StreamUtils", "RuntimeException closeStreams");
                }
            }
        }
    }

    private StreamUtils() {
    }
}
