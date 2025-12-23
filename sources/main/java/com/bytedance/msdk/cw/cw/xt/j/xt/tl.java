package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.gq;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {

    private static class j extends com.bytedance.msdk.xt.cw {
        private int jy;
        private com.bytedance.sdk.openadsdk.i.cw.xt.oq vl;

        /* renamed from: g, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.ch.j.xt.j.j f24977g = new com.bytedance.sdk.openadsdk.ch.j.xt.j.j(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.j.2
            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(View view, jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).f25334j != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).f25334j.j(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void xt(View view, jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).f25334j != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).f25334j.j(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.j
            public void j(jy jyVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).f25334j != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).f25334j.j();
                }
            }
        };
        com.bytedance.sdk.openadsdk.v.j.xt.j.j oq = new com.bytedance.sdk.openadsdk.v.j.xt.j.j(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.j.3
            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void j(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void cw(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.cw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void r(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void up(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.up();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void j(int i6, int i7) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.j(new com.bytedance.msdk.api.j(i6, "Android MediaPlay Error Code :".concat(String.valueOf(i7))));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.j
            public void j(long j6, long j7) {
                if (((com.bytedance.msdk.xt.cw) j.this).xt != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).xt.j(j6, j7);
                }
            }
        };
        com.bytedance.sdk.openadsdk.i.cw.j.cw qv = new com.bytedance.sdk.openadsdk.i.cw.j.cw(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.j.4
            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void j() {
                j.this.jy = 0;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void cw(long j6, long j7, String str, String str2) {
                j.this.jy = 4;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.xt(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void xt(long j6, long j7, String str, String str2) {
                j.this.jy = 3;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.j(j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void j(long j6, long j7, String str, String str2) {
                j.this.jy = 2;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.j(j6, j7, (int) (j6 != 0 ? j7 / j6 : 0L), -1, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void j(long j6, String str, String str2) {
                j.this.jy = 5;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.j(j6, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.cw.j.cw
            public void j(String str, String str2) {
                j.this.jy = 6;
                if (((com.bytedance.msdk.xt.cw) j.this).cw != null) {
                    ((com.bytedance.msdk.xt.cw) j.this).cw.j(str, str2);
                }
            }
        };

        @Override // com.bytedance.msdk.xt.cw
        public boolean kt() {
            return true;
        }

        private void xt(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                oqVar.j(this.qv);
                try {
                    this.vl.j(new com.bytedance.sdk.openadsdk.v.j.xt.j.xt(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.j.1
                        @Override // com.bytedance.sdk.openadsdk.v.j.xt.j.xt
                        public void j(int i6) {
                            if (((com.bytedance.msdk.xt.cw) j.this).up != null) {
                                ((com.bytedance.msdk.xt.cw) j.this).up.j(i6);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
                this.vl.j(viewGroup, list, list2, list3, list4, view, this.f24977g);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public String ae() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar;
            if (!uf() || (oqVar = this.vl) == null || oqVar.xt() == null) {
                return null;
            }
            return this.vl.xt().j();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void cw() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar == null || oqVar.kt() == null) {
                return;
            }
            this.vl.kt().xt();
        }

        @Override // com.bytedance.msdk.xt.cw
        public int el() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return oqVar.cw();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.xt.cw
        public int fs() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            return oqVar != null ? oqVar.qv() : super.fs();
        }

        @Override // com.bytedance.msdk.xt.cw
        public int hu() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return oqVar.r();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.xt.cw
        public double hw() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            return oqVar != null ? oqVar.j() : super.hw();
        }

        @Override // com.bytedance.msdk.xt.cw
        public long ig() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return com.bytedance.msdk.j.cw.xt.j(oqVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public Bitmap ja() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            return oqVar != null ? oqVar.m() : super.ja();
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.r kk() {
            if (this.vl == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native : getDislikeInfo");
            return this.vl.w();
        }

        @Override // com.bytedance.msdk.xt.cw
        public String o() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return com.bytedance.msdk.j.cw.xt.cw(oqVar.f());
            }
            return null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public View oq() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return oqVar.tj();
            }
            return null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public Map<String, Object> p() {
            Map<String, Object> f6;
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar == null || (f6 = oqVar.f()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", f6.get("coupon"));
            hashMap.put("live_room", f6.get("live_room"));
            hashMap.put("product", f6.get("product"));
            cw(hashMap);
            return super.p();
        }

        @Override // com.bytedance.msdk.xt.cw
        public int r() {
            return this.jy;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.msdk.api.r.j.ae.up tl() {
            if (uf()) {
                return new com.bytedance.msdk.api.r.j.ae.up() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.j.5
                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void j(long j6) {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().j(j6);
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void xt(long j6) {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().xt(j6);
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void cw(long j6) {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().cw(j6);
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void j() {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().cw();
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void xt() {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().r();
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void j(int i6, int i7) {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().j(i6, i7);
                    }

                    @Override // com.bytedance.msdk.api.r.j.ae.up
                    public void j(long j6, int i6, int i7) {
                        if (j.this.vl == null || j.this.vl.xt() == null) {
                            return;
                        }
                        j.this.vl.xt().j(j6, i6, i7);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void uf(String str) {
            if (this.vl != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.vl.j(str);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public boolean up() {
            return this.vl == null;
        }

        @Override // com.bytedance.msdk.xt.cw
        public void w() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                oqVar.j((com.bytedance.sdk.openadsdk.v.j.xt.j.j) null);
                this.vl.x();
                this.vl = null;
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public long yb() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                return com.bytedance.msdk.j.cw.xt.xt(oqVar.f());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.vl zk() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            return oqVar != null ? oqVar.up() : super.zk();
        }

        j(com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar, boolean z5, boolean z6) {
            boolean z7;
            Map<String, Object> f6;
            this.vl = oqVar;
            com.bytedance.sdk.openadsdk.i.cw.xt.cw mi = oqVar.mi();
            if (mi != null) {
                f(mi.j());
                v(mi.cw());
                ch(mi.r());
                s(mi.xt());
                HashMap hashMap = new HashMap();
                Map<String, String> up = mi.up();
                if (up != null && up.size() > 0) {
                    hashMap.putAll(up);
                }
                up(hashMap);
                if (com.bytedance.msdk.j.cw.xt.j("5.1.0.0")) {
                    x(mi.m());
                }
                if (com.bytedance.msdk.j.cw.xt.j("5.4.0.3")) {
                    vl(mi.ae());
                }
                if (com.bytedance.msdk.j.cw.xt.j("6.8.1.6")) {
                    oq(mi.tl());
                }
                qv(mi.g());
            }
            xt(z6 ? 1 : 0);
            la(oqVar.ae());
            gq(oqVar.tl());
            p(oqVar.g());
            a(oqVar.ws() != null ? oqVar.ws().cw() : null);
            qv(oqVar.i());
            vl(oqVar.av());
            rn(oqVar.jy());
            r(oqVar.oq());
            if (oqVar.av() == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            tl(z7);
            ae(false);
            if (oqVar.i() != 16 && oqVar.i() != 3 && oqVar.i() != 2 && oqVar.i() != 131) {
                if (oqVar.i() == 4) {
                    if (oqVar.az() != null && oqVar.az().size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.bytedance.sdk.openadsdk.i.cw.xt.vl> it = oqVar.az().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().cw());
                        }
                        j((List<String>) arrayList);
                    }
                } else {
                    com.bytedance.sdk.openadsdk.i.cw.xt.vl up2 = oqVar.up();
                    if (up2 == null && oqVar.az() != null && !oqVar.az().isEmpty() && oqVar.az().get(0) != null) {
                        up2 = oqVar.az().get(0);
                    }
                    if (up2 != null) {
                        l(up2.cw());
                        mi(up2.j());
                        w(up2.xt());
                    }
                }
            } else if (oqVar.az() != null && !oqVar.az().isEmpty() && oqVar.az().get(0) != null) {
                com.bytedance.sdk.openadsdk.i.cw.xt.vl vlVar = oqVar.az().get(0);
                l(vlVar.cw());
                mi(vlVar.j());
                w(vlVar.xt());
            }
            if (z5 && (f6 = oqVar.f()) != null) {
                double j6 = com.bytedance.msdk.j.cw.xt.j(f6.get("price"));
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(j6)));
                j(j6 <= 0.0d ? 0.0d : j6);
            }
            this.vl.j(this.oq);
            this.vl.j(this.qv);
            new HashMap();
            j(MediationConstant.EXTRA_ADID, Long.valueOf(yb()));
            j(MediationConstant.EXTRA_CID, Long.valueOf(ig()));
            j("duration", Double.valueOf(this.vl.j()));
            Map<String, Object> f7 = this.vl.f();
            if (f7 != null) {
                r(f7);
                j(MediationConstant.EXTRA_LOG_EXTRA, f7.toString());
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.j(viewGroup, list, list2, list3, list4, view);
            xt(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
            this.vl.j(xtVar);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar2;
            View tj;
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar3;
            View findViewById;
            super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
            xt(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar4 = this.vl;
            if (oqVar4 != null && oqVar4.m() != null && oqVar != null && (findViewById = viewGroup.findViewById(oqVar.vl)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.vl.m());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.j.up.ae.xt(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.j.up.ae.xt(viewGroup.getContext(), 38.0f);
                    findViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ((ImageView) findViewById).setImageBitmap(this.vl.m());
                }
            }
            if ((uf() && (oqVar3 = this.vl) != null && oqVar3.xt() != null && !TextUtils.isEmpty(this.vl.xt().j())) || oqVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(oqVar.ae)) == null || (oqVar2 = this.vl) == null || (tj = oqVar2.tj()) == null) {
                return;
            }
            xt(tj);
            frameLayout.removeAllViews();
            frameLayout.addView(tj, -1, -1);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void xt(Activity activity) {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar != null) {
                oqVar.xt(activity);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void xt() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar == null || oqVar.kt() == null || this.jy != 3) {
                return;
            }
            this.vl.kt().j();
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae xt(Dialog dialog, Integer[] numArr) {
            if (this.vl == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.vl.j(dialog, numArr);
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j() {
            com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar = this.vl;
            if (oqVar == null || oqVar.kt() == null || this.jy != 2) {
                return;
            }
            this.vl.kt().j();
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
            if (this.vl != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + jVar);
                this.vl.j(activity, jVar);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public void j(Dialog dialog, Integer[] numArr) {
            if (this.vl != null) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.vl.xt(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.xt.cw
        public com.bytedance.sdk.openadsdk.i.cw.xt.ae j(Activity activity) {
            if (this.vl == null) {
                return null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.vl.j(activity);
        }
    }

    public void j(final boolean z5, gq gqVar, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.msdk.cw.cw.xt.j.xt xtVar2) {
        if (gqVar == null || xtVar2 == null || xtVar == null) {
            return;
        }
        gqVar.j(xtVar, new com.bytedance.sdk.openadsdk.tj.j.xt.j.cw(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.1
            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.cw
            public void j(int i6, String str) {
                xtVar2.j(new com.bytedance.msdk.api.j(i6, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.cw
            public void j(List<com.bytedance.sdk.openadsdk.i.cw.xt.oq> list) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + xtVar.qv());
                if (list == null || list.isEmpty()) {
                    xtVar2.j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                if (xtVar.qv()) {
                    tl.this.j(list, xtVar2, z5);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.i.cw.xt.oq> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new j(it.next(), z5, false));
                }
                xtVar2.j(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<com.bytedance.sdk.openadsdk.i.cw.xt.oq> list, final com.bytedance.msdk.cw.cw.xt.j.xt xtVar, final boolean z5) {
        final int size = list.size();
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.bytedance.sdk.openadsdk.i.cw.xt.oq oqVar : list) {
            final long currentTimeMillis = System.currentTimeMillis();
            oqVar.j(new com.bytedance.sdk.openadsdk.ch.j.xt.j.cw(null) { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.tl.2
                @Override // com.bytedance.sdk.openadsdk.ch.j.xt.j.cw
                public void j(View view, float f6, float f7, boolean z6) {
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z6 + " duration:" + (System.currentTimeMillis() - currentTimeMillis));
                    arrayList.add(new j(oqVar, z5, z6));
                    if (atomicInteger.incrementAndGet() != size || xtVar == null) {
                        return;
                    }
                    com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    xtVar.j(arrayList);
                }
            });
            oqVar.v();
        }
    }
}
