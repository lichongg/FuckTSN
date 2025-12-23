package com.bytedance.sdk.component.tl.xt.xt;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.m;
import com.bytedance.sdk.component.tl.j.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static long j(int i6, Context context, up upVar) {
        return xt(i6, context, upVar);
    }

    private static long xt(int i6, Context context, up upVar) {
        if (context == null) {
            return i6;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long maxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            return freeMemory <= 10 ? Math.min(i6, 10) : Math.min((freeMemory / 2) * 10, i6);
        }
        long j6 = ((freeMemory + maxMemory) - 10) / 2;
        if (j6 <= 2) {
            return 1L;
        }
        return j6 <= 10 ? Math.min(i6, 10) : Math.min(j6 * 10, i6);
    }

    public static boolean j(up upVar) {
        m xt = upVar.xt();
        return (xt == null || TextUtils.isEmpty(xt.j())) ? false : true;
    }

    public static boolean cw(up upVar) {
        m xt = upVar.xt();
        if (xt != null && !TextUtils.isEmpty(xt.r())) {
            return true;
        }
        return false;
    }

    public static boolean m(up upVar) {
        m xt = upVar.xt();
        if (xt != null && !TextUtils.isEmpty(xt.m())) {
            return true;
        }
        return false;
    }

    public static boolean r(up upVar) {
        m xt = upVar.xt();
        if (xt != null && !TextUtils.isEmpty(xt.up())) {
            return true;
        }
        return false;
    }

    public static boolean up(up upVar) {
        m xt = upVar.xt();
        if (xt != null && !TextUtils.isEmpty(xt.cw())) {
            return true;
        }
        return false;
    }

    public static boolean xt(up upVar) {
        m xt = upVar.xt();
        return (xt == null || TextUtils.isEmpty(xt.xt())) ? false : true;
    }
}
