package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final /* synthetic */ class e {
    public static /* synthetic */ void a(EditText[] editTextArr, View view, boolean z5) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }

    public static void c(@NonNull final EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.datepicker.c
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z5) {
                e.a(editTextArr, view, z5);
            }
        };
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
        final EditText editText2 = editTextArr[0];
        editText2.postDelayed(new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                ViewUtils.requestFocusAndShowKeyboard(editText2, false);
            }
        }, 100L);
    }
}
