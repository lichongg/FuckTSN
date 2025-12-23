package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.t.p;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper UX;
    private com.kwad.components.core.video.e Vp;
    private KSCornerImageView aiA;
    private TextView aiB;
    private ScaleAnimSeekBar aiC;
    private ImageView aiD;
    private ImageView aiE;
    private ImageView aiF;
    private ViewGroup aiG;
    private ViewGroup aiH;
    private TextView aiI;
    private ViewGroup aiJ;
    private ViewGroup aiK;
    private int aiL;
    private boolean aiM;
    private boolean aiN;
    private long aiO;
    private boolean aiP;
    private KsAdVideoPlayConfig aiQ;
    private a aiR;
    private View aiS;
    private boolean aiT;
    private Runnable aiU;
    private p aiV;
    private RatioFrameLayout aiv;
    private TextView aiw;
    private TextView aix;
    private TextView aiy;
    private View aiz;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0692a cz;
    private KsAppDownloadListener dW;
    private View.OnClickListener fN;
    private TextView hA;
    private ImageView hM;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void rb();

        void rc();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.aiL = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiU = runnable;
        this.aiV = new p(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.cl(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i6) {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.dG(i6));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i6) {
                    FeedVideoView.this.aiy.setText(com.kwad.sdk.core.response.b.a.dF(i6));
                }
            };
        }
        return this.dW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        a aVar = this.aiR;
        if (aVar != null) {
            aVar.rb();
        }
        if ((this.aiL == 100) && vZ()) {
            this.aiH.setVisibility(0);
            this.aiI.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z5 = com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo);
            this.aiM = aq.dg(getContext());
            getContext();
            this.aiN = aq.QW();
            if (z5) {
                aq.dj(getContext());
            } else {
                aq.di(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.aiJ.getParent();
            this.aiK = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.aiJ);
                View view = new View(this.aiJ.getContext());
                this.aiS = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.aiJ.getWidth(), this.aiJ.getHeight()));
                viewGroup.addView(this.aiS);
            }
            aq.d(getContext(), false);
            Activity ej = m.ej(getContext());
            if (ej != null) {
                ViewGroup viewGroup2 = (ViewGroup) ej.getWindow().getDecorView();
                this.aiJ.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z5 && viewGroup2.getWidth() != 0) {
                    this.aiv.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.aiJ, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        if ((this.aiL == 101) & vZ()) {
            this.aiH.setVisibility(8);
            if (this.aiM) {
                aq.dg(getContext());
            } else {
                aq.dh(getContext());
            }
            if (this.aiN) {
                aq.dj(getContext());
            } else {
                aq.di(getContext());
            }
            aq.d(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.aiJ.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.aiJ);
            }
            this.aiJ.setLayoutParams(new ViewGroup.LayoutParams(this.aiK.getWidth(), this.aiK.getHeight()));
            this.aiv.setRatio(0.5600000023841858d);
            View view = this.aiS;
            if (view != null) {
                this.aiK.removeView(view);
                this.aiS = null;
            }
            this.aiK.addView(this.aiJ, new FrameLayout.LayoutParams(-1, -2));
            this.aiJ.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.aiR;
        if (aVar != null) {
            aVar.rc();
        }
    }

    @Override // com.kwad.components.core.widget.b
    protected final void bw() {
        this.UX = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.aiv = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.hA = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.aiC = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.aiC.setMinProgress(0);
        this.aiy = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.aiz = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.aiB = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.aiA = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.aiw = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.aix = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.aiD = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.aiF = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.aiE = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.aiG = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.aiJ = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.aiH = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.aiI = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d((FeedVideoView) adResultData);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return this.UX.dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return this.UX.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return this.UX.dispatchNestedPreScroll(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return this.UX.dispatchNestedScroll(i6, i7, i8, i9, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    protected int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.UX.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.UX.isNestedScrollingEnabled();
    }

    public final void rJ() {
        this.Vp.tQ();
    }

    public final void rN() {
        this.Vp.tT();
        this.Vp.setVisibility(0);
        this.Vp.setAlpha(1.0f);
        this.aiD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.aiF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Vp;
        if (eVar != null) {
            eVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z5) {
        this.UX.setNestedScrollingEnabled(z5);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.fN = onClickListener;
    }

    protected void setUIWithStateAndMode(int i6) {
        if (i6 == 101) {
            this.aiE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.aiE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.aiL = i6;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.aiR = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i6) {
        return this.UX.startNestedScroll(i6);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.UX.stopNestedScroll();
    }

    public final void tw() {
        this.Vp.tS();
        this.aiF.setVisibility(0);
        this.aiF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.aiD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final boolean wc() {
        if (this.aiL != 101) {
            return false;
        }
        wb();
        return true;
    }

    static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z5) {
        feedVideoView.aiT = true;
        return true;
    }

    private boolean vZ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j6 = elapsedRealtime - this.aiO;
        if (j6 > 888) {
            this.aiO = elapsedRealtime;
        }
        if (j6 > 888) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void E(View view) {
        super.E(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null && !aVar.isPlaying()) {
            rN();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.aiV);
                getHandler().postDelayed(this.aiV, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bu() {
        super.bu();
        if (this.cq != null) {
            tw();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.aiV);
                getHandler().postDelayed(this.aiV, 5000L);
            }
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.aiT = false;
        com.kwad.sdk.core.response.model.b bu = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo);
        this.aiQ = ksAdVideoPlayConfig;
        String url = bu.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        this.ck = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        this.cq = AdVideoPlayerViewCache.getInstance().eF(K);
        if (com.kwad.sdk.core.response.b.a.aq(this.mAdInfo)) {
            this.hA.setVisibility(8);
            View view = this.aiz;
            if (view != null) {
                view.setVisibility(0);
                this.aiy.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.aiB.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.aiA, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.aiy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.fN != null) {
                            FeedVideoView.this.fN.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.aiz;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.hA.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null) {
            this.cq = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ab(this.mAdInfo);
            this.cq.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).dg(com.kwad.sdk.core.response.b.e.en(this.mAdTemplate)).dh(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.em(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), null);
            a.InterfaceC0692a interfaceC0692a = new a.InterfaceC0692a() { // from class: com.kwad.components.core.widget.FeedVideoView.6
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0692a
                public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                        return null;
                    }
                    com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, FeedVideoView.this.mAdTemplate);
                    if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cz = interfaceC0692a;
            this.cq.setExternalPlayerListener(interfaceC0692a);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cq, ksAdVideoPlayConfig);
            this.Vp = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cq.setController(this.Vp);
            this.Vp.setAutoRelease(false);
            if (com.kwad.sdk.core.config.e.EP() == 2) {
                AdVideoPlayerViewCache.getInstance().a(K, this.cq);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.ck = (List) this.cq.getTag();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.cq.getController();
            this.Vp = eVar2;
            eVar2.setAutoRelease(false);
            this.Vp.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cq.getParent() != null) {
            ((ViewGroup) this.cq.getParent()).removeView(this.cq);
            this.Vp.tQ();
        }
        if (this.aiv.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.aiv;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.aiv.setTag(null);
        }
        this.aiv.addView(this.cq);
        this.aiv.setTag(this.cq);
        this.aiG.setVisibility(8);
        this.aiF.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.hA.setVisibility(8);
        } else {
            this.hA.setVisibility(0);
            this.hA.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Vp, this.cq);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiL = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiU = runnable;
        this.aiV = new p(runnable);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aiL = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(true);
                }
            }
        };
        this.aiU = runnable;
        this.aiV = new p(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.aiJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aiG.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                        if (FeedVideoView.this.aiP) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.cq.isCompleted()) {
                    FeedVideoView.this.aiG.setVisibility(0);
                    FeedVideoView.this.aiF.setVisibility(0);
                    if (FeedVideoView.this.Vp != null) {
                        FeedVideoView.this.Vp.aR(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.aiL != 101) {
                    if (FeedVideoView.this.fN != null) {
                        FeedVideoView.this.fN.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.aiG.setVisibility(0);
                FeedVideoView.this.aiF.setVisibility(8);
                if (FeedVideoView.this.Vp != null) {
                    FeedVideoView.this.Vp.aR(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiU);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (!FeedVideoView.this.aiT) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.eE) {
                    return;
                }
                this.eE = true;
                com.kwad.components.core.p.a.se().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aiG.setVisibility(8);
                FeedVideoView.this.aiF.setVisibility(8);
                FeedVideoView.this.aiC.setProgress(100);
                FeedVideoView.this.aix.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j6) {
                FeedVideoView.this.c(j6);
                float duration = (j6 * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.aiP) {
                    FeedVideoView.this.aiC.setProgress((int) duration);
                    FeedVideoView.this.aix.setText(bu.aq(j6));
                }
                FeedVideoView.this.aiw.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.aiT) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.bX(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.aiw.setText(bu.aq(aVar2.getDuration()));
            }
        });
        this.Vp.setAdClickListener(new a.InterfaceC0635a() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // com.kwad.components.core.video.a.InterfaceC0635a
            public final void a(int i6, aj.a aVar3) {
                int i7 = MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
                int i8 = 2;
                boolean z5 = false;
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            i7 = com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i8 = 1;
                            z5 = true;
                        } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                            i7 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i7 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i7 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0616a(FeedVideoView.this.getContext()).aB(FeedVideoView.this.mAdTemplate).av(true).b(FeedVideoView.this.mApkDownloadHelper).aB(i8).aq(z5).as(true).aA(i7).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.vV();
                    }
                }));
            }
        });
        this.aiC.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z5) {
                if (z5) {
                    FeedVideoView.this.aiC.bv(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.aiP = true;
                    FeedVideoView.this.aix.setText(bu.aq((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void wd() {
                FeedVideoView.this.aiC.bv(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                FeedVideoView.this.aiP = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.aiC.bv(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
                FeedVideoView.this.aiP = false;
            }
        });
        this.aiD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.Vp.tT();
                    FeedVideoView.this.aiD.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.aiF.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.Vp.tS();
                    FeedVideoView.this.aiF.setVisibility(0);
                    FeedVideoView.this.aiF.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.aiD.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
            }
        });
        this.aiF.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.cq.isPaused() || FeedVideoView.this.cq.isIdle()) {
                    FeedVideoView.this.rN();
                } else if (FeedVideoView.this.cq.isPlaying()) {
                    FeedVideoView.this.tw();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aiV);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.aiV, 5000L);
                }
            }
        });
        this.aiH.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.wb();
            }
        });
        this.aiE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.aiL == 100) {
                    FeedVideoView.this.wa();
                } else if (FeedVideoView.this.aiL == 101) {
                    FeedVideoView.this.wb();
                }
            }
        });
    }
}
