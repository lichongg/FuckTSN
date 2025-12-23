package com.bxkj.student.v2.vm.face;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.repository.face.b;
import java.io.File;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceCollectVM extends BaseViewModel {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCollectVM$faceCollect$1", f = "FaceCollectVM.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f22293b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22294c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, Function0<n1> function0, e<? super a> eVar) {
            super(1, eVar);
            this.f22293b = file;
            this.f22294c = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new a(this.f22293b, this.f22294c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22292a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                b bVar = new b();
                MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData(master.flame.danmaku.danmaku.parser.b.f50156c, this.f22293b.getName(), RequestBody.Companion.create(this.f22293b, MediaType.Companion.get("image/png")));
                this.f22292a = 1;
                if (bVar.a(createFormData, this) == l6) {
                    return l6;
                }
            }
            this.f22294c.invoke();
            return n1.f44123a;
        }
    }

    public final void t(@NotNull File faceFile, @NotNull Function0<n1> result) {
        kotlin.jvm.internal.g0.p(faceFile, "faceFile");
        kotlin.jvm.internal.g0.p(result, "result");
        BaseViewModel.j(this, new a(faceFile, result, null), null, null, null, null, null, null, null, 254, null);
    }
}
