package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class IActivityProxy implements IComponentProxy {
    private Activity mActivity;

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(int i6) {
        this.mActivity.setContentView(i6);
    }

    @KsAdSdkDynamicApi
    @Keep
    public <T extends View> T findViewById(int i6) {
        return (T) this.mActivity.findViewById(i6);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void finish() {
        this.mActivity.finish();
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public Activity getActivity() {
        return this.mActivity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public Intent getIntent() {
        return this.mActivity.getIntent();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Window getWindow() {
        return this.mActivity.getWindow();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onBackPressed() {
        Activity activity = this.mActivity;
        try {
            if (activity instanceof BaseProxyActivity) {
                ((BaseProxyActivity) activity).superOnBackPressed();
            } else {
                if (activity instanceof BaseProxyFragmentActivity) {
                    ((BaseProxyFragmentActivity) activity).superOnBackPressed();
                    return;
                }
                throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
            }
        } catch (Exception unused) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyDown(i6, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyDown(i6, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyLongPress(int i6, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyLongPress(i6, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyLongPress(i6, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyUp(i6, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyUp(i6, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public void overridePendingTransition(int i6, int i7) {
        this.mActivity.overridePendingTransition(i6, i7);
    }

    void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view) {
        this.mActivity.setContentView(view);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActivity.setContentView(view, layoutParams);
    }

    @KsAdSdkDynamicApi
    @Keep
    protected void onDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPause() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPrePause() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onUserLeaveHint() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onConfigurationChanged(Configuration configuration) {
    }

    @KsAdSdkDynamicApi
    @Keep
    protected void onCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onNewIntent(Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    protected void onPostCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    protected void onPreCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreSaveInstanceState(@NonNull Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onTitleChanged(CharSequence charSequence, int i6) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onActivityResult(int i6, int i7, Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onApplyThemeResource(Resources.Theme theme, int i6, boolean z5) {
    }
}
