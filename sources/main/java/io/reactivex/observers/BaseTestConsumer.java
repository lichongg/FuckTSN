package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected final List<T> values = new ArrayList();
    protected final List<Throwable> errors = new ArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public abstract U assertNotSubscribed();

    public abstract U assertSubscribed();

    public final U assertValue(T t5) {
        if (this.values.size() != 1) {
            throw fail("Expected: " + valueAndClass(t5) + ", Actual: " + this.values);
        }
        T t6 = this.values.get(0);
        if (ObjectHelper.equals(t5, t6)) {
            return this;
        }
        throw fail("Expected: " + valueAndClass(t5) + ", Actual: " + valueAndClass(t6));
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final U assertComplete() {
        long j6 = this.completions;
        if (j6 == 0) {
            throw fail("Not completed");
        }
        if (j6 <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j6);
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        if (size != 1) {
            throw fail("Multiple errors");
        }
        String message = this.errors.get(0).getMessage();
        if (ObjectHelper.equals(str, message)) {
            return this;
        }
        throw fail("Error message differs; Expected: " + str + ", Actual: " + message);
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertNotComplete() {
        long j6 = this.completions;
        if (j6 == 1) {
            throw fail("Completed!");
        }
        if (j6 <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j6);
    }

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final U assertTerminated() {
        if (this.done.getCount() != 0) {
            throw fail("Subscriber still running!");
        }
        long j6 = this.completions;
        if (j6 > 1) {
            throw fail("Terminated with multiple completions: " + j6);
        }
        int size = this.errors.size();
        if (size > 1) {
            throw fail("Terminated with multiple errors: " + size);
        }
        if (j6 == 0 || size == 0) {
            return this;
        }
        throw fail("Terminated with multiple completions and errors: " + j6);
    }

    public final U assertValueAt(int i6, Predicate<T> predicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        }
        if (i6 >= this.values.size()) {
            throw fail("Invalid index: " + i6);
        }
        try {
            if (predicate.test(this.values.get(i6))) {
                return this;
            }
            throw fail("Value not present");
        } catch (Exception e6) {
            throw ExceptionHelper.wrapOrThrow(e6);
        }
    }

    public final U assertValueCount(int i6) {
        int size = this.values.size();
        if (size == i6) {
            return this;
        }
        throw fail("Value counts differ; Expected: " + i6 + ", Actual: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i6 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext || !hasNext2) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!ObjectHelper.equals(next2, next)) {
                throw fail("Values at position " + i6 + " differ; Expected: " + valueAndClass(next2) + ", Actual: " + valueAndClass(next));
            }
            i6++;
        }
        if (hasNext) {
            throw fail("More values received than expected (" + i6 + ")");
        }
        if (!hasNext2) {
            return this;
        }
        throw fail("Fever values received than expected (" + i6 + ")");
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size != tArr.length) {
            throw fail("Value count differs; Expected: " + tArr.length + " " + Arrays.toString(tArr) + ", Actual: " + size + " " + this.values);
        }
        for (int i6 = 0; i6 < size; i6++) {
            T t5 = this.values.get(i6);
            T t6 = tArr[i6];
            if (!ObjectHelper.equals(t6, t5)) {
                throw fail("Values at position " + i6 + " differ; Expected: " + valueAndClass(t6) + ", Actual: " + valueAndClass(t5));
            }
        }
        return this;
    }

    public final U awaitDone(long j6, TimeUnit timeUnit) {
        try {
            if (this.done.await(j6, timeUnit)) {
                return this;
            }
            dispose();
            return this;
        } catch (InterruptedException e6) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e6);
        }
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    protected final AssertionError fail(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.completions);
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
                return assertionError;
            }
            assertionError.initCause(new CompositeException(this.errors));
        }
        return assertionError;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j6 = 0; j6 < this.completions; j6++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            Iterator<Throwable> it = this.errors.iterator();
            while (it.hasNext()) {
                try {
                    if (predicate.test(it.next())) {
                        if (size == 1) {
                            return this;
                        }
                        throw fail("Error present but other errors as well");
                    }
                } catch (Exception e6) {
                    throw ExceptionHelper.wrapOrThrow(e6);
                }
            }
            throw fail("Error not present");
        }
        throw fail("No errors");
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t5 : this.values) {
            if (!collection.contains(t5)) {
                throw fail("Value not in the expected collection: " + valueAndClass(t5));
            }
        }
        return this;
    }

    public final boolean await(long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.done.getCount() == 0 || this.done.await(j6, timeUnit);
    }

    public final boolean awaitTerminalEvent(long j6, TimeUnit timeUnit) {
        try {
            return await(j6, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }
}
