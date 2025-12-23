package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h extends d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f45891d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final k0 f45892e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.f f45893f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f45894g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class a implements x.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.h$a$a, reason: collision with other inner class name */
        public static final class C0893a implements x.a {

            /* renamed from: a, reason: collision with root package name */
            private final /* synthetic */ x.a f45896a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ x.a f45897b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f45898c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f45899d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f45900e;

            C0893a(x.a aVar, a aVar2, kotlin.reflect.jvm.internal.impl.name.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                this.f45897b = aVar;
                this.f45898c = aVar2;
                this.f45899d = fVar;
                this.f45900e = arrayList;
                this.f45896a = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.b enumClassId, kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                kotlin.jvm.internal.g0.p(enumClassId, "enumClassId");
                kotlin.jvm.internal.g0.p(enumEntryName, "enumEntryName");
                this.f45896a.a(fVar, enumClassId, enumEntryName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public x.a b(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.b classId) {
                kotlin.jvm.internal.g0.p(classId, "classId");
                return this.f45896a.b(fVar, classId);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public void c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.g0.p(value, "value");
                this.f45896a.c(fVar, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public void d(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
                this.f45896a.d(fVar, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public x.b e(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                return this.f45896a.e(fVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
            public void visitEnd() {
                this.f45897b.visitEnd();
                this.f45898c.g(this.f45899d, new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) kotlin.collections.f0.m5(this.f45900e)));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b implements x.b {

            /* renamed from: a, reason: collision with root package name */
            private final ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f45901a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f45902b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f45903c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f45904d;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.h$a$b$a, reason: collision with other inner class name */
            public static final class C0894a implements x.a {

                /* renamed from: a, reason: collision with root package name */
                private final /* synthetic */ x.a f45905a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ x.a f45906b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ b f45907c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f45908d;

                C0894a(x.a aVar, b bVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                    this.f45906b = aVar;
                    this.f45907c = bVar;
                    this.f45908d = arrayList;
                    this.f45905a = aVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.b enumClassId, kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                    kotlin.jvm.internal.g0.p(enumClassId, "enumClassId");
                    kotlin.jvm.internal.g0.p(enumEntryName, "enumEntryName");
                    this.f45905a.a(fVar, enumClassId, enumEntryName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public x.a b(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.b classId) {
                    kotlin.jvm.internal.g0.p(classId, "classId");
                    return this.f45905a.b(fVar, classId);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public void c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                    kotlin.jvm.internal.g0.p(value, "value");
                    this.f45905a.c(fVar, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public void d(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
                    this.f45905a.d(fVar, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public x.b e(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                    return this.f45905a.e(fVar);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
                public void visitEnd() {
                    this.f45906b.visitEnd();
                    this.f45907c.f45901a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) kotlin.collections.f0.m5(this.f45908d)));
                }
            }

            b(h hVar, kotlin.reflect.jvm.internal.impl.name.f fVar, a aVar) {
                this.f45902b = hVar;
                this.f45903c = fVar;
                this.f45904d = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
            public void a(Object obj) {
                this.f45901a.add(this.f45902b.O(this.f45903c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
            public x.a b(kotlin.reflect.jvm.internal.impl.name.b classId) {
                kotlin.jvm.internal.g0.p(classId, "classId");
                ArrayList arrayList = new ArrayList();
                h hVar = this.f45902b;
                e1 NO_SOURCE = e1.f44683a;
                kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
                x.a x5 = hVar.x(classId, NO_SOURCE, arrayList);
                kotlin.jvm.internal.g0.m(x5);
                return new C0894a(x5, this, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
            public void c(kotlin.reflect.jvm.internal.impl.name.b enumClassId, kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
                kotlin.jvm.internal.g0.p(enumClassId, "enumClassId");
                kotlin.jvm.internal.g0.p(enumEntryName, "enumEntryName");
                this.f45901a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.k(enumClassId, enumEntryName));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
            public void d(kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
                kotlin.jvm.internal.g0.p(value, "value");
                this.f45901a.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.t(value));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
            public void visitEnd() {
                this.f45904d.f(this.f45903c, this.f45901a);
            }
        }

        public abstract void f(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arrayList);

        public abstract void g(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar);

        public a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void a(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
            kotlin.jvm.internal.g0.p(enumClassId, "enumClassId");
            kotlin.jvm.internal.g0.p(enumEntryName, "enumEntryName");
            g(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.k(enumClassId, enumEntryName));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.a b(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            ArrayList arrayList = new ArrayList();
            h hVar = h.this;
            e1 NO_SOURCE = e1.f44683a;
            kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
            x.a x5 = hVar.x(classId, NO_SOURCE, arrayList);
            kotlin.jvm.internal.g0.m(x5);
            return new C0893a(x5, this, fVar, arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void c(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f value) {
            kotlin.jvm.internal.g0.p(value, "value");
            g(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.t(value));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj) {
            g(fVar, h.this.O(fVar, obj));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.b e(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar) {
            return new b(h.this, fVar, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBinaryClassAnnotationAndConstantLoaderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryClassAnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/load/kotlin/BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,245:1\n808#2,11:246\n1634#2,3:257\n*S KotlinDebug\n*F\n+ 1 BinaryClassAnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/load/kotlin/BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1\n*L\n93#1:246,11\n93#1:257,3\n*E\n"})
    public static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private final HashMap<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f45909b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f45911d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.b f45912e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f45913f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e1 f45914g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.name.b bVar, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list, e1 e1Var) {
            super();
            this.f45911d = dVar;
            this.f45912e = bVar;
            this.f45913f = list;
            this.f45914g = e1Var;
            this.f45909b = new HashMap<>();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.h.a
        public void f(kotlin.reflect.jvm.internal.impl.name.f fVar, ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> elements) {
            kotlin.jvm.internal.g0.p(elements, "elements");
            if (fVar == null) {
                return;
            }
            q1 b6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, this.f45911d);
            if (b6 != null) {
                HashMap<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> hashMap = this.f45909b;
                kotlin.reflect.jvm.internal.impl.resolve.constants.i iVar = kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a;
                List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> c6 = kotlin.reflect.jvm.internal.impl.utils.a.c(elements);
                t0 type = b6.getType();
                kotlin.jvm.internal.g0.o(type, "getType(...)");
                hashMap.put(fVar, iVar.c(c6, type));
                return;
            }
            if (h.this.w(this.f45912e) && kotlin.jvm.internal.g0.g(fVar.b(), "value")) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : elements) {
                    if (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
                        arrayList.add(obj);
                    }
                }
                List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list = this.f45913f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add(((kotlin.reflect.jvm.internal.impl.resolve.constants.a) it.next()).a());
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.h.a
        public void g(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> value) {
            kotlin.jvm.internal.g0.p(value, "value");
            if (fVar != null) {
                this.f45909b.put(fVar, value);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void visitEnd() {
            if (h.this.F(this.f45912e, this.f45909b) || h.this.w(this.f45912e)) {
                return;
            }
            this.f45913f.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(this.f45911d.s(), this.f45909b, this.f45914g));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull k0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull v kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f45891d = module;
        this.f45892e = notFoundClasses;
        this.f45893f = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.f(module, notFoundClasses);
        this.f45894g = kotlin.reflect.jvm.internal.impl.metadata.deserialization.c.f46236i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> O(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> e6 = kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a.e(obj, this.f45891d);
        if (e6 != null) {
            return e6;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.l.f46670b.a("Unsupported annotation argument: " + fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d R(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.d(this.f45891d, bVar, this.f45892e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.e, kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c k(@NotNull ProtoBuf.Annotation proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        return this.f45893f.a(proto, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d
    @Nullable
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> I(@NotNull String desc, @NotNull Object initializer) {
        kotlin.jvm.internal.g0.p(desc, "desc");
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        if (kotlin.text.u.l3("ZBCS", desc, false, 2, null)) {
            int intValue = ((Integer) initializer).intValue();
            int hashCode = desc.hashCode();
            if (hashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 67) {
                if (desc.equals("C")) {
                    initializer = Character.valueOf((char) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 83) {
                if (desc.equals(ExifInterface.LATITUDE_SOUTH)) {
                    initializer = Short.valueOf((short) intValue);
                }
                throw new AssertionError(desc);
            }
            if (hashCode == 90 && desc.equals("Z")) {
                initializer = Boolean.valueOf(intValue != 0);
            }
            throw new AssertionError(desc);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a.e(initializer, this.f45891d);
    }

    public void S(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar) {
        kotlin.jvm.internal.g0.p(cVar, "<set-?>");
        this.f45894g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.d
    @Nullable
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> M(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> constant) {
        kotlin.jvm.internal.g0.p(constant, "constant");
        return constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.d ? new kotlin.reflect.jvm.internal.impl.resolve.constants.b0(((kotlin.reflect.jvm.internal.impl.resolve.constants.d) constant).a().byteValue()) : constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.x ? new kotlin.reflect.jvm.internal.impl.resolve.constants.e0(((kotlin.reflect.jvm.internal.impl.resolve.constants.x) constant).a().shortValue()) : constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n ? new kotlin.reflect.jvm.internal.impl.resolve.constants.c0(((kotlin.reflect.jvm.internal.impl.resolve.constants.n) constant).a().intValue()) : constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.u ? new kotlin.reflect.jvm.internal.impl.resolve.constants.d0(((kotlin.reflect.jvm.internal.impl.resolve.constants.u) constant).a().longValue()) : constant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.c v() {
        return this.f45894g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.e
    @Nullable
    protected x.a x(@NotNull kotlin.reflect.jvm.internal.impl.name.b annotationClassId, @NotNull e1 source, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> result) {
        kotlin.jvm.internal.g0.p(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.g0.p(source, "source");
        kotlin.jvm.internal.g0.p(result, "result");
        return new b(R(annotationClassId), annotationClassId, result, source);
    }
}
