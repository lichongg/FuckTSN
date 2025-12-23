package com.bytedance.msdk.cw.cw.xt.j.j;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.xt.xt.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends xt {

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.msdk.cw.j.j.cw f24886g;

    public void az() {
        if (this.f24886g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.5
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.up.j jVar = (com.bytedance.msdk.api.r.j.up.j) m.this.f24886g.ym();
                    if (jVar != null) {
                        jVar.up();
                    }
                }
            });
        }
    }

    public void cw() {
        if (this.f24886g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.1
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    m.this.xt(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.1.1
                        @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                        public void j() {
                            com.bytedance.msdk.api.r.j.up.j jVar = (com.bytedance.msdk.api.r.j.up.j) m.this.f24886g.ym();
                            if (jVar != null) {
                                jVar.j();
                            }
                        }
                    });
                }
            });
        }
    }

    public void j(double d6, Map<String, Object> map) {
        if (xt()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
        com.bytedance.msdk.cw.j.j.ae aeVar = new com.bytedance.msdk.cw.j.j.ae(this, ((xt) this).cw);
        this.f24886g = aeVar;
        j(aeVar, d6, map);
    }

    public void r() {
        if (this.f24886g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.2
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    m.this.cw(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.2.1
                        @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                        public void j() {
                            com.bytedance.msdk.api.r.j.up.j jVar = (com.bytedance.msdk.api.r.j.up.j) m.this.f24886g.ym();
                            if (jVar != null) {
                                jVar.xt();
                            }
                        }
                    });
                }
            });
        }
    }

    public void up() {
        if (this.f24886g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.3
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.up.j jVar = (com.bytedance.msdk.api.r.j.up.j) m.this.f24886g.ym();
                    if (jVar != null) {
                        jVar.cw();
                    }
                }
            });
        }
    }

    public void ws() {
        if (this.f24886g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.m.4
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.up.j jVar = (com.bytedance.msdk.api.r.j.up.j) m.this.f24886g.ym();
                    if (jVar != null) {
                        jVar.r();
                    }
                }
            });
        }
    }

    public m(String str, com.bytedance.msdk.cw.j.xt xtVar) {
        super(str, xtVar);
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.j.xt
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        double d6;
        Map<String, Object> map;
        if (i6 == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            j(intValue, stringValue);
        } else if (i6 == 8107) {
            if (pluginValueSet != null) {
                d6 = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d6 = 0.0d;
                map = null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callLoadSucceed price:" + d6 + " mextraMsg:" + map);
            j(d6, map);
        } else if (i6 == 1008) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialShow");
            cw();
        } else if (i6 == 1009) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdClick");
            r();
        } else if (i6 == 1014) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialClosed");
            up();
        } else if (i6 == 1015) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdOpened");
            ws();
        } else if (i6 == 1016) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            az();
        }
        return null;
    }
}
