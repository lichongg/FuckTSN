package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static boolean b(long j6, long j7) {
        if (j6 > 0 && j7 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j6)).equals(simpleDateFormat.format(new Date(j7)));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        return false;
    }

    public static StatusInfo.SplashStyleControl e(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl == null || !g(sceneImpl)) {
            return null;
        }
        SplashExtraDataImpl splashExtraDataImpl = sceneImpl.splashExtraData;
        splashStyleControl.disableShake = splashExtraDataImpl.disableShake;
        splashStyleControl.disableRotate = splashExtraDataImpl.disableRotate;
        splashStyleControl.disableSlide = splashExtraDataImpl.disableSlide;
        return splashStyleControl;
    }

    public static StatusInfo.NativeAdStyleControl f(SceneImpl sceneImpl) {
        NativeAdExtraDataImpl nativeAdExtraDataImpl;
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        if (sceneImpl != null && (nativeAdExtraDataImpl = sceneImpl.nativeAdExtraData) != null) {
            nativeAdStyleControl.enableShake = nativeAdExtraDataImpl.enableShake;
            nativeAdStyleControl.enableRotate = nativeAdExtraDataImpl.enableRotate;
        }
        return nativeAdStyleControl;
    }

    private static boolean g(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }

    public static int Pq() {
        String Qv = ag.Qv();
        if (!TextUtils.isEmpty(Qv)) {
            try {
                JSONObject jSONObject = new JSONObject(Qv);
                int optInt = jSONObject.optInt("currentDailyCount");
                if (b(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                    return optInt;
                }
                return 0;
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                return 0;
            }
        }
        return 0;
    }
}
