package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup CC;
    public Activity mActivity;
    protected final Context mContext;

    protected ViewGroup dw() {
        return null;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void h(View view);

    protected boolean oX() {
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.o.m.n(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    protected float dv() {
        return -1.0f;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i6) {
        T t5 = (T) this.CC.findViewById(i6);
        return t5 != null ? t5 : (T) super.findViewById(i6);
    }

    protected g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(activity);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.CC = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.CC = dw();
            }
            setContentView(this.CC);
            setCanceledOnTouchOutside(oX());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (dv() != -1.0f) {
                attributes.dimAmount = dv();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            h(this.CC);
        } catch (Throwable th) {
            if (com.kwad.sdk.l.Cf().Bk()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                dismiss();
                return;
            }
            throw th;
        }
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i6) {
        super.setContentView(i6);
        this.CC = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, i6, null);
    }
}
