package cn.jiguang.bz;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2755a = j("j-c-o-r-e-").getBytes(StandardCharsets.UTF_8);

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ReentrantLock> f2756b = new ConcurrentHashMap<>();

    public static class a implements FileFilter {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2757a = new a(true, false);

        /* renamed from: b, reason: collision with root package name */
        public static final a f2758b = new a(false, true);

        /* renamed from: c, reason: collision with root package name */
        private final boolean f2759c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f2760d;

        /* renamed from: e, reason: collision with root package name */
        private final String f2761e;

        /* renamed from: f, reason: collision with root package name */
        private final int f2762f;

        public a(boolean z5, boolean z6) {
            this.f2759c = z5;
            this.f2760d = z6;
            this.f2761e = null;
            this.f2762f = 0;
        }

        public a(boolean z5, boolean z6, String str, int i6) {
            this.f2761e = str;
            this.f2762f = i6;
            this.f2759c = z5;
            this.f2760d = z6;
        }

        public static a a(String str) {
            return new a(false, true, str, 3);
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (this.f2759c && !file.isFile()) {
                return false;
            }
            if (this.f2760d && !file.isDirectory()) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2761e)) {
                return true;
            }
            int i6 = this.f2762f;
            if (i6 == 1) {
                return file.getName().startsWith(this.f2761e);
            }
            if (i6 == 2) {
                return file.getName().endsWith(this.f2761e);
            }
            if (i6 == 3) {
                return file.getName().equals(this.f2761e);
            }
            if (i6 != 4) {
                return false;
            }
            return file.getName().contains(this.f2761e);
        }
    }

    public static File a(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0L)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static JSONArray b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.bb.f.c("FileUtils", "file_name is null , give up read ");
                return null;
            }
            String e6 = e(str);
            if (w.a(e6)) {
                return null;
            }
            return new JSONArray(e6.trim());
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("FileUtils", "can't build " + str + " into JSONArray, give up read :" + th);
            return null;
        }
    }

    public static File c(String str) {
        File filesDir = d.a().getFilesDir();
        if (filesDir != null) {
            return new File(filesDir, str);
        }
        cn.jiguang.bb.f.i("FileUtils", "can't get file :" + str);
        return null;
    }

    public static void d(String str) {
        b(c(str));
    }

    public static String e(String str) {
        return c(c(str));
    }

    public static JSONObject a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.bb.f.c("FileUtils", "file_name is null , give up read ");
                return null;
            }
            String e6 = e(str);
            if (w.a(e6)) {
                return null;
            }
            return new JSONObject(e6.trim());
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("FileUtils", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static boolean b(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            cn.jiguang.bv.e.b(file.getAbsolutePath());
        } catch (Throwable unused) {
        }
        if (file.isDirectory() && !d(file) && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!b(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.io.File r15) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.j.c(java.io.File):java.lang.String");
    }

    private static boolean d(File file) {
        Path path;
        boolean isSymbolicLink;
        if (file != null && file.exists()) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    return !file.getCanonicalPath().equals(file.getAbsolutePath());
                }
                path = file.toPath();
                isSymbolicLink = Files.isSymbolicLink(path);
                return isSymbolicLink;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean e(File file) {
        return file == null || file.isDirectory() || !file.exists();
    }

    private static ReentrantLock h(String str) {
        ReentrantLock putIfAbsent;
        ConcurrentHashMap<String, ReentrantLock> concurrentHashMap = f2756b;
        ReentrantLock reentrantLock = concurrentHashMap.get(str);
        return (reentrantLock != null || (putIfAbsent = concurrentHashMap.putIfAbsent(str, (reentrantLock = new ReentrantLock()))) == null) ? reentrantLock : putIfAbsent;
    }

    private static void i(String str) {
        ReentrantLock reentrantLock = f2756b.get(str);
        if (reentrantLock != null) {
            if (reentrantLock.isHeldByCurrentThread()) {
                while (reentrantLock.getHoldCount() > 0) {
                    reentrantLock.unlock();
                }
            }
            if (reentrantLock.hasQueuedThreads() || reentrantLock.getHoldCount() != 0) {
                return;
            }
            f2756b.remove(str, reentrantLock);
        }
    }

    private static void a(BufferedOutputStream bufferedOutputStream, String str) {
        if (str.length() <= 65536) {
            bufferedOutputStream.write(j(str).getBytes(StandardCharsets.UTF_8));
        } else {
            int i6 = 0;
            while (i6 < str.length()) {
                int i7 = i6 + 65536;
                bufferedOutputStream.write(j(str.substring(i6, Math.min(str.length(), i7))).getBytes(StandardCharsets.UTF_8));
                i6 = i7;
            }
        }
        bufferedOutputStream.flush();
    }

    public static boolean b(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return b(file);
        }
        a(file);
        boolean z5 = true;
        try {
            if (cn.jiguang.bv.e.a(file, str)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        File file2 = null;
        try {
            try {
                if (!h(file.getAbsolutePath()).tryLock(10L, TimeUnit.SECONDS)) {
                    cn.jiguang.bb.f.i("FileUtils", "save Failed to acquire file lock within timeout");
                    i(file.getAbsolutePath());
                    return false;
                }
                File file3 = new File(file.getParent(), file.getName() + ".tmp");
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 8192);
                    try {
                        bufferedOutputStream.write(f2755a);
                        a(bufferedOutputStream, str);
                        if (!file3.renameTo(file)) {
                            if (!a(file3, file)) {
                                z5 = false;
                            }
                        }
                        bufferedOutputStream.close();
                        i(file.getAbsolutePath());
                        if (file3.exists()) {
                            file3.delete();
                        }
                        return z5;
                    } catch (Throwable th) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (InterruptedException unused2) {
                    file2 = file3;
                    cn.jiguang.bb.f.i("FileUtils", "save Thread interrupted while waiting for file lock");
                    i(file.getAbsolutePath());
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = file3;
                    cn.jiguang.bb.f.i("FileUtils", "save fail: " + th.getMessage());
                    return false;
                }
            } catch (InterruptedException unused3) {
            } catch (Throwable th4) {
                th = th4;
            }
        } finally {
            i(file.getAbsolutePath());
            if (0 != 0 && file2.exists()) {
                file2.delete();
            }
        }
    }

    public static void c(String str, String str2) {
        String str3;
        try {
            File c6 = c(str);
            if (c6 != null && c6.exists()) {
                File c7 = c(str2);
                if (c7 == null) {
                    str3 = "Cannot create temp file: " + str2;
                    cn.jiguang.bb.f.i("FileUtils", str3);
                }
                a(c7);
                try {
                    FileInputStream fileInputStream = new FileInputStream(c6);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(c7);
                        try {
                            byte[] bArr = new byte[Math.min(65536, (int) c6.length())];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    fileInputStream.close();
                                    return;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    cn.jiguang.bb.f.i("FileUtils", "Copy file failed: " + e6.getMessage());
                    if (c7.exists()) {
                        c7.delete();
                        return;
                    }
                    return;
                }
            }
            str3 = "Source file does not exist: " + str;
            cn.jiguang.bb.f.i("FileUtils", str3);
        } catch (Throwable th3) {
            cn.jiguang.bb.f.i("FileUtils", "copyFileToTemp error: " + th3.getMessage());
        }
    }

    private static boolean d(File file, String str) {
        File file2 = new File(file.getParent(), file.getName() + ".tmp");
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    bufferedOutputStream.write(f2755a);
                    if (file.exists() && file.length() > 0) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[Math.min(65536, (int) file.length())];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                Charset charset = StandardCharsets.UTF_8;
                                bufferedOutputStream.write(j(new String(bArr, 0, read, charset)).getBytes(charset));
                            }
                            fileInputStream.close();
                        } finally {
                        }
                    }
                    bufferedOutputStream.write(j(str).getBytes(StandardCharsets.UTF_8));
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    boolean z5 = file2.renameTo(file) || a(file2, file);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return z5;
                } catch (Throwable th) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("FileUtils", "Rebuild file failed: " + e6.getMessage());
                if (file2.exists()) {
                    file2.delete();
                }
                return false;
            }
        } catch (Throwable th3) {
            if (file2.exists()) {
                file2.delete();
            }
            throw th3;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0 || !file.canRead()) {
            return false;
        }
        return true;
    }

    public static String g(String str) {
        if (!f(str)) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8192];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String c6 = w.c(byteArrayOutputStream.toByteArray());
                        fileInputStream.close();
                        return c6;
                    }
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i6 = 0; i6 < charArray.length; i6++) {
            charArray[i6] = (char) (charArray[i6] ^ 2000);
        }
        return new String(charArray);
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(String str, String str2) {
        return c(c(str), str2);
    }

    public static boolean c(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a(file);
        try {
            if (cn.jiguang.bv.e.a(file.getAbsolutePath(), str)) {
                cn.jiguang.bb.f.c("FileUtils", "append success using native method: " + file.getAbsolutePath());
                return true;
            }
        } catch (Throwable unused) {
        }
        String absolutePath = file.getAbsolutePath();
        try {
            if (!h(absolutePath).tryLock(10L, TimeUnit.SECONDS)) {
                cn.jiguang.bb.f.i("FileUtils", "append Failed to acquire file lock within timeout");
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                if (a(randomAccessFile)) {
                    boolean a6 = a(randomAccessFile, str);
                    randomAccessFile.close();
                    return a6;
                }
                boolean d6 = d(file, str);
                randomAccessFile.close();
                return d6;
            } finally {
            }
        } catch (Throwable th) {
            try {
                cn.jiguang.bb.f.i("FileUtils", "append fail: " + th.getMessage());
                return false;
            } finally {
                i(absolutePath);
            }
        }
    }

    private static boolean a(File file, File file2) {
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    if (channel2 != null) {
                        channel2.close();
                    }
                    channel.close();
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (IOException e6) {
            cn.jiguang.bb.f.i("FileUtils", "Copy failed: " + e6.toString());
            return false;
        }
    }

    public static boolean a(File file, String str) {
        String str2;
        if (file == null || file.isDirectory()) {
            str2 = "File should not be null or a directory";
        } else if (TextUtils.isEmpty(str)) {
            str2 = "Append data should not be empty";
        } else {
            try {
                a(file);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    return true;
                } finally {
                }
            } catch (IOException e6) {
                str2 = "Failed to append to file: " + file.getAbsolutePath() + ". Exception: " + e6.getMessage();
            }
        }
        cn.jiguang.bb.f.i("FileUtils", str2);
        return false;
    }

    public static boolean a(File file, byte[] bArr) {
        if (file != null && bArr != null) {
            File file2 = new File(file.getParent(), file.getName() + ".tmp");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    boolean renameTo = file2.renameTo(file);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return renameTo;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception unused) {
                if (file2.exists()) {
                    file2.delete();
                }
            } catch (Throwable th3) {
                if (file2.exists()) {
                    file2.delete();
                }
                throw th3;
            }
        }
        return false;
    }

    private static boolean a(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length();
        byte[] bArr = f2755a;
        if (length < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        randomAccessFile.seek(0L);
        randomAccessFile.readFully(bArr2);
        return Arrays.equals(bArr2, bArr);
    }

    private static boolean a(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.seek(randomAccessFile.length());
            int i6 = 0;
            while (i6 < str.length()) {
                int i7 = 65536 + i6;
                randomAccessFile.write(j(str.substring(i6, Math.min(str.length(), i7))).getBytes(StandardCharsets.UTF_8));
                i6 = i7;
            }
            return true;
        } catch (Exception e6) {
            cn.jiguang.bb.f.i("FileUtils", "Append encrypted failed: " + e6.getMessage());
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return b(c(str), str2);
    }

    public static boolean a(String str, String str2, String str3) {
        boolean b6;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            synchronized ((str2 + "/" + str).intern()) {
                try {
                    File file = new File(d.a().getFilesDir(), str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    b6 = b(file2, str3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b6;
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("FileUtils", "writeString throwable:" + th2.getMessage());
            return false;
        }
    }

    public static boolean a(String str, JSONArray jSONArray) {
        return a(str, jSONArray != null ? jSONArray.toString() : null);
    }

    public static boolean a(String str, JSONObject jSONObject) {
        return a(str, jSONObject != null ? jSONObject.toString() : null);
    }

    public static File[] a(File file, FileFilter... fileFilterArr) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        if (fileFilterArr == null || fileFilterArr.length == 0 || (fileFilterArr.length == 1 && fileFilterArr[0] == null)) {
            return file.listFiles();
        }
        if (fileFilterArr.length == 1) {
            return file.listFiles(fileFilterArr[0]);
        }
        LinkedList<File> linkedList = new LinkedList();
        linkedList.add(file);
        int length = fileFilterArr.length;
        int i6 = 0;
        while (i6 < length) {
            FileFilter fileFilter = fileFilterArr[i6];
            LinkedList linkedList2 = new LinkedList();
            for (File file2 : linkedList) {
                File[] listFiles = fileFilter != null ? file2.listFiles(fileFilter) : file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    Collections.addAll(linkedList2, listFiles);
                }
            }
            if (linkedList2.isEmpty()) {
                return null;
            }
            i6++;
            linkedList = linkedList2;
        }
        return (File[]) linkedList.toArray(new File[0]);
    }

    public static File[] a(String str, FileFilter... fileFilterArr) {
        try {
            return a(new File(str), fileFilterArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
