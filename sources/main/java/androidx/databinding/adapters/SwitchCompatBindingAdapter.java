package androidx.databinding.adapters;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@BindingMethods({@BindingMethod(attribute = "android:thumb", method = "setThumbDrawable", type = SwitchCompat.class), @BindingMethod(attribute = "android:track", method = "setTrackDrawable", type = SwitchCompat.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class SwitchCompatBindingAdapter {
    @BindingAdapter({"android:switchTextAppearance"})
    public static void setSwitchTextAppearance(SwitchCompat switchCompat, int i6) {
        switchCompat.setSwitchTextAppearance(null, i6);
    }
}
