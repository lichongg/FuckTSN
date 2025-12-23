package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.j.xt.av;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.layer.tl;
import com.bytedance.adsdk.lottie.model.xt.tl;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw implements com.bytedance.adsdk.lottie.j.j.up, j.InterfaceC0316j {

    /* renamed from: a, reason: collision with root package name */
    private List<cw> f23370a;
    private final Paint av;
    private final Paint az;
    private cw ch;
    final tl cw;

    /* renamed from: f, reason: collision with root package name */
    private final String f23371f;
    private final Matrix gq;

    /* renamed from: h, reason: collision with root package name */
    private boolean f23373h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f23374i;

    /* renamed from: j, reason: collision with root package name */
    final Matrix f23375j;
    private final Paint jy;
    private final RectF kt;

    /* renamed from: l, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.j.xt.j<?, ?>> f23376l;
    private Paint la;

    /* renamed from: m, reason: collision with root package name */
    BlurMaskFilter f23377m;
    private final RectF mi;

    /* renamed from: p, reason: collision with root package name */
    private boolean f23378p;

    /* renamed from: r, reason: collision with root package name */
    final av f23379r;
    private float rn;

    /* renamed from: s, reason: collision with root package name */
    private cw f23380s;
    private final RectF tj;
    private boolean tl;
    float up;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.tl f23381v;

    /* renamed from: w, reason: collision with root package name */
    private final RectF f23382w;
    private final Paint ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.r f23383x;
    final com.bytedance.adsdk.lottie.tl xt;
    private final Handler ae = new Handler(Looper.getMainLooper());

    /* renamed from: g, reason: collision with root package name */
    private final Path f23372g = new Path();
    private final Matrix oq = new Matrix();
    private final Matrix qv = new Matrix();
    private final Paint vl = new com.bytedance.adsdk.lottie.j.j(1);

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<com.bytedance.adsdk.lottie.j.j.cw> list, List<com.bytedance.adsdk.lottie.j.j.cw> list2) {
    }

    tl r() {
        return this.cw;
    }

    boolean up() {
        return this.ch != null;
    }

    public boolean xt() {
        return this.tl;
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.cw$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23385j;
        static final /* synthetic */ int[] xt;

        static {
            int[] iArr = new int[tl.j.values().length];
            xt = iArr;
            try {
                iArr[tl.j.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xt[tl.j.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xt[tl.j.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xt[tl.j.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[tl.j.values().length];
            f23385j = iArr2;
            try {
                iArr2[tl.j.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23385j[tl.j.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23385j[tl.j.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23385j[tl.j.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23385j[tl.j.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23385j[tl.j.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23385j[tl.j.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private boolean av() {
        if (this.f23381v.xt().isEmpty()) {
            return false;
        }
        for (int i6 = 0; i6 < this.f23381v.j().size(); i6++) {
            if (this.f23381v.j().get(i6).j() != tl.j.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void az() {
        this.xt.invalidateSelf();
    }

    private void i() {
        if (this.f23370a != null) {
            return;
        }
        if (this.f23380s == null) {
            this.f23370a = Collections.EMPTY_LIST;
            return;
        }
        this.f23370a = new ArrayList();
        for (cw cwVar = this.f23380s; cwVar != null; cwVar = cwVar.f23380s) {
            this.f23370a.add(cwVar);
        }
    }

    private void r(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar, com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2) {
        com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.jy);
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        this.vl.setAlpha((int) (jVar2.ae().intValue() * 2.55f));
        canvas.drawPath(this.f23372g, this.vl);
        canvas.restore();
    }

    private void up(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar, com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2) {
        com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.jy);
        canvas.drawRect(this.f23374i, this.vl);
        this.ws.setAlpha((int) (jVar2.ae().intValue() * 2.55f));
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        canvas.drawPath(this.f23372g, this.ws);
        canvas.restore();
    }

    private void ws() {
        if (this.cw.r().isEmpty()) {
            xt(true);
            return;
        }
        com.bytedance.adsdk.lottie.j.xt.r rVar = new com.bytedance.adsdk.lottie.j.xt.r(this.cw.r());
        this.f23383x = rVar;
        rVar.j();
        this.f23383x.j(new j.InterfaceC0316j() { // from class: com.bytedance.adsdk.lottie.model.layer.cw.1
            @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
            public void j() {
                cw cwVar = cw.this;
                cwVar.xt(cwVar.f23383x.g() == 1.0f);
            }
        });
        xt(this.f23383x.ae().floatValue() == 1.0f);
        j(this.f23383x);
    }

    public String ae() {
        tl tlVar = this.cw;
        if (tlVar != null) {
            return tlVar.ae();
        }
        return null;
    }

    public void cw() {
        this.tl = true;
    }

    boolean g() {
        com.bytedance.adsdk.lottie.j.xt.tl tlVar = this.f23381v;
        return (tlVar == null || tlVar.xt().isEmpty()) ? false : true;
    }

    public com.bytedance.adsdk.lottie.r.oq jy() {
        return this.cw.x();
    }

    public Matrix m() {
        return this.gq;
    }

    public boolean oq() {
        return this.f23378p;
    }

    public String qv() {
        return this.cw.m();
    }

    public float tl() {
        return this.rn;
    }

    public com.bytedance.adsdk.lottie.model.xt.j vl() {
        return this.cw.v();
    }

    void xt(cw cwVar) {
        this.f23380s = cwVar;
    }

    cw(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.jy = new com.bytedance.adsdk.lottie.j.j(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.ws = new com.bytedance.adsdk.lottie.j.j(1, mode2);
        com.bytedance.adsdk.lottie.j.j jVar = new com.bytedance.adsdk.lottie.j.j(1);
        this.az = jVar;
        this.av = new com.bytedance.adsdk.lottie.j.j(PorterDuff.Mode.CLEAR);
        this.f23374i = new RectF();
        this.f23382w = new RectF();
        this.mi = new RectF();
        this.kt = new RectF();
        this.tj = new RectF();
        this.f23375j = new Matrix();
        this.f23376l = new ArrayList();
        this.f23378p = true;
        this.up = 0.0f;
        this.gq = new Matrix();
        this.rn = 1.0f;
        this.xt = tlVar;
        this.cw = tlVar2;
        this.f23371f = tlVar2.m() + "#draw";
        if (tlVar2.vl() == tl.xt.INVERT) {
            jVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            jVar.setXfermode(new PorterDuffXfermode(mode));
        }
        av oq = tlVar2.az().oq();
        this.f23379r = oq;
        oq.j((j.InterfaceC0316j) this);
        if (tlVar2.oq() != null && !tlVar2.oq().isEmpty()) {
            com.bytedance.adsdk.lottie.j.xt.tl tlVar3 = new com.bytedance.adsdk.lottie.j.xt.tl(tlVar2.oq());
            this.f23381v = tlVar3;
            Iterator<com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path>> it = tlVar3.xt().iterator();
            while (it.hasNext()) {
                it.next().j(this);
            }
            for (com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2 : this.f23381v.cw()) {
                j(jVar2);
                jVar2.j(this);
            }
        }
        ws();
    }

    private void cw(float f6) {
        this.xt.a().cw().j(this.cw.m(), f6);
    }

    private void xt(RectF rectF, Matrix matrix) {
        if (up() && this.cw.vl() != tl.xt.INVERT) {
            this.kt.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.ch.j(this.kt, matrix, true);
            if (rectF.intersect(this.kt)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void j(Runnable runnable) {
        this.ae.post(runnable);
    }

    static cw j(r rVar, tl tlVar, com.bytedance.adsdk.lottie.tl tlVar2, com.bytedance.adsdk.lottie.m mVar, Context context) {
        switch (AnonymousClass2.f23385j[tlVar.qv().ordinal()]) {
            case 1:
                return new oq(tlVar2, tlVar, rVar, mVar);
            case 2:
                return new r(tlVar2, tlVar, mVar.xt(tlVar.ae()), mVar, context);
            case 3:
                return new qv(tlVar2, tlVar);
            case 4:
                if (j(tlVar2, tlVar, "text:")) {
                    return new m(tlVar2, tlVar, context);
                }
                if (j(tlVar2, tlVar, "videoview:")) {
                    g.j j6 = j(tlVar2, tlVar);
                    if (j6 != null) {
                        g.j.C0314j c0314j = j6.f23229j;
                        if (c0314j != null && c0314j.f23230j > 0.0f) {
                            return new up(tlVar2, tlVar, context, c0314j);
                        }
                        if (j6.xt) {
                            return new xt(tlVar2, tlVar, context);
                        }
                        return new ws(tlVar2, tlVar, context);
                    }
                    return new ws(tlVar2, tlVar, context);
                }
                if (j(tlVar2, tlVar, "animview:")) {
                    return new j(tlVar2, tlVar, context);
                }
                if (j(tlVar2, tlVar, "view:")) {
                    return new jy(tlVar2, tlVar, context);
                }
                return new ae(tlVar2, tlVar);
            case 5:
                return new g(tlVar2, tlVar);
            case 6:
                return new vl(tlVar2, tlVar);
            default:
                com.bytedance.adsdk.lottie.up.up.xt("Unknown layer type " + tlVar.qv());
                return null;
        }
    }

    private void cw(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar, com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2) {
        com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.ws);
        canvas.drawRect(this.f23374i, this.vl);
        this.ws.setAlpha((int) (jVar2.ae().intValue() * 2.55f));
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        canvas.drawPath(this.f23372g, this.ws);
        canvas.restore();
    }

    public void xt(Canvas canvas, Matrix matrix, int i6) {
        j(i6);
    }

    private void xt(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar, com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2) {
        com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.vl);
        canvas.drawRect(this.f23374i, this.vl);
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        this.vl.setAlpha((int) (jVar2.ae().intValue() * 2.55f));
        canvas.drawPath(this.f23372g, this.ws);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z5) {
        if (z5 != this.f23378p) {
            this.f23378p = z5;
            az();
        }
    }

    public BlurMaskFilter xt(float f6) {
        if (this.up == f6) {
            return this.f23377m;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f6 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f23377m = blurMaskFilter;
        this.up = f6;
        return blurMaskFilter;
    }

    private static g.j j(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2) {
        com.bytedance.adsdk.lottie.g m6;
        if (tlVar == null || tlVar2 == null || (m6 = tlVar.m(tlVar2.ae())) == null) {
            return null;
        }
        return m6.oq();
    }

    private static boolean j(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, String str) {
        com.bytedance.adsdk.lottie.g m6;
        if (tlVar == null || tlVar2 == null || str == null || (m6 = tlVar.m(tlVar2.ae())) == null) {
            return false;
        }
        return str.equals(m6.jy());
    }

    void j(boolean z5) {
        if (z5 && this.la == null) {
            this.la = new com.bytedance.adsdk.lottie.j.j();
        }
        this.f23373h = z5;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        az();
    }

    void j(cw cwVar) {
        this.ch = cwVar;
    }

    public void j(com.bytedance.adsdk.lottie.j.xt.j<?, ?> jVar) {
        if (jVar == null) {
            return;
        }
        this.f23376l.add(jVar);
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        this.f23374i.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        this.f23375j.set(matrix);
        if (z5) {
            List<cw> list = this.f23370a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f23375j.preConcat(this.f23370a.get(size).f23379r.r());
                }
            } else {
                cw cwVar = this.f23380s;
                if (cwVar != null) {
                    this.f23375j.preConcat(cwVar.f23379r.r());
                }
            }
        }
        this.f23375j.preConcat(this.f23379r.r());
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        Paint paint;
        Integer ae;
        com.bytedance.adsdk.lottie.up.j(this.f23371f);
        if (this.f23378p && !this.cw.f()) {
            i();
            com.bytedance.adsdk.lottie.up.j("Layer#parentMatrix");
            this.gq.set(matrix);
            this.oq.reset();
            this.oq.set(matrix);
            for (int size = this.f23370a.size() - 1; size >= 0; size--) {
                this.oq.preConcat(this.f23370a.get(size).f23379r.r());
            }
            com.bytedance.adsdk.lottie.up.xt("Layer#parentMatrix");
            com.bytedance.adsdk.lottie.j.xt.j<?, Integer> j6 = this.f23379r.j();
            int intValue = (int) ((((i6 / 255.0f) * ((j6 == null || (ae = j6.ae()) == null) ? 100 : ae.intValue())) / 100.0f) * 255.0f);
            if (!up() && !g()) {
                this.oq.preConcat(this.f23379r.r());
                com.bytedance.adsdk.lottie.up.j("Layer#drawLayer");
                xt(canvas, this.oq, intValue);
                com.bytedance.adsdk.lottie.up.xt("Layer#drawLayer");
                cw(com.bytedance.adsdk.lottie.up.xt(this.f23371f));
                return;
            }
            com.bytedance.adsdk.lottie.up.j("Layer#computeBounds");
            j(this.f23374i, this.oq, false);
            xt(this.f23374i, matrix);
            this.oq.preConcat(this.f23379r.r());
            j(this.f23374i, this.oq);
            this.f23382w.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.qv);
            if (!this.qv.isIdentity()) {
                Matrix matrix2 = this.qv;
                matrix2.invert(matrix2);
                this.qv.mapRect(this.f23382w);
            }
            if (!this.f23374i.intersect(this.f23382w)) {
                this.f23374i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.bytedance.adsdk.lottie.up.xt("Layer#computeBounds");
            if (this.f23374i.width() >= 1.0f && this.f23374i.height() >= 1.0f) {
                com.bytedance.adsdk.lottie.up.j("Layer#saveLayer");
                this.vl.setAlpha(255);
                com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.vl);
                com.bytedance.adsdk.lottie.up.xt("Layer#saveLayer");
                j(canvas);
                com.bytedance.adsdk.lottie.up.j("Layer#drawLayer");
                xt(canvas, this.oq, intValue);
                com.bytedance.adsdk.lottie.up.xt("Layer#drawLayer");
                if (g()) {
                    j(canvas, this.oq);
                }
                if (up()) {
                    com.bytedance.adsdk.lottie.up.j("Layer#drawMatte");
                    com.bytedance.adsdk.lottie.up.j("Layer#saveLayer");
                    com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.az, 19);
                    com.bytedance.adsdk.lottie.up.xt("Layer#saveLayer");
                    j(canvas);
                    this.ch.j(canvas, matrix, intValue);
                    com.bytedance.adsdk.lottie.up.j("Layer#restoreLayer");
                    canvas.restore();
                    com.bytedance.adsdk.lottie.up.xt("Layer#restoreLayer");
                    com.bytedance.adsdk.lottie.up.xt("Layer#drawMatte");
                }
                com.bytedance.adsdk.lottie.up.j("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.up.xt("Layer#restoreLayer");
            }
            if (this.f23373h && (paint = this.la) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.la.setColor(-251901);
                this.la.setStrokeWidth(4.0f);
                canvas.drawRect(this.f23374i, this.la);
                this.la.setStyle(Paint.Style.FILL);
                this.la.setColor(1357638635);
                canvas.drawRect(this.f23374i, this.la);
            }
            cw(com.bytedance.adsdk.lottie.up.xt(this.f23371f));
            return;
        }
        com.bytedance.adsdk.lottie.up.xt(this.f23371f);
    }

    private void j(Canvas canvas) {
        com.bytedance.adsdk.lottie.up.j("Layer#clearLayer");
        RectF rectF = this.f23374i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.av);
        com.bytedance.adsdk.lottie.up.xt("Layer#clearLayer");
    }

    private void j(RectF rectF, Matrix matrix) {
        this.mi.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (g()) {
            int size = this.f23381v.j().size();
            for (int i6 = 0; i6 < size; i6++) {
                com.bytedance.adsdk.lottie.model.xt.tl tlVar = this.f23381v.j().get(i6);
                Path ae = this.f23381v.xt().get(i6).ae();
                if (ae != null) {
                    this.f23372g.set(ae);
                    this.f23372g.transform(matrix);
                    int i7 = AnonymousClass2.xt[tlVar.j().ordinal()];
                    if (i7 == 1 || i7 == 2) {
                        return;
                    }
                    if ((i7 == 3 || i7 == 4) && tlVar.r()) {
                        return;
                    }
                    this.f23372g.computeBounds(this.tj, false);
                    if (i6 == 0) {
                        this.mi.set(this.tj);
                    } else {
                        RectF rectF2 = this.mi;
                        rectF2.set(Math.min(rectF2.left, this.tj.left), Math.min(this.mi.top, this.tj.top), Math.max(this.mi.right, this.tj.right), Math.max(this.mi.bottom, this.tj.bottom));
                    }
                }
            }
            if (rectF.intersect(this.mi)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    protected void j(int i6) {
        this.rn = ((this.f23379r.j() != null ? this.f23379r.j().ae().intValue() : 100) / 100.0f) * (i6 / 255.0f);
    }

    private void j(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.up.j("Layer#saveLayer");
        com.bytedance.adsdk.lottie.up.g.j(canvas, this.f23374i, this.jy, 19);
        if (Build.VERSION.SDK_INT < 28) {
            j(canvas);
        }
        com.bytedance.adsdk.lottie.up.xt("Layer#saveLayer");
        for (int i6 = 0; i6 < this.f23381v.j().size(); i6++) {
            com.bytedance.adsdk.lottie.model.xt.tl tlVar = this.f23381v.j().get(i6);
            com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar = this.f23381v.xt().get(i6);
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2 = this.f23381v.cw().get(i6);
            int i7 = AnonymousClass2.xt[tlVar.j().ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    if (i6 == 0) {
                        this.vl.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.vl.setAlpha(255);
                        canvas.drawRect(this.f23374i, this.vl);
                    }
                    if (tlVar.r()) {
                        cw(canvas, matrix, jVar, jVar2);
                    } else {
                        j(canvas, matrix, jVar);
                    }
                } else if (i7 != 3) {
                    if (i7 == 4) {
                        if (tlVar.r()) {
                            xt(canvas, matrix, jVar, jVar2);
                        } else {
                            j(canvas, matrix, jVar, jVar2);
                        }
                    }
                } else if (tlVar.r()) {
                    up(canvas, matrix, jVar, jVar2);
                } else {
                    r(canvas, matrix, jVar, jVar2);
                }
            } else if (av()) {
                this.vl.setAlpha(255);
                canvas.drawRect(this.f23374i, this.vl);
            }
        }
        com.bytedance.adsdk.lottie.up.j("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.up.xt("Layer#restoreLayer");
    }

    private void j(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar, com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2) {
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        this.vl.setAlpha((int) (jVar2.ae().intValue() * 2.55f));
        canvas.drawPath(this.f23372g, this.vl);
    }

    private void j(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.ws, Path> jVar) {
        this.f23372g.set(jVar.ae());
        this.f23372g.transform(matrix);
        canvas.drawPath(this.f23372g, this.ws);
    }

    void j(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.f23379r.j(f6);
        if (this.f23381v != null) {
            for (int i6 = 0; i6 < this.f23381v.xt().size(); i6++) {
                this.f23381v.xt().get(i6).j(f6);
            }
        }
        com.bytedance.adsdk.lottie.j.xt.r rVar = this.f23383x;
        if (rVar != null) {
            rVar.j(f6);
        }
        cw cwVar = this.ch;
        if (cwVar != null) {
            cwVar.j(f6);
        }
        for (int i7 = 0; i7 < this.f23376l.size(); i7++) {
            this.f23376l.get(i7).j(f6);
        }
    }
}
