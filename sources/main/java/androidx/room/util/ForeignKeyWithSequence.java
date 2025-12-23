package androidx.room.util;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

    @NotNull
    private final String from;
    private final int id;
    private final int sequence;

    @NotNull
    private final String to;

    public ForeignKeyWithSequence(int i6, int i7, @NotNull String from, @NotNull String to) {
        g0.p(from, "from");
        g0.p(to, "to");
        this.id = i6;
        this.sequence = i7;
        this.from = from;
        this.to = to;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull ForeignKeyWithSequence other) {
        g0.p(other, "other");
        int i6 = this.id - other.id;
        return i6 == 0 ? this.sequence - other.sequence : i6;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSequence() {
        return this.sequence;
    }

    @NotNull
    public final String getTo() {
        return this.to;
    }
}
