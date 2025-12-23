package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean jk = com.kwad.components.ad.reward.a.b.hN();

    @Nullable
    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (e.Gg()) {
            ksVideoPlayConfig = com.kwad.components.core.internal.api.e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData d6 = f.ol().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (d6 == null) {
                return null;
            }
            return a(d6, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public final AdInfo cU() {
        return this.mAdInfo;
    }

    public final boolean cV() {
        return com.kwad.sdk.core.response.b.e.ex(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final AdResultData iu() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig iv() {
        return this.mVideoPlayConfig;
    }

    public final int iw() {
        return this.rewardType;
    }

    public final JSONObject ix() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo iy() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!e.Gg() && com.kwad.sdk.core.response.b.e.eB(adTemplate) < 0) {
            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.K(adInfo));
            if (cf == null || !cf.exists()) {
                return false;
            }
        }
        return true;
    }

    public final boolean is() {
        return com.kwad.sdk.core.response.b.e.k(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(cU()));
    }

    public final boolean it() {
        return com.kwad.sdk.core.response.b.e.O(getAdTemplate());
    }

    @Nullable
    private static c a(AdResultData adResultData, int i6, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        if (r5 == null) {
            com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo el = com.kwad.sdk.core.response.b.e.el(r5);
        if (!c(r5, el)) {
            return null;
        }
        boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
        r5.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = r5;
        cVar.mAdInfo = el;
        cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
        cVar.rewardType = i6;
        return cVar;
    }
}
