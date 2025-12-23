package com.bytedance.adsdk.ugeno.widget.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.j;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.r;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.xt;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends xt {

    /* renamed from: d, reason: collision with root package name */
    private j.C0322j f23837d;
    private boolean fx;
    private String oy;
    private String px;
    private String qe;
    private boolean tk;
    private int wi;
    private int xw;
    private String yl;

    @Override // com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        tl();
        ((UGTextView) this.up).setGravity(17);
    }

    private void tl() {
        if (TextUtils.isEmpty(this.oy)) {
            return;
        }
        ((UGTextView) this.up).setCompoundDrawables(null, null, null, null);
        if (!this.oy.startsWith("local://")) {
            r.j().xt().j(this.f23861g, this.oy, new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.widget.j.j.1
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.j.j.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.xt(new BitmapDrawable(((cw) j.this).xt.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String replace = this.oy.replace("local://", "");
            Context context = this.xt;
            xt(tl.j(context, com.bytedance.adsdk.ugeno.m.r.xt(context, replace)));
        } catch (Throwable unused) {
        }
    }

    public j(Context context) {
        super(context);
        this.yl = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "direction":
                this.yl = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.wi = com.bytedance.adsdk.ugeno.m.j.j(str2);
                this.tk = true;
                break;
            case "image":
                this.oy = str2;
                break;
            case "highlightImage":
                this.qe = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.m.j.cw(str2)) {
                    this.f23875u = true;
                    this.f23837d = com.bytedance.adsdk.ugeno.m.j.xt(str2);
                } else {
                    this.xw = com.bytedance.adsdk.ugeno.m.j.j(str2);
                    this.f23875u = false;
                }
                this.fx = true;
                break;
            case "highlightBackgroundImage":
                this.px = str2;
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected void n() {
        super.n();
        if (this.tk) {
            ((UGTextView) this.up).setTextColor(this.wi);
        }
        if (this.fx) {
            if (this.f23875u) {
                j(this.f23837d);
            } else {
                cw(this.xw);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected void nd() {
        super.nd();
        if (this.tk) {
            ((UGTextView) this.up).setTextColor(((xt) this).ll);
        }
        if (this.fx) {
            if (this.f23875u) {
                j(this.wo);
            } else {
                cw(this.ed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public void xt(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        String str = this.yl;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    ((UGTextView) this.up).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
                    return;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    ((UGTextView) this.up).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                    return;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    ((UGTextView) this.up).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    return;
                }
                break;
            case 113114:
                str.equals("row");
                break;
        }
        ((UGTextView) this.up).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
