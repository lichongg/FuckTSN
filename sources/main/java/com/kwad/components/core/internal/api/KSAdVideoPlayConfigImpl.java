package com.kwad.components.core.internal.api;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    private static final long serialVersionUID = -154151744722615768L;
    public boolean dataFlowAutoStart;
    public boolean hasNoCache;
    public int videoAutoPlayType;
    public boolean videoSoundEnable;
    private int videoSoundValue = 0;
    private int dataFlowAutoStartValue = 0;

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setNoCache() {
        this.hasNoCache = true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.b(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
    }

    public int getDataFlowAutoStartValue() {
        return this.dataFlowAutoStartValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public int getVideoAutoPlayType() {
        return this.videoAutoPlayType;
    }

    public int getVideoSoundValue() {
        return this.videoSoundValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        return this.dataFlowAutoStart;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isNoCache() {
        return this.hasNoCache;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z5) {
        this.dataFlowAutoStart = z5;
        this.dataFlowAutoStartValue = 1;
        this.videoAutoPlayType = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoAutoPlayType(int i6) {
        this.videoAutoPlayType = i6;
        this.dataFlowAutoStartValue = 0;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z5) {
        this.videoSoundEnable = z5;
        this.videoSoundValue = 1;
    }
}
