package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ListenerHolders {
    private final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(@NonNull L l6, @NonNull Looper looper, @NonNull String str) {
        Preconditions.checkNotNull(l6, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l6, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(@NonNull L l6, @NonNull String str) {
        Preconditions.checkNotNull(l6, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l6, str);
    }

    @NonNull
    public final ListenerHolder zaa(@NonNull Object obj, @NonNull Looper looper, @NonNull String str) {
        Set set = this.zaa;
        ListenerHolder createListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        set.add(createListenerHolder);
        return createListenerHolder;
    }

    public final void zab() {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).clear();
        }
        this.zaa.clear();
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(@NonNull L l6, @NonNull Executor executor, @NonNull String str) {
        Preconditions.checkNotNull(l6, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l6, str);
    }
}
