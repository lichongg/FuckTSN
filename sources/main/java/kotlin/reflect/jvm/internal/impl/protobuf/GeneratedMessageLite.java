package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class GeneratedMessageLite extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements d<MessageType> {
        private final g<e> extensions;

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<e, Object>> f46439a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f46440b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f46441c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z5, a aVar) {
                this(z5);
            }

            private a(boolean z5) {
                Iterator<Map.Entry<e, Object>> p5 = ExtendableMessage.this.extensions.p();
                this.f46439a = p5;
                if (p5.hasNext()) {
                    this.f46440b = p5.next();
                }
                this.f46441c = z5;
            }

            public void a(int i6, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f46440b;
                    if (entry == null || entry.getKey().getNumber() >= i6) {
                        return;
                    }
                    e key = this.f46440b.getKey();
                    if (this.f46441c && key.B() == WireFormat.JavaType.MESSAGE && !key.H()) {
                        codedOutputStream.j0(key.getNumber(), (n) this.f46440b.getValue());
                    } else {
                        g.z(key, this.f46440b.getValue(), codedOutputStream);
                    }
                    if (this.f46439a.hasNext()) {
                        this.f46440b = this.f46439a.next();
                    } else {
                        this.f46440b = null;
                    }
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = g.t();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            Object h6 = this.extensions.h(fVar.f46455d);
            return h6 == null ? fVar.f46453b : (Type) fVar.a(h6);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.k();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected void makeExtensionsImmutable() {
            this.extensions.q();
        }

        protected ExtendableMessage<MessageType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i6) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, h(), eVar, codedOutputStream, fVar, i6);
        }

        protected ExtendableMessage(c<MessageType, ?> cVar) {
            this.extensions = cVar.o();
        }

        private void verifyExtensionContainingType(f<MessageType, ?> fVar) {
            if (fVar.b() == h()) {
            } else {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.j(fVar.f46455d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.m(fVar.f46455d);
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i6) {
            verifyExtensionContainingType(fVar);
            return (Type) fVar.e(this.extensions.i(fVar.f46455d, i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends a.AbstractC0905a<BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d f46444a = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public abstract MessageType h();

        public abstract BuilderType k(MessageType messagetype);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
        /* renamed from: g */
        public BuilderType p() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.d i() {
            return this.f46444a;
        }

        public final BuilderType l(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f46444a = dVar;
            return this;
        }

        protected b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class c<MessageType extends ExtendableMessage<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements d<MessageType> {

        /* renamed from: b, reason: collision with root package name */
        private g<e> f46445b = g.g();

        /* renamed from: c, reason: collision with root package name */
        private boolean f46446c;

        /* JADX INFO: Access modifiers changed from: private */
        public g<e> o() {
            this.f46445b.q();
            this.f46446c = false;
            return this.f46445b;
        }

        private void q() {
            if (this.f46446c) {
                return;
            }
            this.f46445b = this.f46445b.clone();
            this.f46446c = true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        public BuilderType p() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean s() {
            return this.f46445b.n();
        }

        protected c() {
        }

        private void v(f<MessageType, ?> fVar) {
            if (fVar.b() == h()) {
            } else {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType n(f<MessageType, List<Type>> fVar, Type type) {
            v(fVar);
            q();
            this.f46445b.a(fVar.f46455d, fVar.f(type));
            return this;
        }

        protected final void t(MessageType messagetype) {
            q();
            this.f46445b.r(((ExtendableMessage) messagetype).extensions);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType u(f<MessageType, Type> fVar, Type type) {
            v(fVar);
            q();
            this.f46445b.v(fVar.f46455d, fVar.g(type));
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d<MessageType extends ExtendableMessage> extends o {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e implements g.b<e> {

        /* renamed from: a, reason: collision with root package name */
        final h.b<?> f46447a;

        /* renamed from: b, reason: collision with root package name */
        final int f46448b;

        /* renamed from: c, reason: collision with root package name */
        final WireFormat.FieldType f46449c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f46450d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f46451e;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public WireFormat.FieldType A() {
            return this.f46449c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public WireFormat.JavaType B() {
            return this.f46449c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public n.a G(n.a aVar, n nVar) {
            return ((b) aVar).k((GeneratedMessageLite) nVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean H() {
            return this.f46450d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean P() {
            return this.f46451e;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f46448b - eVar.f46448b;
        }

        public h.b<?> b() {
            return this.f46447a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public int getNumber() {
            return this.f46448b;
        }

        e(h.b<?> bVar, int i6, WireFormat.FieldType fieldType, boolean z5, boolean z6) {
            this.f46447a = bVar;
            this.f46448b = i6;
            this.f46449c = fieldType;
            this.f46450d = z5;
            this.f46451e = z6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f<ContainingType extends n, Type> {

        /* renamed from: a, reason: collision with root package name */
        final ContainingType f46452a;

        /* renamed from: b, reason: collision with root package name */
        final Type f46453b;

        /* renamed from: c, reason: collision with root package name */
        final n f46454c;

        /* renamed from: d, reason: collision with root package name */
        final e f46455d;

        /* renamed from: e, reason: collision with root package name */
        final Class f46456e;

        /* renamed from: f, reason: collision with root package name */
        final Method f46457f;

        Object a(Object obj) {
            if (!this.f46455d.H()) {
                return e(obj);
            }
            if (this.f46455d.B() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.f46452a;
        }

        public n c() {
            return this.f46454c;
        }

        public int d() {
            return this.f46455d.getNumber();
        }

        Object e(Object obj) {
            return this.f46455d.B() == WireFormat.JavaType.ENUM ? GeneratedMessageLite.invokeOrDie(this.f46457f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f46455d.B() == WireFormat.JavaType.ENUM ? Integer.valueOf(((h.a) obj).getNumber()) : obj;
        }

        Object g(Object obj) {
            if (!this.f46455d.H()) {
                return f(obj);
            }
            if (this.f46455d.B() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(f(it.next()));
            }
            return arrayList;
        }

        f(ContainingType containingtype, Type type, n nVar, e eVar, Class cls) {
            if (containingtype != null) {
                if (eVar.A() == WireFormat.FieldType.MESSAGE && nVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f46452a = containingtype;
                this.f46453b = type;
                this.f46454c = nVar;
                this.f46455d = eVar;
                this.f46456e = cls;
                if (h.a.class.isAssignableFrom(cls)) {
                    this.f46457f = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.f46457f = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    protected GeneratedMessageLite() {
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, n nVar, h.b<?> bVar, int i6, WireFormat.FieldType fieldType, boolean z5, Class cls) {
        return new f<>(containingtype, Collections.EMPTY_LIST, nVar, new e(bVar, i6, fieldType, true, z5), cls);
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, n nVar, h.b<?> bVar, int i6, WireFormat.FieldType fieldType, Class cls) {
        return new f<>(containingtype, type, nVar, new e(bVar, i6, fieldType, false, false), cls);
    }

    protected boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i6) throws IOException {
        return eVar.P(i6, codedOutputStream);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46443a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f46443a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46443a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected GeneratedMessageLite(b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.n> boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e> r5, MessageType r6, kotlin.reflect.jvm.internal.impl.protobuf.e r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.f r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.g, kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f, int):boolean");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public p<? extends n> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e6) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + valueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(valueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e6);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e6);
        } catch (InvocationTargetException e7) {
            Throwable cause = e7.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected void makeExtensionsImmutable() {
    }
}
