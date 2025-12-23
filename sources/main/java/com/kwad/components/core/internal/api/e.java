package com.kwad.components.core.internal.api;

import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static String a(KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksVideoPlayConfig == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "showScene", ksVideoPlayConfig.getShowScene());
            aa.putValue(jSONObject, "showLandscape", ksVideoPlayConfig.isShowLandscape());
            aa.putValue(jSONObject, "skipThirtySecond", ksVideoPlayConfig.isSkipThirtySecond());
            aa.putValue(jSONObject, "videoSoundEnable", ksVideoPlayConfig.isVideoSoundEnable());
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static VideoPlayConfigImpl b(String str, boolean z5) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            VideoPlayConfigImpl videoPlayConfigImpl = new VideoPlayConfigImpl();
            videoPlayConfigImpl.setShowScene(jSONObject.optString("showScene", null));
            videoPlayConfigImpl.setShowLandscape(jSONObject.optBoolean("showLandscape", false));
            videoPlayConfigImpl.setSkipThirtySecond(jSONObject.optBoolean("skipThirtySecond", false));
            videoPlayConfigImpl.setVideoSoundEnable(jSONObject.optBoolean("videoSoundEnable", true));
            return videoPlayConfigImpl;
        } catch (Exception unused) {
            return new VideoPlayConfigImpl();
        }
    }
}
