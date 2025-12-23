package com.kwad.sdk.api.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.ComponentDestroyer;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsFragmentActivity extends FragmentActivity {
    private KsFragmentManager mFragmentManager;

    @KsAdSdkDynamicApi
    @Keep
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i6) {
        super.startActivityFromFragment(fragment, intent, i6);
    }

    @Keep
    public final KsFragmentManager getSupportFragmentManager2() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
        }
        return this.mFragmentManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof IDelegateFragment) {
            onAttachFragment(((IDelegateFragment) fragment).getBase());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i6, @Nullable Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i6, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ComponentDestroyer.destroyActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }
}
