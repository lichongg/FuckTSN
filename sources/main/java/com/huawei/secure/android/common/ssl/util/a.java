package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35212a = "BksUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35213b = "com.huawei.hwid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35214c = "com.huawei.hwid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35215d = "com.huawei.hms";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35216e = "com.huawei.hwid.tv";

    /* renamed from: g, reason: collision with root package name */
    private static final String f35218g = "files/hmsrootcas.bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f35219h = "4.0.2.300";

    /* renamed from: i, reason: collision with root package name */
    private static final String f35220i = "aegis";

    /* renamed from: j, reason: collision with root package name */
    private static final String f35221j = "hmsrootcas.bks";

    /* renamed from: k, reason: collision with root package name */
    private static final long f35222k = 604800000;

    /* renamed from: l, reason: collision with root package name */
    private static final String f35223l = "last_update_time";

    /* renamed from: n, reason: collision with root package name */
    private static final String f35225n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* renamed from: q, reason: collision with root package name */
    private static final String f35228q = "";

    /* renamed from: r, reason: collision with root package name */
    private static final String f35229r = "bks_hash";

    /* renamed from: f, reason: collision with root package name */
    private static final Uri f35217f = Uri.parse("content://com.huawei.hwid");

    /* renamed from: m, reason: collision with root package name */
    private static final String f35224m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* renamed from: o, reason: collision with root package name */
    private static final String f35226o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f35227p = {f35224m, f35226o};

    private static byte[] f(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e6) {
            e6.getMessage();
        } catch (Exception e7) {
            e7.getMessage();
        }
        return new byte[0];
    }

    private static String b(Context context) {
        Context createDeviceProtectedStorageContext;
        if (Build.VERSION.SDK_INT < 24) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + f35220i;
        }
        StringBuilder sb = new StringBuilder();
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        sb.append(createDeviceProtectedStorageContext.getFilesDir());
        sb.append(File.separator);
        sb.append(f35220i);
        return sb.toString();
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void d(InputStream inputStream, Context context) {
        if (inputStream == null || context == null) {
            return;
        }
        String b6 = b(context);
        if (!new File(b6).exists()) {
            a(b6);
        }
        File file = new File(b6, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                h.e(f35212a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            g.h(fileOutputStream2);
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    h.d(f35212a, " IOException");
                    g.h(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    g.h(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String g(Context context) {
        return b(context) + File.separator + "hmsrootcas.bks";
    }

    private static String h(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            h.d(f35212a, "inputstraem exception");
            return "";
        }
    }

    private static String k(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return c(MessageDigest.getInstance("SHA-256").digest(bArr));
            } catch (NoSuchAlgorithmException e6) {
                e6.getMessage();
            }
        }
        return "";
    }

    private static boolean l(Context context) {
        return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream n(Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        String c6;
        String h6;
        synchronized (a.class) {
            try {
                h.e(f35212a, "get bks from tss begin");
                if (context != null) {
                    c.b(context);
                }
                Context a6 = c.a();
                InputStream inputStream4 = null;
                if (a6 == null) {
                    h.d(f35212a, "context is null");
                    return null;
                }
                if (!j(i.a("com.huawei.hwid")) && !j(i.a(f35215d))) {
                    h.d(f35212a, "hms version code is too low : " + i.a("com.huawei.hwid"));
                    return null;
                }
                if (!m(a6, "com.huawei.hwid") && !i(a6, f35215d)) {
                    h.d(f35212a, "hms sign error");
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream2 = a6.getContentResolver().openInputStream(Uri.withAppendedPath(f35217f, f35218g));
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read <= -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            inputStream3 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                c6 = j.c(f35229r, "", a6);
                                h6 = h(byteArrayOutputStream.toByteArray());
                            } catch (Exception e6) {
                                e = e6;
                                inputStream4 = inputStream3;
                                h.d(f35212a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                                g.g(inputStream2);
                                g.h(byteArrayOutputStream);
                                g.g(inputStream4);
                                return o(a6);
                            } catch (Throwable th) {
                                th = th;
                                g.g(inputStream2);
                                g.h(byteArrayOutputStream);
                                g.g(inputStream3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            InputStream inputStream5 = inputStream2;
                            inputStream = inputStream4;
                            inputStream4 = inputStream5;
                            inputStream3 = inputStream;
                            inputStream2 = inputStream4;
                            g.g(inputStream2);
                            g.h(byteArrayOutputStream);
                            g.g(inputStream3);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                } catch (Exception e8) {
                    e = e8;
                    inputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    inputStream3 = inputStream;
                    inputStream2 = inputStream4;
                    g.g(inputStream2);
                    g.h(byteArrayOutputStream);
                    g.g(inputStream3);
                    throw th;
                }
                if (l(a6) && c6.equals(h6)) {
                    h.e(f35212a, "bks not update");
                    g.g(inputStream2);
                    g.h(byteArrayOutputStream);
                    g.g(inputStream3);
                    return o(a6);
                }
                h.e(f35212a, "update bks and sp");
                d(inputStream3, a6);
                j.i(f35229r, h6, a6);
                g.g(inputStream2);
                g.h(byteArrayOutputStream);
                g.g(inputStream3);
                return o(a6);
            } finally {
            }
        }
    }

    private a() {
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            h.g(f35212a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            h.b(f35212a, "create directory  success");
            return 0;
        }
        h.d(f35212a, "create directory  failed");
        return -1;
    }

    private static boolean e(int i6) {
        if (i6 >= 40002300) {
            return true;
        }
        return false;
    }

    private static boolean i(Context context, String str) {
        return f35226o.equalsIgnoreCase(k(f(context, str)));
    }

    private static boolean j(String str) {
        int parseInt;
        int i6;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        h.e(f35212a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f35219h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i7 = 0; i7 < max; i7++) {
            if (i7 < length) {
                try {
                    parseInt = Integer.parseInt(split[i7]);
                } catch (Exception e6) {
                    h.d(f35212a, " exception : " + e6.getMessage());
                    if (i7 < length2) {
                        return false;
                    }
                    return true;
                }
            } else {
                parseInt = 0;
            }
            if (i7 < length2) {
                i6 = Integer.parseInt(split2[i7]);
            } else {
                i6 = 0;
            }
            if (parseInt < i6) {
                return false;
            }
            if (parseInt > i6) {
                return true;
            }
        }
        return true;
    }

    private static boolean m(Context context, String str) {
        byte[] f6 = f(context, str);
        for (String str2 : f35227p) {
            if (str2.equalsIgnoreCase(k(f6))) {
                return true;
            }
        }
        return false;
    }

    public static InputStream o(Context context) {
        if (l(context)) {
            h.e(f35212a, "getFilesBksIS ");
            try {
                return new FileInputStream(g(context));
            } catch (FileNotFoundException unused) {
                h.d(f35212a, "FileNotFoundExceptio: ");
                return null;
            }
        }
        return null;
    }
}
