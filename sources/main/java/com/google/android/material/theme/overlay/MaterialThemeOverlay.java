package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = {R.attr.theme, com.google.android.material.R.attr.theme};
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = {com.google.android.material.R.attr.materialThemeOverlay};

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6, @StyleRes int i7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MATERIAL_THEME_OVERLAY_ATTR, i6, i7);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private MaterialThemeOverlay() {
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6, @StyleRes int i7) {
        boolean z5;
        int obtainMaterialThemeOverlayId = obtainMaterialThemeOverlayId(context, attributeSet, i6, i7);
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == obtainMaterialThemeOverlayId) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (obtainMaterialThemeOverlayId != 0 && !z5) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, obtainMaterialThemeOverlayId);
            int obtainAndroidThemeOverlayId = obtainAndroidThemeOverlayId(context, attributeSet);
            if (obtainAndroidThemeOverlayId != 0) {
                contextThemeWrapper.getTheme().applyStyle(obtainAndroidThemeOverlayId, true);
            }
            return contextThemeWrapper;
        }
        return context;
    }
}
