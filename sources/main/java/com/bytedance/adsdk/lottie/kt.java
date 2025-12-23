package com.bytedance.adsdk.lottie;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class kt {
    private final tl cw;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, String> f23323j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f23324r;
    private final LottieAnimationView xt;

    kt() {
        this.f23323j = new HashMap();
        this.f23324r = true;
        this.xt = null;
        this.cw = null;
    }

    public String j(String str) {
        return str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String cw(String str, String str2) {
        if (this.f23324r && this.f23323j.containsKey(str2)) {
            return this.f23323j.get(str2);
        }
        String j6 = j(str, str2);
        if (this.f23324r) {
            this.f23323j.put(str2, j6);
        }
        return j6;
    }

    public String j(String str, String str2) {
        return j(str2);
    }

    public void xt(String str, String str2) {
        this.f23323j.put(str, str2);
        j();
    }

    private void j() {
        LottieAnimationView lottieAnimationView = this.xt;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.invalidateSelf();
        }
    }

    public kt(LottieAnimationView lottieAnimationView) {
        this.f23323j = new HashMap();
        this.f23324r = true;
        this.xt = lottieAnimationView;
        this.cw = null;
    }
}
