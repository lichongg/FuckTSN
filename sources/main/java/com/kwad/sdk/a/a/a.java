package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends g {

    @SuppressLint({"StaticFieldLeak"})
    private static a asR;

    @Nullable
    private final DialogInterface.OnDismissListener asS;
    private final AdTemplate mAdTemplate;

    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    public static boolean CP() {
        a aVar = asR;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        asR.dismiss();
        return true;
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = asR;
            if (aVar != null && aVar.isShowing()) {
                asR.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                asR = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean oW() {
        a aVar = asR;
        return aVar != null && aVar.isShowing();
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        final AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        String F = d.F(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
        if (F.equals("")) {
            F = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.b.a.av(el));
        }
        textView.setText(F);
        textView3.setText(d.Da());
        textView2.setText(d.Db());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                as.a(com.kwad.sdk.core.download.a.H(el), new as.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.as.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.as.a
                    public final void pR() {
                        com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bk(a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    private a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.asS = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.asS;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            asR = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate CV;
        if (activity == null || activity.isFinishing() || (CV = c.CU().CV()) == null) {
            return false;
        }
        return a(activity, CV, onDismissListener, onClickListener);
    }
}
