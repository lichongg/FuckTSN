package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<DislikeView> {

    /* renamed from: j, reason: collision with root package name */
    private int f23809j;
    private int ll;
    private int oy;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public DislikeView j() {
        DislikeView dislikeView = new DislikeView(this.xt);
        dislikeView.j(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "dislikeColor":
                this.f23809j = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "dislikeWidth":
                this.ll = (int) tl.j(this.xt, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.oy = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
        }
    }

    public j(Context context) {
        super(context);
        this.f23809j = 0;
        this.oy = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((DislikeView) this.up).setRadius(this.ol);
        ((DislikeView) this.up).setStrokeWidth((int) this.sm);
        ((DislikeView) this.up).setDislikeColor(this.f23809j);
        ((DislikeView) this.up).setStrokeColor(this.xq);
        ((DislikeView) this.up).setDislikeWidth(this.ll);
        ((DislikeView) this.up).setBgColor(this.oy);
    }
}
