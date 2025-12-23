package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SetBuilder<T> {
    private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
    private final List<T> contributions;

    public static <T> SetBuilder<T> newSetBuilder(int i6) {
        return new SetBuilder<>(i6);
    }

    public SetBuilder<T> add(T t5) {
        this.contributions.add(Preconditions.checkNotNull(t5, SET_CONTRIBUTIONS_CANNOT_BE_NULL));
        return this;
    }

    public Set<T> build() {
        int size = this.contributions.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableSet(new HashSet(this.contributions)) : Collections.singleton(this.contributions.get(0)) : Collections.EMPTY_SET;
    }

    private SetBuilder(int i6) {
        this.contributions = new ArrayList(i6);
    }

    public SetBuilder<T> addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next(), SET_CONTRIBUTIONS_CANNOT_BE_NULL);
        }
        this.contributions.addAll(collection);
        return this;
    }
}
