package com.kwad.components.core.proxy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class j extends DialogFragment {
    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            Boolean bool = Boolean.FALSE;
            z.a(this, "mDismissed", bool);
            z.a(this, "mShownByMe", Boolean.TRUE);
            z.a(this, "mViewDestroyed", bool);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    protected abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public Context getContext() {
        return com.kwad.sdk.o.m.wrapContextIfNeed(super.getContext());
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        com.kwad.sdk.n.checkInitSDK(context);
        super.onAttach(com.kwad.sdk.o.m.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater eq = com.kwad.sdk.o.m.eq(com.kwad.sdk.o.m.wrapContextIfNeed(layoutInflater.getContext()));
        getDialog().requestWindowFeature(1);
        return a(eq, viewGroup);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return com.kwad.sdk.o.m.eq(com.kwad.sdk.o.m.wrapContextIfNeed(super.onGetLayoutInflater(bundle).getContext()));
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable unused) {
                z.callMethod(this, "showAllowingStateLoss", fragmentManager, str);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            a(fragmentManager.beginTransaction(), str);
        }
    }
}
