package com.kwad.sdk.api.core.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
interface IDialogFragmentLifecycle extends IFragmentLifecycle {
    void onCancel(DialogInterface dialogInterface);

    Dialog onCreateDialog(Bundle bundle);

    void onDismiss(DialogInterface dialogInterface);
}
