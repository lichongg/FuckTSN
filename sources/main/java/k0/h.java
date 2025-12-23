package k0;

import com.google.mlkit.vision.common.PointF3D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final float f43539a = 2.5f;

    private static List<PointF3D> a(List<PointF3D> lm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(k.j(k.c(lm.get(23), lm.get(24)), k.c(lm.get(11), lm.get(12))));
        arrayList.add(k.j(lm.get(11), lm.get(13)));
        arrayList.add(k.j(lm.get(12), lm.get(14)));
        arrayList.add(k.j(lm.get(13), lm.get(15)));
        arrayList.add(k.j(lm.get(14), lm.get(16)));
        arrayList.add(k.j(lm.get(23), lm.get(25)));
        arrayList.add(k.j(lm.get(24), lm.get(26)));
        arrayList.add(k.j(lm.get(25), lm.get(27)));
        arrayList.add(k.j(lm.get(26), lm.get(28)));
        arrayList.add(k.j(lm.get(11), lm.get(15)));
        arrayList.add(k.j(lm.get(12), lm.get(16)));
        arrayList.add(k.j(lm.get(23), lm.get(27)));
        arrayList.add(k.j(lm.get(24), lm.get(28)));
        arrayList.add(k.j(lm.get(23), lm.get(15)));
        arrayList.add(k.j(lm.get(24), lm.get(16)));
        arrayList.add(k.j(lm.get(11), lm.get(27)));
        arrayList.add(k.j(lm.get(12), lm.get(28)));
        arrayList.add(k.j(lm.get(23), lm.get(15)));
        arrayList.add(k.j(lm.get(24), lm.get(16)));
        arrayList.add(k.j(lm.get(13), lm.get(14)));
        arrayList.add(k.j(lm.get(25), lm.get(26)));
        arrayList.add(k.j(lm.get(15), lm.get(16)));
        arrayList.add(k.j(lm.get(27), lm.get(28)));
        return arrayList;
    }

    private static float c(List<PointF3D> landmarks) {
        PointF3D c6 = k.c(landmarks.get(23), landmarks.get(24));
        float d6 = k.d(k.j(c6, k.c(landmarks.get(11), landmarks.get(12)))) * f43539a;
        Iterator<PointF3D> it = landmarks.iterator();
        while (it.hasNext()) {
            float d7 = k.d(k.j(c6, it.next()));
            if (d7 > d6) {
                d6 = d7;
            }
        }
        return d6;
    }

    private static List<PointF3D> d(List<PointF3D> landmarks) {
        ArrayList arrayList = new ArrayList(landmarks);
        k.k(k.c(landmarks.get(23), landmarks.get(24)), arrayList);
        k.h(arrayList, 1.0f / c(arrayList));
        k.h(arrayList, 100.0f);
        return arrayList;
    }

    private h() {
    }

    public static List<PointF3D> b(List<PointF3D> landmarks) {
        return a(d(landmarks));
    }
}
