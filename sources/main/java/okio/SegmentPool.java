package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;

    @NotNull
    private static final AtomicReference<Segment>[] hashBuckets;

    @NotNull
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;

    @NotNull
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i6 = 0; i6 < highestOneBit; i6++) {
            atomicReferenceArr[i6] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment segment) {
        AtomicReference<Segment> firstRef;
        Segment segment2;
        Segment andSet;
        g0.p(segment, "segment");
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared || (andSet = (firstRef = INSTANCE.firstRef()).getAndSet((segment2 = LOCK))) == segment2) {
            return;
        }
        int i6 = andSet != null ? andSet.limit : 0;
        if (i6 >= MAX_SIZE) {
            firstRef.set(andSet);
            return;
        }
        segment.next = andSet;
        segment.pos = 0;
        segment.limit = i6 + 8192;
        firstRef.set(segment);
    }

    @JvmStatic
    @NotNull
    public static final Segment take() {
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment andSet = firstRef.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            firstRef.set(null);
            return new Segment();
        }
        firstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
    }

    public final int getByteCount() {
        Segment segment = firstRef().get();
        if (segment == null) {
            return 0;
        }
        return segment.limit;
    }
}
