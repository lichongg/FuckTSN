package cn.jpush.android.y;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.kuaishou.weapon.p0.t;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f4010d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f4011e = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private String f4012a;

    /* renamed from: b, reason: collision with root package name */
    private Resources f4013b;

    /* renamed from: c, reason: collision with root package name */
    private ClassLoader f4014c;

    private static String c(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(l.f3480a);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public int a(String str, String str2) {
        String str3 = this.f4012a + ".R$" + str;
        Logger.d("LoadedResource", "resource class:" + str3 + ",fieldName:" + str2);
        try {
            return ((Integer) this.f4014c.loadClass(str3).getField(str2).get(null)).intValue();
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "[getResourceID] failed:" + th.getMessage());
            return 0;
        }
    }

    private static PackageInfo a(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public Class b(String str) {
        try {
            return this.f4014c.loadClass(str);
        } catch (ClassNotFoundException e6) {
            Logger.ww("LoadedResource", "[getClass] failed:" + e6.getMessage());
            return null;
        }
    }

    public static a a(Context context) {
        try {
            Object dyInfo = JCoreHelper.getDyInfo(context, 2);
            Logger.d("LoadedResource", "load resouce:" + dyInfo);
            if (dyInfo != null && (dyInfo instanceof Map)) {
                Map map = (Map) dyInfo;
                String str = (String) map.get("p");
                Logger.d("LoadedResource", "jpush dex path:" + str);
                if (!TextUtils.isEmpty(str)) {
                    return a(context, str, (String) map.get("o"), (String) map.get(t.f36143d), false);
                }
            }
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "l r failed:" + th.getMessage());
        }
        Logger.d("LoadedResource", "load resource failed");
        return null;
    }

    private static a a(Context context, String str, String str2, String str3, boolean z5) {
        String a6 = a(context, str, z5);
        PackageInfo a7 = a(context, a6);
        if (a7 == null) {
            Logger.d("LoadedResource", "info is null");
            return null;
        }
        Logger.d("LoadedResource", "pkg name:" + a7.packageName);
        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
        AssetManager.class.getMethod("addAssetPath", String.class).invoke(assetManager, a6);
        Resources resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        a aVar = new a();
        aVar.a(resources);
        aVar.a(a7.packageName);
        aVar.a(new b(a6, str2, str3, context.getClassLoader()));
        a(context, str, a6, z5);
        Logger.d("LoadedResource", "build resource:" + a6 + ", o: " + str);
        return aVar;
    }

    private static String a(Context context, String str, boolean z5) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                if (!z5 && JConstants.SDK_VERSION_INT >= 440) {
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                String c6 = c(str);
                Map<String, String> map = f4011e;
                if (map.containsKey(c6)) {
                    Logger.d("LoadedResource", "use d f cache");
                    String str2 = map.get(c6);
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str2;
                }
                String c7 = c(cn.jpush.android.ad.a.d(context));
                if (TextUtils.isEmpty(c7)) {
                    Logger.w("LoadedResource", "process name to hash failed");
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                String c8 = c(c7 + new File(str).getName());
                if (TextUtils.isEmpty(c8)) {
                    Logger.w("LoadedResource", "process + fileName to hash failed");
                    m.a((Closeable) null);
                    m.a((Closeable) null);
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(context.getCacheDir());
                String str3 = File.separator;
                sb.append(str3);
                sb.append(".p");
                File file = new File(sb.toString(), c7 + str3 + c8 + ".d");
                if (file.exists()) {
                    file.delete();
                }
                file.getParentFile().mkdirs();
                file.createNewFile();
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                file.setReadOnly();
                                f4011e.put(c6, file.getAbsolutePath());
                                Logger.d("LoadedResource", "fix d success, name: " + file.getName());
                                String absolutePath = file.getAbsolutePath();
                                m.a(fileOutputStream2);
                                m.a((Closeable) fileInputStream2);
                                return absolutePath;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            Logger.w("LoadedResource", "fix d file failed, " + th.getMessage());
                            return str;
                        } finally {
                            m.a(fileOutputStream);
                            m.a((Closeable) fileInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    fileInputStream = fileInputStream2;
                    th = th2;
                }
            }
            m.a((Closeable) null);
            m.a((Closeable) null);
            return str;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i6 = 0; i6 < bArr.length; i6++) {
            char[] cArr = f4010d;
            sb.append(cArr[(bArr[i6] & 240) >>> 4]);
            sb.append(cArr[bArr[i6] & 15]);
        }
        return sb.toString();
    }

    private static void a(Context context, String str, String str2, boolean z5) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z5 || JConstants.SDK_VERSION_INT < 440) {
            try {
                String c6 = c(str);
                Map<String, String> map = f4011e;
                if (!map.containsKey(c6) || TextUtils.equals(str, str2)) {
                    return;
                }
                map.remove(c6);
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                    Logger.d("LoadedResource", "d d file success:" + file.getAbsolutePath());
                }
            } catch (Throwable th) {
                Logger.w("LoadedResource", "d dex f failed, " + th.getMessage());
            }
        }
    }

    public void a(Resources resources) {
        this.f4013b = resources;
    }

    public void a(ClassLoader classLoader) {
        this.f4014c = classLoader;
    }

    public void a(String str) {
        this.f4012a = str;
    }
}
