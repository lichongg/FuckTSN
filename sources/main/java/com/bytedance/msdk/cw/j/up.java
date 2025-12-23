package com.bytedance.msdk.cw.j;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.umeng.analytics.pro.o;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends r {
    @Override // com.bytedance.msdk.xt.cw
    public void j(Activity activity, Object obj, String str) {
        super.j(activity, obj, str);
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8113).j(Void.class).j(20033, activity).xt());
        }
    }

    private com.bytedance.msdk.api.r.j.r.j os() {
        return (com.bytedance.msdk.api.r.j.r.j) this.ae;
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean lx() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.lx();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(o.a.C).j(Boolean.class).xt());
        return apply instanceof Boolean ? ((Boolean) apply).booleanValue() : super.lx();
    }

    @Override // com.bytedance.msdk.xt.cw
    public String o() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.o();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8147).j(String.class).xt());
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    public up(com.bytedance.msdk.cw.m.xt.j jVar) {
        super(jVar);
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        return com.bytedance.msdk.core.j.j.up.j(zz(), ((r) this).f25000g);
    }

    @Override // com.bytedance.msdk.cw.j.r
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        String str;
        if (i6 == 8143) {
            return (T) Double.valueOf(t());
        }
        if (i6 == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!m109if() && !yl()) {
                return null;
            }
            j(pluginValueSet.doubleValue(8016));
            return null;
        }
        int i7 = 0;
        if (i6 == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            ae(pluginValueSet.booleanValue(8033, false));
            return null;
        }
        if (i6 == 1008) {
            if (os() == null) {
                return null;
            }
            os().g_();
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
        if (i6 == 1009) {
            if (os() == null) {
                return null;
            }
            os().h_();
            return null;
        }
        if (i6 == 1014) {
            if (os() == null) {
                return null;
            }
            os().cw();
            return null;
        }
        if (i6 == 1026) {
            if (os() == null) {
                return null;
            }
            os().r();
            return null;
        }
        if (i6 == 1021) {
            if (os() == null) {
                return null;
            }
            os().up();
            return null;
        }
        if (i6 == 1037) {
            if (os() == null) {
                return null;
            }
            os().m();
            return null;
        }
        if (i6 != 1018 || os() == null) {
            return null;
        }
        final boolean booleanValue = pluginValueSet.booleanValue(8017);
        final float intValue = pluginValueSet.intValue(8018);
        final String stringValue = pluginValueSet.stringValue(8019);
        os().j(new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.j.up.1
            @Override // com.bytedance.msdk.api.cw.j
            public Map<String, Object> r() {
                return null;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public String cw() {
                return stringValue;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public boolean j() {
                return booleanValue;
            }

            @Override // com.bytedance.msdk.api.cw.j
            public float xt() {
                return intValue;
            }
        });
        return null;
    }
}
