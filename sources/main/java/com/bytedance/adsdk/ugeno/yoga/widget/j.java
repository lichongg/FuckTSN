package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.cw.ae;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.cw;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.r;
import com.bytedance.adsdk.ugeno.xt.j;
import com.bytedance.adsdk.ugeno.yoga.jy;
import com.bytedance.adsdk.ugeno.yoga.m;
import com.bytedance.adsdk.ugeno.yoga.oq;
import com.bytedance.adsdk.ugeno.yoga.up;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import com.bytedance.adsdk.ugeno.yoga.ws;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.adsdk.ugeno.xt.j<YogaLayout> {
    private up ll;
    private ws oy;
    private com.bytedance.adsdk.ugeno.yoga.j px;
    private com.bytedance.adsdk.ugeno.yoga.j qe;
    private oq xw;
    private m yl;

    /* renamed from: com.bytedance.adsdk.ugeno.yoga.widget.j$j, reason: collision with other inner class name */
    public static class C0330j extends j.C0328j {

        /* renamed from: a, reason: collision with root package name */
        public float f23936a;

        /* renamed from: c, reason: collision with root package name */
        private boolean f23937c;
        public float ed;
        public int gq;
        private boolean gx;

        /* renamed from: h, reason: collision with root package name */
        public float f23938h;

        /* renamed from: l, reason: collision with root package name */
        public float f23939l;
        public int la;

        /* renamed from: n, reason: collision with root package name */
        private boolean f23940n;
        private boolean nd;
        private boolean ol;

        /* renamed from: p, reason: collision with root package name */
        public int f23941p;
        private boolean rh;
        public int rn;

        /* renamed from: s, reason: collision with root package name */
        public int f23942s;
        public int uf;
        public int wq;

        private void r() {
            com.bytedance.adsdk.ugeno.xt.j jVar = this.ch;
            if (jVar instanceof j) {
                if (((j) jVar).sm() == up.ROW && this.ch.rn() == -2 && this.f23891j == -1.0f && !this.ch.ol()) {
                    this.f23891j = -2.0f;
                    this.f23939l = 1.0f;
                    this.f23936a = 1.0f;
                    this.f23937c = true;
                    this.f23938h = -1.0f;
                }
                if (((j) this.ch).sm() == up.COLUMN && this.ch.wq() == -2 && this.xt == -1.0f && !this.ch.ol()) {
                    this.xt = -2.0f;
                    this.f23939l = 1.0f;
                    this.f23936a = 1.0f;
                    this.f23937c = true;
                    this.f23938h = -1.0f;
                }
            }
        }

        public boolean cw() {
            float f6 = this.f23891j;
            if (f6 == -1.0f && this.xt == -1.0f) {
                return false;
            }
            return f6 == -2.0f || this.xt == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        public void j(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.j(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasis":
                    this.f23937c = true;
                    float j6 = cw.j(str2, -1.0f);
                    this.f23938h = j6;
                    this.f23938h = tl.j(context, j6);
                    break;
                case "bottom":
                    this.f23940n = true;
                    this.rn = (int) tl.j(context, cw.j(str2, 0));
                    break;
                case "top":
                    this.gx = true;
                    this.gq = (int) tl.j(context, cw.j(str2, 0));
                    break;
                case "left":
                    this.nd = true;
                    this.wq = (int) tl.j(context, cw.j(str2, 0));
                    break;
                case "order":
                    this.f23942s = cw.j(str2, 1);
                    break;
                case "ratio":
                    this.ol = true;
                    this.ed = cw.j(str2, 0.0f);
                    break;
                case "right":
                    this.rh = true;
                    this.uf = (int) tl.j(context, cw.j(str2, 0));
                    break;
                case "position":
                    this.la = jy.j(str2).j();
                    break;
                case "flexShrink":
                    this.f23939l = cw.j(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.f23936a = cw.j(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.f23941p = com.bytedance.adsdk.ugeno.yoga.j.j(str2).j();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        public String toString() {
            return "LayoutParams{mOrder=" + this.f23942s + ", mFlexGrow=" + this.f23936a + ", mFlexShrink=" + this.f23939l + ", mAlignSelf=" + this.f23941p + ", mFlexBasis=" + this.f23938h + ", mPosition=" + this.la + ", mTop=" + this.gq + ", mBottom=" + this.rn + ", mLeft=" + this.wq + ", mRight=" + this.uf + '}';
        }

        public C0330j(com.bytedance.adsdk.ugeno.xt.j jVar) {
            super(jVar);
            this.f23942s = 1;
            this.f23936a = 0.0f;
            this.f23939l = 1.0f;
            this.f23941p = com.bytedance.adsdk.ugeno.yoga.j.AUTO.j();
            this.f23938h = -1.0f;
            this.la = jy.RELATIVE.j();
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        /* renamed from: xt, reason: merged with bridge method [inline-methods] */
        public YogaLayout.j j() {
            float f6;
            float f7;
            float f8;
            float f9;
            r();
            YogaLayout.j jVar = new YogaLayout.j((int) this.f23891j, (int) this.xt);
            if (this.kt) {
                f6 = this.f23892m;
            } else {
                f6 = this.up;
            }
            jVar.vl((int) f6);
            if (this.tj) {
                f7 = this.ae;
            } else {
                f7 = this.up;
            }
            jVar.ws((int) f7);
            if (this.f23888f) {
                f8 = this.tl;
            } else {
                f8 = this.up;
            }
            jVar.qv((int) f8);
            if (this.f23894v) {
                f9 = this.f23889g;
            } else {
                f9 = this.up;
            }
            jVar.jy((int) f9);
            jVar.j(this.f23942s);
            jVar.up(this.f23941p);
            jVar.xt(this.f23936a);
            jVar.cw(this.f23939l);
            jVar.av(this.cw);
            jVar.i(this.f23893r);
            if (this.f23937c) {
                jVar.r(this.f23938h);
            }
            jVar.m(this.la);
            if (this.gx) {
                jVar.ae(this.gq);
            }
            if (this.f23940n) {
                jVar.g(this.rn);
            }
            if (this.nd) {
                jVar.tl(this.wq);
            }
            if (this.rh) {
                jVar.oq(this.uf);
            }
            if (this.ol && cw()) {
                float f10 = this.ed;
                if (f10 > 0.0f) {
                    jVar.az(f10);
                    jVar.cw(0.0f);
                    jVar.xt(0.0f);
                }
            }
            return jVar;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: qb, reason: merged with bridge method [inline-methods] */
    public YogaLayout j() {
        YogaLayout yogaLayout = new YogaLayout(this.xt);
        yogaLayout.j(this);
        this.xw = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected void s() {
        ImageView.ScaleType scaleType;
        if (this.nd) {
            ae aeVar = this.ik;
            if (aeVar != null) {
                aeVar.j();
            }
            r.j().xt().j(this.f23861g, this.f23857c, new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.j.1
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik != null) {
                            ae aeVar2 = ((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik;
                            j jVar = j.this;
                            aeVar2.xt(jVar, ((com.bytedance.adsdk.ugeno.xt.cw) jVar).f23857c);
                            return;
                        }
                        return;
                    }
                    if (((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik != null) {
                        ae aeVar3 = ((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik;
                        j jVar2 = j.this;
                        aeVar3.j(jVar2, ((com.bytedance.adsdk.ugeno.xt.cw) jVar2).f23857c);
                    }
                    final Bitmap j6 = tl.j(((com.bytedance.adsdk.ugeno.xt.cw) j.this).xt, bitmap, (int) ((com.bytedance.adsdk.ugeno.xt.cw) j.this).f23868n);
                    if (j6 != null) {
                        tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.j.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                j.this.j(new BitmapDrawable(j6));
                            }
                        });
                    }
                }
            });
            return;
        }
        ae aeVar2 = this.ik;
        if (aeVar2 != null) {
            aeVar2.j();
        }
        ImageView imageView = new ImageView(this.xt);
        r.j().xt().j(this.f23861g, this.f23857c, imageView, this.up.getWidth(), this.up.getHeight(), new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.j.2
            @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
            public void j(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik != null) {
                        ae aeVar3 = ((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik;
                        j jVar = j.this;
                        aeVar3.xt(jVar, ((com.bytedance.adsdk.ugeno.xt.cw) jVar).f23857c);
                        return;
                    }
                    return;
                }
                if (((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik != null) {
                    ae aeVar4 = ((com.bytedance.adsdk.ugeno.xt.cw) j.this).ik;
                    j jVar2 = j.this;
                    aeVar4.j(jVar2, ((com.bytedance.adsdk.ugeno.xt.cw) jVar2).f23857c);
                }
            }
        });
        if (!this.rh || (scaleType = this.gx) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        YogaLayout.j jVar = new YogaLayout.j(-1, -1);
        jVar.m(jy.ABSOLUTE.j());
        T t5 = this.up;
        if (t5 instanceof YogaLayout) {
            ((YogaLayout) t5).addView(imageView, 0, jVar);
            j(imageView);
        }
    }

    public up sm() {
        return this.ll;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected void vl() {
        if (this.la) {
            this.xw.xt(com.bytedance.adsdk.ugeno.yoga.r.ALL, this.f23873s);
        }
        if (this.gq) {
            this.xw.xt(com.bytedance.adsdk.ugeno.yoga.r.LEFT, this.f23855a);
        }
        if (this.rn) {
            this.xw.xt(com.bytedance.adsdk.ugeno.yoga.r.RIGHT, this.f23866l);
        }
        if (this.wq) {
            this.xw.xt(com.bytedance.adsdk.ugeno.yoga.r.TOP, this.f23870p);
        }
        if (this.uf) {
            this.xw.xt(com.bytedance.adsdk.ugeno.yoga.r.BOTTOM, this.f23862h);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        this.xw.j(this.ll);
        this.xw.j(this.oy);
        this.xw.j(this.yl);
        this.xw.j(this.qe);
        this.xw.cw(this.px);
        this.xw.j(true);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    /* renamed from: ya, reason: merged with bridge method [inline-methods] */
    public C0330j tl() {
        return new C0330j(this);
    }

    public j(Context context) {
        super(context);
        this.ll = up.ROW;
        this.oy = ws.NO_WRAP;
        this.yl = m.FLEX_START;
        com.bytedance.adsdk.ugeno.yoga.j jVar = com.bytedance.adsdk.ugeno.yoga.j.STRETCH;
        this.qe = jVar;
        this.px = jVar;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    protected void j(Drawable drawable) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(this.xt);
        imageView.setImageDrawable(drawable);
        if (this.rh && (scaleType = this.gx) != ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(scaleType);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        YogaLayout.j jVar = new YogaLayout.j(-1, -1);
        jVar.m(jy.ABSOLUTE.j());
        T t5 = this.up;
        if (t5 instanceof YogaLayout) {
            ((YogaLayout) t5).addView(imageView, 0, jVar);
            j(imageView);
        }
    }

    private void j(final ImageView imageView) {
        this.up.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.j.3
            @Override // java.lang.Runnable
            public void run() {
                oq j6;
                if (((com.bytedance.adsdk.ugeno.xt.cw) j.this).up == null || (j6 = ((YogaLayout) ((com.bytedance.adsdk.ugeno.xt.cw) j.this).up).j(imageView)) == null) {
                    return;
                }
                j6.r(((com.bytedance.adsdk.ugeno.xt.cw) j.this).up.getWidth());
                j6.m(((com.bytedance.adsdk.ugeno.xt.cw) j.this).up.getHeight());
                ((com.bytedance.adsdk.ugeno.xt.cw) j.this).up.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        super.j(cwVar);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, ViewGroup.LayoutParams layoutParams) {
        if (cwVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.xt.j) this).f23887j.add(cwVar);
        View g6 = cwVar.g();
        if (g6 != null) {
            ((YogaLayout) this.up).addView(g6, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.qe = com.bytedance.adsdk.ugeno.yoga.j.j(str2);
                break;
            case "flexDirection":
                this.ll = up.j(str2);
                break;
            case "alignContent":
                this.px = com.bytedance.adsdk.ugeno.yoga.j.j(str2);
                break;
            case "flexWrap":
                this.oy = ws.j(str2);
                break;
            case "justifyContent":
                this.yl = m.j(str2);
                break;
        }
    }
}
