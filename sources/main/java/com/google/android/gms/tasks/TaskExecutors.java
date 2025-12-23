package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class TaskExecutors {

    @NonNull
    public static final Executor MAIN_THREAD = new zzu();
    static final Executor zza = new zzt();

    private TaskExecutors() {
    }
}
