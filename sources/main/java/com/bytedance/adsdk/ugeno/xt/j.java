package com.bytedance.adsdk.ugeno.xt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.m.tl;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j<E extends ViewGroup> extends cw {

    /* renamed from: j, reason: collision with root package name */
    protected List<cw<View>> f23887j;

    /* renamed from: com.bytedance.adsdk.ugeno.xt.j$j, reason: collision with other inner class name */
    public static class C0328j {
        protected float ae;
        protected boolean av;
        protected boolean az;
        protected j ch;

        /* renamed from: f, reason: collision with root package name */
        protected boolean f23888f;

        /* renamed from: g, reason: collision with root package name */
        protected float f23889g;

        /* renamed from: i, reason: collision with root package name */
        protected boolean f23890i;
        protected float jy;
        protected boolean kt;

        /* renamed from: m, reason: collision with root package name */
        protected float f23892m;
        protected boolean mi;
        protected float oq;
        protected float qv;
        protected boolean tj;
        protected float tl;
        protected float up;

        /* renamed from: v, reason: collision with root package name */
        protected boolean f23894v;
        protected float vl;

        /* renamed from: w, reason: collision with root package name */
        protected boolean f23895w;
        protected float ws;

        /* renamed from: x, reason: collision with root package name */
        protected ViewGroup.LayoutParams f23896x;

        /* renamed from: j, reason: collision with root package name */
        protected float f23891j = -2.0f;
        protected float xt = -2.0f;
        protected float cw = 0.0f;

        /* renamed from: r, reason: collision with root package name */
        protected float f23893r = 0.0f;

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void j(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.getClass();
            char c6 = 65535;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        c6 = 3;
                        break;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        c6 = 4;
                        break;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        c6 = 5;
                        break;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        c6 = 6;
                        break;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        c6 = 7;
                        break;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        c6 = '\t';
                        break;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        c6 = '\n';
                        break;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        c6 = 11;
                        break;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        c6 = '\f';
                        break;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        c6 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
            }
            switch (c6) {
                case 0:
                    this.qv = tl.j(context, str2);
                    this.av = true;
                    break;
                case 1:
                    this.cw = tl.j(context, str2);
                    break;
                case 2:
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.xt = tl.j(context, str2);
                            break;
                        } else {
                            this.xt = -2.0f;
                            break;
                        }
                    } else {
                        this.xt = -1.0f;
                        break;
                    }
                case 3:
                    this.up = tl.j(context, str2);
                    break;
                case 4:
                    this.tl = tl.j(context, str2);
                    this.f23888f = true;
                    break;
                case 5:
                    this.oq = tl.j(context, str2);
                    this.az = true;
                    break;
                case 6:
                    this.f23889g = tl.j(context, str2);
                    this.f23894v = true;
                    break;
                case 7:
                    this.f23893r = tl.j(context, str2);
                    break;
                case '\b':
                    this.vl = tl.j(context, str2);
                    this.f23895w = true;
                    break;
                case '\t':
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.f23891j = tl.j(context, str2);
                            break;
                        } else {
                            this.f23891j = -2.0f;
                            break;
                        }
                    } else {
                        this.f23891j = -1.0f;
                        break;
                    }
                case '\n':
                    this.ws = tl.j(context, str2);
                    this.mi = true;
                    break;
                case 11:
                    this.jy = tl.j(context, str2);
                    this.f23890i = true;
                    break;
                case '\f':
                    this.ae = tl.j(context, str2);
                    this.tj = true;
                    break;
                case '\r':
                    this.f23892m = tl.j(context, str2);
                    this.kt = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.f23891j + ", mHeight=" + this.xt + ", mMargin=" + this.up + ", mMarginLeft=" + this.f23892m + ", mMarginRight=" + this.ae + ", mMarginTop=" + this.tl + ", mMarginBottom=" + this.f23889g + ", mParams=" + this.f23896x + '}';
        }

        public C0328j(j jVar) {
            this.ch = jVar;
        }

        public ViewGroup.LayoutParams j() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.f23891j, (int) this.xt);
            marginLayoutParams.leftMargin = (int) (this.kt ? this.f23892m : this.up);
            marginLayoutParams.rightMargin = (int) (this.tj ? this.ae : this.up);
            marginLayoutParams.topMargin = (int) (this.f23888f ? this.tl : this.up);
            marginLayoutParams.bottomMargin = (int) (this.f23894v ? this.f23889g : this.up);
            return marginLayoutParams;
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public void j(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.f23887j.add(cwVar);
        View g6 = cwVar.g();
        if (g6 != null) {
            ((ViewGroup) this.up).addView(g6);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
    }

    public j(Context context, j jVar) {
        super(context, jVar);
        this.f23887j = new ArrayList();
    }

    public List<cw<View>> ae() {
        return this.f23887j;
    }

    public C0328j tl() {
        return new C0328j(this);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public cw xt(String str) {
        cw<View> up;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.vl)) {
            return this;
        }
        for (cw<View> cwVar : this.f23887j) {
            if (cwVar != null && (up = cwVar.up(str)) != null) {
                return up;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected cw cw(String str) {
        cw<View> m6;
        if (!TextUtils.isEmpty(str) && oq(str) != null) {
            return this;
        }
        for (cw<View> cwVar : this.f23887j) {
            if (cwVar != null && (m6 = cwVar.m(str)) != null) {
                return m6;
            }
        }
        return null;
    }

    public void j(cw cwVar, ViewGroup.LayoutParams layoutParams) {
        if (cwVar == null) {
            return;
        }
        this.f23887j.add(cwVar);
        View g6 = cwVar.g();
        if (g6 != null) {
            ((ViewGroup) this.up).addView(g6, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public cw j(String str) {
        cw<View> r5;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.qv)) {
            return this;
        }
        for (cw<View> cwVar : this.f23887j) {
            if (cwVar != null && (r5 = cwVar.r(str)) != null) {
                return r5;
            }
        }
        return null;
    }
}
