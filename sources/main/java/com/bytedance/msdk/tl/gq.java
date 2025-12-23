package com.bytedance.msdk.tl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class gq {

    /* renamed from: j, reason: collision with root package name */
    private static String f25213j;

    public static boolean j() {
        return com.bytedance.msdk.j.up.cw.xt() && com.bytedance.msdk.core.j.qv().ch() && com.bytedance.msdk.core.j.qv().s();
    }

    public static String xt() {
        if (TextUtils.isEmpty(f25213j)) {
            f25213j = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f25213j;
    }

    public static String j(String str) {
        try {
            if (!j()) {
                return str;
            }
            String x5 = com.bytedance.msdk.core.j.qv().x();
            if (TextUtils.isEmpty(x5)) {
                return str;
            }
            com.bytedance.msdk.j.up.cw.j("TestHelperUtils", "AnyDoorId=" + x5);
            return Uri.parse(str).buildUpon().appendQueryParameter(xt(), x5).appendQueryParameter(CommonNetImpl.AID, "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
