package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    private static class j extends com.bytedance.msdk.xt.cw {

        /* renamed from: g, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.s.j.xt.j.xt f24969g;
        com.bytedance.sdk.openadsdk.s.j.xt.j.cw oq;
        private ws qv;

        @Override // com.bytedance.msdk.xt.cw
        public boolean kt() {
            return true;
        }

        @Override // com.bytedance.msdk.xt.cw
        public View g() {
            ws wsVar = this.qv;
            if (wsVar != null) {
                return wsVar.j();
            }
            return null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            ws wsVar = this.qv;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(wsVar.tl());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
            if (this.qv != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + jVar);
                this.qv.j(activity, jVar);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
            ws wsVar = this.qv;
            return wsVar != null ? wsVar.m() : super.kk();
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            ws wsVar = this.qv;
            return wsVar != null ? com.bytedance.msdk.j.cw.xt.cw(wsVar.tl()) : "";
        }

        @Override // com.bytedance.msdk.xt.cw
        public void oq(boolean z5) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express : setCanInterruptVideoPlay b = ".concat(String.valueOf(z5)));
            ws wsVar = this.qv;
            if (wsVar != null) {
                wsVar.j(z5);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> tl;
            ws wsVar = this.qv;
            if (wsVar == null || (tl = wsVar.tl()) == null) {
                return null;
            }
            cw(tl);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void qv() {
            ws wsVar = this.qv;
            if (wsVar != null) {
                wsVar.r();
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void uf(String str) {
            if (this.qv != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.qv.j(str);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.qv == null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            ws wsVar = this.qv;
            if (wsVar != null) {
                wsVar.up();
                this.qv = null;
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            ws wsVar = this.qv;
            if (wsVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(wsVar.tl());
            }
            return 0L;
        }

        j(ws wsVar, boolean z5) {
            Map<String, Object> tl;
            Function function = null;
            this.f24969g = new com.bytedance.sdk.openadsdk.s.j.xt.j.xt(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.r.j.1
                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, int i6) {
                    if (((com.bytedance.msdk.xt.cw) j.this).f25337m != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).f25337m.j(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void xt(View view, int i6) {
                    if (((com.bytedance.msdk.xt.cw) j.this).f25337m != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).f25337m.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, String str, int i6) {
                    if (((com.bytedance.msdk.xt.cw) j.this).f25337m instanceof com.bytedance.msdk.api.r.j.cw.r) {
                        ((com.bytedance.msdk.api.r.j.cw.r) ((com.bytedance.msdk.xt.cw) j.this).f25337m).j(view, str, i6);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.xt
                public void j(View view, float f6, float f7) {
                    if (((com.bytedance.msdk.xt.cw) j.this).f25337m instanceof com.bytedance.msdk.api.r.j.cw.r) {
                        ((com.bytedance.msdk.api.r.j.cw.r) ((com.bytedance.msdk.xt.cw) j.this).f25337m).j(f6, f7);
                    }
                }
            };
            this.oq = new com.bytedance.sdk.openadsdk.s.j.xt.j.cw(function) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.r.j.2
                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void j() {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void cw() {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.cw();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void r() {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.r();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void up() {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.up();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void xt() {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.xt();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void j(int i6, int i7) {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.j(new com.bytedance.msdk.api.j(i6, "MediaPlayer inter error code:".concat(String.valueOf(i7))));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.s.j.xt.j.cw
                public void j(long j6, long j7) {
                    if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                        ((com.bytedance.msdk.xt.cw) j.this).xt.j(j6, j7);
                    }
                }
            };
            this.qv = wsVar;
            qv(wsVar.xt());
            vl(this.qv.cw());
            ae(true);
            if (z5 && (tl = wsVar.tl()) != null) {
                double j6 = com.bytedance.msdk.j.cw.xt.j(tl.get("price"));
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：".concat(String.valueOf(j6)));
                j(j6 <= 0.0d ? 0.0d : j6);
            }
            this.qv.j(this.f24969g);
            this.qv.j(this.oq);
            j(MediationConstant.EXTRA_ADID, Long.valueOf(yb()));
            j(MediationConstant.EXTRA_CID, Long.valueOf(ig()));
            Map<String, Object> tl2 = this.qv.tl();
            if (tl2 != null) {
                r(tl2);
                j(MediationConstant.EXTRA_LOG_EXTRA, tl2.toString());
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Dialog dialog, Integer[] numArr) {
            if (this.qv != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.qv.j(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
            ws wsVar = this.qv;
            if (wsVar != null) {
                return wsVar.j(activity);
            }
            return super.j(activity);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(cwVar)));
            ws wsVar = this.qv;
            if (wsVar != null) {
                wsVar.j(cwVar);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle draw express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(xtVar)));
            ws wsVar = this.qv;
            if (wsVar != null) {
                wsVar.j(xtVar);
            }
        }
    }

    public void j(final boolean z5, gq gqVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.msdk.cw.cw.xt.j.xt xtVar2) {
        if (gqVar == null || xtVar2 == null) {
            return;
        }
        gqVar.xt(xtVar, new com.bytedance.sdk.openadsdk.tj.j.xt.j.m(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.r.1
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
            public void j(int i6, String str) {
                xtVar2.j(new com.bytedance.msdk.api.j(i6, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
            public void j(List<ws> list) {
                if (list == null || list.size() == 0) {
                    xtVar2.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ws wsVar : list) {
                    if (wsVar != null) {
                        arrayList.add(new j(wsVar, z5));
                    }
                }
                xtVar2.j(arrayList);
            }
        });
    }
}
