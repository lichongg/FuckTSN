package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMultiInstanceInvalidationClient.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiInstanceInvalidationClient.android.kt\nandroidx/room/MultiInstanceInvalidationClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,146:1\n1#2:147\n60#3:148\n63#3:152\n50#4:149\n55#4:151\n107#5:150\n*S KotlinDebug\n*F\n+ 1 MultiInstanceInvalidationClient.android.kt\nandroidx/room/MultiInstanceInvalidationClient\n*L\n133#1:148\n133#1:152\n133#1:149\n133#1:151\n133#1:150\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private int clientId;

    @NotNull
    private final r0 coroutineScope;

    @NotNull
    private final kotlinx.coroutines.flow.s<Set<String>> invalidatedTables;

    @NotNull
    private final IMultiInstanceInvalidationCallback invalidationCallback;

    @Nullable
    private IMultiInstanceInvalidationService invalidationService;

    @NotNull
    private final InvalidationTracker invalidationTracker;

    @NotNull
    private final String name;

    @NotNull
    private final MultiInstanceInvalidationClient$observer$1 observer;

    @NotNull
    private final ServiceConnection serviceConnection;

    @NotNull
    private final AtomicBoolean stopped;

    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.room.MultiInstanceInvalidationClient$observer$1] */
    public MultiInstanceInvalidationClient(@NotNull Context context, @NotNull String name, @NotNull InvalidationTracker invalidationTracker) {
        g0.p(context, "context");
        g0.p(name, "name");
        g0.p(invalidationTracker, "invalidationTracker");
        this.name = name;
        this.invalidationTracker = invalidationTracker;
        this.appContext = context.getApplicationContext();
        this.coroutineScope = invalidationTracker.getDatabase$room_runtime_release().getCoroutineScope();
        this.stopped = new AtomicBoolean(true);
        this.invalidatedTables = kotlinx.coroutines.flow.z.a(0, 0, BufferOverflow.SUSPEND);
        final String[] tableNames$room_runtime_release = invalidationTracker.getTableNames$room_runtime_release();
        this.observer = new InvalidationTracker.Observer(tableNames$room_runtime_release) { // from class: androidx.room.MultiInstanceInvalidationClient$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables) {
                AtomicBoolean atomicBoolean;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService;
                int i6;
                g0.p(tables, "tables");
                atomicBoolean = MultiInstanceInvalidationClient.this.stopped;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.invalidationService;
                    if (iMultiInstanceInvalidationService != null) {
                        i6 = MultiInstanceInvalidationClient.this.clientId;
                        iMultiInstanceInvalidationService.broadcastInvalidation(i6, (String[]) tables.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        };
        this.invalidationCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] tables) {
                r0 r0Var;
                g0.p(tables, "tables");
                r0Var = MultiInstanceInvalidationClient.this.coroutineScope;
                kotlinx.coroutines.k.f(r0Var, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(tables, MultiInstanceInvalidationClient.this, null), 3, null);
            }
        };
        this.serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name2, IBinder service) {
                g0.p(name2, "name");
                g0.p(service, "service");
                MultiInstanceInvalidationClient.this.invalidationService = IMultiInstanceInvalidationService.Stub.asInterface(service);
                MultiInstanceInvalidationClient.this.registerCallback();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name2) {
                g0.p(name2, "name");
                MultiInstanceInvalidationClient.this.invalidationService = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerCallback() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
            if (iMultiInstanceInvalidationService != null) {
                this.clientId = iMultiInstanceInvalidationService.registerCallback(this.invalidationCallback, this.name);
            }
        } catch (RemoteException unused) {
        }
    }

    @NotNull
    public final kotlinx.coroutines.flow.i<Set<String>> createFlow(@NotNull final String[] resolvedTableNames) {
        g0.p(resolvedTableNames, "resolvedTableNames");
        final kotlinx.coroutines.flow.s<Set<String>> sVar = this.invalidatedTables;
        return new kotlinx.coroutines.flow.i<Set<? extends String>>() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 MultiInstanceInvalidationClient.android.kt\nandroidx/room/MultiInstanceInvalidationClient\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,222:1\n61#2:223\n62#2:239\n134#3,2:224\n136#3:227\n137#3,4:229\n141#3:234\n142#3,2:236\n13402#4:226\n13403#4:235\n1863#5:228\n1864#5:233\n1#6:238\n*S KotlinDebug\n*F\n+ 1 MultiInstanceInvalidationClient.android.kt\nandroidx/room/MultiInstanceInvalidationClient\n*L\n135#1:226\n135#1:235\n136#1:228\n136#1:233\n*E\n"})
            /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.j {
                final /* synthetic */ String[] $resolvedTableNames$inlined;
                final /* synthetic */ kotlinx.coroutines.flow.j $this_unsafeFlow;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", i = {}, l = {org.apache.commons.net.telnet.f.f51102r}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.j jVar, String[] strArr) {
                    this.$this_unsafeFlow = jVar;
                    this.$resolvedTableNames$inlined = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r12)
                        goto L77
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        kotlin.g0.n(r12)
                        kotlinx.coroutines.flow.j r12 = r10.$this_unsafeFlow
                        java.util.Set r11 = (java.util.Set) r11
                        java.util.Set r2 = kotlin.collections.u1.d()
                        java.lang.String[] r4 = r10.$resolvedTableNames$inlined
                        int r5 = r4.length
                        r6 = 0
                    L40:
                        if (r6 >= r5) goto L61
                        r7 = r4[r6]
                        java.util.Iterator r8 = r11.iterator()
                    L48:
                        boolean r9 = r8.hasNext()
                        if (r9 == 0) goto L5e
                        java.lang.Object r9 = r8.next()
                        java.lang.String r9 = (java.lang.String) r9
                        boolean r9 = kotlin.text.u.a2(r7, r9, r3)
                        if (r9 == 0) goto L48
                        r2.add(r7)
                        goto L48
                    L5e:
                        int r6 = r6 + 1
                        goto L40
                    L61:
                        java.util.Set r11 = kotlin.collections.u1.a(r2)
                        boolean r2 = r11.isEmpty()
                        if (r2 == 0) goto L6c
                        r11 = 0
                    L6c:
                        if (r11 == 0) goto L77
                        r0.label = r3
                        java.lang.Object r11 = r12.emit(r11, r0)
                        if (r11 != r1) goto L77
                        return r1
                    L77:
                        kotlin.n1 r11 = kotlin.n1.f44123a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull kotlinx.coroutines.flow.j<? super Set<? extends String>> jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = kotlinx.coroutines.flow.i.this.collect(new AnonymousClass2(jVar, resolvedTableNames), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        };
    }

    @NotNull
    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void start(@NotNull Intent serviceIntent) {
        g0.p(serviceIntent, "serviceIntent");
        if (this.stopped.compareAndSet(true, false)) {
            this.appContext.bindService(serviceIntent, this.serviceConnection, 1);
            this.invalidationTracker.addRemoteObserver$room_runtime_release(this.observer);
        }
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(this.observer);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.invalidationCallback, this.clientId);
                }
            } catch (RemoteException unused) {
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
