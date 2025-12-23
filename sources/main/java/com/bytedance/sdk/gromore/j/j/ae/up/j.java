package com.bytedance.sdk.gromore.j.j.ae.up;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bytedance.msdk.cw.r.vl;
import com.bytedance.sdk.gromore.j.j.up.r;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends az {
    private com.bytedance.sdk.openadsdk.a.j.xt.j.j cw;

    /* renamed from: j, reason: collision with root package name */
    private vl f27431j;
    private com.bytedance.sdk.openadsdk.a.j.xt.j.j xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public int cw() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void m() {
        vl vlVar = this.f27431j;
        if (vlVar == null) {
            return;
        }
        vlVar.j(new com.bytedance.msdk.api.r.j.tl.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.up.j.1
            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(com.bytedance.msdk.api.j jVar) {
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void cw() {
                if (j.this.xt != null) {
                    j.this.xt.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void i_() {
                if (j.this.xt != null) {
                    j.this.xt.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(com.bytedance.msdk.api.cw.j jVar) {
                j jVar2 = j.this;
                jVar2.j(jVar, jVar2.xt, "CSJMRewardAd normal");
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j_() {
                if (j.this.xt != null) {
                    j.this.xt.xt();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void m() {
                if (j.this.xt != null) {
                    j.this.xt.m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void r() {
                if (j.this.xt != null) {
                    j.this.xt.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void up() {
                if (j.this.xt != null) {
                    j.this.xt.up();
                }
            }
        });
        this.f27431j.xt(new com.bytedance.msdk.api.r.j.tl.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.up.j.2
            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(com.bytedance.msdk.api.j jVar) {
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void cw() {
                if (j.this.cw != null) {
                    j.this.cw.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void i_() {
                if (j.this.cw != null) {
                    j.this.cw.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(com.bytedance.msdk.api.cw.j jVar) {
                j jVar2 = j.this;
                jVar2.j(jVar, jVar2.cw, "CSJMRewardAd play again");
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j_() {
                if (j.this.cw != null) {
                    j.this.cw.xt();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void m() {
                if (j.this.cw != null) {
                    j.this.cw.m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void r() {
                if (j.this.cw != null) {
                    j.this.cw.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void up() {
                if (j.this.cw != null) {
                    j.this.cw.up();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public m up() {
        return new com.bytedance.sdk.gromore.j.j.up.j(new xt(this.f27431j));
    }

    public j(vl vlVar) {
        this.f27431j = vlVar;
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void xt(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        this.cw = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public Map<String, Object> xt() {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            return vlVar.w();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.msdk.api.cw.j jVar, com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar2, String str) {
        Bundle bundle;
        String str2;
        r.j(jVar, str);
        if (jVar2 == null || jVar == null) {
            return;
        }
        boolean j6 = jVar.j();
        float xt = jVar.xt();
        String cw = jVar.cw();
        Map<String, Object> r5 = jVar.r();
        if (r5 == null) {
            r5 = new HashMap<>();
        }
        Object obj = r5.get(MediationConstant.KEY_REWARD_TYPE);
        int i6 = 0;
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = r5.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, cw);
        bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, xt);
        Object obj3 = r5.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj3 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj3).booleanValue());
        }
        Object obj4 = r5.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = r5.get(MediationConstant.KEY_REASON);
        if (obj5 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj5).intValue());
        }
        Object obj6 = r5.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = r5.get("errorCode");
        if (obj7 instanceof Integer) {
            Integer num = (Integer) obj7;
            i6 = num.intValue();
            bundle.putInt("errorCode", num.intValue());
        }
        Object obj8 = r5.get(MediationConstant.KEY_ERROR_MSG);
        if (obj8 instanceof String) {
            String str3 = (String) obj8;
            bundle.putString(MediationConstant.KEY_ERROR_MSG, str3);
            str2 = str3;
        } else {
            str2 = "";
        }
        Object obj9 = r5.get(MediationConstant.KEY_ADN_NAME);
        if (obj9 instanceof String) {
            bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj9);
        }
        Object obj10 = r5.get("ecpm");
        if (obj10 instanceof String) {
            bundle.putString("ecpm", (String) obj10);
        }
        jVar2.j(j6, intValue, bundle);
        if (com.bytedance.msdk.j.cw.xt.j("6.4.0.0")) {
            jVar2.j(j6, (int) xt, cw != null ? cw : "", i6, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public long r() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar) {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            vlVar.j(xtVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(final com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            vlVar.j(new com.bytedance.msdk.api.r.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.up.j.3
                @Override // com.bytedance.msdk.api.r.j.xt
                public void j() {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j();
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt() {
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void xt(long j6, long j7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.cw(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, int i6, int i7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, long j7, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.xt(j6, j7, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(long j6, @Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(j6, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.xt
                public void j(@Nullable String str, @Nullable String str2) {
                    com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(Activity activity) {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            vlVar.j(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(Activity activity, Object obj, String str) {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            vlVar.j(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public int j() {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            return vlVar.i();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        vl vlVar = this.f27431j;
        if (vlVar != null) {
            vlVar.j(xtVar);
        }
    }
}
