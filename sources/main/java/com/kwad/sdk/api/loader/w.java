package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.ApiReflect;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class w {
    private static Map<String, Resources> apZ = new HashMap();
    private static final Object aqa = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {
        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cn("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {
        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cn("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d {
        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cn("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e {
        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cn("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f {
        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) ApiReflect.cn("android.content.res.VivoResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                ApiReflect.h(resources2).a("init", new Class[]{String.class}, context.getPackageName());
            } catch (ApiReflect.ReflectException e6) {
                e6.printStackTrace();
            }
            try {
                ApiReflect.h(resources2).b("mThemeValues", ApiReflect.h(resources).get("mThemeValues"));
            } catch (ApiReflect.ReflectException e7) {
                e7.printStackTrace();
            }
            return resources2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    @NonNull
    static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (aqa) {
            try {
                resources2 = apZ.get(str);
                if (resources2 == null) {
                    resources2 = b(context, resources, str);
                    if (resources2 == null) {
                        throw new RuntimeException("Can not createResources for " + str);
                    }
                    apZ.put(str, resources);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return resources2;
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                ApiReflect.h(assetManager).a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
            } else {
                ApiReflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
            }
        } catch (Throwable unused) {
            ApiReflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        }
        return 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) ApiReflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    private static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    private static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    private static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    private static boolean f(Resources resources) {
        if (!"android.content.res.Resources".equals(resources.getClass().getName())) {
            return true;
        }
        return false;
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) ApiReflect.a((Class<?>) AssetManager.class).Dk().get();
        ApiReflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            Object obj = ApiReflect.h(applicationInfo).get("resourceDirs");
            if (obj != null && obj.getClass().isArray()) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    for (Object obj2 : objArr) {
                        if (obj2 instanceof String) {
                            a(assetManager, (String) obj2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            String[] strArr = applicationInfo.sharedLibraryFiles;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str2 != null && str2.endsWith(".apk")) {
                        b(assetManager, str2);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static void a(AssetManager assetManager, String str) {
        try {
            ApiReflect.h(assetManager).a("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            ApiReflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (a(resources)) {
            return d.a(resources, assetManager);
        }
        if (b(resources)) {
            return c.a(resources, assetManager);
        }
        if (e(resources)) {
            return b.a(resources, assetManager);
        }
        if (c(resources)) {
            return f.a(context, resources, assetManager);
        }
        if (d(resources)) {
            return e.a(resources, assetManager);
        }
        if (f(resources)) {
            return a.a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    private static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }
}
