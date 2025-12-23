package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Position implements Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final Position NO_POSITION = new Position(-1, -1);
    private final int column;
    private final int line;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final Position a() {
            return Position.NO_POSITION;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return this.line == position.line && this.column == position.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    @NotNull
    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }

    public Position(int i6, int i7) {
        this.line = i6;
        this.column = i7;
    }
}
