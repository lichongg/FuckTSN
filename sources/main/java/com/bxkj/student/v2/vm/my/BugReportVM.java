package com.bxkj.student.v2.vm.my;

import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.bn;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.http.result.OldApiResult;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.db.AppDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.j;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class BugReportVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22340h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.my.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.my.b w5;
            w5 = BugReportVM.w();
            return w5;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private String f22341i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.my.BugReportVM$commit$1", f = "BugReportVM.kt", i = {0, 0, 0, 0, 0, 0}, l = {67}, m = "invokeSuspend", n = {"parts", "key", "shareFile", "shareFileBody", "dbFile", "dbFileBody"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @SourceDebugExtension({"SMAP\nBugReportVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BugReportVM.kt\ncom/bxkj/student/v2/vm/my/BugReportVM$commit$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1869#2,2:82\n1#3:84\n*S KotlinDebug\n*F\n+ 1 BugReportVM.kt\ncom/bxkj/student/v2/vm/my/BugReportVM$commit$1\n*L\n48#1:82,2\n*E\n"})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22342a;

        /* renamed from: b, reason: collision with root package name */
        Object f22343b;

        /* renamed from: c, reason: collision with root package name */
        Object f22344c;

        /* renamed from: d, reason: collision with root package name */
        Object f22345d;

        /* renamed from: e, reason: collision with root package name */
        Object f22346e;

        /* renamed from: f, reason: collision with root package name */
        Object f22347f;

        /* renamed from: g, reason: collision with root package name */
        int f22348g;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List<String> f22350i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f22351j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f22352k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22353l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<String> list, String str, String str2, Function1<? super String, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22350i = list;
            this.f22351j = str;
            this.f22352k = str2;
            this.f22353l = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return BugReportVM.this.new a(this.f22350i, this.f22351j, this.f22352k, this.f22353l, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22348g;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                ArrayList arrayList = new ArrayList();
                AppDatabase.f20686a.a().close();
                File B = BugReportVM.this.B();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.Companion companion2 = MediaType.Companion;
                RequestBody create = companion.create(companion2.parse(Headers.VALUE_APPLICATION_XML), B);
                MultipartBody.Part.Companion companion3 = MultipartBody.Part.Companion;
                arrayList.add(companion3.createFormData("files", B.getName(), create));
                File z5 = BugReportVM.this.z();
                RequestBody create2 = companion.create(companion2.parse("application/db"), z5);
                arrayList.add(companion3.createFormData("files", z5.getName(), create2));
                Iterator<T> it = this.f22350i.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    arrayList.add(MultipartBody.Part.Companion.createFormData("files", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse("application/octet-stream"), file)));
                }
                MultipartBody.Part.Companion companion4 = MultipartBody.Part.Companion;
                arrayList.add(companion4.createFormData("note", this.f22351j + "【联系方式：" + this.f22352k + "】"));
                b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                arrayList.add(companion4.createFormData("schoolCode", aVar.a().J()));
                arrayList.add(companion4.createFormData("userNum", aVar.a().S()));
                arrayList.add(companion4.createFormData("appType", "Android"));
                c0.a aVar2 = c0.a.f1040a;
                Object obj2 = aVar2.a().get("versionCode");
                Object obj3 = "";
                if (obj2 == null) {
                    obj2 = "";
                }
                arrayList.add(companion4.createFormData("versionCode", String.valueOf(obj2)));
                Object obj4 = aVar2.a().get("versionName");
                if (obj4 == null) {
                    obj4 = "";
                }
                arrayList.add(companion4.createFormData("versionName", String.valueOf(obj4)));
                Object obj5 = aVar2.a().get("signatureMD5");
                if (obj5 == null) {
                    obj5 = "";
                }
                arrayList.add(companion4.createFormData("signatureMD5", String.valueOf(obj5)));
                Object obj6 = aVar2.a().get(bn.f10754j);
                if (obj6 == null) {
                    obj6 = "";
                }
                arrayList.add(companion4.createFormData(bn.f10754j, String.valueOf(obj6)));
                Object obj7 = aVar2.a().get(bn.f10753i);
                if (obj7 == null) {
                    obj7 = "";
                }
                arrayList.add(companion4.createFormData(bn.f10753i, String.valueOf(obj7)));
                Object obj8 = aVar2.a().get(ConstantHelper.LOG_OS);
                if (obj8 == null) {
                    obj8 = "";
                }
                arrayList.add(companion4.createFormData(ConstantHelper.LOG_OS, String.valueOf(obj8)));
                Object obj9 = aVar2.a().get("version");
                if (obj9 != null) {
                    obj3 = obj9;
                }
                arrayList.add(companion4.createFormData("version", String.valueOf(obj3)));
                com.bxkj.student.v2.repository.my.b y5 = BugReportVM.this.y();
                this.f22342a = j.a(arrayList);
                this.f22343b = j.a("files");
                this.f22344c = j.a(B);
                this.f22345d = j.a(create);
                this.f22346e = j.a(z5);
                this.f22347f = j.a(create2);
                this.f22348g = 1;
                obj = y5.a(arrayList, this);
                if (obj == l6) {
                    return l6;
                }
            }
            OldApiResult oldApiResult = (OldApiResult) obj;
            if (oldApiResult != null) {
                str = oldApiResult.getReturnMsg();
            } else {
                str = null;
            }
            this.f22353l.invoke(str);
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File B() {
        return new File(new File(App.f17573d.a().getFilesDir().getParent(), "shared_prefs"), "share_date.xml");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.my.b w() {
        return new com.bxkj.student.v2.repository.my.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File z() {
        File databasePath = App.f17573d.a().getDatabasePath("TSNStudent.db");
        kotlin.jvm.internal.g0.o(databasePath, "getDatabasePath(...)");
        return databasePath;
    }

    @Nullable
    public final String A() {
        return this.f22341i;
    }

    public final void C(@Nullable String str) {
        this.f22341i = str;
    }

    public final void x(@NotNull String phone, @NotNull String note, @NotNull List<String> paths, @NotNull Function1<? super String, n1> callBack) {
        kotlin.jvm.internal.g0.p(phone, "phone");
        kotlin.jvm.internal.g0.p(note, "note");
        kotlin.jvm.internal.g0.p(paths, "paths");
        kotlin.jvm.internal.g0.p(callBack, "callBack");
        if (TextUtils.isEmpty(phone)) {
            f().postValue("请留下您的联系方式，便于我们联系您");
        } else if (TextUtils.isEmpty(note)) {
            f().postValue("请输入您遇到了什么bug？");
        } else {
            BaseViewModel.j(this, new a(paths, note, phone, callBack, null), null, null, null, null, null, null, null, 254, null);
        }
    }

    @NotNull
    public final com.bxkj.student.v2.repository.my.b y() {
        return (com.bxkj.student.v2.repository.my.b) this.f22340h.getValue();
    }
}
