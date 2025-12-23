package com.kwad.components.ad.nativead.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bu;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig bU;
    private AdInfo mAdInfo;
    private TextView pA;
    private ViewGroup py;
    private ImageView pz;

    private boolean e(AdInfo adInfo) {
        if (adInfo.isAllowVideoAutoPlay) {
            return true;
        }
        if (!ao.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ao.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ao.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cc(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cd(adInfo) && ao.isWifiConnected(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy() {
        if (this.py.getVisibility() != 0) {
            return;
        }
        this.py.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.pz) {
            this.pq.pr.fL();
            this.mAdInfo.isAllowVideoAutoPlay = true;
        }
    }

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.bU = ksAdVideoPlayConfig;
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate);
        this.mAdInfo = el;
        if (!e(el)) {
            this.pA.setText(bu.aq(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
            this.pz.setOnClickListener(this);
            this.pq.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.py.setVisibility(0);
        } else {
            this.py.setVisibility(8);
        }
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.a.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.fy();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.fy();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.py = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.pz = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.pA = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}
