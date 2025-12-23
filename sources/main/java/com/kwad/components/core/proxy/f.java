package com.kwad.components.core.proxy;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class f extends IActivityProxy implements com.kwad.components.core.proxy.a.c {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    public View mRootView;
    private final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(this);
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();

    public void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    protected boolean checkIntentData(@Nullable Intent intent) {
        return true;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract String getPageName();

    protected abstract void initData();

    protected abstract void initView();

    protected boolean needAdaptionScreen() {
        return false;
    }

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !com.kwad.sdk.l.Cf().Bk()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar, int i6) {
        this.mBackPressDelete.addBackPressable(bVar, i6);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i6) {
        T t5 = (T) this.mRootView.findViewById(i6);
        return t5 != null ? t5 : (T) super.findViewById(i6);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPreCreate(@Nullable Bundle bundle) {
        try {
            this.mPageMonitor.a(PageCreateStage.START_ON_PRE_CREATE);
            super.onPreCreate(bundle);
            try {
                if (!com.kwad.sdk.l.Cf().Bk() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                    com.kwad.components.core.t.d.a(getActivity(), 0, true, false);
                }
            } catch (Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
            disableFragmentRestore(bundle);
            this.mPageMonitor.a(PageCreateStage.END_ON_PRE_CREATE);
        } catch (Throwable th2) {
            this.mPageMonitor.a(PageCreateStage.ERROR_START_ACTIVITY);
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception", th2));
        }
    }

    public void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void setContentView(int i6) {
        try {
            View inflate = com.kwad.sdk.o.m.inflate(this.mContext, i6, null);
            this.mRootView = inflate;
            super.setContentView(inflate);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public Intent getIntent() {
        Intent intent = super.getIntent();
        com.kwad.components.core.t.m.c(intent);
        return intent;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        try {
        } catch (Throwable th) {
            onCreateCaughtException(th);
            this.mPageMonitor.a(PageCreateStage.ERROR_CAUGHT_EXCEPTION);
            if (com.kwad.sdk.l.Cf().Bk()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                finish();
            } else {
                throw th;
            }
        }
        if (!com.kwad.sdk.l.Cf().Bn()) {
            this.mPageMonitor.a(PageCreateStage.ERROR_SDK_NOT_INIT);
            finish();
            return;
        }
        this.mPageMonitor.a(PageCreateStage.START_ON_CREATE);
        super.onCreate(bundle);
        getActivity().setTheme(R.style.Theme.Light.NoTitleBar.Fullscreen);
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(getActivity());
        Intent intent = getIntent();
        this.mPageMonitor.a(PageCreateStage.START_CHECK_INTENT);
        if (!checkIntentData(intent)) {
            this.mPageMonitor.a(PageCreateStage.ERROR_CHECK_INTENT);
            finish();
            return;
        }
        getWindow().setFlags(16777216, 16777216);
        long j6 = 0;
        if (intent != null) {
            j6 = intent.getLongExtra("key_start_time", 0L);
        }
        this.mPageMonitor.aC(getPageName());
        this.mPageMonitor.L(j6);
        int layoutId = getLayoutId();
        this.mPageMonitor.a(PageCreateStage.START_SET_CONTENT_VIEW);
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        this.mPageMonitor.a(PageCreateStage.START_INIT_DATA);
        initData();
        this.mPageMonitor.a(PageCreateStage.START_INIT_VIEW);
        initView();
        this.mPageMonitor.a(PageCreateStage.END_INIT_VIEW);
        l.rV().a(this, bundle);
        onActivityCreate();
        this.mPageMonitor.a(PageCreateStage.END_ON_CREATE);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            l.rV().g(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            l.rV().f(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
            getActivity();
            aVar.sd();
            l.rV().e(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    @CallSuper
    protected void onActivityCreate() {
    }

    protected void onCreateCaughtException(Throwable th) {
    }

    public void onCreateStageChange(PageCreateStage pageCreateStage) {
    }
}
