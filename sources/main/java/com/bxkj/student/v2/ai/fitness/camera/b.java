package com.bxkj.student.v2.ai.fitness.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b extends GraphicOverlay.a {

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f20512b;

    @Override // com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay.a
    public void a(Canvas canvas) {
        canvas.drawBitmap(this.f20512b, c(), null);
    }

    public b(GraphicOverlay overlay, Bitmap bitmap) {
        super(overlay);
        this.f20512b = bitmap;
    }
}
