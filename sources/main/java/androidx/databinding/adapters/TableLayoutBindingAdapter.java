package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");

    @BindingAdapter({"android:shrinkColumns"})
    public static void setShrinkColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setShrinkAllColumns(true);
            return;
        }
        tableLayout.setShrinkAllColumns(false);
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = parseColumns.keyAt(i6);
            boolean valueAt = parseColumns.valueAt(i6);
            if (valueAt) {
                tableLayout.setColumnShrinkable(keyAt, valueAt);
            }
        }
    }

    @BindingAdapter({"android:stretchColumns"})
    public static void setStretchColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setStretchAllColumns(true);
            return;
        }
        tableLayout.setStretchAllColumns(false);
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = parseColumns.keyAt(i6);
            boolean valueAt = parseColumns.valueAt(i6);
            if (valueAt) {
                tableLayout.setColumnStretchable(keyAt, valueAt);
            }
        }
    }

    private static SparseBooleanArray parseColumns(CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (charSequence != null) {
            for (String str : sColumnPattern.split(charSequence)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    if (parseInt >= 0) {
                        sparseBooleanArray.put(parseInt, true);
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return sparseBooleanArray;
    }

    @BindingAdapter({"android:collapseColumns"})
    public static void setCollapseColumns(TableLayout tableLayout, CharSequence charSequence) {
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        for (int i6 = 0; i6 < 20; i6++) {
            boolean z5 = parseColumns.get(i6, false);
            if (z5 != tableLayout.isColumnCollapsed(i6)) {
                tableLayout.setColumnCollapsed(i6, z5);
            }
        }
    }
}
