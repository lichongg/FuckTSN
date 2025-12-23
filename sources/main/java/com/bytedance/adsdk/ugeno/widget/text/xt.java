package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw<UGTextView> {

    /* renamed from: d, reason: collision with root package name */
    private int f23852d;
    private boolean et;
    private float fx;
    private int gr;

    /* renamed from: j, reason: collision with root package name */
    protected String f23853j;
    protected int ll;
    private float na;

    @Deprecated
    private float nu;
    private float om;

    @Deprecated
    private float ov;
    private float oy;
    private int px;
    private int qe;
    private float qg;
    private float rs;
    private TextUtils.TruncateAt tk;

    @Deprecated
    private TextUtils.TruncateAt wi;
    private int xw;
    private int yl;
    private float zs;

    private TextUtils.TruncateAt jy(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private void qb() {
        float f6 = this.fx;
        if (f6 <= 3.0f) {
            ((UGTextView) this.up).setLineSpacing(0.0f, f6);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int round = Math.round(tl.j(this.xt, (f6 - (this.oy * 1.2f)) / 2.0f));
            int paddingTop = ((UGTextView) this.up).getPaddingTop() + round;
            int paddingBottom = ((UGTextView) this.up).getPaddingBottom() + round;
            T t5 = this.up;
            ((UGTextView) t5).setPadding(((UGTextView) t5).getPaddingLeft(), paddingTop, ((UGTextView) this.up).getPaddingRight(), paddingBottom);
            ((UGTextView) this.up).setLineHeight(Math.round(tl.j(this.xt, this.fx)));
        }
    }

    private void tl() {
        ((UGTextView) this.up).setLineSpacing(0.0f, this.fx);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UGTextView j() {
        UGTextView uGTextView = new UGTextView(this.xt);
        uGTextView.j(this);
        return uGTextView;
    }

    public void j(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.up).setEllipsize(truncateAt);
    }

    public void m(int i6) {
        this.f23852d = i6;
        if (i6 == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.up).setPaintFlags(i6);
    }

    public void qv(String str) {
        this.f23853j = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.f23853j = "";
        }
        ((UGTextView) this.up).setText(this.f23853j);
    }

    public xt(Context context) {
        super(context);
        this.ll = ViewCompat.MEASURED_STATE_MASK;
        this.oy = 12.0f;
        this.qe = Integer.MAX_VALUE;
        this.xw = GravityCompat.START;
        this.tk = TextUtils.TruncateAt.END;
        this.fx = -1.0f;
        this.na = 400.0f;
    }

    private int av(String str) {
        str.getClass();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }

    private int az(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "left":
                return 3;
            case "right":
                return 5;
            case "center_horizontal":
                return 1;
            default:
                return 3;
        }
    }

    private TextUtils.TruncateAt vl(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.wi = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.wi = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.wi = TextUtils.TruncateAt.START;
                break;
            default:
                this.wi = null;
                break;
        }
        return this.wi;
    }

    private int ws(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1178781136) {
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
                    return 1;
                }
                return 0;
            }
            str.equals(PrerollVideoResponse.NORMAL);
            return 0;
        }
        if (str.equals("italic")) {
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    c6 = 3;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    c6 = 4;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c6 = 5;
                    break;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    c6 = 6;
                    break;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    c6 = 7;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    c6 = '\b';
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c6 = '\t';
                    break;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    c6 = '\n';
                    break;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    c6 = 11;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c6 = '\f';
                    break;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 3556653:
                if (str.equals(com.baidu.mobads.sdk.internal.a.f10501b)) {
                    c6 = 14;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    c6 = 15;
                    break;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    c6 = 16;
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c6 = 17;
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c6 = 18;
                    break;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    c6 = 19;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 7:
                this.qg = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 1:
                this.gr = com.bytedance.adsdk.ugeno.m.j.j(str2);
                this.et = true;
                break;
            case 2:
                this.om = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 3:
                this.zs = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 4:
                this.xw = az(str2);
                break;
            case 5:
                this.ll = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case 6:
                this.yl = ws(str2);
                break;
            case '\b':
                this.oy = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '\t':
                this.f23852d = av(str2);
                break;
            case '\n':
                this.ov = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 11:
                this.nu = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '\f':
                float j6 = com.bytedance.adsdk.ugeno.m.cw.j(str2, -1.0f);
                this.na = j6;
                if (j6 < 1.0f || j6 > 1000.0f) {
                    this.na = 400.0f;
                    break;
                }
                break;
            case '\r':
                this.fx = com.bytedance.adsdk.ugeno.m.cw.j(str2, 1.0f);
                break;
            case 14:
                this.f23853j = str2;
                break;
            case 15:
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0);
                break;
            case 16:
                this.tk = jy(str2);
                break;
            case 17:
                int j7 = com.bytedance.adsdk.ugeno.m.cw.j(str2, Integer.MAX_VALUE);
                this.qe = j7 > 0 ? j7 : Integer.MAX_VALUE;
                break;
            case 18:
                this.wi = vl(str2);
                break;
            case 19:
                this.rs = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        Typeface create;
        super.xt();
        if (TextUtils.equals("null", this.f23853j)) {
            this.f23853j = "";
        }
        qv(this.f23853j);
        boolean z5 = true;
        ((UGTextView) this.up).setTextSize(1, this.oy);
        ((UGTextView) this.up).setTextColor(this.ll);
        ((UGTextView) this.up).setLines(this.px);
        ((UGTextView) this.up).setMaxLines(this.qe);
        ((UGTextView) this.up).setGravity(this.xw);
        ((UGTextView) this.up).setIncludeFontPadding(false);
        m(this.f23852d);
        if (p()) {
            j(this.tk);
        } else {
            j(this.wi);
        }
        if (this.fx > 0.0f) {
            if (p()) {
                qb();
            } else {
                tl();
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            ((UGTextView) this.up).setBreakStrategy(0);
        }
        if (p()) {
            if (this.et) {
                if (this.qg <= 0.0f) {
                    this.qg = 1.0E-5f;
                }
                ((UGTextView) this.up).setShadowLayer(this.qg, this.om, this.zs, this.gr);
            }
        } else {
            ((UGTextView) this.up).setShadowLayer(this.qg, this.ov, this.nu, this.gr);
        }
        int i7 = this.yl;
        if (i7 == 1) {
            ((UGTextView) this.up).setTypeface(Typeface.DEFAULT, i7);
        } else if (i6 >= 28) {
            Typeface typeface = Typeface.DEFAULT;
            int i8 = (int) this.na;
            if (i7 != 2) {
                z5 = false;
            }
            create = Typeface.create(typeface, i8, z5);
            ((UGTextView) this.up).setTypeface(create);
        } else if (this.na >= 500.0f) {
            ((UGTextView) this.up).setTypeface(Typeface.DEFAULT, 1);
        }
        if (tl.j(this.xt, this.oy) > 0.0f) {
            ((UGTextView) this.up).setLetterSpacing(this.rs / tl.j(this.xt, this.oy));
        }
    }
}
