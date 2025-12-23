package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h<E> extends AbstractList<E> implements List<E>, m3.e {
    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i6, E e6);

    public abstract int getSize();

    public abstract E removeAt(int i6);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i6, E e6);

    protected h() {
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i6) {
        return removeAt(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
