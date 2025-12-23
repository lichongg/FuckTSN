package com.kwad.components.core.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Rv;
    public Presenter mPresenter;
    protected ViewGroup nY;

    public c(Context context) {
        this(context, null);
    }

    protected boolean ai() {
        return false;
    }

    protected abstract void ak();

    protected abstract T al();

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initData();

    @NonNull
    public abstract Presenter onCreatePresenter();

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, 0);
        if (ai()) {
            return;
        }
        qs();
    }

    private void initMVP() {
        this.Rv = al();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.K(this.nY);
        }
        this.mPresenter.n(this.Rv);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ab() {
        super.ab();
        T t5 = this.Rv;
        if (t5 != null) {
            t5.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    protected final void qs() {
        initData();
        this.nY = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        ak();
    }
}
