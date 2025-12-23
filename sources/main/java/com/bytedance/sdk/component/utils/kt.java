package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class kt {
    private static Resources cw;

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f26887j;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f26888m;

    /* renamed from: r, reason: collision with root package name */
    private static String f26889r;
    private static boolean up;
    private static String xt;

    private static String cw(Context context) {
        if (f26889r == null) {
            f26889r = context.getPackageName();
        }
        return f26889r;
    }

    private static int j(Context context, String str, String str2) {
        int identifier = j(context).getIdentifier(str, str2, cw(context));
        if (identifier != 0) {
            return identifier;
        }
        if (up) {
            return context.getResources().getIdentifier(str, str2, cw(context));
        }
        xt(context);
        return j(context).getIdentifier(str, str2, cw(context));
    }

    public static int xt(Context context, String str) {
        return j(context, str, ResIdentify.RES_TYPE_STRING);
    }

    public static int ae(Context context, String str) {
        return j(context, str, ResIdentify.RES_TYPE_LAYOUT);
    }

    public static int g(Context context, String str) {
        return j(context, str, "dimen");
    }

    public static int m(Context context, String str) {
        return j(context, str, "id");
    }

    public static int qv(Context context, String str) {
        return j(context, str, "color");
    }

    public static int tl(Context context, String str) {
        return j(context, str, ResIdentify.RES_TYPE_STYLE);
    }

    public static int up(Context context, String str) {
        try {
            return j(context, str, ResIdentify.RES_TYPE_DRAWABLE);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int vl(Context context, String str) {
        return j(context, str, "anim");
    }

    public static synchronized void xt(Context context) {
        synchronized (kt.class) {
            try {
                if (TextUtils.isEmpty(xt)) {
                    return;
                }
                Resources resources = context.getResources();
                cw = new Resources(xt(resources.getAssets(), xt + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
                f26889r = context.getPackageName();
                up = true;
            } catch (Throwable th) {
                vl.cw("ResourceHelp", "makePluginResources failed", th);
            }
        }
    }

    public static int oq(Context context, String str) {
        return j(context).getColor(qv(context, str));
    }

    public static Bitmap r(Context context, String str) {
        return BitmapFactory.decodeResource(j(context), up(context, str));
    }

    public static Drawable cw(Context context, String str) {
        try {
            return j(context).getDrawable(up(context, str));
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static String j(Context context, String str) {
        return j(context).getString(xt(context, str));
    }

    public static void j(Context context, String str, ImageView imageView) {
        Drawable drawable = j(context).getDrawable(up(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void j(Context context, String str, View view) {
        Drawable drawable = j(context).getDrawable(up(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    private static AssetManager xt(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(null).newInstance(null);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            j(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            j(assetManager, str);
        }
        try {
            p.j(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static Resources j(Context context) {
        Resources resources = cw;
        if (resources == null) {
            resources = null;
        }
        Context context2 = f26887j;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static boolean j(AssetManager assetManager, String str) {
        Method j6 = p.j((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (j6 == null) {
            j6 = p.j((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (j6 != null) {
            int i6 = 3;
            while (true) {
                int i7 = i6 - 1;
                if (i6 < 0) {
                    break;
                }
                if (((Integer) j6.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i6 = i7;
            }
        }
        return false;
    }
}
