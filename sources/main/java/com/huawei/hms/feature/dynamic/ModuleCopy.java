package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModuleCopy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33182a = "ModuleCopy";

    /* renamed from: b, reason: collision with root package name */
    public static final int f33183b = 2048;

    /* renamed from: c, reason: collision with root package name */
    public static final int f33184c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33185d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final String f33186e = "module_uri_path";

    /* renamed from: f, reason: collision with root package name */
    public static final String f33187f = "loader_uri_path";

    /* renamed from: g, reason: collision with root package name */
    public static final String f33188g = "dynamic_modules";

    /* renamed from: h, reason: collision with root package name */
    public static final String f33189h = ".apk";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33190a;

        public a(String str) {
            this.f33190a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ModuleCopy.c(this.f33190a);
            } catch (SecurityException unused) {
                Logger.w(ModuleCopy.f33182a, "Delete file failed: SecurityException.");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f33191a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33192b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f33193c;

        public b(String[] strArr, int i6, String str) {
            this.f33191a = strArr;
            this.f33192b = i6;
            this.f33193c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f33191a) {
                if (Integer.parseInt(str) < this.f33192b) {
                    Logger.i(ModuleCopy.f33182a, "Delete low version:" + this.f33192b + " in modulePath.");
                    ModuleCopy.c(this.f33193c + File.separator + str);
                }
            }
        }
    }

    public static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.i(f33182a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i6 = 0;
        for (String str : strArr) {
            i6 = Math.max(Integer.parseInt(str), i6);
        }
        return i6;
    }

    public static void b(String str) {
        c.a(1, "DeleteFile").execute(new a(str));
    }

    public static void clearLowVersionModule(int i6, String str, String[] strArr, String str2) {
        c.a(1, str2).execute(new b(strArr, i6, str));
    }

    public static boolean isLocalModuleFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f33182a, "context or filePath is null.");
            return false;
        }
        try {
            return new File(str).getCanonicalPath().startsWith(getProtectedPath(context) + File.separator + "dynamic_modules");
        } catch (IOException unused) {
            return false;
        }
    }

    public static String a(Context context, Bundle bundle, int i6, Uri uri) {
        String str;
        String string;
        String valueOf;
        StringBuilder sb;
        String[] list;
        int a6;
        if (i6 == 0) {
            str = com.huawei.hms.feature.dynamic.b.f33211j;
            string = bundle.getString(com.huawei.hms.feature.dynamic.b.f33211j);
            valueOf = String.valueOf(bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k));
            sb = new StringBuilder();
        } else {
            str = com.huawei.hms.feature.dynamic.b.f33217p;
            string = bundle.getString(com.huawei.hms.feature.dynamic.b.f33217p);
            valueOf = String.valueOf(bundle.getInt(com.huawei.hms.feature.dynamic.b.f33218q));
            sb = new StringBuilder();
        }
        sb.append(bundle.getString(str));
        sb.append(".apk");
        String sb2 = sb.toString();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getProtectedPath(context));
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append("dynamic_modules");
            sb3.append(str2);
            sb3.append(string);
            String sb4 = sb3.toString();
            String str3 = sb4 + str2 + valueOf;
            String str4 = str3 + str2 + sb2;
            if (new File(sb4).exists() && (a6 = a((list = new File(sb4).list()))) >= Integer.parseInt(valueOf)) {
                clearLowVersionModule(a6, sb4, list, f33182a);
                return sb4 + str2 + a6 + str2 + sb2;
            }
            return a(context, str3, uri, str4);
        } catch (IOException e6) {
            Logger.w(f33182a, "request modulePath error: " + e6.getMessage());
            return null;
        }
    }

    public static boolean c(String str) {
        boolean z5;
        File file = new File(str);
        if (!file.isDirectory() || file.list() == null) {
            z5 = true;
        } else {
            z5 = true;
            for (String str2 : file.list()) {
                if (z5) {
                    if (c(str + File.separator + str2)) {
                        z5 = true;
                    }
                }
                z5 = false;
            }
        }
        return z5 && file.delete();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(f33182a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.e(f33182a, "The context or module info bundle is null.");
            return;
        }
        boolean a6 = a(bundle);
        a(context, bundle, 0);
        if (a6) {
            bundle.putString(com.huawei.hms.feature.dynamic.b.f33219r, bundle.getString(com.huawei.hms.feature.dynamic.b.f33215n));
        } else {
            a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IOException {
        Context createDeviceProtectedStorageContext;
        File dataDir;
        if (Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            return dataDir.getCanonicalPath();
        }
        String canonicalPath = context.getFilesDir().getCanonicalPath();
        int lastIndexOf = canonicalPath.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? canonicalPath : canonicalPath.substring(0, lastIndexOf);
    }

    public static boolean makeDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e6) {
            Logger.e(f33182a, "makeDirectory Exception: " + e6.getMessage());
            return false;
        }
    }

    public static String trimLastSection(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }

    public static String a(Context context, String str, Uri uri, String str2) {
        if (!makeDirectory(str)) {
            Logger.e(f33182a, "makeDirectory return false");
            return null;
        }
        a(context, uri, str2);
        if (com.huawei.hms.feature.dynamic.f.d.b(context, str2)) {
            return str2;
        }
        Logger.w(f33182a, "The coped module apk is invalid.");
        b(str2);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static void a(Context context, Uri uri, String str) {
        InputStream inputStream;
        IOException e6;
        FileNotFoundException e7;
        InputStream inputStream2;
        StringBuilder sb;
        String message;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e8) {
                e7 = e8;
                inputStream = null;
            } catch (IOException e9) {
                e6 = e9;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                if (inputStream == null) {
                    Logger.w(f33182a, "Get input stream failed: null.");
                    closeQuietly(inputStream);
                    closeQuietly(null);
                    return;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            closeQuietly(inputStream);
                            closeQuietly(bufferedOutputStream2);
                            return;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (FileNotFoundException e10) {
                    bufferedOutputStream = bufferedOutputStream2;
                    e7 = e10;
                    sb = new StringBuilder();
                    sb.append("FileNotFoundException:");
                    message = e7.getMessage();
                    context = inputStream;
                    sb.append(message);
                    Logger.e(f33182a, sb.toString());
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                } catch (IOException e11) {
                    bufferedOutputStream = bufferedOutputStream2;
                    e6 = e11;
                    sb = new StringBuilder();
                    sb.append("IOException ");
                    message = e6.getMessage();
                    context = inputStream;
                    sb.append(message);
                    Logger.e(f33182a, sb.toString());
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    inputStream2 = inputStream;
                    closeQuietly(inputStream2);
                    closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e12) {
                e7 = e12;
            } catch (IOException e13) {
                e6 = e13;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                inputStream2 = inputStream;
                closeQuietly(inputStream2);
                closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = context;
        }
    }

    public static void a(Context context, Bundle bundle, int i6) {
        String string = bundle.getString(i6 == 0 ? f33186e : f33187f);
        Logger.i(f33182a, "path:" + string);
        String a6 = a(context, bundle, i6, Uri.parse(string));
        if (TextUtils.isEmpty(a6)) {
            Logger.w(f33182a, "checkModulePath failed: null.");
        } else if (i6 == 0) {
            bundle.putString(com.huawei.hms.feature.dynamic.b.f33215n, a6);
        } else {
            bundle.putString(com.huawei.hms.feature.dynamic.b.f33219r, a6);
        }
    }

    public static boolean a(Bundle bundle) {
        return TextUtils.equals(bundle.getString(com.huawei.hms.feature.dynamic.b.f33215n), bundle.getString(com.huawei.hms.feature.dynamic.b.f33219r));
    }
}
