package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ae {
    public static void a(boolean z5) {
        try {
            if (z5) {
                try {
                    com.beizi.ad.f.a(false);
                } catch (Throwable unused) {
                }
                BeiZis.setLimitPersonalAds(false);
                return;
            }
            try {
                com.beizi.ad.f.a(true);
            } catch (Throwable unused2) {
            }
            BeiZis.setLimitPersonalAds(true);
            if (com.beizi.fusion.c.b.a().e() == null || !b()) {
                return;
            }
            if (RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo() != null && !TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().getOaid())) {
                RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().setOaid("");
            }
            if (RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo() == null || TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().getHonorOaid())) {
                return;
            }
            RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().setHonorOaid("");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b() {
        int c6 = c();
        if (c6 != 0 && c6 != 2) {
            return false;
        }
        return true;
    }

    private static int c() {
        Context e6 = com.beizi.fusion.c.b.a().e();
        if (e6 != null) {
            if (!ResponseInfo.getInstance(e6).isInit()) {
                ResponseInfo.getInstance(e6).init();
            }
            Manager manager = ResponseInfo.getInstance(e6).getManager();
            if (manager != null) {
                return manager.getPersonalRecommend();
            }
            return 0;
        }
        return 0;
    }

    public static boolean a() {
        int c6 = c();
        boolean isLimitPersonalAds = BeiZis.isLimitPersonalAds();
        if (c6 == 0 || c6 == 2) {
            return isLimitPersonalAds;
        }
        return false;
    }
}
