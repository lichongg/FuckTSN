package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long zza;

    @KeepForSdk
    public native void nativeOnComplete(long j6, @Nullable Object obj, boolean z5, boolean z6, @Nullable String str);

    @KeepForSdk
    public static void createAndAddCallback(@NonNull Task<Object> task, long j6) {
        task.addOnCompleteListener(new NativeOnCompleteListener(j6));
    }

    @KeepForSdk
    public NativeOnCompleteListener(long j6) {
        this.zza = j6;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void onComplete(@NonNull Task<Object> task) {
        Object obj;
        String str;
        Exception exception;
        if (task.isSuccessful()) {
            obj = task.getResult();
            str = null;
        } else if (!task.isCanceled() && (exception = task.getException()) != null) {
            str = exception.getMessage();
            obj = null;
        } else {
            obj = null;
            str = null;
        }
        nativeOnComplete(this.zza, obj, task.isSuccessful(), task.isCanceled(), str);
    }
}
