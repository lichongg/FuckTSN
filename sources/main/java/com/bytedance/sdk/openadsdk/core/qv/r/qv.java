package com.bytedance.sdk.openadsdk.core.qv.r;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.widget.oq;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {
    private static AlertDialog j(Activity activity, final com.bytedance.sdk.openadsdk.core.qv.r.j jVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.oq(activity).j(jVar.f29975j).xt(jVar.xt).cw(jVar.cw).r(jVar.f29977r).j(jVar.up).j(new oq.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
            public void onClickNo(Dialog dialog) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.xt(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
            public void onClickYes(Dialog dialog) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.j(dialog);
                }
            }
        }).j(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.cw(dialogInterface);
                }
            }
        });
    }

    public static void j(WeakReference<Context> weakReference, boolean z5, final com.bytedance.sdk.openadsdk.core.qv.r.j jVar) {
        m.j jVar2 = new m.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.3
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.xt(new j());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.j(new j());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.cw(new j());
                }
            }
        };
        if (z5) {
            com.bytedance.sdk.openadsdk.core.rn.m.j(weakReference.get(), String.valueOf(jVar.hashCode()), jVar.f29975j, jVar.xt, jVar.cw, jVar.f29977r, jVar2);
        } else {
            com.bytedance.sdk.openadsdk.core.rn.m.j(weakReference.get(), String.valueOf(jVar.hashCode()), jVar.f29975j, jVar.xt, jVar2);
        }
    }

    public static AlertDialog j(Activity activity, boolean z5, com.bytedance.sdk.openadsdk.core.qv.r.j jVar) {
        if (z5) {
            AlertDialog j6 = j(activity, jVar);
            if (activity != null && !activity.isFinishing()) {
                j6.show();
            }
            return j6;
        }
        return j(activity, kt.tl(activity, "Theme.Dialog.TTDownload"), jVar);
    }

    private static AlertDialog j(Activity activity, int i6, final com.bytedance.sdk.openadsdk.core.qv.r.j jVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i6).setTitle(jVar.f29975j).setMessage(jVar.xt).setPositiveButton(jVar.cw, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.j(dialogInterface);
                }
            }
        }).setNegativeButton(jVar.f29977r, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.xt(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.qv.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                xt xtVar = com.bytedance.sdk.openadsdk.core.qv.r.j.this.f29976m;
                if (xtVar != null) {
                    xtVar.cw(dialogInterface);
                }
            }
        });
        Drawable drawable = jVar.up;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog create = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            create.show();
        }
        return create;
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
