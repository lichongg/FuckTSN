package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv extends xt {
    private com.bytedance.msdk.cw.m.xt.xt cw;
    private com.bytedance.msdk.api.j.xt xt;

    class j extends com.bytedance.msdk.xt.cw {

        /* renamed from: g, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.tj.j.xt.j.ae f24953g = new AnonymousClass1(null);
        private Map<String, Object> jy;
        private az qv;
        private boolean vl;

        /* renamed from: com.bytedance.msdk.cw.cw.xt.j.xt.qv$j$1, reason: invalid class name */
        class AnonymousClass1 extends com.bytedance.sdk.openadsdk.tj.j.xt.j.ae {
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
            public void j(int i6, String str) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward_onError code:" + i6 + "  message:" + str);
                qv.this.j(new com.bytedance.msdk.api.j(i6, str));
            }

            AnonymousClass1(Function function) {
                super(function);
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
            public void xt(az azVar) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward_onRewardVideoCached 2");
                j jVar = j.this;
                qv.this.j(jVar, (com.bytedance.msdk.api.j) null);
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
            public void j(az azVar) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward_onRewardVideoAdLoad");
                if (azVar != null) {
                    j.this.qv = azVar;
                    j.this.ae(true);
                    j jVar = j.this;
                    jVar.vl(jVar.qv.j());
                    Map<String, Object> xt = j.this.qv.xt();
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(xt)));
                    if (qv.this.cw.j() && xt != null) {
                        double j6 = com.bytedance.msdk.j.cw.xt.j(xt.get("price"));
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", com.bytedance.msdk.j.up.up.xt(qv.this.cw.xt(), qv.this.cw.vl()) + "pangle reward 返回的 cpm价格：" + j6);
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
                            j.this.vl = ((Boolean) obj).booleanValue();
                            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "pangle 激励 返回的adnPreload：" + j.this.vl);
                        }
                    }
                    Function function = null;
                    j.this.qv.j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.1
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
                    j.this.qv.xt(new com.bytedance.sdk.openadsdk.a.j.xt.j.j(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.2
                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void j() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdShow-----------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void cw() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdClose-----------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().cw();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void m() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onSkippedVideo-------------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().m();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void r() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onVideoComplete----------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().r();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void up() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onVideoError-----------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().up();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void xt() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick---------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        @Deprecated
                        public void j(final boolean z5, final int i6, final String str, final int i7, final String str2) {
                            if (j.this.to()) {
                                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                    j.this.m104if().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.2.1
                                        @Override // com.bytedance.msdk.api.cw.j
                                        public String cw() {
                                            return !TextUtils.isEmpty(str) ? str : qv.this.xt != null ? qv.this.xt.p() : "";
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public boolean j() {
                                            return z5;
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public Map<String, Object> r() {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("errorCode", Integer.valueOf(i7));
                                            hashMap.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return hashMap;
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public float xt() {
                                            int i8 = i6;
                                            if (i8 >= 0) {
                                                return i8;
                                            }
                                            if (qv.this.xt != null) {
                                                return qv.this.xt.h();
                                            }
                                            return 0.0f;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void j(final boolean z5, final int i6, final Bundle bundle) {
                            if (j.this.to()) {
                                return;
                            }
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onRewardArrived-------------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.m104if().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.2.2
                                    @Override // com.bytedance.msdk.api.cw.j
                                    public String cw() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : qv.this.xt != null ? qv.this.xt.p() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public boolean j() {
                                        return z5;
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public Map<String, Object> r() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        hashMap.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i6));
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public float xt() {
                                        float f6 = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f6 >= 0.0f) {
                                            return f6;
                                        }
                                        if (qv.this.xt != null) {
                                            return qv.this.xt.h();
                                        }
                                        return 0.0f;
                                    }
                                });
                            }
                        }
                    });
                    j.this.qv.j(new com.bytedance.sdk.openadsdk.a.j.xt.j.j(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.3
                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void j() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdShow");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void cw() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdClose");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().cw();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void m() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onSkippedVideo");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().m();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void r() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onVideoComplete");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().r();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void up() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onVideoError");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().up();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void xt() {
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        @Deprecated
                        public void j(final boolean z5, final int i6, final String str, final int i7, final String str2) {
                            if (j.this.to()) {
                                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                    j.this.os().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.3.1
                                        @Override // com.bytedance.msdk.api.cw.j
                                        public String cw() {
                                            return !TextUtils.isEmpty(str) ? str : qv.this.xt != null ? qv.this.xt.p() : "";
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public boolean j() {
                                            return z5;
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public Map<String, Object> r() {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("errorCode", Integer.valueOf(i7));
                                            hashMap.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return hashMap;
                                        }

                                        @Override // com.bytedance.msdk.api.cw.j
                                        public float xt() {
                                            int i8 = i6;
                                            if (i8 >= 0) {
                                                return i8;
                                            }
                                            if (qv.this.xt != null) {
                                                return qv.this.xt.h();
                                            }
                                            return 0.0f;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.j.xt.j.j
                        public void j(final boolean z5, final int i6, final Bundle bundle) {
                            if (j.this.to()) {
                                return;
                            }
                            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward:onRewardArrived-------------2");
                            if (((com.bytedance.msdk.xt.cw) j.this).ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                                j.this.os().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.1.3.2
                                    @Override // com.bytedance.msdk.api.cw.j
                                    public String cw() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : qv.this.xt != null ? qv.this.xt.p() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public boolean j() {
                                        return z5;
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public Map<String, Object> r() {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        hashMap.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i6));
                                        return hashMap;
                                    }

                                    @Override // com.bytedance.msdk.api.cw.j
                                    public float xt() {
                                        float f6 = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f6 >= 0.0f) {
                                            return f6;
                                        }
                                        if (qv.this.xt != null) {
                                            return qv.this.xt.h();
                                        }
                                        return 0.0f;
                                    }
                                });
                            }
                        }
                    });
                    j jVar3 = j.this;
                    qv.this.j(jVar3);
                    return;
                }
                qv.this.j(new com.bytedance.msdk.api.j("请求成功，但无广告可用"));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.ae
            public void j() {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "pangle_reward_onRewardVideoCached");
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean lx() {
            return true;
        }

        j(Map<String, Object> map) {
            this.jy = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: if, reason: not valid java name */
        public com.bytedance.msdk.api.r.j.tl.j m104if() {
            return (com.bytedance.msdk.api.r.j.tl.j) this.tl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.r.j.tl.j os() {
            return (com.bytedance.msdk.api.r.j.tl.j) this.ae;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean to() {
            return !cm.f10901d.equals(qv.this.j(MediationConstant.ADN_PANGLE)) && "4.4.0.0".compareTo(qv.this.j(MediationConstant.ADN_PANGLE)) > 0;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            az azVar = this.qv;
            if (azVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(azVar.xt());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public Integer m() {
            az azVar = this.qv;
            return (azVar == null || azVar.r() <= System.currentTimeMillis()) ? 3 : 2;
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean nd() {
            return this.vl;
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            az azVar = this.qv;
            return azVar != null ? com.bytedance.msdk.j.cw.xt.cw(azVar.xt()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            az azVar = this.qv;
            if (azVar != null) {
                cw(azVar.xt());
            }
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.qv == null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            az azVar = this.qv;
            if (azVar != null) {
                azVar.j((com.bytedance.sdk.openadsdk.i.cw.j.cw) null);
                this.qv.j((com.bytedance.sdk.openadsdk.a.j.xt.j.j) null);
                this.qv.j((com.bytedance.sdk.openadsdk.i.cw.j.xt) null);
                this.qv = null;
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            az azVar = this.qv;
            if (azVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(azVar.xt());
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void j(android.content.Context r9) {
            /*
                r8 = this;
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r0 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.sdk.openadsdk.core.gq r9 = r0.j(r9)
                if (r9 != 0) goto L9
                return
            L9:
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r0 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r0 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r0)
                java.util.Map r0 = r0.c()
                if (r0 == 0) goto L28
                java.lang.String r1 = "pangle"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.String
                if (r1 == 0) goto L28
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L28
                goto L2a
            L28:
                java.lang.String r0 = ""
            L2a:
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r1)
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.cw.m.xt.xt r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.xt(r1)
                java.lang.String r3 = r1.vl()
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.cw.m.xt.xt r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.xt(r1)
                java.lang.String r4 = r1.av()
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.cw.m.xt.xt r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.xt(r1)
                java.lang.String r5 = r1.i()
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.cw.m.xt.xt r1 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.xt(r1)
                java.lang.String r6 = r1.ch()
                r7 = 0
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r1 = com.bytedance.msdk.j.cw.xt.j(r2, r3, r4, r5, r6, r7)
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r2)
                java.lang.String r2 = r2.gq()
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r2 = r1.m(r2)
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r0 = r2.up(r0)
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r2)
                java.lang.String r2 = r2.p()
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r0 = r0.oq(r2)
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r2)
                int r2 = r2.h()
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r0 = r0.tl(r2)
                r2 = 1080(0x438, float:1.513E-42)
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r0 = r0.j(r2)
                r2 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.i.cw.cw.xt$j r0 = r0.xt(r2)
                com.bytedance.msdk.cw.cw.xt.j.xt.qv r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.this
                com.bytedance.msdk.api.j.xt r2 = com.bytedance.msdk.cw.cw.xt.j.xt.qv.j(r2)
                int r2 = r2.rn()
                r0.r(r2)
                com.bytedance.sdk.openadsdk.i.cw.cw.xt r0 = r1.j()
                com.bytedance.sdk.openadsdk.tj.j.xt.j.ae r1 = r8.f24953g
                r9.j(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.cw.xt.j.xt.qv.j.j(android.content.Context):void");
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, Object obj, String str) {
            az azVar = this.qv;
            if (azVar != null) {
                if (obj != null) {
                    azVar.j(activity, obj, str);
                } else {
                    azVar.j(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Object obj) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setRewardAdPlayAgainController rewardAdPlayAgainController:" + obj + "  mTTRewardVideoAd: " + this.qv);
            az azVar = this.qv;
            if (azVar == null || !(obj instanceof com.bytedance.sdk.openadsdk.a.j.xt.j.xt)) {
                return;
            }
            azVar.j((com.bytedance.sdk.openadsdk.a.j.xt.j.xt) obj);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + xtVar + "  mTTRewardVideoAd: " + this.qv);
            az azVar = this.qv;
            if (azVar != null) {
                azVar.j(xtVar);
            }
        }
    }

    public void cw() {
        j(new com.bytedance.msdk.api.j("load ad fail adSlot is null"));
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        this.xt = xtVar2;
        this.cw = xtVar;
        if (xtVar2 == null) {
            cw();
        } else {
            new j(map).j(context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : com.bytedance.msdk.core.xt.getContext());
        }
    }

    public qv(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }
}
