package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.j {
    protected int ae;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.j cw;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f29585g;

    /* renamed from: j, reason: collision with root package name */
    protected Context f29586j;
    private NativeVideoTsView jy;

    /* renamed from: m, reason: collision with root package name */
    protected int f29587m;
    protected boolean oq;
    protected String qv;

    /* renamed from: r, reason: collision with root package name */
    protected Dialog f29588r;
    protected int tl;
    protected String up;
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j vl;
    protected n xt;

    private void j() {
        setTag("tt_express_backup_fl_tag_26");
    }

    private boolean xt() {
        if (r()) {
            return cw();
        }
        n nVar = this.xt;
        return nVar != null && n.xt(nVar);
    }

    protected abstract void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar);

    private boolean cw() {
        com.bykv.vk.openvk.component.video.api.cw.cw ws;
        n nVar = this.xt;
        return (nVar == null || nVar.wf() == 1 || (ws = ln.ws(this.xt)) == null || TextUtils.isEmpty(ws.vl())) ? false : true;
    }

    private boolean r() {
        return TextUtils.equals(this.up, "splash_ad") || TextUtils.equals(this.up, "cache_splash_ad");
    }

    protected String getDescription() {
        return !TextUtils.isEmpty(this.xt.hw()) ? this.xt.hw() : !TextUtils.isEmpty(this.xt.zk()) ? this.xt.zk() : "";
    }

    public n getMeta() {
        return this.xt;
    }

    protected String getNameOrSource() {
        n nVar = this.xt;
        return nVar == null ? "" : (nVar.by() == null || TextUtils.isEmpty(this.xt.by().cw())) ? !TextUtils.isEmpty(this.xt.rs()) ? this.xt.rs() : "" : this.xt.by().cw();
    }

    public float getRealHeight() {
        return ed.r(this.f29586j, this.ae);
    }

    public float getRealWidth() {
        return ed.r(this.f29586j, this.f29587m);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    protected String getTitle() {
        return (this.xt.by() == null || TextUtils.isEmpty(this.xt.by().cw())) ? !TextUtils.isEmpty(this.xt.rs()) ? this.xt.rs() : !TextUtils.isEmpty(this.xt.hw()) ? this.xt.hw() : "" : this.xt.by().cw();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xt.j getVideoModel() {
        return this.vl;
    }

    protected void j(View view, boolean z5) {
        final com.bytedance.sdk.openadsdk.core.xt.xt xtVar;
        if (view == null) {
            return;
        }
        if (z5) {
            Context context = this.f29586j;
            n nVar = this.xt;
            String str = this.up;
            xtVar = new com.bytedance.sdk.openadsdk.core.xt.j(context, nVar, str, uf.xt(str));
        } else {
            Context context2 = this.f29586j;
            n nVar2 = this.xt;
            String str2 = this.up;
            xtVar = new com.bytedance.sdk.openadsdk.core.xt.xt(context2, nVar2, str2, uf.xt(str2));
        }
        view.setOnTouchListener(xtVar);
        view.setOnClickListener(xtVar);
        cw cwVar = new cw() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.cw
            public void j(View view2, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
                try {
                    xVar.j().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).up());
                } catch (JSONException unused) {
                }
                BackupView.this.j(view2, i6, xVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.xt.j.xt.j jVar = (com.bytedance.sdk.openadsdk.core.xt.j.xt.j) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.xt.j.class);
        if (jVar != null) {
            jVar.j(cwVar);
            jVar.j(z5 ? 2 : 1);
        }
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.i.cw.xt.ae aeVar) {
        if (aeVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.j) {
            this.cw = (com.bytedance.sdk.openadsdk.core.dislike.ui.j) aeVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.f29588r = dialog;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.j(this);
    }

    public void up() {
        Dialog dialog = this.f29588r;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.cw;
        if (jVar != null) {
            jVar.j();
        } else {
            TTDelegateActivity.j(getContext(), this.xt);
        }
    }

    public BackupView(Context context) {
        super(context);
        this.up = "embeded_ad";
        this.f29585g = true;
        this.oq = true;
        this.vl = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
        j();
    }

    protected void xt(int i6) {
        this.oq = com.bytedance.sdk.openadsdk.core.v.xt().r(this.tl);
        int ae = com.bytedance.sdk.openadsdk.core.v.xt().ae(i6);
        if (3 == ae) {
            this.f29585g = false;
            return;
        }
        if (1 != ae || !com.bytedance.sdk.component.utils.ws.r(this.f29586j)) {
            if (2 == ae) {
                if (com.bytedance.sdk.component.utils.ws.up(this.f29586j) || com.bytedance.sdk.component.utils.ws.r(this.f29586j) || com.bytedance.sdk.component.utils.ws.m(this.f29586j)) {
                    this.f29585g = true;
                    return;
                }
                return;
            }
            if (5 != ae) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.ws.r(this.f29586j) && !com.bytedance.sdk.component.utils.ws.m(this.f29586j)) {
                return;
            }
        }
        this.f29585g = true;
    }

    protected View j(final NativeExpressView nativeExpressView) {
        BackupView backupView;
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.jy;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.xt != null && this.f29586j != null) {
            if (xt()) {
                try {
                    backupView = this;
                    try {
                        NativeVideoTsView j6 = backupView.j(this.f29586j, this.xt, this.up, true, false);
                        backupView.jy = j6;
                        j6.setAdCreativeClickListener(new NativeVideoTsView.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.j
                            public void j(View view, int i6) {
                                j expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                                if (expressInteractionListener == null) {
                                    return;
                                }
                                expressInteractionListener.j(view, i6);
                            }
                        });
                        backupView.jy.setVideoCacheUrl(backupView.qv);
                        backupView.jy.setControllerStatusCallBack(new NativeVideoTsView.r() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.r
                            public void j(boolean z5, long j7, long j8, long j9, boolean z6, boolean z7) {
                                com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = BackupView.this.vl;
                                jVar.f29581j = z5;
                                jVar.up = j7;
                                jVar.f29582m = j8;
                                jVar.ae = j9;
                                jVar.f29583r = z6;
                                jVar.tl = z7;
                            }
                        });
                        backupView.jy.setIsAutoPlay(backupView.f29585g);
                        backupView.jy.setIsQuiet(backupView.oq);
                    } catch (Throwable unused) {
                        backupView.jy = null;
                        if (xt()) {
                            return backupView.jy;
                        }
                        return null;
                    }
                } catch (Throwable unused2) {
                    backupView = this;
                }
            } else {
                backupView = this;
            }
            if (xt() && (nativeVideoTsView = backupView.jy) != null && nativeVideoTsView.j(0L, true, false)) {
                return backupView.jy;
            }
        }
        return null;
    }

    protected NativeVideoTsView j(Context context, n nVar, String str, boolean z5, boolean z6) {
        return new NativeVideoTsView(context, nVar, str, z5, z6);
    }

    protected void j(View view) {
        if (ln.ws(this.xt) == null || view == null) {
            return;
        }
        j(view, this.xt.k() == 1 && this.f29585g);
    }

    public void b_(int i6) {
    }
}
