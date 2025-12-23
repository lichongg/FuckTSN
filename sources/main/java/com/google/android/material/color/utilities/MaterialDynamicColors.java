package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.function.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MaterialDynamicColors {
    private static final double CONTAINER_ACCENT_TONE_DELTA = 15.0d;

    public static /* synthetic */ ToneDeltaConstraint T(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, materialDynamicColors.errorContainer(), dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    public static /* synthetic */ ToneDeltaConstraint a0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, materialDynamicColors.tertiaryContainer(), dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        return dynamicScheme.variant == Variant.MONOCHROME;
    }

    public static /* synthetic */ ToneDeltaConstraint n0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, materialDynamicColors.primaryContainer(), dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        return ViewingConditions.defaultWithBackgroundLstar(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    public static /* synthetic */ ToneDeltaConstraint z1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, materialDynamicColors.secondaryContainer(), dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    @NonNull
    public DynamicColor background() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.h3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.i3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 6.0d : 98.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.d2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 30.0d : 90.0d);
                return valueOf;
            }
        }, null);
    }

    @NonNull
    public DynamicColor controlHighlight() {
        return new DynamicColor(new Function() { // from class: com.google.android.material.color.utilities.y2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(0.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.z2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(0.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.a3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 100.0d : 0.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 0.2d : 0.12d);
                return valueOf;
            }
        }, null, new Function() { // from class: com.google.android.material.color.utilities.d3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(DynamicColor.toneMinContrastDefault(new Function() { // from class: com.google.android.material.color.utilities.i2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        Double valueOf2;
                        valueOf2 = Double.valueOf(r2.isDark ? 100.0d : 0.0d);
                        return valueOf2;
                    }
                }, null, (DynamicScheme) obj, null));
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(DynamicColor.toneMaxContrastDefault(new Function() { // from class: com.google.android.material.color.utilities.x1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        Double valueOf2;
                        valueOf2 = Double.valueOf(r2.isDark ? 100.0d : 0.0d);
                        return valueOf2;
                    }
                }, null, (DynamicScheme) obj, null));
                return valueOf;
            }
        }, null);
    }

    @NonNull
    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.b2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 80.0d : 30.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor error() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.s0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.t0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 80.0d : 40.0d);
                return valueOf;
            }
        }, new q5(this), new Function() { // from class: com.google.android.material.color.utilities.u0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.T(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        });
    }

    @NonNull
    public DynamicColor errorContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 30.0d : 90.0d);
                return valueOf;
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        return dynamicScheme.isDark ? surfaceBright() : surfaceDim();
    }

    @NonNull
    public DynamicColor inverseOnSurface() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.e0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 20.0d : 95.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor inverseSurface;
                inverseSurface = MaterialDynamicColors.this.inverseSurface();
                return inverseSurface;
            }
        });
    }

    @NonNull
    public DynamicColor inversePrimary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.w3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 40.0d : 80.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.z3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor inverseSurface;
                inverseSurface = MaterialDynamicColors.this.inverseSurface();
                return inverseSurface;
            }
        });
    }

    @NonNull
    public DynamicColor inverseSurface() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.d1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 90.0d : 20.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.f0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.q0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicScheme) obj).neutralPalette.getKeyColor().getTone());
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.v4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicScheme) obj).neutralVariantPalette.getKeyColor().getTone());
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor onBackground() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 90.0d : 10.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor background;
                background = MaterialDynamicColors.this.background();
                return background;
            }
        });
    }

    @NonNull
    public DynamicColor onError() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.h4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.i4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 20.0d : 100.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor error;
                error = MaterialDynamicColors.this.error();
                return error;
            }
        });
    }

    @NonNull
    public DynamicColor onErrorContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.f1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).errorPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 90.0d : 10.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor errorContainer;
                errorContainer = MaterialDynamicColors.this.errorContainer();
                return errorContainer;
            }
        });
    }

    @NonNull
    public DynamicColor onPrimary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.t3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.u3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.f1((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.v3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor primary;
                primary = MaterialDynamicColors.this.primary();
                return primary;
            }
        });
    }

    @NonNull
    public DynamicColor onPrimaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.X0(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor primaryContainer;
                primaryContainer = MaterialDynamicColors.this.primaryContainer();
                return primaryContainer;
            }
        }, null);
    }

    @NonNull
    public DynamicColor onPrimaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.u1((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor primaryFixedDim;
                primaryFixedDim = MaterialDynamicColors.this.primaryFixedDim();
                return primaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor onPrimaryFixedVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.c4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.d4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.c((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor primaryFixedDim;
                primaryFixedDim = MaterialDynamicColors.this.primaryFixedDim();
                return primaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor onSecondary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.O1((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor secondary;
                secondary = MaterialDynamicColors.this.secondary();
                return secondary;
            }
        });
    }

    @NonNull
    public DynamicColor onSecondaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.x1(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor secondaryContainer;
                secondaryContainer = MaterialDynamicColors.this.secondaryContainer();
                return secondaryContainer;
            }
        });
    }

    @NonNull
    public DynamicColor onSecondaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.b0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(10.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.d0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor secondaryFixedDim;
                secondaryFixedDim = MaterialDynamicColors.this.secondaryFixedDim();
                return secondaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor onSecondaryFixedVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.u1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.v1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.z((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor secondaryFixedDim;
                secondaryFixedDim = MaterialDynamicColors.this.secondaryFixedDim();
                return secondaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor onSurface() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.u4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.f5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 90.0d : 10.0d);
                return valueOf;
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor onSurfaceVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.z0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 80.0d : 30.0d);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor surfaceVariant;
                surfaceVariant = MaterialDynamicColors.this.surfaceVariant();
                return surfaceVariant;
            }
        });
    }

    @NonNull
    public DynamicColor onTertiary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.y3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.G0((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor tertiary;
                tertiary = MaterialDynamicColors.this.tertiary();
                return tertiary;
            }
        });
    }

    @NonNull
    public DynamicColor onTertiaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.i0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.P1(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor tertiaryContainer;
                tertiaryContainer = MaterialDynamicColors.this.tertiaryContainer();
                return tertiaryContainer;
            }
        });
    }

    @NonNull
    public DynamicColor onTertiaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.t2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.u2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.Z((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.v2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor tertiaryFixedDim;
                tertiaryFixedDim = MaterialDynamicColors.this.tertiaryFixedDim();
                return tertiaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor onTertiaryFixedVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.j2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.L0((DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicColor tertiaryFixedDim;
                tertiaryFixedDim = MaterialDynamicColors.this.tertiaryFixedDim();
                return tertiaryFixedDim;
            }
        });
    }

    @NonNull
    public DynamicColor outline() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 60.0d : 50.0d);
                return valueOf;
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor outlineVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.p3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.q3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 30.0d : 80.0d);
                return valueOf;
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor primary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.p1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.q1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.Y0((DynamicScheme) obj);
            }
        }, new q5(this), new Function() { // from class: com.google.android.material.color.utilities.r1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.n0(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        });
    }

    @NonNull
    public DynamicColor primaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.f3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.R0((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor primaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.d5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.C0((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor primaryFixedDim() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.g5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.y0((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.f2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicScheme) obj).primaryPalette.getKeyColor().getTone());
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor scrim() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.s1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.t1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(0.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor secondary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 80.0d : 40.0d);
                return valueOf;
            }
        }, new q5(this), new Function() { // from class: com.google.android.material.color.utilities.p5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.z1(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        });
    }

    @NonNull
    public DynamicColor secondaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.q2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.s2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.u0((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor secondaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.a4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.N1((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor secondaryFixedDim() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.q4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.r4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.I1((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicScheme) obj).secondaryPalette.getKeyColor().getTone());
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor shadow() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.z4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.a5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(0.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surface() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 6.0d : 98.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceBright() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.r3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.s3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 24.0d : 98.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.y0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 12.0d : 94.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceContainerHigh() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.j3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 17.0d : 92.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceContainerHighest() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.b5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 22.0d : 90.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceContainerLow() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.o2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 10.0d : 96.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceContainerLowest() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 4.0d : 100.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceDim() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.b1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 6.0d : 87.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceTint() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.a0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 80.0d : 40.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor surfaceVariant() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.s4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.t4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 30.0d : 90.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor tertiary() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.y1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.z1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.k1((DynamicScheme) obj);
            }
        }, new q5(this), new Function() { // from class: com.google.android.material.color.utilities.a2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.a0(MaterialDynamicColors.this, (DynamicScheme) obj);
            }
        });
    }

    @NonNull
    public DynamicColor tertiaryContainer() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.i5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.q((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor tertiaryFixed() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.N((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor tertiaryFixedDim() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.f4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.R((DynamicScheme) obj);
            }
        }, new q5(this));
    }

    @NonNull
    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.w2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicScheme) obj).tertiaryPalette.getKeyColor().getTone());
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.x4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.y4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 10.0d : 90.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.v0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 10.0d : 90.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 10.0d : 90.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.i1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 30.0d : 80.0d);
                return valueOf;
            }
        });
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.r2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette tonalPalette;
                tonalPalette = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r2.isDark ? 10.0d : 90.0d);
                return valueOf;
            }
        });
    }

    public static /* synthetic */ Double C0(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 100.0d;
            } else {
                d6 = 10.0d;
            }
            return Double.valueOf(d6);
        }
        return Double.valueOf(90.0d);
    }

    public static /* synthetic */ Double G0(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 10.0d;
            } else {
                d7 = 90.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 20.0d;
        } else {
            d6 = 100.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double I1(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 70.0d;
        } else {
            d6 = 80.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double L0(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 70.0d;
        } else {
            d6 = 30.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double N(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 40.0d;
        } else {
            d6 = 90.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double N1(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 80.0d;
        } else {
            d6 = 90.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double O1(DynamicScheme dynamicScheme) {
        double d6 = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 10.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d6 = 20.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double P1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        Object apply;
        double d6;
        double d7;
        materialDynamicColors.getClass();
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 0.0d;
            } else {
                d7 = 100.0d;
            }
            return Double.valueOf(d7);
        }
        if (isFidelity(dynamicScheme)) {
            apply = materialDynamicColors.tertiaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.contrastingTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d6 = 90.0d;
        } else {
            d6 = 10.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double R(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 30.0d;
        } else {
            d6 = 80.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double R0(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 85.0d;
            } else {
                d7 = 25.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 30.0d;
        } else {
            d6 = 90.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double X0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        Object apply;
        materialDynamicColors.getClass();
        if (isFidelity(dynamicScheme)) {
            apply = materialDynamicColors.primaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.contrastingTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 0.0d;
            } else {
                d7 = 100.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 90.0d;
        } else {
            d6 = 10.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double Y0(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 100.0d;
            } else {
                d7 = 0.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 80.0d;
        } else {
            d6 = 40.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double Z(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 90.0d;
        } else {
            d6 = 10.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double c(DynamicScheme dynamicScheme) {
        double d6 = 30.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d6 = 70.0d;
            }
            return Double.valueOf(d6);
        }
        return Double.valueOf(30.0d);
    }

    public static /* synthetic */ Double f1(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 10.0d;
            } else {
                d7 = 90.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 20.0d;
        } else {
            d6 = 100.0d;
        }
        return Double.valueOf(d6);
    }

    static double findDesiredChromaByTone(double d6, double d7, double d8, boolean z5) {
        double d9;
        Hct from = Hct.from(d6, d7, d8);
        if (from.getChroma() < d7) {
            double chroma = from.getChroma();
            while (from.getChroma() < d7) {
                if (z5) {
                    d9 = -1.0d;
                } else {
                    d9 = 1.0d;
                }
                d8 += d9;
                Hct from2 = Hct.from(d6, d7, d8);
                if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d7) < 0.4d) {
                    return d8;
                }
                if (Math.abs(from2.getChroma() - d7) < Math.abs(from.getChroma() - d7)) {
                    from = from2;
                }
                chroma = Math.max(chroma, from2.getChroma());
            }
        }
        return d8;
    }

    public static /* synthetic */ Double k1(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 90.0d;
            } else {
                d7 = 25.0d;
            }
            return Double.valueOf(d7);
        }
        if (dynamicScheme.isDark) {
            d6 = 80.0d;
        } else {
            d6 = 40.0d;
        }
        return Double.valueOf(d6);
    }

    static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct inViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (DynamicColor.tonePrefersLightForeground(hct.getTone()) && !DynamicColor.toneAllowsLightForeground(inViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(hct.getTone());
        }
        return DynamicColor.enableLightForeground(inViewingConditions.getTone());
    }

    public static /* synthetic */ Double q(DynamicScheme dynamicScheme) {
        double d6;
        double d7;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d7 = 60.0d;
            } else {
                d7 = 49.0d;
            }
            return Double.valueOf(d7);
        }
        if (!isFidelity(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 30.0d;
            } else {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
    }

    public static /* synthetic */ Double u0(DynamicScheme dynamicScheme) {
        double d6 = 30.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d6 = 85.0d;
            }
            return Double.valueOf(d6);
        }
        if (!dynamicScheme.isDark) {
            d6 = 90.0d;
        }
        double d7 = d6;
        if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d7);
        }
        return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d7, !dynamicScheme.isDark)), dynamicScheme));
    }

    public static /* synthetic */ Double u1(DynamicScheme dynamicScheme) {
        double d6 = 10.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        return Double.valueOf(10.0d);
    }

    public static /* synthetic */ Double x1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        Object apply;
        double d6;
        materialDynamicColors.getClass();
        if (isFidelity(dynamicScheme)) {
            apply = materialDynamicColors.secondaryContainer().tone.apply(dynamicScheme);
            return Double.valueOf(DynamicColor.contrastingTone(((Double) apply).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d6 = 90.0d;
        } else {
            d6 = 10.0d;
        }
        return Double.valueOf(d6);
    }

    public static /* synthetic */ Double y0(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 90.0d;
            } else {
                d6 = 20.0d;
            }
            return Double.valueOf(d6);
        }
        return Double.valueOf(80.0d);
    }

    public static /* synthetic */ Double z(DynamicScheme dynamicScheme) {
        double d6;
        if (isMonochrome(dynamicScheme)) {
            d6 = 25.0d;
        } else {
            d6 = 30.0d;
        }
        return Double.valueOf(d6);
    }
}
