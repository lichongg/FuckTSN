package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends xt {

    class j extends com.bytedance.msdk.xt.cw {
        private com.bytedance.msdk.api.j.xt av;
        private com.bytedance.msdk.cw.cw.xt.j.xt az;

        /* renamed from: g, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.tj.j.xt.j.r f24949g = new com.bytedance.sdk.openadsdk.tj.j.xt.j.r(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.m.j.1
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
            public void j(int i6, String str) {
                j.this.vl = false;
                j.this.az.j(new com.bytedance.msdk.api.j(i6, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
            public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar) {
                com.bytedance.msdk.j.up.cw.j("TMe", "pangle full cached 2");
                j.this.vl = true;
                j.this.az.j(j.this, (com.bytedance.msdk.api.j) null);
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
            public void j(com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar) {
                if (qvVar == null) {
                    j.this.az.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用"));
                    return;
                }
                j.this.qv = qvVar;
                j.this.ae(true);
                j jVar = j.this;
                jVar.vl(jVar.qv.j());
                Map<String, Object> xt = j.this.qv.xt();
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(xt)));
                if (j.this.ws.j() && xt != null) {
                    double j6 = com.bytedance.msdk.j.cw.xt.j(xt.get("price"));
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", com.bytedance.msdk.j.up.up.xt(j.this.ws.xt(), j.this.ws.vl()) + "pangle 全屏 返回的 cpm价格：" + j6);
                    j jVar2 = j.this;
                    if (j6 <= 0.0d) {
                        j6 = 0.0d;
                    }
                    jVar2.j(j6);
                }
                if (xt != null) {
                    j.this.r(xt);
                    Object obj = xt.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        j.this.jy = ((Boolean) obj).booleanValue();
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "pangle 全屏 返回的adnPreload：" + j.this.jy);
                    }
                }
                Function function = null;
                j.this.qv.j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.m.j.1.1
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
                j.this.qv.j(new com.bytedance.sdk.openadsdk.x.j.xt.j.j(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.m.j.1.2
                    @Override // com.bytedance.sdk.openadsdk.x.j.xt.j.j
                    public void cw() {
                        if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.xt) {
                            j.this.m103if().cw();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.x.j.xt.j.j
                    public void j() {
                        if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.xt) {
                            j.this.m103if().g_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.x.j.xt.j.j
                    public void r() {
                        if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.xt) {
                            j.this.m103if().r();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.x.j.xt.j.j
                    public void up() {
                        if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.xt) {
                            j.this.m103if().m();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.x.j.xt.j.j
                    public void xt() {
                        if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.j.xt.xt) {
                            j.this.m103if().h_();
                        }
                    }
                });
                j.this.vl = true;
                j.this.az.j(j.this);
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.r
            public void j() {
                com.bytedance.msdk.j.up.cw.j("TMe", "pangle full cached");
            }
        };
        private boolean jy;
        private com.bytedance.sdk.openadsdk.i.cw.xt.qv qv;
        private boolean vl;
        private com.bytedance.msdk.cw.m.xt.xt ws;

        @Override // com.bytedance.msdk.xt.cw
        public boolean lx() {
            return true;
        }

        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.j.xt.xt m103if() {
            return (com.bytedance.msdk.j.xt.xt) this.ae;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(qvVar.xt());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public Integer m() {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            return (qvVar == null || qvVar.r() <= System.currentTimeMillis()) ? 3 : 2;
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean nd() {
            return this.jy;
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            return qvVar != null ? com.bytedance.msdk.j.cw.xt.cw(qvVar.xt()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> xt;
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar == null || (xt = qvVar.xt()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", xt.get("coupon"));
            hashMap.put("live_room", xt.get("live_room"));
            hashMap.put("product", xt.get("product"));
            cw(hashMap);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.qv == null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar != null) {
                qvVar.j((com.bytedance.sdk.openadsdk.x.j.xt.j.j) null);
                this.qv.j((com.bytedance.sdk.openadsdk.i.cw.j.cw) null);
                this.qv.j((com.bytedance.sdk.openadsdk.i.cw.j.xt) null);
                this.qv = null;
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(qvVar.xt());
            }
            return 0L;
        }

        public void j(Context context, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, com.bytedance.msdk.cw.cw.xt.j.xt xtVar3) {
            this.ws = xtVar2;
            this.az = xtVar3;
            this.av = xtVar;
            gq j6 = m.this.j(context);
            if (j6 == null) {
                return;
            }
            xt.j j7 = com.bytedance.msdk.j.cw.xt.j(this.av, this.ws, false);
            j7.j(PredefinedCaptureConfigurations.f35652s).xt(PredefinedCaptureConfigurations.f35653t).r(this.av.rn());
            j6.j(j7.j(), this.f24949g);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, Object obj, String str) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.qv + "  activity:" + activity);
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar != null) {
                if (obj != null) {
                    qvVar.j(activity, obj, str);
                } else {
                    qvVar.j(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.sdk.openadsdk.i.cw.xt.qv qvVar = this.qv;
            if (qvVar != null) {
                qvVar.j(xtVar);
            }
        }
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        if (xtVar2 == null) {
            j(new com.bytedance.msdk.api.j("load ad fail adSlot is null"));
        } else {
            new j().j(StubApp.getOrigApplicationContext(context.getApplicationContext()), xtVar2, xtVar, this);
        }
    }

    public m(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }
}
