package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.a1;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.builtins.i;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.s;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.util.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n2746#2,3:162\n1563#2:165\n1634#2,3:166\n1740#2,3:169\n1563#2:172\n1634#2,3:173\n1761#2,3:176\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor\n*L\n63#1:162,3\n64#1:165\n64#1:166,3\n88#1:169,3\n92#1:172\n92#1:173,3\n106#1:176,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d extends o0 {

    @NotNull
    public static final a E = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFunctionInvokeDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n967#2,7:162\n1563#2:169\n1634#2,3:170\n*S KotlinDebug\n*F\n+ 1 FunctionInvokeDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionInvokeDescriptor$Factory\n*L\n122#1:162,7\n124#1:169\n124#1:170,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final d a(@NotNull b functionClass, boolean z5) {
            g0.p(functionClass, "functionClass");
            List<j1> t5 = functionClass.t();
            d dVar = new d(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z5, null);
            z0 V = functionClass.V();
            List<z0> J = f0.J();
            List<? extends j1> J2 = f0.J();
            ArrayList arrayList = new ArrayList();
            for (Object obj : t5) {
                if (((j1) obj).l() != Variance.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<a1> m6 = f0.m6(arrayList);
            ArrayList arrayList2 = new ArrayList(f0.d0(m6, 10));
            for (a1 a1Var : m6) {
                arrayList2.add(d.E.b(dVar, a1Var.e(), (j1) a1Var.f()));
            }
            dVar.M0(null, V, J, J2, arrayList2, ((j1) f0.u3(t5)).s(), Modality.ABSTRACT, r.f44948e);
            dVar.U0(true);
            return dVar;
        }

        private final q1 b(d dVar, int i6, j1 j1Var) {
            String lowerCase;
            String b6 = j1Var.getName().b();
            g0.o(b6, "asString(...)");
            if (g0.g(b6, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else if (g0.g(b6, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = SocialConstants.PARAM_RECEIVER;
            } else {
                lowerCase = b6.toLowerCase(Locale.ROOT);
                g0.o(lowerCase, "toLowerCase(...)");
            }
            g b7 = g.f44655q0.b();
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(lowerCase);
            g0.o(h6, "identifier(...)");
            e1 s5 = j1Var.s();
            g0.o(s5, "getDefaultType(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.e1 NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a;
            g0.o(NO_SOURCE, "NO_SOURCE");
            return new u0(dVar, null, i6, b7, h6, s5, false, false, false, null, NO_SOURCE);
        }
    }

    public /* synthetic */ d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z5, v vVar) {
        this(kVar, dVar, kind, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean y() {
        return false;
    }

    private d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        super(kVar, dVar, g.f44655q0.b(), t.f47438i, kind, kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a);
        a1(true);
        c1(z5);
        T0(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    protected s G0(@NotNull k newOwner, @Nullable y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull g annotations, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e1 source) {
        g0.p(newOwner, "newOwner");
        g0.p(kind, "kind");
        g0.p(annotations, "annotations");
        g0.p(source, "source");
        return new d(newOwner, (d) yVar, kind, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @Nullable
    protected y H0(@NotNull s.c configuration) {
        g0.p(configuration, "configuration");
        d dVar = (d) super.H0(configuration);
        if (dVar == null) {
            return null;
        }
        List<q1> g6 = dVar.g();
        g0.o(g6, "getValueParameters(...)");
        List<q1> list = g6;
        if ((list instanceof Collection) && list.isEmpty()) {
            return dVar;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t0 type = ((q1) it.next()).getType();
            g0.o(type, "getType(...)");
            if (i.d(type) != null) {
                List<q1> g7 = dVar.g();
                g0.o(g7, "getValueParameters(...)");
                List<q1> list2 = g7;
                ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    t0 type2 = ((q1) it2.next()).getType();
                    g0.o(type2, "getType(...)");
                    arrayList.add(i.d(type2));
                }
                return dVar.k1(arrayList);
            }
        }
        return dVar;
    }

    private final y k1(List<kotlin.reflect.jvm.internal.impl.name.f> list) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        int size = g().size() - list.size();
        boolean z5 = true;
        if (size == 0) {
            List<q1> g6 = g();
            g0.o(g6, "getValueParameters(...)");
            List<Pair> o6 = f0.o6(list, g6);
            if ((o6 instanceof Collection) && o6.isEmpty()) {
                return this;
            }
            for (Pair pair : o6) {
                if (!g0.g((kotlin.reflect.jvm.internal.impl.name.f) pair.component1(), ((q1) pair.component2()).getName())) {
                }
            }
            return this;
        }
        List<q1> g7 = g();
        g0.o(g7, "getValueParameters(...)");
        List<q1> list2 = g7;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        for (q1 q1Var : list2) {
            kotlin.reflect.jvm.internal.impl.name.f name = q1Var.getName();
            g0.o(name, "getName(...)");
            int index = q1Var.getIndex();
            int i6 = index - size;
            if (i6 >= 0 && (fVar = list.get(i6)) != null) {
                name = fVar;
            }
            arrayList.add(q1Var.I(this, name, index));
        }
        s.c N0 = N0(h2.f47263b);
        List<kotlin.reflect.jvm.internal.impl.name.f> list3 = list;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.name.f) it.next()) == null) {
                    break;
                }
            }
        }
        z5 = false;
        s.c i7 = N0.G(z5).n(arrayList).i(a());
        g0.o(i7, "setOriginal(...)");
        y H0 = super.H0(i7);
        g0.m(H0);
        return H0;
    }
}
