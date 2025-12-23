package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.reflect.MutableTypeToInstanceMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        /* synthetic */ UnmodifiableEntry(Map.Entry entry, AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> set) {
            return new ForwardingSet<Map.Entry<K, V>>() { // from class: com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.1
                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
                public Object[] toArray() {
                    return standardToArray();
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
                public <T> T[] toArray(T[] tArr) {
                    return (T[]) standardToArray(tArr);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
                public Set<Map.Entry<K, V>> delegate() {
                    return set;
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.transformEntries(super.iterator());
                }
            };
        }

        private UnmodifiableEntry(Map.Entry<K, V> entry) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(entry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> it) {
            return Iterators.transform(it, new Function<Map.Entry<K, V>, Map.Entry<K, V>>() { // from class: com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.2
                @Override // com.google.common.base.Function
                public Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
                    return new UnmodifiableEntry(entry, null);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v5) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) trustedGet(TypeToken.of((Class) cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((TypeToken<? extends TypeToken<? extends B>>) obj, (TypeToken<? extends B>) obj2);
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T putInstance(Class<T> cls, @NullableDecl T t5) {
        return (T) trustedPut(TypeToken.of((Class) cls), t5);
    }

    @NullableDecl
    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.backingMap.get(typeToken);
    }

    @NullableDecl
    private <T extends B> T trustedPut(TypeToken<T> typeToken, @NullableDecl T t5) {
        return this.backingMap.put(typeToken, t5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        return (T) trustedGet(typeToken.rejectTypeVariables());
    }

    @CanIgnoreReturnValue
    @Deprecated
    public B put(TypeToken<? extends B> typeToken, B b6) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T putInstance(TypeToken<T> typeToken, @NullableDecl T t5) {
        return (T) trustedPut(typeToken.rejectTypeVariables(), t5);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }
}
