package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsDialogFragment extends KsFragment implements IDialogFragmentLifecycle {
    private DelegateDialogFragment mBase;

    @KsAdSdkDynamicApi
    @Keep
    public KsDialogFragment() {
        super(null);
        ResDialogFragment resDialogFragment = new ResDialogFragment(this);
        this.mBase = resDialogFragment;
        setBase(resDialogFragment);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void show(KsFragmentManager ksFragmentManager, String str) {
        this.mBase.show(ksFragmentManager.getBase(), str);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismiss() {
        this.mBase.dismiss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismissAllowingStateLoss() {
        this.mBase.dismissAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Dialog getDialog() {
        return this.mBase.getDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean getShowsDialog() {
        return this.mBase.getShowsDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getTheme() {
        return this.mBase.getTheme();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isCancelable() {
        return this.mBase.isCancelable();
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onCancel(DialogInterface dialogInterface) {
        this.mBase.superOnCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mBase.superOnCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onDismiss(DialogInterface dialogInterface) {
        this.mBase.superOnDismiss(dialogInterface);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setCancelable(boolean z5) {
        this.mBase.setCancelable(z5);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setShowsDialog(boolean z5) {
        this.mBase.setShowsDialog(z5);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setStyle(int i6, int i7) {
        this.mBase.setStyle(i6, i7);
    }

    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i6) {
        this.mBase.setupDialog(dialog, i6);
    }

    @KsAdSdkDynamicApi
    @Keep
    public int show(KsFragmentTransaction ksFragmentTransaction, String str) {
        return this.mBase.show(ksFragmentTransaction.getBase(), str);
    }

    @Keep
    KsDialogFragment(DelegateDialogFragment delegateDialogFragment) {
        super(delegateDialogFragment);
        this.mBase = delegateDialogFragment;
    }
}
