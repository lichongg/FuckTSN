package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j<E> extends AbstractSet<E> implements Set<E>, m3.h {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e6);

    public abstract int getSize();

    protected j() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
