package com.bytedance.msdk.cw.cw.xt.j.j;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.xt.xt.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends xt {

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.msdk.cw.j.j.cw f24881g;

    public void cw() {
        if (this.f24881g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.j.1
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.j.j jVar = (com.bytedance.msdk.api.r.j.j.j) j.this.f24881g.ym();
                    if (jVar != null) {
                        jVar.xt(null);
                    }
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
        com.bytedance.msdk.cw.j.j.xt xtVar = new com.bytedance.msdk.cw.j.j.xt(this, ((xt) this).cw);
        this.f24881g = xtVar;
        xtVar.cw(this.up);
        this.f24881g.ws(this.f24915r.s());
        if (d6 > 0.0d && g() == 1) {
            this.f24881g.j(d6);
        }
        if (map != null) {
            this.up.putAll(map);
        }
        this.f24881g.r(this.up);
        j(this.f24881g);
    }

    public void r() {
        if (this.f24881g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.j.2
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    j.this.cw(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.j.2.1
                        @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                        public void j() {
                            com.bytedance.msdk.api.r.j.j.j jVar = (com.bytedance.msdk.api.r.j.j.j) j.this.f24881g.ym();
                            if (jVar != null) {
                                jVar.j((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void up() {
        if (this.f24881g != null) {
            j(new j.InterfaceC0348j() { // from class: com.bytedance.msdk.cw.cw.xt.j.j.j.3
                @Override // com.bytedance.msdk.api.r.j.xt.xt.j.InterfaceC0348j
                public void j() {
                    com.bytedance.msdk.api.r.j.j.j jVar = (com.bytedance.msdk.api.r.j.j.j) j.this.f24881g.ym();
                    if (jVar != null) {
                        jVar.f_();
                    }
                }
            });
        }
    }

    public j(String str, com.bytedance.msdk.cw.j.xt xtVar) {
        super(str, xtVar);
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.j.xt
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        double d6;
        Map<String, Object> map;
        if (i6 == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom banner loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            j(intValue, stringValue);
        } else if (i6 == 8107) {
            if (pluginValueSet != null) {
                d6 = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d6 = 0.0d;
                map = null;
            }
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom banner loader : callLoadSucceed price:" + d6 + " mextraMsg:" + map);
            j(d6, map);
        } else if (i6 == 1008) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdShow");
            cw();
        } else if (i6 == 1009) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClick");
            r();
        } else if (i6 == 1014) {
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClosed");
            up();
        }
        return null;
    }
}
