package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class SortedLists {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class KeyAbsentBehavior {
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX;
        public static final KeyAbsentBehavior NEXT_HIGHER;
        public static final KeyAbsentBehavior NEXT_LOWER;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum a extends KeyAbsentBehavior {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int i6) {
                return i6 - 1;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum c extends KeyAbsentBehavior {
            c(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i6) {
                return ~i6;
            }
        }

        private KeyAbsentBehavior(String str, int i6) {
        }

        abstract int resultIndex(int i6);

        static {
            a aVar = new a("NEXT_LOWER", 0);
            NEXT_LOWER = aVar;
            b bVar = new b("NEXT_HIGHER", 1);
            NEXT_HIGHER = bVar;
            c cVar = new c("INVERTED_INSERTION_INDEX", 2);
            INVERTED_INSERTION_INDEX = cVar;
            $VALUES = new KeyAbsentBehavior[]{aVar, bVar, cVar};
        }

        /* synthetic */ KeyAbsentBehavior(String str, int i6, a aVar) {
            this(str, i6);
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum b extends KeyAbsentBehavior {
            b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i6) {
                return i6;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class KeyPresentBehavior {
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES;
        public static final KeyPresentBehavior ANY_PRESENT;
        public static final KeyPresentBehavior FIRST_AFTER;
        public static final KeyPresentBehavior FIRST_PRESENT;
        public static final KeyPresentBehavior LAST_BEFORE;
        public static final KeyPresentBehavior LAST_PRESENT;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum c extends KeyPresentBehavior {
            c(String str, int i6) {
                super(str, i6, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
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
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum d extends KeyPresentBehavior {
            d(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e6, list, i6) + 1;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum e extends KeyPresentBehavior {
            e(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e6, list, i6) - 1;
            }
        }

        private KeyPresentBehavior(String str, int i6) {
        }

        abstract <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum b extends KeyPresentBehavior {
            b(String str, int i6) {
                super(str, i6, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
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
        }

        static {
            a aVar = new a("ANY_PRESENT", 0);
            ANY_PRESENT = aVar;
            b bVar = new b("LAST_PRESENT", 1);
            LAST_PRESENT = bVar;
            c cVar = new c("FIRST_PRESENT", 2);
            FIRST_PRESENT = cVar;
            d dVar = new d("FIRST_AFTER", 3);
            FIRST_AFTER = dVar;
            e eVar = new e("LAST_BEFORE", 4);
            LAST_BEFORE = eVar;
            $VALUES = new KeyPresentBehavior[]{aVar, bVar, cVar, dVar, eVar};
        }

        /* synthetic */ KeyPresentBehavior(String str, int i6, a aVar) {
            this(str, i6);
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        enum a extends KeyPresentBehavior {
            a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, E e6, List<? extends E> list, int i6) {
                return i6;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    public static <E> int a(List<? extends E> list, E e6, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(keyPresentBehavior);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = w.g(list);
        }
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            int compare = comparator.compare(e6, list.get(i7));
            if (compare < 0) {
                size = i7 - 1;
            } else if (compare > 0) {
                i6 = i7 + 1;
            } else {
                return i6 + keyPresentBehavior.resultIndex(comparator, e6, list.subList(i6, size + 1), i7 - i6);
            }
        }
        return keyAbsentBehavior.resultIndex(i6);
    }
}
