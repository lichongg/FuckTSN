package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Iterable<? extends MaybeSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i6 = 0;
            for (MaybeSource<? extends T> maybeSource : this.sources) {
                if (i6 == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i6 >> 2) + i6);
                }
                int i7 = i6 + 1;
                maybeSourceArr[i6] = maybeSource;
                i6 = i7;
            }
            if (i6 == 0) {
                EmptyDisposable.complete(maybeObserver);
                return;
            }
            if (i6 == 1) {
                maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new Function<T, R>() { // from class: io.reactivex.internal.operators.maybe.MaybeZipIterable.1
                    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
                    @Override // io.reactivex.functions.Function
                    public R apply(T t5) throws Exception {
                        return MaybeZipIterable.this.zipper.apply(new Object[]{t5});
                    }
                }));
                return;
            }
            MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i6, this.zipper);
            maybeObserver.onSubscribe(zipCoordinator);
            for (int i8 = 0; i8 < i6 && !zipCoordinator.isDisposed(); i8++) {
                maybeSourceArr[i8].subscribe(zipCoordinator.observers[i8]);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.sources = iterable;
        this.zipper = function;
    }
}
