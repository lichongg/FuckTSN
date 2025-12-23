package okio;

import java.util.Arrays;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSegment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Segment.kt\nokio/Segment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Segment {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @JvmField
    @NotNull
    public final byte[] data;

    @JvmField
    public int limit;

    @JvmField
    @Nullable
    public Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @JvmField
    @Nullable
    public Segment prev;

    @JvmField
    public boolean shared;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final void compact() {
        int i6;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        g0.m(segment);
        if (segment.owner) {
            int i7 = this.limit - this.pos;
            Segment segment2 = this.prev;
            g0.m(segment2);
            int i8 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            g0.m(segment3);
            if (segment3.shared) {
                i6 = 0;
            } else {
                Segment segment4 = this.prev;
                g0.m(segment4);
                i6 = segment4.pos;
            }
            if (i7 > i8 + i6) {
                return;
            }
            Segment segment5 = this.prev;
            g0.m(segment5);
            writeTo(segment5, i7);
            pop();
            SegmentPool.recycle(this);
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        g0.m(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        g0.m(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @NotNull
    public final Segment push(@NotNull Segment segment) {
        g0.p(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        g0.m(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @NotNull
    public final Segment split(int i6) {
        Segment take;
        if (i6 <= 0 || i6 > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i6 >= 1024) {
            take = sharedCopy();
        } else {
            take = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = take.data;
            int i7 = this.pos;
            n.E0(bArr, bArr2, 0, i7, i7 + i6, 2, null);
        }
        take.limit = take.pos + i6;
        this.pos += i6;
        Segment segment = this.prev;
        g0.m(segment);
        segment.push(take);
        return take;
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment sink, int i6) {
        g0.p(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i7 = sink.limit;
        if (i7 + i6 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i8 = sink.pos;
            if ((i7 + i6) - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            n.E0(bArr, bArr, 0, i8, i7, 2, null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i9 = sink.limit;
        int i10 = this.pos;
        n.v0(bArr2, bArr3, i9, i10, i10 + i6);
        sink.limit += i6;
        this.pos += i6;
    }

    public Segment(@NotNull byte[] data, int i6, int i7, boolean z5, boolean z6) {
        g0.p(data, "data");
        this.data = data;
        this.pos = i6;
        this.limit = i7;
        this.shared = z5;
        this.owner = z6;
    }
}
