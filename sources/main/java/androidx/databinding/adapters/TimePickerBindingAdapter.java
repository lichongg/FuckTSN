package androidx.databinding.adapters;

import android.os.Build;
import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class TimePickerBindingAdapter {
    @InverseBindingAdapter(attribute = "android:hour")
    public static int getHour(TimePicker timePicker) {
        int hour;
        if (Build.VERSION.SDK_INT >= 23) {
            hour = timePicker.getHour();
            return hour;
        }
        Integer currentHour = timePicker.getCurrentHour();
        if (currentHour == null) {
            return 0;
        }
        return currentHour.intValue();
    }

    @InverseBindingAdapter(attribute = "android:minute")
    public static int getMinute(TimePicker timePicker) {
        int minute;
        if (Build.VERSION.SDK_INT >= 23) {
            minute = timePicker.getMinute();
            return minute;
        }
        Integer currentMinute = timePicker.getCurrentMinute();
        if (currentMinute == null) {
            return 0;
        }
        return currentMinute.intValue();
    }

    @BindingAdapter({"android:hour"})
    public static void setHour(TimePicker timePicker, int i6) {
        int hour;
        if (Build.VERSION.SDK_INT < 23) {
            if (timePicker.getCurrentHour().intValue() != i6) {
                timePicker.setCurrentHour(Integer.valueOf(i6));
            }
        } else {
            hour = timePicker.getHour();
            if (hour != i6) {
                timePicker.setHour(i6);
            }
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onTimeChanged", "android:hourAttrChanged", "android:minuteAttrChanged"})
    public static void setListeners(TimePicker timePicker, final TimePicker.OnTimeChangedListener onTimeChangedListener, final InverseBindingListener inverseBindingListener, final InverseBindingListener inverseBindingListener2) {
        if (inverseBindingListener == null && inverseBindingListener2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: androidx.databinding.adapters.TimePickerBindingAdapter.1
                @Override // android.widget.TimePicker.OnTimeChangedListener
                public void onTimeChanged(TimePicker timePicker2, int i6, int i7) {
                    TimePicker.OnTimeChangedListener onTimeChangedListener2 = onTimeChangedListener;
                    if (onTimeChangedListener2 != null) {
                        onTimeChangedListener2.onTimeChanged(timePicker2, i6, i7);
                    }
                    InverseBindingListener inverseBindingListener3 = inverseBindingListener;
                    if (inverseBindingListener3 != null) {
                        inverseBindingListener3.onChange();
                    }
                    InverseBindingListener inverseBindingListener4 = inverseBindingListener2;
                    if (inverseBindingListener4 != null) {
                        inverseBindingListener4.onChange();
                    }
                }
            });
        }
    }

    @BindingAdapter({"android:minute"})
    public static void setMinute(TimePicker timePicker, int i6) {
        int minute;
        if (Build.VERSION.SDK_INT < 23) {
            if (timePicker.getCurrentMinute().intValue() != i6) {
                timePicker.setCurrentHour(Integer.valueOf(i6));
            }
        } else {
            minute = timePicker.getMinute();
            if (minute != i6) {
                timePicker.setMinute(i6);
            }
        }
    }
}
