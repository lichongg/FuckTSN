package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CacheExector {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42441a = "CacheExector";

    /* renamed from: b, reason: collision with root package name */
    private final int f42442b = 32;

    /* renamed from: c, reason: collision with root package name */
    private final int f42443c = 5120;

    /* renamed from: d, reason: collision with root package name */
    private final int f42444d = 8;

    /* renamed from: e, reason: collision with root package name */
    private String f42445e;

    private double a(long j6) {
        if (j6 <= 0) {
            return 0.0d;
        }
        return j6 / 1024.0d;
    }

    private File b(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return a(file, str);
        }
        File c6 = c(file, str);
        return c6 == null ? a(file, str) : c6;
    }

    private File d(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        return e(file, str);
    }

    private File a() {
        if (TextUtils.isEmpty(this.f42445e)) {
            return null;
        }
        File file = new File(this.f42445e);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public CacheExector(String str) {
        this.f42445e = str;
    }

    private File c(File file, String str) {
        File[] a6 = a(file);
        if (a6 == null || a6.length <= 0 || a6.length <= 0) {
            return null;
        }
        File file2 = a6[0];
        if (a(file2.length()) > 32.0d) {
            return null;
        }
        return file2;
    }

    private File e(File file, String str) {
        File[] a6 = a(file);
        if (a6 != null && a6.length > 0) {
            for (File file2 : a6) {
                if (a(file2.length()) <= 40 && file2.getName().endsWith(str)) {
                    return file2;
                }
                file2.length();
                deleteFile(file2.getName());
            }
        }
        return null;
    }

    public double checkSize(String str) {
        File a6 = a();
        double d6 = 0.0d;
        if (a6 != null && a6.isDirectory()) {
            File[] listFiles = a6.listFiles();
            for (int i6 = 0; i6 < listFiles.length; i6++) {
                File file = listFiles[i6];
                if (file != null && file.getName().contains(str)) {
                    d6 += a(listFiles[i6].length());
                }
            }
        }
        return d6;
    }

    public boolean deleteFile(String str) {
        File[] listFiles = a().listFiles();
        boolean z5 = false;
        for (int i6 = 0; i6 < listFiles.length; i6++) {
            File file = listFiles[i6];
            if (file != null && file.getName().contains(str)) {
                z5 = listFiles[i6].delete();
            }
        }
        return z5;
    }

    public <T extends IReader> T readFile(String str, Class<T> cls) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        T t5;
        File d6 = d(a(), str);
        Closeable closeable = null;
        if (d6 == null) {
            return null;
        }
        try {
            fileInputStream = new AtomicFile(d6).openRead();
        } catch (IOException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
            deleteFile(d6.getName());
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        try {
            t5 = (T) a(d6.getName(), cls);
            inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                closeable = inputStreamReader;
                a(fileInputStream);
                a(closeable);
                a(bufferedReader);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            inputStreamReader = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            a(fileInputStream);
            a(closeable);
            a(bufferedReader);
            throw th;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(readLine)) {
                        try {
                            sb.append(readLine);
                        } catch (Exception e9) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e9);
                        }
                    }
                }
                if (t5 != null) {
                    t5.create(sb.toString());
                }
                a(fileInputStream);
                a(inputStreamReader);
                a(bufferedReader);
                return t5;
            } catch (Throwable th3) {
                th = th3;
                closeable = inputStreamReader;
                a(fileInputStream);
                a(closeable);
                a(bufferedReader);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            a(fileInputStream);
            a(inputStreamReader);
            a(bufferedReader);
            return null;
        }
    }

    public boolean save(String str, String str2) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        File b6 = b(a(), str2);
        boolean z5 = false;
        if (b6 == null) {
            return false;
        }
        AtomicFile atomicFile = new AtomicFile(b6);
        Closeable closeable = null;
        try {
            fileOutputStream = atomicFile.startWrite(true);
        } catch (IOException e6) {
            SLog.error(UmengText.CACHE.CACHEFILE, e6);
            deleteFile(b6.getName());
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                try {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        try {
                            bufferedWriter.write(str);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            atomicFile.finishWrite(fileOutputStream);
                            closeable = bufferedWriter;
                            z5 = true;
                        } catch (IOException e7) {
                            e = e7;
                            closeable = bufferedWriter;
                            atomicFile.failWrite(fileOutputStream);
                            SLog.error(UmengText.CACHE.CACHEFILE, e);
                            a(closeable);
                            a(outputStreamWriter);
                            a(fileOutputStream);
                            return z5;
                        } catch (Throwable th) {
                            th = th;
                            closeable = bufferedWriter;
                            a(closeable);
                            a(outputStreamWriter);
                            a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } else {
                outputStreamWriter = null;
            }
        } catch (IOException e9) {
            e = e9;
            outputStreamWriter = null;
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
        }
        a(closeable);
        a(outputStreamWriter);
        a(fileOutputStream);
        return z5;
    }

    private File a(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return new File(file, a(str));
    }

    private Comparator<File> b() {
        return new Comparator<File>() { // from class: com.umeng.socialize.net.dplus.cache1.CacheExector.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    private String a(String str) {
        return String.valueOf(System.currentTimeMillis()) + str;
    }

    private File[] a(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, b());
        return listFiles;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e6) {
                SLog.error(UmengText.CACHE.CACHEFILE, e6);
            }
        }
    }

    private <T extends IReader> T a(String str, Class<T> cls) {
        try {
            return cls.getConstructor(String.class).newInstance(str);
        } catch (Throwable th) {
            SLog.error(UmengText.CACHE.CACHEFILE, th);
            return null;
        }
    }
}
