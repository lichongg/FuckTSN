package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsButtonBorderSpreadView;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlidePopUpView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b {
    private KsSplashSlidePathView GK;
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
    private TextView Hh;
    private TextView Hi;
    private KsSlidePopUpView Hj;
    private KsButtonBorderSpreadView Hk;
    private KsShakeView Hl;
    private View Hm;
    private ImageView Hn;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private AdInfo mAdInfo;
    private long mStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void mu() {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.c(1, mv(), 53, 2);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cd() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    n.this.Hl.nx();
                }
            });
        }
        KsSlidePopUpView ksSlidePopUpView = this.Hj;
        if (ksSlidePopUpView != null) {
            ksSlidePopUpView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    n.this.Hj.nz();
                }
            });
        }
        KsButtonBorderSpreadView ksButtonBorderSpreadView = this.Hk;
        if (ksButtonBorderSpreadView != null) {
            ksButtonBorderSpreadView.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    n.this.Hk.fM();
                }
            }, 300L);
        }
        KsSlideArrowView ksSlideArrowView = this.GO;
        if (ksSlideArrowView != null) {
            ksSlideArrowView.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.9
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    n.this.GO.fM();
                }
            }, 1000L);
        }
        KsSlideArrowView ksSlideArrowView2 = this.GP;
        if (ksSlideArrowView2 != null) {
            ksSlideArrowView2.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.10
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    n.this.GP.fM();
                }
            }, 800L);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i6, String str) {
        if (this.Hi != null) {
            if (i6 != 2) {
                str = "或点击" + str;
            }
            this.Hi.setText(str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.GN = com.kwad.components.ad.splashscreen.d.a(adTemplate, el, this.Gf.mApkDownloadHelper, 9);
        TextView textView = this.Hh;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dF(el));
        }
        TextView textView2 = this.Hi;
        if (textView2 != null) {
            textView2.setText(this.GN.lA());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        View view = this.Hm;
        if (view == null || this.Gf == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 199, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(199);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        float dj = com.kwad.sdk.core.response.b.b.dj(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(dj);
            this.gX = dVar2;
            dVar2.a(this);
        } else {
            dVar.g(dj);
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bG(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(mv());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.c(1, mv(), 158, 1);
        }
    }

    static /* synthetic */ boolean a(n nVar, boolean z5) {
        nVar.GZ = true;
        return true;
    }

    static /* synthetic */ boolean b(n nVar, boolean z5) {
        nVar.GY = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        View rootView;
        this.mStartTime = SystemClock.elapsedRealtime();
        super.at();
        if (this.Gf != null && (rootView = getRootView()) != null) {
            rootView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.splashscreen.h hVar = n.this.Gf;
                    if (hVar != null) {
                        hVar.FH = SystemClock.elapsedRealtime() - n.this.mStartTime;
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
                    ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3
                        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                        public final void a(float f6, float f7, float f8, float f9) {
                            n nVar;
                            com.kwad.components.ad.splashscreen.h hVar;
                            final float px2dip = com.kwad.sdk.c.a.a.px2dip(n.this.mv(), (float) Math.sqrt(Math.pow(f8 - f6, 2.0d) + Math.pow(f9 - f7, 2.0d)));
                            if (px2dip < n.this.GQ || (hVar = (nVar = n.this).Gf) == null) {
                                return;
                            }
                            hVar.a(1, nVar.mv(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3.1
                                @Override // com.kwad.components.ad.splashscreen.h.a
                                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                                    bVar.dn(n.this.GR.style);
                                    bVar.m120do((int) px2dip);
                                }
                            });
                        }

                        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                        public final void c(MotionEvent motionEvent) {
                            if (n.this.GY && n.this.GZ) {
                                float x5 = motionEvent.getX() + n.this.GU;
                                float y5 = motionEvent.getY() + n.this.GV;
                                if (x5 >= n.this.GS && x5 <= n.this.GS + n.this.GW && y5 >= n.this.GT && y5 <= n.this.GT + n.this.GX) {
                                    n.this.mu();
                                    return;
                                }
                            }
                            if (com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo)) {
                                n.this.mu();
                            }
                        }
                    });
                    this.GK.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.4
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            n.this.GK.getLocationOnScreen(new int[2]);
                            n.this.GU = r0[0];
                            n.this.GV = r0[1];
                            n.a(n.this, true);
                        }
                    });
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        Context mv = mv();
        if (mv != null) {
            this.gZ = (Vibrator) mv.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_combo_layout);
        if (viewStub != null) {
            this.Hm = viewStub.inflate();
        } else {
            this.Hm = findViewById(R.id.ksad_shake_combo_root);
        }
        this.Hj = (KsSlidePopUpView) findViewById(R.id.ksad_shake_combo_slide_popup_view);
        this.Hh = (TextView) findViewById(R.id.ksad_shake_combo_shake_main_text);
        this.Hi = (TextView) findViewById(R.id.ksad_shake_combo_sub_text);
        this.Hl = (KsShakeView) findViewById(R.id.ksad_shake_combo_shake_icon);
        this.GO = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_top);
        this.GP = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_bottom);
        this.Hk = (KsButtonBorderSpreadView) findViewById(R.id.ksad_shake_combo_button_spread);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_shake_combo_button_background);
        this.Hn = imageView;
        imageView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.n.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                n.this.Hn.getLocationOnScreen(new int[2]);
                n.this.GS = r0[0];
                n.this.GT = r0[1];
                n.this.GW = r0.Hn.getWidth();
                n.this.GX = r0.Hn.getHeight();
                n.b(n.this, true);
            }
        });
        this.GO.setAnimationDelayTime(500);
        this.GP.setAnimationDelayTime(500);
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
        if (context == null && (view = this.Hm) != null) {
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
        com.kwad.sdk.core.d.c.d("SplashShakeComboPresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.ny();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d6) {
        boolean oW = com.kwad.components.core.e.c.b.oW();
        if (!this.Gf.Fs.wl() || oW) {
            return;
        }
        this.Hl.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                n nVar = n.this;
                com.kwad.components.ad.splashscreen.h hVar = nVar.Gf;
                if (hVar != null) {
                    hVar.a(1, nVar.mv(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d6);
                        }
                    });
                }
                n.this.Hl.nx();
            }
        });
        bw.a(mv(), this.gZ);
        mr();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
    }
}
