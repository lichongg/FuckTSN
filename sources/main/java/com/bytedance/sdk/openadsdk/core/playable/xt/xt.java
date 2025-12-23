package com.bytedance.sdk.openadsdk.core.playable.xt;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private boolean f29868j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f29869r;
    private long xt = 0;
    private long cw = 0;

    public void j(final Activity activity, n nVar) {
        if (activity == null || nVar == null || !nVar.qv()) {
            return;
        }
        ed.cw(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.xt.xt.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i6) {
                    if (i6 == 0) {
                        xt.this.j();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.xt.xt.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ed.cw(activity);
                                }
                            }, 5000L);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean xt(Activity activity, n nVar) {
        if (activity != null && nVar != null) {
            boolean z5 = this.f29868j;
            this.f29868j = false;
            if (!nVar.qv() || !z5) {
                return false;
            }
            if (j.j(activity) || xt()) {
                return true;
            }
            try {
                if (!this.f29869r) {
                    return j(activity);
                }
                if (j.j()) {
                    return false;
                }
                return j(activity);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public xt(String str) {
        boolean z5;
        if (!"rewarded_video".equalsIgnoreCase(str) && !"fullscreen_interstitial_ad".equalsIgnoreCase(str)) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.f29869r = z5;
    }

    public void j(int i6) {
        boolean z5 = i6 == 4;
        this.f29868j = z5;
        if (z5) {
            this.xt = System.currentTimeMillis();
        }
    }

    public void j() {
        this.cw = System.currentTimeMillis();
    }

    private boolean j(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean xt() {
        long j6 = this.xt;
        long abs = j6 > 0 ? Math.abs(j6 - this.cw) : -1L;
        return abs >= 0 && abs < 300;
    }
}
