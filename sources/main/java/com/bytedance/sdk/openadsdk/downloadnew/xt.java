package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.m;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static int j(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, ResIdentify.RES_TYPE_DRAWABLE, context.getPackageName());
        } catch (Exception e6) {
            m.j(e6);
            return 0;
        }
    }

    public static int xt(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, ResIdentify.RES_TYPE_STYLE, context.getPackageName());
        } catch (Exception e6) {
            m.j(e6);
            return 0;
        }
    }

    public static int cw(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e6) {
            m.j(e6);
            return 0;
        }
    }

    public static int j(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, ResIdentify.RES_TYPE_DRAWABLE, str2);
        } catch (Exception e6) {
            m.j(e6);
            return 0;
        }
    }

    public static int xt(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e6) {
            m.j(e6);
            return 0;
        }
    }
}
