package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w {
    public static final BigInteger aZe;
    public static final BigInteger aZf;
    public static final BigInteger aZg;
    public static final BigInteger aZh;
    public static final BigInteger aZi;
    public static final BigInteger aZj;
    public static final char aZk;
    public static final BigInteger aZl;
    public static final BigInteger aZm;
    public static final File[] aZn;
    public static final String aZo;
    private static final char aZp;

    public static boolean P(File file) {
        return file.exists();
    }

    private static FileOutputStream R(File file) {
        return a(file, false);
    }

    public static boolean T(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                N(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static FileOutputStream a(File file, boolean z5) {
        S(file);
        return new FileOutputStream(file, z5);
    }

    private static void b(File file, File file2, boolean z5) {
        ax.g(file, "Source");
        ax.g(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            c(file, file2, true);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    private static void d(File file, File file2, boolean z5) {
        a(file, file2, (FileFilter) null, true);
    }

    public static void f(File file, File file2) {
        b(file, file2, true);
    }

    public static void g(File file, File file2) {
        d(file, file2, true);
    }

    private static int gT(String str) {
        int lastIndexOf;
        if (str != null && gS(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        aZe = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        aZf = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        aZg = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        aZh = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        aZi = multiply4;
        aZj = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(kotlinx.coroutines.internal.a0.f49227p));
        aZl = multiply5;
        aZm = valueOf.multiply(multiply5);
        aZn = new File[0];
        aZo = Character.toString('.');
        aZp = File.separatorChar;
        if (Qb()) {
            aZk = '/';
        } else {
            aZk = '\\';
        }
    }

    public static boolean O(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String P(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    private static boolean Qb() {
        return aZp == '\\';
    }

    public static void Y(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else {
            if (file.isDirectory()) {
                return;
            }
            if (!T(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static boolean ab(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return T(file2);
    }

    public static boolean delete(String str) {
        return T(new File(str));
    }

    private static int gS(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int gT = gT(str);
        return gT == -1 ? "" : str.substring(gT + 1);
    }

    private static void M(File file) {
        if (file.exists()) {
            if (!aa(file)) {
                N(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void N(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e6 = null;
                    for (File file2 : listFiles) {
                        try {
                            X(file2);
                        } catch (IOException e7) {
                            e6 = e7;
                        }
                    }
                    if (e6 == null) {
                        return;
                    } else {
                        throw e6;
                    }
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static FileInputStream Q(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static void S(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                return;
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
            file.createNewFile();
            return;
        }
        throw new IOException("Could not find parent directory");
    }

    public static boolean U(File file) {
        return T(file);
    }

    public static byte[] V(File file) {
        return W(file).getBytes();
    }

    public static String W(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void X(File file) {
        if (file.isDirectory()) {
            M(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static void Z(File file) {
        T(file);
        s(file);
        if (file.exists()) {
        } else {
            throw new IOException("Create file fail");
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z5) {
        ArrayList arrayList;
        File[] listFiles;
        ax.g(file, "Source");
        ax.g(file2, "Destination");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(listFiles.length);
                        for (File file3 : listFiles) {
                            arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                        }
                    }
                    a(file, file2, null, z5, arrayList);
                    return;
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    private static boolean aa(File file) {
        ax.checkNotNull(file);
        if (Qb()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        if (file.getCanonicalFile().equals(file.getAbsoluteFile())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void c(File file, File file2, boolean z5) {
        Throwable th;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3;
        FileChannel channel;
        long j6;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel4 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            fileChannel = null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileChannel2 = fileInputStream.getChannel();
                try {
                    channel = fileOutputStream.getChannel();
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel3 = fileOutputStream;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel2 = null;
                fileChannel3 = fileOutputStream;
            }
            try {
                long size = fileChannel2.size();
                for (long j7 = 0; j7 < size; j7 += channel.transferFrom(fileChannel2, j7, j6)) {
                    j6 = size - j7;
                    if (j6 > 31457280) {
                        j6 = 31457280;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(channel);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                if (file.length() == file2.length()) {
                    if (z5) {
                        file2.setLastModified(file.lastModified());
                    }
                } else {
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                }
            } catch (Throwable th5) {
                th = th5;
                fileChannel4 = channel;
                fileChannel3 = fileOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel4);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel3);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileChannel2 = fileChannel;
            fileChannel3 = fileChannel;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel3);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void deleteContents(@NonNull File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    private static boolean e(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
            return true;
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
            return false;
        }
    }

    public static BufferedInputStream gP(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new BufferedInputStream(fileInputStream);
    }

    public static boolean gQ(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static boolean gR(String str) {
        if (!TextUtils.isEmpty(str) && O(new File(str))) {
            return true;
        }
        return false;
    }

    private static void s(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(R(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = R(file);
            try {
                com.kwad.sdk.crash.utils.h.e(inputStream, fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z5, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            a(file3, file4, fileFilter, z5, list);
                        } else {
                            c(file3, file4, z5);
                        }
                    }
                }
                if (z5) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void a(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                b(inputStream, file);
                return;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
        throw new IllegalArgumentException("Asset path is empty.");
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = Q(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String a6 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return a6;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void a(File file, String str, Charset charset, boolean z5) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }
}
