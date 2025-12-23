package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class SortedLists {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.SortedLists$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int i6) {
                return i6 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i6) {
                return i6;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i6) {
                return ~i6;
            }
        };

        abstract int resultIndex(int i6);

        /* synthetic */ KeyAbsentBehavior(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return i6;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                int size = list.size() - 1;
                while (i6 < size) {
                    int i7 = ((i6 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i7), e6) > 0) {
                        size = i7 - 1;
                    } else {
                        i6 = i7;
                    }
                }
                return i6;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                int i7 = 0;
                while (i7 < i6) {
                    int i8 = (i7 + i6) >>> 1;
                    if (comparator.compare(list.get(i8), e6) < 0) {
                        i7 = i8 + 1;
                    } else {
                        i6 = i8;
                    }
                }
                return i7;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e6, list, i6) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e6, list, i6) - 1;
            }
        };

        abstract <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6);

        /* synthetic */ KeyPresentBehavior(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e6, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(e6);
        return binarySearch(list, e6, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    private SortedLists() {
    }

    public static <E, K extends Comparable> int binarySearch(List<E> list, Function<? super E, K> function, @NullableDecl K k6, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(list, function, k6, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> function, @NullableDecl K k6, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch((List<? extends K>) Lists.transform(list, function), k6, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int binarySearch(List<? extends E> list, @NullableDecl E e6, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            int compare = comparator.compare(e6, list.get(i7));
            if (compare < 0) {
                size = i7 - 1;
            } else {
                if (compare <= 0) {
                    return i6 + keyPresentBehavior.resultIndex(comparator, e6, list.subList(i6, size + 1), i7 - i6);
                }
                i6 = i7 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i6);
    }
}
