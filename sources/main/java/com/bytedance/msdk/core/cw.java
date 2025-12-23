package com.bytedance.msdk.core;

import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.msdk.tl.gq;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static String f24456j;
    private static String xt;

    public static String cw() {
        return gq.j(up() + "/api/ad/union/mediation/exchange/");
    }

    public static String j() {
        return gq.j(up() + "/api/ad/union/mediation/config/");
    }

    public static String r() {
        return gq.j(up() + "/api/ad/union/mediation/reward_video/reward/");
    }

    public static String xt() {
        return gq.j(JPushConstants.HTTPS_PRE + xt.xt().qv());
    }

    private static String m() {
        String xt2 = com.bytedance.msdk.ae.j.j().xt("server_dist_host");
        if (TextUtils.isEmpty(xt2)) {
            return null;
        }
        if (TextUtils.equals(xt2, f24456j) && !TextUtils.isEmpty(xt)) {
            return xt;
        }
        f24456j = xt2;
        xt = null;
        if (!TextUtils.isEmpty(xt2)) {
            xt = com.bytedance.msdk.tl.j.xt(f24456j, com.bytedance.msdk.tl.xt.j());
        }
        if (TextUtils.isEmpty(xt)) {
            return null;
        }
        String str = JPushConstants.HTTPS_PRE + xt;
        xt = str;
        return str;
    }

    private static String up() {
        String m6 = m();
        if (!TextUtils.isEmpty(m6)) {
            return m6;
        }
        return "https://gromore.pangolin-sdk-toutiao.com";
    }
}
