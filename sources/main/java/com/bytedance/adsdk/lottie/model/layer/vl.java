package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.j.xt.az;
import com.bytedance.adsdk.lottie.model.xt;
import com.bytedance.adsdk.lottie.model.xt.av;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends cw {

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Typeface, Typeface> f23416a;
    private final StringBuilder ae;
    private final com.bytedance.adsdk.lottie.tl av;
    private final az az;
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> ch;

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> f23417f;

    /* renamed from: g, reason: collision with root package name */
    private final Matrix f23418g;

    /* renamed from: i, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.m f23419i;
    private final LongSparseArray<String> jy;
    private com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> kt;
    private com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> mi;
    private final Paint oq;
    private final Paint qv;

    /* renamed from: s, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> f23420s;
    private com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> tj;
    private final RectF tl;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> f23421v;
    private final Map<com.bytedance.adsdk.lottie.model.r, List<com.bytedance.adsdk.lottie.j.j.r>> vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> f23422w;
    private final List<j> ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> f23423x;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private String f23427j;
        private float xt;

        private j() {
            this.f23427j = "";
            this.xt = 0.0f;
        }

        void j(String str, float f6) {
            this.f23427j = str;
            this.xt = f6;
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw, com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        super.j(rectF, matrix, z5);
        rectF.set(0.0f, 0.0f, this.f23419i.r().width(), this.f23419i.r().height());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        super.xt(canvas, matrix, i6);
        com.bytedance.adsdk.lottie.model.xt ae = this.az.ae();
        com.bytedance.adsdk.lottie.model.cw cwVar = this.f23419i.av().get(ae.xt);
        if (cwVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(ae, matrix);
        if (this.av.s()) {
            j(ae, matrix, cwVar, canvas);
        } else {
            j(ae, cwVar, canvas);
        }
        canvas.restore();
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.vl$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23426j;

        static {
            int[] iArr = new int[xt.j.values().length];
            f23426j = iArr;
            try {
                iArr[xt.j.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23426j[xt.j.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23426j[xt.j.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    vl(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2) {
        super(tlVar, tlVar2);
        com.bytedance.adsdk.lottie.model.j.xt xtVar;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2;
        com.bytedance.adsdk.lottie.model.j.j jVar;
        com.bytedance.adsdk.lottie.model.j.j jVar2;
        this.ae = new StringBuilder(2);
        this.tl = new RectF();
        this.f23418g = new Matrix();
        int i6 = 1;
        this.oq = new Paint(i6) { // from class: com.bytedance.adsdk.lottie.model.layer.vl.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.qv = new Paint(i6) { // from class: com.bytedance.adsdk.lottie.model.layer.vl.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.vl = new HashMap();
        this.jy = new LongSparseArray<>();
        this.ws = new ArrayList();
        this.av = tlVar;
        this.f23419i = tlVar2.j();
        az j6 = tlVar2.mi().j();
        this.az = j6;
        j6.j(this);
        j(j6);
        com.bytedance.adsdk.lottie.model.j.qv kt = tlVar2.kt();
        if (kt != null && (jVar2 = kt.f23358j) != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j7 = jVar2.j();
            this.f23422w = j7;
            j7.j(this);
            j(this.f23422w);
        }
        if (kt != null && (jVar = kt.xt) != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j8 = jVar.j();
            this.kt = j8;
            j8.j(this);
            j(this.kt);
        }
        if (kt != null && (xtVar2 = kt.cw) != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j9 = xtVar2.j();
            this.f23417f = j9;
            j9.j(this);
            j(this.f23417f);
        }
        if (kt != null && (xtVar = kt.f23359r) != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j10 = xtVar.j();
            this.f23423x = j10;
            j10.j(this);
            j(this.f23423x);
        }
    }

    private boolean cw(int i6) {
        if (Character.getType(i6) != 16 && Character.getType(i6) != 27 && Character.getType(i6) != 6 && Character.getType(i6) != 28 && Character.getType(i6) != 8 && Character.getType(i6) != 19) {
            return false;
        }
        return true;
    }

    private void j(com.bytedance.adsdk.lottie.model.xt xtVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar = this.mi;
        if (jVar != null) {
            this.oq.setColor(jVar.ae().intValue());
        } else {
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar2 = this.f23422w;
            if (jVar2 != null) {
                this.oq.setColor(jVar2.ae().intValue());
            } else {
                this.oq.setColor(xtVar.tl);
            }
        }
        com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar3 = this.tj;
        if (jVar3 != null) {
            this.qv.setColor(jVar3.ae().intValue());
        } else {
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jVar4 = this.kt;
            if (jVar4 != null) {
                this.qv.setColor(jVar4.ae().intValue());
            } else {
                this.qv.setColor(xtVar.f23442g);
            }
        }
        int intValue = ((this.f23379r.j() == null ? 100 : this.f23379r.j().ae().intValue()) * 255) / 100;
        this.oq.setAlpha(intValue);
        this.qv.setAlpha(intValue);
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar5 = this.f23421v;
        if (jVar5 != null) {
            this.qv.setStrokeWidth(jVar5.ae().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar6 = this.f23417f;
        if (jVar6 != null) {
            this.qv.setStrokeWidth(jVar6.ae().floatValue());
        } else {
            this.qv.setStrokeWidth(xtVar.oq * com.bytedance.adsdk.lottie.up.g.j());
        }
    }

    private j xt(int i6) {
        for (int size = this.ws.size(); size < i6; size++) {
            this.ws.add(new j());
        }
        return this.ws.get(i6 - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bytedance.adsdk.lottie.model.xt r17, android.graphics.Matrix r18, com.bytedance.adsdk.lottie.model.cw r19, android.graphics.Canvas r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r1 = r0.f23420s
            if (r1 == 0) goto L13
            java.lang.Object r1 = r1.ae()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L15
        L13:
            float r1 = r7.cw
        L15:
            r2 = 1120403456(0x42c80000, float:100.0)
            float r4 = r1 / r2
            float r8 = com.bytedance.adsdk.lottie.up.g.j(r18)
            java.lang.String r1 = r7.f23443j
            java.util.List r9 = r0.j(r1)
            int r10 = r9.size()
            int r1 = r7.up
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r2 = r0.ch
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.ae()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L3b:
            float r1 = r1 + r2
        L3c:
            r5 = r1
            goto L4d
        L3e:
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r2 = r0.f23423x
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r2.ae()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L3b
        L4d:
            r11 = 0
            r1 = -1
            r12 = -1
            r13 = 0
        L51:
            if (r13 >= r10) goto La7
            java.lang.Object r1 = r9.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r2 = r7.jy
            if (r2 != 0) goto L5f
            r2 = 0
            goto L61
        L5f:
            float r2 = r2.x
        L61:
            r6 = 1
            r3 = r19
            java.util.List r14 = r0.j(r1, r2, r3, r4, r5, r6)
            r15 = 0
        L69:
            int r1 = r14.size()
            if (r15 >= r1) goto L9d
            java.lang.Object r1 = r14.get(r15)
            com.bytedance.adsdk.lottie.model.layer.vl$j r1 = (com.bytedance.adsdk.lottie.model.layer.vl.j) r1
            int r12 = r12 + 1
            r20.save()
            float r2 = com.bytedance.adsdk.lottie.model.layer.vl.j.j(r1)
            r3 = r20
            r0.j(r3, r7, r12, r2)
            java.lang.String r1 = com.bytedance.adsdk.lottie.model.layer.vl.j.xt(r1)
            r6 = r4
            r2 = r7
            r4 = r3
            r7 = r5
            r5 = r8
            r3 = r19
            r0.j(r1, r2, r3, r4, r5, r6, r7)
            r4 = r6
            r20.restore()
            int r15 = r15 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L69
        L9d:
            r7 = r5
            r5 = r8
            int r13 = r13 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L51
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.vl.j(com.bytedance.adsdk.lottie.model.xt, android.graphics.Matrix, com.bytedance.adsdk.lottie.model.cw, android.graphics.Canvas):void");
    }

    private void j(String str, com.bytedance.adsdk.lottie.model.xt xtVar, com.bytedance.adsdk.lottie.model.cw cwVar, Canvas canvas, float f6, float f7, float f8) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            com.bytedance.adsdk.lottie.model.r rVar = this.f23419i.az().get(com.bytedance.adsdk.lottie.model.r.j(str.charAt(i6), cwVar.j(), cwVar.cw()));
            if (rVar != null) {
                j(rVar, f7, xtVar, canvas);
                canvas.translate((((float) rVar.xt()) * f7 * com.bytedance.adsdk.lottie.up.g.j()) + f8, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bytedance.adsdk.lottie.model.xt r13, com.bytedance.adsdk.lottie.model.cw r14, android.graphics.Canvas r15) {
        /*
            r12 = this;
            android.graphics.Typeface r0 = r12.j(r14)
            if (r0 != 0) goto L9
        L6:
            r3 = r12
            goto Ld4
        L9:
            java.lang.String r1 = r13.f23443j
            com.bytedance.adsdk.lottie.tl r2 = r12.av
            com.bytedance.adsdk.lottie.kt r2 = r2.ch()
            if (r2 == 0) goto L1b
            java.lang.String r3 = r12.qv()
            java.lang.String r1 = r2.cw(r3, r1)
        L1b:
            android.graphics.Paint r2 = r12.oq
            r2.setTypeface(r0)
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r0 = r12.f23420s
            if (r0 == 0) goto L2f
            java.lang.Object r0 = r0.ae()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L31
        L2f:
            float r0 = r13.cw
        L31:
            android.graphics.Paint r2 = r12.oq
            float r3 = com.bytedance.adsdk.lottie.up.g.j()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r12.qv
            android.graphics.Paint r3 = r12.oq
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r12.qv
            android.graphics.Paint r3 = r12.oq
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r13.up
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r3 = r12.ch
            if (r3 == 0) goto L68
            java.lang.Object r3 = r3.ae()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L66:
            float r2 = r2 + r3
            goto L77
        L68:
            com.bytedance.adsdk.lottie.j.xt.j<java.lang.Float, java.lang.Float> r3 = r12.f23423x
            if (r3 == 0) goto L77
            java.lang.Object r3 = r3.ae()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L66
        L77:
            float r3 = com.bytedance.adsdk.lottie.up.g.j()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r8 = r2 / r0
            java.util.List r0 = r12.j(r1)
            int r1 = r0.size()
            r2 = 0
            r3 = -1
            r10 = -1
            r11 = 0
        L8f:
            if (r11 >= r1) goto L6
            java.lang.Object r3 = r0.get(r11)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            android.graphics.PointF r3 = r13.jy
            if (r3 != 0) goto L9f
            r3 = 0
            r5 = 0
            goto La2
        L9f:
            float r3 = r3.x
            r5 = r3
        La2:
            r7 = 0
            r9 = 0
            r3 = r12
            r6 = r14
            java.util.List r14 = r3.j(r4, r5, r6, r7, r8, r9)
            r4 = 0
        Lab:
            int r5 = r14.size()
            if (r4 >= r5) goto Ld0
            java.lang.Object r5 = r14.get(r4)
            com.bytedance.adsdk.lottie.model.layer.vl$j r5 = (com.bytedance.adsdk.lottie.model.layer.vl.j) r5
            int r10 = r10 + 1
            r15.save()
            float r7 = com.bytedance.adsdk.lottie.model.layer.vl.j.j(r5)
            r12.j(r15, r13, r10, r7)
            java.lang.String r5 = com.bytedance.adsdk.lottie.model.layer.vl.j.xt(r5)
            r12.j(r5, r13, r15, r8)
            r15.restore()
            int r4 = r4 + 1
            goto Lab
        Ld0:
            int r11 = r11 + 1
            r14 = r6
            goto L8f
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.vl.j(com.bytedance.adsdk.lottie.model.xt, com.bytedance.adsdk.lottie.model.cw, android.graphics.Canvas):void");
    }

    private void j(Canvas canvas, com.bytedance.adsdk.lottie.model.xt xtVar, int i6, float f6) {
        PointF pointF = xtVar.vl;
        PointF pointF2 = xtVar.jy;
        float j6 = com.bytedance.adsdk.lottie.up.g.j();
        float f7 = (i6 * xtVar.f23444m * j6) + (pointF == null ? 0.0f : (xtVar.f23444m * 0.6f * j6) + pointF.y);
        float f8 = pointF == null ? 0.0f : pointF.x;
        float f9 = pointF2 != null ? pointF2.x : 0.0f;
        int i7 = AnonymousClass3.f23426j[xtVar.f23445r.ordinal()];
        if (i7 == 1) {
            canvas.translate(f8, f7);
        } else if (i7 == 2) {
            canvas.translate((f8 + f9) - f6, f7);
        } else {
            if (i7 != 3) {
                return;
            }
            canvas.translate((f8 + (f9 / 2.0f)) - (f6 / 2.0f), f7);
        }
    }

    private Typeface j(com.bytedance.adsdk.lottie.model.cw cwVar) {
        Typeface ae;
        com.bytedance.adsdk.lottie.j.xt.j<Typeface, Typeface> jVar = this.f23416a;
        if (jVar != null && (ae = jVar.ae()) != null) {
            return ae;
        }
        Typeface j6 = this.av.j(cwVar);
        return j6 != null ? j6 : cwVar.r();
    }

    private List<String> j(String str) {
        return Arrays.asList(str.replaceAll(org.apache.commons.net.g.f50795q, "\r").replaceAll("\u0003", "\r").replaceAll(com.snail.antifake.deviceid.e.f37542d, "\r").split("\r"));
    }

    private void j(String str, com.bytedance.adsdk.lottie.model.xt xtVar, Canvas canvas, float f6) {
        int i6 = 0;
        while (i6 < str.length()) {
            String j6 = j(str, i6);
            i6 += j6.length();
            j(j6, xtVar, canvas);
            canvas.translate(this.oq.measureText(j6) + f6, 0.0f);
        }
    }

    private List<j> j(String str, float f6, com.bytedance.adsdk.lottie.model.cw cwVar, float f7, float f8, boolean z5) {
        float measureText;
        float f9 = 0.0f;
        int i6 = 0;
        int i7 = 0;
        boolean z6 = false;
        float f10 = 0.0f;
        int i8 = 0;
        float f11 = 0.0f;
        for (int i9 = 0; i9 < str.length(); i9++) {
            char charAt = str.charAt(i9);
            if (z5) {
                com.bytedance.adsdk.lottie.model.r rVar = this.f23419i.az().get(com.bytedance.adsdk.lottie.model.r.j(charAt, cwVar.j(), cwVar.cw()));
                if (rVar != null) {
                    measureText = ((float) rVar.xt()) * f7 * com.bytedance.adsdk.lottie.up.g.j();
                }
            } else {
                measureText = this.oq.measureText(str.substring(i9, i9 + 1));
            }
            float f12 = measureText + f8;
            if (charAt == ' ') {
                z6 = true;
                f11 = f12;
            } else if (z6) {
                i8 = i9;
                f10 = f12;
                z6 = false;
            } else {
                f10 += f12;
            }
            f9 += f12;
            if (f6 > 0.0f && f9 >= f6 && charAt != ' ') {
                i6++;
                j xt = xt(i6);
                if (i8 == i7) {
                    xt.j(str.substring(i7, i9).trim(), (f9 - f12) - ((r9.length() - r7.length()) * f11));
                    i7 = i9;
                    i8 = i7;
                    f9 = f12;
                    f10 = f9;
                } else {
                    xt.j(str.substring(i7, i8 - 1).trim(), ((f9 - f10) - ((r7.length() - r13.length()) * f11)) - f11);
                    f9 = f10;
                    i7 = i8;
                }
            }
        }
        if (f9 > 0.0f) {
            i6++;
            xt(i6).j(str.substring(i7), f9);
        }
        return this.ws.subList(0, i6);
    }

    private void j(com.bytedance.adsdk.lottie.model.r rVar, float f6, com.bytedance.adsdk.lottie.model.xt xtVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.j.j.r> j6 = j(rVar);
        for (int i6 = 0; i6 < j6.size(); i6++) {
            Path r5 = j6.get(i6).r();
            r5.computeBounds(this.tl, false);
            this.f23418g.reset();
            this.f23418g.preTranslate(0.0f, (-xtVar.ae) * com.bytedance.adsdk.lottie.up.g.j());
            this.f23418g.preScale(f6, f6);
            r5.transform(this.f23418g);
            if (xtVar.qv) {
                j(r5, this.oq, canvas);
                j(r5, this.qv, canvas);
            } else {
                j(r5, this.qv, canvas);
                j(r5, this.oq, canvas);
            }
        }
    }

    private void j(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void j(String str, com.bytedance.adsdk.lottie.model.xt xtVar, Canvas canvas) {
        if (xtVar.qv) {
            j(str, this.oq, canvas);
            j(str, this.qv, canvas);
        } else {
            j(str, this.qv, canvas);
            j(str, this.oq, canvas);
        }
    }

    private void j(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.j.j.r> j(com.bytedance.adsdk.lottie.model.r rVar) {
        if (this.vl.containsKey(rVar)) {
            return this.vl.get(rVar);
        }
        List<av> j6 = rVar.j();
        int size = j6.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(new com.bytedance.adsdk.lottie.j.j.r(this.av, this, j6.get(i6), this.f23419i));
        }
        this.vl.put(rVar, arrayList);
        return arrayList;
    }

    private String j(String str, int i6) {
        int codePointAt = str.codePointAt(i6);
        int charCount = Character.charCount(codePointAt) + i6;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!cw(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j6 = codePointAt;
        if (this.jy.indexOfKey(j6) >= 0) {
            return this.jy.get(j6);
        }
        this.ae.setLength(0);
        while (i6 < charCount) {
            int codePointAt3 = str.codePointAt(i6);
            this.ae.appendCodePoint(codePointAt3);
            i6 += Character.charCount(codePointAt3);
        }
        String sb = this.ae.toString();
        this.jy.put(j6, sb);
        return sb;
    }
}
