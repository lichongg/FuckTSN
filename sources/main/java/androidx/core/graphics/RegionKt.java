package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class RegionKt {
    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final boolean contains(@NotNull Region region, @NotNull Point point) {
        return region.contains(point.x, point.y);
    }

    public static final void forEach(@NotNull Region region, @NotNull Function1<? super Rect, n1> function1) {
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                function1.invoke(rect);
            }
        }
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region region) {
        return new RegionKt$iterator$1(region);
    }

    @NotNull
    public static final Region not(@NotNull Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
