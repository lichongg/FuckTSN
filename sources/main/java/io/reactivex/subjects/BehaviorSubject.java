package io.reactivex.subjects;

import androidx.camera.view.p;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    boolean done;
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    final AtomicReference<Object> value;
    final Lock writeLock;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];
    static final BehaviorDisposable[] TERMINATED = new BehaviorDisposable[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        final Observer<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorSubject<T> state;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.next) {
                        return;
                    }
                    BehaviorSubject<T> behaviorSubject = this.state;
                    Lock lock = behaviorSubject.readLock;
                    lock.lock();
                    this.index = behaviorSubject.index;
                    Object obj = behaviorSubject.value.get();
                    lock.unlock();
                    this.emitting = obj != null;
                    this.next = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    emitLoop();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void emitLoop() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            while (!this.cancelled) {
                synchronized (this) {
                    try {
                        appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }

        void emitNext(Object obj, long j6) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    try {
                        if (this.cancelled) {
                            return;
                        }
                        if (this.index == j6) {
                            return;
                        }
                        if (this.emitting) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.queue = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.add(obj);
                            return;
                        }
                        this.next = true;
                        this.fastPath = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.cancelled || NotificationLite.accept(obj, this.actual);
        }

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.actual = observer;
            this.state = behaviorSubject;
        }
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>();
    }

    public static <T> BehaviorSubject<T> createDefault(T t5) {
        return new BehaviorSubject<>(t5);
    }

    boolean add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.subscribers.get();
            if (behaviorDisposableArr == TERMINATED) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!p.a(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        Object obj = this.value.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T getValue() {
        Object obj = this.value.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.value.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.value.get());
    }

    public boolean hasValue() {
        Object obj = this.value.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Object complete = NotificationLite.complete();
        for (BehaviorDisposable<T> behaviorDisposable : terminate(complete)) {
            behaviorDisposable.emitNext(complete, this.index);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        Object error = NotificationLite.error(th);
        for (BehaviorDisposable<T> behaviorDisposable : terminate(error)) {
            behaviorDisposable.emitNext(error, this.index);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.done) {
            return;
        }
        Object next = NotificationLite.next(t5);
        setCurrent(next);
        for (BehaviorDisposable<T> behaviorDisposable : this.subscribers.get()) {
            behaviorDisposable.emitNext(next, this.index);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done) {
            disposable.dispose();
        }
    }

    void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.subscribers.get();
            if (behaviorDisposableArr == TERMINATED || behaviorDisposableArr == EMPTY) {
                return;
            }
            int length = behaviorDisposableArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (behaviorDisposableArr[i6] == behaviorDisposable) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = EMPTY;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i6);
                System.arraycopy(behaviorDisposableArr, i6 + 1, behaviorDisposableArr3, i6, (length - i6) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!p.a(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    void setCurrent(Object obj) {
        this.writeLock.lock();
        try {
            this.index++;
            this.value.lazySet(obj);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (add(behaviorDisposable)) {
            if (behaviorDisposable.cancelled) {
                remove(behaviorDisposable);
                return;
            } else {
                behaviorDisposable.emitFirst();
                return;
            }
        }
        Object obj = this.value.get();
        if (NotificationLite.isComplete(obj)) {
            observer.onComplete();
        } else {
            observer.onError(NotificationLite.getError(obj));
        }
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    BehaviorDisposable<T>[] terminate(Object obj) {
        BehaviorDisposable<T>[] behaviorDisposableArr = this.subscribers.get();
        BehaviorDisposable<T>[] behaviorDisposableArr2 = TERMINATED;
        if (behaviorDisposableArr != behaviorDisposableArr2 && (behaviorDisposableArr = this.subscribers.getAndSet(behaviorDisposableArr2)) != behaviorDisposableArr2) {
            setCurrent(obj);
        }
        return behaviorDisposableArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] tArr) {
        Object obj = this.value.get();
        if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
            Object value = NotificationLite.getValue(obj);
            if (tArr.length != 0) {
                tArr[0] = value;
                if (tArr.length != 1) {
                    tArr[1] = 0;
                }
                return tArr;
            }
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        if (tArr.length != 0) {
            tArr[0] = 0;
        }
        return tArr;
    }

    BehaviorSubject(T t5) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(t5, "defaultValue is null"));
    }
}
