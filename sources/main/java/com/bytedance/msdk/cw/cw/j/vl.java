package com.bytedance.msdk.cw.cw.j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl implements j {

    /* renamed from: j, reason: collision with root package name */
    private final long f24841j = 500;

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        if (j6.vl() == null && j6.mi().f() == 3 && !com.bytedance.msdk.core.xt.xt().l() && j6.h() != null) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "执行开启开屏兜底...............");
            j(interfaceC0365j, j6, j6.mi(), j6.h());
        } else {
            interfaceC0365j.j(j6);
        }
    }

    protected void j(final j.InterfaceC0365j interfaceC0365j, final com.bytedance.msdk.cw.m.j.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, com.bytedance.msdk.api.r.qv qvVar) {
        if (qvVar != null && xtVar2 != null) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar2.v()) + "settings config.......AdUnitId = " + xtVar2.v() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.bytedance.msdk.xt.j.j(qvVar.j()));
        }
        com.bytedance.msdk.up.m.xt(xtVar2, -4);
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + qvVar.j() + " getAppId = " + qvVar.cw() + " getAppKey = " + qvVar.r() + " getAdNetworkSlotId = " + qvVar.xt());
        if (!TextUtils.isEmpty(qvVar.xt()) && (!TextUtils.isEmpty(qvVar.cw()) || !TextUtils.isEmpty(qvVar.r()))) {
            int j6 = qvVar.j();
            final String j7 = com.bytedance.msdk.xt.j.j(j6);
            final String xt = qvVar.xt();
            if (TextUtils.isEmpty(j7)) {
                j(xtVar, 840027);
                xtVar.j(new com.bytedance.msdk.api.j(840027, com.bytedance.msdk.api.j.j(840027)));
                return;
            }
            if (j6 == 3) {
                new com.bytedance.msdk.m.j.up(qvVar).j(qvVar);
                Looper xt2 = com.bytedance.msdk.j.up.m.xt();
                if (xt2 != null) {
                    new Handler(xt2).postDelayed(new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.vl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            vl.this.j(interfaceC0365j, xtVar, j7, xt);
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            if (j6 == 1) {
                com.bytedance.msdk.m.j.oq.xt(qvVar).j(qvVar, new com.bytedance.msdk.j.j.cw() { // from class: com.bytedance.msdk.cw.cw.j.vl.2
                    @Override // com.bytedance.msdk.j.j.cw
                    public void j() {
                        vl.this.j(interfaceC0365j, xtVar, j7, xt);
                    }

                    @Override // com.bytedance.msdk.j.j.cw
                    public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                        vl.this.j(xtVar, 840027);
                        xtVar.j(new com.bytedance.msdk.api.j(840027, com.bytedance.msdk.api.j.j(840027)));
                    }
                });
                return;
            }
            if (j6 == 7) {
                new com.bytedance.msdk.m.j.ae(qvVar).j(qvVar);
                j(interfaceC0365j, xtVar, j7, xt);
                return;
            }
            if (j6 == 6) {
                new com.bytedance.msdk.m.j.xt(qvVar).j(qvVar);
                j(interfaceC0365j, xtVar, j7, xt);
                return;
            }
            if (j6 == 4) {
                new com.bytedance.msdk.m.j.tl(qvVar).j(qvVar);
                j(interfaceC0365j, xtVar, j7, xt);
                return;
            } else if (j6 == 8) {
                new com.bytedance.msdk.m.j.vl(qvVar).j(qvVar);
                j(interfaceC0365j, xtVar, j7, xt);
                return;
            } else if (j6 == 9) {
                new com.bytedance.msdk.m.j.m(qvVar).j(qvVar, new com.bytedance.msdk.j.j.cw() { // from class: com.bytedance.msdk.cw.cw.j.vl.3
                    @Override // com.bytedance.msdk.j.j.cw
                    public void j() {
                        vl.this.j(interfaceC0365j, xtVar, j7, xt);
                    }

                    @Override // com.bytedance.msdk.j.j.cw
                    public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                        vl.this.j(xtVar, 840027);
                        xtVar.j(new com.bytedance.msdk.api.j(840027, com.bytedance.msdk.api.j.j(840027)));
                    }
                });
                return;
            } else {
                j(xtVar, 840027);
                xtVar.j(new com.bytedance.msdk.api.j(840027, com.bytedance.msdk.api.j.j(840027)));
                return;
            }
        }
        j(xtVar, 840027);
        xtVar.j(new com.bytedance.msdk.api.j(840027, com.bytedance.msdk.api.j.j(840027)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.msdk.cw.m.j.xt xtVar, int i6) {
        com.bytedance.msdk.up.m.j(xtVar.mi(), (String) null, !xtVar.v(), xtVar.wq().f24631j, i6, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(j.InterfaceC0365j interfaceC0365j, com.bytedance.msdk.cw.m.j.xt xtVar, String str, String str2) {
        xtVar.j(j(xtVar.mi().v(), str, str2));
        interfaceC0365j.j(xtVar);
    }

    private com.bytedance.msdk.core.oq.xt j(String str, String str2, String str3) {
        com.bytedance.msdk.core.oq.oq j6 = com.bytedance.msdk.core.ae.cw.j(str3, str2, -4, -4);
        if (j6 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(j6);
        com.bytedance.msdk.core.oq.xt xtVar = new com.bytedance.msdk.core.oq.xt();
        xtVar.r(str);
        xtVar.ws(3);
        xtVar.r(400L);
        xtVar.up(2000L);
        xtVar.m(5000L);
        xtVar.ae(3000L);
        xtVar.j(arrayList);
        return xtVar;
    }
}
