package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e extends r<Character> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e1 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        e1 v5 = module.p().v();
        g0.o(v5, "getCharType(...)");
        return v5;
    }

    public e(char c6) {
        super(Character.valueOf(c6));
    }

    private final String b(char c6) {
        switch (c6) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            case 11:
            default:
                if (c(c6)) {
                    return String.valueOf(c6);
                }
                return "?";
            case '\f':
                return "\\f";
            case '\r':
                return "\\r";
        }
    }

    private final boolean c(char c6) {
        byte type = (byte) Character.getType(c6);
        if (type != 0 && type != 13 && type != 14 && type != 15 && type != 16 && type != 18 && type != 19) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(a().charValue()), b(a().charValue())}, 2));
        g0.o(format, "format(...)");
        return format;
    }
}
