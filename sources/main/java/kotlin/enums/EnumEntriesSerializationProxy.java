package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    @NotNull
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Class<E> f43791c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public EnumEntriesSerializationProxy(@NotNull E[] entries) {
        g0.p(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        g0.m(cls);
        this.f43791c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f43791c.getEnumConstants();
        g0.o(enumConstants, "getEnumConstants(...)");
        return c.c(enumConstants);
    }
}
