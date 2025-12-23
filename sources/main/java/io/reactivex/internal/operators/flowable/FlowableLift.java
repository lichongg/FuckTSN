package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> operator;

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> apply = this.operator.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + this.operator + " returned a null Subscriber");
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public FlowableLift(Publisher<T> publisher, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(publisher);
        this.operator = flowableOperator;
    }
}
