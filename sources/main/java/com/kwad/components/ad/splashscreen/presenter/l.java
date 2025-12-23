package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateTypeTwoView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView GI;
    private KsSlideRoundView GJ;
    private KsSplashSlidePathView GK;
    private KsRotateTypeTwoView GL;
    private View GM;
    private com.kwad.components.ad.splashscreen.d GN;
    private KsSlideArrowView GO;
    private KsSlideArrowView GP;
    private double GQ;
    private AdMatrixInfo.SplashSlideInfo GR;
    private float GS;
    private float GT;
    private float GU;
    private float GV;
    private float GW;
    private float GX;
    private boolean GY = false;
    private boolean GZ = false;
    private com.kwad.sdk.core.g.c gY;
    private AdInfo mAdInfo;
    private long mStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void mu() {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.c(1, mv(), 53, 2);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ce() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        KsSlideArrowView ksSlideArrowView = this.GO;
        if (ksSlideArrowView != null && this.GP != null) {
            ksSlideArrowView.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    l.this.GO.fM();
                }
            }, 200L);
            this.GP.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    l.this.GP.fM();
                }
            });
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.GL;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    l.this.GL.fM();
                }
            });
        }
        KsSlideRoundView ksSlideRoundView = this.GJ;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    l.this.GJ.fM();
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i6, String str) {
        if (this.GI != null) {
            if (i6 != 2) {
                str = "扭动或点击" + str;
            }
            this.GI.setText(str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_combo_layout);
        if (viewStub != null) {
            this.GM = viewStub.inflate();
        } else {
            this.GM = findViewById(R.id.ksad_rotate_combo_root);
        }
        this.GJ = (KsSlideRoundView) findViewById(R.id.ksad_rotate_combo_slide_round_img);
        this.GI = (TextView) findViewById(R.id.ksad_rotate_combo_action_text);
        this.GL = (KsRotateTypeTwoView) findViewById(R.id.ksad_rotate_combo_rotate_view);
        this.GO = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_top);
        this.GP = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_bottom);
        this.GO.setAnimationDelayTime(200);
        this.GP.setAnimationDelayTime(200);
        this.GJ.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                l.this.GJ.getLocationOnScreen(new int[2]);
                l.this.GS = r0[0];
                l.this.GT = r0[1];
                l.this.GW = r0.GJ.getWidth();
                l.this.GX = r0.GJ.getHeight();
                l.b(l.this, true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        com.kwad.components.ad.splashscreen.d a6 = com.kwad.components.ad.splashscreen.d.a(adTemplate, com.kwad.sdk.core.response.b.e.el(adTemplate), this.Gf.mApkDownloadHelper, 10);
        this.GN = a6;
        TextView textView = this.GI;
        if (textView != null) {
            textView.setText(a6.lA());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        View view = this.GM;
        if (view == null || this.Gf == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 200, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(200);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        AdMatrixInfo.RotateInfo dk = com.kwad.sdk.core.response.b.b.dk(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(dk);
            this.gY = cVar2;
            cVar2.a(this);
        } else {
            cVar.b(dk);
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.GL;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bG(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.c(1, mv(), 162, 1);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void r(final String str) {
        boolean wl = this.Gf.Fs.wl();
        boolean oW = com.kwad.components.core.e.c.b.oW();
        if (!wl || oW) {
            return;
        }
        this.GO.nw();
        this.GP.nw();
        this.GJ.nw();
        this.GL.nw();
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.a(1, mv(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.9
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dv(str);
                }
            });
        }
        mt();
        mr();
    }

    static /* synthetic */ boolean a(l lVar, boolean z5) {
        lVar.GZ = true;
        return true;
    }

    static /* synthetic */ boolean b(l lVar, boolean z5) {
        lVar.GY = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        View rootView;
        this.mStartTime = SystemClock.elapsedRealtime();
        super.at();
        if (this.Gf != null && (rootView = getRootView()) != null) {
            rootView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.splashscreen.h hVar = l.this.Gf;
                    if (hVar != null) {
                        hVar.FH = SystemClock.elapsedRealtime() - l.this.mStartTime;
                    }
                }
            });
            this.Gf.a(this);
            AdInfo el = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
            this.mAdInfo = el;
            try {
                this.GR = el.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
                this.GQ = r0.convertDistance;
                ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
                if (viewStub != null) {
                    this.GK = (KsSplashSlidePathView) viewStub.inflate();
                } else {
                    this.GK = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
                }
                KsSplashSlidePathView ksSplashSlidePathView = this.GK;
                if (ksSplashSlidePathView != null) {
                    ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2
                        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                        public final void a(float f6, float f7, float f8, float f9) {
                            l lVar;
                            com.kwad.components.ad.splashscreen.h hVar;
                            final float px2dip = com.kwad.sdk.c.a.a.px2dip(l.this.mv(), (float) Math.sqrt(Math.pow(f8 - f6, 2.0d) + Math.pow(f9 - f7, 2.0d)));
                            if (px2dip < l.this.GQ || (hVar = (lVar = l.this).Gf) == null) {
                                return;
                            }
                            hVar.a(1, lVar.mv(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2.1
                                @Override // com.kwad.components.ad.splashscreen.h.a
                                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                                    bVar.dn(l.this.GR.style);
                                    bVar.m120do((int) px2dip);
                                }
                            });
                        }

                        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                        public final void c(MotionEvent motionEvent) {
                            if (l.this.GY && l.this.GZ) {
                                float x5 = motionEvent.getX() + l.this.GU;
                                float y5 = motionEvent.getY() + l.this.GV;
                                if (x5 >= l.this.GS && x5 <= l.this.GS + l.this.GW && y5 >= l.this.GT && y5 <= l.this.GT + l.this.GX) {
                                    l.this.mu();
                                    return;
                                }
                            }
                            if (com.kwad.components.ad.splashscreen.h.n(l.this.mAdInfo)) {
                                l.this.mu();
                            }
                        }
                    });
                    this.GK.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.l.3
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            l.this.GK.getLocationOnScreen(new int[2]);
                            l.this.GU = r0[0];
                            l.this.GV = r0[1];
                            l.a(l.this, true);
                        }
                    });
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
    }

    @Nullable
    protected final Context mv() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        if (context == null && (view = this.GM) != null) {
            return view.getContext();
        }
        return context;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotateComboPresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
    }
}
