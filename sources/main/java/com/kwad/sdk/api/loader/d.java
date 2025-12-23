package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d {
    private static void J(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            j.j(file);
        }
        d(new FileInputStream(str), new FileOutputStream(file, false));
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static void K(String str, String str2) {
        String str3;
        ZipFile zipFile;
        if (ac.is64Bit()) {
            str3 = "lib/arm64-v8a/";
        } else {
            str3 = "lib/armeabi-v7a/";
        }
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                        d(zipFile.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
            }
            try {
                zipFile.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    static boolean a(Context context, ClassLoader classLoader, String str, String str2) {
        String t5 = j.t(context, str2);
        h(new File(t5));
        String v5 = j.v(context, str2);
        String w5 = j.w(context, str2);
        String x5 = j.x(context, str2);
        try {
            J(str, v5);
            K(str, x5);
            if (m.b(context, classLoader, v5, w5, x5).Dn() != null) {
                return true;
            }
            return false;
        } catch (Exception e6) {
            h(new File(v5));
            h(new File(w5));
            h(new File(x5));
            h(new File(t5));
            throw e6;
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused2) {
            }
        } finally {
        }
    }

    private static void h(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
    }
}
