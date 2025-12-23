package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HarmonizedColors {
    private static final String TAG = "HarmonizedColors";

    @RequiresApi(api = 30)
    private static void addHarmonizedColorAttributesToReplacementMap(@NonNull Map<Integer, Integer> map, @NonNull TypedArray typedArray, @Nullable TypedArray typedArray2, @ColorInt int i6) {
        if (typedArray2 == null) {
            typedArray2 = typedArray;
        }
        for (int i7 = 0; i7 < typedArray.getIndexCount(); i7++) {
            int resourceId = typedArray2.getResourceId(i7, 0);
            if (resourceId != 0 && typedArray.hasValue(i7) && ResourcesLoaderUtils.isColorResource(typedArray.getType(i7))) {
                map.put(Integer.valueOf(resourceId), Integer.valueOf(MaterialColors.harmonize(typedArray.getColor(i7, 0), i6)));
            }
        }
    }

    @RequiresApi(api = 30)
    private static Map<Integer, Integer> createHarmonizedColorReplacementMap(Context context, HarmonizedColorsOptions harmonizedColorsOptions) {
        HashMap hashMap = new HashMap();
        int color = MaterialColors.getColor(context, harmonizedColorsOptions.getColorAttributeToHarmonizeWith(), TAG);
        for (int i6 : harmonizedColorsOptions.getColorResourceIds()) {
            hashMap.put(Integer.valueOf(i6), Integer.valueOf(MaterialColors.harmonize(ContextCompat.getColor(context, i6), color)));
        }
        HarmonizedColorAttributes colorAttributes = harmonizedColorsOptions.getColorAttributes();
        if (colorAttributes != null) {
            int[] attributes = colorAttributes.getAttributes();
            if (attributes.length > 0) {
                int themeOverlay = colorAttributes.getThemeOverlay();
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributes);
                TypedArray obtainStyledAttributes2 = themeOverlay != 0 ? new ContextThemeWrapper(context, themeOverlay).obtainStyledAttributes(attributes) : null;
                addHarmonizedColorAttributesToReplacementMap(hashMap, obtainStyledAttributes, obtainStyledAttributes2, color);
                obtainStyledAttributes.recycle();
                if (obtainStyledAttributes2 != null) {
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return hashMap;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static boolean isHarmonizedColorAvailable() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private HarmonizedColors() {
    }

    @NonNull
    public static void applyToContextIfAvailable(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (isHarmonizedColorAvailable()) {
            Map<Integer, Integer> createHarmonizedColorReplacementMap = createHarmonizedColorReplacementMap(context, harmonizedColorsOptions);
            int themeOverlayResourceId = harmonizedColorsOptions.getThemeOverlayResourceId(0);
            if (ResourcesLoaderUtils.addResourcesLoaderToContext(context, createHarmonizedColorReplacementMap) && themeOverlayResourceId != 0) {
                ThemeUtils.applyThemeOverlay(context, themeOverlayResourceId);
            }
        }
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (isHarmonizedColorAvailable()) {
            Map<Integer, Integer> createHarmonizedColorReplacementMap = createHarmonizedColorReplacementMap(context, harmonizedColorsOptions);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, harmonizedColorsOptions.getThemeOverlayResourceId(R.style.ThemeOverlay_Material3_HarmonizedColors_Empty));
            contextThemeWrapper.applyOverrideConfiguration(new Configuration());
            if (ResourcesLoaderUtils.addResourcesLoaderToContext(contextThemeWrapper, createHarmonizedColorReplacementMap)) {
                return contextThemeWrapper;
            }
        }
        return context;
    }
}
