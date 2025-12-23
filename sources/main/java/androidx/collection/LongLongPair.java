package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongLongPair {
    private final long first;
    private final long second;

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        return longLongPair.first == this.first && longLongPair.second == this.second;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        return e.a(this.first) ^ e.a(this.second);
    }

    @NotNull
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }

    public LongLongPair(long j6, long j7) {
        this.first = j6;
        this.second = j7;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }
}
