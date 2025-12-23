package com.bytedance.sdk.openadsdk.ats.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.r.up;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements up {
    private xt xt = new xt();
    private j cw = new j();

    /* renamed from: j, reason: collision with root package name */
    private boolean f27611j = !this.xt.j();

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(1)
    public String j(String str) {
        String j6 = this.xt.j() ? this.xt.j(str) : "";
        return (this.f27611j && TextUtils.isEmpty(j6)) ? this.cw.j(str) : j6;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(3)
    public long cw(String str) {
        long cw = this.xt.j() ? this.xt.cw(str) : Long.MAX_VALUE;
        return (this.f27611j && cw == 2147483647L) ? this.cw.cw(str) : cw;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(4)
    public boolean r(String str) {
        boolean r5 = this.xt.j() ? this.xt.r(str) : false;
        return (!this.f27611j || r5) ? r5 : this.cw.r(str);
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(2)
    public int xt(String str) {
        int xt = this.xt.j() ? this.xt.xt(str) : Integer.MAX_VALUE;
        return (this.f27611j && xt == Integer.MAX_VALUE) ? this.cw.xt(str) : xt;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(5)
    public void j(String str, String str2) {
        if (this.xt.j()) {
            this.xt.j(str, str2);
        }
    }
}
