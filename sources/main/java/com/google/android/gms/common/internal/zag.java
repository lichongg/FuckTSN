package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    protected abstract void zaa();

    public static zag zab(Activity activity, @Nullable Intent intent, int i6) {
        return new zad(intent, activity, i6);
    }

    public static zag zac(@NonNull Fragment fragment, @Nullable Intent intent, int i6) {
        return new zae(intent, fragment, i6);
    }

    public static zag zad(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i6) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i6) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException unused) {
                Build.FINGERPRINT.contains("generic");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
