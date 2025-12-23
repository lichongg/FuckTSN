package com.bytedance.adsdk.lottie.up;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final String f23563j;
    private static final String xt;

    public interface j<T> {
        void j(int i6, String str);

        void j(T t5);
    }

    public static String j(Context context) {
        return com.bytedance.sdk.component.utils.m.j(context, com.bytedance.sdk.component.adexpress.j.j.j.j().cw().vl(), f23563j).getAbsolutePath();
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        sb.append(str);
        sb.append("lottie");
        sb.append(str);
        sb.append("anim_img");
        f23563j = sb.toString();
        xt = "tt_derive" + str + "lottie" + str + "anim_video";
    }

    public static void j(String str, Context context, final j<File> jVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (jVar != null) {
                jVar.j(2, "url is empty");
                return;
            }
            return;
        }
        com.bytedance.sdk.component.g.xt.xt r5 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().r();
        if (r5 == null) {
            if (jVar != null) {
                jVar.j(3, "exec is null");
            }
        } else {
            final String j6 = j(context);
            final String xt2 = com.bytedance.sdk.component.utils.up.xt(str);
            r5.j(str);
            r5.j(j6, xt2);
            r5.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.adsdk.lottie.up.xt.1
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (j.this != null) {
                        File file = new File(j6, xt2);
                        if (file.exists()) {
                            j.this.j(file);
                        } else {
                            j.this.j(4, "file not exist");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    j jVar2 = j.this;
                    if (jVar2 != null) {
                        jVar2.j(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }

    public static String xt(Context context) {
        return com.bytedance.sdk.component.utils.m.j(context, com.bytedance.sdk.component.adexpress.j.j.j.j().cw().vl(), xt).getAbsolutePath();
    }
}
