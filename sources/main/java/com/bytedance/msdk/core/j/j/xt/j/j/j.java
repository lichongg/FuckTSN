package com.bytedance.msdk.core.j.j.xt.j.j;

import a1.a;
import a1.b;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.g;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.core.j.j.xt.j {
    private void ae() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40031).j(50014, Integer.valueOf((int) this.f24490j.ws())).j(Void.class).xt());
        }
    }

    private void m() {
        if (this.cw == null || this.f24490j == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40068).j(10004, new C0354j(this)).j(10013, 1).j(Void.class).xt());
    }

    private void r() {
        HashMap hashMap = new HashMap();
        g xt = com.bytedance.msdk.core.j.qv().p().xt();
        if (xt != null) {
            hashMap.put(d.D, String.valueOf(xt.xt()));
            hashMap.put(d.C, String.valueOf(xt.j()));
            hashMap.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (hashMap.isEmpty() || this.cw == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40025).j(50010, hashMap).j(Void.class).xt());
    }

    private void tl() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40018).j(50010, this.f24490j.c()).j(Void.class).xt());
        }
    }

    private void up() {
        if (this.cw == null || this.f24490j == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40037).j(10004, new C0354j(this)).j(10013, 1).j(Void.class).xt());
    }

    /* renamed from: com.bytedance.msdk.core.j.j.xt.j.j.j$j, reason: collision with other inner class name */
    static class C0354j extends com.bytedance.sdk.openadsdk.core.wq.r {
        private r cw;

        /* renamed from: j, reason: collision with root package name */
        private com.bytedance.msdk.core.j.j.xt.j f24546j;
        private volatile boolean xt = false;

        public C0354j(com.bytedance.msdk.core.j.j.xt.j jVar) {
            this.f24546j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.r
        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
            com.bytedance.msdk.core.j.j.xt.j jVar;
            if (i6 == 60008) {
                if (!this.xt) {
                    this.xt = true;
                    Function a6 = b.a(pluginValueSet.objectValue(50005, a.a()));
                    com.bytedance.msdk.core.j.j.xt.j jVar2 = this.f24546j;
                    if (jVar2 != null) {
                        if (a6 != null) {
                            xt xtVar = new xt(jVar2, a6);
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(xtVar);
                            this.f24546j.j(arrayList);
                            return null;
                        }
                        jVar2.j(-999, "adn return data is null");
                        return null;
                    }
                    return null;
                }
                return null;
            }
            if (i6 == 60001) {
                if (!this.xt) {
                    this.xt = true;
                    if (this.f24546j != null) {
                        com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar2 = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
                        this.f24546j.j(xtVar2.j(), xtVar2.xt());
                        return null;
                    }
                    return null;
                }
                return null;
            }
            if (i6 == 60000) {
                Function a7 = b.a(pluginValueSet.objectValue(50005, a.a()));
                if (a7 != null) {
                    if (this.f24546j.j()) {
                        r rVar = new r(this.f24546j, a7);
                        this.cw = rVar;
                        rVar.qv();
                        return null;
                    }
                    com.bytedance.msdk.core.j.j.xt.j jVar3 = this.f24546j;
                    if (jVar3 != null) {
                        cw cwVar = new cw(jVar3, a7);
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(cwVar);
                        this.f24546j.j(arrayList2);
                        return null;
                    }
                    return null;
                }
                com.bytedance.msdk.core.j.j.xt.j jVar4 = this.f24546j;
                if (jVar4 != null) {
                    jVar4.j(-999, "adn return data is null");
                    return null;
                }
                return null;
            }
            if (i6 == 60017 && (jVar = this.f24546j) != null) {
                if (this.cw != null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(this.cw);
                    this.f24546j.j(arrayList3);
                    return null;
                }
                jVar.j(-999, "adn return data is null");
                return null;
            }
            return null;
        }
    }

    private void cw(Context context) {
        if (this.xt != null) {
            r(context);
            g();
            oq();
            up();
        }
    }

    private void g() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40019).j(50010, this.f24490j.c()).j(Void.class).xt());
        }
    }

    private void oq() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40020).j(50010, this.f24490j.c()).j(Void.class).xt());
        }
    }

    private void qv() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40067).j(50022, 0).j(Void.class).xt());
        }
    }

    private void vl() {
        if (this.cw == null || this.xt == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40002).j(10004, new C0354j(this)).j(Void.class).xt());
    }

    @Override // com.bytedance.msdk.core.j.j.xt.j
    protected void j(final Context context) {
        if (cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt(context);
                }
            });
        } else {
            xt(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(Context context) {
        r();
        oq oqVar = this.xt;
        if (oqVar != null) {
            if (oqVar.m() == 4) {
                int oq = this.xt.oq();
                if (oq == 1) {
                    up(context);
                    return;
                } else if (oq == 2) {
                    cw(context);
                    return;
                } else {
                    ae(context);
                    return;
                }
            }
            ae(context);
        }
    }

    private void ae(Context context) {
        tl(context);
        qv();
        vl();
    }

    private void tl(Context context) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40066).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(10000, context).j(Void.class).xt());
        }
    }

    private void m(Context context) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40030).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(10000, context).j(50002, xt()).j(Void.class).xt());
        }
    }

    private void up(Context context) {
        if (this.xt != null) {
            ae();
            m(context);
            g();
            oq();
            tl();
            m();
        }
    }

    private void r(Context context) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40036).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(10000, context).j(50002, xt()).j(Void.class).xt());
        }
    }
}
