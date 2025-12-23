package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zac implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity zaa;
    final /* synthetic */ int zab;
    final /* synthetic */ ActivityResultLauncher zac;
    final /* synthetic */ GoogleApiAvailability zad;

    zac(GoogleApiAvailability googleApiAvailability, Activity activity, int i6, ActivityResultLauncher activityResultLauncher) {
        this.zad = googleApiAvailability;
        this.zaa = activity;
        this.zab = i6;
        this.zac = activityResultLauncher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i6) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.zad.getErrorResolutionPendingIntent(this.zaa, this.zab, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.zac.launch(new IntentSenderRequest.Builder(errorResolutionPendingIntent.getIntentSender()).build());
    }
}
