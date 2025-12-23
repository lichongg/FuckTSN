package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static String Da() {
        String FY = com.kwad.sdk.core.config.e.FY();
        if (TextUtils.isEmpty(FY)) {
            return "安装";
        }
        return FY;
    }

    public static String Db() {
        String FZ = com.kwad.sdk.core.config.e.FZ();
        if (TextUtils.isEmpty(FZ)) {
            return "取消";
        }
        return FZ;
    }

    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.FX().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.t.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
