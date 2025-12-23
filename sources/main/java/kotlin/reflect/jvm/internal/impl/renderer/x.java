package kotlin.reflect.jvm.internal.impl.renderer;

import com.acse.ottn.l3;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.renderer.m;
import kotlin.reflect.jvm.internal.impl.renderer.u;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDescriptorRendererOptionsImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRendererOptionsImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererOptionsImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Delegates.kt\nkotlin/properties/Delegates\n*L\n1#1,137:1\n1#2:138\n51#3,3:139\n*S KotlinDebug\n*F\n+ 1 DescriptorRendererOptionsImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererOptionsImpl\n*L\n60#1:139,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x implements u {
    static final /* synthetic */ kotlin.reflect.n<Object>[] Z = {o0.k(new MutablePropertyReference1Impl(x.class, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "withDefinedIn", "getWithDefinedIn()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "modifiers", "getModifiers()Ljava/util/Set;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "startFromName", "getStartFromName()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "debugMode", "getDebugMode()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "verbose", "getVerbose()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "unitReturnType", "getUnitReturnType()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "withoutReturnType", "getWithoutReturnType()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "enhancedTypes", "getEnhancedTypes()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderDefaultModality", "getRenderDefaultModality()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "includePropertyConstant", "getIncludePropertyConstant()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "receiverAfterName", "getReceiverAfterName()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0)), o0.k(new MutablePropertyReference1Impl(x.class, "informativeErrorType", "getInformativeErrorType()Z", 0))};

    @NotNull
    private final kotlin.properties.f A;

    @NotNull
    private final kotlin.properties.f B;

    @NotNull
    private final kotlin.properties.f C;

    @NotNull
    private final kotlin.properties.f D;

    @NotNull
    private final kotlin.properties.f E;

    @NotNull
    private final kotlin.properties.f F;

    @NotNull
    private final kotlin.properties.f G;

    @NotNull
    private final kotlin.properties.f H;

    @NotNull
    private final kotlin.properties.f I;

    @NotNull
    private final kotlin.properties.f J;

    @NotNull
    private final kotlin.properties.f K;

    @NotNull
    private final kotlin.properties.f L;

    @NotNull
    private final kotlin.properties.f M;

    @NotNull
    private final kotlin.properties.f N;

    @NotNull
    private final kotlin.properties.f O;

    @NotNull
    private final kotlin.properties.f P;

    @NotNull
    private final kotlin.properties.f Q;

    @NotNull
    private final kotlin.properties.f R;

    @NotNull
    private final kotlin.properties.f S;

    @NotNull
    private final kotlin.properties.f T;

    @NotNull
    private final kotlin.properties.f U;

    @NotNull
    private final kotlin.properties.f V;

    @NotNull
    private final kotlin.properties.f W;

    @NotNull
    private final kotlin.properties.f X;

    @NotNull
    private final kotlin.properties.f Y;

    /* renamed from: a, reason: collision with root package name */
    private boolean f46602a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46603b = s0(a.c.f46562a);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46604c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46605d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46606e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46607f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46608g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46609h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46610i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46611j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46612k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46613l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46614m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46615n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46616o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46617p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46618q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46619r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46620s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46621t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46622u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46623v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46624w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46625x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46626y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private final kotlin.properties.f f46627z;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n+ 2 DescriptorRendererOptionsImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererOptionsImpl\n*L\n1#1,73:1\n61#2,6:74\n*E\n"})
    public static final class a<T> extends kotlin.properties.c<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f46628b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, x xVar) {
            super(obj);
            this.f46628b = xVar;
        }

        @Override // kotlin.properties.c
        protected boolean d(kotlin.reflect.n<?> property, T t5, T t6) {
            g0.p(property, "property");
            if (this.f46628b.q0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    public final void r0() {
        this.f46602a = true;
    }

    private final <T> kotlin.properties.f<x, T> s0(T t5) {
        kotlin.properties.a aVar = kotlin.properties.a.f44133a;
        return new a(t5, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 t0(t0 it) {
        g0.p(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(q1 it) {
        g0.p(it, "it");
        return "...";
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.renderer.a A() {
        return (kotlin.reflect.jvm.internal.impl.renderer.a) this.f46603b.a(this, Z[0]);
    }

    @Nullable
    public Function1<q1, String> B() {
        return (Function1) this.f46627z.a(this, Z[24]);
    }

    public boolean C() {
        return ((Boolean) this.J.a(this, Z[34])).booleanValue();
    }

    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> D() {
        return (Set) this.K.a(this, Z[35]);
    }

    public boolean E() {
        return ((Boolean) this.T.a(this, Z[44])).booleanValue();
    }

    public boolean H() {
        return ((Boolean) this.f46622u.a(this, Z[19])).booleanValue();
    }

    public boolean I() {
        return ((Boolean) this.Y.a(this, Z[49])).booleanValue();
    }

    @NotNull
    public Set<DescriptorRendererModifier> J() {
        return (Set) this.f46606e.a(this, Z[3]);
    }

    public boolean K() {
        return ((Boolean) this.f46615n.a(this, Z[12])).booleanValue();
    }

    @NotNull
    public OverrideRenderingPolicy L() {
        return (OverrideRenderingPolicy) this.B.a(this, Z[26]);
    }

    @NotNull
    public ParameterNameRenderingPolicy M() {
        return (ParameterNameRenderingPolicy) this.E.a(this, Z[29]);
    }

    public boolean N() {
        return ((Boolean) this.U.a(this, Z[45])).booleanValue();
    }

    public boolean O() {
        return ((Boolean) this.W.a(this, Z[47])).booleanValue();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy P() {
        return (PropertyAccessorRenderingPolicy) this.H.a(this, Z[32]);
    }

    @Nullable
    public Function1<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>, String> Q() {
        return (Function1) this.f46623v.a(this, Z[20]);
    }

    public boolean R() {
        return ((Boolean) this.F.a(this, Z[30])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.S.a(this, Z[43])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.G.a(this, Z[31])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.f46618q.a(this, Z[15])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.P.a(this, Z[40])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.I.a(this, Z[33])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.f46617p.a(this, Z[14])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f46616o.a(this, Z[13])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.f46619r.a(this, Z[16])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void a(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        g0.p(parameterNameRenderingPolicy, "<set-?>");
        this.E.b(this, Z[29], parameterNameRenderingPolicy);
    }

    public boolean a0() {
        return ((Boolean) this.R.a(this, Z[42])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public boolean b() {
        return ((Boolean) this.f46614m.a(this, Z[11])).booleanValue();
    }

    public boolean b0() {
        return ((Boolean) this.Q.a(this, Z[41])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> c() {
        return (Set) this.L.a(this, Z[36]);
    }

    public boolean c0() {
        return ((Boolean) this.A.a(this, Z[25])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public boolean d() {
        return ((Boolean) this.f46609h.a(this, Z[6])).booleanValue();
    }

    public boolean d0() {
        return ((Boolean) this.f46608g.a(this, Z[5])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    @NotNull
    public AnnotationArgumentsRenderingPolicy e() {
        return (AnnotationArgumentsRenderingPolicy) this.N.a(this, Z[38]);
    }

    public boolean e0() {
        return ((Boolean) this.f46607f.a(this, Z[4])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void f(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set) {
        g0.p(set, "<set-?>");
        this.L.b(this, Z[36], set);
    }

    @NotNull
    public RenderingFormat f0() {
        return (RenderingFormat) this.D.a(this, Z[28]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void g(@NotNull Set<? extends DescriptorRendererModifier> set) {
        g0.p(set, "<set-?>");
        this.f46606e.b(this, Z[3], set);
    }

    @NotNull
    public Function1<t0, t0> g0() {
        return (Function1) this.f46626y.a(this, Z[23]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void h(boolean z5) {
        this.f46609h.b(this, Z[6], Boolean.valueOf(z5));
    }

    public boolean h0() {
        return ((Boolean) this.f46621t.a(this, Z[18])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void i(boolean z5) {
        this.f46624w.b(this, Z[21], Boolean.valueOf(z5));
    }

    public boolean i0() {
        return ((Boolean) this.f46612k.a(this, Z[9])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void j(boolean z5) {
        this.f46607f.b(this, Z[4], Boolean.valueOf(z5));
    }

    @NotNull
    public m.b j0() {
        return (m.b) this.C.a(this, Z[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void k(boolean z5) {
        this.f46604c.b(this, Z[1], Boolean.valueOf(z5));
    }

    public boolean k0() {
        return ((Boolean) this.f46611j.a(this, Z[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void l(boolean z5) {
        this.f46625x.b(this, Z[22], Boolean.valueOf(z5));
    }

    public boolean l0() {
        return ((Boolean) this.f46604c.a(this, Z[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void m(boolean z5) {
        this.F.b(this, Z[30], Boolean.valueOf(z5));
    }

    public boolean m0() {
        return ((Boolean) this.f46605d.a(this, Z[2])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void n(@NotNull RenderingFormat renderingFormat) {
        g0.p(renderingFormat, "<set-?>");
        this.D.b(this, Z[28], renderingFormat);
    }

    public boolean n0() {
        return ((Boolean) this.f46613l.a(this, Z[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void o(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        g0.p(annotationArgumentsRenderingPolicy, "<set-?>");
        this.N.b(this, Z[38], annotationArgumentsRenderingPolicy);
    }

    public boolean o0() {
        return ((Boolean) this.f46625x.a(this, Z[22])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void p(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        g0.p(aVar, "<set-?>");
        this.f46603b.b(this, Z[0], aVar);
    }

    public boolean p0() {
        return ((Boolean) this.f46624w.a(this, Z[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void q(boolean z5) {
        this.G.b(this, Z[31], Boolean.valueOf(z5));
    }

    public final boolean q0() {
        return this.f46602a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void setVerbose(boolean z5) {
        this.f46611j.b(this, Z[8], Boolean.valueOf(z5));
    }

    @NotNull
    public final x t() {
        x xVar = new x();
        Iterator a6 = kotlin.jvm.internal.h.a(x.class.getDeclaredFields());
        while (a6.hasNext()) {
            Field field = (Field) a6.next();
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                kotlin.properties.c cVar = obj instanceof kotlin.properties.c ? (kotlin.properties.c) obj : null;
                if (cVar != null) {
                    String name = field.getName();
                    g0.o(name, "getName(...)");
                    kotlin.text.u.H2(name, "is", false, 2, null);
                    kotlin.reflect.d d6 = o0.d(x.class);
                    String name2 = field.getName();
                    StringBuilder sb = new StringBuilder();
                    sb.append(l3.f4736f);
                    String name3 = field.getName();
                    g0.o(name3, "getName(...)");
                    if (name3.length() > 0) {
                        char upperCase = Character.toUpperCase(name3.charAt(0));
                        String substring = name3.substring(1);
                        g0.o(substring, "substring(...)");
                        name3 = upperCase + substring;
                    }
                    sb.append(name3);
                    field.set(xVar, xVar.s0(cVar.a(this, new PropertyReference1Impl(d6, name2, sb.toString()))));
                }
            }
        }
        return xVar;
    }

    public boolean v() {
        return ((Boolean) this.f46620s.a(this, Z[17])).booleanValue();
    }

    public boolean w() {
        return ((Boolean) this.O.a(this, Z[39])).booleanValue();
    }

    @Nullable
    public Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> x() {
        return (Function1) this.M.a(this, Z[37]);
    }

    public boolean y() {
        return ((Boolean) this.X.a(this, Z[48])).booleanValue();
    }

    public boolean z() {
        return ((Boolean) this.f46610i.a(this, Z[7])).booleanValue();
    }

    public x() {
        Boolean bool = Boolean.TRUE;
        this.f46604c = s0(bool);
        this.f46605d = s0(bool);
        this.f46606e = s0(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f46607f = s0(bool2);
        this.f46608g = s0(bool2);
        this.f46609h = s0(bool2);
        this.f46610i = s0(bool2);
        this.f46611j = s0(bool2);
        this.f46612k = s0(bool);
        this.f46613l = s0(bool2);
        this.f46614m = s0(bool2);
        this.f46615n = s0(bool2);
        this.f46616o = s0(bool);
        this.f46617p = s0(bool);
        this.f46618q = s0(bool2);
        this.f46619r = s0(bool2);
        this.f46620s = s0(bool2);
        this.f46621t = s0(bool2);
        this.f46622u = s0(bool2);
        this.f46623v = s0(null);
        this.f46624w = s0(bool2);
        this.f46625x = s0(bool2);
        this.f46626y = s0(v.f46600a);
        this.f46627z = s0(w.f46601a);
        this.A = s0(bool);
        this.B = s0(OverrideRenderingPolicy.RENDER_OPEN);
        this.C = s0(m.b.a.f46587a);
        this.D = s0(RenderingFormat.PLAIN);
        this.E = s0(ParameterNameRenderingPolicy.ALL);
        this.F = s0(bool2);
        this.G = s0(bool2);
        this.H = s0(PropertyAccessorRenderingPolicy.DEBUG);
        this.I = s0(bool2);
        this.J = s0(bool2);
        this.K = s0(u1.k());
        this.L = s0(y.f46629a.a());
        this.M = s0(null);
        this.N = s0(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
        this.O = s0(bool2);
        this.P = s0(bool);
        this.Q = s0(bool);
        this.R = s0(bool2);
        this.S = s0(bool2);
        this.T = s0(bool);
        this.U = s0(bool);
        this.V = s0(bool2);
        this.W = s0(bool2);
        this.X = s0(bool2);
        this.Y = s0(bool);
    }

    public boolean F() {
        return u.a.a(this);
    }

    public boolean G() {
        return u.a.b(this);
    }
}
