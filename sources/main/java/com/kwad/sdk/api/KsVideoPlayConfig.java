package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsVideoPlayConfig extends Serializable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public static class Builder {
        private boolean showLandscape;
        private String showScene;
        private boolean skipLongTime;
        private boolean videoSoundEnable = true;

        @KsAdSdkApi
        @Keep
        public Builder showLandscape(boolean z5) {
            this.showLandscape = z5;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder skipThirtySecond(boolean z5) {
            this.skipLongTime = z5;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z5) {
            this.videoSoundEnable = z5;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public KsVideoPlayConfig build() {
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
            ksVideoPlayConfig.setShowScene(this.showScene);
            ksVideoPlayConfig.setShowLandscape(this.showLandscape);
            ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
            ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            return ksVideoPlayConfig;
        }
    }

    @KsAdSdkApi
    @Keep
    String getShowScene();

    @KsAdSdkApi
    @Keep
    boolean isShowLandscape();

    @KsAdSdkApi
    @Keep
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setShowLandscape(boolean z5);

    @KsAdSdkApi
    @Keep
    void setShowScene(String str);

    @KsAdSdkApi
    @Keep
    void setSkipThirtySecond(boolean z5);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z5);
}
