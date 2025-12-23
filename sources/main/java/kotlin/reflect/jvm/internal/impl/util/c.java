package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c<T> implements Iterable<T>, m3.a {
    public /* synthetic */ c(kotlin.jvm.internal.v vVar) {
        this();
    }

    public abstract int a();

    public abstract void d(int i6, @NotNull T t5);

    @Nullable
    public abstract T get(int i6);

    private c() {
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
