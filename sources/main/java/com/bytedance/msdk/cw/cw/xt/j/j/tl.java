package com.bytedance.msdk.cw.cw.xt.j.j;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.xt.xt.j;
import com.bytedance.msdk.cw.j.j.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends xt {

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.msdk.cw.j.j.cw f24894g;

    public void cw() {
        if (this.f24894g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.1
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    tl.this.cw(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.1.1
                        @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                        public void j() {
                            com.bytedance.msdk.api.r.j.g.xt xtVar = (com.bytedance.msdk.api.r.j.g.xt) tl.this.f24894g.ym();
                            if (xtVar != null) {
                                xtVar.r();
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
        oq oqVar = new oq(this, ((xt) this).cw);
        this.f24894g = oqVar;
        j(oqVar, d6, map);
    }

    public void r() {
        if (this.f24894g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.2
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    tl.this.xt(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.2.1
                        @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                        public void j() {
                            com.bytedance.msdk.api.r.j.g.xt xtVar = (com.bytedance.msdk.api.r.j.g.xt) tl.this.f24894g.ym();
                            if (xtVar != null) {
                                xtVar.up();
                            }
                        }
                    });
                }
            });
        }
    }

    public void up() {
        if (this.f24894g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.3
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.g.xt xtVar = (com.bytedance.msdk.api.r.j.g.xt) tl.this.f24894g.ym();
                    if (xtVar != null) {
                        xtVar.j(1);
                    }
                }
            });
        }
    }

    public void ws() {
        if (this.f24894g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.tl.4
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.g.xt xtVar = (com.bytedance.msdk.api.r.j.g.xt) tl.this.f24894g.ym();
                    if (xtVar != null) {
                        xtVar.xt(2);
                    }
                }
            });
        }
    }

    public tl(String str, com.bytedance.msdk.cw.j.xt xtVar) {
        super(str, xtVar);
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.j.xt
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        double d6;
        Map<String, Object> map;
        if (i6 == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            j(intValue, stringValue);
        } else if (i6 == 8107) {
            if (pluginValueSet != null) {
                d6 = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d6 = 0.0d;
                map = null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callLoadSucceed price:" + d6 + " mextraMsg:" + map);
            j(d6, map);
        } else if (i6 == 1009) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdClicked");
            cw();
        } else if (i6 == 1008) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdShow");
            r();
        } else if (i6 == 1019) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdSkip");
            up();
        } else if (i6 == 1011) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdDismiss");
            ws();
        }
        return null;
    }
}
