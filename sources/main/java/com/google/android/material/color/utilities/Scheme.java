package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CheckReturnValue
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme) || !super.equals(obj)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary;
    }

    public Scheme(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34) {
        this.primary = i6;
        this.onPrimary = i7;
        this.primaryContainer = i8;
        this.onPrimaryContainer = i9;
        this.secondary = i10;
        this.onSecondary = i11;
        this.secondaryContainer = i12;
        this.onSecondaryContainer = i13;
        this.tertiary = i14;
        this.onTertiary = i15;
        this.tertiaryContainer = i16;
        this.onTertiaryContainer = i17;
        this.error = i18;
        this.onError = i19;
        this.errorContainer = i20;
        this.onErrorContainer = i21;
        this.background = i22;
        this.onBackground = i23;
        this.surface = i24;
        this.onSurface = i25;
        this.surfaceVariant = i26;
        this.onSurfaceVariant = i27;
        this.outline = i28;
        this.outlineVariant = i29;
        this.shadow = i30;
        this.scrim = i31;
        this.inverseSurface = i32;
        this.inverseOnSurface = i33;
        this.inversePrimary = i34;
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f32582a1.tone(80)).withOnPrimary(corePalette.f32582a1.tone(20)).withPrimaryContainer(corePalette.f32582a1.tone(30)).withOnPrimaryContainer(corePalette.f32582a1.tone(90)).withSecondary(corePalette.f32583a2.tone(80)).withOnSecondary(corePalette.f32583a2.tone(20)).withSecondaryContainer(corePalette.f32583a2.tone(30)).withOnSecondaryContainer(corePalette.f32583a2.tone(90)).withTertiary(corePalette.f32584a3.tone(80)).withOnTertiary(corePalette.f32584a3.tone(20)).withTertiaryContainer(corePalette.f32584a3.tone(30)).withOnTertiaryContainer(corePalette.f32584a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.f32585n1.tone(10)).withOnBackground(corePalette.f32585n1.tone(90)).withSurface(corePalette.f32585n1.tone(10)).withOnSurface(corePalette.f32585n1.tone(90)).withSurfaceVariant(corePalette.f32586n2.tone(30)).withOnSurfaceVariant(corePalette.f32586n2.tone(80)).withOutline(corePalette.f32586n2.tone(60)).withOutlineVariant(corePalette.f32586n2.tone(30)).withShadow(corePalette.f32585n1.tone(0)).withScrim(corePalette.f32585n1.tone(0)).withInverseSurface(corePalette.f32585n1.tone(90)).withInverseOnSurface(corePalette.f32585n1.tone(20)).withInversePrimary(corePalette.f32582a1.tone(40));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f32582a1.tone(40)).withOnPrimary(corePalette.f32582a1.tone(100)).withPrimaryContainer(corePalette.f32582a1.tone(90)).withOnPrimaryContainer(corePalette.f32582a1.tone(10)).withSecondary(corePalette.f32583a2.tone(40)).withOnSecondary(corePalette.f32583a2.tone(100)).withSecondaryContainer(corePalette.f32583a2.tone(90)).withOnSecondaryContainer(corePalette.f32583a2.tone(10)).withTertiary(corePalette.f32584a3.tone(40)).withOnTertiary(corePalette.f32584a3.tone(100)).withTertiaryContainer(corePalette.f32584a3.tone(90)).withOnTertiaryContainer(corePalette.f32584a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.f32585n1.tone(99)).withOnBackground(corePalette.f32585n1.tone(10)).withSurface(corePalette.f32585n1.tone(99)).withOnSurface(corePalette.f32585n1.tone(10)).withSurfaceVariant(corePalette.f32586n2.tone(90)).withOnSurfaceVariant(corePalette.f32586n2.tone(30)).withOutline(corePalette.f32586n2.tone(50)).withOutlineVariant(corePalette.f32586n2.tone(80)).withShadow(corePalette.f32585n1.tone(0)).withScrim(corePalette.f32585n1.tone(0)).withInverseSurface(corePalette.f32585n1.tone(20)).withInverseOnSurface(corePalette.f32585n1.tone(95)).withInversePrimary(corePalette.f32582a1.tone(80));
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public void setBackground(int i6) {
        this.background = i6;
    }

    public void setError(int i6) {
        this.error = i6;
    }

    public void setErrorContainer(int i6) {
        this.errorContainer = i6;
    }

    public void setInverseOnSurface(int i6) {
        this.inverseOnSurface = i6;
    }

    public void setInversePrimary(int i6) {
        this.inversePrimary = i6;
    }

    public void setInverseSurface(int i6) {
        this.inverseSurface = i6;
    }

    public void setOnBackground(int i6) {
        this.onBackground = i6;
    }

    public void setOnError(int i6) {
        this.onError = i6;
    }

    public void setOnErrorContainer(int i6) {
        this.onErrorContainer = i6;
    }

    public void setOnPrimary(int i6) {
        this.onPrimary = i6;
    }

    public void setOnPrimaryContainer(int i6) {
        this.onPrimaryContainer = i6;
    }

    public void setOnSecondary(int i6) {
        this.onSecondary = i6;
    }

    public void setOnSecondaryContainer(int i6) {
        this.onSecondaryContainer = i6;
    }

    public void setOnSurface(int i6) {
        this.onSurface = i6;
    }

    public void setOnSurfaceVariant(int i6) {
        this.onSurfaceVariant = i6;
    }

    public void setOnTertiary(int i6) {
        this.onTertiary = i6;
    }

    public void setOnTertiaryContainer(int i6) {
        this.onTertiaryContainer = i6;
    }

    public void setOutline(int i6) {
        this.outline = i6;
    }

    public void setOutlineVariant(int i6) {
        this.outlineVariant = i6;
    }

    public void setPrimary(int i6) {
        this.primary = i6;
    }

    public void setPrimaryContainer(int i6) {
        this.primaryContainer = i6;
    }

    public void setScrim(int i6) {
        this.scrim = i6;
    }

    public void setSecondary(int i6) {
        this.secondary = i6;
    }

    public void setSecondaryContainer(int i6) {
        this.secondaryContainer = i6;
    }

    public void setShadow(int i6) {
        this.shadow = i6;
    }

    public void setSurface(int i6) {
        this.surface = i6;
    }

    public void setSurfaceVariant(int i6) {
        this.surfaceVariant = i6;
    }

    public void setTertiary(int i6) {
        this.tertiary = i6;
    }

    public void setTertiaryContainer(int i6) {
        this.tertiaryContainer = i6;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    @CanIgnoreReturnValue
    public Scheme withBackground(int i6) {
        this.background = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withError(int i6) {
        this.error = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withErrorContainer(int i6) {
        this.errorContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withInverseOnSurface(int i6) {
        this.inverseOnSurface = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withInversePrimary(int i6) {
        this.inversePrimary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withInverseSurface(int i6) {
        this.inverseSurface = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnBackground(int i6) {
        this.onBackground = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnError(int i6) {
        this.onError = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnErrorContainer(int i6) {
        this.onErrorContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnPrimary(int i6) {
        this.onPrimary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnPrimaryContainer(int i6) {
        this.onPrimaryContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnSecondary(int i6) {
        this.onSecondary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnSecondaryContainer(int i6) {
        this.onSecondaryContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnSurface(int i6) {
        this.onSurface = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnSurfaceVariant(int i6) {
        this.onSurfaceVariant = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnTertiary(int i6) {
        this.onTertiary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOnTertiaryContainer(int i6) {
        this.onTertiaryContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOutline(int i6) {
        this.outline = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withOutlineVariant(int i6) {
        this.outlineVariant = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withPrimary(int i6) {
        this.primary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withPrimaryContainer(int i6) {
        this.primaryContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withScrim(int i6) {
        this.scrim = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withSecondary(int i6) {
        this.secondary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withSecondaryContainer(int i6) {
        this.secondaryContainer = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withShadow(int i6) {
        this.shadow = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withSurface(int i6) {
        this.surface = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withSurfaceVariant(int i6) {
        this.surfaceVariant = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withTertiary(int i6) {
        this.tertiary = i6;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme withTertiaryContainer(int i6) {
        this.tertiaryContainer = i6;
        return this;
    }

    public static Scheme dark(int i6) {
        return darkFromCorePalette(CorePalette.of(i6));
    }

    public static Scheme darkContent(int i6) {
        return darkFromCorePalette(CorePalette.contentOf(i6));
    }

    public static Scheme light(int i6) {
        return lightFromCorePalette(CorePalette.of(i6));
    }

    public static Scheme lightContent(int i6) {
        return lightFromCorePalette(CorePalette.contentOf(i6));
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }
}
