package io.netty.util.internal;

import io.netty.util.Recycler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RecyclableArrayList extends ArrayList<Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final Recycler<RecyclableArrayList> RECYCLER = new Recycler<RecyclableArrayList>() { // from class: io.netty.util.internal.RecyclableArrayList.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public RecyclableArrayList newObject(Recycler.Handle<RecyclableArrayList> handle) {
            return new RecyclableArrayList(handle);
        }
    };
    private static final long serialVersionUID = -8605125654176467947L;
    private final Recycler.Handle<RecyclableArrayList> handle;
    private boolean insertSinceRecycled;

    public static RecyclableArrayList newInstance() {
        return newInstance(8);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("element");
        }
        if (!super.add(obj)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<?> collection) {
        checkNullElements(collection);
        if (!super.addAll(collection)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    private RecyclableArrayList(Recycler.Handle<RecyclableArrayList> handle) {
        this(handle, 8);
    }

    private static void checkNullElements(Collection<?> collection) {
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
            }
            return;
        }
        List list = (List) collection;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (list.get(i6) == null) {
                throw new IllegalArgumentException("c contains null values");
            }
        }
    }

    public static RecyclableArrayList newInstance(int i6) {
        RecyclableArrayList recyclableArrayList = RECYCLER.get();
        recyclableArrayList.ensureCapacity(i6);
        return recyclableArrayList;
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i6, Object obj) {
        if (obj == null) {
            throw new NullPointerException("element");
        }
        Object obj2 = super.set(i6, obj);
        this.insertSinceRecycled = true;
        return obj2;
    }

    private RecyclableArrayList(Recycler.Handle<RecyclableArrayList> handle, int i6) {
        super(i6);
        this.handle = handle;
    }

    public boolean recycle() {
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i6, Object obj) {
        if (obj != null) {
            super.add(i6, obj);
            this.insertSinceRecycled = true;
            return;
        }
        throw new NullPointerException("element");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i6, Collection<?> collection) {
        checkNullElements(collection);
        if (!super.addAll(i6, collection)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }
}
