package com.bxkj.student.v2.ai.fitness.camera;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i extends GraphicOverlay.a {

    /* renamed from: h, reason: collision with root package name */
    private static final int f20549h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static final float f20550i = 60.0f;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f20551b;

    /* renamed from: c, reason: collision with root package name */
    private final GraphicOverlay f20552c;

    /* renamed from: d, reason: collision with root package name */
    private final long f20553d;

    /* renamed from: e, reason: collision with root package name */
    private final long f20554e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final Integer f20555f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20556g;

    public i(GraphicOverlay overlay, long frameLatency, long detectorLatency, @Nullable Integer framesPerSecond) {
        super(overlay);
        this.f20556g = true;
        this.f20552c = overlay;
        this.f20553d = frameLatency;
        this.f20554e = detectorLatency;
        this.f20555f = framesPerSecond;
        Paint paint = new Paint();
        this.f20551b = paint;
        paint.setColor(-1);
        paint.setTextSize(60.0f);
        paint.setShadowLayer(5.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        e();
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay.a
    public synchronized void a(Canvas canvas) {
        try {
            canvas.drawText("InputImage size: " + this.f20552c.getImageHeight() + "x" + this.f20552c.getImageWidth(), 30.0f, 90.0f, this.f20551b);
            if (this.f20556g) {
                if (this.f20555f != null) {
                    canvas.drawText("FPS: " + this.f20555f + ", Frame latency: " + this.f20553d + " ms", 30.0f, 150.0f, this.f20551b);
                } else {
                    canvas.drawText("Frame latency: " + this.f20553d + " ms", 30.0f, 150.0f, this.f20551b);
                }
                canvas.drawText("AI FITNESS", 30.0f, 210.0f, this.f20551b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public i(GraphicOverlay overlay) {
        this(overlay, 0L, 0L, null);
        this.f20556g = false;
    }
}
