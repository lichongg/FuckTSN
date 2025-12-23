package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7\n*L\n1#1,332:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__ZipKt$combineTransform$7<R> extends SuspendLambda implements Function2<j<? super R>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ i<T>[] $flowArray;
    final /* synthetic */ Function3<j<? super R>, T[], kotlin.coroutines.e<? super n1>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$1\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function0<T[]> {
        final /* synthetic */ i<T>[] $flowArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(i<T>[] iVarArr) {
            super(0);
            this.$flowArray = iVarArr;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final T[] invoke() {
            int length = this.$flowArray.length;
            kotlin.jvm.internal.g0.y(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$2\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function3<j<? super R>, T[], kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ Function3<j<? super R>, T[], kotlin.coroutines.e<? super n1>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, kotlin.coroutines.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
            this.$transform = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull j<? super R> jVar, @NotNull T[] tArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            kotlin.jvm.internal.g0.w();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, eVar);
            anonymousClass2.L$0 = jVar;
            anonymousClass2.L$1 = tArr;
            return anonymousClass2.invokeSuspend(n1.f44123a);
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.$transform.invoke((j) this.L$0, (Object[]) this.L$1, this);
            return n1.f44123a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                j jVar = (j) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Function3<j<? super R>, T[], kotlin.coroutines.e<? super n1>, Object> function3 = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (function3.invoke(jVar, objArr, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransform$7(i<T>[] iVarArr, Function3<? super j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, kotlin.coroutines.e<? super FlowKt__ZipKt$combineTransform$7> eVar) {
        super(2, eVar);
        this.$flowArray = iVarArr;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, eVar);
        flowKt__ZipKt$combineTransform$7.L$0 = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<? super R> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((FlowKt__ZipKt$combineTransform$7) create(jVar, eVar)).invokeSuspend(n1.f44123a);
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        j jVar = (j) this.L$0;
        i<T>[] iVarArr = this.$flowArray;
        kotlin.jvm.internal.g0.w();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
        kotlin.jvm.internal.g0.w();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
        kotlin.jvm.internal.d0.e(0);
        kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, anonymousClass1, anonymousClass2, this);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                kotlin.g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.g0.n(obj);
            j jVar = (j) this.L$0;
            i<T>[] iVarArr = this.$flowArray;
            kotlin.jvm.internal.g0.w();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
            kotlin.jvm.internal.g0.w();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, anonymousClass1, anonymousClass2, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
