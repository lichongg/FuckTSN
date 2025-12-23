package xyz.adscope.common.tool.security;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.net.ftp.b;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class GzipUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    public static String compressByteToString(String str) {
        ?? r22;
        byte[] bArr = null;
        OutputStream outputStream = null;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        try {
            try {
                r22 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    r22.write(str.getBytes(b.T));
                    r22.close();
                } catch (IOException e7) {
                    e = e7;
                    outputStream = r22;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    return new String(bArr, StandardCharsets.ISO_8859_1);
                } catch (Throwable th) {
                    th = th;
                    if (r22 != null) {
                        try {
                            r22.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
            bArr = byteArrayOutputStream.toByteArray();
            return new String(bArr, StandardCharsets.ISO_8859_1);
        } catch (Throwable th2) {
            th = th2;
            r22 = bArr;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x0063
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String uncompressByteToString(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            byte[] r7 = r7.getBytes(r2)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
        L1d:
            int r4 = r7.read(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r5 = -1
            if (r4 == r5) goto L2d
            r5 = 0
            r1.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            goto L1d
        L29:
            r0 = move-exception
            goto L3a
        L2b:
            r3 = move-exception
            goto L4d
        L2d:
            java.lang.String r3 = "ISO-8859-1"
            java.lang.String r0 = r1.toString(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r7.close()     // Catch: java.io.IOException -> L36
        L36:
            r2.close()     // Catch: java.io.IOException -> L63
            goto L63
        L3a:
            r6 = r0
            r0 = r7
            r7 = r6
            goto L67
        L3e:
            r7 = move-exception
            goto L67
        L40:
            r7 = move-exception
            r3 = r7
            r7 = r0
            goto L4d
        L44:
            r7 = move-exception
            goto L49
        L46:
            r7 = move-exception
            r3 = r7
            goto L4b
        L49:
            r2 = r0
            goto L67
        L4b:
            r7 = r0
            r2 = r7
        L4d:
            java.lang.String r4 = "common_log"
            java.lang.String r5 = "解压失败,eventCode:{},errorCode:{} : 2200 : 22001"
            xyz.adscope.common.tool.LogUtil.e(r4, r5)     // Catch: java.lang.Throwable -> L29
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L5e
            r7.close()     // Catch: java.io.IOException -> L5d
            goto L5e
        L5d:
        L5e:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L63
        L63:
            r1.close()     // Catch: java.io.IOException -> L66
        L66:
            return r0
        L67:
            if (r0 == 0) goto L6e
            r0.close()     // Catch: java.io.IOException -> L6d
            goto L6e
        L6d:
        L6e:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L73
        L73:
            r1.close()     // Catch: java.io.IOException -> L76
        L76:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.tool.security.GzipUtil.uncompressByteToString(java.lang.String):java.lang.String");
    }

    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] uncompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[2048];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String compressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArray, 2);
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return "";
        }
    }

    public static String decompressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
            }
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }
}
