package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String[] j(File file) {
        String[] j6 = com.bytedance.pangle.util.j.xt.j(file);
        if (TextUtils.isEmpty(j6[0])) {
            return com.bytedance.pangle.util.j.j.j(file);
        }
        return j6;
    }
}
