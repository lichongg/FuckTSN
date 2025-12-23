package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> source;

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<T> source() {
        return this.source;
    }

    AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }
}
