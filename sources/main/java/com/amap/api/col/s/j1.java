package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.s.i1;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f8179a = {"arm64-v8a", "x86_64"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f8180b = {"arm", DeviceUtils.f54642a};

    /* renamed from: c, reason: collision with root package name */
    static String f8181c;

    private static byte[] E(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream2.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter);
                    }
                    String obj = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        printWriter.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return obj;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        th.printStackTrace();
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
            }
        } catch (Throwable th8) {
            th = th8;
            stringWriter = null;
            printWriter = null;
        }
    }

    public static void j(ByteArrayOutputStream byteArrayOutputStream, byte b6, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b6});
            int i6 = b6 & 255;
            if (i6 < 255 && i6 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i6 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e6) {
            d2.e(e6, "ut", "wFie");
        }
    }

    public static boolean l(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                d2.e(th, "ut", "cpm");
            }
        }
        return true;
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 80; i6++) {
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        }
        f8181c = sb.toString();
    }

    public static String D(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static i1 a() throws bv {
        return new i1.a("collection", "1.0", "AMap_collection_1.0").c(new String[]{"com.amap.api.collection"}).d();
    }

    public static String b(long j6) {
        return c(j6, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String c(long j6, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j6));
        } catch (Throwable th) {
            d2.e(th, "ut", "ctt");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r8) {
        /*
            java.lang.Class<android.os.Build> r0 = android.os.Build.class
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "ut"
            r3 = 1
            r4 = 28
            if (r1 >= r4) goto L2f
            android.content.pm.ApplicationInfo r1 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L29
            java.lang.Class<android.content.pm.ApplicationInfo> r5 = android.content.pm.ApplicationInfo.class
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L29
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = "primaryCpuAbi"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch: java.lang.Throwable -> L29
            r5.setAccessible(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r1 = r5.get(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r5 = "gct"
            com.amap.api.col.s.d2.e(r1, r2, r5)
        L2f:
            java.lang.String r1 = ""
        L31:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r4) goto L9c
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L4b
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch: java.lang.Throwable -> L4b
            r6 = 0
            if (r4 == 0) goto L4d
            int r7 = r4.length     // Catch: java.lang.Throwable -> L4b
            if (r7 <= 0) goto L4d
            r1 = r4[r6]     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r8 = move-exception
            goto L97
        L4d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L4b
            if (r4 != 0) goto L9c
            java.lang.String[] r4 = com.amap.api.col.s.j1.f8179a     // Catch: java.lang.Throwable -> L4b
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: java.lang.Throwable -> L4b
            boolean r4 = r4.contains(r1)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L9c
            android.content.pm.ApplicationInfo r8 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r8 = r8.nativeLibraryDir     // Catch: java.lang.Throwable -> L4b
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L4b
            if (r4 != 0) goto L9c
            java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L4b
            int r4 = r8.lastIndexOf(r4)     // Catch: java.lang.Throwable -> L4b
            int r4 = r4 + r3
            java.lang.String r8 = r8.substring(r4)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r3 = com.amap.api.col.s.j1.f8180b     // Catch: java.lang.Throwable -> L4b
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch: java.lang.Throwable -> L4b
            boolean r8 = r3.contains(r8)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            java.lang.String r8 = "SUPPORTED_32_BIT_ABIS"
            java.lang.reflect.Field r8 = r0.getDeclaredField(r8)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            int r0 = r8.length     // Catch: java.lang.Throwable -> L4b
            if (r0 <= 0) goto L9c
            r8 = r8[r6]     // Catch: java.lang.Throwable -> L4b
            r1 = r8
            goto L9c
        L97:
            java.lang.String r0 = "gct_p"
            com.amap.api.col.s.d2.e(r8, r2, r0)
        L9c:
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto La4
            java.lang.String r1 = android.os.Build.CPU_ABI
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.j1.d(android.content.Context):java.lang.String");
    }

    public static String g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static Calendar h(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
            return calendar;
        } catch (ParseException e6) {
            d2.e(e6, "ut", "ctt");
            return null;
        }
    }

    public static void i(Context context, String str, String str2, JSONObject jSONObject) {
        String string;
        String h6 = x0.h(context);
        String a6 = g1.a(h6);
        String a7 = x0.a(context);
        try {
            String string2 = jSONObject.has("info") ? jSONObject.getString("info") : "";
            if ("INVALID_USER_SCODE".equals(string2)) {
                String string3 = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
                string = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
                if (a6.equals(string3) || a6.equals(string)) {
                    t("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si");
                }
            } else if ("INVALID_USER_KEY".equals(string2)) {
                string = jSONObject.has("key") ? jSONObject.getString("key") : "";
                if (string.length() > 0 && !a7.equals(string)) {
                    t("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                }
            }
        } catch (Throwable unused) {
        }
        C("SHA1Package:".concat(String.valueOf(h6)));
        C("key:".concat(String.valueOf(a7)));
        C("csid:".concat(String.valueOf(str)));
        C("gsid:".concat(String.valueOf(str2)));
        C("json:" + jSONObject.toString());
    }

    public static boolean m(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] n(int i6) {
        return new byte[]{(byte) (i6 / 256), (byte) (i6 % 256)};
    }

    public static i1 p() throws bv {
        return new i1.a("co", "1.0.0", "AMap_co_1.0.0").c(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).d();
    }

    public static String q(String str) {
        if (str == null) {
            return null;
        }
        String i6 = d1.i(o(str));
        try {
            return ((char) ((i6.length() % 26) + 65)) + i6;
        } catch (Throwable th) {
            d2.e(th, "ut", "tsfb64");
            return "";
        }
    }

    public static String r(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return z(sb.toString());
    }

    public static byte[] u() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i6 = 0; i6 < split.length; i6++) {
                bArr[i6] = Byte.parseByte(split[i6]);
            }
            String[] split2 = new StringBuffer(new String(d1.g(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i7 = 0; i7 < split2.length; i7++) {
                bArr2[i7] = Byte.parseByte(split2[i7]);
            }
            return bArr2;
        } catch (Throwable th) {
            d2.e(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        if (r4 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] v(byte[] r8) {
        /*
            java.lang.String r0 = "zp2"
            java.lang.String r1 = "zp1"
            java.lang.String r2 = "ut"
            r3 = 0
            if (r8 == 0) goto L71
            int r4 = r8.length
            if (r4 != 0) goto Le
            goto L71
        Le:
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L45
            r4.<init>()     // Catch: java.lang.Throwable -> L45
            java.util.zip.ZipOutputStream r5 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L42
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L42
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L40
            java.lang.String r7 = "log"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L40
            r5.putNextEntry(r6)     // Catch: java.lang.Throwable -> L40
            r5.write(r8)     // Catch: java.lang.Throwable -> L40
            r5.closeEntry()     // Catch: java.lang.Throwable -> L40
            r5.finish()     // Catch: java.lang.Throwable -> L40
            byte[] r3 = r4.toByteArray()     // Catch: java.lang.Throwable -> L40
            r5.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r8 = move-exception
            com.amap.api.col.s.d2.e(r8, r2, r1)
        L37:
            r4.close()     // Catch: java.lang.Throwable -> L3b
            goto L5a
        L3b:
            r8 = move-exception
            com.amap.api.col.s.d2.e(r8, r2, r0)
            goto L5a
        L40:
            r8 = move-exception
            goto L48
        L42:
            r8 = move-exception
            r5 = r3
            goto L48
        L45:
            r8 = move-exception
            r4 = r3
            r5 = r4
        L48:
            java.lang.String r6 = "zp"
            com.amap.api.col.s.d2.e(r8, r2, r6)     // Catch: java.lang.Throwable -> L5b
            if (r5 == 0) goto L57
            r5.close()     // Catch: java.lang.Throwable -> L53
            goto L57
        L53:
            r8 = move-exception
            com.amap.api.col.s.d2.e(r8, r2, r1)
        L57:
            if (r4 == 0) goto L5a
            goto L37
        L5a:
            return r3
        L5b:
            r8 = move-exception
            if (r5 == 0) goto L66
            r5.close()     // Catch: java.lang.Throwable -> L62
            goto L66
        L62:
            r3 = move-exception
            com.amap.api.col.s.d2.e(r3, r2, r1)
        L66:
            if (r4 == 0) goto L70
            r4.close()     // Catch: java.lang.Throwable -> L6c
            goto L70
        L6c:
            r1 = move-exception
            com.amap.api.col.s.d2.e(r1, r2, r0)
        L70:
            throw r8
        L71:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.j1.v(byte[]):byte[]");
    }

    static PublicKey w() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(d1.g("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
        } catch (Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(t("IWC41MDk"));
            KeyFactory keyFactory = KeyFactory.getInstance(t("EUlNB"));
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            if (generateCertificate != null && keyFactory != null) {
                PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                try {
                    byteArrayInputStream.close();
                    return generatePublic;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return generatePublic;
                }
            }
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return null;
        } catch (Throwable unused2) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            return null;
        }
    }

    private static String z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
        } catch (Throwable th) {
            d2.e(th, "ut", "sPa");
            return str;
        }
    }

    static String A(byte[] bArr) {
        try {
            return D(bArr);
        } catch (Throwable th) {
            d2.e(th, "ut", "h2s");
            return null;
        }
    }

    static String B(byte[] bArr) {
        try {
            return D(bArr);
        } catch (Throwable th) {
            d2.e(th, "ut", "csb2h");
            return null;
        }
    }

    private static void C(String str) {
        int i6;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            str.substring(0, 78);
            str = str.substring(78);
        }
        for (i6 = 0; i6 < 78 - str.length(); i6++) {
        }
    }

    public static String f(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            boolean z5 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z5) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(entry.getValue());
                    z5 = false;
                } else {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            d2.e(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e6) {
                d2.e(e6, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        j(byteArrayOutputStream, (byte) length, o(str));
    }

    public static byte[] o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static byte[] s(byte[] bArr) {
        try {
            return E(bArr);
        } catch (Throwable th) {
            d2.e(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String t(String str) {
        if (str.length() < 2) {
            return "";
        }
        return d1.a(str.substring(1));
    }

    public static byte[] x(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) Integer.parseInt(str.substring(i7, i7 + 2), 16);
        }
        return bArr;
    }

    public static byte[] y(byte[] bArr) {
        try {
            return E(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }
}
