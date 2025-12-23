package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class Traverser<N> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class GraphTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> graph;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n6 : iterable) {
                    if (this.visited.add(n6)) {
                        this.queue.add(n6);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                for (N n6 : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(n6)) {
                        this.queue.add(n6);
                    }
                }
                return remove;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack;
            private final Set<N> visited;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            private final class NodeAndSuccessors {

                @NullableDecl
                final N node;
                final Iterator<? extends N> successorIterator;

                NodeAndSuccessors(@NullableDecl N n6, Iterable<? extends N> iterable) {
                    this.node = n6;
                    this.successorIterator = iterable.iterator();
                }
            }

            DepthFirstIterator(Iterable<? extends N> iterable, Order order) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                this.visited = new HashSet();
                arrayDeque.push(new NodeAndSuccessors(null, iterable));
                this.order = order;
            }

            @Override // com.google.common.collect.AbstractIterator
            protected N computeNext() {
                N n6;
                while (!this.stack.isEmpty()) {
                    GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors first = this.stack.getFirst();
                    boolean add = this.visited.add(first.node);
                    boolean hasNext = first.successorIterator.hasNext();
                    boolean z5 = (add && this.order == Order.PREORDER) || (!hasNext && this.order == Order.POSTORDER);
                    if (hasNext) {
                        N next = first.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    } else {
                        this.stack.pop();
                    }
                    if (z5 && (n6 = first.node) != null) {
                        return n6;
                    }
                }
                return (N) endOfData();
            }

            GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n6) {
                return new NodeAndSuccessors(n6, GraphTraverser.this.graph.successors(n6));
            }
        }

        GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n6) {
            Preconditions.checkNotNull(n6);
            return breadthFirst((Iterable) ImmutableSet.of(n6));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n6) {
            Preconditions.checkNotNull(n6);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n6));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n6) {
            Preconditions.checkNotNull(n6);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n6));
        }

        private void checkThatNodeIsInGraph(N n6) {
            this.graph.successors(n6);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInGraph(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInGraph(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInGraph(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum Order {
        PREORDER,
        POSTORDER
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class TreeTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> tree;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                Iterator<? extends N> it = iterable.iterator();
                while (it.hasNext()) {
                    this.queue.add(it.next());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            private final class NodeAndChildren {
                final Iterator<? extends N> childIterator;

                @NullableDecl
                final N node;

                NodeAndChildren(@NullableDecl N n6, Iterable<? extends N> iterable) {
                    this.node = n6;
                    this.childIterator = iterable.iterator();
                }
            }

            DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            @Override // com.google.common.collect.AbstractIterator
            protected N computeNext() {
                while (!this.stack.isEmpty()) {
                    TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        N n6 = last.node;
                        if (n6 != null) {
                            return n6;
                        }
                    }
                }
                return (N) endOfData();
            }

            TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n6) {
                return new NodeAndChildren(n6, TreeTraverser.this.tree.successors(n6));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;

            DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.stack.getLast();
                N n6 = (N) Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator<? extends N> it = TreeTraverser.this.tree.successors(n6).iterator();
                if (it.hasNext()) {
                    this.stack.addLast(it);
                }
                return n6;
            }
        }

        TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super(null);
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n6) {
            Preconditions.checkNotNull(n6);
            return breadthFirst((Iterable) ImmutableSet.of(n6));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n6) {
            Preconditions.checkNotNull(n6);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n6));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n6) {
            Preconditions.checkNotNull(n6);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n6));
        }

        private void checkThatNodeIsInTree(N n6) {
            this.tree.successors(n6);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInTree(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInTree(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it = iterable.iterator();
            while (it.hasNext()) {
                checkThatNodeIsInTree(it.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }
    }

    /* synthetic */ Traverser(AnonymousClass1 anonymousClass1) {
        this();
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n6);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n6);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n6);

    private Traverser() {
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }
}
