package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends xt {
    private int xt;

    class j extends com.bytedance.msdk.xt.cw {
        private com.bytedance.msdk.cw.cw.xt.j.xt jy;
        private com.bytedance.sdk.openadsdk.i.cw.xt.xt oq;
        private Map<String, Object> qv;
        private com.bytedance.msdk.cw.m.xt.xt vl;
        private com.bytedance.msdk.api.j.xt ws;

        j(Map<String, Object> map) {
            this.qv = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.j.xt.up m105if() {
            return (com.bytedance.msdk.j.xt.up) this.ae;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(xtVar.up());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            return xtVar != null ? com.bytedance.msdk.j.cw.xt.cw(xtVar.up()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> up;
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null && (up = xtVar.up()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("coupon", up.get("coupon"));
                hashMap.put("live_room", up.get("live_room"));
                hashMap.put("product", up.get("product"));
                cw(hashMap);
            }
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void sf() {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleSplashLoader hideSkipButton   WaterfallPangleSplashLoader  mCSJSplashAd:" + this.oq);
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null) {
                xtVar.m();
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.oq == null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null) {
                xtVar.j((com.bytedance.sdk.openadsdk.r.j.xt.j.j) null);
                this.oq.j((com.bytedance.sdk.openadsdk.i.cw.j.cw) null);
                this.oq.j((com.bytedance.sdk.openadsdk.r.j.xt.j.xt) null);
                this.oq = null;
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(xtVar.up());
            }
            return 0L;
        }

        void j(Context context, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, com.bytedance.msdk.cw.cw.xt.j.xt xtVar3) {
            this.vl = xtVar2;
            this.jy = xtVar3;
            this.ws = xtVar;
            gq j6 = vl.this.j(context);
            if (j6 == null) {
                return;
            }
            Map<String, Object> map = this.qv;
            if (map == null) {
                vl.this.xt = 3000;
            } else {
                vl.this.xt = map.get("ad_load_timeout") != null ? ((Integer) this.qv.get("ad_load_timeout")).intValue() : 3000;
            }
            xt.j j7 = com.bytedance.msdk.j.cw.xt.j(this.ws, this.vl, false);
            j7.j(this.ws.ch()).xt(this.ws.s()).j(this.ws.ws()).xt(this.ws.az());
            j(j6, j7.j());
        }

        private void j(gq gqVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
            com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar = new com.bytedance.sdk.openadsdk.tj.j.xt.j.j(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.vl.j.1
                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
                public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar2) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashLoadSuccess 111");
                    if (xtVar2 == null) {
                        j.this.jy.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "渲染成功但广告是空"));
                        return;
                    }
                    j.this.oq = xtVar2;
                    j.this.ae(true);
                    j jVar2 = j.this;
                    jVar2.vl(jVar2.oq.r());
                    Map<String, Object> up = j.this.oq.up();
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleSplashLoader WaterfallPangleSplashLoader extraInfo :".concat(String.valueOf(up)));
                    if (up != null) {
                        j.this.r(up);
                    }
                    if (j.this.vl.j() && up != null) {
                        double j6 = com.bytedance.msdk.j.cw.xt.j(up.get("price"));
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", com.bytedance.msdk.j.up.up.xt(j.this.vl.xt(), j.this.vl.vl()) + "pangle Splash 返回的 cpm价格：" + j6);
                        j jVar3 = j.this;
                        if (j6 <= 0.0d) {
                            j6 = 0.0d;
                        }
                        jVar3.j(j6);
                    }
                    Function function = null;
                    j.this.oq.j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.vl.j.1.1
                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void j() {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.j();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void cw(long j7, long j8, String str, String str2) {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.xt(j7, j8, str, str2);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void xt(long j7, long j8, String str, String str2) {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.j(j7, j8, str, str2);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void j(long j7, long j8, String str, String str2) {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.j(j7, j8, (int) (j7 != 0 ? j8 / j7 : 0L), -1, str, str2);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void j(long j7, String str, String str2) {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.j(j7, str, str2);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
                        public void j(String str, String str2) {
                            if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).cw.j(str, str2);
                            }
                        }
                    });
                    j.this.oq.j(new com.bytedance.sdk.openadsdk.r.j.xt.j.j(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.vl.j.1.2
                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.j
                        public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar3) {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashAdShow");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if().up();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.j
                        public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar3) {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashAdClick");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if().r();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.j
                        public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar3, int i6) {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashAdClose closeType = ".concat(String.valueOf(i6)));
                            if (i6 == 1 || i6 == 3) {
                                if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                    j.this.m105if().j(i6);
                                }
                            } else if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if().xt(i6);
                            }
                        }
                    });
                    j.this.oq.j(new com.bytedance.sdk.openadsdk.r.j.xt.j.xt(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.vl.j.1.3
                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.xt
                        public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar3) {
                            if (xtVar3 != null) {
                                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + xtVar3.cw());
                            }
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if();
                            }
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if().k_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.xt
                        public void xt() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashCardClose");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                j.this.m105if().l_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.r.j.xt.j.xt
                        public void j() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashCardClick");
                            try {
                                if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.up) {
                                    j.this.m105if().cw();
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.vl.j(th);
                            }
                        }
                    });
                    j.this.jy.j(j.this);
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
                @MainThread
                public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar2) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashRenderSuccess");
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
                @MainThread
                public void j(com.bytedance.sdk.openadsdk.i.cw.xt.j jVar2) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashLoadFail");
                    if (jVar2 != null) {
                        j.this.jy.j(new com.bytedance.msdk.api.j(jVar2.j(), jVar2.xt()));
                    } else {
                        j.this.jy.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.j
                @MainThread
                public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar2, com.bytedance.sdk.openadsdk.i.cw.xt.j jVar2) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "new api onSplashRenderFail");
                    if (jVar2 != null) {
                        j.this.jy.j(new com.bytedance.msdk.api.j(jVar2.j(), jVar2.xt()));
                    } else {
                        j.this.jy.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }
            };
            if (gqVar != null) {
                gqVar.j(xtVar, jVar, vl.this.xt);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(ViewGroup viewGroup) {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar == null || viewGroup == null) {
                return;
            }
            xtVar.j(viewGroup);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(ViewGroup viewGroup, Activity activity) {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar = this.oq;
            if (xtVar != null) {
                xtVar.j(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar2 = this.oq;
            if (xtVar2 != null) {
                xtVar2.j(xtVar);
            }
        }
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        if (xtVar2 == null) {
            j(new com.bytedance.msdk.api.j("load ad fail adSlot is null"));
        } else {
            new j(map).j(context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : com.bytedance.msdk.core.xt.getContext(), xtVar2, xtVar, this);
        }
    }

    public vl(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
        this.xt = 3000;
    }
}
