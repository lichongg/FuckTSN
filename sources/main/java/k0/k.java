package k0;

import com.google.mlkit.vision.common.PointF3D;
import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k {
    private k() {
    }

    public static PointF3D a(PointF3D a6, PointF3D b6) {
        return PointF3D.from(a6.getX() + b6.getX(), a6.getY() + b6.getY(), a6.getZ() + b6.getZ());
    }

    public static void b(List<PointF3D> pointsList, PointF3D p5) {
        ListIterator<PointF3D> listIterator = pointsList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(a(listIterator.next(), p5));
        }
    }

    public static PointF3D c(PointF3D a6, PointF3D b6) {
        return PointF3D.from((a6.getX() + b6.getX()) * 0.5f, (a6.getY() + b6.getY()) * 0.5f, (a6.getZ() + b6.getZ()) * 0.5f);
    }

    public static float d(PointF3D point) {
        return (float) Math.hypot(point.getX(), point.getY());
    }

    public static float e(PointF3D point) {
        return Math.max(Math.abs(point.getX()), Math.max(Math.abs(point.getY()), Math.abs(point.getZ())));
    }

    public static PointF3D f(PointF3D a6, float multiple) {
        return PointF3D.from(a6.getX() * multiple, a6.getY() * multiple, a6.getZ() * multiple);
    }

    public static PointF3D g(PointF3D a6, PointF3D multiple) {
        return PointF3D.from(a6.getX() * multiple.getX(), a6.getY() * multiple.getY(), a6.getZ() * multiple.getZ());
    }

    public static void h(List<PointF3D> pointsList, float multiple) {
        ListIterator<PointF3D> listIterator = pointsList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(f(listIterator.next(), multiple));
        }
    }

    public static void i(List<PointF3D> pointsList, PointF3D multiple) {
        ListIterator<PointF3D> listIterator = pointsList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(g(listIterator.next(), multiple));
        }
    }

    public static PointF3D j(PointF3D b6, PointF3D a6) {
        return PointF3D.from(a6.getX() - b6.getX(), a6.getY() - b6.getY(), a6.getZ() - b6.getZ());
    }

    public static void k(PointF3D p5, List<PointF3D> pointsList) {
        ListIterator<PointF3D> listIterator = pointsList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(j(p5, listIterator.next()));
        }
    }

    public static float l(PointF3D point) {
        return Math.abs(point.getX()) + Math.abs(point.getY()) + Math.abs(point.getZ());
    }
}
