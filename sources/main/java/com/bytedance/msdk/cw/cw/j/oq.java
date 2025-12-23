package com.bytedance.msdk.cw.cw.j;

import android.text.TextUtils;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq extends xt {
    private final List<com.bytedance.msdk.core.oq.oq> ae;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.msdk.core.oq.xt f24837m;
    private final HashSet<String> tl = new HashSet<>();
    private final com.bytedance.msdk.cw.m.j.xt up;

    @Override // com.bytedance.msdk.cw.cw.j.xt
    public boolean xt(com.bytedance.msdk.core.oq.oq oqVar, int i6) {
        com.bytedance.msdk.core.oq.oq m6;
        if (i6 == 1) {
            com.bytedance.msdk.core.oq.oq m7 = m();
            if (m7 != null && oqVar != null && TextUtils.equals(m7.w(), oqVar.w())) {
                cw();
                return true;
            }
        } else if (i6 == 2) {
            if (oqVar != null) {
                this.tl.add(oqVar.w());
                CopyOnWriteArrayList<com.bytedance.msdk.xt.cw> tl = this.up.tl();
                com.bytedance.msdk.xt.cw cwVar = (tl == null || tl.size() <= 0) ? null : tl.get(0);
                if (cwVar != null && (m6 = m()) != null && TextUtils.equals(m6.w(), cwVar.qa())) {
                    cw();
                    return true;
                }
            }
            if (this.xt.tl()) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24837m) + "全部广告完成响应...");
                if (p.j(this.up.tl())) {
                    j(new com.bytedance.msdk.api.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION, com.bytedance.msdk.api.j.j(IjkMediaPlayer.FFP_PROP_INT64_VIDEO_CACHED_DURATION)));
                }
                return true;
            }
        } else if (this.xt.up()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(this.f24837m) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.xt.up() + "  allWtfFinish:" + this.xt.tl());
            if (p.j(this.up.tl())) {
                j(new com.bytedance.msdk.api.j(10003, com.bytedance.msdk.api.j.j(10003)));
            } else {
                cw();
            }
            return true;
        }
        return false;
    }

    private com.bytedance.msdk.core.oq.oq m() {
        List<com.bytedance.msdk.core.oq.oq> list = this.ae;
        if (list == null) {
            return null;
        }
        for (com.bytedance.msdk.core.oq.oq oqVar : list) {
            if (oqVar != null) {
                if (!this.tl.contains(oqVar.w())) {
                    return oqVar;
                }
            }
        }
        return null;
    }

    public oq(com.bytedance.msdk.cw.m.j.xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2, List<com.bytedance.msdk.core.oq.oq> list) {
        this.up = xtVar;
        this.f24837m = xtVar2;
        this.ae = list;
    }
}
