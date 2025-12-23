package xyz.adscope.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f54828a;

    /* renamed from: b, reason: collision with root package name */
    private float f54829b;

    /* renamed from: c, reason: collision with root package name */
    private String f54830c;

    /* renamed from: d, reason: collision with root package name */
    private int f54831d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f54832e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f54833f;

    private void d() {
        this.f54832e.setAntiAlias(true);
        this.f54832e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f54833f.setAntiAlias(true);
        this.f54833f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f54828a, this.f54833f, 31);
        RectF rectF = this.f54828a;
        float f6 = this.f54829b;
        canvas.drawRoundRect(rectF, f6, f6, this.f54833f);
        canvas.saveLayer(this.f54828a, this.f54832e, 31);
        super.draw(canvas);
        if (this.f54831d > 0 && !TextUtils.isEmpty(this.f54830c) && this.f54830c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f54830c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f54831d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f54828a;
            float f7 = this.f54829b;
            canvas.drawRoundRect(rectF2, f7, f7, paint);
        }
        canvas.restore();
    }

    protected void setBorderColor(String str) {
        this.f54830c = str;
    }

    protected void setBorderWidth(int i6) {
        this.f54831d = i6;
    }

    protected void setRectRadius(float f6) {
        this.f54829b = f6;
    }

    public b(@NonNull Context context) {
        super(context);
        this.f54828a = new RectF();
        this.f54829b = 0.0f;
        this.f54830c = null;
        this.f54831d = 0;
        this.f54832e = new Paint();
        this.f54833f = new Paint();
        d();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f54828a.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
