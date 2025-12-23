package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x3 {

    /* renamed from: a, reason: collision with root package name */
    private static AssetManager f7640a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Resources f7641b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Resources f7642c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f7643d = true;

    /* renamed from: e, reason: collision with root package name */
    private static Context f7644e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f7645f = "amap_resource";

    /* renamed from: g, reason: collision with root package name */
    private static String f7646g = "1_0_0";

    /* renamed from: i, reason: collision with root package name */
    private static String f7648i = ".jar";

    /* renamed from: j, reason: collision with root package name */
    private static String f7649j = f7645f + f7646g + f7648i;

    /* renamed from: h, reason: collision with root package name */
    private static String f7647h = ".png";

    /* renamed from: k, reason: collision with root package name */
    private static String f7650k = f7645f + f7646g + f7647h;

    /* renamed from: l, reason: collision with root package name */
    private static String f7651l = "";

    /* renamed from: m, reason: collision with root package name */
    private static String f7652m = f7651l + f7649j;

    /* renamed from: n, reason: collision with root package name */
    private static Resources.Theme f7653n = null;

    /* renamed from: o, reason: collision with root package name */
    private static Resources.Theme f7654o = null;

    /* renamed from: p, reason: collision with root package name */
    private static Field f7655p = null;

    /* renamed from: q, reason: collision with root package name */
    private static Field f7656q = null;

    /* renamed from: r, reason: collision with root package name */
    private static Activity f7657r = null;

    /* renamed from: s, reason: collision with root package name */
    public static int f7658s = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(x3.f7646g);
            sb.append(x3.f7648i);
            return str.startsWith(x3.f7645f) && !str.endsWith(sb.toString());
        }

        a() {
        }
    }

    private static AssetManager a(String str) {
        Class<?> cls;
        AssetManager assetManager;
        AssetManager assetManager2 = null;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Throwable th2) {
            th = th2;
            assetManager2 = assetManager;
            v5.p(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager2;
        }
    }

    public static boolean f(Context context) {
        try {
            f7644e = context;
            File g6 = g(context);
            if (g6 != null) {
                f7651l = g6.getAbsolutePath() + "/";
            }
            f7652m = f7651l + f7649j;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!f7643d) {
            return true;
        }
        if (!k(context)) {
            return false;
        }
        AssetManager a6 = a(f7652m);
        f7640a = a6;
        f7641b = c(context, a6);
        return true;
    }

    private static File g(Context context) {
        try {
            if (context == null) {
                if (context != null) {
                    context.getFilesDir();
                }
                return null;
            }
            try {
                File externalFilesDir = (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) ? context.getExternalFilesDir("LBS") : context.getFilesDir();
                if (externalFilesDir == null) {
                    context.getFilesDir();
                }
                return externalFilesDir;
            } catch (Exception e6) {
                e6.printStackTrace();
                if (0 == 0) {
                    return context.getFilesDir();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    public static Resources b() {
        Resources resources = f7641b;
        return resources == null ? f7644e.getResources() : resources;
    }

    private static Resources c(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    private static OutputStream e(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(f7651l, f7649j));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private static boolean i(InputStream inputStream) throws IOException {
        File file = new File(f7652m);
        long length = file.length();
        int available = inputStream.available();
        if (!file.exists() || length != available) {
            return false;
        }
        inputStream.close();
        return true;
    }

    private static boolean k(Context context) {
        m(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(f7650k);
            if (i(inputStream)) {
                return true;
            }
            n();
            OutputStream e6 = e(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    v5.p(e7, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            e6.close();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                v5.p(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream == null) {
                    return false;
                }
                try {
                    inputStream.close();
                    return false;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    v5.p(e8, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    return false;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        v5.p(e9, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    private static void n() {
        File[] listFiles = new File(f7651l).listFiles(new a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }

    public static View d(Context context, int i6) {
        XmlResourceParser xml = b().getXml(i6);
        if (!f7643d) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i7 = f7658s;
            if (i7 == -1) {
                i7 = 0;
            }
            return LayoutInflater.from(new w3(context, i7, x3.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                v5.p(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");
                return null;
            } finally {
                xml.close();
            }
        }
    }

    private static void m(Context context) {
        f7651l = context.getFilesDir().getAbsolutePath();
        f7652m = f7651l + "/" + f7649j;
    }
}
