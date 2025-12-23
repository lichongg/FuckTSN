package k0;

import android.util.Pair;
import com.google.mlkit.vision.common.PointF3D;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseLandmark;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    private static final String f43523e = "PoseClassifier";

    /* renamed from: f, reason: collision with root package name */
    private static final int f43524f = 30;

    /* renamed from: g, reason: collision with root package name */
    private static final int f43525g = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final PointF3D f43526h = PointF3D.from(1.0f, 1.0f, 0.2f);

    /* renamed from: a, reason: collision with root package name */
    private final List<i> f43527a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43528b;

    /* renamed from: c, reason: collision with root package name */
    private final int f43529c;

    /* renamed from: d, reason: collision with root package name */
    private final PointF3D f43530d;

    public f(List<i> poseSamples) {
        this(poseSamples, 30, 10, f43526h);
    }

    public f(List<i> poseSamples, int maxDistanceTopK, int meanDistanceTopK, PointF3D axesWeights) {
        this.f43527a = poseSamples;
        this.f43528b = maxDistanceTopK;
        this.f43529c = meanDistanceTopK;
        this.f43530d = axesWeights;
    }

    public static /* synthetic */ int a(Pair pair, Pair pair2) {
        return -Float.compare(((Float) pair.second).floatValue(), ((Float) pair2.second).floatValue());
    }

    public static /* synthetic */ int b(Pair pair, Pair pair2) {
        return -Float.compare(((Float) pair.second).floatValue(), ((Float) pair2.second).floatValue());
    }

    private static List<PointF3D> f(Pose pose) {
        ArrayList arrayList = new ArrayList();
        Iterator<PoseLandmark> it = pose.getAllPoseLandmarks().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPosition3D());
        }
        return arrayList;
    }

    public b d(List<PointF3D> landmarks) {
        b bVar = new b();
        if (!landmarks.isEmpty()) {
            ArrayList arrayList = new ArrayList(landmarks);
            k.i(arrayList, PointF3D.from(-1.0f, 1.0f, 1.0f));
            List<PointF3D> b6 = h.b(landmarks);
            List<PointF3D> b7 = h.b(arrayList);
            PriorityQueue priorityQueue = new PriorityQueue(this.f43528b, new Comparator() { // from class: k0.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return f.b((Pair) obj, (Pair) obj2);
                }
            });
            Iterator<i> it = this.f43527a.iterator();
            while (true) {
                float f6 = 0.0f;
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                List<PointF3D> b8 = next.b();
                float f7 = 0.0f;
                for (int i6 = 0; i6 < b6.size(); i6++) {
                    f6 = Math.max(f6, k.e(k.g(k.j(b6.get(i6), b8.get(i6)), this.f43530d)));
                    f7 = Math.max(f7, k.e(k.g(k.j(b7.get(i6), b8.get(i6)), this.f43530d)));
                }
                priorityQueue.add(new Pair(next, Float.valueOf(Math.min(f6, f7))));
                if (priorityQueue.size() > this.f43528b) {
                    priorityQueue.poll();
                }
            }
            PriorityQueue priorityQueue2 = new PriorityQueue(this.f43529c, new Comparator() { // from class: k0.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return f.a((Pair) obj, (Pair) obj2);
                }
            });
            Iterator it2 = priorityQueue.iterator();
            while (it2.hasNext()) {
                i iVar = (i) ((Pair) it2.next()).first;
                List<PointF3D> b9 = iVar.b();
                float f8 = 0.0f;
                float f9 = 0.0f;
                for (int i7 = 0; i7 < b6.size(); i7++) {
                    f8 += k.l(k.g(k.j(b6.get(i7), b9.get(i7)), this.f43530d));
                    f9 += k.l(k.g(k.j(b7.get(i7), b9.get(i7)), this.f43530d));
                }
                priorityQueue2.add(new Pair(iVar, Float.valueOf(Math.min(f8, f9) / (b6.size() * 2))));
                if (priorityQueue2.size() > this.f43529c) {
                    priorityQueue2.poll();
                }
            }
            Iterator it3 = priorityQueue2.iterator();
            while (it3.hasNext()) {
                bVar.e(((i) ((Pair) it3.next()).first).a());
            }
        }
        return bVar;
    }

    public int e() {
        return Math.min(this.f43528b, this.f43529c);
    }

    public b c(Pose pose) {
        return d(f(pose));
    }
}
