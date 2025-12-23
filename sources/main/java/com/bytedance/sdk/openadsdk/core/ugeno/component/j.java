package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.m.r;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.g.xt;
import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw<RoundImageView> {

    /* renamed from: j, reason: collision with root package name */
    protected String f30626j;
    protected int ll;

    private void tl() {
        if (TextUtils.isEmpty(this.f30626j)) {
            return;
        }
        ((RoundImageView) this.up).setImageDrawable(null);
        if (this.f30626j.startsWith("local://")) {
            ae.j(new g("UG_decode_img") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.j.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap decodeResource = BitmapFactory.decodeResource(((cw) j.this).xt.getResources(), r.cw(((cw) j.this).xt, j.this.f30626j.replace("local://", "")));
                    if (decodeResource != null) {
                        j.this.j(decodeResource);
                    }
                }
            });
        } else {
            xt.j(this.f30626j).cw(2).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.j.2
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv qvVar) {
                    Object cw = qvVar.cw();
                    if (cw == null || !(cw instanceof Bitmap)) {
                        return;
                    }
                    j.this.j((Bitmap) cw);
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                    vl.xt("UGBlurWidget", str, th);
                }
            }, 4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public RoundImageView j() {
        RoundImageView roundImageView = new RoundImageView(this.xt);
        roundImageView.j(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        tl();
        ((RoundImageView) this.up).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.up).setBorderColor(this.xq);
        ((RoundImageView) this.up).setCornerRadius(this.ol);
        ((RoundImageView) this.up).setBorderWidth(this.sm);
    }

    public j(Context context) {
        super(context);
        this.ll = 25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        final Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(this.xt, bitmap, 25);
        if (j6 != null) {
            ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.j.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((cw) j.this).up != null) {
                        ((RoundImageView) ((cw) j.this).up).setImageBitmap(j6);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        if (!str.equals("blurRate")) {
            if (str.equals("src")) {
                this.f30626j = str2;
            }
        } else {
            try {
                this.ll = Integer.parseInt(str2);
            } catch (Exception e6) {
                vl.xt("UGBlurWidget", e6);
            }
        }
    }
}
