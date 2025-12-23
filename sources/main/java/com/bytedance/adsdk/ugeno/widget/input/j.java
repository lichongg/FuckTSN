package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw<EditText> {

    /* renamed from: d, reason: collision with root package name */
    private int f23835d;

    /* renamed from: j, reason: collision with root package name */
    private int f23836j;
    private int ll;
    private float oy;
    private int px;
    private int qe;
    private String tk;
    private String wi;
    private String xw;
    private String yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public EditText j() {
        UGEditText uGEditText = new UGEditText(this.xt);
        uGEditText.j(this);
        return uGEditText;
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
                this.f23835d = vl(str2);
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
            case "hint":
                this.tk = str2;
                break;
            case "text":
                this.wi = str2;
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
            case "inputType":
                this.f23836j = qv(str2);
                break;
        }
    }

    public j(Context context) {
        super(context);
        this.f23836j = 1;
        this.qe = Integer.MAX_VALUE;
        this.f23835d = 2;
    }

    private int qv(String str) {
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals("number")) {
                    return 2;
                }
                return 1;
            case 3556653:
                str.equals(a.f10501b);
                return 1;
            case 96619420:
                if (str.equals("email")) {
                    return 32;
                }
                return 1;
            case 106642798:
                if (str.equals("phone")) {
                    return 3;
                }
                return 1;
            case 1216985755:
                if (str.equals("password")) {
                    return 128;
                }
                return 1;
            default:
                return 1;
        }
    }

    private int vl(String str) {
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
        ((EditText) this.up).setInputType(this.f23836j);
        ((EditText) this.up).setText(this.wi);
        ((EditText) this.up).setTextSize(1, this.oy);
        ((EditText) this.up).setTextColor(this.ll);
        ((EditText) this.up).setLines(this.px);
        ((EditText) this.up).setMaxLines(this.qe);
        ((EditText) this.up).setGravity(this.f23835d);
        ((EditText) this.up).setHint(this.tk);
    }
}
