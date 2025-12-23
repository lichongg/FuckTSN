package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface b<E> {
    @Nonnull
    @CheckReturnValue
    <T> c<T> A();

    @Nonnull
    @CheckReturnValue
    <T> c<T> I(@Nonnull E e6);

    @Nonnull
    @CheckReturnValue
    Observable<E> o();
}
