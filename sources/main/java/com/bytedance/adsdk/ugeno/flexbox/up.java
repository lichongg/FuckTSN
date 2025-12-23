package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout;
import com.bytedance.adsdk.ugeno.xt.j;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends com.bytedance.adsdk.ugeno.xt.j<FlexboxLayout> {
    private int ll;
    private int oy;
    private int px;
    private int qe;
    private int yl;

    public static class j extends j.C0328j {

        /* renamed from: a, reason: collision with root package name */
        public float f23663a;
        public int gq;

        /* renamed from: h, reason: collision with root package name */
        public float f23664h;

        /* renamed from: l, reason: collision with root package name */
        public float f23665l;
        public int la;

        /* renamed from: p, reason: collision with root package name */
        public int f23666p;
        public int rn;

        /* renamed from: s, reason: collision with root package name */
        public int f23667s;
        public int wq;

        private float xt(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e6) {
                vl.j(e6);
                return 0.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        public void j(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.j(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasisPercent":
                    this.f23664h = r(str2);
                    break;
                case "order":
                    this.f23667s = j(str2);
                    break;
                case "flexShrink":
                    this.f23665l = cw(str2);
                    break;
                case "flexGrow":
                    this.f23663a = xt(str2);
                    break;
                case "alignSelf":
                    this.f23666p = up(str2);
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        public String toString() {
            return "LayoutParams{mWidth=" + this.f23891j + ", mHeight=" + this.xt + ", mMargin=" + this.up + ", mMarginLeft=" + this.f23892m + ", mMarginRight=" + this.ae + ", mMarginTop=" + this.tl + ", mMarginBottom=" + this.f23889g + ", mParams=" + this.f23896x + ", mOrder=" + this.f23667s + ", mFlexGrow=" + this.f23663a + ", mFlexShrink=" + this.f23665l + ", mAlignSelf=" + this.f23666p + ", mFlexBasisPercent=" + this.f23664h + ", mMinWidth=" + this.la + ", mMinHeight=" + this.gq + ", mMaxWidth=" + this.rn + ", mMaxHeight=" + this.wq + "} " + super.toString();
        }

        public j(com.bytedance.adsdk.ugeno.xt.j jVar) {
            super(jVar);
            this.f23667s = 1;
            this.f23663a = 0.0f;
            this.f23665l = 0.0f;
            this.f23666p = -1;
            this.f23664h = -1.0f;
            this.la = -1;
            this.gq = -1;
            this.rn = 16777215;
            this.wq = 16777215;
        }

        private float cw(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e6) {
                vl.j(e6);
                return 0.0f;
            }
        }

        private float r(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e6) {
                vl.j(e6);
                return -1.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int up(String str) {
            char c6;
            str.getClass();
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1364013995:
                    if (str.equals(AutoScrollViewPager.f4187g)) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1384876188:
                    if (str.equals("flex_start")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1744442261:
                    if (str.equals("flex_end")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    return 4;
                case 1:
                    return 3;
                case 2:
                    return 2;
                case 3:
                    return 0;
                case 4:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        /* renamed from: xt, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.j j() {
            FlexboxLayout.j jVar = new FlexboxLayout.j((int) this.f23891j, (int) this.xt);
            ((ViewGroup.MarginLayoutParams) jVar).leftMargin = (int) this.f23892m;
            ((ViewGroup.MarginLayoutParams) jVar).rightMargin = (int) this.ae;
            ((ViewGroup.MarginLayoutParams) jVar).topMargin = (int) this.tl;
            ((ViewGroup.MarginLayoutParams) jVar).bottomMargin = (int) this.f23889g;
            jVar.cw(this.f23667s);
            jVar.r(this.f23666p);
            jVar.j(this.f23663a);
            jVar.xt(this.f23665l);
            jVar.cw(this.f23664h);
            return jVar;
        }

        private int j(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e6) {
                vl.j(e6);
                return 1;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.qe = ws(str2);
                break;
            case "flexDirection":
                this.ll = qv(str2);
                break;
            case "alignContent":
                this.px = az(str2);
                break;
            case "flexWrap":
                this.oy = vl(str2);
                break;
            case "justifyContent":
                this.yl = jy(str2);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: qb, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout j() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.xt);
        flexboxLayout.j(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public j.C0328j tl() {
        return new j(this);
    }

    public up(Context context) {
        super(context);
    }

    private int az(String str) {
        switch (str.hashCode()) {
            case -1881872635:
                str.equals("stretch");
                return 5;
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4187g)) {
                    return 2;
                }
                return 5;
            case -932331738:
                if (str.equals("space_around")) {
                    return 4;
                }
                return 5;
            case 1384876188:
                if (str.equals("flex_start")) {
                    return 0;
                }
                return 5;
            case 1682480591:
                if (str.equals("space_between")) {
                    return 3;
                }
                return 5;
            case 1744442261:
                if (str.equals("flex_end")) {
                    return 1;
                }
                return 5;
            default:
                return 5;
        }
    }

    private int jy(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    private int vl(String str) {
        str.getClass();
        if (!str.equals("wrap")) {
            return 0;
        }
        return 1;
    }

    private int ws(String str) {
        switch (str.hashCode()) {
            case -1881872635:
                str.equals("stretch");
                return 4;
            case -1720785339:
                if (str.equals("baseline")) {
                    return 3;
                }
                return 4;
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4187g)) {
                    return 2;
                }
                return 4;
            case 1384876188:
                if (str.equals("flex_start")) {
                    return 0;
                }
                return 4;
            case 1744442261:
                if (str.equals("flex_end")) {
                    return 1;
                }
                return 4;
            default:
                return 4;
        }
    }

    int qv(String str) {
        str.getClass();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((FlexboxLayout) this.up).setFlexDirection(this.ll);
        ((FlexboxLayout) this.up).setFlexWrap(this.oy);
        ((FlexboxLayout) this.up).setJustifyContent(this.yl);
        ((FlexboxLayout) this.up).setAlignItems(this.qe);
        ((FlexboxLayout) this.up).setAlignContent(this.px);
    }
}
