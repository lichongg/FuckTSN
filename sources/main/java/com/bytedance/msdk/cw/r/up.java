package com.bytedance.msdk.cw.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.msdk.core.up.xt.r;
import com.bytedance.msdk.tl.la;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends xt implements com.bytedance.msdk.core.up.xt.cw {
    private List<com.bytedance.msdk.core.oq.oq> av;

    /* renamed from: j, reason: collision with root package name */
    private final int f25100j;
    private r.cw xt;

    @Override // com.bytedance.msdk.core.up.xt.cw
    public void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, r.cw cwVar2) {
        this.xt = cwVar2;
        j(xtVar);
        this.cw.j(true);
        this.cw.r(true);
        this.cw.mi().j(xtVar.j());
        com.bytedance.msdk.core.oq.xt j6 = j(this.ae, cwVar);
        this.ae = j6;
        this.cw.j(j6);
        this.f25122m.m(1);
        com.bytedance.msdk.core.oq.xt j7 = com.bytedance.msdk.core.cw.cw.j(this.f25122m, this.ae);
        if (j7 != null) {
            this.ae = j7;
            this.cw.j(j7);
        }
        com.bytedance.msdk.core.oq.xt xtVar2 = this.ae;
        if (xtVar2 == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，mRitConfig为null");
            r.cw cwVar3 = this.xt;
            if (cwVar3 != null) {
                cwVar3.j(this.up, false, 0, null);
                return;
            }
            return;
        }
        List<com.bytedance.msdk.core.oq.oq> ol = xtVar2.ol();
        if (ol == null || ol.size() <= 0) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            r.cw cwVar4 = this.xt;
            if (cwVar4 != null) {
                cwVar4.j(this.up, false, 0, null);
                return;
            }
            return;
        }
        this.ae.m((long) (r6.c() * this.ae.cw()));
        this.ae.up((long) (r6.ed() * this.ae.xt()));
        this.ae.xt(false);
        this.ae.j(false);
        List<com.bytedance.msdk.core.oq.oq> ol2 = this.ae.ol();
        this.av = ol2;
        la.j(ol2, this.az);
        if (com.bytedance.msdk.j.up.cw.xt()) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.bytedance.msdk.core.oq.oq oqVar : this.av) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.up) + "waterfall: " + oqVar.az() + "adnSlotId: " + oqVar.w() + ", loadSort: " + oqVar.x() + ", showSort: " + oqVar.ch() + ", eCpm: " + oqVar.v());
            }
        }
        g();
    }

    @Override // com.bytedance.msdk.cw.r.xt
    protected com.bytedance.msdk.cw.cw.j.ae g() {
        ArrayList arrayList = new ArrayList();
        int i6 = this.f25100j;
        if (i6 == 3) {
            arrayList.add(new com.bytedance.msdk.cw.cw.j.g());
        } else if (i6 == 4) {
            arrayList.add(new com.bytedance.msdk.cw.cw.j.oq(this.cw, this.ae, this.av));
        } else {
            arrayList.add(new com.bytedance.msdk.cw.cw.j.xt());
        }
        com.bytedance.msdk.cw.cw.j.ae aeVar = new com.bytedance.msdk.cw.cw.j.ae(arrayList);
        aeVar.j(this.cw);
        return aeVar;
    }

    public up(Context context, int i6) {
        super(context);
        this.f25100j = i6;
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void ae() {
        String str;
        super.ae();
        r.cw cwVar = this.xt;
        if (cwVar != null) {
            com.bytedance.msdk.core.oq.xt xtVar = this.ae;
            if (xtVar != null) {
                str = xtVar.rn();
            } else {
                str = "";
            }
            cwVar.j(str, true, 0, this.cw.tl());
        }
    }

    @Override // com.bytedance.msdk.cw.r.xt, com.bytedance.msdk.cw.xt.j.j
    public void xt(@NonNull com.bytedance.msdk.api.j jVar) {
        String str;
        super.xt(jVar);
        r.cw cwVar = this.xt;
        if (cwVar != null) {
            int i6 = IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION;
            if (jVar != null && jVar.f24334j == 10003) {
                i6 = 10003;
            }
            com.bytedance.msdk.core.oq.xt xtVar = this.ae;
            if (xtVar != null) {
                str = xtVar.rn();
            } else {
                str = "";
            }
            cwVar.j(str, false, i6, null);
        }
    }

    private com.bytedance.msdk.core.oq.xt j(com.bytedance.msdk.core.oq.xt xtVar, com.bytedance.msdk.xt.cw cwVar) {
        if (xtVar == null || cwVar == null) {
            return null;
        }
        double t5 = cwVar.t();
        com.bytedance.msdk.j.up.cw.xt("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(t5)));
        com.bytedance.msdk.core.oq.xt clone = xtVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.bytedance.msdk.core.oq.oq oqVar : clone.ol()) {
            if (oqVar != null && oqVar.uf() && oqVar.v() > t5) {
                copyOnWriteArrayList.add(oqVar);
            }
        }
        if (clone.qv()) {
            clone.xt(copyOnWriteArrayList);
            return clone;
        }
        clone.j(copyOnWriteArrayList);
        return clone;
    }
}
