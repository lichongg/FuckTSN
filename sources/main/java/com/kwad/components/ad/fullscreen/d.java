package com.kwad.components.ad.fullscreen;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.components.ad.reward.e.c {
    private boolean jm = false;
    private AdTemplate mAdTemplate;
    private c mInteractionListener;

    private void onAdClosed() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClosed();
        }
    }

    private void onAdShow() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdShow();
        }
    }

    public final void a(c cVar) {
        this.mInteractionListener = cVar;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void cW() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i6, int i7) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayError(i6, i7);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayStart();
        }
        if (!this.jm) {
            this.jm = true;
            onAdShow();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j6) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onSkippedVideo();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z5) {
        onAdClosed();
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }
}
