package com.kwad.components.ad.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.k.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private com.kwad.components.core.webview.tachikoma.b.o cY;
    private a.b fD;
    private com.kwad.components.core.webview.tachikoma.i fU;
    private d.b hf;
    private d.InterfaceC0556d hg;
    private long ht;
    private float hu;
    private float hv;
    private com.kwad.components.core.widget.b iG;
    private boolean iH;
    private b.a iR;
    private KSFrameLayout jb;
    private az jc;
    private com.kwad.sdk.core.webview.c.c jd;
    private a je;
    private FrameLayout.LayoutParams jf;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mHeight;
    private boolean mIsNative;
    private int mWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void d(int i6, String str);
    }

    public r(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
    }

    private r(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN() {
        com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
        nVar.ahg = getMuteStatus();
        this.fU.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF() {
        float cY = com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate);
        if (this.hg == null) {
            this.hg = new d.InterfaceC0556d() { // from class: com.kwad.components.ad.feed.widget.r.11
                @Override // com.kwad.components.ad.feed.d.InterfaceC0556d
                public final boolean b(final double d6) {
                    if (!bz.o(r.this.jb, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !r.this.fq() || !com.kwad.components.ad.feed.d.bY()) {
                        return false;
                    }
                    com.kwad.components.core.e.d.a.a(new a.C0616a(r.this.getContext()).aB(r.this.mAdTemplate).b(r.this.mApkDownloadHelper).aB(2).aq(false).as(false).aA(157).az(5).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.11.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.ev(r.this.mAdTemplate));
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.l(d6);
                            bVar.dd(157);
                            r.this.c(bVar);
                        }
                    }));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(cY, this.mContext, this.hg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG() {
        if (this.iH) {
            return;
        }
        this.iH = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN() {
        if (this.jb != null) {
            this.jf = new FrameLayout.LayoutParams(this.jb.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO() {
        this.fU.a("setVideoPlayStatusCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.g() { // from class: com.kwad.components.ad.feed.widget.r.6
            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void a(y yVar) {
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(r.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - r.this.ht);
                com.kwad.components.core.p.a.se().g(r.this.mAdTemplate, yVar.errorCode, yVar.vE());
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bS() {
                if (com.kwad.components.core.t.a.aC(r.this.mContext).sW() && r.this.fU != null) {
                    com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                    nVar.ahg = r.this.getMuteStatus();
                    r.this.fU.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
                com.kwad.components.core.k.a.qp().a(r.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(r.this.mAdInfo), null, SystemClock.elapsedRealtime() - r.this.ht);
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bR() {
                com.kwad.components.core.k.a.qp().c(r.this.fD);
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bP() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bQ() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP() {
        if (this.jd == null) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.r.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean isNetworkConnected = ao.isNetworkConnected(r.this.mContext);
                boolean isWifiConnected = ao.isWifiConnected(r.this.mContext);
                if (r.this.bU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) r.this.bU;
                    dVar.agW = r.this.a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.agW = r.this.a(isNetworkConnected, isWifiConnected);
                }
                r.this.jd.a(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.fU;
        if (iVar == null || iVar.vt() == null) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.r.8
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean isNetworkConnected = ao.isNetworkConnected(r.this.mContext);
                boolean isWifiConnected = ao.isWifiConnected(r.this.mContext);
                if (r.this.bU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) r.this.bU;
                    dVar.agW = r.this.a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.agW = r.this.a(isNetworkConnected, isWifiConnected);
                }
                if (r.this.fU != null) {
                    r.this.fU.a("setVideoAutoPlayListener", dVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR() {
        if (this.iG == null) {
            this.mIsNative = true;
            int be = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            Context context = this.mContext;
            R r5 = this.mAdTemplate;
            com.kwad.components.core.widget.b a6 = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(r5.type, r5.defaultType), be);
            this.iG = a6;
            if (a6 != null) {
                int a7 = com.kwad.sdk.c.a.a.a(this.mContext, 16.0f);
                FrameLayout.LayoutParams layoutParams = this.jf;
                if (layoutParams != null) {
                    this.jb.setLayoutParams(layoutParams);
                }
                this.iG.setMargin(a7);
                this.jb.removeAllViews();
                this.iG.setInnerAdInteractionListener(this.iR);
                this.jb.addView(this.iG);
                a aVar = this.je;
                if (aVar != null) {
                    aVar.d(1, "");
                }
                this.iG.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.iG;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.bU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS() {
        AdMatrixInfo.RotateInfo dl = com.kwad.sdk.core.response.b.b.dl(this.mAdTemplate);
        if (this.hf == null) {
            this.hf = new d.b() { // from class: com.kwad.components.ad.feed.widget.r.12
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean s(String str) {
                    if (!bz.o(r.this.jb, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !r.this.fq() || !com.kwad.components.ad.feed.d.bY()) {
                        return false;
                    }
                    r.this.fU.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(1, str).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(dl, this.mContext, this.hf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT() {
        float cY = com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate);
        if (this.hg == null) {
            this.hg = new d.InterfaceC0556d() { // from class: com.kwad.components.ad.feed.widget.r.2
                @Override // com.kwad.components.ad.feed.d.InterfaceC0556d
                public final boolean b(double d6) {
                    if (!bz.o(r.this.jb, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !r.this.fq() || !com.kwad.components.ad.feed.d.bY()) {
                        return false;
                    }
                    r.this.fU.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(2, Double.toString(d6)).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(cY, this.mContext, this.hg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.fD == null) {
            this.fD = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.r.10
                @Override // com.kwad.components.core.k.a.c
                public final void bF() {
                }
            });
        }
        return this.fD;
    }

    private void init(Context context) {
        int a6 = com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aAZ);
        final WeakReference weakReference = new WeakReference(com.kwad.sdk.o.m.ej(context));
        this.fU = new com.kwad.components.core.webview.tachikoma.i(context, a6, a6);
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.widget.r.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                r.this.onRelease();
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRelease() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.fU;
        if (iVar != null) {
            iVar.kz();
        }
        az azVar = this.jc;
        if (azVar != null) {
            azVar.onDestroy();
        }
        d.InterfaceC0556d interfaceC0556d = this.hg;
        if (interfaceC0556d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0556d);
        }
        d.b bVar = this.hf;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
        com.kwad.components.ad.feed.d.D(this.mContext);
        com.kwad.components.ad.feed.d.E(this.mContext);
    }

    @Override // com.kwad.components.core.widget.b
    public final void W() {
        if (this.mAdTemplate.mPvReported || this.mAdTemplate.mHasAdShow) {
            return;
        }
        az azVar = this.jc;
        if (azVar != null) {
            azVar.uF();
            this.jc.uG();
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 3, 3);
        }
        if (this.fU.vt() != null) {
            setLifeStatue("showStart");
            setLifeStatue("showEnd");
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 3, 3);
        }
        b.a aVar = this.aig;
        if (aVar != null) {
            aVar.onAdShow();
            this.mAdTemplate.mHasAdShow = true;
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
    }

    @Override // com.kwad.components.core.widget.b
    public final void bw() {
        this.jb = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d((r) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.ht = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.db(this.mAdTemplate) > 0.0d) {
            this.mHeight = (int) (this.mWidth * com.kwad.sdk.core.response.b.b.db(this.mAdTemplate));
        } else {
            this.mHeight = this.jb.getHeight();
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        this.fU.a(com.kwad.sdk.o.m.ej(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.widget.r.5
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.g getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.n nVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aB() {
                r.this.fU.a("setSensorMotionType", (String) null, new com.kwad.sdk.components.m() { // from class: com.kwad.components.ad.feed.widget.r.5.7
                    @Override // com.kwad.sdk.components.m
                    public final Object call(@Nullable Object... objArr) {
                        if (objArr != null && objArr.length != 0) {
                            try {
                                Object obj = objArr[0];
                                if (obj instanceof Integer) {
                                    int intValue = ((Integer) obj).intValue();
                                    if (intValue == 1) {
                                        r.this.cS();
                                    } else if (intValue == 2) {
                                        r.this.cT();
                                    } else if (intValue == 3) {
                                        r.this.cS();
                                        r.this.cT();
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        return null;
                    }
                });
                r.this.cQ();
                r.this.cO();
                r.this.bN();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void az() {
                if (r.this.je != null) {
                    r.this.je.d(3, "");
                }
                com.kwad.sdk.core.d.c.d("TKFeedView", "TK load success, cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getRegisterViewKey() {
                return "ksad-feed-card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                r.this.cN();
                return r.this.jb;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.dU(r.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(u uVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                r.this.cR();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                if (r.this.fU.vd()) {
                    return;
                }
                tVar.c(new com.kwad.components.core.webview.tachikoma.b.n() { // from class: com.kwad.components.ad.feed.widget.r.5.1
                    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        r.this.jd = cVar2;
                        r.this.cP();
                    }
                });
                tVar.c(new x() { // from class: com.kwad.components.ad.feed.widget.r.5.2
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void a(y yVar) {
                        super.a(yVar);
                        com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(r.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - r.this.ht);
                        com.kwad.components.core.p.a.se().g(r.this.mAdTemplate, yVar.errorCode, yVar.vE());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void b(y yVar) {
                        super.b(yVar);
                        if (com.kwad.components.core.t.a.aC(r.this.mContext).sW() && r.this.cY != null) {
                            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                            nVar.ahg = true;
                            r.this.cY.c(nVar);
                        }
                        com.kwad.components.core.k.a.qp().a(r.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(r.this.mAdInfo), null, SystemClock.elapsedRealtime() - r.this.ht);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void c(y yVar) {
                        super.c(yVar);
                        com.kwad.components.core.k.a.qp().c(r.this.fD);
                    }
                });
                bb bbVar = new bb(new bb.a() { // from class: com.kwad.components.ad.feed.widget.r.5.3
                    @Override // com.kwad.components.core.webview.jshandler.bb.a
                    public final void cL() {
                        r.this.cF();
                    }
                });
                ax axVar = new ax(new ax.a() { // from class: com.kwad.components.ad.feed.widget.r.5.4
                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void c(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        r.this.a(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void d(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        r.this.b(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void e(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        r.this.a(dVar);
                        r.this.b(dVar);
                    }
                });
                tVar.c(bbVar);
                tVar.c(axVar);
                tVar.c(new z(bVar, r.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) r.this.fU, true));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (r.this.aig != null) {
                    r.this.aig.onAdClicked();
                }
                r.this.cG();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ae.a aVar) {
                aVar.width = com.kwad.sdk.c.a.a.px2dip(r.this.mContext, r.this.mWidth);
                aVar.height = com.kwad.sdk.c.a.a.px2dip(r.this.mContext, r.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aA() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.o oVar) {
                r.this.cY = oVar;
                r.this.cY.a(new o.a() { // from class: com.kwad.components.ad.feed.widget.r.5.5
                    @Override // com.kwad.components.core.webview.tachikoma.b.o.a
                    public final boolean isMuted() {
                        return r.this.getMuteStatus();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (r.this.jc != null) {
                    r.this.jc.uH();
                    r.this.jc.uI();
                }
                r.this.setLifeStatue("hideStart");
                r.this.setLifeStatue("hideEnd");
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.r.5.6
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        r.this.vW();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void f(AdTemplate adTemplate) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(az azVar) {
                r.this.jc = azVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0637a c0637a) {
                if (r.this.aig != null) {
                    String str = c0637a.acf;
                    str.getClass();
                    switch (str) {
                        case "adShowCallback":
                            r.this.aig.onAdShow();
                            break;
                        case "adDownloadConfirmTipCancel":
                        case "adDownloadConfirmTipDismiss":
                            r.this.aig.onDownloadTipsDialogDismiss();
                            break;
                        case "adCloseCallback":
                            r.this.aig.onDislikeClicked();
                            break;
                        case "adDownloadConfirmTipShow":
                            r.this.aig.onDownloadTipsDialogShow();
                            break;
                        case "adClickCallback":
                            r.this.aig.onAdClicked();
                            break;
                    }
                }
            }
        });
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    public final void setLifeStatue(String str) {
        com.kwad.components.core.webview.tachikoma.i iVar = this.fU;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.je;
        if (aVar2 != null) {
            aVar2.d(this.mIsNative ? 1 : 3, "");
        }
        this.je = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.bU = ksAdVideoPlayConfig;
        cP();
        cQ();
    }

    public final void setWidth(int i6) {
        if (i6 <= 0) {
            i6 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i6;
    }

    private r(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mIsNative = false;
        this.iR = new b.a() { // from class: com.kwad.components.ad.feed.widget.r.9
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (r.this.aig != null) {
                    r.this.aig.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, r.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (r.this.mIsNative) {
                    if (r.this.aig != null) {
                        r.this.aig.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0675a c0675a = new a.C0675a();
                    FeedType fromInt = FeedType.fromInt(r.this.mAdTemplate.type, r.this.mAdTemplate.defaultType);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0675a.templateId = String.valueOf(fromInt.getType());
                    c0675a.awW = String.valueOf(fromInt.getFeedDefaultType() == null ? 0 : fromInt.getFeedDefaultType().getDefaultType());
                    bVar.b(c0675a);
                    bVar.w(r.this.getHeight(), r.this.mWidth);
                    com.kwad.components.core.t.b.sY().a(r.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.c(r.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (r.this.aig != null) {
                    r.this.aig.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (r.this.aig != null) {
                    r.this.aig.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (r.this.aig != null) {
                    r.this.aig.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (com.kwad.components.core.k.a.b(r3.fD) == false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getMuteStatus() {
        /*
            r3 = this;
            boolean r0 = com.kwad.sdk.core.config.e.hC()
            r1 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r3.mContext
            com.kwad.components.core.t.a r0 = com.kwad.components.core.t.a.aC(r0)
            boolean r0 = r0.sW()
            if (r0 == 0) goto L14
            goto L44
        L14:
            com.kwad.components.core.k.a$b r0 = r3.fD
            if (r0 == 0) goto L24
            com.kwad.components.core.k.a.qp()
            com.kwad.components.core.k.a$b r0 = r3.fD
            boolean r0 = com.kwad.components.core.k.a.b(r0)
            if (r0 != 0) goto L24
            goto L44
        L24:
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r2 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
            if (r2 == 0) goto L3a
            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
            int r0 = r0.getVideoSoundValue()
            if (r0 == 0) goto L3a
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r0 = r0.isVideoSoundEnable()
            r0 = r0 ^ r1
            goto L45
        L3a:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.ca(r0)
            if (r0 != 0) goto L43
            goto L44
        L43:
            r1 = 0
        L44:
            r0 = r1
        L45:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            if (r1 == 0) goto L4d
            r2 = r0 ^ 1
            r1.mIsAudioEnable = r2
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.widget.r.getMuteStatus():boolean");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
        az azVar = this.jc;
        if (azVar != null) {
            azVar.uJ();
        }
        setLifeStatue("pageVisiable");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bu() {
        super.bu();
        az azVar = this.jc;
        if (azVar != null) {
            azVar.uK();
            com.kwad.components.core.k.a.qp().c(this.fD);
        }
        setLifeStatue("pageInvisiable");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.e.FM() && com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            b(motionEvent);
            if ((action == 2 || action == 3) && this.jb != null && !this.mIsNative && Math.abs(motionEvent.getX() - this.hu) > 0.0f) {
                this.jb.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.hu);
                double abs2 = Math.abs(motionEvent.getY() - this.hv);
                if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                    this.jb.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.hu = motionEvent.getX();
            this.hv = motionEvent.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        AdMatrixInfo.RotateInfo dl = com.kwad.sdk.core.response.b.b.dl(this.mAdTemplate);
        if (this.hf == null) {
            this.hf = new d.b() { // from class: com.kwad.components.ad.feed.widget.r.4
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean s(String str) {
                    if (!bz.o(r.this.jb, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !r.this.fq() || !com.kwad.components.ad.feed.d.bY()) {
                        return false;
                    }
                    dVar.p(1, str);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(dl, this.mContext, this.hf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z5, boolean z6, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i6) {
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    }
                } else {
                    return a(z5, z6);
                }
            }
            return z6;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z5, boolean z6) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        if (!com.kwad.sdk.core.response.b.a.cc(el)) {
            if (!com.kwad.sdk.core.response.b.a.cd(el)) {
                if (com.kwad.sdk.core.response.b.a.ce(el)) {
                    return false;
                }
                if (com.kwad.sdk.core.config.e.FA()) {
                }
            }
            return z6;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        float cY = com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate);
        if (this.hg == null) {
            this.hg = new d.InterfaceC0556d() { // from class: com.kwad.components.ad.feed.widget.r.3
                @Override // com.kwad.components.ad.feed.d.InterfaceC0556d
                public final boolean b(double d6) {
                    if (!bz.o(r.this.jb, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !r.this.fq() || !com.kwad.components.ad.feed.d.bY()) {
                        return false;
                    }
                    dVar.p(2, Double.toString(d6));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(cY, this.mContext, this.hg);
    }
}
