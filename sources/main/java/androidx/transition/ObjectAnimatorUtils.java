package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class ObjectAnimatorUtils {
    static <T> ObjectAnimator ofPointF(T t5, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t5, property, (TypeConverter) null, path);
    }

    private ObjectAnimatorUtils() {
    }
}
