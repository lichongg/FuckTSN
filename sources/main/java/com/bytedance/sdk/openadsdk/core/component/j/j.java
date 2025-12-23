package com.bytedance.sdk.openadsdk.core.component.j;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.up.j;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.l.oq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f28035j;
    private final s xt = v.j();

    /* JADX WARN: Multi-variable type inference failed */
    public void xt(final Context context, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        nd ndVar = new nd();
        if (cwVar != 0 && (cwVar instanceof com.bytedance.sdk.openadsdk.core.j.xt)) {
            ndVar.tl = ((com.bytedance.sdk.openadsdk.core.j.xt) cwVar).xt();
        }
        this.xt.j(xtVar, ndVar, 6, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.2
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                cwVar.j(i6, str);
                xtVar2.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(final com.bytedance.sdk.openadsdk.core.tj.j jVar, final com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                ae.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        j.this.xt(jVar, context, xtVar, currentTimeMillis, cwVar, xtVar2);
                    }
                });
            }
        });
    }

    private j() {
    }

    public static j j() {
        if (f28035j == null) {
            synchronized (j.class) {
                try {
                    if (f28035j == null) {
                        f28035j = new j();
                    }
                } finally {
                }
            }
        }
        return f28035j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.openadsdk.core.tj.j jVar, Context context, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, long j6, com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
        if (jVar.xt() != null && !jVar.xt().isEmpty()) {
            List<n> xt = jVar.xt();
            ArrayList arrayList = new ArrayList(xt.size());
            Iterator<n> it = xt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next.sj()) {
                    arrayList.add(new cw(context, next, 6, xtVar));
                }
                if (!n.j(next) || oq.j(next)) {
                    if (!TextUtils.isEmpty(ln.j(next))) {
                        if (v.xt().r(String.valueOf(uf.g(next))) && v.xt().yu()) {
                            if (ln.ws(next) != null) {
                                ln.ws(next).up(1);
                            }
                            if (ln.ws(next) != null) {
                                ln.ws(next).up(1);
                            }
                            r j7 = ln.j(4, next);
                            j7.j("material_meta", next);
                            j7.j("ad_slot", Integer.valueOf(xtVar != null ? xtVar.kt() : 0));
                            com.bytedance.sdk.openadsdk.core.video.r.xt.j(j7, (j.InterfaceC0307j) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(xt.get(0), uf.xt(xtVar.kt()), j6);
                cwVar.j(arrayList);
                return;
            } else {
                cwVar.j(-4, g.j(-4));
                xtVar2.j(-4);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                return;
            }
        }
        cwVar.j(-3, g.j(-3));
        xtVar2.j(-3);
        com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(final Context context, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        nd ndVar = new nd();
        if (cwVar != 0 && (cwVar instanceof com.bytedance.sdk.openadsdk.core.j.xt)) {
            ndVar.tl = ((com.bytedance.sdk.openadsdk.core.j.xt) cwVar).xt();
        }
        this.xt.j(xtVar, ndVar, 5, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.1
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                cwVar.j(i6, str);
                xtVar2.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(final com.bytedance.sdk.openadsdk.core.tj.j jVar, final com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                ae.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        j.this.j(jVar, context, xtVar, currentTimeMillis, cwVar, xtVar2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, Context context, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, long j6, com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
        if (jVar.xt() != null && !jVar.xt().isEmpty()) {
            List<n> xt = jVar.xt();
            ArrayList arrayList = new ArrayList(xt.size());
            Iterator<n> it = xt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next.sj()) {
                    arrayList.add(new cw(context, next, 5, xtVar));
                }
                if (!n.j(next) || oq.j(next)) {
                    if (!TextUtils.isEmpty(ln.j(next))) {
                        if (v.xt().r(String.valueOf(uf.g(next))) && v.xt().yu()) {
                            if (ln.ws(next) != null) {
                                ln.ws(next).up(1);
                            }
                            if (ln.az(next) != null) {
                                ln.az(next).up(1);
                            }
                            r j7 = ln.j(4, next);
                            j7.j("material_meta", next);
                            j7.j("ad_slot", Integer.valueOf(xtVar != null ? xtVar.kt() : 0));
                            com.bytedance.sdk.openadsdk.core.video.r.xt.j(j7, (j.InterfaceC0307j) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(xt.get(0), uf.xt(xtVar.kt()), j6);
                cwVar.j(arrayList);
                return;
            } else {
                cwVar.j(-4, g.j(-4));
                xtVar2.j(-4);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                return;
            }
        }
        cwVar.j(-3, g.j(-3));
        xtVar2.j(-3);
        com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(final Context context, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar2) {
        final long currentTimeMillis = System.currentTimeMillis();
        nd ndVar = new nd();
        if (xtVar2 != 0 && (xtVar2 instanceof com.bytedance.sdk.openadsdk.core.j.xt)) {
            ndVar.tl = ((com.bytedance.sdk.openadsdk.core.j.xt) xtVar2).xt();
        }
        this.xt.j(xtVar, ndVar, 9, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.3
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) {
                xtVar2.j(i6, str);
                xtVar3.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(final com.bytedance.sdk.openadsdk.core.tj.j jVar, final com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) {
                ae.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.j.j.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        j.this.j(jVar, context, xtVar, currentTimeMillis, xtVar2, xtVar3);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, Context context, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, long j6, com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar2, com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) {
        if (jVar.xt() != null && !jVar.xt().isEmpty()) {
            List<n> xt = jVar.xt();
            ArrayList arrayList = new ArrayList(xt.size());
            Iterator<n> it = xt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next.sj()) {
                    arrayList.add(new xt(context, next, 9, xtVar));
                }
                if (!TextUtils.isEmpty(ln.j(next))) {
                    if (v.xt().r(String.valueOf(uf.g(next))) && v.xt().yu()) {
                        if (ln.ws(next) != null) {
                            ln.ws(next).up(1);
                        }
                        if (ln.az(next) != null) {
                            ln.az(next).up(1);
                        }
                        r j7 = ln.j(4, next);
                        j7.j("material_meta", next);
                        j7.j("ad_slot", Integer.valueOf(xtVar != null ? xtVar.kt() : 0));
                        com.bytedance.sdk.openadsdk.core.video.r.xt.j(j7, (j.InterfaceC0307j) null);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(xt.get(0), uf.xt(xtVar.kt()), j6);
                xtVar2.j(arrayList);
                return;
            } else {
                xtVar2.j(-4, g.j(-4));
                xtVar3.j(-4);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar3);
                return;
            }
        }
        xtVar2.j(-3, g.j(-3));
        xtVar3.j(-3);
        com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar3);
    }
}
