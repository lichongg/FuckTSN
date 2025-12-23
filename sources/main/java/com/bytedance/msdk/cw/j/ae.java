package com.bytedance.msdk.cw.j;

import a1.a;
import a1.b;
import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.j.ae.oq;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.i.cw.xt.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.umeng.analytics.pro.o;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends r {
    private com.bytedance.sdk.openadsdk.kt.j.xt.j.j qv;
    private com.bytedance.msdk.cw.cw.xt.j.cw vl;

    private void xt(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, oq oqVar, List<View> list4) {
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8159).j(Void.class).j(20033, activity).j(8067, viewGroup).j(8068, list).j(8069, list2).j(8070, list3).j(8071, oq.j(oqVar)).j(8053, list4).xt());
        }
    }

    @Override // com.bytedance.msdk.cw.j.r
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        com.bytedance.msdk.api.r.j.cw.j jVar;
        com.bytedance.msdk.api.r.j.cw.j jVar2;
        if (i6 == 8130) {
            if (om() == 5) {
                if (rh() == 5) {
                    com.bytedance.msdk.api.r.j.cw.j jVar3 = this.f25337m;
                    if (jVar3 != null) {
                        jVar3.j(null);
                    }
                } else {
                    com.bytedance.msdk.api.r.j.ae.xt xtVar = this.f25334j;
                    if (xtVar != null) {
                        xtVar.j(null);
                    }
                }
            } else if (om() == 9 && (jVar2 = this.f25337m) != null) {
                jVar2.j(null);
            }
        } else if (i6 == 8113) {
            if (om() == 5) {
                if (rh() == 5) {
                    com.bytedance.msdk.api.r.j.cw.j jVar4 = this.f25337m;
                    if (jVar4 != null) {
                        jVar4.j();
                    }
                } else {
                    com.bytedance.msdk.api.r.j.ae.xt xtVar2 = this.f25334j;
                    if (xtVar2 != null) {
                        xtVar2.j();
                    }
                }
            } else if (om() == 9 && (jVar = this.f25337m) != null) {
                jVar.j();
            }
        } else if (i6 == 8131) {
            if (this.vl != null) {
                this.vl.j(this, pluginValueSet.stringValue(8036));
            }
        } else if (i6 == 8132) {
            com.bytedance.msdk.cw.m.xt.j jVar5 = ((r) this).oq;
            if (jVar5 != null) {
                com.bytedance.msdk.core.xt.j.j(jVar5.xt());
            }
            if (this.qv != null) {
                this.qv.j(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i6 == 8133) {
            float floatValue = pluginValueSet.floatValue(8040);
            float floatValue2 = pluginValueSet.floatValue(8041);
            if (om() == 5) {
                if (rh() == 5) {
                    com.bytedance.msdk.api.r.j.cw.j jVar6 = this.f25337m;
                    if (jVar6 instanceof com.bytedance.msdk.api.r.j.cw.r) {
                        ((com.bytedance.msdk.api.r.j.cw.r) jVar6).j(floatValue, floatValue2);
                    }
                } else {
                    com.bytedance.msdk.api.r.j.ae.xt xtVar3 = this.f25334j;
                    if (xtVar3 instanceof com.bytedance.msdk.api.r.j.ae.m) {
                        ((com.bytedance.msdk.api.r.j.ae.m) xtVar3).j(floatValue, floatValue2);
                    }
                }
            } else if (om() == 9) {
                com.bytedance.msdk.api.r.j.cw.j jVar7 = this.f25337m;
                if (jVar7 instanceof com.bytedance.msdk.api.r.j.cw.r) {
                    ((com.bytedance.msdk.api.r.j.cw.r) jVar7).j(floatValue, floatValue2);
                }
            }
        } else if (i6 == 8134) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (om() == 5) {
                if (rh() == 5) {
                    com.bytedance.msdk.api.r.j.cw.j jVar8 = this.f25337m;
                    if (jVar8 instanceof com.bytedance.msdk.api.r.j.cw.r) {
                        ((com.bytedance.msdk.api.r.j.cw.r) jVar8).j(view, stringValue, intValue);
                    }
                } else {
                    com.bytedance.msdk.api.r.j.ae.xt xtVar4 = this.f25334j;
                    if (xtVar4 instanceof com.bytedance.msdk.api.r.j.ae.m) {
                        ((com.bytedance.msdk.api.r.j.ae.m) xtVar4).j(view, stringValue, intValue);
                    }
                }
            } else if (om() == 9) {
                com.bytedance.msdk.api.r.j.cw.j jVar9 = this.f25337m;
                if (jVar9 instanceof com.bytedance.msdk.api.r.j.cw.r) {
                    ((com.bytedance.msdk.api.r.j.cw.r) jVar9).j(view, stringValue, intValue);
                }
            }
        } else if (i6 == 8140) {
            String stringValue2 = pluginValueSet.stringValue(8045);
            String stringValue3 = pluginValueSet.stringValue(8046);
            int intValue2 = pluginValueSet.intValue(8047);
            String stringValue4 = pluginValueSet.stringValue(8048);
            String stringValue5 = pluginValueSet.stringValue(8049);
            String stringValue6 = pluginValueSet.stringValue(8050);
            int intValue3 = pluginValueSet.intValue(8051);
            int intValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String stringValue7 = pluginValueSet.stringValue(8054);
            boolean booleanValue = pluginValueSet.booleanValue(8055);
            String stringValue8 = pluginValueSet.stringValue(8056);
            String stringValue9 = pluginValueSet.stringValue(8057);
            Object objectValue = pluginValueSet.objectValue(8036, Object.class);
            String stringValue10 = pluginValueSet.stringValue(8058);
            double doubleValue = pluginValueSet.doubleValue(8016);
            boolean booleanValue2 = pluginValueSet.booleanValue(8033);
            int intValue5 = pluginValueSet.intValue(8060);
            String stringValue11 = pluginValueSet.stringValue(8061);
            String stringValue12 = pluginValueSet.stringValue(8061);
            long longValue = pluginValueSet.longValue(8078);
            String stringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String stringValue14 = pluginValueSet.stringValue(8080);
            String stringValue15 = pluginValueSet.stringValue(8081);
            double doubleValue2 = pluginValueSet.doubleValue(8082);
            int intValue6 = pluginValueSet.intValue(8059);
            String stringValue16 = pluginValueSet.stringValue(8551);
            String stringValue17 = pluginValueSet.stringValue(8559);
            int intValue7 = pluginValueSet.intValue(8553);
            la(stringValue2);
            gq(stringValue3);
            kt(intValue2);
            a(stringValue4);
            rn(stringValue5);
            l(stringValue6);
            mi(intValue3);
            w(intValue4);
            j(list);
            h(stringValue7);
            tl(booleanValue);
            f(stringValue8);
            v(stringValue9);
            if (TextUtils.equals(ff(), "baidu")) {
                j(MediationConstant.BAIDU_DISLIKE_INFO, objectValue);
            }
            ws(stringValue10);
            j(doubleValue);
            ae(booleanValue2);
            qv(intValue5);
            p(stringValue11);
            tj(stringValue12);
            xt(longValue);
            x(stringValue13);
            up(map);
            ch(stringValue14);
            s(stringValue15);
            r(doubleValue2);
            vl(intValue6);
            vl(stringValue16);
            oq(stringValue17);
            xt(intValue7);
        } else {
            if (i6 == 8143) {
                return (T) Double.valueOf(t());
            }
            if (i6 == 8145) {
                com.bytedance.msdk.api.r.j.ae.tl tlVar = this.xt;
                if (tlVar != null) {
                    tlVar.xt();
                }
            } else if (i6 == 8146) {
                com.bytedance.msdk.api.r.j.ae.tl tlVar2 = this.xt;
                if (tlVar2 != null) {
                    tlVar2.cw();
                }
            } else if (i6 == 8118) {
                com.bytedance.msdk.api.r.j.ae.tl tlVar3 = this.xt;
                if (tlVar3 != null) {
                    tlVar3.up();
                }
            } else if (i6 == 8117) {
                int intValue8 = pluginValueSet.intValue(8014);
                String stringValue18 = pluginValueSet.stringValue(8015);
                com.bytedance.msdk.api.r.j.ae.tl tlVar4 = this.xt;
                if (tlVar4 != null) {
                    tlVar4.j(new com.bytedance.msdk.api.j(intValue8, stringValue18));
                }
            } else if (i6 == 8150) {
                com.bytedance.msdk.api.r.j.ae.tl tlVar5 = this.xt;
                if (tlVar5 != null) {
                    tlVar5.r();
                }
            } else if (i6 == 1025) {
                if (this.xt != null) {
                    this.xt.j(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i6 == 8152) {
                com.bytedance.msdk.api.r.j.xt xtVar5 = this.cw;
                if (xtVar5 != null) {
                    xtVar5.j();
                }
            } else if (i6 == 8153) {
                com.bytedance.msdk.api.r.j.xt xtVar6 = this.cw;
                if (xtVar6 != null) {
                    xtVar6.xt();
                }
            } else if (i6 == 8187) {
                if (this.cw != null) {
                    this.cw.j(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i6 == 8155) {
                if (this.cw != null) {
                    this.cw.j(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i6 == 8156) {
                if (this.cw != null) {
                    this.cw.j(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i6 == 8157) {
                if (this.cw != null) {
                    this.cw.xt(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i6 == 8158) {
                if (this.cw != null) {
                    this.cw.j(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i6 == 8160) {
                    return (T) Boolean.valueOf(uf());
                }
                if (i6 == 6069) {
                    return (T) Integer.valueOf(st());
                }
                if (i6 == 8185) {
                    com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar10 = this.qv;
                    if (jVar10 != null) {
                        jVar10.j();
                    }
                } else if (i6 == 8184) {
                    com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar11 = this.qv;
                    if (jVar11 != null) {
                        jVar11.xt();
                    }
                } else {
                    if (i6 == 8196) {
                        return (T) Boolean.valueOf(aq());
                    }
                    if (i6 == 8197) {
                        com.bytedance.msdk.api.r.j.r rVar = this.f25341r;
                        if (rVar != null) {
                            rVar.j();
                        }
                    } else if (i6 == 8227) {
                        if (pluginValueSet != null) {
                            r((Map<String, Object>) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i6 == 6107 && this.up != null) {
                        this.up.j(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.bytedance.msdk.core.av.j.j(cls);
    }

    @Override // com.bytedance.msdk.xt.cw
    public String ae() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.ae();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8163).j(String.class).xt());
        return apply instanceof String ? apply.toString() : "";
    }

    @Override // com.bytedance.msdk.xt.cw
    public void cw() {
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6093).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public int el() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.el();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8161).j(Integer.class).xt());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
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
    public int hu() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.el();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8162).j(Integer.class).xt());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.xt.cw
    public double hw() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.hw();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8268).j(Double.class).xt());
        if (apply instanceof Double) {
            return ((Double) apply).doubleValue();
        }
        return 0.0d;
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
            return apply.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public View oq() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.oq();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6164).j(View.class).xt());
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public int r() {
        Object apply;
        if (((r) this).f25000g == null) {
            return super.r();
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(o.a.f41411r).j(Integer.class).xt());
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.xt.cw
    public com.bytedance.msdk.api.r.j.ae.up tl() {
        Object apply;
        if (((r) this).f25000g == null) {
            return null;
        }
        apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8320).j(a.a()).xt());
        if (f.a(apply)) {
            return com.bytedance.msdk.core.j.j.j(b.a(apply));
        }
        return null;
    }

    @Override // com.bytedance.msdk.xt.cw
    public vl zk() {
        Object apply;
        if (((r) this).f25000g != null) {
            apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8269).j(Map.class).xt());
            if (apply instanceof Map) {
                Map map = (Map) apply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get("width");
                final Object obj3 = map.get("height");
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get("duration");
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new vl() { // from class: com.bytedance.msdk.cw.j.ae.1
                            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
                            public String cw() {
                                return str;
                            }

                            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
                            public int j() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
                            public double r() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
                            public boolean up() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }

                            @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
                            public int xt() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }
                        };
                    }
                }
            }
        }
        return super.zk();
    }

    public ae(com.bytedance.msdk.cw.m.xt.j jVar, com.bytedance.msdk.cw.cw.xt.j.cw cwVar) {
        super(jVar);
        this.vl = cwVar;
    }

    @Override // com.bytedance.msdk.xt.cw
    public Bitmap ja() {
        Object apply;
        if (TextUtils.equals(zz(), MediationConstant.ADN_GDT) && com.bytedance.msdk.core.j.j.up.j(MediationConstant.ADN_GDT)) {
            return kt.r(com.bytedance.msdk.core.xt.getContext(), "tt_adapter_gdt_logo");
        }
        if (TextUtils.equals(zz(), MediationConstant.ADN_KS) && com.bytedance.msdk.core.j.j.up.j(MediationConstant.ADN_KS)) {
            return kt.r(com.bytedance.msdk.core.xt.getContext(), "tt_adapter_ks_logo");
        }
        if (TextUtils.equals(zz(), "baidu") && com.bytedance.msdk.core.j.j.up.j("baidu")) {
            return kt.r(com.bytedance.msdk.core.xt.getContext(), "tt_adapter_baidu_logo");
        }
        if (((r) this).f25000g != null) {
            apply = ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8267).j(Bitmap.class).xt());
            if (apply instanceof Bitmap) {
                return (Bitmap) apply;
            }
            return null;
        }
        return super.ja();
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        return com.bytedance.msdk.core.j.j.up.j(zz(), ((r) this).f25000g);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void qv() {
        super.qv();
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6083).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt() {
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8192).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        this.qv = jVar;
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6085).j(Void.class).j(20033, activity).xt());
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, oq oqVar, List<View> list4) {
        super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
        xt(activity, viewGroup, list, list2, list3, oqVar, list4);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j() {
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(HmsScanBase.ALL_SCAN_TYPE).j(Void.class).xt());
        }
    }
}
