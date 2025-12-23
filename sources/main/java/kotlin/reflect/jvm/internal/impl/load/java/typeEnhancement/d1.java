package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n1563#2:348\n1634#2,3:349\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo\n*L\n41#1:348\n41#1:349,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final n1 f45761a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<n1> f45762b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f45763c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final d1 f45764d;

    public d1() {
        this(null, null, null, 7, null);
    }

    public d1(@Nullable n1 n1Var, @NotNull List<n1> parametersInfo, @Nullable String str) {
        kotlin.jvm.internal.g0.p(parametersInfo, "parametersInfo");
        this.f45761a = n1Var;
        this.f45762b = parametersInfo;
        this.f45763c = str;
        d1 d1Var = null;
        if (str != null) {
            n1 a6 = n1Var != null ? n1Var.a() : null;
            List<n1> list = parametersInfo;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            for (n1 n1Var2 : list) {
                arrayList.add(n1Var2 != null ? n1Var2.a() : null);
            }
            d1Var = new d1(a6, arrayList, null);
        }
        this.f45764d = d1Var;
    }

    @Nullable
    public final String a() {
        return this.f45763c;
    }

    @NotNull
    public final List<n1> b() {
        return this.f45762b;
    }

    @Nullable
    public final n1 c() {
        return this.f45761a;
    }

    @Nullable
    public final d1 d() {
        return this.f45764d;
    }

    public /* synthetic */ d1(n1 n1Var, List list, String str, int i6, kotlin.jvm.internal.v vVar) {
        this((i6 & 1) != 0 ? null : n1Var, (i6 & 2) != 0 ? kotlin.collections.f0.J() : list, (i6 & 4) != 0 ? null : str);
    }
}
