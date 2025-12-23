package cn.bluemobi.dylan.http.dialog;

import android.content.DialogInterface;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DialogOnDismissListener implements DialogInterface.OnDismissListener {
    private m subscribe;

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        m mVar = this.subscribe;
        if (mVar == null || mVar.isUnsubscribed()) {
            return;
        }
        this.subscribe.unsubscribe();
    }

    public DialogOnDismissListener(m mVar) {
        this.subscribe = mVar;
    }
}
