package androidx.databinding.adapters;

import android.R;
import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class AbsSpinnerBindingAdapter {
    @BindingAdapter({"android:entries"})
    public static <T extends CharSequence> void setEntries(AbsSpinner absSpinner, T[] tArr) {
        if (tArr == null) {
            absSpinner.setAdapter((SpinnerAdapter) null);
            return;
        }
        SpinnerAdapter adapter = absSpinner.getAdapter();
        if (adapter != null && adapter.getCount() == tArr.length) {
            for (int i6 = 0; i6 < tArr.length; i6++) {
                if (tArr[i6].equals(adapter.getItem(i6))) {
                }
            }
            return;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(absSpinner.getContext(), R.layout.simple_spinner_item, tArr);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        absSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    @BindingAdapter({"android:entries"})
    public static <T> void setEntries(AbsSpinner absSpinner, List<T> list) {
        if (list != null) {
            SpinnerAdapter adapter = absSpinner.getAdapter();
            if (adapter instanceof ObservableListAdapter) {
                ((ObservableListAdapter) adapter).setList(list);
                return;
            } else {
                absSpinner.setAdapter((SpinnerAdapter) new ObservableListAdapter(absSpinner.getContext(), list, R.layout.simple_spinner_item, R.layout.simple_spinner_dropdown_item, 0));
                return;
            }
        }
        absSpinner.setAdapter((SpinnerAdapter) null);
    }
}
