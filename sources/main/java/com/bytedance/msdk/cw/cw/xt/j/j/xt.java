package com.bytedance.msdk.cw.cw.xt.j.j;

import a1.a;
import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.xt.xt.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt extends com.bytedance.msdk.cw.cw.xt.j.xt {
    protected int ae;
    protected Function<SparseArray<Object>, Object> cw;

    /* renamed from: g, reason: collision with root package name */
    private String f24913g;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f24914m;
    private String oq;
    private com.bytedance.msdk.api.j.xt qv;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.msdk.cw.m.xt.xt f24915r;
    protected int tl;
    protected Map<String, Object> up;
    protected com.bytedance.msdk.api.r.j.xt.cw.cw xt;

    public abstract <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls);

    public void j(int i6, String str) {
        j(new com.bytedance.msdk.api.j(i6, str));
    }

    public void m() {
        this.f24914m = true;
    }

    public Integer oq() {
        Object apply;
        if (this.cw == null) {
            return 1;
        }
        apply = this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8121).j(Object.class).j(20068, 1).xt());
        Integer j6 = com.bytedance.sdk.openadsdk.core.wq.j.j.j(apply);
        if (j6 == null) {
            return 1;
        }
        return j6;
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public final void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        this.f24915r = xtVar;
        this.qv = xtVar2;
        this.xt = new com.bytedance.msdk.api.r.j.xt.cw.cw(xtVar.f(), xtVar.vl(), xtVar.ws(), xtVar.az(), xtVar.wq());
        com.bytedance.msdk.api.r.j.xt.m.j j6 = com.bytedance.msdk.m.xt.j.j(xtVar.jy());
        this.f24913g = j6 != null ? j6.j() : "";
        com.bytedance.sdk.openadsdk.i.r j7 = com.bytedance.sdk.openadsdk.i.r.j();
        j7.j(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.bytedance.sdk.gromore.init.j.j() >= 5900) {
            j7.j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.j.up.j.j(context));
        } else {
            j7.j(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        j7.j(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.oq);
        j7.j(8546, com.bytedance.sdk.openadsdk.i.cw.r.j(this.xt.j()));
        if (xtVar2.gx() != null) {
            j7.j(8548, com.bytedance.sdk.openadsdk.i.cw.r.j(xtVar2.gx()));
        }
        Function<SparseArray<Object>, Object> ae = com.bytedance.msdk.core.qv.j.j().ae();
        if (ae == null) {
            j(new com.bytedance.msdk.api.j("Adn custom class loader is null"));
            return;
        }
        j7.j(Void.class);
        j7.j(8106);
        ae.apply(j7.xt());
    }

    public String ae() {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24915r;
        return xtVar != null ? xtVar.ch() : "";
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt, com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8221) {
            this.cw = b.a(pluginValueSet.objectValue(8405, a.a()));
        } else {
            if (i6 == 8137) {
                T t5 = (T) ae();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom loader : getAdm = ".concat(String.valueOf(t5)));
                return t5;
            }
            if (i6 == 8224) {
                T t6 = (T) tl();
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t6)));
                return t6;
            }
            if (i6 == 8226) {
                T t7 = (T) Integer.valueOf(g());
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom loader : getBiddingType = ".concat(String.valueOf(t7)));
                return t7;
            }
            if (i6 == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                j(map);
            }
        }
        return (T) j(i6, pluginValueSet, cls);
    }

    public final void cw(j.InterfaceC0348j interfaceC0348j) {
        int i6 = this.tl;
        if (i6 >= 60) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.tl = i6 + 1;
        if (interfaceC0348j != null) {
            interfaceC0348j.j();
        }
    }

    public int g() {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24915r;
        if (xtVar != null) {
            return xtVar.mi();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.cw.j.j
    public String j(String str) {
        return this.f24913g;
    }

    public void jy() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8109).j(Void.class).xt());
        }
    }

    public void qv() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8149).j(Void.class).xt());
        }
    }

    public Object tl() {
        com.bytedance.msdk.cw.m.xt.xt xtVar = this.f24915r;
        return xtVar != null ? xtVar.uf() : "";
    }

    public void vl() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8148).j(Void.class).xt());
        }
    }

    public xt(String str, com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
        this.up = new ConcurrentHashMap();
        this.f24914m = false;
        this.ae = 0;
        this.tl = 0;
        this.oq = str;
    }

    public void j(Map<String, Object> map) {
        if (map != null) {
            this.up.clear();
            this.up.putAll(map);
        }
    }

    public void j(boolean z5, double d6, int i6, Map<String, Object> map) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8225).j(Void.class).j(8406, Boolean.valueOf(z5)).j(8407, Double.valueOf(d6)).j(8408, Integer.valueOf(i6)).j(8075, map).xt());
        }
    }

    public final void j(j.InterfaceC0348j interfaceC0348j) {
        if (!xt()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0348j != null) {
            interfaceC0348j.j();
        }
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt
    public void j(com.bytedance.msdk.xt.cw cwVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(cwVar);
        j(arrayList);
    }

    protected void j(com.bytedance.msdk.xt.cw cwVar, double d6, Map<String, Object> map) {
        if (d6 > 0.0d && g() == 1) {
            cwVar.j(d6);
        }
        if (map != null) {
            this.up.putAll(map);
        }
        cwVar.r(this.up);
        j(cwVar);
    }

    public final void xt(j.InterfaceC0348j interfaceC0348j) {
        if (this.f24914m) {
            int i6 = this.ae;
            if (i6 < 2) {
                this.ae = i6 + 1;
                if (interfaceC0348j != null) {
                    interfaceC0348j.j();
                    return;
                }
                return;
            }
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.xt, com.bytedance.msdk.cw.j.xt
    public void j(List<com.bytedance.msdk.xt.cw> list) {
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            cwVar.cw(this.up);
            cwVar.ws(this.f24915r.s());
        }
        super.j(list);
    }
}
