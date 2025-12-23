package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    static boolean isEditable(@NonNull EditText editText) {
        if (editText.getInputType() != 0) {
            return true;
        }
        return false;
    }
}
