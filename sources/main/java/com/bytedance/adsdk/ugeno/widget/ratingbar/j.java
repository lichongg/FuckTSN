package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<UGRatingBar> {
    private static final int px = Color.parseColor("#FFC642");
    private static final int xw = Color.parseColor("#e3e3e4");

    /* renamed from: j, reason: collision with root package name */
    private int f23846j;
    private int ll;
    private float oy;
    private float qe;
    private float yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UGRatingBar j() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.xt);
        uGRatingBar.j(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.f23846j = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.ll = com.bytedance.adsdk.ugeno.m.j.j(str2, xw);
                break;
            case "gap":
                this.qe = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case "size":
                this.yl = com.bytedance.adsdk.ugeno.m.cw.j(str2, 20.0f);
                break;
            case "score":
                this.oy = com.bytedance.adsdk.ugeno.m.cw.j(str2, 4.0f);
                break;
        }
    }

    public j(Context context) {
        super(context);
        this.f23846j = px;
        this.ll = xw;
        this.oy = 4.0f;
        this.yl = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        if (p()) {
            ((UGRatingBar) this.up).j(this.oy, this.f23846j, this.ll, this.yl, (int) this.qe);
        } else {
            ((UGRatingBar) this.up).j(this.oy, this.f23846j, this.ll, this.yl, 5);
        }
    }
}
