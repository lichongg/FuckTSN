package com.bxkj.student.v2.common.data;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f20655a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static double f20656b = 0.2d;

    @NotNull
    public final PointData a(@NotNull PointData lastPoint, @NotNull PointData newPoint) {
        g0.p(lastPoint, "lastPoint");
        g0.p(newPoint, "newPoint");
        double d6 = 1;
        newPoint.setA((f20656b * newPoint.getA()) + ((d6 - f20656b) * lastPoint.getA()));
        newPoint.setO((f20656b * newPoint.getO()) + ((d6 - f20656b) * lastPoint.getO()));
        return newPoint;
    }

    private b() {
    }
}
