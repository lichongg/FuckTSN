package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,181:1\n1563#2:182\n1634#2,3:183\n1563#2:186\n1634#2,2:187\n1636#2:190\n1563#2:191\n1634#2,3:192\n1563#2:195\n1634#2,3:196\n1#3:189\n11318#4:199\n11429#4,4:200\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n*L\n28#1:182\n28#1:183,3\n35#1:186\n35#1:187,2\n35#1:190\n37#1:191\n37#1:192,3\n20#1:195\n20#1:196,3\n53#1:199\n53#1:200,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AnnotationConstructorCaller implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f44272a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<String> f44273b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final CallMode f44274c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<Method> f44275d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<Type> f44276e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<Class<?>> f44277f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<Object> f44278g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CallMode {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ CallMode[] $VALUES;
        public static final CallMode CALL_BY_NAME = new CallMode("CALL_BY_NAME", 0);
        public static final CallMode POSITIONAL_CALL = new CallMode("POSITIONAL_CALL", 1);

        private static final /* synthetic */ CallMode[] $values() {
            return new CallMode[]{CALL_BY_NAME, POSITIONAL_CALL};
        }

        static {
            CallMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static CallMode valueOf(String str) {
            return (CallMode) Enum.valueOf(CallMode.class, str);
        }

        public static CallMode[] values() {
            return (CallMode[]) $VALUES.clone();
        }

        private CallMode(String str, int i6) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Origin {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ Origin[] $VALUES;
        public static final Origin JAVA = new Origin("JAVA", 0);
        public static final Origin KOTLIN = new Origin("KOTLIN", 1);

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{JAVA, KOTLIN};
        }

        static {
            Origin[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static Origin valueOf(String str) {
            return (Origin) Enum.valueOf(Origin.class, str);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }

        private Origin(String str, int i6) {
        }
    }

    public AnnotationConstructorCaller(@NotNull Class<?> jClass, @NotNull List<String> parameterNames, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> methods) {
        g0.p(jClass, "jClass");
        g0.p(parameterNames, "parameterNames");
        g0.p(callMode, "callMode");
        g0.p(origin, "origin");
        g0.p(methods, "methods");
        this.f44272a = jClass;
        this.f44273b = parameterNames;
        this.f44274c = callMode;
        this.f44275d = methods;
        List<Method> list = methods;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f44276e = arrayList;
        List<Method> list2 = this.f44275d;
        ArrayList arrayList2 = new ArrayList(f0.d0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            g0.m(returnType);
            Class<?> k6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.k(returnType);
            if (k6 != null) {
                returnType = k6;
            }
            arrayList2.add(returnType);
        }
        this.f44277f = arrayList2;
        List<Method> list3 = this.f44275d;
        ArrayList arrayList3 = new ArrayList(f0.d0(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f44278g = arrayList3;
        if (this.f44274c == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && !f0.v4(this.f44273b, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    public boolean f() {
        return false;
    }

    @Nullable
    public Void g() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public List<Type> b() {
        return this.f44276e;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @Nullable
    public Object call(@NotNull Object[] args) {
        g0.p(args, "args");
        d(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            Object obj = args[i6];
            int i8 = i7 + 1;
            Object q5 = (obj == null && this.f44274c == CallMode.CALL_BY_NAME) ? this.f44278g.get(i7) : e.q(obj, this.f44277f.get(i7));
            if (q5 == null) {
                e.p(i7, this.f44273b.get(i7), this.f44277f.get(i7));
                throw new KotlinNothingValueException();
            }
            arrayList.add(q5);
            i6++;
            i7 = i8;
        }
        return e.g(this.f44272a, i1.B0(f0.o6(this.f44273b, arrayList)), this.f44275d);
    }

    public void e(Object[] args) {
        g0.p(args, "args");
        if (i.a(this) == args.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + i.a(this) + " arguments, but " + args.length + " were provided.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public Type getReturnType() {
        return this.f44272a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public boolean a() {
        return f();
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public /* bridge */ /* synthetic */ Member c() {
        return (Member) g();
    }

    public void d(@NotNull Object[] objArr) {
        e(objArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, kotlin.jvm.internal.v r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L32
            r11 = r8
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = kotlin.collections.f0.d0(r11, r13)
            r12.<init>(r13)
            java.util.Iterator r11 = r11.iterator()
        L16:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L2b
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r12.add(r13)
            goto L16
        L2b:
            r5 = r12
        L2c:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            goto L34
        L32:
            r5 = r11
            goto L2c
        L34:
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, kotlin.jvm.internal.v):void");
    }
}
