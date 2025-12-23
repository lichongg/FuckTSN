package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.Switch;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@BindingMethods({@BindingMethod(attribute = "android:thumb", method = "setThumbDrawable", type = Switch.class), @BindingMethod(attribute = "android:track", method = "setTrackDrawable", type = Switch.class)})
@TargetApi(14)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class SwitchBindingAdapter {
    @BindingAdapter({"android:switchTextAppearance"})
    public static void setSwitchTextAppearance(Switch r12, int i6) {
        r12.setSwitchTextAppearance(null, i6);
    }
}
