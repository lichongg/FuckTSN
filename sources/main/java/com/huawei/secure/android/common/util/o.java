package com.huawei.secure.android.common.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35291a = "ZipUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f35292b = 104857600;

    /* renamed from: c, reason: collision with root package name */
    private static final int f35293c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f35294d = 4096;

    /* renamed from: e, reason: collision with root package name */
    private static final String f35295e = "..";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f35296f = {"..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    private static boolean i(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!d(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0184  */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> a(java.io.File r18, java.io.File r19, long r20, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.o.a(java.io.File, java.io.File, long, boolean, boolean):java.util.List");
    }

    private static boolean d(File file) {
        if (file != null) {
            return file.exists() ? file.isDirectory() : file.mkdirs();
        }
        return false;
    }

    @RequiresApi(api = 24)
    private static boolean e(String str, long j6, int i6, boolean z5) {
        ZipFile a6;
        ZipEntry nextElement;
        ZipFile zipFile = null;
        boolean z6 = false;
        try {
            try {
                try {
                    if (z5) {
                        e.r(f35291a, "not a utf8 zip file, use gbk open zip file : " + str);
                        m.a();
                        a6 = n.a(str, Charset.forName("GBK"));
                    } else {
                        a6 = new ZipFile(str);
                    }
                    ZipFile zipFile2 = a6;
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    long j7 = 0;
                    boolean z7 = true;
                    int i7 = 0;
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            z6 = z7;
                            break;
                        }
                        try {
                            nextElement = entries.nextElement();
                            j7 += nextElement.getSize();
                            i7++;
                        } catch (IllegalArgumentException e6) {
                            e.r(f35291a, "not a utf8 zip file, IllegalArgumentException : " + e6.getMessage());
                            if (Build.VERSION.SDK_INT >= 24) {
                                z6 = e(str, j6, i6, true);
                                break;
                            }
                            e.l(f35291a, "File is not a utf8 zip file and Build.VERSION_CODES < 24");
                            z7 = false;
                        }
                        if (o(nextElement.getName()) || i7 >= i6 || j7 > j6 || nextElement.getSize() == -1) {
                            break;
                        }
                    }
                    e.l(f35291a, "File name is invalid or too many files or too big");
                    zipFile2.close();
                } catch (IOException e7) {
                    e.l(f35291a, "not a valid zip file, IOException : " + e7.getMessage());
                    if (0 != 0) {
                        zipFile.close();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        zipFile.close();
                    } catch (IOException unused) {
                        e.l(f35291a, "close zipFile IOException ");
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            e.l(f35291a, "close zipFile IOException ");
        }
        return z6;
    }

    private static void k(File file) {
        if (file == null || file.delete()) {
            return;
        }
        e.l(f35291a, "delete file error");
    }

    private static void m(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        e.l(f35291a, "mkdirs error , files exists or IOException.");
    }

    private static void n(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            k(file);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                k(file);
                return;
            }
            for (File file2 : listFiles) {
                n(file2);
            }
            k(file);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x012d  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean p(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.o.p(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    private static void b(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        d.c(fileInputStream);
        d.d(bufferedOutputStream);
        d.c(zipInputStream);
        d.d(fileOutputStream);
    }

    private static void c(String str) {
        if (!TextUtils.isEmpty(str) && o(str)) {
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean f(String str, String str2, long j6, int i6) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !o(str)) {
            if (!TextUtils.isEmpty(str2) && !o(str2)) {
                if (e(str, j6, i6, false)) {
                    return true;
                }
                e.l(f35291a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            e.l(f35291a, "target directory is not valid");
            return false;
        }
        e.l(f35291a, "zip file is not valid");
        return false;
    }

    private static boolean g(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                n(it.next());
            }
            return true;
        } catch (Exception e6) {
            e.l(f35291a, "unzip fail delete file failed" + e6.getMessage());
            return false;
        }
    }

    private static File h(String str) {
        c(str);
        return new File(str);
    }

    private static File j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(str);
    }

    private static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    private static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(f35295e)) {
            return true;
        }
        for (String str2 : f35296f) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean q(String str, String str2, boolean z5) throws SecurityCommonException {
        return p(str, str2, 104857600L, 100, z5);
    }

    public static List<File> r(String str, String str2, long j6, int i6, boolean z5) throws SecurityCommonException {
        if (!f(str, str2, j6, i6)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(j(str), j(str2), j6, z5, false);
    }

    public static List<File> s(String str, String str2, boolean z5) throws SecurityCommonException {
        return r(str, str2, 104857600L, 100, z5);
    }
}
