package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    private com.bykv.vk.openvk.component.video.api.cw.cw ae;
    private Context cw;

    /* renamed from: g, reason: collision with root package name */
    private View f31168g;

    /* renamed from: j, reason: collision with root package name */
    private View f31169j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31170m = false;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.xt f31171r;
    private TTViewStub tl;
    private xt up;
    private TextView xt;

    public enum j {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public interface xt {
        boolean oq();

        void vl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.cw == null) {
            return;
        }
        r();
    }

    private void r() {
        View view = this.f31169j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void xt() {
        this.ae = null;
    }

    public void j(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.f31168g = view;
        this.cw = StubApp.getOrigApplicationContext(v.getContext().getApplicationContext());
        try {
            this.tl = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.tl());
        } catch (Throwable unused) {
        }
    }

    private void j(Context context, View view, boolean z5) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.tl) == null || tTViewStub.getParent() == null || this.f31169j != null) {
            return;
        }
        this.tl.j();
        this.f31169j = view.findViewById(2114387876);
        this.xt = (TextView) view.findViewById(2114387823);
        View findViewById = view.findViewById(2114387886);
        if (z5) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.az.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    az.this.cw();
                    if (az.this.f31171r != null) {
                        az.this.f31171r.j(j.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            findViewById.setOnClickListener(null);
            findViewById.setClickable(false);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.nativevideo.xt xtVar, xt xtVar2) {
        this.up = xtVar2;
        this.f31171r = xtVar;
    }

    public boolean j(int i6, com.bykv.vk.openvk.component.video.api.cw.cw cwVar, boolean z5) {
        Context context = this.cw;
        if (context != null && cwVar != null) {
            try {
                j(context, this.f31168g, z5);
                this.ae = cwVar;
                if (i6 == 1 || i6 == 2) {
                    return j(i6);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
        return true;
    }

    private boolean j(int i6) {
        xt xtVar;
        if (j() || this.f31170m) {
            return true;
        }
        if (this.f31171r != null && (xtVar = this.up) != null) {
            if (xtVar.oq()) {
                this.f31171r.up(null, null);
            }
            this.f31171r.j(j.PAUSE_VIDEO, (String) null);
        }
        j(this.ae, true);
        return false;
    }

    public void j(boolean z5) {
        if (z5) {
            xt();
        }
        r();
    }

    public boolean j() {
        View view = this.f31169j;
        return view != null && view.getVisibility() == 0;
    }

    private void j(com.bykv.vk.openvk.component.video.api.cw.cw cwVar, boolean z5) {
        View view;
        String str;
        View view2;
        if (cwVar == null || (view = this.f31169j) == null || this.cw == null || view.getVisibility() == 0) {
            return;
        }
        xt xtVar = this.up;
        if (xtVar != null) {
            xtVar.vl();
        }
        int ceil = (int) Math.ceil((cwVar.up() * 1.0d) / 1048576.0d);
        if (z5) {
            str = kt.j(this.cw, "tt_video_without_wifi_tips") + ceil + kt.j(this.cw, "tt_video_bytesize_MB") + kt.j(this.cw, "tt_video_bytesize");
        } else {
            str = kt.j(this.cw, "tt_video_without_wifi_tips") + kt.j(this.cw, "tt_video_bytesize");
        }
        ed.j(this.f31169j, 0);
        ed.j(this.xt, str);
        if (!ed.r(this.f31169j) || (view2 = this.f31169j) == null) {
            return;
        }
        view2.bringToFront();
    }
}
