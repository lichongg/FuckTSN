package com.google.android.material.slider;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface LabelFormatter {
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_VISIBLE = 3;
    public static final int LABEL_WITHIN_BOUNDS = 1;

    @NonNull
    String getFormattedValue(float f6);
}
