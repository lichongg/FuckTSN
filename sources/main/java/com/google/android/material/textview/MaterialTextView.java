package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private static int readFirstAvailableDimension(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int i6 = -1;
        for (int i7 = 0; i7 < iArr.length && i6 < 0; i7++) {
            i6 = MaterialResources.getDimensionPixelSize(context, typedArray, iArr[i7], -1);
        }
        return i6;
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme theme, int i6) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i6, com.google.android.material.R.styleable.MaterialTextAppearance);
        int readFirstAvailableDimension = readFirstAvailableDimension(getContext(), obtainStyledAttributes, com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (readFirstAvailableDimension >= 0) {
            setLineHeight(readFirstAvailableDimension);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context context) {
        return MaterialAttributes.resolveBoolean(context, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.MaterialTextView, i6, i7);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.MaterialTextView, i6, i7);
        int readFirstAvailableDimension = readFirstAvailableDimension(context, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R.styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        return readFirstAvailableDimension != -1;
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i6, 0), attributeSet, i6);
        initialize(attributeSet, i6, 0);
    }

    private void initialize(@Nullable AttributeSet attributeSet, int i6, int i7) {
        int findViewAppearanceResourceId;
        Context context = getContext();
        if (canApplyTextAppearanceLineHeight(context)) {
            Resources.Theme theme = context.getTheme();
            if (!viewAttrsHasLineHeight(context, theme, attributeSet, i6, i7) && (findViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, i6, i7)) != -1) {
                applyLineHeightFromViewAppearance(theme, findViewAppearanceResourceId);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i6) {
        super.setTextAppearance(context, i6);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), i6);
        }
    }

    @Deprecated
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i6, i7), attributeSet, i6);
        initialize(attributeSet, i6, i7);
    }
}
