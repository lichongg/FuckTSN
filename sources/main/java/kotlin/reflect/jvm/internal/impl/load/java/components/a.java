package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a, reason: collision with other inner class name */
    static class C0887a extends kotlin.reflect.jvm.internal.impl.resolve.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f45373a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f45374b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f45375c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a$a, reason: collision with other inner class name */
        class C0888a implements Function1<CallableMemberDescriptor, n1> {
            private static /* synthetic */ void a(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            C0888a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public n1 invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    a(0);
                }
                C0887a.this.f45373a.a(callableMemberDescriptor);
                return n1.f44123a;
            }
        }

        private static /* synthetic */ void f(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "fromSuper";
            } else if (i6 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i6 == 3) {
                objArr[0] = "member";
            } else if (i6 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i6 == 1 || i6 == 2) {
                objArr[2] = "conflict";
            } else if (i6 == 3 || i6 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        C0887a(v vVar, Set set, boolean z5) {
            this.f45373a = vVar;
            this.f45374b = set;
            this.f45375c = z5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.m
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                f(0);
            }
            OverridingUtil.K(callableMemberDescriptor, new C0888a());
            this.f45374b.add(callableMemberDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.m
        public void d(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection) {
            if (callableMemberDescriptor == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f45375c || callableMemberDescriptor.h() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                super.d(callableMemberDescriptor, collection);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.l
        public void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
            if (callableMemberDescriptor == null) {
                f(1);
            }
            if (callableMemberDescriptor2 == null) {
                f(2);
            }
        }
    }

    private static /* synthetic */ void a(int i6) {
        String str = i6 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 18 ? 3 : 2];
        switch (i6) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i6 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i6) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 == 18) {
            throw new IllegalStateException(format);
        }
    }

    @Nullable
    public static q1 b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (fVar == null) {
            a(19);
        }
        if (dVar == null) {
            a(20);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f6 = dVar.f();
        if (f6.size() != 1) {
            return null;
        }
        for (q1 q1Var : f6.iterator().next().g()) {
            if (q1Var.getName().equals(fVar)) {
                return q1Var;
            }
        }
        return null;
    }

    @NotNull
    private static <D extends CallableMemberDescriptor> Collection<D> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull v vVar, @NotNull OverridingUtil overridingUtil, boolean z5) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (dVar == null) {
            a(15);
        }
        if (vVar == null) {
            a(16);
        }
        if (overridingUtil == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.v(fVar, collection, collection2, dVar, new C0887a(vVar, linkedHashSet, z5));
        return linkedHashSet;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> d(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull v vVar, @NotNull OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        if (vVar == null) {
            a(4);
        }
        if (overridingUtil == null) {
            a(5);
        }
        return c(fVar, collection, collection2, dVar, vVar, overridingUtil, false);
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull v vVar, @NotNull OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (dVar == null) {
            a(9);
        }
        if (vVar == null) {
            a(10);
        }
        if (overridingUtil == null) {
            a(11);
        }
        return c(fVar, collection, collection2, dVar, vVar, overridingUtil, true);
    }
}
