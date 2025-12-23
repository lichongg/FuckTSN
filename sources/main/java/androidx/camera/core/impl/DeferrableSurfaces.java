package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class DeferrableSurfaces {
    @NonNull
    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(@NonNull Collection<DeferrableSurface> collection, final boolean z5, final long j6, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Futures.nonCancellationPropagating(it.next().getSurface()));
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.t
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DeferrableSurfaces.a(arrayList, scheduledExecutorService, executor, j6, z5, completer);
            }
        });
    }

    private DeferrableSurfaces() {
    }

    public static /* synthetic */ Object a(List list, ScheduledExecutorService scheduledExecutorService, final Executor executor, final long j6, final boolean z5, final CallbackToFutureAdapter.Completer completer) {
        final ListenableFuture successfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: androidx.camera.core.impl.v
            @Override // java.lang.Runnable
            public final void run() {
                executor.execute(new Runnable() { // from class: androidx.camera.core.impl.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeferrableSurfaces.c(ListenableFuture.this, r2, r3);
                    }
                });
            }
        }, j6, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.w
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFuture.this.cancel(true);
            }
        }, executor);
        Futures.addCallback(successfulAsList, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.EMPTY_LIST));
                schedule.cancel(true);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<Surface> list2) {
                ArrayList arrayList = new ArrayList(list2);
                if (z5) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.set(arrayList);
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    public static /* synthetic */ void c(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j6) {
        if (!listenableFuture.isDone()) {
            completer.setException(new TimeoutException("Cannot complete surfaceList within " + j6));
            listenableFuture.cancel(true);
        }
    }

    public static void decrementAll(@NonNull List<DeferrableSurface> list) {
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().decrementUseCount();
        }
    }

    public static void incrementAll(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i6 = 0;
            do {
                try {
                    list.get(i6).incrementUseCount();
                    i6++;
                } catch (DeferrableSurface.SurfaceClosedException e6) {
                    for (int i7 = i6 - 1; i7 >= 0; i7--) {
                        list.get(i7).decrementUseCount();
                    }
                    throw e6;
                }
            } while (i6 < list.size());
        }
    }

    public static boolean tryIncrementAll(@NonNull List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }
}
