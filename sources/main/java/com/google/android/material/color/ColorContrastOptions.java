package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ColorContrastOptions {

    @StyleRes
    private final int highContrastThemeOverlayResourceId;

    @StyleRes
    private final int mediumContrastThemeOverlayResourceId;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.color.ColorContrastOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        @StyleRes
        private int highContrastThemeOverlayResourceId;

        @StyleRes
        private int mediumContrastThemeOverlayResourceId;

        @NonNull
        public ColorContrastOptions build() {
            return new ColorContrastOptions(this, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setHighContrastThemeOverlay(@StyleRes int i6) {
            this.highContrastThemeOverlayResourceId = i6;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setMediumContrastThemeOverlay(@StyleRes int i6) {
            this.mediumContrastThemeOverlayResourceId = i6;
            return this;
        }
    }

    /* synthetic */ ColorContrastOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ColorContrastOptions(Builder builder) {
        this.mediumContrastThemeOverlayResourceId = builder.mediumContrastThemeOverlayResourceId;
        this.highContrastThemeOverlayResourceId = builder.highContrastThemeOverlayResourceId;
    }

    @StyleRes
    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    @StyleRes
    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }
}
