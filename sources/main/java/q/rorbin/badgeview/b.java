package q.rorbin.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends ValueAnimator {

    /* renamed from: a, reason: collision with root package name */
    private c[][] f51946a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<QBadgeView> f51947b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QBadgeView qBadgeView = (QBadgeView) b.this.f51947b.get();
            if (qBadgeView == null || !qBadgeView.isShown()) {
                b.this.cancel();
            } else {
                qBadgeView.invalidate();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: q.rorbin.badgeview.b$b, reason: collision with other inner class name */
    class C1004b extends AnimatorListenerAdapter {
        C1004b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QBadgeView qBadgeView = (QBadgeView) b.this.f51947b.get();
            if (qBadgeView != null) {
                qBadgeView.M();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        Random f51950a;

        /* renamed from: b, reason: collision with root package name */
        float f51951b;

        /* renamed from: c, reason: collision with root package name */
        float f51952c;

        /* renamed from: d, reason: collision with root package name */
        float f51953d;

        /* renamed from: e, reason: collision with root package name */
        int f51954e;

        /* renamed from: f, reason: collision with root package name */
        int f51955f;

        /* renamed from: g, reason: collision with root package name */
        Paint f51956g;

        public c() {
            Paint paint = new Paint();
            this.f51956g = paint;
            paint.setAntiAlias(true);
            this.f51956g.setStyle(Paint.Style.FILL);
            this.f51950a = new Random();
        }

        public void a(float f6, Canvas canvas) {
            this.f51956g.setColor(this.f51954e);
            this.f51951b += this.f51950a.nextInt(this.f51955f) * 0.1f * (this.f51950a.nextFloat() - 0.5f);
            float nextInt = this.f51952c + (this.f51950a.nextInt(this.f51955f) * 0.1f * (this.f51950a.nextFloat() - 0.5f));
            this.f51952c = nextInt;
            float f7 = this.f51951b;
            float f8 = this.f51953d;
            canvas.drawCircle(f7, nextInt, f8 - (f6 * f8), this.f51956g);
        }
    }

    public void b(Canvas canvas) {
        for (int i6 = 0; i6 < this.f51946a.length; i6++) {
            int i7 = 0;
            while (true) {
                c[] cVarArr = this.f51946a[i6];
                if (i7 < cVarArr.length) {
                    cVarArr[i7].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i7++;
                }
            }
        }
    }

    public b(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        this.f51947b = new WeakReference<>(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f51946a = c(bitmap, pointF);
        addUpdateListener(new a());
        addListener(new C1004b());
    }

    private c[][] c(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        c[][] cVarArr = (c[][]) Array.newInstance((Class<?>) c.class, (int) (height / min), (int) (width / min));
        for (int i6 = 0; i6 < cVarArr.length; i6++) {
            for (int i7 = 0; i7 < cVarArr[i6].length; i7++) {
                c cVar = new c();
                float f6 = i7 * min;
                float f7 = i6 * min;
                cVar.f51954e = bitmap.getPixel((int) f6, (int) f7);
                cVar.f51951b = f6 + width2;
                cVar.f51952c = f7 + height2;
                cVar.f51953d = min;
                cVar.f51955f = Math.max(width, height);
                cVarArr[i6][i7] = cVar;
            }
        }
        bitmap.recycle();
        return cVarArr;
    }
}
