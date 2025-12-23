package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static boolean PM;

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.j(adTemplate, 1);
            return 0;
        }
        Cursor cursor = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (query != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(query);
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bw.s(th));
                        com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th2) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        throw th2;
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            com.kwad.sdk.crash.utils.b.closeQuietly(query);
            return 1;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean E(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aC(boolean z5) {
        PM = z5;
    }

    private static boolean pW() {
        return PM;
    }

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.S(el)) {
            return 0;
        }
        return a(context, el.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    private static void a(final JumpFrom jumpFrom, final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (pW()) {
            return;
        }
        aC(true);
        int abs = Math.abs(com.kwad.sdk.core.config.e.Fo());
        if (abs > 0) {
            bw.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.aC(false);
                    com.kwad.sdk.core.c.b.Ho();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.smallApp.a.a(AdTemplate.this, jumpFrom, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            aC(false);
        }
    }
}
