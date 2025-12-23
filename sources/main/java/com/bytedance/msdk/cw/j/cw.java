package com.bytedance.msdk.cw.j;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.ae.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends r {
    @Override // com.bytedance.msdk.xt.cw
    public void j(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, oq oqVar, List<View> list4) {
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8159).j(Void.class).j(20033, activity).j(8067, viewGroup).j(8068, list).j(8069, list2).j(8070, list3).j(8071, oq.j(oqVar)).xt());
        }
    }

    private com.bytedance.msdk.api.r.j.j.j os() {
        return (com.bytedance.msdk.api.r.j.j.j) this.ae;
    }

    @Override // com.bytedance.msdk.xt.cw
    public View g() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.g();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6081).j(View.class).xt());
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean kt() {
        Object apply;
        try {
            if (((r) this).f25000g != null) {
                apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8135).j(Boolean.class).xt());
                if (apply instanceof Boolean) {
                    return ((Boolean) apply).booleanValue();
                }
                return false;
            }
        } catch (Exception unused) {
        }
        return super.kt();
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

    public cw(com.bytedance.msdk.cw.m.xt.j jVar) {
        super(jVar);
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        return com.bytedance.msdk.core.j.j.up.j(zz(), ((r) this).f25000g);
    }

    @Override // com.bytedance.msdk.cw.j.r
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 1008) {
            if (!(this.ae instanceof com.bytedance.msdk.api.r.j.j.j)) {
                return null;
            }
            os().xt(null);
            return null;
        }
        if (i6 != 1009) {
            if (i6 != 1014) {
                if (i6 != 1016) {
                    if (i6 == 8111) {
                        j(pluginValueSet.doubleValue(8016));
                    } else if (i6 == 8140) {
                        String stringValue = pluginValueSet.stringValue(8045);
                        String stringValue2 = pluginValueSet.stringValue(8046);
                        int intValue = pluginValueSet.intValue(8047);
                        String stringValue3 = pluginValueSet.stringValue(8048);
                        String stringValue4 = pluginValueSet.stringValue(8049);
                        String stringValue5 = pluginValueSet.stringValue(8050);
                        int intValue2 = pluginValueSet.intValue(8051);
                        int intValue3 = pluginValueSet.intValue(8052);
                        List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                        String stringValue6 = pluginValueSet.stringValue(8054);
                        boolean booleanValue = pluginValueSet.booleanValue(8055);
                        String stringValue7 = pluginValueSet.stringValue(8056);
                        String stringValue8 = pluginValueSet.stringValue(8057);
                        Object objectValue = pluginValueSet.objectValue(8036, Object.class);
                        String stringValue9 = pluginValueSet.stringValue(8058);
                        double doubleValue = pluginValueSet.doubleValue(8016);
                        boolean booleanValue2 = pluginValueSet.booleanValue(8033);
                        int intValue4 = pluginValueSet.intValue(8060);
                        String stringValue10 = pluginValueSet.stringValue(8061);
                        String stringValue11 = pluginValueSet.stringValue(8061);
                        long longValue = pluginValueSet.longValue(8078);
                        String stringValue12 = pluginValueSet.stringValue(8079);
                        Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                        String stringValue13 = pluginValueSet.stringValue(8080);
                        String stringValue14 = pluginValueSet.stringValue(8081);
                        double doubleValue2 = pluginValueSet.doubleValue(8082);
                        int intValue5 = pluginValueSet.intValue(8059);
                        String stringValue15 = pluginValueSet.stringValue(8551);
                        String stringValue16 = pluginValueSet.stringValue(8559);
                        la(stringValue);
                        gq(stringValue2);
                        kt(intValue);
                        a(stringValue3);
                        rn(stringValue4);
                        l(stringValue5);
                        mi(intValue2);
                        w(intValue3);
                        j(list);
                        h(stringValue6);
                        tl(booleanValue);
                        f(stringValue7);
                        v(stringValue8);
                        if (TextUtils.equals(ff(), "baidu")) {
                            j(MediationConstant.BAIDU_DISLIKE_INFO, objectValue);
                        }
                        ws(stringValue9);
                        j(doubleValue);
                        ae(booleanValue2);
                        qv(intValue4);
                        vl(intValue5);
                        p(stringValue10);
                        tj(stringValue11);
                        xt(longValue);
                        x(stringValue12);
                        up(map);
                        ch(stringValue13);
                        s(stringValue14);
                        r(doubleValue2);
                        vl(stringValue15);
                        oq(stringValue16);
                    } else if (i6 == 8207) {
                        ws(pluginValueSet.stringValue(8058));
                    }
                }
            } else if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
                com.bytedance.msdk.cw.m.xt.j jVar = ((r) this).oq;
                if (jVar != null) {
                    com.bytedance.msdk.core.xt.j.j(jVar.xt());
                }
                os().f_();
            }
        } else if (this.ae instanceof com.bytedance.msdk.api.r.j.j.j) {
            os().j((View) null);
            return null;
        }
        return null;
    }
}
