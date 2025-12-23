package com.bxkj.student.v2.ai.fitness.camera;

import android.graphics.Bitmap;
import androidx.camera.core.ImageProxy;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface m {
    void a(ByteBuffer data, f frameMetadata, GraphicOverlay graphicOverlay) throws MlKitException;

    void b(ImageProxy image, GraphicOverlay graphicOverlay) throws MlKitException;

    void c(Bitmap bitmap, GraphicOverlay graphicOverlay);

    void stop();
}
