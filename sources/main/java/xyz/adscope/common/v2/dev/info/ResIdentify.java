package xyz.adscope.common.v2.dev.info;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class ResIdentify {
    private static final String APP_ICON = "app_icon";
    private static final String APP_NAME = "app_name";
    public static final String RES_TYPE_DRAWABLE = "drawable";
    public static final String RES_TYPE_ID = "id";
    public static final String RES_TYPE_LAYOUT = "layout";
    public static final String RES_TYPE_MIPMAP = "mipmap";
    public static final String RES_TYPE_RAW = "raw";
    public static final String RES_TYPE_STRING = "string";
    public static final String RES_TYPE_STYLE = "style";

    public static int getAppIconIdentify(Context context) {
        return getDrawableIdentify(context, APP_ICON);
    }

    public static int getAppNameIdentify(Context context) {
        return getStringIdentify(context, "app_name");
    }

    public static int getDrawableIdentify(Context context, String str) {
        return getResIdentify(context, RES_TYPE_DRAWABLE, str);
    }

    public static int getIDIdentify(Context context, String str) {
        return getResIdentify(context, "id", str);
    }

    public static int getLayoutIdentify(Context context, String str) {
        return getResIdentify(context, RES_TYPE_LAYOUT, str);
    }

    public static int getStringIdentify(Context context, String str) {
        return getResIdentify(context, RES_TYPE_STRING, str);
    }

    public static int getStyleIdentify(Context context, String str) {
        return getResIdentify(context, RES_TYPE_STYLE, str);
    }

    private ResIdentify() {
        throw new RuntimeException("class don't need new instance");
    }

    public static int getMipmapIdentify(Context context, String str) {
        return context.getResources().getIdentifier(str, RES_TYPE_MIPMAP, context.getPackageName());
    }

    public static int getRawIdentify(Context context, String str) {
        return context.getResources().getIdentifier(str, RES_TYPE_RAW, context.getPackageName());
    }

    public static int getResIdentify(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }
}
