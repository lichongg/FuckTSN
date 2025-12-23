package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    abstract void calcPosition(int i6, int i7, float f6, float f7, float f8, float f9);

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int i6, int i7, RectF rectF, RectF rectF2, float f6, float f7);

    abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr);

    KeyPositionBase() {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    void getAttributeNames(HashSet<String> hashSet) {
    }
}
