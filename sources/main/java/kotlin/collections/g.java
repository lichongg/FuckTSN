package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g<E> extends AbstractCollection<E> implements Collection<E>, m3.b {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e6);

    protected g() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
