package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.databinding.BindingConversion;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Converters {
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int i6) {
        return new ColorDrawable(i6);
    }

    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int i6) {
        return ColorStateList.valueOf(i6);
    }
}
