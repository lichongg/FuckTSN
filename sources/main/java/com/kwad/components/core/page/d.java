package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.y;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends i {
    private boolean Tv;

    private void qZ() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.ksad_request_install_title);
        builder.setMessage(R.string.ksad_request_install_content);
        builder.setNegativeButton(R.string.ksad_request_install_nagative, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.ksad_request_install_positive, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                d.this.ra();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        if (Build.VERSION.SDK_INT < 26) {
            finish();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
        intent.addFlags(67108864);
        getActivity().startActivityForResult(intent, 100);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.c.a(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i6, int i7, Intent intent) {
        if (i6 == 100 && i7 == -1) {
            aI(this.Tv);
        }
        finish();
    }

    private void aI(boolean z5) {
        Intent intent = getIntent();
        if (z5) {
            getActivity().startActivity((Intent) intent.getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT));
        } else {
            String stringExtra = intent.getStringExtra("filePath");
            if (!TextUtils.isEmpty(stringExtra)) {
                as.he(stringExtra);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
            this.Tv = booleanExtra;
            if (Build.VERSION.SDK_INT < 26) {
                aI(booleanExtra);
                finish();
            } else {
                if (booleanExtra) {
                    if (y.cM(getActivity())) {
                        aI(this.Tv);
                        return;
                    } else {
                        ra();
                        return;
                    }
                }
                if (intent.getBooleanExtra("needAllowDialog", false)) {
                    qZ();
                } else {
                    ra();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
