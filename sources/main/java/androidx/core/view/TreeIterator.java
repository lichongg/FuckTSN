package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class TreeIterator<T> implements Iterator<T>, m3.a {

    @NotNull
    private final Function1<T, Iterator<T>> getChildIterator;

    @NotNull
    private Iterator<? extends T> iterator;

    @NotNull
    private final List<Iterator<T>> stack = new ArrayList();

    private final void prepareNextIterator(T t5) {
        Iterator<T> invoke = this.getChildIterator.invoke(t5);
        if (invoke != null && invoke.hasNext()) {
            this.stack.add(this.iterator);
            this.iterator = invoke;
        } else {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) kotlin.collections.f0.u3(this.stack);
                kotlin.collections.f0.Q0(this.stack);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TreeIterator(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, ? extends Iterator<? extends T>> function1) {
        this.getChildIterator = function1;
        this.iterator = it;
    }
}
