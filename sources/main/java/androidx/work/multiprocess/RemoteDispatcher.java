package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"LambdaLast"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public interface RemoteDispatcher<T> {
    void execute(@NonNull T t5, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable;
}
