package com.baidu.idl.main.facesdk.utils;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IOUtil {
    public static void close(Closeable... closeableArr) throws IOException {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }

    public static void closeQuietly(Closeable... closeableArr) {
        try {
            close(closeableArr);
        } catch (IOException unused) {
        }
    }
}
