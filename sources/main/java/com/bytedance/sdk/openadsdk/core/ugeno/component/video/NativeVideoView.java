package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.r;
import com.bytedance.sdk.openadsdk.l.oq;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeVideoView extends NativeVideoTsView implements cw.j {

    /* renamed from: f, reason: collision with root package name */
    private boolean f30654f;

    /* renamed from: j, reason: collision with root package name */
    private int f30655j;
    private com.bytedance.adsdk.ugeno.cw tj;
    private j xt;

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected cw j(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        j jVar = new j(context, viewGroup, nVar, str, z5, z6, z7);
        this.xt = jVar;
        return jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.r.j
    public void C_() {
        ed.j((View) this.oq, 8);
        super.C_();
    }

    public void M_() {
        j jVar = this.xt;
        if (jVar != null) {
            jVar.tl();
            ed.j((View) this.oq, 8);
        }
    }

    public void j(boolean z5, boolean z6) {
        qv();
        ed.j((View) this.oq, 0);
        ed.j((View) this.jy, z5 ? 0 : 8);
        ed.j((View) this.qv, z6 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        com.bytedance.adsdk.ugeno.cw cwVar = this.tj;
        if (cwVar == null) {
            super.onMeasure(i6, i7);
        } else {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void r() {
        cw cwVar = this.up;
        if (cwVar == null) {
            B_();
        } else if ((cwVar instanceof r) && !av()) {
            ((r) this.up).z();
        }
        if (this.up == null || !this.kt.get()) {
            return;
        }
        this.kt.set(false);
        ae();
        if (!ws()) {
            if (this.up.kt()) {
                ed.j((View) this.oq, 0);
                return;
            }
            vl.j("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            qv();
            ed.j((View) this.oq, 0);
            return;
        }
        ed.j((View) this.oq, 0);
        ImageView imageView = this.vl;
        if (imageView != null) {
            ed.j((View) imageView, 8);
        }
        if (ln.ws(this.f30994r) == null) {
            vl.r("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(4, this.f30994r);
        j6.xt(this.f30994r.fs());
        j6.xt(this.f30990m.getWidth());
        j6.cw(this.f30990m.getHeight());
        j6.cw(this.f30994r.os());
        this.f30994r.b(this.f30655j);
        j6.up(this.f30655j);
        j6.j(oq.j(this.f30994r));
        j6.j(this.up.qv());
        j6.xt(this.up.mi());
        ((r) this.up).up(this.f30655j);
        ((r) this.up).j(this.f30994r);
        j(j6);
        this.up.cw(false);
    }

    public void setExtraMap(Map<String, Object> map) {
        cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.xt(map);
        }
    }

    public void setLp(boolean z5) {
        this.f30654f = z5;
    }

    public void setPlayerType(int i6) {
        this.f30655j = i6;
    }

    public void tl() {
        j jVar = this.xt;
        if (jVar != null) {
            jVar.m();
        }
    }

    public NativeVideoView(Context context) {
        super(context);
        cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.j(true);
        }
        this.kt.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void B_() {
        super.B_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        if (!this.f30654f && i6 == 8) {
            up();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z5) {
        super.setIsAutoPlay(z5);
        ed.j((View) this.oq, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void up() {
        super.up();
        ed.j((View) this.oq, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.r.cw.j
    public void xt(long j6, int i6) {
        super.xt(j6, i6);
        ed.j((View) this.oq, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean j(long j6, boolean z5, boolean z6) {
        this.f30990m.setVisibility(0);
        if (this.up == null) {
            this.up = new r(getContext(), this.ae, this.f30994r, this.az, false, false);
        }
        if (vl() || this.f30984g) {
            j(this.cw, 25, ln.xt(this.f30994r));
        }
        return false;
    }

    public void j(com.bytedance.adsdk.ugeno.cw cwVar) {
        this.tj = cwVar;
    }
}
