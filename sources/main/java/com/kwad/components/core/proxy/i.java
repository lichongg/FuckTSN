package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class i extends IFragmentActivityProxy {
    public Context mContext;
    public View mRootView;
    private final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(null);
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();

    public void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    protected abstract String getPageName();

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
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    public void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i6) {
        View inflate = com.kwad.sdk.o.m.inflate(this.mContext, i6, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        com.kwad.components.core.t.m.c(intent);
        return intent;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            if (!com.kwad.sdk.l.Cf().Bn()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            long j6 = 0;
            if (intent != null) {
                j6 = intent.getLongExtra("key_start_time", 0L);
            }
            this.mPageMonitor.aC(getClass().getSimpleName());
            this.mPageMonitor.L(j6);
        } catch (Throwable th) {
            if (com.kwad.sdk.l.Cf().Bk()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                finish();
                return;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            com.kwad.components.core.t.g.destroyActivity(getActivity(), getWindow());
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
            getActivity();
            aVar.sd();
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }
}
