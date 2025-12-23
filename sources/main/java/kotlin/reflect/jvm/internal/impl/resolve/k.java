package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k implements Comparator<kotlin.reflect.jvm.internal.impl.descriptors.k> {

    /* renamed from: a, reason: collision with root package name */
    public static final k f46721a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.renderer.m f46722b = kotlin.reflect.jvm.internal.impl.renderer.m.f46574a.b(new a());

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f46723c = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Function1<kotlin.reflect.jvm.internal.impl.renderer.u, n1> {
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n1 invoke(kotlin.reflect.jvm.internal.impl.renderer.u uVar) {
            uVar.k(false);
            uVar.setVerbose(true);
            uVar.o(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            uVar.g(DescriptorRendererModifier.ALL);
            return n1.f44123a;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements Comparator<kotlin.reflect.jvm.internal.impl.descriptors.k> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f46724a = new b();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static Integer c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            int d6 = d(kVar2) - d(kVar);
            if (d6 != 0) {
                return Integer.valueOf(d6);
            }
            if (i.B(kVar) && i.B(kVar2)) {
                return 0;
            }
            int compareTo = kVar.getName().compareTo(kVar2.getName());
            if (compareTo != 0) {
                return Integer.valueOf(compareTo);
            }
            return null;
        }

        private static int d(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (i.B(kVar)) {
                return 8;
            }
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                return 7;
            }
            if (kVar instanceof w0) {
                if (((w0) kVar).f0() == null) {
                    return 6;
                }
                return 5;
            }
            if (kVar instanceof y) {
                if (((y) kVar).f0() == null) {
                    return 4;
                }
                return 3;
            }
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return 2;
            }
            if (kVar instanceof i1) {
                return 1;
            }
            return 0;
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            Integer c6 = c(kVar, kVar2);
            if (c6 != null) {
                return c6.intValue();
            }
            return 0;
        }
    }

    private k() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        int ordinal;
        Integer c6 = b.c(kVar, kVar2);
        if (c6 != null) {
            return c6.intValue();
        }
        if ((kVar instanceof i1) && (kVar2 instanceof i1)) {
            kotlin.reflect.jvm.internal.impl.renderer.m mVar = f46722b;
            int compareTo = mVar.T(((i1) kVar).y0()).compareTo(mVar.T(((i1) kVar2).y0()));
            if (compareTo != 0) {
                return compareTo;
            }
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar;
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2;
            z0 f02 = aVar.f0();
            z0 f03 = aVar2.f0();
            if (f02 != null) {
                kotlin.reflect.jvm.internal.impl.renderer.m mVar2 = f46722b;
                int compareTo2 = mVar2.T(f02.getType()).compareTo(mVar2.T(f03.getType()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
            }
            List<q1> g6 = aVar.g();
            List<q1> g7 = aVar2.g();
            for (int i6 = 0; i6 < Math.min(g6.size(), g7.size()); i6++) {
                kotlin.reflect.jvm.internal.impl.renderer.m mVar3 = f46722b;
                int compareTo3 = mVar3.T(g6.get(i6).getType()).compareTo(mVar3.T(g7.get(i6).getType()));
                if (compareTo3 != 0) {
                    return compareTo3;
                }
            }
            int size = g6.size() - g7.size();
            if (size != 0) {
                return size;
            }
            List<j1> typeParameters = aVar.getTypeParameters();
            List<j1> typeParameters2 = aVar2.getTypeParameters();
            for (int i7 = 0; i7 < Math.min(typeParameters.size(), typeParameters2.size()); i7++) {
                List<t0> upperBounds = typeParameters.get(i7).getUpperBounds();
                List<t0> upperBounds2 = typeParameters2.get(i7).getUpperBounds();
                int size2 = upperBounds.size() - upperBounds2.size();
                if (size2 != 0) {
                    return size2;
                }
                for (int i8 = 0; i8 < upperBounds.size(); i8++) {
                    kotlin.reflect.jvm.internal.impl.renderer.m mVar4 = f46722b;
                    int compareTo4 = mVar4.T(upperBounds.get(i8)).compareTo(mVar4.T(upperBounds2.get(i8)));
                    if (compareTo4 != 0) {
                        return compareTo4;
                    }
                }
            }
            int size3 = typeParameters.size() - typeParameters2.size();
            if (size3 != 0) {
                return size3;
            }
            if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof CallableMemberDescriptor) && (ordinal = ((CallableMemberDescriptor) aVar).h().ordinal() - ((CallableMemberDescriptor) aVar2).h().ordinal()) != 0) {
                return ordinal;
            }
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2;
            if (dVar.h().ordinal() != dVar2.h().ordinal()) {
                return dVar.h().ordinal() - dVar2.h().ordinal();
            }
            if (dVar.l0() != dVar2.l0()) {
                if (dVar.l0()) {
                    return 1;
                }
                return -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", kVar, kVar.getClass(), kVar2, kVar2.getClass()));
        }
        kotlin.reflect.jvm.internal.impl.renderer.m mVar5 = f46722b;
        int compareTo5 = mVar5.N(kVar).compareTo(mVar5.N(kVar2));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        return i.g(kVar).getName().compareTo(i.g(kVar2).getName());
    }
}
