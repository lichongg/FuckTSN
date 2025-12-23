package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class JvmProtoBuf {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Constructor, JvmMethodSignature> f46259a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Function, JvmMethodSignature> f46260b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Function, Integer> f46261c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, JvmPropertySignature> f46262d;

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, Integer> f46263e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> f46264f;

    /* renamed from: g, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, Boolean> f46265g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f46266h;

    /* renamed from: i, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f46267i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Property>> f46268j;

    /* renamed from: k, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f46269k;

    /* renamed from: l, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f46270l;

    /* renamed from: m, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Package, Integer> f46271m;

    /* renamed from: n, reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Package, List<ProtoBuf.Property>> f46272n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class JvmFieldSignature extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.jvm.a {
        public static p<JvmFieldSignature> PARSER = new a();
        private static final JvmFieldSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmFieldSignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmFieldSignature d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<JvmFieldSignature, b> implements kotlin.reflect.jvm.internal.impl.metadata.jvm.a {

            /* renamed from: b, reason: collision with root package name */
            private int f46273b;

            /* renamed from: c, reason: collision with root package name */
            private int f46274c;

            /* renamed from: d, reason: collision with root package name */
            private int f46275d;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.k(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.k(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            public JvmFieldSignature o() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this);
                int i6 = this.f46273b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                jvmFieldSignature.name_ = this.f46274c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                jvmFieldSignature.desc_ = this.f46275d;
                jvmFieldSignature.bitField0_ = i7;
                return jvmFieldSignature;
            }

            public b w(int i6) {
                this.f46273b |= 2;
                this.f46275d = i6;
                return this;
            }

            public b x(int i6) {
                this.f46273b |= 1;
                this.f46274c = i6;
                return this;
            }

            private b() {
                t();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmFieldSignature build() {
                JvmFieldSignature o5 = o();
                if (o5.isInitialized()) {
                    return o5;
                }
                throw a.AbstractC0905a.f(o5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            public b p() {
                return q().k(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public JvmFieldSignature h() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b k(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    x(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    w(jvmFieldSignature.getDesc());
                }
                l(i().d(jvmFieldSignature.unknownFields));
                return this;
            }

            private void t() {
            }
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.initFields();
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().k(jvmFieldSignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public JvmFieldSignature h() {
            return defaultInstance;
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.desc_);
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b6 = this.memoizedIsInitialized;
            if (b6 == 1) {
                return true;
            }
            if (b6 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmFieldSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.desc_);
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private JvmFieldSignature(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (K2 != 16) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        K.J();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t5.e();
                        throw th2;
                    }
                    this.unknownFields = t5.e();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                K.J();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t5.e();
                throw th3;
            }
            this.unknownFields = t5.e();
            makeExtensionsImmutable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class JvmMethodSignature extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.jvm.b {
        public static p<JvmMethodSignature> PARSER = new a();
        private static final JvmMethodSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmMethodSignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmMethodSignature d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<JvmMethodSignature, b> implements kotlin.reflect.jvm.internal.impl.metadata.jvm.b {

            /* renamed from: b, reason: collision with root package name */
            private int f46276b;

            /* renamed from: c, reason: collision with root package name */
            private int f46277c;

            /* renamed from: d, reason: collision with root package name */
            private int f46278d;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.k(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.k(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            public JvmMethodSignature o() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this);
                int i6 = this.f46276b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                jvmMethodSignature.name_ = this.f46277c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                jvmMethodSignature.desc_ = this.f46278d;
                jvmMethodSignature.bitField0_ = i7;
                return jvmMethodSignature;
            }

            public b w(int i6) {
                this.f46276b |= 2;
                this.f46278d = i6;
                return this;
            }

            public b x(int i6) {
                this.f46276b |= 1;
                this.f46277c = i6;
                return this;
            }

            private b() {
                t();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmMethodSignature build() {
                JvmMethodSignature o5 = o();
                if (o5.isInitialized()) {
                    return o5;
                }
                throw a.AbstractC0905a.f(o5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            public b p() {
                return q().k(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public JvmMethodSignature h() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b k(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    x(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    w(jvmMethodSignature.getDesc());
                }
                l(i().d(jvmMethodSignature.unknownFields));
                return this;
            }

            private void t() {
            }
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.initFields();
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().k(jvmMethodSignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public JvmMethodSignature h() {
            return defaultInstance;
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.desc_);
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b6 = this.memoizedIsInitialized;
            if (b6 == 1) {
                return true;
            }
            if (b6 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmMethodSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.desc_);
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private JvmMethodSignature(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (K2 != 16) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        K.J();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t5.e();
                        throw th2;
                    }
                    this.unknownFields = t5.e();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                K.J();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t5.e();
                throw th3;
            }
            this.unknownFields = t5.e();
            makeExtensionsImmutable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class JvmPropertySignature extends GeneratedMessageLite implements c {
        public static p<JvmPropertySignature> PARSER = new a();
        private static final JvmPropertySignature defaultInstance;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmPropertySignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public JvmPropertySignature d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<JvmPropertySignature, b> implements c {

            /* renamed from: b, reason: collision with root package name */
            private int f46279b;

            /* renamed from: c, reason: collision with root package name */
            private JvmFieldSignature f46280c = JvmFieldSignature.getDefaultInstance();

            /* renamed from: d, reason: collision with root package name */
            private JvmMethodSignature f46281d = JvmMethodSignature.getDefaultInstance();

            /* renamed from: e, reason: collision with root package name */
            private JvmMethodSignature f46282e = JvmMethodSignature.getDefaultInstance();

            /* renamed from: f, reason: collision with root package name */
            private JvmMethodSignature f46283f = JvmMethodSignature.getDefaultInstance();

            /* renamed from: g, reason: collision with root package name */
            private JvmMethodSignature f46284g = JvmMethodSignature.getDefaultInstance();

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.k(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.k(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            public b A(JvmMethodSignature jvmMethodSignature) {
                if ((this.f46279b & 2) != 2 || this.f46281d == JvmMethodSignature.getDefaultInstance()) {
                    this.f46281d = jvmMethodSignature;
                } else {
                    this.f46281d = JvmMethodSignature.newBuilder(this.f46281d).k(jvmMethodSignature).o();
                }
                this.f46279b |= 2;
                return this;
            }

            public JvmPropertySignature o() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this);
                int i6 = this.f46279b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                jvmPropertySignature.field_ = this.f46280c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.f46281d;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                jvmPropertySignature.getter_ = this.f46282e;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                jvmPropertySignature.setter_ = this.f46283f;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                jvmPropertySignature.delegateMethod_ = this.f46284g;
                jvmPropertySignature.bitField0_ = i7;
                return jvmPropertySignature;
            }

            public b u(JvmMethodSignature jvmMethodSignature) {
                if ((this.f46279b & 16) != 16 || this.f46284g == JvmMethodSignature.getDefaultInstance()) {
                    this.f46284g = jvmMethodSignature;
                } else {
                    this.f46284g = JvmMethodSignature.newBuilder(this.f46284g).k(jvmMethodSignature).o();
                }
                this.f46279b |= 16;
                return this;
            }

            public b v(JvmFieldSignature jvmFieldSignature) {
                if ((this.f46279b & 1) != 1 || this.f46280c == JvmFieldSignature.getDefaultInstance()) {
                    this.f46280c = jvmFieldSignature;
                } else {
                    this.f46280c = JvmFieldSignature.newBuilder(this.f46280c).k(jvmFieldSignature).o();
                }
                this.f46279b |= 1;
                return this;
            }

            public b y(JvmMethodSignature jvmMethodSignature) {
                if ((this.f46279b & 4) != 4 || this.f46282e == JvmMethodSignature.getDefaultInstance()) {
                    this.f46282e = jvmMethodSignature;
                } else {
                    this.f46282e = JvmMethodSignature.newBuilder(this.f46282e).k(jvmMethodSignature).o();
                }
                this.f46279b |= 4;
                return this;
            }

            public b z(JvmMethodSignature jvmMethodSignature) {
                if ((this.f46279b & 8) != 8 || this.f46283f == JvmMethodSignature.getDefaultInstance()) {
                    this.f46283f = jvmMethodSignature;
                } else {
                    this.f46283f = JvmMethodSignature.newBuilder(this.f46283f).k(jvmMethodSignature).o();
                }
                this.f46279b |= 8;
                return this;
            }

            private b() {
                t();
            }

            public b B(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.f46284g = jvmMethodSignature;
                this.f46279b |= 16;
                return this;
            }

            public b C(JvmFieldSignature jvmFieldSignature) {
                jvmFieldSignature.getClass();
                this.f46280c = jvmFieldSignature;
                this.f46279b |= 1;
                return this;
            }

            public b D(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.f46282e = jvmMethodSignature;
                this.f46279b |= 4;
                return this;
            }

            public b E(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.f46283f = jvmMethodSignature;
                this.f46279b |= 8;
                return this;
            }

            public b F(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.f46281d = jvmMethodSignature;
                this.f46279b |= 2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public JvmPropertySignature build() {
                JvmPropertySignature o5 = o();
                if (o5.isInitialized()) {
                    return o5;
                }
                throw a.AbstractC0905a.f(o5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            public b p() {
                return q().k(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public JvmPropertySignature h() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b k(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    v(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    A(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    y(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    z(jvmPropertySignature.getSetter());
                }
                if (jvmPropertySignature.hasDelegateMethod()) {
                    u(jvmPropertySignature.getDelegateMethod());
                }
                l(i().d(jvmPropertySignature.unknownFields));
                return this;
            }

            private void t() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.initFields();
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().k(jvmPropertySignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public JvmPropertySignature h() {
            return defaultInstance;
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int t5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.t(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                t5 += CodedOutputStream.t(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                t5 += CodedOutputStream.t(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                t5 += CodedOutputStream.t(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                t5 += CodedOutputStream.t(5, this.delegateMethod_);
            }
            int size = t5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasDelegateMethod() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b6 = this.memoizedIsInitialized;
            if (b6 == 1) {
                return true;
            }
            if (b6 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private JvmPropertySignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.h0(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.h0(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.h0(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.h0(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.h0(5, this.delegateMethod_);
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private JvmPropertySignature(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 10) {
                                JvmFieldSignature.b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) eVar.u(JvmFieldSignature.PARSER, fVar);
                                this.field_ = jvmFieldSignature;
                                if (builder != null) {
                                    builder.k(jvmFieldSignature);
                                    this.field_ = builder.o();
                                }
                                this.bitField0_ |= 1;
                            } else if (K2 == 18) {
                                JvmMethodSignature.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.syntheticMethod_ = jvmMethodSignature;
                                if (builder2 != null) {
                                    builder2.k(jvmMethodSignature);
                                    this.syntheticMethod_ = builder2.o();
                                }
                                this.bitField0_ |= 2;
                            } else if (K2 == 26) {
                                JvmMethodSignature.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.getter_ = jvmMethodSignature2;
                                if (builder3 != null) {
                                    builder3.k(jvmMethodSignature2);
                                    this.getter_ = builder3.o();
                                }
                                this.bitField0_ |= 4;
                            } else if (K2 == 34) {
                                JvmMethodSignature.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.setter_ = jvmMethodSignature3;
                                if (builder4 != null) {
                                    builder4.k(jvmMethodSignature3);
                                    this.setter_ = builder4.o();
                                }
                                this.bitField0_ |= 8;
                            } else if (K2 != 42) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                JvmMethodSignature.b builder5 = (this.bitField0_ & 16) == 16 ? this.delegateMethod_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature4 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.delegateMethod_ = jvmMethodSignature4;
                                if (builder5 != null) {
                                    builder5.k(jvmMethodSignature4);
                                    this.delegateMethod_ = builder5.o();
                                }
                                this.bitField0_ |= 16;
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        K.J();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t5.e();
                        throw th2;
                    }
                    this.unknownFields = t5.e();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                K.J();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t5.e();
                throw th3;
            }
            this.unknownFields = t5.e();
            makeExtensionsImmutable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class StringTableTypes extends GeneratedMessageLite implements e {
        public static p<StringTableTypes> PARSER = new a();
        private static final StringTableTypes defaultInstance;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Record extends GeneratedMessageLite implements d {
            public static p<Record> PARSER = new a();
            private static final Record defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public enum Operation implements h.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);

                private static h.b<Operation> internalValueMap = new a();
                private final int value;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                static class a implements h.b<Operation> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Operation a(int i6) {
                        return Operation.valueOf(i6);
                    }
                }

                public static Operation valueOf(int i6) {
                    if (i6 == 0) {
                        return NONE;
                    }
                    if (i6 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i6 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                Operation(int i6, int i7) {
                    this.value = i7;
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Record> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public Record d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new Record(eVar, fVar);
                }

                a() {
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static final class b extends GeneratedMessageLite.b<Record, b> implements d {

                /* renamed from: b, reason: collision with root package name */
                private int f46285b;

                /* renamed from: d, reason: collision with root package name */
                private int f46287d;

                /* renamed from: g, reason: collision with root package name */
                private List<Integer> f46290g;

                /* renamed from: h, reason: collision with root package name */
                private List<Integer> f46291h;

                /* renamed from: c, reason: collision with root package name */
                private int f46286c = 1;

                /* renamed from: e, reason: collision with root package name */
                private Object f46288e = "";

                /* renamed from: f, reason: collision with root package name */
                private Operation f46289f = Operation.NONE;

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.k(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.k(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$b");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b q() {
                    return new b();
                }

                private void s() {
                    if ((this.f46285b & 32) != 32) {
                        this.f46291h = new ArrayList(this.f46291h);
                        this.f46285b |= 32;
                    }
                }

                private void t() {
                    if ((this.f46285b & 16) != 16) {
                        this.f46290g = new ArrayList(this.f46290g);
                        this.f46285b |= 16;
                    }
                }

                public b A(int i6) {
                    this.f46285b |= 1;
                    this.f46286c = i6;
                    return this;
                }

                public Record o() {
                    Record record = new Record(this);
                    int i6 = this.f46285b;
                    int i7 = (i6 & 1) != 1 ? 0 : 1;
                    record.range_ = this.f46286c;
                    if ((i6 & 2) == 2) {
                        i7 |= 2;
                    }
                    record.predefinedIndex_ = this.f46287d;
                    if ((i6 & 4) == 4) {
                        i7 |= 4;
                    }
                    record.string_ = this.f46288e;
                    if ((i6 & 8) == 8) {
                        i7 |= 8;
                    }
                    record.operation_ = this.f46289f;
                    if ((this.f46285b & 16) == 16) {
                        this.f46290g = Collections.unmodifiableList(this.f46290g);
                        this.f46285b &= -17;
                    }
                    record.substringIndex_ = this.f46290g;
                    if ((this.f46285b & 32) == 32) {
                        this.f46291h = Collections.unmodifiableList(this.f46291h);
                        this.f46285b &= -33;
                    }
                    record.replaceChar_ = this.f46291h;
                    record.bitField0_ = i7;
                    return record;
                }

                public b z(int i6) {
                    this.f46285b |= 2;
                    this.f46287d = i6;
                    return this;
                }

                private b() {
                    List<Integer> list = Collections.EMPTY_LIST;
                    this.f46290g = list;
                    this.f46291h = list;
                    v();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public Record build() {
                    Record o5 = o();
                    if (o5.isInitialized()) {
                        return o5;
                    }
                    throw a.AbstractC0905a.f(o5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                public b p() {
                    return q().k(o());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public Record h() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public b k(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        A(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        z(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.f46285b |= 4;
                        this.f46288e = record.string_;
                    }
                    if (record.hasOperation()) {
                        y(record.getOperation());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.f46290g.isEmpty()) {
                            this.f46290g = record.substringIndex_;
                            this.f46285b &= -17;
                        } else {
                            t();
                            this.f46290g.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.f46291h.isEmpty()) {
                            this.f46291h = record.replaceChar_;
                            this.f46285b &= -33;
                        } else {
                            s();
                            this.f46291h.addAll(record.replaceChar_);
                        }
                    }
                    l(i().d(record.unknownFields));
                    return this;
                }

                public b y(Operation operation) {
                    operation.getClass();
                    this.f46285b |= 8;
                    this.f46289f = operation;
                    return this;
                }

                private void v() {
                }
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                List<Integer> list = Collections.EMPTY_LIST;
                this.substringIndex_ = list;
                this.replaceChar_ = list;
            }

            public static b newBuilder() {
                return b.q();
            }

            static {
                Record record = new Record(true);
                defaultInstance = record;
                record.initFields();
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            public static b newBuilder(Record record) {
                return newBuilder().k(record);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: getDefaultInstanceForType */
            public Record h() {
                return defaultInstance;
            }

            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public p<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i6 = this.memoizedSerializedSize;
                if (i6 != -1) {
                    return i6;
                }
                int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.range_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    p5 += CodedOutputStream.p(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    p5 += CodedOutputStream.i(3, this.operation_.getNumber());
                }
                int i7 = 0;
                for (int i8 = 0; i8 < this.substringIndex_.size(); i8++) {
                    i7 += CodedOutputStream.q(this.substringIndex_.get(i8).intValue());
                }
                int i9 = p5 + i7;
                if (!getSubstringIndexList().isEmpty()) {
                    i9 = i9 + 1 + CodedOutputStream.q(i7);
                }
                this.substringIndexMemoizedSerializedSize = i7;
                int i10 = 0;
                for (int i11 = 0; i11 < this.replaceChar_.size(); i11++) {
                    i10 += CodedOutputStream.q(this.replaceChar_.get(i11).intValue());
                }
                int i12 = i9 + i10;
                if (!getReplaceCharList().isEmpty()) {
                    i12 = i12 + 1 + CodedOutputStream.q(i10);
                }
                this.replaceCharMemoizedSerializedSize = i10;
                if ((this.bitField0_ & 4) == 4) {
                    i12 += CodedOutputStream.e(6, getStringBytes());
                }
                int size = i12 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String z5 = dVar.z();
                if (dVar.q()) {
                    this.string_ = z5;
                }
                return z5;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d j6 = kotlin.reflect.jvm.internal.impl.protobuf.d.j((String) obj);
                this.string_ = j6;
                return j6;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                byte b6 = this.memoizedIsInitialized;
                if (b6 == 1) {
                    return true;
                }
                if (b6 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Record(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.i();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.e0(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.e0(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.W(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.s0(34);
                    codedOutputStream.s0(this.substringIndexMemoizedSerializedSize);
                }
                for (int i6 = 0; i6 < this.substringIndex_.size(); i6++) {
                    codedOutputStream.f0(this.substringIndex_.get(i6).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.s0(42);
                    codedOutputStream.s0(this.replaceCharMemoizedSerializedSize);
                }
                for (int i7 = 0; i7 < this.replaceChar_.size(); i7++) {
                    codedOutputStream.f0(this.replaceChar_.get(i7).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.S(6, getStringBytes());
                }
                codedOutputStream.m0(this.unknownFields);
            }

            private Record(boolean z5) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
                CodedOutputStream K = CodedOutputStream.K(t5, 1);
                boolean z5 = false;
                int i6 = 0;
                while (!z5) {
                    try {
                        try {
                            int K2 = eVar.K();
                            if (K2 != 0) {
                                if (K2 == 8) {
                                    this.bitField0_ |= 1;
                                    this.range_ = eVar.s();
                                } else if (K2 == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = eVar.s();
                                } else if (K2 == 24) {
                                    int n6 = eVar.n();
                                    Operation valueOf = Operation.valueOf(n6);
                                    if (valueOf == null) {
                                        K.s0(K2);
                                        K.s0(n6);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = valueOf;
                                    }
                                } else if (K2 == 32) {
                                    if ((i6 & 16) != 16) {
                                        this.substringIndex_ = new ArrayList();
                                        i6 |= 16;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                } else if (K2 == 34) {
                                    int j6 = eVar.j(eVar.A());
                                    if ((i6 & 16) != 16 && eVar.e() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        i6 |= 16;
                                    }
                                    while (eVar.e() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j6);
                                } else if (K2 == 40) {
                                    if ((i6 & 32) != 32) {
                                        this.replaceChar_ = new ArrayList();
                                        i6 |= 32;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                } else if (K2 == 42) {
                                    int j7 = eVar.j(eVar.A());
                                    if ((i6 & 32) != 32 && eVar.e() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        i6 |= 32;
                                    }
                                    while (eVar.e() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j7);
                                } else if (K2 != 50) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    kotlin.reflect.jvm.internal.impl.protobuf.d l6 = eVar.l();
                                    this.bitField0_ |= 4;
                                    this.string_ = l6;
                                }
                            }
                            z5 = true;
                        } catch (InvalidProtocolBufferException e6) {
                            throw e6.setUnfinishedMessage(this);
                        } catch (IOException e7) {
                            throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if ((i6 & 16) == 16) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if ((i6 & 32) == 32) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        }
                        try {
                            K.J();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = t5.e();
                            throw th2;
                        }
                        this.unknownFields = t5.e();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                if ((i6 & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i6 & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    K.J();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = t5.e();
                    throw th3;
                }
                this.unknownFields = t5.e();
                makeExtensionsImmutable();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<StringTableTypes> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public StringTableTypes d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new StringTableTypes(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<StringTableTypes, b> implements e {

            /* renamed from: b, reason: collision with root package name */
            private int f46292b;

            /* renamed from: c, reason: collision with root package name */
            private List<Record> f46293c;

            /* renamed from: d, reason: collision with root package name */
            private List<Integer> f46294d;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.k(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.k(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46292b & 2) != 2) {
                    this.f46294d = new ArrayList(this.f46294d);
                    this.f46292b |= 2;
                }
            }

            private void t() {
                if ((this.f46292b & 1) != 1) {
                    this.f46293c = new ArrayList(this.f46293c);
                    this.f46292b |= 1;
                }
            }

            public StringTableTypes o() {
                StringTableTypes stringTableTypes = new StringTableTypes(this);
                if ((this.f46292b & 1) == 1) {
                    this.f46293c = Collections.unmodifiableList(this.f46293c);
                    this.f46292b &= -2;
                }
                stringTableTypes.record_ = this.f46293c;
                if ((this.f46292b & 2) == 2) {
                    this.f46294d = Collections.unmodifiableList(this.f46294d);
                    this.f46292b &= -3;
                }
                stringTableTypes.localName_ = this.f46294d;
                return stringTableTypes;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46293c = list;
                this.f46294d = list;
                v();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public StringTableTypes build() {
                StringTableTypes o5 = o();
                if (o5.isInitialized()) {
                    return o5;
                }
                throw a.AbstractC0905a.f(o5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            public b p() {
                return q().k(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public StringTableTypes h() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b k(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.f46293c.isEmpty()) {
                        this.f46293c = stringTableTypes.record_;
                        this.f46292b &= -2;
                    } else {
                        t();
                        this.f46293c.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.f46294d.isEmpty()) {
                        this.f46294d = stringTableTypes.localName_;
                        this.f46292b &= -3;
                    } else {
                        s();
                        this.f46294d.addAll(stringTableTypes.localName_);
                    }
                }
                l(i().d(stringTableTypes.unknownFields));
                return this;
            }

            private void v() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            defaultInstance = stringTableTypes;
            stringTableTypes.initFields();
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            List list = Collections.EMPTY_LIST;
            this.record_ = list;
            this.localName_ = list;
        }

        public static b newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().k(stringTableTypes);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public StringTableTypes h() {
            return defaultInstance;
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.record_.size(); i8++) {
                i7 += CodedOutputStream.t(1, this.record_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.localName_.size(); i10++) {
                i9 += CodedOutputStream.q(this.localName_.get(i10).intValue());
            }
            int i11 = i7 + i9;
            if (!getLocalNameList().isEmpty()) {
                i11 = i11 + 1 + CodedOutputStream.q(i9);
            }
            this.localNameMemoizedSerializedSize = i9;
            int size = i11 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b6 = this.memoizedIsInitialized;
            if (b6 == 1) {
                return true;
            }
            if (b6 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private StringTableTypes(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.record_.size(); i6++) {
                codedOutputStream.h0(1, this.record_.get(i6));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.s0(42);
                codedOutputStream.s0(this.localNameMemoizedSerializedSize);
            }
            for (int i7 = 0; i7 < this.localName_.size(); i7++) {
                codedOutputStream.f0(this.localName_.get(i7).intValue());
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private StringTableTypes(boolean z5) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            int i6 = 0;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 10) {
                                if ((i6 & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i6 |= 1;
                                }
                                this.record_.add(eVar.u(Record.PARSER, fVar));
                            } else if (K2 == 40) {
                                if ((i6 & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i6 |= 2;
                                }
                                this.localName_.add(Integer.valueOf(eVar.s()));
                            } else if (K2 != 42) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                int j6 = eVar.j(eVar.A());
                                if ((i6 & 2) != 2 && eVar.e() > 0) {
                                    this.localName_ = new ArrayList();
                                    i6 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.localName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j6);
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i6 & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i6 & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        K.J();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = t5.e();
                        throw th2;
                    }
                    this.unknownFields = t5.e();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if ((i6 & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i6 & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                K.J();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = t5.e();
                throw th3;
            }
            this.unknownFields = t5.e();
            makeExtensionsImmutable();
        }
    }

    public static void a(f fVar) {
        fVar.a(f46259a);
        fVar.a(f46260b);
        fVar.a(f46261c);
        fVar.a(f46262d);
        fVar.a(f46263e);
        fVar.a(f46264f);
        fVar.a(f46265g);
        fVar.a(f46266h);
        fVar.a(f46267i);
        fVar.a(f46268j);
        fVar.a(f46269k);
        fVar.a(f46270l);
        fVar.a(f46271m);
        fVar.a(f46272n);
    }

    static {
        ProtoBuf.Constructor defaultInstance = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature defaultInstance2 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature defaultInstance3 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        f46259a = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, fieldType, JvmMethodSignature.class);
        f46260b = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, fieldType, JvmMethodSignature.class);
        ProtoBuf.Function defaultInstance4 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType fieldType2 = WireFormat.FieldType.INT32;
        f46261c = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, fieldType2, Integer.class);
        f46262d = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, fieldType, JvmPropertySignature.class);
        f46263e = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f46264f = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f46265g = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        f46266h = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f46267i = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f46268j = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
        f46269k = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, fieldType2, Integer.class);
        f46270l = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, fieldType2, Integer.class);
        f46271m = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f46272n = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
    }
}
