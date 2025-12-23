package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AssetLoadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33126a = "AssetLoadManager";

    /* renamed from: b, reason: collision with root package name */
    public static final String f33127b = "dynamic_modules";

    /* renamed from: c, reason: collision with root package name */
    public static final String f33128c = ".apk";

    /* renamed from: d, reason: collision with root package name */
    public static final String f33129d = "com.huawei.hms.feature.dynamic.descriptors.";

    /* renamed from: e, reason: collision with root package name */
    public static final String f33130e = ".AssetModuleDescriptor";

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f33126a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(f33129d + str + f33130e).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f33126a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e6) {
            Logger.w(f33126a, "Get local asset module info failed.", e6);
            return 0;
        }
    }

    public static Bundle a(Context context, File file, String str) {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.w(f33126a, "No version in module path.");
            return new Bundle();
        }
        int i6 = 0;
        for (String str2 : list) {
            i6 = Math.max(Integer.parseInt(str2), i6);
        }
        if (i6 == 0) {
            Logger.w(f33126a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(i6, canonicalPath, list, f33126a);
            if (a(context, str) > i6) {
                Logger.i(f33126a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(canonicalPath);
            String str3 = File.separator;
            sb.append(str3);
            sb.append(i6);
            sb.append(str3);
            sb.append(str);
            sb.append(".apk");
            String sb2 = sb.toString();
            if (!new File(sb2).exists()) {
                Logger.w(f33126a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString(b.f33211j, str);
            bundle.putString(b.f33215n, sb2);
            bundle.putInt(b.f33214m, i6);
            Logger.i(f33126a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i6 + ", ModulePath:" + sb2);
            return bundle;
        } catch (IOException e6) {
            Logger.w(f33126a, "request modulePath error: " + e6.getMessage());
            return new Bundle();
        }
    }

    public static Bundle b(Context context, String str) {
        try {
            String[] list = context.getAssets().list("dynamic_modules" + File.separator + str);
            if (list != null && list.length != 0) {
                String str2 = list[0];
                int a6 = a(context, str);
                String a7 = a(context, str, a6, str2);
                if (!TextUtils.isEmpty(a7) && new File(a7).exists()) {
                    if (ExtractNativeUtils.d(context, a7) && ExtractNativeUtils.a(new File(a7), ModuleCopy.trimLastSection(a7)) != 0) {
                        Logger.w(f33126a, "Extract native to current dir failed.");
                        return new Bundle();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(b.f33211j, str);
                    bundle.putString(b.f33215n, a7);
                    bundle.putInt(b.f33214m, a6);
                    Logger.i(f33126a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + a6 + ", ModulePath:" + a7);
                    return bundle;
                }
                Logger.w(f33126a, "Decompress module from assets failed.");
                return new Bundle();
            }
            Logger.w(f33126a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e6) {
            Logger.i(f33126a, "getModuleFromAsset failed.", e6);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f33126a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(ModuleCopy.getProtectedPath(context));
            String str2 = File.separator;
            sb.append(str2);
            sb.append("dynamic_modules");
            sb.append(str2);
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                Bundle a6 = a(context, file, str);
                if (a6.getInt(b.f33214m) > 0) {
                    Logger.i(f33126a, "Successfully get module info from decompressed asset path.");
                    return a6;
                }
            }
            Bundle b6 = b(context, str);
            if (b6.getInt(b.f33214m) > 0) {
                Logger.i(f33126a, "Successfully get module info from asset.");
                return b6;
            }
        } catch (Exception e6) {
            Logger.i(f33126a, "getDataModuleInfo failed.", e6);
        }
        return new Bundle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.Closeable, java.io.InputStream] */
    public static String a(Context context, String str, int i6, String str2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        Closeable closeable2;
        String str3;
        String str4;
        Closeable closeable3 = null;
        try {
            try {
                AssetManager assets = context.getAssets();
                StringBuilder sb = new StringBuilder();
                sb.append("dynamic_modules");
                str3 = File.separator;
                sb.append(str3);
                sb.append(str);
                sb.append(str3);
                sb.append((String) str2);
                str2 = assets.open(sb.toString());
            } catch (Exception e6) {
                e = e6;
                str2 = 0;
            } catch (Throwable th) {
                th = th;
                str2 = 0;
            }
            try {
                bufferedInputStream = new BufferedInputStream(str2);
                try {
                    str4 = ModuleCopy.getProtectedPath(context) + str3 + "dynamic_modules" + str3 + str + str3 + ((int) i6);
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream = null;
                    closeable = str2;
                } catch (Throwable th2) {
                    th = th2;
                    ModuleCopy.closeQuietly(bufferedInputStream);
                    ModuleCopy.closeQuietly(closeable3);
                    ModuleCopy.closeQuietly(str2);
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
                bufferedInputStream = null;
                closeable = str2;
                Logger.w(f33126a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable2 = closeable;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(closeable3);
                ModuleCopy.closeQuietly(str2);
                throw th;
            }
            if (!new File(str4).exists() && !new File(str4).mkdirs()) {
                Logger.w(f33126a, "mkdirs local loaderPath failed.");
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(null);
                closeable2 = str2;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            }
            String str5 = str4 + str3 + str + ".apk";
            fileOutputStream = new FileOutputStream(str5);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        Logger.i(f33126a, "Decompress module:" + str + " from assets success.");
                        ModuleCopy.closeQuietly(bufferedInputStream);
                        ModuleCopy.closeQuietly(fileOutputStream);
                        ModuleCopy.closeQuietly(str2);
                        return str5;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e9) {
                e = e9;
                closeable = str2;
                Logger.w(f33126a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable2 = closeable;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable3 = i6;
        }
    }
}
