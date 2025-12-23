package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentActivity;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseProxyFragmentActivity extends KsFragmentActivity {
    private IFragmentActivityProxy mDelegate;

    @NonNull
    protected abstract IFragmentActivityProxy getDelegate(Context context);

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void z2() {
        this.mDelegate.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        this.mDelegate.onPreCreate(bundle);
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mDelegate.onPreDestroy();
        super.onDestroy();
        this.mDelegate.onDestroy();
        Wrapper.onDestroy(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        return this.mDelegate.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i6, KeyEvent keyEvent) {
        return this.mDelegate.onKeyLongPress(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        return this.mDelegate.onKeyUp(i6, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.mDelegate.onPrePause();
        super.onPause();
        this.mDelegate.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.mDelegate.onPreResume();
        super.onResume();
        this.mDelegate.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mDelegate.onPreSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
        this.mDelegate.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        this.mDelegate.onPreStart();
        super.onStart();
        this.mDelegate.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.mDelegate.onPreStop();
        super.onStop();
        this.mDelegate.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.putExtra("key_start_time", SystemClock.uptimeMillis());
        }
        super.startActivity(intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.mDelegate = getDelegate(context);
        super.attachBaseContext(Wrapper.wrapContextIfNeed(context));
        this.mDelegate.setProxyFragmentActivity(this);
        this.mDelegate.setActivity(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        return Wrapper.wrapContextIfNeed(super.createConfigurationContext(configuration));
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            Intent intent = super.getIntent();
            intent.setExtrasClassLoader(externalClassLoader);
            return intent;
        }
        return super.getIntent();
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return Wrapper.wrapInflaterIfNeed(super.getLayoutInflater());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            return externalResource;
        }
        return resources;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        this.mDelegate.onActivityResult(i6, i7, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i6, boolean z5) {
        super.onApplyThemeResource(theme, i6, z5);
        this.mDelegate.onApplyThemeResource(theme, i6, z5);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragmentActivity
    public void onAttachFragment(KsFragment ksFragment) {
        super.onAttachFragment(ksFragment);
        this.mDelegate.onAttachFragment(ksFragment);
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
        this.mDelegate.onChildTitleChanged(activity, charSequence);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mDelegate.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        this.mDelegate.onPostCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mDelegate.onPostResume();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.mDelegate.onRestart();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDelegate.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i6) {
        super.onTitleChanged(charSequence, i6);
        this.mDelegate.onTitleChanged(charSequence, i6);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.mDelegate.onUserLeaveHint();
    }

    public void superOnBackPressed() {
        super.z2();
    }

    public boolean superOnKeyDown(int i6, KeyEvent keyEvent) {
        return super.onKeyDown(i6, keyEvent);
    }

    public boolean superOnKeyLongPress(int i6, KeyEvent keyEvent) {
        return super.onKeyLongPress(i6, keyEvent);
    }

    public boolean superOnKeyUp(int i6, KeyEvent keyEvent) {
        return super.onKeyUp(i6, keyEvent);
    }
}
