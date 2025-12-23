package com.bytedance.sdk.gromore.init;

import a1.a;
import a1.b;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.jy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends com.bytedance.sdk.openadsdk.mediation.xt.xt.r {
    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Activity activity, List<com.bytedance.sdk.openadsdk.mediation.xt.xt.up> list, int i6, int i7, Function<SparseArray<Object>, Object> function) {
        com.bytedance.msdk.api.j.xt j6;
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i6 + " requestIntervalS = " + i7 + " classLoader = " + function);
        if (list == null || list.size() == 0) {
            com.bytedance.msdk.j.up.cw.r("TMe", "参数错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.mediation.xt.xt.up upVar : list) {
            if (upVar != null && (j6 = com.bytedance.msdk.api.r.j.j.j(upVar.j(), upVar.xt(), function)) != null) {
                arrayList.add(new jy(j6, upVar.cw()));
            }
        }
        if (arrayList.size() > 0) {
            com.bytedance.msdk.api.r.oq.j(activity, arrayList, i6, i7);
        } else {
            com.bytedance.msdk.j.up.cw.r("TMe", "参数错误");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(String str) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager setPulisherDid configUserInfoForSegment = ".concat(String.valueOf(str)));
        com.bytedance.msdk.api.r.oq.j(str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Context context) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager requestPermissionIfNecessary context = ".concat(String.valueOf(context)));
        com.bytedance.msdk.api.r.oq.j(context);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Context context, int[] iArr) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.bytedance.msdk.api.r.oq.j(context, iArr);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(int i6) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager setThemeStatus themeStatus = ".concat(String.valueOf(i6)));
        com.bytedance.msdk.api.r.oq.j(i6);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public int j(final com.bytedance.sdk.openadsdk.mediation.xt.xt.j.r rVar) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.bytedance.msdk.api.r.oq.j(new com.bytedance.msdk.api.r.cw() { // from class: com.bytedance.sdk.gromore.init.tl.1
            @Override // com.bytedance.msdk.api.r.cw
            public void j(int i6) {
                com.bytedance.sdk.openadsdk.mediation.xt.xt.j.r rVar2 = rVar;
                if (rVar2 != null) {
                    rVar2.j(i6);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar) {
        com.bytedance.msdk.api.r.oq.j(xt.j(cwVar));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager updatePrivacyConfig customController = ".concat(String.valueOf(rVar)));
        com.bytedance.msdk.api.r.oq.j(rVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Map<String, Object> map) {
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager updateLocalExtra map = ".concat(String.valueOf(map)) == null ? "null" : map.toString());
        com.bytedance.msdk.core.j.qv().xt(map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, final com.bytedance.sdk.openadsdk.mediation.xt.xt.j.cw cwVar, Function<SparseArray<Object>, Object> function) {
        if (context == null || jVar == null) {
            com.bytedance.msdk.j.up.cw.r("TMe", "参数错误");
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + jVar + " pluginIMediationNativeAdTokenCallback = " + cwVar + " classLoader = " + function);
        com.bytedance.msdk.api.j.xt j6 = com.bytedance.msdk.api.r.j.j.j(5, jVar, function);
        if (j6 != null) {
            final com.bytedance.msdk.cw.r.g gVar = new com.bytedance.msdk.cw.r.g(context);
            gVar.j(j6, new com.bytedance.msdk.api.r.j.cw() { // from class: com.bytedance.sdk.gromore.init.tl.2
                @Override // com.bytedance.msdk.api.r.j.cw
                public void j(String str) {
                    com.bytedance.sdk.openadsdk.mediation.xt.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(str, new com.bytedance.sdk.gromore.j.j.ae.r.j(gVar));
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw
                public void j(com.bytedance.msdk.api.j jVar2) {
                    com.bytedance.sdk.openadsdk.mediation.xt.xt.j.cw cwVar2;
                    if (jVar2 == null || (cwVar2 = cwVar) == null) {
                        return;
                    }
                    cwVar2.j(jVar2.f24334j, jVar2.xt);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, final com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j jVar2, Function<SparseArray<Object>, Object> function) {
        if (context == null || jVar == null) {
            com.bytedance.msdk.j.up.cw.r("TMe", "参数错误");
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + jVar + " pluginIMediationDrawAdTokenCallback = " + jVar2 + " classLoader = " + function);
        com.bytedance.msdk.api.j.xt j6 = com.bytedance.msdk.api.r.j.j.j(9, jVar, function);
        if (j6 != null) {
            final com.bytedance.msdk.cw.r.ae aeVar = new com.bytedance.msdk.cw.r.ae(context);
            aeVar.j(j6, new com.bytedance.msdk.api.r.j.cw() { // from class: com.bytedance.sdk.gromore.init.tl.3
                @Override // com.bytedance.msdk.api.r.j.cw
                public void j(String str) {
                    com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j jVar3 = jVar2;
                    if (jVar3 != null) {
                        jVar3.j(str, new com.bytedance.sdk.gromore.j.j.ae.xt.r(aeVar));
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.cw
                public void j(com.bytedance.msdk.api.j jVar3) {
                    com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j jVar4;
                    if (jVar3 == null || (jVar4 = jVar2) == null) {
                        return;
                    }
                    jVar4.j(jVar3.f24334j, jVar3.xt);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public Map<String, Object> j() {
        com.bytedance.msdk.j.up.cw.xt("TMe", "getMediationExtraInfo");
        return com.bytedance.msdk.api.r.oq.jy();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.r
    public Object j(int i6, PluginValueSet pluginValueSet) {
        String str;
        String str2;
        if (i6 == 8259) {
            return j();
        }
        if (i6 == 1001) {
            return Boolean.valueOf(com.bytedance.msdk.api.r.oq.j());
        }
        if (i6 == 1002) {
            return Boolean.valueOf(com.bytedance.msdk.api.r.oq.j(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1002)));
        }
        if (i6 == 1003) {
            return Boolean.valueOf(com.bytedance.msdk.api.r.oq.xt(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1003)));
        }
        if (i6 == 1004) {
            return com.bytedance.msdk.api.r.oq.up();
        }
        if (i6 == 1005) {
            return com.bytedance.msdk.api.r.oq.qv();
        }
        if (i6 == 1006) {
            return com.bytedance.msdk.api.r.oq.oq();
        }
        if (i6 == 1007) {
            return com.bytedance.msdk.api.r.oq.xt((Context) pluginValueSet.objectValue(1004, Context.class));
        }
        if (i6 == 1008) {
            com.bytedance.msdk.api.r.oq.xt(2);
        } else if (i6 == 1009) {
            com.bytedance.msdk.api.r.oq.vl();
        } else {
            if (i6 == 1010) {
                return Boolean.valueOf(com.bytedance.msdk.api.r.oq.r(pluginValueSet.stringValue(1001)));
            }
            if (i6 == 1011) {
                String stringValue = pluginValueSet.stringValue(1001);
                com.bytedance.msdk.api.r.j.xt.m.j up = com.bytedance.msdk.api.r.oq.up(stringValue);
                com.bytedance.msdk.j.j.r m6 = com.bytedance.msdk.api.r.oq.m(stringValue);
                if (up != null) {
                    str = up.j();
                    str2 = up.xt();
                } else if (m6 != null) {
                    String xt = m6.xt();
                    str2 = m6.j();
                    str = xt;
                } else {
                    str = "";
                    str2 = "";
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("networdSdkVersion", str);
                hashMap.put("adapterSdkVersion", str2);
                return hashMap;
            }
            if (i6 == 2001) {
                if (pluginValueSet == null) {
                    return null;
                }
                com.bytedance.sdk.gromore.xt.j.j((Function<SparseArray<Object>, Object>) b.a(pluginValueSet.objectValue(2002, a.a())));
                return com.bytedance.sdk.gromore.xt.j.j();
            }
            if (i6 == 1012) {
                return Boolean.valueOf(com.bytedance.msdk.core.j.qv().p().cw());
            }
        }
        return null;
    }
}
