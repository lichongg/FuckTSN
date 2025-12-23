package com.acse.ottn;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q0 extends ProgressDialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f5005a;

    public q0(Context context) {
        super(context);
        this.f5005a = context;
    }

    public q0(Context context, int i6) {
        super(context, i6);
        this.f5005a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(getContext(), R.layout.customprogressdialog, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
