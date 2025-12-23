package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DialogOnKeyListener implements DialogInterface.OnKeyListener {
    private boolean canCancel;
    private LoadingDialog dialog;

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        LoadingDialog loadingDialog;
        if (i6 != 4) {
            return false;
        }
        if (!this.canCancel || (loadingDialog = this.dialog) == null || !loadingDialog.isShowing()) {
            return true;
        }
        this.dialog.dismiss();
        return true;
    }

    public DialogOnKeyListener(LoadingDialog loadingDialog, boolean z5) {
        this.dialog = loadingDialog;
        this.canCancel = z5;
    }
}
