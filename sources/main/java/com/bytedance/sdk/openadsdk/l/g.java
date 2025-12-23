package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static volatile com.bykv.vk.openvk.component.video.api.j.xt cw = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f31555j = null;

    /* renamed from: m, reason: collision with root package name */
    private static int f31556m = 1;

    /* renamed from: r, reason: collision with root package name */
    private static String f31557r;
    private static String up;
    public static volatile com.bykv.vk.openvk.component.video.api.j.xt xt;

    public static com.bykv.vk.openvk.component.video.api.j.xt j(int i6) {
        return i6 == 1 ? tl() : ae();
    }

    private static String xt(int i6) {
        File j6;
        Context context = v.getContext();
        if (i6 == 1) {
            vl.j("CacheDirConstants", "使用内部存储");
            j6 = com.bytedance.sdk.component.utils.m.xt(context, com.bytedance.sdk.openadsdk.core.multipro.xt.cw(), "tt_ad");
        } else {
            vl.j("CacheDirConstants", "使用外部存储");
            j6 = com.bytedance.sdk.component.utils.m.j(context, com.bytedance.sdk.openadsdk.core.multipro.xt.cw(), "tt_ad");
        }
        if (j6.isFile()) {
            j6.delete();
        }
        if (!j6.exists()) {
            j6.mkdirs();
        }
        return j6.getAbsolutePath();
    }

    private static com.bykv.vk.openvk.component.video.api.j.xt ae() {
        if (xt == null) {
            synchronized (g.class) {
                try {
                    if (xt == null) {
                        com.bykv.vk.openvk.component.video.j.j.j.j jVar = new com.bykv.vk.openvk.component.video.j.j.j.j();
                        xt = jVar;
                        jVar.j(g());
                        xt.up();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public static long[] cw() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    private static String g() {
        if (!TextUtils.isEmpty(f31555j)) {
            return f31555j;
        }
        int gr = v.xt().gr();
        f31556m = gr;
        String xt2 = xt(gr);
        f31555j = xt2;
        return xt2;
    }

    public static String m() {
        if (up == null) {
            up = j(SocializeProtocolConstants.IMAGE);
        }
        return up;
    }

    public static int r() {
        return f31556m;
    }

    private static com.bykv.vk.openvk.component.video.api.j.xt tl() {
        if (cw == null) {
            synchronized (g.class) {
                try {
                    if (cw == null) {
                        com.bytedance.sdk.component.vl.xt.j.j jVar = new com.bytedance.sdk.component.vl.xt.j.j();
                        cw = jVar;
                        jVar.j(g());
                        cw.up();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    public static String up() {
        if (f31557r == null) {
            f31557r = j("splash_image");
        }
        return f31557r;
    }

    public static String j() {
        return g() + File.separator + "video_brand";
    }

    public static String j(String str) {
        return g() + File.separator + str;
    }

    public static String[] xt() {
        String xt2 = xt(1);
        com.bytedance.sdk.component.vl.xt.j.j jVar = new com.bytedance.sdk.component.vl.xt.j.j();
        jVar.j(xt2);
        String xt3 = xt(0);
        com.bytedance.sdk.component.vl.xt.j.j jVar2 = new com.bytedance.sdk.component.vl.xt.j.j();
        jVar2.j(xt3);
        return new String[]{jVar.xt(), jVar.cw(), jVar.j(), jVar.r(), jVar2.xt(), jVar2.cw(), jVar2.j(), jVar2.r()};
    }
}
