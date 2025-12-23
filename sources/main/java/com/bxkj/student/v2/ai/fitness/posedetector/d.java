package com.bxkj.student.v2.ai.fitness.posedetector;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay;
import com.google.common.primitives.Ints;
import com.google.mlkit.vision.common.PointF3D;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseLandmark;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d extends GraphicOverlay.a {

    /* renamed from: o, reason: collision with root package name */
    private static final float f20614o = 8.0f;

    /* renamed from: p, reason: collision with root package name */
    private static final float f20615p = 30.0f;

    /* renamed from: q, reason: collision with root package name */
    private static final float f20616q = 30.0f;

    /* renamed from: r, reason: collision with root package name */
    private static final float f20617r = 200.0f;

    /* renamed from: b, reason: collision with root package name */
    private final Pose f20618b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f20619c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f20620d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f20621e;

    /* renamed from: f, reason: collision with root package name */
    private float f20622f;

    /* renamed from: g, reason: collision with root package name */
    private float f20623g;

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f20624h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f20625i;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f20626j;

    /* renamed from: k, reason: collision with root package name */
    private final Paint f20627k;

    /* renamed from: l, reason: collision with root package name */
    private final Paint f20628l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f20629m;

    /* renamed from: n, reason: collision with root package name */
    private String f20630n;

    private void k(Paint paint, Canvas canvas, float zInImagePixel) {
        float width;
        float width2;
        if (this.f20620d) {
            if (this.f20621e) {
                width2 = Math.min(-0.001f, f(this.f20622f));
                width = Math.max(0.001f, f(this.f20623g));
            } else {
                width = canvas.getWidth() * 1.0f;
                width2 = canvas.getWidth() * (-1.0f);
            }
            float f6 = f(zInImagePixel);
            if (f6 < 0.0f) {
                int constrainToRange = 255 - Ints.constrainToRange((int) ((f6 / width2) * 255.0f), 0, 255);
                paint.setARGB(255, 255, constrainToRange, constrainToRange);
            } else {
                int constrainToRange2 = 255 - Ints.constrainToRange((int) ((f6 / width) * 255.0f), 0, 255);
                paint.setARGB(255, constrainToRange2, constrainToRange2, 255);
            }
        }
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay.a
    public void a(Canvas canvas) {
        List<PoseLandmark> allPoseLandmarks = this.f20618b.getAllPoseLandmarks();
        if (allPoseLandmarks.isEmpty() || allPoseLandmarks.size() < 33) {
            return;
        }
        float measureText = this.f20625i.measureText(this.f20624h.get(0));
        float width = (canvas.getWidth() / 2) - (measureText / 2.0f);
        Paint.FontMetrics fontMetrics = this.f20625i.getFontMetrics();
        float f6 = fontMetrics.bottom;
        float f7 = fontMetrics.top;
        float f8 = ((f6 - f7) / 2.0f) - f7;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#B0707070"));
        paint.setStyle(Paint.Style.FILL);
        if (this.f20629m) {
            float f9 = f8;
            for (int i6 = 0; i6 < this.f20624h.size(); i6++) {
                String str = this.f20624h.get(i6);
                this.f20625i.getTextBounds(str, 0, str.length(), new Rect());
                float f10 = width - 10.0f;
                float height = (f9 - r2.height()) - 10.0f;
                canvas.drawRoundRect(f10, height, measureText + 20.0f + f10, r2.height() + 20.0f + height, 30.0f, 30.0f, paint);
                canvas.drawText(this.f20624h.get(i6), width, f9, this.f20625i);
                f9 += r2.height() + 20.0f;
            }
        }
        for (PoseLandmark poseLandmark : allPoseLandmarks) {
            j(canvas, poseLandmark, this.f20628l);
            if (this.f20620d && this.f20621e) {
                this.f20622f = Math.min(this.f20622f, poseLandmark.getPosition3D().getZ());
                this.f20623g = Math.max(this.f20623g, poseLandmark.getPosition3D().getZ());
            }
        }
        PoseLandmark poseLandmark2 = this.f20618b.getPoseLandmark(0);
        PoseLandmark poseLandmark3 = this.f20618b.getPoseLandmark(1);
        PoseLandmark poseLandmark4 = this.f20618b.getPoseLandmark(2);
        PoseLandmark poseLandmark5 = this.f20618b.getPoseLandmark(3);
        PoseLandmark poseLandmark6 = this.f20618b.getPoseLandmark(4);
        PoseLandmark poseLandmark7 = this.f20618b.getPoseLandmark(5);
        PoseLandmark poseLandmark8 = this.f20618b.getPoseLandmark(6);
        PoseLandmark poseLandmark9 = this.f20618b.getPoseLandmark(7);
        PoseLandmark poseLandmark10 = this.f20618b.getPoseLandmark(8);
        PoseLandmark poseLandmark11 = this.f20618b.getPoseLandmark(9);
        PoseLandmark poseLandmark12 = this.f20618b.getPoseLandmark(10);
        PoseLandmark poseLandmark13 = this.f20618b.getPoseLandmark(11);
        PoseLandmark poseLandmark14 = this.f20618b.getPoseLandmark(12);
        PoseLandmark poseLandmark15 = this.f20618b.getPoseLandmark(13);
        PoseLandmark poseLandmark16 = this.f20618b.getPoseLandmark(14);
        PoseLandmark poseLandmark17 = this.f20618b.getPoseLandmark(15);
        PoseLandmark poseLandmark18 = this.f20618b.getPoseLandmark(16);
        PoseLandmark poseLandmark19 = this.f20618b.getPoseLandmark(23);
        PoseLandmark poseLandmark20 = this.f20618b.getPoseLandmark(24);
        PoseLandmark poseLandmark21 = this.f20618b.getPoseLandmark(25);
        PoseLandmark poseLandmark22 = this.f20618b.getPoseLandmark(26);
        PoseLandmark poseLandmark23 = this.f20618b.getPoseLandmark(27);
        PoseLandmark poseLandmark24 = this.f20618b.getPoseLandmark(28);
        PoseLandmark poseLandmark25 = this.f20618b.getPoseLandmark(17);
        PoseLandmark poseLandmark26 = this.f20618b.getPoseLandmark(18);
        PoseLandmark poseLandmark27 = this.f20618b.getPoseLandmark(19);
        PoseLandmark poseLandmark28 = this.f20618b.getPoseLandmark(20);
        PoseLandmark poseLandmark29 = this.f20618b.getPoseLandmark(21);
        PoseLandmark poseLandmark30 = this.f20618b.getPoseLandmark(22);
        PoseLandmark poseLandmark31 = this.f20618b.getPoseLandmark(29);
        PoseLandmark poseLandmark32 = this.f20618b.getPoseLandmark(30);
        PoseLandmark poseLandmark33 = this.f20618b.getPoseLandmark(31);
        PoseLandmark poseLandmark34 = this.f20618b.getPoseLandmark(32);
        i(canvas, poseLandmark2, poseLandmark3, this.f20628l);
        i(canvas, poseLandmark3, poseLandmark4, this.f20628l);
        i(canvas, poseLandmark4, poseLandmark5, this.f20628l);
        i(canvas, poseLandmark5, poseLandmark9, this.f20628l);
        i(canvas, poseLandmark2, poseLandmark6, this.f20628l);
        i(canvas, poseLandmark6, poseLandmark7, this.f20628l);
        i(canvas, poseLandmark7, poseLandmark8, this.f20628l);
        i(canvas, poseLandmark8, poseLandmark10, this.f20628l);
        i(canvas, poseLandmark11, poseLandmark12, this.f20628l);
        i(canvas, poseLandmark13, poseLandmark14, this.f20628l);
        i(canvas, poseLandmark19, poseLandmark20, this.f20628l);
        i(canvas, poseLandmark13, poseLandmark15, this.f20626j);
        i(canvas, poseLandmark15, poseLandmark17, this.f20626j);
        i(canvas, poseLandmark13, poseLandmark19, this.f20626j);
        i(canvas, poseLandmark19, poseLandmark21, this.f20626j);
        i(canvas, poseLandmark21, poseLandmark23, this.f20626j);
        i(canvas, poseLandmark17, poseLandmark29, this.f20626j);
        i(canvas, poseLandmark17, poseLandmark25, this.f20626j);
        i(canvas, poseLandmark17, poseLandmark27, this.f20626j);
        i(canvas, poseLandmark27, poseLandmark25, this.f20626j);
        i(canvas, poseLandmark23, poseLandmark31, this.f20626j);
        i(canvas, poseLandmark31, poseLandmark33, this.f20626j);
        i(canvas, poseLandmark14, poseLandmark16, this.f20627k);
        i(canvas, poseLandmark16, poseLandmark18, this.f20627k);
        i(canvas, poseLandmark14, poseLandmark20, this.f20627k);
        i(canvas, poseLandmark20, poseLandmark22, this.f20627k);
        i(canvas, poseLandmark22, poseLandmark24, this.f20627k);
        i(canvas, poseLandmark18, poseLandmark30, this.f20627k);
        i(canvas, poseLandmark18, poseLandmark26, this.f20627k);
        i(canvas, poseLandmark18, poseLandmark28, this.f20627k);
        i(canvas, poseLandmark28, poseLandmark26, this.f20627k);
        i(canvas, poseLandmark24, poseLandmark32, this.f20627k);
        i(canvas, poseLandmark32, poseLandmark34, this.f20627k);
        if (this.f20619c) {
            for (PoseLandmark poseLandmark35 : allPoseLandmarks) {
                canvas.drawText(String.format(Locale.US, "%.2f", Float.valueOf(poseLandmark35.getInFrameLikelihood())), g(poseLandmark35.getPosition().x), h(poseLandmark35.getPosition().y), this.f20628l);
            }
        }
    }

    d(GraphicOverlay overlay, Pose pose, boolean showInFrameLikelihood, boolean visualizeZ, boolean rescaleZForVisualization, List<String> poseClassification, boolean isStreamMode, String poseClass) {
        super(overlay);
        this.f20622f = Float.MAX_VALUE;
        this.f20623g = Float.MIN_VALUE;
        this.f20618b = pose;
        this.f20619c = showInFrameLikelihood;
        this.f20620d = visualizeZ;
        this.f20621e = rescaleZForVisualization;
        this.f20624h = poseClassification;
        this.f20629m = isStreamMode;
        this.f20630n = poseClass;
        Paint paint = new Paint();
        this.f20625i = paint;
        paint.setColor(-1);
        paint.setTextSize(200.0f);
        paint.setShadowLayer(5.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = new Paint();
        this.f20628l = paint2;
        paint2.setStrokeWidth(30.0f);
        paint2.setColor(-1);
        paint2.setTextSize(30.0f);
        Paint paint3 = new Paint();
        this.f20626j = paint3;
        paint3.setStrokeWidth(30.0f);
        paint3.setColor(-16711936);
        Paint paint4 = new Paint();
        this.f20627k = paint4;
        paint4.setStrokeWidth(30.0f);
        paint4.setColor(InputDeviceCompat.SOURCE_ANY);
    }

    void i(Canvas canvas, PoseLandmark startLandmark, PoseLandmark endLandmark, Paint paint) {
        PointF3D position3D = startLandmark.getPosition3D();
        PointF3D position3D2 = endLandmark.getPosition3D();
        k(paint, canvas, (position3D.getZ() + position3D2.getZ()) / 2.0f);
        canvas.drawLine(g(position3D.getX()), h(position3D.getY()), g(position3D2.getX()), h(position3D2.getY()), paint);
    }

    void j(Canvas canvas, PoseLandmark landmark, Paint paint) {
        PointF3D position3D = landmark.getPosition3D();
        k(paint, canvas, position3D.getZ());
        canvas.drawCircle(g(position3D.getX()), h(position3D.getY()), f20614o, paint);
    }
}
