package com.bytedance.sdk.component.adexpress.r;

import android.net.Uri;
import android.text.TextUtils;
import com.bxkj.base.v2.common.utils.g0;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {

    public enum j {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String up;

        public String getType() {
            return this.up;
        }

        j(String str) {
            this.up = str;
        }
    }

    public static j j(String str) {
        j jVar = j.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        return j.CSS;
                    }
                    if (path.endsWith(".js")) {
                        return j.JS;
                    }
                    if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(g0.f16898c) && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        return j.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jVar;
    }

    public static boolean xt(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }
}
