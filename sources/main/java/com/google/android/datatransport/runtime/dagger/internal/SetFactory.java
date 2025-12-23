package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.EMPTY_SET);
    private final List<Provider<Collection<T>>> collectionProviders;
    private final List<Provider<T>> individualProviders;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.runtime.dagger.internal.SetFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Provider<Collection<T>>> collectionProviders;
        private final List<Provider<T>> individualProviders;

        /* synthetic */ Builder(int i6, int i7, AnonymousClass1 anonymousClass1) {
            this(i6, i7);
        }

        private Builder(int i6, int i7) {
            this.individualProviders = DaggerCollections.presizedList(i6);
            this.collectionProviders = DaggerCollections.presizedList(i7);
        }

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> provider) {
            this.collectionProviders.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> provider) {
            this.individualProviders.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.individualProviders, this.collectionProviders, null);
        }
    }

    /* synthetic */ SetFactory(List list, List list2, AnonymousClass1 anonymousClass1) {
        this(list, list2);
    }

    private SetFactory(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    public static <T> Builder<T> builder(int i6, int i7) {
        return new Builder<>(i6, i7, null);
    }

    public static <T> Factory<Set<T>> empty() {
        return (Factory<Set<T>>) EMPTY_FACTORY;
    }

    @Override // javax.inject.Provider
    public Set<T> get() {
        int size = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        int size2 = this.collectionProviders.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Collection<T> collection = this.collectionProviders.get(i6).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet newHashSetWithExpectedSize = DaggerCollections.newHashSetWithExpectedSize(size);
        int size3 = this.individualProviders.size();
        for (int i7 = 0; i7 < size3; i7++) {
            newHashSetWithExpectedSize.add(Preconditions.checkNotNull(this.individualProviders.get(i7).get()));
        }
        int size4 = arrayList.size();
        for (int i8 = 0; i8 < size4; i8++) {
            Iterator it = ((Collection) arrayList.get(i8)).iterator();
            while (it.hasNext()) {
                newHashSetWithExpectedSize.add(Preconditions.checkNotNull(it.next()));
            }
        }
        return Collections.unmodifiableSet(newHashSetWithExpectedSize);
    }
}
