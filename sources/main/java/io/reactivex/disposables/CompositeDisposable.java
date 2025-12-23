package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            try {
                if (this.disposed) {
                    return;
                }
                this.disposed = true;
                OpenHashSet<Disposable> openHashSet = this.resources;
                this.resources = null;
                dispose(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CompositeDisposable(Disposable... disposableArr) {
        ObjectHelper.requireNonNull(disposableArr, "resources is null");
        this.resources = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>();
                            this.resources = openHashSet;
                        }
                        openHashSet.add(disposable);
                        return true;
                    }
                } finally {
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(Disposable... disposableArr) {
        ObjectHelper.requireNonNull(disposableArr, "ds is null");
        if (!this.disposed) {
            synchronized (this) {
                try {
                    if (!this.disposed) {
                        OpenHashSet<Disposable> openHashSet = this.resources;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet<>(disposableArr.length + 1);
                            this.resources = openHashSet;
                        }
                        for (Disposable disposable : disposableArr) {
                            ObjectHelper.requireNonNull(disposable, "d is null");
                            openHashSet.add(disposable);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        for (Disposable disposable2 : disposableArr) {
            disposable2.dispose();
        }
        return false;
    }

    public void clear() {
        if (this.disposed) {
            return;
        }
        synchronized (this) {
            try {
                if (this.disposed) {
                    return;
                }
                OpenHashSet<Disposable> openHashSet = this.resources;
                this.resources = null;
                dispose(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "Disposable item is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.disposed) {
                    return false;
                }
                OpenHashSet<Disposable> openHashSet = this.resources;
                if (openHashSet != null && openHashSet.remove(disposable)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    public int size() {
        if (this.disposed) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.disposed) {
                    return 0;
                }
                OpenHashSet<Disposable> openHashSet = this.resources;
                return openHashSet != null ? openHashSet.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable disposable) {
        if (delete(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    public CompositeDisposable(Iterable<? extends Disposable> iterable) {
        ObjectHelper.requireNonNull(iterable, "resources is null");
        this.resources = new OpenHashSet<>();
        for (Disposable disposable : iterable) {
            ObjectHelper.requireNonNull(disposable, "Disposable item is null");
            this.resources.add(disposable);
        }
    }

    void dispose(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.keys()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
