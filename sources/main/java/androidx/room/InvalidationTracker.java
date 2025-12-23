package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInvalidationTracker.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/InvalidationTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ReentrantLock.kt\nandroidx/room/concurrent/ReentrantLockKt\n*L\n1#1,592:1\n827#2:593\n855#2,2:594\n1863#2,2:617\n1863#2,2:624\n1#3:596\n28#4,5:597\n28#4,5:602\n28#4,5:607\n28#4,5:612\n28#4,5:619\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/InvalidationTracker\n*L\n186#1:593\n186#1:594,2\n351#1:617,2\n365#1:624,2\n274#1:597,5\n318#1:602,5\n322#1:607,5\n350#1:612,5\n364#1:619,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class InvalidationTracker {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private AutoCloser autoCloser;

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final TriggerBasedInvalidationTracker implementation;

    @NotNull
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;

    @Nullable
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;

    @Nullable
    private Intent multiInstanceInvalidationIntent;

    @NotNull
    private final Map<Observer, ObserverWrapper> observerMap;

    @NotNull
    private final ReentrantLock observerMapLock;

    @NotNull
    private final Function0<n1> onRefreshCompleted;

    @NotNull
    private final Function0<n1> onRefreshScheduled;

    @NotNull
    private final Map<String, String> shadowTablesMap;

    @NotNull
    private final String[] tableNames;

    @NotNull
    private final Object trackerLock;

    @NotNull
    private final Map<String, Set<String>> viewTables;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class MultiInstanceClientInitState {

        @NotNull
        private final Context context;

        @NotNull
        private final String name;

        @NotNull
        private final Intent serviceIntent;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) obj;
            return g0.g(this.context, multiInstanceClientInitState.context) && g0.g(this.name, multiInstanceClientInitState.name) && g0.g(this.serviceIntent, multiInstanceClientInitState.serviceIntent);
        }

        public MultiInstanceClientInitState(@NotNull Context context, @NotNull String name, @NotNull Intent serviceIntent) {
            g0.p(context, "context");
            g0.p(name, "name");
            g0.p(serviceIntent, "serviceIntent");
            this.context = context;
            this.name = name;
            this.serviceIntent = serviceIntent;
        }

        public static /* synthetic */ MultiInstanceClientInitState copy$default(MultiInstanceClientInitState multiInstanceClientInitState, Context context, String str, Intent intent, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                context = multiInstanceClientInitState.context;
            }
            if ((i6 & 2) != 0) {
                str = multiInstanceClientInitState.name;
            }
            if ((i6 & 4) != 0) {
                intent = multiInstanceClientInitState.serviceIntent;
            }
            return multiInstanceClientInitState.copy(context, str, intent);
        }

        @NotNull
        public final Context component1() {
            return this.context;
        }

        @NotNull
        public final String component2() {
            return this.name;
        }

        @NotNull
        public final Intent component3() {
            return this.serviceIntent;
        }

        @NotNull
        public final MultiInstanceClientInitState copy(@NotNull Context context, @NotNull String name, @NotNull Intent serviceIntent) {
            g0.p(context, "context");
            g0.p(name, "name");
            g0.p(serviceIntent, "serviceIntent");
            return new MultiInstanceClientInitState(context, name, serviceIntent);
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public int hashCode() {
            return (((this.context.hashCode() * 31) + this.name.hashCode()) * 31) + this.serviceIntent.hashCode();
        }

        @NotNull
        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.context + ", name=" + this.name + ", serviceIntent=" + this.serviceIntent + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Observer {

        @NotNull
        private final String[] tables;

        public Observer(@NotNull String[] tables) {
            g0.p(tables, "tables");
            this.tables = tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(@NotNull Set<String> set);

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected Observer(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.String... r4) {
            /*
                r2 = this;
                java.lang.String r0 = "firstTable"
                kotlin.jvm.internal.g0.p(r3, r0)
                java.lang.String r0 = "rest"
                kotlin.jvm.internal.g0.p(r4, r0)
                kotlin.jvm.internal.s0 r0 = new kotlin.jvm.internal.s0
                r1 = 2
                r0.<init>(r1)
                r0.a(r3)
                r0.b(r4)
                int r3 = r0.c()
                java.lang.String[] r3 = new java.lang.String[r3]
                java.lang.Object[] r3 = r0.d(r3)
                java.lang.String[] r3 = (java.lang.String[]) r3
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.Observer.<init>(java.lang.String, java.lang.String[]):void");
        }

        @NotNull
        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@NotNull RoomDatabase database, @NotNull Map<String, String> shadowTablesMap, @NotNull Map<String, Set<String>> viewTables, @NotNull String... tableNames) {
        g0.p(database, "database");
        g0.p(shadowTablesMap, "shadowTablesMap");
        g0.p(viewTables, "viewTables");
        g0.p(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.tableNames = tableNames;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(database, shadowTablesMap, viewTables, tableNames, database.getUseTempTrackingTable$room_runtime_release(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        this.onRefreshScheduled = new Function0() { // from class: androidx.room.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 onRefreshScheduled$lambda$0;
                onRefreshScheduled$lambda$0 = InvalidationTracker.onRefreshScheduled$lambda$0(InvalidationTracker.this);
                return onRefreshScheduled$lambda$0;
            }
        };
        this.onRefreshCompleted = new Function0() { // from class: androidx.room.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 onRefreshCompleted$lambda$1;
                onRefreshCompleted$lambda$1 = InvalidationTracker.onRefreshCompleted$lambda$1(InvalidationTracker.this);
                return onRefreshCompleted$lambda$1;
            }
        };
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.trackerLock = new Object();
        triggerBasedInvalidationTracker.setOnAllowRefresh$room_runtime_release(new Function0() { // from class: androidx.room.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _init_$lambda$2;
                _init_$lambda$2 = InvalidationTracker._init_$lambda$2(InvalidationTracker.this);
                return Boolean.valueOf(_init_$lambda$2);
            }
        });
    }

    @JvmOverloads
    @NotNull
    public final kotlinx.coroutines.flow.i<Set<String>> createFlow(@NotNull String... tables) {
        g0.p(tables, "tables");
        return createFlow$default(this, tables, false, 2, null);
    }

    @Deprecated(message = "Replaced with overload that takes 'inTransaction 'parameter.", replaceWith = @ReplaceWith(expression = "createLiveData(tableNames, false, computeFunction", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public <T> LiveData<T> createLiveData(@NotNull String[] tableNames, @NotNull Callable<T> computeFunction) {
        g0.p(tableNames, "tableNames");
        g0.p(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, (Callable) computeFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.database.inCompatibilityMode$room_runtime_release() || invalidationTracker.database.isOpenInternal();
    }

    private final boolean addObserverOnly(Observer observer) {
        Pair<String[], int[]> validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(observer.getTables$room_runtime_release());
        String[] component1 = validateTableNames$room_runtime_release.component1();
        int[] component2 = validateTableNames$room_runtime_release.component2();
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, component2, component1);
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper put = this.observerMap.containsKey(observer) ? (ObserverWrapper) i1.K(this.observerMap, observer) : this.observerMap.put(observer, observerWrapper);
            reentrantLock.unlock();
            return put == null && this.implementation.onObserverAdded$room_runtime_release(component2);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ kotlinx.coroutines.flow.i createFlow$default(InvalidationTracker invalidationTracker, String[] strArr, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow");
        }
        if ((i6 & 2) != 0) {
            z5 = true;
        }
        return invalidationTracker.createFlow(strArr, z5);
    }

    private final List<Observer> getAllObservers() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return f0.a6(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInvalidatedObservers(Set<Integer> set) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List a6 = f0.a6(this.observerMap.values());
            reentrantLock.unlock();
            Iterator it = a6.iterator();
            while (it.hasNext()) {
                ((ObserverWrapper) it.next()).notifyByTableIds$room_runtime_release(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    List<Observer> allObservers = getAllObservers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : allObservers) {
                        if (!((Observer) obj).isRemote$room_runtime_release()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.stop();
                    }
                }
                this.implementation.resetSync$room_runtime_release();
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 onRefreshCompleted$lambda$1(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.decrementCountAndScheduleClose();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 onRefreshScheduled$lambda$0(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        return n1.f44123a;
    }

    private final boolean removeObserverOnly(Observer observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper remove = this.observerMap.remove(observer);
            return remove != null && this.implementation.onObserverRemoved$room_runtime_release(remove.getTableIds$room_runtime_release());
        } finally {
            reentrantLock.unlock();
        }
    }

    @WorkerThread
    public void addObserver(@NotNull Observer observer) {
        g0.p(observer, "observer");
        if (addObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$addObserver$1(this, null));
        }
    }

    public final void addRemoteObserver$room_runtime_release(@NotNull Observer observer) {
        g0.p(observer, "observer");
        if (!observer.isRemote$room_runtime_release()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        addObserverOnly(observer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void addWeakObserver(@NotNull Observer observer) {
        g0.p(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @JvmOverloads
    @NotNull
    public final kotlinx.coroutines.flow.i<Set<String>> createFlow(@NotNull String[] tables, boolean z5) {
        g0.p(tables, "tables");
        Pair<String[], int[]> validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(tables);
        String[] component1 = validateTableNames$room_runtime_release.component1();
        kotlinx.coroutines.flow.i<Set<String>> createFlow$room_runtime_release = this.implementation.createFlow$room_runtime_release(component1, validateTableNames$room_runtime_release.component2(), z5);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        kotlinx.coroutines.flow.i<Set<String>> createFlow = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.createFlow(component1) : null;
        return createFlow != null ? kotlinx.coroutines.flow.k.b1(createFlow$room_runtime_release, createFlow) : createFlow$room_runtime_release;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public <T> LiveData<T> createLiveData(@NotNull String[] tableNames, boolean z5, @NotNull Callable<T> computeFunction) {
        g0.p(tableNames, "tableNames");
        g0.p(computeFunction, "computeFunction");
        this.implementation.validateTableNames$room_runtime_release(tableNames);
        return this.invalidationLiveDataContainer.create(tableNames, z5, computeFunction);
    }

    @NotNull
    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    @NotNull
    public final String[] getTableNames$room_runtime_release() {
        return this.tableNames;
    }

    public final void initMultiInstanceInvalidation$room_runtime_release(@NotNull Context context, @NotNull String name, @NotNull Intent serviceIntent) {
        g0.p(context, "context");
        g0.p(name, "name");
        g0.p(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationIntent = serviceIntent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this);
    }

    public final void internalInit$room_runtime_release(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        this.implementation.configureConnection(connection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.start(intent);
                    n1 n1Var = n1.f44123a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void notifyObserversByTableNames$room_runtime_release(@NotNull Set<String> tables) {
        g0.p(tables, "tables");
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> a6 = f0.a6(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : a6) {
                if (!observerWrapper.getObserver$room_runtime_release().isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(tables);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final Object refresh(@NotNull String[] strArr, @NotNull kotlin.coroutines.e<? super Boolean> eVar) {
        return this.implementation.refreshInvalidation$room_runtime_release(strArr, this.onRefreshScheduled, this.onRefreshCompleted, eVar);
    }

    public final void refreshAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void refreshVersionsAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$refreshVersionsSync$1(this, null));
    }

    @WorkerThread
    public void removeObserver(@NotNull Observer observer) {
        g0.p(observer, "observer");
        if (removeObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$removeObserver$1(this, null));
        }
    }

    public final void setAutoCloser$room_runtime_release(@NotNull AutoCloser autoCloser) {
        g0.p(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void stop$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
    }

    @Nullable
    public final Object sync$room_runtime_release(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        if (this.database.inCompatibilityMode$room_runtime_release() && !this.database.isOpenInternal()) {
            return n1.f44123a;
        }
        Object syncTriggers$room_runtime_release = this.implementation.syncTriggers$room_runtime_release(eVar);
        return syncTriggers$room_runtime_release == kotlin.coroutines.intrinsics.a.l() ? syncTriggers$room_runtime_release : n1.f44123a;
    }

    @WorkerThread
    public final void syncBlocking$room_runtime_release() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$syncBlocking$1(this, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public final <T> LiveData<T> createLiveData(@NotNull String[] tableNames, boolean z5, @NotNull Function1<? super SQLiteConnection, ? extends T> computeFunction) {
        g0.p(tableNames, "tableNames");
        g0.p(computeFunction, "computeFunction");
        this.implementation.validateTableNames$room_runtime_release(tableNames);
        return this.invalidationLiveDataContainer.create(tableNames, z5, computeFunction);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "No longer called by generated implementation")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@NotNull RoomDatabase database, @NotNull String... tableNames) {
        this(database, i1.z(), i1.z(), (String[]) Arrays.copyOf(tableNames, tableNames.length));
        g0.p(database, "database");
        g0.p(tableNames, "tableNames");
    }
}
