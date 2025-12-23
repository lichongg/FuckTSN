package c4;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final f f1055a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Package, Integer> f1056b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> f1057c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> f1058d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> f1059e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> f1060f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1061g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1062h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1063i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1064j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1065k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> f1066l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> f1067m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> f1068n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> f1069o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> f1070p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f1071q;

    public a(@NotNull f extensionRegistry, @NotNull GeneratedMessageLite.f<ProtoBuf.Package, Integer> packageFqName, @NotNull GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation, @Nullable GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> fVar, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation, @Nullable GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> fVar2, @Nullable GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> fVar3, @Nullable GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> fVar4, @NotNull GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue, @NotNull GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation, @NotNull GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation) {
        g0.p(extensionRegistry, "extensionRegistry");
        g0.p(packageFqName, "packageFqName");
        g0.p(constructorAnnotation, "constructorAnnotation");
        g0.p(classAnnotation, "classAnnotation");
        g0.p(functionAnnotation, "functionAnnotation");
        g0.p(propertyAnnotation, "propertyAnnotation");
        g0.p(propertyGetterAnnotation, "propertyGetterAnnotation");
        g0.p(propertySetterAnnotation, "propertySetterAnnotation");
        g0.p(enumEntryAnnotation, "enumEntryAnnotation");
        g0.p(compileTimeValue, "compileTimeValue");
        g0.p(parameterAnnotation, "parameterAnnotation");
        g0.p(typeAnnotation, "typeAnnotation");
        g0.p(typeParameterAnnotation, "typeParameterAnnotation");
        this.f1055a = extensionRegistry;
        this.f1056b = packageFqName;
        this.f1057c = constructorAnnotation;
        this.f1058d = classAnnotation;
        this.f1059e = functionAnnotation;
        this.f1060f = fVar;
        this.f1061g = propertyAnnotation;
        this.f1062h = propertyGetterAnnotation;
        this.f1063i = propertySetterAnnotation;
        this.f1064j = fVar2;
        this.f1065k = fVar3;
        this.f1066l = fVar4;
        this.f1067m = enumEntryAnnotation;
        this.f1068n = compileTimeValue;
        this.f1069o = parameterAnnotation;
        this.f1070p = typeAnnotation;
        this.f1071q = typeParameterAnnotation;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Annotation>> a() {
        return this.f1058d;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> b() {
        return this.f1068n;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> c() {
        return this.f1057c;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> d() {
        return this.f1067m;
    }

    @NotNull
    public final f e() {
        return this.f1055a;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> f() {
        return this.f1059e;
    }

    @Nullable
    public final GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> g() {
        return this.f1060f;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> h() {
        return this.f1069o;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> i() {
        return this.f1061g;
    }

    @Nullable
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> j() {
        return this.f1065k;
    }

    @Nullable
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> k() {
        return this.f1066l;
    }

    @Nullable
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> l() {
        return this.f1064j;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> m() {
        return this.f1062h;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> n() {
        return this.f1063i;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> o() {
        return this.f1070p;
    }

    @NotNull
    public final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> p() {
        return this.f1071q;
    }
}
