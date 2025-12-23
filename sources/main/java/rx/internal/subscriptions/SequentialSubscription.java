package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;
import rx.subscriptions.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SequentialSubscription extends AtomicReference<m> implements m {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public SequentialSubscription(m mVar) {
        lazySet(mVar);
    }

    public m current() {
        m mVar = (m) super.get();
        if (mVar == Unsubscribed.INSTANCE) {
            return f.e();
        }
        return mVar;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    public boolean replace(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == Unsubscribed.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        return true;
    }

    public boolean replaceWeak(m mVar) {
        m mVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar2 == unsubscribed) {
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return false;
        }
        if (compareAndSet(mVar2, mVar) || get() != unsubscribed) {
            return true;
        }
        if (mVar != null) {
            mVar.unsubscribe();
        }
        return false;
    }

    @Override // rx.m
    public void unsubscribe() {
        m andSet;
        m mVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != unsubscribed) {
            andSet.unsubscribe();
        }
    }

    public boolean update(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == Unsubscribed.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        if (mVar2 != null) {
            mVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(m mVar) {
        m mVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (mVar2 == unsubscribed) {
            if (mVar != null) {
                mVar.unsubscribe();
            }
            return false;
        }
        if (compareAndSet(mVar2, mVar)) {
            return true;
        }
        m mVar3 = get();
        if (mVar != null) {
            mVar.unsubscribe();
        }
        if (mVar3 != unsubscribed) {
            return false;
        }
        return true;
    }
}
