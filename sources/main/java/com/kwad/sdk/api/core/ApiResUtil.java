package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class ApiResUtil {
    static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, "attr");
    }

    static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, "dimen");
    }

    static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, ResIdentify.RES_TYPE_DRAWABLE);
    }

    static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, ResIdentify.RES_TYPE_LAYOUT);
    }

    static int getRawId(Context context, String str) {
        return getIdentifier(context, str, ResIdentify.RES_TYPE_RAW);
    }

    static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, ResIdentify.RES_TYPE_STYLE);
    }

    ApiResUtil() {
    }

    static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, "color"));
    }

    static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, ResIdentify.RES_TYPE_DRAWABLE));
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return context.getPackageName();
    }

    private static Resources getResources(Context context) {
        return context.getResources();
    }

    static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, ResIdentify.RES_TYPE_STRING));
    }
}
