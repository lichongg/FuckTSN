package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<UGProgressBar> {

    /* renamed from: j, reason: collision with root package name */
    private int f23842j;
    private int ll;
    private String oy;
    private float px;
    private float qe;
    private int yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UGProgressBar j() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.xt);
        uGProgressBar.j(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "progressBgColor":
                this.ll = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "textColor":
                this.yl = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "textSize":
                this.qe = tl.j(this.xt, str2);
                break;
            case "progress":
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case "text":
                this.oy = str2;
                break;
            case "progressColor":
                this.f23842j = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((UGProgressBar) this.up).setBackgroundColor(this.ll);
        ((UGProgressBar) this.up).setText(this.oy);
        ((UGProgressBar) this.up).setProgressBgColor(this.ll);
        ((UGProgressBar) this.up).setProgressColor(this.f23842j);
        ((UGProgressBar) this.up).setTextColor(this.yl);
    }
}
