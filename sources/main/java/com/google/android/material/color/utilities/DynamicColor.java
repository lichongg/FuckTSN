package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final Function<DynamicScheme, Double> chroma;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final Function<DynamicScheme, Double> hue;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaConstraint> toneDeltaConstraint;
    public final Function<DynamicScheme, Double> toneMaxContrast;
    public final Function<DynamicScheme, Double> toneMinContrast;

    public static DynamicColor fromArgb(int i6) {
        final Hct fromInt = Hct.fromInt(i6);
        final TonalPalette fromInt2 = TonalPalette.fromInt(i6);
        return fromPalette(new Function() { // from class: com.google.android.material.color.utilities.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.f(TonalPalette.this, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(Hct.this.getTone());
                return valueOf;
            }
        });
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return fromPalette(function, function2, null, null);
    }

    public double getTone(final DynamicScheme dynamicScheme) {
        Object apply;
        Object apply2;
        final DynamicColor dynamicColor;
        final double d6;
        Object apply3;
        Object apply4;
        Object apply5;
        Object apply6;
        Object apply7;
        Object apply8;
        Object apply9;
        Object apply10;
        Object apply11;
        apply = this.tone.apply(dynamicScheme);
        final double doubleValue = ((Double) apply).doubleValue();
        double d7 = dynamicScheme.contrastLevel;
        boolean z5 = false;
        boolean z6 = d7 < 0.0d;
        if (d7 != 0.0d) {
            apply10 = this.tone.apply(dynamicScheme);
            double doubleValue2 = ((Double) apply10).doubleValue();
            apply11 = (z6 ? this.toneMinContrast : this.toneMaxContrast).apply(dynamicScheme);
            doubleValue = doubleValue2 + ((((Double) apply11).doubleValue() - doubleValue2) * Math.abs(dynamicScheme.contrastLevel));
        }
        Function<DynamicScheme, DynamicColor> function = this.background;
        if (function == null) {
            dynamicColor = null;
        } else {
            apply2 = function.apply(dynamicScheme);
            dynamicColor = (DynamicColor) apply2;
        }
        if (dynamicColor != null) {
            Function<DynamicScheme, DynamicColor> function2 = dynamicColor.background;
            if (function2 != null) {
                apply9 = function2.apply(dynamicScheme);
                if (apply9 != null) {
                    z5 = true;
                }
            }
            apply3 = this.tone.apply(dynamicScheme);
            double doubleValue3 = ((Double) apply3).doubleValue();
            apply4 = dynamicColor.tone.apply(dynamicScheme);
            double ratioOfTones = Contrast.ratioOfTones(doubleValue3, ((Double) apply4).doubleValue());
            if (z6) {
                apply7 = this.toneMinContrast.apply(dynamicScheme);
                double doubleValue4 = ((Double) apply7).doubleValue();
                apply8 = dynamicColor.toneMinContrast.apply(dynamicScheme);
                r10 = z5 ? Contrast.ratioOfTones(doubleValue4, ((Double) apply8).doubleValue()) : 1.0d;
                d6 = ratioOfTones;
            } else {
                apply5 = this.toneMaxContrast.apply(dynamicScheme);
                double doubleValue5 = ((Double) apply5).doubleValue();
                apply6 = dynamicColor.toneMaxContrast.apply(dynamicScheme);
                double ratioOfTones2 = Contrast.ratioOfTones(doubleValue5, ((Double) apply6).doubleValue());
                r10 = z5 ? Math.min(ratioOfTones2, ratioOfTones) : 1.0d;
                if (z5) {
                    d6 = Math.max(ratioOfTones2, ratioOfTones);
                }
            }
            return calculateDynamicTone(dynamicScheme, this.tone, new Function() { // from class: com.google.android.material.color.utilities.n
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Double valueOf;
                    valueOf = Double.valueOf(((DynamicColor) obj).getTone(DynamicScheme.this));
                    return valueOf;
                }
            }, new BiFunction() { // from class: com.google.android.material.color.utilities.o
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Double valueOf;
                    valueOf = Double.valueOf(doubleValue);
                    return valueOf;
                }
            }, new Function() { // from class: com.google.android.material.color.utilities.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DynamicColor.c(DynamicColor.this, (DynamicScheme) obj);
                }
            }, this.toneDeltaConstraint, new Function() { // from class: com.google.android.material.color.utilities.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Double valueOf;
                    valueOf = Double.valueOf(r1);
                    return valueOf;
                }
            }, new Function() { // from class: com.google.android.material.color.utilities.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Double valueOf;
                    valueOf = Double.valueOf(d6);
                    return valueOf;
                }
            });
        }
        d6 = 21.0d;
        return calculateDynamicTone(dynamicScheme, this.tone, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(((DynamicColor) obj).getTone(DynamicScheme.this));
                return valueOf;
            }
        }, new BiFunction() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Double valueOf;
                valueOf = Double.valueOf(doubleValue);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.c(DynamicColor.this, (DynamicScheme) obj);
            }
        }, this.toneDeltaConstraint, new Function() { // from class: com.google.android.material.color.utilities.q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(r1);
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(d6);
                return valueOf;
            }
        });
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.color.utilities.DynamicColor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$TonePolarity;

        static {
            int[] iArr = new int[TonePolarity.values().length];
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity = iArr;
            try {
                iArr[TonePolarity.DARKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.LIGHTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.NO_PREFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r0 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double calculateDynamicTone(com.google.android.material.color.utilities.DynamicScheme r20, java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r21, java.util.function.Function<com.google.android.material.color.utilities.DynamicColor, java.lang.Double> r22, java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> r23, java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r24, java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.ToneDeltaConstraint> r25, java.util.function.Function<java.lang.Double, java.lang.Double> r26, java.util.function.Function<java.lang.Double, java.lang.Double> r27) {
        /*
            r4 = r20
            r0 = r24
            r1 = r26
            r2 = r21
            r3 = r27
            java.lang.Object r2 = com.bytedance.msdk.core.ae.a.a(r2, r4)
            java.lang.Double r2 = (java.lang.Double) r2
            double r5 = r2.doubleValue()
            if (r0 != 0) goto L18
            r0 = 0
            goto L1e
        L18:
            java.lang.Object r0 = com.bytedance.msdk.core.ae.a.a(r0, r4)
            com.google.android.material.color.utilities.DynamicColor r0 = (com.google.android.material.color.utilities.DynamicColor) r0
        L1e:
            if (r0 != 0) goto L21
            return r5
        L21:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r2 = r0.tone
            java.lang.Object r2 = com.bytedance.msdk.core.ae.a.a(r2, r4)
            java.lang.Double r2 = (java.lang.Double) r2
            double r7 = r2.doubleValue()
            double r7 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r5, r7)
            r2 = r22
            java.lang.Object r9 = com.bytedance.msdk.core.ae.a.a(r2, r0)
            java.lang.Double r9 = (java.lang.Double) r9
            double r10 = r9.doubleValue()
            java.lang.Double r12 = java.lang.Double.valueOf(r7)
            r13 = r23
            java.lang.Object r9 = com.google.android.material.color.utilities.a.a(r13, r12, r9)
            java.lang.Double r9 = (java.lang.Double) r9
            double r12 = r9.doubleValue()
            double r18 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r10, r12)
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r1 != 0) goto L56
            goto L6f
        L56:
            java.lang.Double r9 = java.lang.Double.valueOf(r7)
            java.lang.Object r9 = com.bytedance.msdk.core.ae.a.a(r1, r9)
            if (r9 != 0) goto L61
            goto L6f
        L61:
            java.lang.Double r9 = java.lang.Double.valueOf(r7)
            java.lang.Object r1 = com.bytedance.msdk.core.ae.a.a(r1, r9)
            java.lang.Double r1 = (java.lang.Double) r1
            double r14 = r1.doubleValue()
        L6f:
            r16 = 4626604192193052672(0x4035000000000000, double:21.0)
            if (r3 != 0) goto L74
            goto L8d
        L74:
            java.lang.Double r1 = java.lang.Double.valueOf(r7)
            java.lang.Object r1 = com.bytedance.msdk.core.ae.a.a(r3, r1)
            if (r1 != 0) goto L7f
            goto L8d
        L7f:
            java.lang.Double r1 = java.lang.Double.valueOf(r7)
            java.lang.Object r1 = com.bytedance.msdk.core.ae.a.a(r3, r1)
            java.lang.Double r1 = (java.lang.Double) r1
            double r16 = r1.doubleValue()
        L8d:
            double r7 = com.google.android.material.color.utilities.MathUtils.clampDouble(r14, r16, r18)
            int r1 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r1 != 0) goto L96
            goto L9a
        L96:
            double r12 = contrastingTone(r10, r7)
        L9a:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r0 = r0.background
            if (r0 == 0) goto Lac
            java.lang.Object r0 = com.bytedance.msdk.core.ae.a.a(r0, r4)
            if (r0 != 0) goto La5
            goto Lac
        La5:
            r0 = r5
            r6 = r2
            r2 = r0
            r5 = r25
            r0 = r12
            goto Lb1
        Lac:
            double r12 = enableLightForeground(r12)
            goto La5
        Lb1:
            double r0 = ensureToneDelta(r0, r2, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.calculateDynamicTone(com.google.android.material.color.utilities.DynamicScheme, java.util.function.Function, java.util.function.Function, java.util.function.BiFunction, java.util.function.Function, java.util.function.Function, java.util.function.Function, java.util.function.Function):double");
    }

    static double ensureToneDelta(double d6, double d7, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function, Function<DynamicColor, Double> function2) {
        Object apply;
        ToneDeltaConstraint toneDeltaConstraint;
        Object apply2;
        Object apply3;
        if (function == null) {
            toneDeltaConstraint = null;
        } else {
            apply = function.apply(dynamicScheme);
            toneDeltaConstraint = (ToneDeltaConstraint) apply;
        }
        if (toneDeltaConstraint != null) {
            double d8 = toneDeltaConstraint.delta;
            apply2 = function2.apply(toneDeltaConstraint.keepAway);
            double doubleValue = ((Double) apply2).doubleValue();
            double abs = Math.abs(d6 - doubleValue);
            if (abs < d8) {
                int i6 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$TonePolarity[toneDeltaConstraint.keepAwayPolarity.ordinal()];
                if (i6 == 1) {
                    return MathUtils.clampDouble(0.0d, 100.0d, doubleValue + d8);
                }
                if (i6 == 2) {
                    return MathUtils.clampDouble(0.0d, 100.0d, doubleValue - d8);
                }
                if (i6 == 3) {
                    apply3 = toneDeltaConstraint.keepAway.tone.apply(dynamicScheme);
                    boolean z5 = d7 > ((Double) apply3).doubleValue();
                    double abs2 = Math.abs(abs - d8);
                    return (!z5 ? d6 < abs2 : d6 + abs2 <= 100.0d) ? d6 - abs2 : d6 + abs2;
                }
            }
        }
        return d6;
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, DynamicColor> function3) {
        return fromPalette(function, function2, function3, null);
    }

    public static /* synthetic */ Double h(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        Object apply;
        apply = dynamicColor.toneMaxContrast.apply(dynamicScheme);
        return (Double) apply;
    }

    public static /* synthetic */ Double k(Function function, DynamicScheme dynamicScheme, Double d6, Double d7) {
        Object apply;
        Object apply2;
        Object apply3;
        Object apply4;
        if (function != null) {
            apply = function.apply(dynamicScheme);
            if (apply != null) {
                apply2 = function.apply(dynamicScheme);
                if (((DynamicColor) apply2).background != null) {
                    apply3 = function.apply(dynamicScheme);
                    apply4 = ((DynamicColor) apply3).background.apply(dynamicScheme);
                    if (apply4 != null) {
                        return Double.valueOf(contrastingTone(d7.doubleValue(), 7.0d));
                    }
                }
            }
        }
        return Double.valueOf(contrastingTone(d7.doubleValue(), Math.max(7.0d, d6.doubleValue())));
    }

    public static /* synthetic */ Double m(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        Object apply;
        apply = dynamicColor.toneMinContrast.apply(dynamicScheme);
        return (Double) apply;
    }

    public static double toneMaxContrastDefault(Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new Function() { // from class: com.google.android.material.color.utilities.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.h(DynamicScheme.this, (DynamicColor) obj);
            }
        }, new BiFunction() { // from class: com.google.android.material.color.utilities.h
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.k(function2, dynamicScheme, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, null);
    }

    public static double toneMinContrastDefault(final Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new Function() { // from class: com.google.android.material.color.utilities.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.m(DynamicScheme.this, (DynamicColor) obj);
            }
        }, new BiFunction() { // from class: com.google.android.material.color.utilities.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.i(function, dynamicScheme, function2, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.r((Double) obj);
            }
        });
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Object apply;
        Object apply2;
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        apply = this.hue.apply(dynamicScheme);
        double doubleValue = ((Double) apply).doubleValue();
        apply2 = this.chroma.apply(dynamicScheme);
        Hct from = Hct.from(doubleValue, ((Double) apply2).doubleValue(), getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, from);
        return from;
    }

    public DynamicColor(Function<DynamicScheme, Double> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, Double> function3, Function<DynamicScheme, Double> function4, Function<DynamicScheme, DynamicColor> function5, Function<DynamicScheme, Double> function6, Function<DynamicScheme, Double> function7, Function<DynamicScheme, ToneDeltaConstraint> function8) {
        this.hue = function;
        this.chroma = function2;
        this.tone = function3;
        this.opacity = function4;
        this.background = function5;
        this.toneMinContrast = function6;
        this.toneMaxContrast = function7;
        this.toneDeltaConstraint = function8;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double contrastingTone(double r11, double r13) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r11, r13)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r11, r13)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r11)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r11)
            boolean r11 = tonePrefersLightForeground(r11)
            if (r11 == 0) goto L3b
            double r11 = r4 - r6
            double r11 = java.lang.Math.abs(r11)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 >= 0) goto L2f
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L2f
            r11 = 1
            goto L30
        L2f:
            r11 = 0
        L30:
            int r12 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r12 >= 0) goto L44
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 >= 0) goto L44
            if (r11 == 0) goto L45
            goto L44
        L3b:
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L45
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 < 0) goto L44
            goto L45
        L44:
            return r0
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.contrastingTone(double, double):double");
    }

    public static double enableLightForeground(double d6) {
        if (tonePrefersLightForeground(d6) && !toneAllowsLightForeground(d6)) {
            return 49.0d;
        }
        return d6;
    }

    public static DynamicColor fromPalette(final Function<DynamicScheme, TonalPalette> function, final Function<DynamicScheme, Double> function2, final Function<DynamicScheme, DynamicColor> function3, final Function<DynamicScheme, ToneDeltaConstraint> function4) {
        return new DynamicColor(new Function() { // from class: com.google.android.material.color.utilities.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.o(function, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.j(function, (DynamicScheme) obj);
            }
        }, function2, null, function3, new Function() { // from class: com.google.android.material.color.utilities.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(DynamicColor.toneMinContrastDefault(function2, function3, (DynamicScheme) obj, function4));
                return valueOf;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(DynamicColor.toneMaxContrastDefault(function2, function3, (DynamicScheme) obj, function4));
                return valueOf;
            }
        }, function4);
    }

    public static /* synthetic */ Double i(Function function, DynamicScheme dynamicScheme, Function function2, Double d6, Double d7) {
        Object apply;
        Object apply2;
        Object apply3;
        Object apply4;
        Object apply5;
        apply = function.apply(dynamicScheme);
        double doubleValue = ((Double) apply).doubleValue();
        if (d6.doubleValue() >= 7.0d) {
            doubleValue = contrastingTone(d7.doubleValue(), 4.5d);
        } else if (d6.doubleValue() >= 3.0d) {
            doubleValue = contrastingTone(d7.doubleValue(), 3.0d);
        } else if (function2 != null) {
            apply2 = function2.apply(dynamicScheme);
            if (apply2 != null) {
                apply3 = function2.apply(dynamicScheme);
                if (((DynamicColor) apply3).background != null) {
                    apply4 = function2.apply(dynamicScheme);
                    apply5 = ((DynamicColor) apply4).background.apply(dynamicScheme);
                    if (apply5 != null) {
                        doubleValue = contrastingTone(d7.doubleValue(), d6.doubleValue());
                    }
                }
            }
        }
        return Double.valueOf(doubleValue);
    }

    public static /* synthetic */ Double j(Function function, DynamicScheme dynamicScheme) {
        Object apply;
        apply = function.apply(dynamicScheme);
        return Double.valueOf(((TonalPalette) apply).getChroma());
    }

    public static /* synthetic */ Double o(Function function, DynamicScheme dynamicScheme) {
        Object apply;
        apply = function.apply(dynamicScheme);
        return Double.valueOf(((TonalPalette) apply).getHue());
    }

    public static boolean toneAllowsLightForeground(double d6) {
        if (Math.round(d6) <= 49) {
            return true;
        }
        return false;
    }

    public static boolean tonePrefersLightForeground(double d6) {
        if (Math.round(d6) < 60) {
            return true;
        }
        return false;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        Object apply;
        int i6 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function != null) {
            apply = function.apply(dynamicScheme);
            return (MathUtils.clampInt(0, 255, (int) Math.round(((Double) apply).doubleValue() * 255.0d)) << 24) | (i6 & 16777215);
        }
        return i6;
    }

    public static DynamicColor fromArgb(final int i6, Function<DynamicScheme, Double> function) {
        return fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette fromInt;
                fromInt = TonalPalette.fromInt(i6);
                return fromInt;
            }
        }, function);
    }

    public static DynamicColor fromArgb(final int i6, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2) {
        return fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette fromInt;
                fromInt = TonalPalette.fromInt(i6);
                return fromInt;
            }
        }, function, function2);
    }

    public static DynamicColor fromArgb(final int i6, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return fromPalette(new Function() { // from class: com.google.android.material.color.utilities.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TonalPalette fromInt;
                fromInt = TonalPalette.fromInt(i6);
                return fromInt;
            }
        }, function, function2, function3);
    }

    public static /* synthetic */ Double r(Double d6) {
        return d6;
    }

    public static /* synthetic */ DynamicColor c(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return dynamicColor;
    }

    public static /* synthetic */ TonalPalette f(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }
}
