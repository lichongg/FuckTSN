package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.widget.az;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private m f31032j;

    public boolean j() {
        az azVar = this.f31032j.f31033a;
        boolean j6 = azVar != null ? azVar.j() : false;
        StringBuilder sb = new StringBuilder("isVisible=");
        sb.append(j6);
        sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
        sb.append(this.f31032j.cw.getVisibility() == 0);
        vl.j("ClickCreativeListener", sb.toString());
        return j6 || this.f31032j.cw.getVisibility() == 0;
    }

    public boolean xt() {
        View view;
        RoundImageView roundImageView;
        TextView textView;
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.f31032j.ch)) {
            return true;
        }
        View view2 = this.f31032j.tl;
        return (view2 != null && view2.getVisibility() == 0) || ((view = this.f31032j.oq) != null && view.getVisibility() == 0) || (((roundImageView = this.f31032j.qv) != null && roundImageView.getVisibility() == 0) || ((textView = this.f31032j.vl) != null && textView.getVisibility() == 0));
    }

    public ae(m mVar) {
        this.f31032j = mVar;
    }
}
