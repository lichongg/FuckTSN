package com.baidu.mobads.sdk.api;

import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.b.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrawableUtil {
    public static Integer getDrawableId(String str) {
        if ("blur_bg_white".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if (a.C0101a.f10677b.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if (a.C0101a.f10676a.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        return null;
    }
}
