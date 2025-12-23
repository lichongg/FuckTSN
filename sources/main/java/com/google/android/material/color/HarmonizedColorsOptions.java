package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HarmonizedColorsOptions {

    @AttrRes
    private final int colorAttributeToHarmonizeWith;

    @Nullable
    private final HarmonizedColorAttributes colorAttributes;

    @NonNull
    @ColorRes
    private final int[] colorResourceIds;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.color.HarmonizedColorsOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        @Nullable
        private HarmonizedColorAttributes colorAttributes;

        @NonNull
        @ColorRes
        private int[] colorResourceIds = new int[0];

        @AttrRes
        private int colorAttributeToHarmonizeWith = R.attr.colorPrimary;

        @NonNull
        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setColorAttributeToHarmonizeWith(@AttrRes int i6) {
            this.colorAttributeToHarmonizeWith = i6;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setColorAttributes(@Nullable HarmonizedColorAttributes harmonizedColorAttributes) {
            this.colorAttributes = harmonizedColorAttributes;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setColorResourceIds(@NonNull @ColorRes int[] iArr) {
            this.colorResourceIds = iArr;
            return this;
        }
    }

    /* synthetic */ HarmonizedColorsOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.colorResourceIds = builder.colorResourceIds;
        this.colorAttributes = builder.colorAttributes;
        this.colorAttributeToHarmonizeWith = builder.colorAttributeToHarmonizeWith;
    }

    @NonNull
    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    @AttrRes
    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    @Nullable
    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    @NonNull
    @ColorRes
    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    @StyleRes
    int getThemeOverlayResourceId(@StyleRes int i6) {
        HarmonizedColorAttributes harmonizedColorAttributes = this.colorAttributes;
        return (harmonizedColorAttributes == null || harmonizedColorAttributes.getThemeOverlay() == 0) ? i6 : this.colorAttributes.getThemeOverlay();
    }
}
