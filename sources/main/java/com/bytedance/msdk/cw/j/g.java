package com.bytedance.msdk.cw.j;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends r {
    private com.bytedance.msdk.j.xt.m qv;

    @Override // com.bytedance.msdk.xt.cw
    public void j(ViewGroup viewGroup) {
        super.j(viewGroup);
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6152).j(Void.class).j(20060, viewGroup).xt());
        }
    }

    private com.bytedance.msdk.j.xt.up os() {
        return (com.bytedance.msdk.j.xt.up) this.ae;
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.o();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8147).j(String.class).xt());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    public g(com.bytedance.msdk.cw.m.xt.j jVar) {
        super(jVar);
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        return com.bytedance.msdk.core.j.j.up.j(zz(), ((r) this).f25000g);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(ViewGroup viewGroup, Activity activity) {
        super.j(viewGroup, activity);
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6154).j(Void.class).j(20060, viewGroup).j(20033, activity).xt());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.msdk.cw.j.r
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        String str;
        if (i6 == 8143) {
            return (T) Double.valueOf(t());
        }
        int i7 = 0;
        if (i6 == 1009) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.j.xt.m mVar = this.qv;
                if (!(mVar instanceof com.bytedance.msdk.api.r.j.g.xt)) {
                    return null;
                }
                ((com.bytedance.msdk.api.r.j.g.xt) mVar).r();
                return null;
            }
            if (os() == null) {
                return null;
            }
            os().r();
            return null;
        }
        if (i6 == 1017) {
            if (os() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                i7 = pluginValueSet.intValue(8014, 0);
                str = pluginValueSet.stringValue(8015);
            } else {
                str = "";
            }
            os().j(new com.bytedance.msdk.api.j(i7, str));
            return null;
        }
        if (i6 == 1011) {
            boolean booleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (booleanValue) {
                com.bytedance.msdk.j.xt.m mVar2 = this.qv;
                if (!(mVar2 instanceof com.bytedance.msdk.api.r.j.g.xt)) {
                    return null;
                }
                ((com.bytedance.msdk.api.r.j.g.xt) mVar2).xt(2);
                return null;
            }
            if (os() == null) {
                return null;
            }
            os().xt(2);
            return null;
        }
        if (i6 == 1008) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.j.xt.m mVar3 = this.qv;
                if (!(mVar3 instanceof com.bytedance.msdk.api.r.j.g.xt)) {
                    return null;
                }
                ((com.bytedance.msdk.api.r.j.g.xt) mVar3).up();
                return null;
            }
            if (os() == null) {
                return null;
            }
            os().up();
            return null;
        }
        if (i6 == 1019) {
            boolean booleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (booleanValue2) {
                com.bytedance.msdk.j.xt.m mVar4 = this.qv;
                if (!(mVar4 instanceof com.bytedance.msdk.api.r.j.g.xt)) {
                    return null;
                }
                ((com.bytedance.msdk.api.r.j.g.xt) mVar4).j(1);
                return null;
            }
            if (os() == null) {
                return null;
            }
            os().j(1);
            return null;
        }
        if (i6 == 1074) {
            if (os() != null) {
                return (T) os().getActivity();
            }
            return null;
        }
        if (i6 == 1051) {
            os();
            return null;
        }
        if (i6 == 1052) {
            os();
            return null;
        }
        if (i6 == 6156) {
            if (os() == null) {
                return null;
            }
            os().cw();
            return null;
        }
        if (i6 != 8111) {
            return null;
        }
        j(pluginValueSet.doubleValue(8016));
        return null;
    }
}
