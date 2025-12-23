package k0;

import android.os.SystemClock;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final int f43516e = 10;

    /* renamed from: f, reason: collision with root package name */
    private static final float f43517f = 0.2f;

    /* renamed from: g, reason: collision with root package name */
    private static final long f43518g = 100;

    /* renamed from: a, reason: collision with root package name */
    private final int f43519a;

    /* renamed from: b, reason: collision with root package name */
    private final float f43520b;

    /* renamed from: c, reason: collision with root package name */
    private final Deque<b> f43521c;

    /* renamed from: d, reason: collision with root package name */
    private long f43522d;

    public c() {
        this(10, 0.2f);
    }

    public c(int windowSize, float alpha) {
        this.f43519a = windowSize;
        this.f43520b = alpha;
        this.f43521c = new LinkedBlockingDeque(windowSize);
    }

    public b a(b classificationResult) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f43522d > 100) {
            this.f43521c.clear();
        }
        this.f43522d = elapsedRealtime;
        if (this.f43521c.size() == this.f43519a) {
            this.f43521c.pollLast();
        }
        this.f43521c.addFirst(classificationResult);
        HashSet<String> hashSet = new HashSet();
        Iterator<b> it = this.f43521c.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().b());
        }
        b bVar = new b();
        for (String str : hashSet) {
            Iterator<b> it2 = this.f43521c.iterator();
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 1.0f;
            while (it2.hasNext()) {
                f6 += it2.next().c(str) * f8;
                f7 += f8;
                f8 = (float) (f8 * (1.0d - this.f43520b));
            }
            bVar.f(str, f6 / f7);
        }
        return bVar;
    }
}
