package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.kwad.sdk.collector.AppStatusRules;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private static boolean cw = j().exists();

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f31561j;
    private static Method xt;

    public static File j() {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext()), ".csj_so");
    }

    private static boolean xt(String str) {
        try {
            if (xt == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                xt = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) m.class.getClassLoader();
            if (xt != null && baseDexClassLoader != null) {
                String findLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (m.class) {
                    xt.invoke(null, findLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            cw = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt("msg", "lock load failed!");
            } catch (JSONException unused) {
            }
            ws.j().j("so_load_fail", jSONObject, th);
        }
        return false;
    }

    public static void j(String str) {
        try {
            if (cw && xt(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            j(str, th);
        }
    }

    private static boolean j(String str, Throwable th) {
        String j6 = com.bytedance.sdk.openadsdk.core.h.j(v.getContext());
        String str2 = "lib" + str + ".so";
        File file = new File(j6, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return j(str, file.getAbsolutePath());
        }
        File file2 = new File(j6, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            j(file2, file, str2);
            File file3 = new File(j6, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return j(str, file3.getAbsolutePath());
                }
            }
            j(str, str2 + " unzip failed !", th);
            return false;
        }
        j(str, "load so filed! apk not exist! ", th);
        return false;
    }

    public static boolean xt() {
        Boolean bool = f31561j;
        if (bool != null) {
            return bool.booleanValue();
        }
        f31561j = Boolean.FALSE;
        try {
            Context context = v.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                f31561j = Boolean.TRUE;
            }
        } catch (Exception e6) {
            vl.xt("SoLoaderUtil", e6);
        }
        return f31561j.booleanValue();
    }

    private static boolean j(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            j(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void j(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.bytedance.sdk.openadsdk.core.s.xt.xt.j() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    bufferedOutputStream.write(bArr, 0, read);
                                } else {
                                    com.bytedance.sdk.component.m.cw.cw.xt.j(bufferedInputStream);
                                    com.bytedance.sdk.component.m.cw.cw.xt.j(bufferedOutputStream);
                                    com.bytedance.sdk.component.m.cw.cw.xt.j(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.bytedance.sdk.component.m.cw.cw.xt.j(bufferedInputStream);
                            com.bytedance.sdk.component.m.cw.cw.xt.j(bufferedOutputStream);
                            com.bytedance.sdk.component.m.cw.cw.xt.j(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable th6) {
            vl.xt("SoLoaderUtil", th6);
        }
    }

    private static void j(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            tj.f30204j = false;
        }
        if (xt()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt("msg", str2);
        } catch (JSONException unused) {
        }
        ws.j().j("so_load_fail", jSONObject, th);
    }
}
