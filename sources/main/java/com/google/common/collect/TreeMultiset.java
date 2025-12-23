package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@NullableDecl AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).totalCount;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> avlNode) {
                return ((AvlNode) avlNode).elemCount;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@NullableDecl AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).distinctElements;
            }
        };

        abstract int nodeAggregate(AvlNode<?> avlNode);

        abstract long treeAggregate(@NullableDecl AvlNode<?> avlNode);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AvlNode<E> {
        private int distinctElements;

        @NullableDecl
        private final E elem;
        private int elemCount;
        private int height;

        @NullableDecl
        private AvlNode<E> left;

        @NullableDecl
        private AvlNode<E> pred;

        @NullableDecl
        private AvlNode<E> right;

        @NullableDecl
        private AvlNode<E> succ;
        private long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> setCount(Comparator<? super E> comparator, @NullableDecl E e6, int i6, int[] iArr) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode != null) {
                    this.left = avlNode.setCount(comparator, e6, i6, iArr);
                    if (i6 == 0 && iArr[0] != 0) {
                        this.distinctElements--;
                    } else if (i6 > 0 && iArr[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += i6 - iArr[0];
                    return rebalance();
                }
                iArr[0] = 0;
                if (i6 > 0) {
                    return addLeftChild(e6, i6);
                }
            } else {
                if (compare <= 0) {
                    iArr[0] = this.elemCount;
                    if (i6 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i6 - r3;
                    this.elemCount = i6;
                    return this;
                }
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 != null) {
                    this.right = avlNode2.setCount(comparator, e6, i6, iArr);
                    if (i6 == 0 && iArr[0] != 0) {
                        this.distinctElements--;
                    } else if (i6 > 0 && iArr[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += i6 - iArr[0];
                    return rebalance();
                }
                iArr[0] = 0;
                if (i6 > 0) {
                    return addRightChild(e6, i6);
                }
            }
            return this;
        }

        private AvlNode<E> addLeftChild(E e6, int i6) {
            AvlNode<E> avlNode = new AvlNode<>(e6, i6);
            this.left = avlNode;
            TreeMultiset.successor(this.pred, avlNode, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i6;
            return this;
        }

        private AvlNode<E> addRightChild(E e6, int i6) {
            AvlNode<E> avlNode = new AvlNode<>(e6, i6);
            this.right = avlNode;
            TreeMultiset.successor(this, avlNode, this.succ);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i6;
            return this;
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public AvlNode<E> ceiling(Comparator<? super E> comparator, E e6) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.firstNonNull(avlNode.ceiling(comparator, e6), this);
                }
            } else if (compare != 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.ceiling(comparator, e6);
            }
            return this;
        }

        private AvlNode<E> deleteMe() {
            int i6 = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(this.pred, this.succ);
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                AvlNode<E> avlNode3 = this.pred;
                avlNode3.left = avlNode.removeMax(avlNode3);
                avlNode3.right = this.right;
                avlNode3.distinctElements = this.distinctElements - 1;
                avlNode3.totalCount = this.totalCount - i6;
                return avlNode3.rebalance();
            }
            AvlNode<E> avlNode4 = this.succ;
            avlNode4.right = avlNode2.removeMin(avlNode4);
            avlNode4.left = this.left;
            avlNode4.distinctElements = this.distinctElements - 1;
            avlNode4.totalCount = this.totalCount - i6;
            return avlNode4.rebalance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public AvlNode<E> floor(Comparator<? super E> comparator, E e6) {
            int compare = comparator.compare(e6, this.elem);
            if (compare > 0) {
                AvlNode<E> avlNode = this.right;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.firstNonNull(avlNode.floor(comparator, e6), this);
                }
            } else if (compare != 0) {
                AvlNode<E> avlNode2 = this.left;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.floor(comparator, e6);
            }
            return this;
        }

        private static int height(@NullableDecl AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return ((AvlNode) avlNode).height;
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
        }

        private AvlNode<E> removeMax(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return this.left;
            }
            this.right = avlNode2.removeMax(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> removeMin(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return this.right;
            }
            this.left = avlNode2.removeMin(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private static long totalCount(@NullableDecl AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return ((AvlNode) avlNode).totalCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> add(Comparator<? super E> comparator, @NullableDecl E e6, int i6, int[] iArr) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return addLeftChild(e6, i6);
                }
                int i7 = avlNode.height;
                AvlNode<E> add = avlNode.add(comparator, e6, i6, iArr);
                this.left = add;
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += i6;
                if (add.height != i7) {
                    return rebalance();
                }
            } else {
                if (compare <= 0) {
                    int i8 = this.elemCount;
                    iArr[0] = i8;
                    long j6 = i6;
                    Preconditions.checkArgument(((long) i8) + j6 <= 2147483647L);
                    this.elemCount += i6;
                    this.totalCount += j6;
                    return this;
                }
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return addRightChild(e6, i6);
                }
                int i9 = avlNode2.height;
                AvlNode<E> add2 = avlNode2.add(comparator, e6, i6, iArr);
                this.right = add2;
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += i6;
                if (add2.height != i9) {
                    return rebalance();
                }
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int count(Comparator<? super E> comparator, E e6) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(comparator, e6);
            }
            if (compare <= 0) {
                return this.elemCount;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return 0;
            }
            return avlNode2.count(comparator, e6);
        }

        int getCount() {
            return this.elemCount;
        }

        E getElement() {
            return this.elem;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> remove(Comparator<? super E> comparator, @NullableDecl E e6, int i6, int[] iArr) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.left = avlNode.remove(comparator, e6, i6, iArr);
                int i7 = iArr[0];
                if (i7 > 0) {
                    if (i6 >= i7) {
                        this.distinctElements--;
                        this.totalCount -= i7;
                    } else {
                        this.totalCount -= i6;
                    }
                }
                return i7 == 0 ? this : rebalance();
            }
            if (compare <= 0) {
                int i8 = this.elemCount;
                iArr[0] = i8;
                if (i6 >= i8) {
                    return deleteMe();
                }
                this.elemCount = i8 - i6;
                this.totalCount -= i6;
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.right = avlNode2.remove(comparator, e6, i6, iArr);
            int i9 = iArr[0];
            if (i9 > 0) {
                if (i6 >= i9) {
                    this.distinctElements--;
                    this.totalCount -= i9;
                } else {
                    this.totalCount -= i6;
                }
            }
            return rebalance();
        }

        AvlNode(@NullableDecl E e6, int i6) {
            boolean z5;
            if (i6 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            this.elem = e6;
            this.elemCount = i6;
            this.totalCount = i6;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor != -2) {
                if (balanceFactor != 2) {
                    recomputeHeight();
                    return this;
                }
                if (this.left.balanceFactor() < 0) {
                    this.left = this.left.rotateLeft();
                }
                return rotateRight();
            }
            if (this.right.balanceFactor() > 0) {
                this.right = this.right.rotateRight();
            }
            return rotateLeft();
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> setCount(Comparator<? super E> comparator, @NullableDecl E e6, int i6, int i7, int[] iArr) {
            int compare = comparator.compare(e6, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i6 == 0 && i7 > 0) {
                        return addLeftChild(e6, i7);
                    }
                } else {
                    this.left = avlNode.setCount(comparator, e6, i6, i7, iArr);
                    int i8 = iArr[0];
                    if (i8 == i6) {
                        if (i7 == 0 && i8 != 0) {
                            this.distinctElements--;
                        } else if (i7 > 0 && i8 == 0) {
                            this.distinctElements++;
                        }
                        this.totalCount += i7 - i8;
                    }
                    return rebalance();
                }
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    if (i6 == 0 && i7 > 0) {
                        return addRightChild(e6, i7);
                    }
                } else {
                    this.right = avlNode2.setCount(comparator, e6, i6, i7, iArr);
                    int i9 = iArr[0];
                    if (i9 == i6) {
                        if (i7 == 0 && i9 != 0) {
                            this.distinctElements--;
                        } else if (i7 > 0 && i9 == 0) {
                            this.distinctElements++;
                        }
                        this.totalCount += i7 - i9;
                    }
                    return rebalance();
                }
            } else {
                int i10 = this.elemCount;
                iArr[0] = i10;
                if (i6 == i10) {
                    if (i7 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i7 - i10;
                    this.elemCount = i7;
                }
            }
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Reference<T> {

        @NullableDecl
        private T value;

        private Reference() {
        }

        void clear() {
            this.value = null;
        }

        public void checkAndSet(@NullableDecl T t5, T t6) {
            if (this.value != t5) {
                throw new ConcurrentModificationException();
            }
            this.value = t6;
        }

        @NullableDecl
        public T get() {
            return this.value;
        }
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.comparator());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        ((AvlNode) avlNode).succ = avlNode2;
        ((AvlNode) avlNode2).pred = avlNode;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        try {
            AvlNode<E> avlNode = this.rootReference.get();
            if (this.range.contains(obj) && avlNode != null) {
                return avlNode.count(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e6, int i6) {
        CollectPreconditions.checkNonnegative(i6, "count");
        if (!this.range.contains(e6)) {
            Preconditions.checkArgument(i6 == 0);
            return 0;
        }
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (i6 > 0) {
                add(e6, i6);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e6, i6, iArr));
        return iArr[0];
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        static {
            int[] iArr = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private long aggregateAboveRange(Aggregate aggregate, @NullableDecl AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateAboveRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), ((AvlNode) avlNode).elem);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, ((AvlNode) avlNode).right);
        }
        if (compare == 0) {
            int i6 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    return aggregate.treeAggregate(((AvlNode) avlNode).right);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregate.treeAggregate(((AvlNode) avlNode).right);
        } else {
            treeAggregate = aggregate.treeAggregate(((AvlNode) avlNode).right) + aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregateAboveRange(aggregate, ((AvlNode) avlNode).left);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @NullableDecl AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateBelowRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), ((AvlNode) avlNode).elem);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, ((AvlNode) avlNode).left);
        }
        if (compare == 0) {
            int i6 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    return aggregate.treeAggregate(((AvlNode) avlNode).left);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregate.treeAggregate(((AvlNode) avlNode).left);
        } else {
            treeAggregate = aggregate.treeAggregate(((AvlNode) avlNode).left) + aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregateBelowRange(aggregate, ((AvlNode) avlNode).right);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        AvlNode<E> avlNode = this.rootReference.get();
        long treeAggregate = aggregate.treeAggregate(avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, avlNode);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, avlNode) : treeAggregate;
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(@NullableDecl AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return ((AvlNode) avlNode).distinctElements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public AvlNode<E> firstNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            avlNode = this.rootReference.get().ceiling(comparator(), lowerEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, avlNode.getElement()) == 0) {
                avlNode = ((AvlNode) avlNode).succ;
            }
        } else {
            avlNode = ((AvlNode) this.header).succ;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public AvlNode<E> lastNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            avlNode = this.rootReference.get().floor(comparator(), upperEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, avlNode.getElement()) == 0) {
                avlNode = ((AvlNode) avlNode).pred;
            }
        } else {
            avlNode = ((AvlNode) this.header).pred;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.TreeMultiset.1
            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int count = avlNode.getCount();
                return count == 0 ? TreeMultiset.this.count(getElement()) : count;
            }

            @Override // com.google.common.collect.Multiset.Entry
            public E getElement() {
                return (E) avlNode.getElement();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e6, int i6) {
        CollectPreconditions.checkNonnegative(i6, "occurrences");
        if (i6 == 0) {
            return count(e6);
        }
        Preconditions.checkArgument(this.range.contains(e6));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.add(comparator(), e6, i6, iArr));
            return iArr[0];
        }
        comparator().compare(e6, e6);
        AvlNode<E> avlNode2 = new AvlNode<>(e6, i6);
        AvlNode<E> avlNode3 = this.header;
        successor(avlNode3, avlNode2, avlNode3);
        this.rootReference.checkAndSet(avlNode, avlNode2);
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> avlNode = ((AvlNode) this.header).succ;
        while (true) {
            AvlNode<E> avlNode2 = this.header;
            if (avlNode == avlNode2) {
                successor(avlNode2, avlNode2);
                this.rootReference.clear();
                return;
            }
            AvlNode<E> avlNode3 = ((AvlNode) avlNode).succ;
            ((AvlNode) avlNode).elemCount = 0;
            ((AvlNode) avlNode).left = null;
            ((AvlNode) avlNode).right = null;
            ((AvlNode) avlNode).pred = null;
            ((AvlNode) avlNode).succ = null;
            avlNode = avlNode3;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3
            AvlNode<E> current;
            Multiset.Entry<E> prevEntry = null;

            {
                this.current = TreeMultiset.this.lastNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                this.prevEntry = wrapEntry;
                if (((AvlNode) this.current).pred == TreeMultiset.this.header) {
                    this.current = null;
                    return wrapEntry;
                }
                this.current = ((AvlNode) this.current).pred;
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2
            AvlNode<E> current;

            @NullableDecl
            Multiset.Entry<E> prevEntry;

            {
                this.current = TreeMultiset.this.firstNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                this.prevEntry = wrapEntry;
                if (((AvlNode) this.current).succ == TreeMultiset.this.header) {
                    this.current = null;
                    return wrapEntry;
                }
                this.current = ((AvlNode) this.current).succ;
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@NullableDecl E e6, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e6, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i6) {
        CollectPreconditions.checkNonnegative(i6, "occurrences");
        if (i6 == 0) {
            return count(obj);
        }
        AvlNode<E> avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && avlNode != null) {
                this.rootReference.checkAndSet(avlNode, avlNode.remove(comparator(), obj, i6, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@NullableDecl E e6, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e6, boundType)), this.header);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((Serialization.FieldSetter) this, (Object) comparator);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set((Serialization.FieldSetter) this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set((Serialization.FieldSetter) this, (Object) new Reference());
        AvlNode avlNode = new AvlNode(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set((Serialization.FieldSetter) this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object obj, BoundType boundType, @NullableDecl Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        AvlNode<E> avlNode = new AvlNode<>(null, 1);
        this.header = avlNode;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e6, int i6, int i7) {
        CollectPreconditions.checkNonnegative(i7, "newCount");
        CollectPreconditions.checkNonnegative(i6, "oldCount");
        Preconditions.checkArgument(this.range.contains(e6));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e6, i6, i7, iArr));
            return iArr[0] == i6;
        }
        if (i6 != 0) {
            return false;
        }
        if (i7 > 0) {
            add(e6, i7);
        }
        return true;
    }
}
