package com.bytedance.msdk.cw.j;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.umeng.analytics.pro.o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends r {
    @Override // com.bytedance.msdk.xt.cw
    public void j(Activity activity, Object obj, String str) {
        super.j(activity, obj, str);
        if (((r) this).f25000g != null) {
            ((r) this).f25000g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8113).j(Void.class).j(20033, activity).xt());
        }
    }

    private com.bytedance.msdk.api.r.j.tl.j os() {
        return (com.bytedance.msdk.api.r.j.tl.j) this.ae;
    }

    private com.bytedance.msdk.api.r.j.tl.j to() {
        return (com.bytedance.msdk.api.r.j.tl.j) this.tl;
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
            return apply.toString();
        }
        return null;
    }

    public tl(com.bytedance.msdk.cw.m.xt.j jVar) {
        super(jVar);
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        return com.bytedance.msdk.core.j.j.up.j(zz(), ((r) this).f25000g);
    }

    @Override // com.bytedance.msdk.cw.j.r
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        String str;
        if (i6 == 8115) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().j_();
            }
        } else if (i6 == 8116) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().cw();
            }
        } else if (i6 == 8117) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().up();
            }
        } else if (i6 == 8118) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().r();
            }
        } else if (i6 == 8119) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().m();
            }
        } else if (i6 == 8230) {
            if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                os().i_();
            }
        } else {
            if (i6 == 8231) {
                if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    final boolean booleanValue = pluginValueSet.booleanValue(8017);
                    final float intValue = pluginValueSet.intValue(8018);
                    final String stringValue = pluginValueSet.stringValue(8019);
                    Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                    final HashMap hashMap = new HashMap();
                    if (map != null) {
                        hashMap.putAll(map);
                    }
                    com.bytedance.msdk.api.cw.j jVar = new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.j.tl.1
                        @Override // com.bytedance.msdk.api.cw.j
                        public String cw() {
                            return stringValue;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public boolean j() {
                            return booleanValue;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public Map<String, Object> r() {
                            return hashMap;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public float xt() {
                            return intValue;
                        }
                    };
                    com.bytedance.sdk.gromore.j.j.up.r.j(jVar, "GMRewardAd reward verify");
                    os().j(jVar);
                }
            } else if (i6 == 1017) {
                if (this.ae instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    int i7 = 0;
                    if (pluginValueSet != null) {
                        i7 = pluginValueSet.intValue(8014, 0);
                        str = pluginValueSet.stringValue(8015);
                    } else {
                        str = "";
                    }
                    os().j(new com.bytedance.msdk.api.j(i7, str));
                }
            } else if (i6 == 8232) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().j_();
                }
            } else if (i6 == 8233) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().cw();
                }
            } else if (i6 == 8234) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().up();
                }
            } else if (i6 == 8235) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().r();
                }
            } else if (i6 == 8236) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().m();
                }
            } else if (i6 == 8237) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    to().i_();
                }
            } else if (i6 == 8238) {
                if (this.tl instanceof com.bytedance.msdk.api.r.j.tl.j) {
                    final boolean booleanValue2 = pluginValueSet.booleanValue(8017);
                    final float intValue2 = pluginValueSet.intValue(8018);
                    final String stringValue2 = pluginValueSet.stringValue(8019);
                    Map map2 = (Map) pluginValueSet.objectValue(8020, Map.class);
                    final HashMap hashMap2 = new HashMap();
                    if (map2 != null) {
                        hashMap2.putAll(map2);
                    }
                    com.bytedance.msdk.api.cw.j jVar2 = new com.bytedance.msdk.api.cw.j() { // from class: com.bytedance.msdk.cw.j.tl.2
                        @Override // com.bytedance.msdk.api.cw.j
                        public String cw() {
                            return stringValue2;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public boolean j() {
                            return booleanValue2;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public Map<String, Object> r() {
                            return hashMap2;
                        }

                        @Override // com.bytedance.msdk.api.cw.j
                        public float xt() {
                            return intValue2;
                        }
                    };
                    com.bytedance.sdk.gromore.j.j.up.r.j(jVar2, "GMRewardAd play again reward verify");
                    to().j(jVar2);
                }
            } else if (i6 == 8111) {
                j(pluginValueSet.doubleValue(8016));
            }
            return (T) com.bytedance.msdk.core.av.j.j(cls);
        }
        return (T) com.bytedance.msdk.core.av.j.j(cls);
    }
}
