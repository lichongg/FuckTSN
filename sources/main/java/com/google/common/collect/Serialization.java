package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class Serialization {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.Serialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FieldSetter<T> {
        private final Field field;

        /* synthetic */ FieldSetter(Field field, AnonymousClass1 anonymousClass1) {
            this(field);
        }

        void set(T t5, Object obj) {
            try {
                this.field.set(t5, obj);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        private FieldSetter(Field field) {
            this.field = field;
            field.setAccessible(true);
        }

        void set(T t5, int i6) {
            try {
                this.field.set(t5, Integer.valueOf(i6));
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    static <K, V> void populateMap(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateMap(map, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void populateMultimap(Multimap<K, V> multimap, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateMultimap(multimap, objectInputStream, objectInputStream.readInt());
    }

    static <E> void populateMultiset(Multiset<E> multiset, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateMultiset(multiset, objectInputStream, objectInputStream.readInt());
    }

    private Serialization() {
    }

    static <T> FieldSetter<T> getFieldSetter(Class<T> cls, String str) {
        try {
            return new FieldSetter<>(cls.getDeclaredField(str), null);
        } catch (NoSuchFieldException e6) {
            throw new AssertionError(e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void populateMap(Map<K, V> map, ObjectInputStream objectInputStream, int i6) throws IOException, ClassNotFoundException {
        for (int i7 = 0; i7 < i6; i7++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void populateMultimap(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i6) throws IOException, ClassNotFoundException {
        for (int i7 = 0; i7 < i6; i7++) {
            Collection collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i8 = 0; i8 < readInt; i8++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> void populateMultiset(Multiset<E> multiset, ObjectInputStream objectInputStream, int i6) throws IOException, ClassNotFoundException {
        for (int i7 = 0; i7 < i6; i7++) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static int readCount(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    static <K, V> void writeMap(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static <K, V> void writeMultimap(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    static <E> void writeMultiset(Multiset<E> multiset, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry<E> entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }
}
