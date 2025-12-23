package kotlin.enums;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.SinceKotlin;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.8")
/* loaded from: D:\Downloads\app\classes8.dex */
final class d<T extends Enum<T>> extends kotlin.collections.d<T> implements a<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f43792a;

    public d(@NotNull T[] entries) {
        g0.p(entries, "entries");
        this.f43792a = entries;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.f43792a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return false;
    }

    public boolean e(@NotNull T element) {
        g0.p(element, "element");
        return ((Enum) n.hf(this.f43792a, element.ordinal())) == element;
    }

    @Override // kotlin.collections.d, java.util.List
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public T get(int i6) {
        kotlin.collections.d.Companion.b(i6, this.f43792a.length);
        return this.f43792a[i6];
    }

    public int g(@NotNull T element) {
        g0.p(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) n.hf(this.f43792a, ordinal)) == element) {
            return ordinal;
        }
        return -1;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.f43792a.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return g((Enum) obj);
        }
        return -1;
    }

    public int j(@NotNull T element) {
        g0.p(element, "element");
        return g(element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return j((Enum) obj);
        }
        return -1;
    }
}
