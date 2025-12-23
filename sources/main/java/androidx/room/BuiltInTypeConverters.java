package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({})
@kotlin.annotation.Target(allowedTargets = {})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: D:\Downloads\app\classes.dex */
public @interface BuiltInTypeConverters {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class State {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ENABLED = new State("ENABLED", 0);
        public static final State DISABLED = new State("DISABLED", 1);
        public static final State INHERITED = new State("INHERITED", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ENABLED, DISABLED, INHERITED};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String str, int i6) {
        }
    }

    State byteBuffer() default State.INHERITED;

    State enums() default State.INHERITED;

    State uuid() default State.INHERITED;
}
