package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.MemberKind;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.km.q;
import kotlin.reflect.jvm.internal.impl.km.s;
import kotlin.reflect.jvm.internal.impl.km.t;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.v;
import kotlin.reflect.jvm.internal.impl.km.y;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFlagDelegatesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/FlagDelegatesImplKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1563#2:89\n1634#2,3:90\n1563#2:93\n1634#2,3:94\n1563#2:97\n1634#2,3:98\n*S KotlinDebug\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/FlagDelegatesImplKt\n*L\n50#1:89\n50#1:90,3\n53#1:93\n53#1:94,3\n56#1:97\n56#1:98,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<kotlin.reflect.jvm.internal.impl.km.g> a(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.a
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.g) obj).i());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.g) obj).r(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<kotlin.reflect.jvm.internal.impl.km.j> b(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.b
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((kotlin.reflect.jvm.internal.impl.km.j) obj).c());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((kotlin.reflect.jvm.internal.impl.km.j) obj).f(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<q> c(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.c
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((q) obj).j(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final <Node> kotlin.reflect.jvm.internal.impl.km.internal.b<Node, MemberKind> d(@NotNull kotlin.reflect.l<Node, Integer> flags) {
        g0.p(flags, "flags");
        b.d<ProtoBuf.MemberKind> MEMBER_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46221p;
        g0.o(MEMBER_KIND, "MEMBER_KIND");
        kotlin.enums.a<MemberKind> entries = MemberKind.getEntries();
        kotlin.enums.a<MemberKind> entries2 = MemberKind.getEntries();
        ArrayList arrayList = new ArrayList(f0.d0(entries2, 10));
        Iterator<E> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MemberKind) it.next()).getFlag$kotlin_metadata());
        }
        return new kotlin.reflect.jvm.internal.impl.km.internal.b<>(flags, MEMBER_KIND, entries, arrayList);
    }

    @NotNull
    public static final <Node> kotlin.reflect.jvm.internal.impl.km.internal.b<Node, Modality> e(@NotNull kotlin.reflect.l<Node, Integer> flags) {
        g0.p(flags, "flags");
        b.d<ProtoBuf.Modality> MODALITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e;
        g0.o(MODALITY, "MODALITY");
        kotlin.enums.a<Modality> entries = Modality.getEntries();
        kotlin.enums.a<Modality> entries2 = Modality.getEntries();
        ArrayList arrayList = new ArrayList(f0.d0(entries2, 10));
        Iterator<E> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Modality) it.next()).getFlag$kotlin_metadata());
        }
        return new kotlin.reflect.jvm.internal.impl.km.internal.b<>(flags, MODALITY, entries, arrayList);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<t> f(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.d
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((t) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((t) obj).c(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<s> g(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.e
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).g());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((s) obj).q(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<v> h(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.f
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((v) obj).b());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((v) obj).f(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<u> i(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.g
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((u) obj).e());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((u) obj).j(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.a<y> j(@NotNull kotlin.reflect.jvm.internal.impl.km.internal.d flag) {
        g0.p(flag, "flag");
        return new kotlin.reflect.jvm.internal.impl.km.internal.a<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.c.h
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return Integer.valueOf(((y) obj).c());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
            public void set(Object obj, Object obj2) {
                ((y) obj).g(((Number) obj2).intValue());
            }
        }, flag);
    }

    @NotNull
    public static final <Node> kotlin.reflect.jvm.internal.impl.km.internal.b<Node, Visibility> k(@NotNull kotlin.reflect.l<Node, Integer> flags) {
        g0.p(flags, "flags");
        b.d<ProtoBuf.Visibility> VISIBILITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d;
        g0.o(VISIBILITY, "VISIBILITY");
        kotlin.enums.a<Visibility> entries = Visibility.getEntries();
        kotlin.enums.a<Visibility> entries2 = Visibility.getEntries();
        ArrayList arrayList = new ArrayList(f0.d0(entries2, 10));
        Iterator<E> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Visibility) it.next()).getFlag$kotlin_metadata());
        }
        return new kotlin.reflect.jvm.internal.impl.km.internal.b<>(flags, VISIBILITY, entries, arrayList);
    }
}
