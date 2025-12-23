package com.bxkj.student.v2.vm.sports.appeal;

import android.text.TextUtils;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.student.v2.repository.sports.c;
import com.orhanobut.logger.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import master.flame.danmaku.danmaku.parser.b;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AppealVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private String f22631h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.appeal.AppealVM$appealV3$1", f = "AppealVM.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"parts"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAppealVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppealVM.kt\ncom/bxkj/student/v2/vm/sports/appeal/AppealVM$appealV3$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n1869#2,2:54\n*S KotlinDebug\n*F\n+ 1 AppealVM.kt\ncom/bxkj/student/v2/vm/sports/appeal/AppealVM$appealV3$1\n*L\n36#1:54,2\n*E\n"})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22632a;

        /* renamed from: b, reason: collision with root package name */
        int f22633b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f22635d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22636e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22637f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<String> list, String str, Function1<? super String, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22635d = list;
            this.f22636e = str;
            this.f22637f = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return AppealVM.this.new a(this.f22635d, this.f22636e, this.f22637f, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22633b;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                j.d("exerciseRecordId=" + AppealVM.this.u(), new Object[0]);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = this.f22635d.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    arrayList.add(MultipartBody.Part.Companion.createFormData(b.f50156c, file.getName(), RequestBody.Companion.create(MediaType.Companion.parse("application/octet-stream"), file)));
                }
                MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
                arrayList.add(companion.createFormData("exerciseRecordId", String.valueOf(AppealVM.this.u())));
                arrayList.add(companion.createFormData("content", this.f22636e));
                c cVar = new c();
                this.f22632a = kotlin.coroutines.jvm.internal.j.a(arrayList);
                this.f22633b = 1;
                obj = cVar.a(arrayList, this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null) {
                str = apiResult.getMsg();
            } else {
                str = null;
            }
            this.f22637f.invoke(str);
            return n1.f44123a;
        }
    }

    public final void t(@NotNull String reason, @NotNull List<String> paths, @NotNull Function1<? super String, n1> callBack) {
        kotlin.jvm.internal.g0.p(reason, "reason");
        kotlin.jvm.internal.g0.p(paths, "paths");
        kotlin.jvm.internal.g0.p(callBack, "callBack");
        if (TextUtils.isEmpty(reason)) {
            f().postValue("请输入申诉理由");
        } else {
            BaseViewModel.j(this, new a(paths, reason, callBack, null), null, null, null, null, null, null, null, 254, null);
        }
    }

    @Nullable
    public final String u() {
        return this.f22631h;
    }

    public final void v(@Nullable String str) {
        this.f22631h = str;
    }
}
