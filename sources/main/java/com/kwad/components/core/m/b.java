package com.kwad.components.core.m;

import androidx.annotation.CallSuper;
import com.kwad.components.core.m.a;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b<T extends a> extends f {
    public T mCallerContext;
    protected Presenter mPresenter;

    protected abstract T onCreateCallerContext();

    protected abstract Presenter onCreatePresenter();

    private void notifyOnCreate() {
        T t5 = this.mCallerContext;
        if (t5 == null) {
            return;
        }
        Iterator<com.kwad.components.core.m.a.a> it = t5.Rt.iterator();
        while (it.hasNext()) {
            it.next().gY();
        }
    }

    private void notifyOnDestroy() {
        T t5 = this.mCallerContext;
        if (t5 == null) {
            return;
        }
        Iterator<com.kwad.components.core.m.a.a> it = t5.Rt.iterator();
        while (it.hasNext()) {
            it.next().gZ();
        }
    }

    private void notifyOnPause() {
        T t5 = this.mCallerContext;
        if (t5 == null) {
            return;
        }
        Iterator<com.kwad.components.core.m.a.a> it = t5.Rt.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    private void notifyOnResume() {
        T t5 = this.mCallerContext;
        if (t5 == null) {
            return;
        }
        Iterator<com.kwad.components.core.m.a.a> it = t5.Rt.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.K(this.mRootView);
        }
        this.mPresenter.n(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.f
    @CallSuper
    public void onActivityCreate() {
        try {
            super.onActivityCreate();
            initMVP();
            notifyOnCreate();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        try {
            super.onDestroy();
            notifyOnDestroy();
            T t5 = this.mCallerContext;
            if (t5 != null) {
                t5.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        try {
            super.onPause();
            notifyOnPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            notifyOnResume();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
