package com.bytedance.sdk.openadsdk.core.rn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl {
    public static byte[] j(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr3 = new byte[4096];
            while (true) {
                int read = byteArrayInputStream.read(bArr3, 0, 4096);
                if (read <= 0) {
                    gZIPOutputStream.close();
                    byteArrayInputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return bArr2;
                }
                gZIPOutputStream.write(bArr3, 0, read);
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return bArr2;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static String xt(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.bytedance.sdk.component.utils.vl.r("gzip compress error.", th.getMessage());
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        if (gZIPInputStream == null) {
                            return null;
                        }
                        gZIPInputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        com.bytedance.sdk.component.utils.vl.j(th3);
                        return null;
                    }
                } catch (Throwable th4) {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th5) {
                        com.bytedance.sdk.component.utils.vl.j(th5);
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            gZIPInputStream = null;
        }
    }
}
