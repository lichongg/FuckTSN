package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends cw<NativeVideoView> {

    /* renamed from: d, reason: collision with root package name */
    private j f30656d;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30657j;
    private String ll;
    private String oy;
    private n px;
    private com.bykv.vk.openvk.component.video.api.cw.cw qe;
    private boolean xw;
    private String yl;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class j implements cw.j {

        /* renamed from: j, reason: collision with root package name */
        cw.j f30658j;

        private j() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
        public void j(long j6, int i6) {
            if (xt.this.f30657j) {
                if (((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up).setComplete(true);
                }
                if (((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up).j(true, true);
                }
            }
            cw.j jVar = this.f30658j;
            if (jVar != null) {
                jVar.j(j6, i6);
            }
        }

        /* synthetic */ j(xt xtVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
        public void xt(long j6, int i6) {
            cw.j jVar = this.f30658j;
            if (jVar != null) {
                jVar.xt(j6, i6);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
        public void j() {
            cw.j jVar = this.f30658j;
            if (jVar != null) {
                jVar.j();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.j
        public void j(long j6, long j7) {
            cw.j jVar = this.f30658j;
            if (jVar != null) {
                jVar.j(j6, j7);
            }
        }
    }

    public void qb() {
        j((com.bytedance.sdk.openadsdk.core.multipro.xt.j) null);
    }

    private void zz() {
        if (!this.f30657j) {
            this.px = new n();
            this.qe = new com.bykv.vk.openvk.component.video.api.cw.cw();
            return;
        }
        if (!TextUtils.isEmpty(this.yl)) {
            try {
                this.px = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(this.yl));
                this.yl = null;
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        n nVar = this.px;
        if (nVar == null) {
            this.px = new n();
            this.qe = new com.bykv.vk.openvk.component.video.api.cw.cw();
            return;
        }
        com.bykv.vk.openvk.component.video.api.cw.cw ws = ln.ws(nVar);
        this.qe = ws;
        if (ws == null) {
            this.qe = new com.bykv.vk.openvk.component.video.api.cw.cw();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public NativeVideoView j() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.xt);
        nativeVideoView.j(this);
        return nativeVideoView;
    }

    public boolean ff() {
        com.bykv.vk.openvk.component.video.api.j i6;
        T t5 = this.up;
        if (t5 == 0 || ((NativeVideoView) t5).getNativeVideoController() == null || (i6 = ((NativeVideoView) this.up).getNativeVideoController().i()) == null) {
            return false;
        }
        return i6.g();
    }

    public boolean k() {
        com.bykv.vk.openvk.component.video.api.j i6;
        T t5 = this.up;
        if (t5 == 0 || ((NativeVideoView) t5).getNativeVideoController() == null || (i6 = ((NativeVideoView) this.up).getNativeVideoController().i()) == null) {
            return false;
        }
        return i6.jy();
    }

    public void r(boolean z5) {
        this.xw = z5;
        T t5 = this.up;
        if (t5 == 0 || ((NativeVideoView) t5).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.up).getNativeVideoController().xt(z5);
    }

    public void sm() {
        T t5 = this.up;
        if (t5 != 0) {
            ((NativeVideoView) t5).tl();
            if (this.f30657j) {
                ((NativeVideoView) this.up).j(true, false);
            } else {
                ((NativeVideoView) this.up).j(this.oy);
            }
        }
    }

    public boolean tl() {
        T t5 = this.up;
        return (t5 == 0 || ((NativeVideoView) t5).getNativeVideoController() == null) ? this.xw : ((NativeVideoView) this.up).getNativeVideoController().mi();
    }

    public void up(boolean z5) {
        T t5 = this.up;
        if (t5 != 0) {
            ((NativeVideoView) t5).setNeedNativeVideoPlayBtnVisible(z5);
        }
    }

    public void xq() {
        T t5 = this.up;
        if (t5 != 0) {
            ((NativeVideoView) t5).up();
            ((NativeVideoView) this.up).j(this.oy);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        zz();
        this.qe.cw(this.ll);
        this.qe.j(this.jy + "x" + this.ws);
        this.qe.xt(this.oy);
        this.px.j(this.qe);
        ((NativeVideoView) this.up).setMaterialMeta(this.px);
        ((NativeVideoView) this.up).setIsAutoPlay(true);
        ((NativeVideoView) this.up).setIsQuiet(this.xw);
        ((NativeVideoView) this.up).setVisibility(0);
        ((NativeVideoView) this.up).setEnableAutoCheck(false);
        ((NativeVideoView) this.up).j(this.xt, 25, this.oy);
        ((NativeVideoView) this.up).j(0L, true, false);
        ((NativeVideoView) this.up).j(this.oy);
        com.bykv.vk.openvk.component.video.api.r.cw nativeVideoController = ((NativeVideoView) this.up).getNativeVideoController();
        if (nativeVideoController != null) {
            j jVar = new j(this, null);
            this.f30656d = jVar;
            nativeVideoController.j(jVar);
        }
    }

    public void ya() {
        T t5 = this.up;
        if (t5 != 0) {
            ((NativeVideoView) t5).M_();
        }
    }

    public xt(Context context) {
        super(context);
        this.xw = false;
    }

    public void j(com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar) {
        n nVar;
        if (oq() != null && (nVar = this.px) != null) {
            if (nVar.ve() == 0) {
                int optInt = oq().optInt("image_mode");
                this.px.uf(optInt);
                this.px.j(new ed(oq()));
                if (optInt == 166) {
                    this.px.b(-2);
                    ((NativeVideoView) this.up).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.up).setPlayerType(0);
        }
        if (jVar != null) {
            com.bykv.vk.openvk.component.video.api.r.cw nativeVideoController = ((NativeVideoView) this.up).getNativeVideoController();
            nativeVideoController.r(jVar.f29583r);
            nativeVideoController.xt(jVar.tl);
            if (jVar.f29581j) {
                nativeVideoController.xt(0L);
            } else {
                nativeVideoController.xt(jVar.ae);
            }
        }
        ((NativeVideoView) this.up).r();
    }

    public void ry() {
        if (ff()) {
            T t5 = this.up;
            if (t5 != 0) {
                ((NativeVideoView) t5).w();
                return;
            }
            return;
        }
        if (k()) {
            sm();
        } else {
            ya();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(JSONObject jSONObject) {
        super.j(jSONObject);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "coverSrc":
                this.oy = str2;
                break;
            case "src":
                this.ll = str2;
                break;
            case "isLp":
                try {
                    boolean booleanValue = Boolean.valueOf(str2).booleanValue();
                    this.f30657j = booleanValue;
                    T t5 = this.up;
                    if (t5 != 0) {
                        ((NativeVideoView) t5).setLp(booleanValue);
                        break;
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.yl = str2;
                break;
        }
    }

    public void j(Map<String, Object> map) {
        T t5 = this.up;
        if (t5 != 0) {
            ((NativeVideoView) t5).setExtraMap(map);
        }
    }
}
