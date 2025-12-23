package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.downloader.cw;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {
    public static int a(String str) {
        try {
            return d(str, cw.nd().getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int b(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, ResIdentify.RES_TYPE_STRING, context.getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int c(String str) {
        try {
            return cw.nd().getResources().getIdentifier(str, ResIdentify.RES_TYPE_LAYOUT, cw.nd().getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int d(String str, String str2) {
        try {
            return cw.nd().getResources().getIdentifier(str, ResIdentify.RES_TYPE_DRAWABLE, str2);
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return cw.nd().getResources().getIdentifier(str, "color", cw.nd().getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return cw.nd().getResources().getIdentifier(str, ResIdentify.RES_TYPE_STYLE, cw.nd().getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int g(String str) {
        try {
            return cw.nd().getResources().getIdentifier(str, "id", cw.nd().getPackageName());
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static int h(String str) {
        return b(cw.nd(), str);
    }

    public static int i(String str, String str2) {
        try {
            return cw.nd().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e6) {
            vl.j(e6);
            return 0;
        }
    }
}
