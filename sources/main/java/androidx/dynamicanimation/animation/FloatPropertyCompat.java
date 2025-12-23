package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public abstract float getValue(T t5);

    public abstract void setValue(T t5, float f6);

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        String name;
        name = floatProperty.getName();
        return new FloatPropertyCompat<T>(name) { // from class: androidx.dynamicanimation.animation.FloatPropertyCompat.1
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(T t5) {
                Object obj;
                obj = floatProperty.get(t5);
                return ((Float) obj).floatValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(T t5, float f6) {
                floatProperty.setValue(t5, f6);
            }
        };
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }
}
