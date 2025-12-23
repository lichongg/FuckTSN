package com.kwad.sdk.commercial.smallApp;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z5 ? 0.1d : 0.01d).b(d.be(adTemplate)).O("ad_sdk_small_app_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
    }

    public static void b(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cF(2).cZ(smallAppJumpInfo.mediaSmallAppId).cY(smallAppJumpInfo.originId).cX(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cF(1).cZ(smallAppJumpInfo.mediaSmallAppId).cY(smallAppJumpInfo.originId).cX(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, String str, String str2, String str3) {
        try {
            a(adTemplate, b.a(jumpFrom).cF(3).cZ(str).cY(str2).cX(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, @Nullable AdInfo.SmallAppJumpInfo smallAppJumpInfo, String str) {
        String str2;
        if (adTemplate == null) {
            return;
        }
        try {
            String str3 = "";
            b cZ = b.a(jumpFrom).cF(4).cZ(smallAppJumpInfo == null ? "" : smallAppJumpInfo.mediaSmallAppId);
            if (smallAppJumpInfo == null) {
                str2 = "";
            } else {
                str2 = smallAppJumpInfo.originId;
            }
            b cY = cZ.cY(str2);
            if (smallAppJumpInfo != null) {
                str3 = smallAppJumpInfo.smallAppJumpUrl;
            }
            a(adTemplate, true, cY.cX(str3).setErrorCode(100008).setErrorMsg(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
