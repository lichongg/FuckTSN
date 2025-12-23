package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<RichTextView> {

    /* renamed from: d, reason: collision with root package name */
    private int f23850d;

    /* renamed from: j, reason: collision with root package name */
    private String f23851j;
    private int ll;
    private float oy;
    private int px;
    private int qe;
    private String xw;
    private String yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public RichTextView j() {
        RichTextView richTextView = new RichTextView(this.xt);
        richTextView.j(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "textAlign":
                this.f23850d = qv(str2);
                break;
            case "textColor":
                this.ll = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "textStyle":
                this.yl = str2;
                break;
            case "textSize":
                this.oy = Float.parseFloat(str2);
                break;
            case "text":
                this.f23851j = str2;
                break;
            case "lines":
                this.px = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.qe = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.xw = str2;
                break;
        }
    }

    public j(Context context) {
        super(context);
        this.qe = Integer.MAX_VALUE;
        this.f23850d = 2;
    }

    private int qv(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((RichTextView) this.up).setRichText(this.f23851j);
        ((RichTextView) this.up).setTextSize(1, this.oy);
        ((RichTextView) this.up).setTextColor(this.ll);
        ((RichTextView) this.up).setLines(this.px);
        ((RichTextView) this.up).setMaxLines(this.qe);
        ((RichTextView) this.up).setGravity(this.f23850d);
    }
}
