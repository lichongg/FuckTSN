package k5;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private float f43572a;

    /* renamed from: b, reason: collision with root package name */
    private Shader f43573b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f43574c = new RectF();

    private void f(@FloatRange(from = 0.0d) float f6) {
        float max = Math.max(0.0f, f6);
        if (max != this.f43572a) {
            this.f43572a = max;
            this.f43573b = null;
        }
    }

    @Override // k5.b
    public void a(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.f43572a == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f43574c, paint);
            return;
        }
        if (this.f43573b == null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f43573b = new BitmapShader(bitmap, tileMode, tileMode);
            Matrix matrix = new Matrix();
            RectF rectF = this.f43574c;
            matrix.setTranslate(rectF.left, rectF.top);
            matrix.preScale(this.f43574c.width() / bitmap.getWidth(), this.f43574c.height() / bitmap.getHeight());
            this.f43573b.setLocalMatrix(matrix);
        }
        paint.setShader(this.f43573b);
        RectF rectF2 = this.f43574c;
        float f6 = this.f43572a;
        canvas.drawRoundRect(rectF2, f6, f6, paint);
    }

    @Override // k5.b
    public void b(Rect rect) {
        this.f43574c.set(rect);
        this.f43573b = null;
    }

    @NonNull
    public RectF c() {
        return this.f43574c;
    }

    @FloatRange(from = 0.0d)
    public float d() {
        return this.f43572a;
    }

    public a(@FloatRange(from = 0.0d) float f6) {
        f(f6);
    }

    public void e(@FloatRange(from = 0.0d) float f6) {
        f(f6);
    }
}
