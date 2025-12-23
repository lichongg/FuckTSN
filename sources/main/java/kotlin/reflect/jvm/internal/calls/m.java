package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.calls.h;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.p3;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,392:1\n1761#2,3:393\n1563#2:396\n1634#2,3:397\n1761#2,3:409\n1634#2,3:412\n37#3:400\n36#3,3:401\n37#3:405\n36#3,3:406\n37#3:415\n36#3,3:416\n1#4:404\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller\n*L\n45#1:393,3\n48#1:396\n48#1:397,3\n166#1:409,3\n184#1:412,3\n48#1:400\n48#1:401,3\n155#1:405\n155#1:406,3\n192#1:415\n192#1:416,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m<M extends Member> implements g<M> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f44309a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final g<M> f44310b;

    /* renamed from: c, reason: collision with root package name */
    private final M f44311c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final a f44312d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.ranges.m[] f44313e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44314f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.ranges.m f44315a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<Method>[] f44316b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final Method f44317c;

        public a(@NotNull kotlin.ranges.m argumentRange, @NotNull List<Method>[] unboxParameters, @Nullable Method method) {
            g0.p(argumentRange, "argumentRange");
            g0.p(unboxParameters, "unboxParameters");
            this.f44315a = argumentRange;
            this.f44316b = unboxParameters;
            this.f44317c = method;
        }

        @NotNull
        public final kotlin.ranges.m a() {
            return this.f44315a;
        }

        @Nullable
        public final Method b() {
            return this.f44317c;
        }

        @NotNull
        public final List<Method>[] c() {
            return this.f44316b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,392:1\n1563#2:393\n1634#2,3:394\n1573#2:397\n1604#2,3:398\n1563#2:401\n1634#2,3:402\n1607#2:405\n1374#2:406\n1460#2,2:407\n1563#2:409\n1634#2,3:410\n1462#2,3:413\n37#3:416\n36#3,3:417\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller\n*L\n224#1:393\n224#1:394,3\n232#1:397\n232#1:398,3\n234#1:401\n234#1:402,3\n232#1:405\n241#1:406\n241#1:407,2\n241#1:409\n241#1:410,3\n241#1:413,3\n241#1:416\n241#1:417,3\n*E\n"})
    public static final class b implements g {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Method f44318a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final Method f44319b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<List<Method>> f44320c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final List<List<Class<?>>> f44321d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final List<Type> f44322e;

        public boolean d() {
            return false;
        }

        @Nullable
        public Void e() {
            return null;
        }

        public b(@NotNull y descriptor, @NotNull KDeclarationContainerImpl container, @NotNull String constructorDesc, @NotNull List<? extends t0> originalParameters) {
            Collection l6;
            List p5;
            g0.p(descriptor, "descriptor");
            g0.p(container, "container");
            g0.p(constructorDesc, "constructorDesc");
            g0.p(originalParameters, "originalParameters");
            Method K = container.K("constructor-impl", constructorDesc);
            g0.m(K);
            this.f44318a = K;
            Method K2 = container.K("box-impl", u.B4(constructorDesc, ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(container.c()));
            g0.m(K2);
            this.f44319b = K2;
            List<? extends t0> list = originalParameters;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.t0 type = ((t0) it.next()).getType();
                g0.o(type, "getType(...)");
                p5 = n.p(g2.a(type), descriptor);
                arrayList.add(p5);
            }
            this.f44320c = arrayList;
            ArrayList arrayList2 = new ArrayList(f0.d0(list, 10));
            int i6 = 0;
            for (Object obj : list) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f0.b0();
                }
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((t0) obj).getType().I0().c();
                g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
                List<Method> list2 = this.f44320c.get(i6);
                if (list2 != null) {
                    List<Method> list3 = list2;
                    l6 = new ArrayList(f0.d0(list3, 10));
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        l6.add(((Method) it2.next()).getReturnType());
                    }
                } else {
                    Class<?> s5 = p3.s(dVar);
                    g0.m(s5);
                    l6 = f0.l(s5);
                }
                arrayList2.add(l6);
                i6 = i7;
            }
            this.f44321d = arrayList2;
            this.f44322e = f0.f0(arrayList2);
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @NotNull
        public List<Type> b() {
            return this.f44322e;
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            Collection l6;
            g0.p(args, "args");
            List<Pair> UA = kotlin.collections.n.UA(args, this.f44320c);
            ArrayList arrayList = new ArrayList();
            for (Pair pair : UA) {
                Object component1 = pair.component1();
                List list = (List) pair.component2();
                if (list != null) {
                    List list2 = list;
                    l6 = new ArrayList(f0.d0(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        l6.add(((Method) it.next()).invoke(component1, null));
                    }
                } else {
                    l6 = f0.l(component1);
                }
                f0.s0(arrayList, l6);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            this.f44318a.invoke(null, Arrays.copyOf(array, array.length));
            return this.f44319b.invoke(null, Arrays.copyOf(array, array.length));
        }

        @NotNull
        public final List<List<Class<?>>> f() {
            return this.f44321d;
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @NotNull
        public Type getReturnType() {
            Class<?> returnType = this.f44319b.getReturnType();
            g0.o(returnType, "getReturnType(...)");
            return returnType;
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        public boolean a() {
            return d();
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        public /* bridge */ /* synthetic */ Member c() {
            return (Member) e();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x010f, code lost:
    
        if ((r12 instanceof kotlin.reflect.jvm.internal.calls.f) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d6, code lost:
    
        r13 = kotlin.reflect.jvm.internal.calls.n.t(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public m(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.g<? extends M> r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.m.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.g, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.d makeKotlinParameterTypes) {
        g0.p(makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return kotlin.reflect.jvm.internal.impl.resolve.j.g(makeKotlinParameterTypes);
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public boolean a() {
        return this.f44310b instanceof h.AbstractC0872h.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public List<Type> b() {
        return this.f44310b.b();
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public M c() {
        return this.f44311c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @Nullable
    public Object call(@NotNull Object[] args) {
        Object invoke;
        Object obj;
        Object g6;
        g0.p(args, "args");
        kotlin.ranges.m a6 = this.f44312d.a();
        List<Method>[] c6 = this.f44312d.c();
        Method b6 = this.f44312d.b();
        if (!a6.isEmpty()) {
            if (this.f44314f) {
                List k6 = f0.k(args.length);
                int e6 = a6.e();
                for (int i6 = 0; i6 < e6; i6++) {
                    k6.add(args[i6]);
                }
                int e7 = a6.e();
                int f6 = a6.f();
                if (e7 <= f6) {
                    while (true) {
                        List<Method> list = c6[e7];
                        Object obj2 = args[e7];
                        if (list != null) {
                            for (Method method : list) {
                                List list2 = k6;
                                if (obj2 != null) {
                                    g6 = method.invoke(obj2, null);
                                } else {
                                    Class<?> returnType = method.getReturnType();
                                    g0.o(returnType, "getReturnType(...)");
                                    g6 = p3.g(returnType);
                                }
                                list2.add(g6);
                            }
                        } else {
                            k6.add(obj2);
                        }
                        if (e7 == f6) {
                            break;
                        }
                        e7++;
                    }
                }
                int f7 = a6.f() + 1;
                int Oe = kotlin.collections.n.Oe(args);
                if (f7 <= Oe) {
                    while (true) {
                        k6.add(args[f7]);
                        if (f7 == Oe) {
                            break;
                        }
                        f7++;
                    }
                }
                args = f0.b(k6).toArray(new Object[0]);
            } else {
                int length = args.length;
                Object[] objArr = new Object[length];
                for (int i7 = 0; i7 < length; i7++) {
                    int e8 = a6.e();
                    if (i7 > a6.f() || e8 > i7) {
                        obj = args[i7];
                    } else {
                        List<Method> list3 = c6[i7];
                        Method method2 = list3 != null ? (Method) f0.m5(list3) : null;
                        obj = args[i7];
                        if (method2 != null) {
                            if (obj != null) {
                                obj = method2.invoke(obj, null);
                            } else {
                                Class<?> returnType2 = method2.getReturnType();
                                g0.o(returnType2, "getReturnType(...)");
                                obj = p3.g(returnType2);
                            }
                        }
                    }
                    objArr[i7] = obj;
                }
                args = objArr;
            }
        }
        Object call = this.f44310b.call(args);
        return (call == kotlin.coroutines.intrinsics.a.l() || b6 == null || (invoke = b6.invoke(null, call)) == null) ? call : invoke;
    }

    @NotNull
    public final kotlin.ranges.m f(int i6) {
        if (i6 >= 0) {
            kotlin.ranges.m[] mVarArr = this.f44313e;
            if (i6 < mVarArr.length) {
                return mVarArr[i6];
            }
        }
        kotlin.ranges.m[] mVarArr2 = this.f44313e;
        if (mVarArr2.length == 0) {
            return new kotlin.ranges.m(i6, i6);
        }
        int length = (i6 - mVarArr2.length) + ((kotlin.ranges.m) kotlin.collections.n.Th(mVarArr2)).f() + 1;
        return new kotlin.ranges.m(length, length);
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public Type getReturnType() {
        return this.f44310b.getReturnType();
    }
}
