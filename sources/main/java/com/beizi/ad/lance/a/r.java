package com.beizi.ad.lance.a;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ap;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r {
    public static boolean a() {
        try {
            return ap.a("com.tencent.mm.opensdk.openapi.IWXAPI");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String b() {
        try {
            Context e6 = com.beizi.fusion.c.b.a().e();
            if (e6 == null) {
                return null;
            }
            String openSDKAppId = ResponseInfo.getInstance(e6).getOpenSDKAppId();
            if (TextUtils.isEmpty(openSDKAppId)) {
                return null;
            }
            return openSDKAppId;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String d() {
        Context e6;
        IWXAPI createWXAPI;
        try {
            if (!com.beizi.ad.internal.h.a().p() || (e6 = com.beizi.fusion.c.b.a().e()) == null) {
                return null;
            }
            String b6 = b();
            if (TextUtils.isEmpty(b6) || (createWXAPI = WXAPIFactory.createWXAPI(e6, b6)) == null) {
                return null;
            }
            return String.valueOf(createWXAPI.getWXAppSupportAPI());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (!com.beizi.ad.internal.h.a().p()) {
                    return false;
                }
                String b6 = b();
                if (TextUtils.isEmpty(b6)) {
                    return false;
                }
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, b6);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                req.path = str2;
                if (!TextUtils.isEmpty(str3)) {
                    req.extData = str3;
                }
                return createWXAPI.sendReq(req);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String c() {
        try {
            if (com.beizi.ad.internal.h.a().p()) {
                return String.valueOf(638067200);
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!com.beizi.ad.internal.h.a().p()) {
                return false;
            }
            String b6 = b();
            if (TextUtils.isEmpty(b6)) {
                return false;
            }
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, b6);
            WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
            req.businessType = "nativeOpenAdCanvas";
            req.extInfo = str;
            if (createWXAPI == null) {
                return false;
            }
            return createWXAPI.sendReq(req);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
