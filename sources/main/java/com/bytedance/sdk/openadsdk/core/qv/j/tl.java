package com.bytedance.sdk.openadsdk.core.qv.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.widget.oq;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private static AlertDialog createAlertDialog(Activity activity, int i6, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i6).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        if (dialogBuilder.icon != null) {
            onCancelListener.setIcon(dialogBuilder.icon);
        }
        AlertDialog create = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            create.show();
        }
        return create;
    }

    private static AlertDialog getBackInstallDialog(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.bytedance.sdk.openadsdk.core.widget.oq(activity).j(dialogBuilder.title).xt(dialogBuilder.message).cw(dialogBuilder.positiveBtnText).r(dialogBuilder.negativeBtnText).j(dialogBuilder.icon).j(new oq.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
            public void onClickNo(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
            public void onClickYes(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }
        }).j(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void showDialogByDelegate(WeakReference<Context> weakReference, boolean z5, final DialogBuilder dialogBuilder) {
        m.j jVar = new m.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.tl.3
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new j());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new j());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new j());
                }
            }
        };
        if (z5) {
            com.bytedance.sdk.openadsdk.core.rn.m.j(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, jVar);
        } else {
            com.bytedance.sdk.openadsdk.core.rn.m.j(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, jVar);
        }
    }

    public static AlertDialog showDialogBySelf(Activity activity, boolean z5, DialogBuilder dialogBuilder) {
        if (!z5) {
            return createAlertDialog(activity, kt.tl(activity, "Theme.Dialog.TTDownload"), dialogBuilder);
        }
        AlertDialog backInstallDialog = getBackInstallDialog(activity, dialogBuilder);
        if (activity != null && !activity.isFinishing()) {
            backInstallDialog.show();
        }
        return backInstallDialog;
    }

    private static class j implements DialogInterface {
        private j() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }
}
