package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "Transformations")
/* loaded from: D:\Downloads\app\classes.dex */
public final class Transformations {
    @JvmName(name = "map")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull final Function1<X, Y> transform) {
        g0.p(liveData, "<this>");
        g0.p(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, n1>() { // from class: androidx.lifecycle.Transformations$map$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Object obj) {
                invoke2((Transformations$map$1<X>) obj);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x5) {
                mediatorLiveData.setValue(transform.invoke(x5));
            }
        }));
        return mediatorLiveData;
    }

    @JvmName(name = "switchMap")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull final Function1<X, LiveData<Y>> transform) {
        g0.p(liveData, "<this>");
        g0.p(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations$switchMap$1

            @Nullable
            private LiveData<Y> liveData;

            @Nullable
            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x5) {
                LiveData<Y> liveData2 = (LiveData) transform.invoke(x5);
                Object obj = this.liveData;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = mediatorLiveData;
                    g0.m(obj);
                    mediatorLiveData2.removeSource(obj);
                }
                this.liveData = liveData2;
                if (liveData2 != 0) {
                    MediatorLiveData<Y> mediatorLiveData3 = mediatorLiveData;
                    g0.m(liveData2);
                    final MediatorLiveData<Y> mediatorLiveData4 = mediatorLiveData;
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Y, n1>() { // from class: androidx.lifecycle.Transformations$switchMap$1$onChanged$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ n1 invoke(Object obj2) {
                            invoke2((Transformations$switchMap$1$onChanged$1<Y>) obj2);
                            return n1.f44123a;
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Y y5) {
                            mediatorLiveData4.setValue(y5);
                        }
                    }));
                }
            }

            public final void setLiveData(@Nullable LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }

    @JvmName(name = "distinctUntilChanged")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        g0.p(liveData, "<this>");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            booleanRef.element = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, n1>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Object obj) {
                invoke2((Transformations$distinctUntilChanged$1<X>) obj);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x5) {
                X value = mediatorLiveData.getValue();
                if (booleanRef.element || ((value == null && x5 != null) || !(value == null || g0.g(value, x5)))) {
                    booleanRef.element = false;
                    mediatorLiveData.setValue(x5);
                }
            }
        }));
        return mediatorLiveData;
    }

    @JvmName(name = "map")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, final Function mapFunction) {
        g0.p(liveData, "<this>");
        g0.p(mapFunction, "mapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Object, n1>() { // from class: androidx.lifecycle.Transformations$map$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Object obj) {
                invoke2(obj);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                mediatorLiveData.setValue(mapFunction.apply(obj));
            }
        }));
        return mediatorLiveData;
    }

    @JvmName(name = "switchMap")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function switchMapFunction) {
        g0.p(liveData, "<this>");
        g0.p(switchMapFunction, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<Object>() { // from class: androidx.lifecycle.Transformations$switchMap$2

            @Nullable
            private LiveData<Object> liveData;

            @Nullable
            public final LiveData<Object> getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LiveData<Object> apply = switchMapFunction.apply(obj);
                LiveData<Object> liveData2 = this.liveData;
                if (liveData2 == apply) {
                    return;
                }
                if (liveData2 != null) {
                    MediatorLiveData<Object> mediatorLiveData2 = mediatorLiveData;
                    g0.m(liveData2);
                    mediatorLiveData2.removeSource(liveData2);
                }
                this.liveData = apply;
                if (apply != null) {
                    MediatorLiveData<Object> mediatorLiveData3 = mediatorLiveData;
                    g0.m(apply);
                    final MediatorLiveData<Object> mediatorLiveData4 = mediatorLiveData;
                    mediatorLiveData3.addSource(apply, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Object, n1>() { // from class: androidx.lifecycle.Transformations$switchMap$2$onChanged$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ n1 invoke(Object obj2) {
                            invoke2(obj2);
                            return n1.f44123a;
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj2) {
                            mediatorLiveData4.setValue(obj2);
                        }
                    }));
                }
            }

            public final void setLiveData(@Nullable LiveData<Object> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
