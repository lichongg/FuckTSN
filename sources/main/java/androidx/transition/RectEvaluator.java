package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    RectEvaluator() {
    }

    RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f6, Rect rect, Rect rect2) {
        int i6 = rect.left + ((int) ((rect2.left - r0) * f6));
        int i7 = rect.top + ((int) ((rect2.top - r1) * f6));
        int i8 = rect.right + ((int) ((rect2.right - r2) * f6));
        int i9 = rect.bottom + ((int) ((rect2.bottom - r6) * f6));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i6, i7, i8, i9);
        }
        rect3.set(i6, i7, i8, i9);
        return this.mRect;
    }
}
