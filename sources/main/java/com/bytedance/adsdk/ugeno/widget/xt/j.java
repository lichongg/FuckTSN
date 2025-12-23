package com.bytedance.adsdk.ugeno.widget.xt;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.xt;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j extends xt {
    private int qe;

    public abstract String qv(String str);

    @Override // com.bytedance.adsdk.ugeno.widget.image.xt
    protected String ae() {
        return ResIdentify.RES_TYPE_DRAWABLE;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        ((xt) this).f23826j = jy(((xt) this).f23826j);
        super.xt();
        ((RoundImageView) this.up).setColorFilter(this.qe);
        ((RoundImageView) this.up).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public j(Context context) {
        super(context);
        this.qe = ViewCompat.MEASURED_STATE_MASK;
    }

    private String jy(String str) {
        String qv = qv(str);
        if (TextUtils.isEmpty(qv)) {
            return "";
        }
        return "local://".concat(String.valueOf(qv));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        if (!str.equals("textColor")) {
            return;
        }
        this.qe = com.bytedance.adsdk.ugeno.m.j.j(str2);
    }
}
