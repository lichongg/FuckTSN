package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f36787a = i.a("e_qq_com_plugin");

    /* renamed from: b, reason: collision with root package name */
    private static String f36788b = i.a("e_qq_com_dex");

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(Context context) {
        try {
            File file = new File(g(context), "stub_ver");
            if (TextUtils.equals(a(file), SDKStatus.getSDKVersion())) {
                return;
            }
            a(SDKStatus.getSDKVersion(), file);
            a(context);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    private static void a(File file, boolean z5) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z5) {
            file.delete();
        }
    }

    static String b() {
        return "gdtadv2.jar";
    }

    static File c(Context context) {
        return context.getDir(f36788b, 0);
    }

    static File d(Context context) {
        return new File(g(context), "update_lc");
    }

    static File e(Context context) {
        return new File(g(context), "gdt_plugin.next");
    }

    static File f(Context context) {
        return new File(g(context), "gdt_plugin.next.sig");
    }

    static File g(Context context) {
        return context.getDir(f36787a, 0);
    }

    static File h(Context context) {
        return new File(g(context), "gdt_plugin.jar");
    }

    static File i(Context context) {
        return new File(g(context), "gdt_plugin.jar.sig");
    }

    static void a(Context context) {
        try {
            File g6 = g(context);
            if (new File(g6, "disdoat").exists()) {
                return;
            }
            a(c(context), false);
            a(new File(g6, "oat"), false);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    static String a() {
        return "gdt_plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    static String a(File file) throws IOException {
        ?? r42;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return sb2;
                        } catch (IOException e6) {
                            throw e6;
                        }
                    } catch (IOException e7) {
                        throw e7;
                    } catch (Throwable th) {
                        th = th;
                        r42 = 0;
                        if (r42 != 0) {
                            try {
                                r42.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r42 = file;
            }
        }
        return null;
    }

    public static boolean a(File file, File file2, Context context, boolean z5) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z5) {
                return a(file2, context);
            }
            return true;
        }
        try {
            boolean a6 = a(new FileInputStream(file), file2);
            if (!z5) {
                return a6;
            }
            if (a6) {
                if (a(file2, context)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean a(File file, Context context) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static void a(String str, File file) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStreamWriter.write(str);
            a(outputStreamWriter);
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            a(outputStreamWriter2);
            throw th;
        }
    }
}
