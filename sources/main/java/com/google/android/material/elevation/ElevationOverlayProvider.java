package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(@NonNull Context context) {
        this(MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0), MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i6, float f6, @NonNull View view) {
        return compositeOverlay(i6, f6 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i6, float f6, @NonNull View view) {
        return compositeOverlayIfNeeded(i6, f6 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f6, @NonNull View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f6 + getParentAbsoluteElevation(view));
    }

    private boolean isThemeSurfaceColor(@ColorInt int i6) {
        return ColorUtils.setAlphaComponent(i6, 255) == this.colorSurface;
    }

    public float calculateOverlayAlphaFraction(float f6) {
        if (this.displayDensity <= 0.0f || f6 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f6 / r0)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int calculateOverlayAlpha(float f6) {
        return Math.round(calculateOverlayAlphaFraction(f6) * 255.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i6, float f6) {
        int i7;
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f6);
        int alpha = Color.alpha(i6);
        int layer = MaterialColors.layer(ColorUtils.setAlphaComponent(i6, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction);
        if (calculateOverlayAlphaFraction > 0.0f && (i7 = this.elevationOverlayAccentColor) != 0) {
            layer = MaterialColors.layer(layer, ColorUtils.setAlphaComponent(i7, OVERLAY_ACCENT_COLOR_ALPHA));
        }
        return ColorUtils.setAlphaComponent(layer, alpha);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i6, float f6) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i6)) ? compositeOverlay(i6, f6) : i6;
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f6) {
        return compositeOverlayIfNeeded(this.colorSurface, f6);
    }

    public float getParentAbsoluteElevation(@NonNull View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    public ElevationOverlayProvider(boolean z5, @ColorInt int i6, @ColorInt int i7, @ColorInt int i8, float f6) {
        this.elevationOverlayEnabled = z5;
        this.elevationOverlayColor = i6;
        this.elevationOverlayAccentColor = i7;
        this.colorSurface = i8;
        this.displayDensity = f6;
    }
}
