package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsVideoPlayConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class VideoPlayConfigImpl implements KsVideoPlayConfig {
    private static final long serialVersionUID = -7203854889686049813L;
    private boolean showLandscape;
    private String showScene;
    private boolean skipThirtySecond;
    private boolean videoSoundEnable = true;

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.b(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public String getShowScene() {
        return this.showScene;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isShowLandscape() {
        return this.showLandscape;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isSkipThirtySecond() {
        return this.skipThirtySecond;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowLandscape(boolean z5) {
        this.showLandscape = z5;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setShowScene(String str) {
        this.showScene = str;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setSkipThirtySecond(boolean z5) {
        this.skipThirtySecond = z5;
    }

    @Override // com.kwad.sdk.api.KsVideoPlayConfig
    public void setVideoSoundEnable(boolean z5) {
        this.videoSoundEnable = z5;
    }
}
