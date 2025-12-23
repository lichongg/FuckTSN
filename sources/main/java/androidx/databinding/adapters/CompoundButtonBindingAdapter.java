package androidx.databinding.adapters;

import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@BindingMethods({@BindingMethod(attribute = "android:buttonTint", method = "setButtonTintList", type = CompoundButton.class), @BindingMethod(attribute = "android:onCheckedChanged", method = "setOnCheckedChangeListener", type = CompoundButton.class)})
@InverseBindingMethods({@InverseBindingMethod(attribute = "android:checked", type = CompoundButton.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class CompoundButtonBindingAdapter {
    @BindingAdapter(requireAll = false, value = {"android:onCheckedChanged", "android:checkedAttrChanged"})
    public static void setListeners(CompoundButton compoundButton, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: androidx.databinding.adapters.CompoundButtonBindingAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton2, boolean z5) {
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = onCheckedChangeListener;
                    if (onCheckedChangeListener2 != null) {
                        onCheckedChangeListener2.onCheckedChanged(compoundButton2, z5);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }

    @BindingAdapter({"android:checked"})
    public static void setChecked(CompoundButton compoundButton, boolean z5) {
        if (compoundButton.isChecked() != z5) {
            compoundButton.setChecked(z5);
        }
    }
}
