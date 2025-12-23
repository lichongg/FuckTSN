package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PointKt {
    public static final int component1(@NotNull Point point) {
        return point.x;
    }

    public static final int component2(@NotNull Point point) {
        return point.y;
    }

    @NotNull
    public static final Point div(@NotNull Point point, float f6) {
        return new Point(Math.round(point.x / f6), Math.round(point.y / f6));
    }

    @NotNull
    public static final Point minus(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @NotNull
    public static final Point times(@NotNull Point point, float f6) {
        return new Point(Math.round(point.x * f6), Math.round(point.y * f6));
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point point) {
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@NotNull PointF pointF) {
        return pointF.x;
    }

    public static final float component2(@NotNull PointF pointF) {
        return pointF.y;
    }

    @NotNull
    public static final PointF div(@NotNull PointF pointF, float f6) {
        return new PointF(pointF.x / f6, pointF.y / f6);
    }

    @NotNull
    public static final PointF times(@NotNull PointF pointF, float f6) {
        return new PointF(pointF.x * f6, pointF.y * f6);
    }

    @NotNull
    public static final Point toPoint(@NotNull PointF pointF) {
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull Point point) {
        return new PointF(point);
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF pointF) {
        return new PointF(-pointF.x, -pointF.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final Point minus(@NotNull Point point, int i6) {
        Point point2 = new Point(point.x, point.y);
        int i7 = -i6;
        point2.offset(i7, i7);
        return point2;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, int i6) {
        Point point2 = new Point(point.x, point.y);
        point2.offset(i6, i6);
        return point2;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, float f6) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f7 = -f6;
        pointF2.offset(f7, f7);
        return pointF2;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, float f6) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f6, f6);
        return pointF2;
    }
}
