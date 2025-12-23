package kotlin.reflect.jvm.internal.impl.types.model;

import e4.k;
import e4.l;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ArgumentList extends ArrayList<l> implements k {
    public /* bridge */ boolean contains(l lVar) {
        return super.contains((Object) lVar);
    }

    public /* bridge */ int indexOf(l lVar) {
        return super.indexOf((Object) lVar);
    }

    public /* bridge */ int lastIndexOf(l lVar) {
        return super.lastIndexOf((Object) lVar);
    }

    public /* bridge */ boolean remove(l lVar) {
        return super.remove((Object) lVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof l) {
            return contains((l) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof l) {
            return indexOf((l) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof l) {
            return lastIndexOf((l) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof l) {
            return remove((l) obj);
        }
        return false;
    }

    public ArgumentList(int i6) {
        super(i6);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
