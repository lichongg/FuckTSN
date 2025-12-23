package kotlin.reflect.jvm.internal.impl.metadata;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ProtoBuf {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Annotation extends GeneratedMessageLite implements c {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> PARSER = new a();
        private static final Annotation defaultInstance;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Argument extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.b {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
            private Value value_;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static final class Value extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.a {
                public static kotlin.reflect.jvm.internal.impl.protobuf.p<Value> PARSER = new a();
                private static final Value defaultInstance;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                public enum Type implements h.a {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);

                    private static h.b<Type> internalValueMap = new a();
                    private final int value;

                    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                    static class a implements h.b<Type> {
                        a() {
                        }

                        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                        /* renamed from: b, reason: merged with bridge method [inline-methods] */
                        public Type a(int i6) {
                            return Type.valueOf(i6);
                        }
                    }

                    public static Type valueOf(int i6) {
                        switch (i6) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                    public final int getNumber() {
                        return this.value;
                    }

                    Type(int i6, int i7) {
                        this.value = i7;
                    }
                }

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Value> {
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                    /* renamed from: m, reason: merged with bridge method [inline-methods] */
                    public Value d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                        return new Value(eVar, fVar);
                    }

                    a() {
                    }
                }

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                public static final class b extends GeneratedMessageLite.b<Value, b> implements kotlin.reflect.jvm.internal.impl.metadata.a {

                    /* renamed from: b, reason: collision with root package name */
                    private int f46013b;

                    /* renamed from: d, reason: collision with root package name */
                    private long f46015d;

                    /* renamed from: e, reason: collision with root package name */
                    private float f46016e;

                    /* renamed from: f, reason: collision with root package name */
                    private double f46017f;

                    /* renamed from: g, reason: collision with root package name */
                    private int f46018g;

                    /* renamed from: h, reason: collision with root package name */
                    private int f46019h;

                    /* renamed from: i, reason: collision with root package name */
                    private int f46020i;

                    /* renamed from: l, reason: collision with root package name */
                    private int f46023l;

                    /* renamed from: m, reason: collision with root package name */
                    private int f46024m;

                    /* renamed from: c, reason: collision with root package name */
                    private Type f46014c = Type.BYTE;

                    /* renamed from: j, reason: collision with root package name */
                    private Annotation f46021j = Annotation.getDefaultInstance();

                    /* renamed from: k, reason: collision with root package name */
                    private List<Value> f46022k = Collections.EMPTY_LIST;

                    /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
                    /* renamed from: C, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                        /*
                            r2 = this;
                            r0 = 0
                            kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4     // Catch: java.lang.Throwable -> Lf
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
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b.d(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value$b");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static b s() {
                        return new b();
                    }

                    private void t() {
                        if ((this.f46013b & 256) != 256) {
                            this.f46022k = new ArrayList(this.f46022k);
                            this.f46013b |= 256;
                        }
                    }

                    public b A(Annotation annotation) {
                        if ((this.f46013b & 128) != 128 || this.f46021j == Annotation.getDefaultInstance()) {
                            this.f46021j = annotation;
                        } else {
                            this.f46021j = Annotation.newBuilder(this.f46021j).k(annotation).p();
                        }
                        this.f46013b |= 128;
                        return this;
                    }

                    public b E(int i6) {
                        this.f46013b |= 512;
                        this.f46023l = i6;
                        return this;
                    }

                    public b F(int i6) {
                        this.f46013b |= 32;
                        this.f46019h = i6;
                        return this;
                    }

                    public b G(double d6) {
                        this.f46013b |= 8;
                        this.f46017f = d6;
                        return this;
                    }

                    public b H(int i6) {
                        this.f46013b |= 64;
                        this.f46020i = i6;
                        return this;
                    }

                    public b I(int i6) {
                        this.f46013b |= 1024;
                        this.f46024m = i6;
                        return this;
                    }

                    public b J(float f6) {
                        this.f46013b |= 4;
                        this.f46016e = f6;
                        return this;
                    }

                    public b K(long j6) {
                        this.f46013b |= 2;
                        this.f46015d = j6;
                        return this;
                    }

                    public b L(int i6) {
                        this.f46013b |= 16;
                        this.f46018g = i6;
                        return this;
                    }

                    public Value p() {
                        Value value = new Value(this);
                        int i6 = this.f46013b;
                        int i7 = (i6 & 1) != 1 ? 0 : 1;
                        value.type_ = this.f46014c;
                        if ((i6 & 2) == 2) {
                            i7 |= 2;
                        }
                        value.intValue_ = this.f46015d;
                        if ((i6 & 4) == 4) {
                            i7 |= 4;
                        }
                        value.floatValue_ = this.f46016e;
                        if ((i6 & 8) == 8) {
                            i7 |= 8;
                        }
                        value.doubleValue_ = this.f46017f;
                        if ((i6 & 16) == 16) {
                            i7 |= 16;
                        }
                        value.stringValue_ = this.f46018g;
                        if ((i6 & 32) == 32) {
                            i7 |= 32;
                        }
                        value.classId_ = this.f46019h;
                        if ((i6 & 64) == 64) {
                            i7 |= 64;
                        }
                        value.enumValueId_ = this.f46020i;
                        if ((i6 & 128) == 128) {
                            i7 |= 128;
                        }
                        value.annotation_ = this.f46021j;
                        if ((this.f46013b & 256) == 256) {
                            this.f46022k = Collections.unmodifiableList(this.f46022k);
                            this.f46013b &= -257;
                        }
                        value.arrayElement_ = this.f46022k;
                        if ((i6 & 512) == 512) {
                            i7 |= 256;
                        }
                        value.arrayDimensionCount_ = this.f46023l;
                        if ((i6 & 1024) == 1024) {
                            i7 |= 512;
                        }
                        value.flags_ = this.f46024m;
                        value.bitField0_ = i7;
                        return value;
                    }

                    public Annotation u() {
                        return this.f46021j;
                    }

                    public Value v(int i6) {
                        return this.f46022k.get(i6);
                    }

                    public int w() {
                        return this.f46022k.size();
                    }

                    public boolean y() {
                        return (this.f46013b & 128) == 128;
                    }

                    private b() {
                        z();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: B, reason: merged with bridge method [inline-methods] */
                    public b k(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            M(value.getType());
                        }
                        if (value.hasIntValue()) {
                            K(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            J(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            G(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            L(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            F(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            H(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            A(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.f46022k.isEmpty()) {
                                this.f46022k = value.arrayElement_;
                                this.f46013b &= -257;
                            } else {
                                t();
                                this.f46022k.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            E(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            I(value.getFlags());
                        }
                        l(i().d(value.unknownFields));
                        return this;
                    }

                    public b D(Annotation annotation) {
                        annotation.getClass();
                        this.f46021j = annotation;
                        this.f46013b |= 128;
                        return this;
                    }

                    public b M(Type type) {
                        type.getClass();
                        this.f46013b |= 1;
                        this.f46014c = type;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                    public final boolean isInitialized() {
                        if (y() && !u().isInitialized()) {
                            return false;
                        }
                        for (int i6 = 0; i6 < w(); i6++) {
                            if (!v(i6).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public b n(b bVar) {
                        t();
                        this.f46022k.add(bVar.build());
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                    /* renamed from: o, reason: merged with bridge method [inline-methods] */
                    public Value build() {
                        Value p5 = p();
                        if (p5.isInitialized()) {
                            return p5;
                        }
                        throw a.AbstractC0905a.f(p5);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                    public b p() {
                        return s().k(p());
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                    public Value h() {
                        return Value.getDefaultInstance();
                    }

                    private void z() {
                    }
                }

                public static b newBuilder() {
                    return b.s();
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.EMPTY_LIST;
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static b newBuilder(Value value) {
                    return newBuilder().k(value);
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int i6) {
                    return this.arrayElement_.get(i6);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                /* renamed from: getDefaultInstanceForType */
                public Value h() {
                    return defaultInstance;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
                public kotlin.reflect.jvm.internal.impl.protobuf.p<Value> getParserForType() {
                    return PARSER;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public int getSerializedSize() {
                    int i6 = this.memoizedSerializedSize;
                    if (i6 != -1) {
                        return i6;
                    }
                    int i7 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.i(1, this.type_.getNumber()) : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        i7 += CodedOutputStream.B(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        i7 += CodedOutputStream.m(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        i7 += CodedOutputStream.g(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        i7 += CodedOutputStream.p(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        i7 += CodedOutputStream.p(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        i7 += CodedOutputStream.p(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        i7 += CodedOutputStream.t(8, this.annotation_);
                    }
                    for (int i8 = 0; i8 < this.arrayElement_.size(); i8++) {
                        i7 += CodedOutputStream.t(9, this.arrayElement_.get(i8));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        i7 += CodedOutputStream.p(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        i7 += CodedOutputStream.p(11, this.arrayDimensionCount_);
                    }
                    int size = i7 + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public boolean hasType() {
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
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i6 = 0; i6 < getArrayElementCount(); i6++) {
                        if (!getArrayElement(i6).isInitialized()) {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
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

                private Value(GeneratedMessageLite.b bVar) {
                    super(bVar);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = bVar.i();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.W(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.x0(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.a0(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.U(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.e0(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.e0(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.e0(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.h0(8, this.annotation_);
                    }
                    for (int i6 = 0; i6 < this.arrayElement_.size(); i6++) {
                        codedOutputStream.h0(9, this.arrayElement_.get(i6));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.e0(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.e0(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.m0(this.unknownFields);
                }

                private Value(boolean z5) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r5v0 */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
                private Value(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
                    CodedOutputStream K = CodedOutputStream.K(t5, 1);
                    boolean z5 = false;
                    char c6 = 0;
                    while (true) {
                        ?? r5 = 256;
                        if (!z5) {
                            try {
                                try {
                                    int K2 = eVar.K();
                                    switch (K2) {
                                        case 0:
                                            z5 = true;
                                        case 8:
                                            int n6 = eVar.n();
                                            Type valueOf = Type.valueOf(n6);
                                            if (valueOf == null) {
                                                K.s0(K2);
                                                K.s0(n6);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = valueOf;
                                            }
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = eVar.H();
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = eVar.q();
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = eVar.m();
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = eVar.s();
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = eVar.s();
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = eVar.s();
                                        case 66:
                                            b builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            Annotation annotation = (Annotation) eVar.u(Annotation.PARSER, fVar);
                                            this.annotation_ = annotation;
                                            if (builder != null) {
                                                builder.k(annotation);
                                                this.annotation_ = builder.p();
                                            }
                                            this.bitField0_ |= 128;
                                        case 74:
                                            if ((c6 & 256) != 256) {
                                                this.arrayElement_ = new ArrayList();
                                                c6 = 256;
                                            }
                                            this.arrayElement_.add(eVar.u(PARSER, fVar));
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = eVar.s();
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = eVar.s();
                                        default:
                                            r5 = parseUnknownField(eVar, K, fVar, K2);
                                            if (r5 == 0) {
                                                z5 = true;
                                            }
                                    }
                                } catch (InvalidProtocolBufferException e6) {
                                    throw e6.setUnfinishedMessage(this);
                                } catch (IOException e7) {
                                    throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                                }
                            } catch (Throwable th) {
                                if ((c6 & 256) == r5) {
                                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                        } else {
                            if ((c6 & 256) == 256) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                            return;
                        }
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public Argument d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }

                a() {
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements kotlin.reflect.jvm.internal.impl.metadata.b {

                /* renamed from: b, reason: collision with root package name */
                private int f46025b;

                /* renamed from: c, reason: collision with root package name */
                private int f46026c;

                /* renamed from: d, reason: collision with root package name */
                private Value f46027d = Value.getDefaultInstance();

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$b");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b q() {
                    return new b();
                }

                public b A(int i6) {
                    this.f46025b |= 1;
                    this.f46026c = i6;
                    return this;
                }

                public Argument o() {
                    Argument argument = new Argument(this);
                    int i6 = this.f46025b;
                    int i7 = (i6 & 1) != 1 ? 0 : 1;
                    argument.nameId_ = this.f46026c;
                    if ((i6 & 2) == 2) {
                        i7 |= 2;
                    }
                    argument.value_ = this.f46027d;
                    argument.bitField0_ = i7;
                    return argument;
                }

                public Value t() {
                    return this.f46027d;
                }

                public boolean u() {
                    return (this.f46025b & 1) == 1;
                }

                public boolean v() {
                    return (this.f46025b & 2) == 2;
                }

                public b z(Value value) {
                    if ((this.f46025b & 2) != 2 || this.f46027d == Value.getDefaultInstance()) {
                        this.f46027d = value;
                    } else {
                        this.f46027d = Value.newBuilder(this.f46027d).k(value).p();
                    }
                    this.f46025b |= 2;
                    return this;
                }

                private b() {
                    w();
                }

                public b B(Value value) {
                    value.getClass();
                    this.f46027d = value;
                    this.f46025b |= 2;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    if (!u() || !v() || !t().isInitialized()) {
                        return false;
                    }
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public Argument build() {
                    Argument o5 = o();
                    if (o5.isInitialized()) {
                        return o5;
                    }
                    throw a.AbstractC0905a.f(o5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public b p() {
                    return q().k(o());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public Argument h() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public b k(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        A(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        z(argument.getValue());
                    }
                    l(i().d(argument.unknownFields));
                    return this;
                }

                private void w() {
                }
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static b newBuilder() {
                return b.q();
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().k(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: getDefaultInstanceForType */
            public Argument h() {
                return defaultInstance;
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i6 = this.memoizedSerializedSize;
                if (i6 != -1) {
                    return i6;
                }
                int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    p5 += CodedOutputStream.t(2, this.value_);
                }
                int size = p5 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
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
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.i();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.e0(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.h0(2, this.value_);
                }
                codedOutputStream.m0(this.unknownFields);
            }

            private Argument(boolean z5) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                    this.nameId_ = eVar.s();
                                } else if (K2 != 18) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    Value.b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                    Value value = (Value) eVar.u(Value.PARSER, fVar);
                                    this.value_ = value;
                                    if (builder != null) {
                                        builder.k(value);
                                        this.value_ = builder.p();
                                    }
                                    this.bitField0_ |= 2;
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
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Annotation> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Annotation d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Annotation(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<Annotation, b> implements c {

            /* renamed from: b, reason: collision with root package name */
            private int f46028b;

            /* renamed from: c, reason: collision with root package name */
            private int f46029c;

            /* renamed from: d, reason: collision with root package name */
            private List<Argument> f46030d = Collections.EMPTY_LIST;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b s() {
                return new b();
            }

            private void t() {
                if ((this.f46028b & 2) != 2) {
                    this.f46030d = new ArrayList(this.f46030d);
                    this.f46028b |= 2;
                }
            }

            public b B(int i6) {
                this.f46028b |= 1;
                this.f46029c = i6;
                return this;
            }

            public Annotation p() {
                Annotation annotation = new Annotation(this);
                int i6 = (this.f46028b & 1) != 1 ? 0 : 1;
                annotation.id_ = this.f46029c;
                if ((this.f46028b & 2) == 2) {
                    this.f46030d = Collections.unmodifiableList(this.f46030d);
                    this.f46028b &= -3;
                }
                annotation.argument_ = this.f46030d;
                annotation.bitField0_ = i6;
                return annotation;
            }

            public Argument u(int i6) {
                return this.f46030d.get(i6);
            }

            public int v() {
                return this.f46030d.size();
            }

            public boolean x() {
                return (this.f46028b & 1) == 1;
            }

            private b() {
                y();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!x()) {
                    return false;
                }
                for (int i6 = 0; i6 < v(); i6++) {
                    if (!u(i6).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public b n(Argument.b bVar) {
                t();
                this.f46030d.add(bVar.build());
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Annotation build() {
                Annotation p5 = p();
                if (p5.isInitialized()) {
                    return p5;
                }
                throw a.AbstractC0905a.f(p5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b p() {
                return s().k(p());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public Annotation h() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b k(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    B(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.f46030d.isEmpty()) {
                        this.f46030d = annotation.argument_;
                        this.f46028b &= -3;
                    } else {
                        t();
                        this.f46030d.addAll(annotation.argument_);
                    }
                }
                l(i().d(annotation.unknownFields));
                return this;
            }

            private void y() {
            }
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.EMPTY_LIST;
        }

        public static b newBuilder() {
            return b.s();
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(Annotation annotation) {
            return newBuilder().k(annotation);
        }

        public Argument getArgument(int i6) {
            return this.argument_.get(i6);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Annotation h() {
            return defaultInstance;
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.id_) : 0;
            for (int i7 = 0; i7 < this.argument_.size(); i7++) {
                p5 += CodedOutputStream.t(2, this.argument_.get(i7));
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getArgumentCount(); i6++) {
                if (!getArgument(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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

        private Annotation(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.id_);
            }
            for (int i6 = 0; i6 < this.argument_.size(); i6++) {
                codedOutputStream.h0(2, this.argument_.get(i6));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private Annotation(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            char c6 = 0;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = eVar.s();
                            } else if (K2 != 18) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                if ((c6 & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    c6 = 2;
                                }
                                this.argument_.add(eVar.u(Argument.PARSER, fVar));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((c6 & 2) == 2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
            if ((c6 & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements d {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Class> PARSER = new a();
        private static final Class defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int companionObjectName_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum Kind implements h.a {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);

            private static h.b<Kind> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<Kind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Kind a(int i6) {
                    return Kind.valueOf(i6);
                }
            }

            public static Kind valueOf(int i6) {
                switch (i6) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            Kind(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Class> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Class d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Class(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Class, b> implements d {
            private TypeTable A;
            private List<Integer> B;
            private VersionRequirementTable C;
            private List<CompilerPluginData> D;

            /* renamed from: d, reason: collision with root package name */
            private int f46031d;

            /* renamed from: e, reason: collision with root package name */
            private int f46032e = 6;

            /* renamed from: f, reason: collision with root package name */
            private int f46033f;

            /* renamed from: g, reason: collision with root package name */
            private int f46034g;

            /* renamed from: h, reason: collision with root package name */
            private List<TypeParameter> f46035h;

            /* renamed from: i, reason: collision with root package name */
            private List<Type> f46036i;

            /* renamed from: j, reason: collision with root package name */
            private List<Integer> f46037j;

            /* renamed from: k, reason: collision with root package name */
            private List<Integer> f46038k;

            /* renamed from: l, reason: collision with root package name */
            private List<Type> f46039l;

            /* renamed from: m, reason: collision with root package name */
            private List<Integer> f46040m;

            /* renamed from: n, reason: collision with root package name */
            private List<Constructor> f46041n;

            /* renamed from: o, reason: collision with root package name */
            private List<Function> f46042o;

            /* renamed from: p, reason: collision with root package name */
            private List<Property> f46043p;

            /* renamed from: q, reason: collision with root package name */
            private List<TypeAlias> f46044q;

            /* renamed from: r, reason: collision with root package name */
            private List<EnumEntry> f46045r;

            /* renamed from: s, reason: collision with root package name */
            private List<Integer> f46046s;

            /* renamed from: t, reason: collision with root package name */
            private int f46047t;

            /* renamed from: u, reason: collision with root package name */
            private Type f46048u;

            /* renamed from: v, reason: collision with root package name */
            private int f46049v;

            /* renamed from: w, reason: collision with root package name */
            private List<Integer> f46050w;

            /* renamed from: x, reason: collision with root package name */
            private List<Type> f46051x;

            /* renamed from: y, reason: collision with root package name */
            private List<Integer> f46052y;

            /* renamed from: z, reason: collision with root package name */
            private List<Annotation> f46053z;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: y0, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46031d & 2097152) != 2097152) {
                    this.f46053z = new ArrayList(this.f46053z);
                    this.f46031d |= 2097152;
                }
            }

            private void D() {
                if ((this.f46031d & CommonNetImpl.FLAG_SHARE_JUMP) != 33554432) {
                    this.D = new ArrayList(this.D);
                    this.f46031d |= CommonNetImpl.FLAG_SHARE_JUMP;
                }
            }

            private void E() {
                if ((this.f46031d & 512) != 512) {
                    this.f46041n = new ArrayList(this.f46041n);
                    this.f46031d |= 512;
                }
            }

            private void F() {
                if ((this.f46031d & 256) != 256) {
                    this.f46040m = new ArrayList(this.f46040m);
                    this.f46031d |= 256;
                }
            }

            private void G() {
                if ((this.f46031d & 128) != 128) {
                    this.f46039l = new ArrayList(this.f46039l);
                    this.f46031d |= 128;
                }
            }

            private void H() {
                if ((this.f46031d & 8192) != 8192) {
                    this.f46045r = new ArrayList(this.f46045r);
                    this.f46031d |= 8192;
                }
            }

            private void I() {
                if ((this.f46031d & 1024) != 1024) {
                    this.f46042o = new ArrayList(this.f46042o);
                    this.f46031d |= 1024;
                }
            }

            private void J() {
                if ((this.f46031d & 262144) != 262144) {
                    this.f46050w = new ArrayList(this.f46050w);
                    this.f46031d |= 262144;
                }
            }

            private void K() {
                if ((this.f46031d & 1048576) != 1048576) {
                    this.f46052y = new ArrayList(this.f46052y);
                    this.f46031d |= 1048576;
                }
            }

            private void L() {
                if ((this.f46031d & 524288) != 524288) {
                    this.f46051x = new ArrayList(this.f46051x);
                    this.f46031d |= 524288;
                }
            }

            private void M() {
                if ((this.f46031d & 64) != 64) {
                    this.f46038k = new ArrayList(this.f46038k);
                    this.f46031d |= 64;
                }
            }

            private void N() {
                if ((this.f46031d & 2048) != 2048) {
                    this.f46043p = new ArrayList(this.f46043p);
                    this.f46031d |= 2048;
                }
            }

            private void O() {
                if ((this.f46031d & 16384) != 16384) {
                    this.f46046s = new ArrayList(this.f46046s);
                    this.f46031d |= 16384;
                }
            }

            private void P() {
                if ((this.f46031d & 32) != 32) {
                    this.f46037j = new ArrayList(this.f46037j);
                    this.f46031d |= 32;
                }
            }

            private void Q() {
                if ((this.f46031d & 16) != 16) {
                    this.f46036i = new ArrayList(this.f46036i);
                    this.f46031d |= 16;
                }
            }

            private void R() {
                if ((this.f46031d & 4096) != 4096) {
                    this.f46044q = new ArrayList(this.f46044q);
                    this.f46031d |= 4096;
                }
            }

            private void S() {
                if ((this.f46031d & 8) != 8) {
                    this.f46035h = new ArrayList(this.f46035h);
                    this.f46031d |= 8;
                }
            }

            private void T() {
                if ((this.f46031d & 8388608) != 8388608) {
                    this.B = new ArrayList(this.B);
                    this.f46031d |= 8388608;
                }
            }

            public b A0(TypeTable typeTable) {
                if ((this.f46031d & 4194304) != 4194304 || this.A == TypeTable.getDefaultInstance()) {
                    this.A = typeTable;
                } else {
                    this.A = TypeTable.newBuilder(this.A).k(typeTable).o();
                }
                this.f46031d |= 4194304;
                return this;
            }

            public b B0(VersionRequirementTable versionRequirementTable) {
                if ((this.f46031d & 16777216) != 16777216 || this.C == VersionRequirementTable.getDefaultInstance()) {
                    this.C = versionRequirementTable;
                } else {
                    this.C = VersionRequirementTable.newBuilder(this.C).k(versionRequirementTable).o();
                }
                this.f46031d |= 16777216;
                return this;
            }

            public b C0(int i6) {
                this.f46031d |= 4;
                this.f46034g = i6;
                return this;
            }

            public b D0(int i6) {
                this.f46031d |= 1;
                this.f46032e = i6;
                return this;
            }

            public b E0(int i6) {
                this.f46031d |= 2;
                this.f46033f = i6;
                return this;
            }

            public b F0(int i6) {
                this.f46031d |= 32768;
                this.f46047t = i6;
                return this;
            }

            public b G0(int i6) {
                this.f46031d |= 131072;
                this.f46049v = i6;
                return this;
            }

            public Annotation U(int i6) {
                return this.f46053z.get(i6);
            }

            public int V() {
                return this.f46053z.size();
            }

            public CompilerPluginData W(int i6) {
                return this.D.get(i6);
            }

            public int X() {
                return this.D.size();
            }

            public Constructor Y(int i6) {
                return this.f46041n.get(i6);
            }

            public int Z() {
                return this.f46041n.size();
            }

            public Type a0(int i6) {
                return this.f46039l.get(i6);
            }

            public int b0() {
                return this.f46039l.size();
            }

            public EnumEntry d0(int i6) {
                return this.f46045r.get(i6);
            }

            public int e0() {
                return this.f46045r.size();
            }

            public Function f0(int i6) {
                return this.f46042o.get(i6);
            }

            public int g0() {
                return this.f46042o.size();
            }

            public Type h0() {
                return this.f46048u;
            }

            public Type i0(int i6) {
                return this.f46051x.get(i6);
            }

            public int j0() {
                return this.f46051x.size();
            }

            public Property k0(int i6) {
                return this.f46043p.get(i6);
            }

            public int l0() {
                return this.f46043p.size();
            }

            public Type m0(int i6) {
                return this.f46036i.get(i6);
            }

            public int n0() {
                return this.f46036i.size();
            }

            public TypeAlias o0(int i6) {
                return this.f46044q.get(i6);
            }

            public int p0() {
                return this.f46044q.size();
            }

            public TypeParameter q0(int i6) {
                return this.f46035h.get(i6);
            }

            public int r0() {
                return this.f46035h.size();
            }

            public TypeTable s0() {
                return this.A;
            }

            public boolean t0() {
                return (this.f46031d & 2) == 2;
            }

            public boolean u0() {
                return (this.f46031d & 65536) == 65536;
            }

            public boolean v0() {
                return (this.f46031d & 4194304) == 4194304;
            }

            public Class z() {
                Class r02 = new Class(this);
                int i6 = this.f46031d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                r02.flags_ = this.f46032e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                r02.fqName_ = this.f46033f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                r02.companionObjectName_ = this.f46034g;
                if ((this.f46031d & 8) == 8) {
                    this.f46035h = Collections.unmodifiableList(this.f46035h);
                    this.f46031d &= -9;
                }
                r02.typeParameter_ = this.f46035h;
                if ((this.f46031d & 16) == 16) {
                    this.f46036i = Collections.unmodifiableList(this.f46036i);
                    this.f46031d &= -17;
                }
                r02.supertype_ = this.f46036i;
                if ((this.f46031d & 32) == 32) {
                    this.f46037j = Collections.unmodifiableList(this.f46037j);
                    this.f46031d &= -33;
                }
                r02.supertypeId_ = this.f46037j;
                if ((this.f46031d & 64) == 64) {
                    this.f46038k = Collections.unmodifiableList(this.f46038k);
                    this.f46031d &= -65;
                }
                r02.nestedClassName_ = this.f46038k;
                if ((this.f46031d & 128) == 128) {
                    this.f46039l = Collections.unmodifiableList(this.f46039l);
                    this.f46031d &= -129;
                }
                r02.contextReceiverType_ = this.f46039l;
                if ((this.f46031d & 256) == 256) {
                    this.f46040m = Collections.unmodifiableList(this.f46040m);
                    this.f46031d &= -257;
                }
                r02.contextReceiverTypeId_ = this.f46040m;
                if ((this.f46031d & 512) == 512) {
                    this.f46041n = Collections.unmodifiableList(this.f46041n);
                    this.f46031d &= -513;
                }
                r02.constructor_ = this.f46041n;
                if ((this.f46031d & 1024) == 1024) {
                    this.f46042o = Collections.unmodifiableList(this.f46042o);
                    this.f46031d &= -1025;
                }
                r02.function_ = this.f46042o;
                if ((this.f46031d & 2048) == 2048) {
                    this.f46043p = Collections.unmodifiableList(this.f46043p);
                    this.f46031d &= -2049;
                }
                r02.property_ = this.f46043p;
                if ((this.f46031d & 4096) == 4096) {
                    this.f46044q = Collections.unmodifiableList(this.f46044q);
                    this.f46031d &= -4097;
                }
                r02.typeAlias_ = this.f46044q;
                if ((this.f46031d & 8192) == 8192) {
                    this.f46045r = Collections.unmodifiableList(this.f46045r);
                    this.f46031d &= -8193;
                }
                r02.enumEntry_ = this.f46045r;
                if ((this.f46031d & 16384) == 16384) {
                    this.f46046s = Collections.unmodifiableList(this.f46046s);
                    this.f46031d &= -16385;
                }
                r02.sealedSubclassFqName_ = this.f46046s;
                if ((i6 & 32768) == 32768) {
                    i7 |= 8;
                }
                r02.inlineClassUnderlyingPropertyName_ = this.f46047t;
                if ((i6 & 65536) == 65536) {
                    i7 |= 16;
                }
                r02.inlineClassUnderlyingType_ = this.f46048u;
                if ((i6 & 131072) == 131072) {
                    i7 |= 32;
                }
                r02.inlineClassUnderlyingTypeId_ = this.f46049v;
                if ((this.f46031d & 262144) == 262144) {
                    this.f46050w = Collections.unmodifiableList(this.f46050w);
                    this.f46031d &= -262145;
                }
                r02.multiFieldValueClassUnderlyingName_ = this.f46050w;
                if ((this.f46031d & 524288) == 524288) {
                    this.f46051x = Collections.unmodifiableList(this.f46051x);
                    this.f46031d &= -524289;
                }
                r02.multiFieldValueClassUnderlyingType_ = this.f46051x;
                if ((this.f46031d & 1048576) == 1048576) {
                    this.f46052y = Collections.unmodifiableList(this.f46052y);
                    this.f46031d &= -1048577;
                }
                r02.multiFieldValueClassUnderlyingTypeId_ = this.f46052y;
                if ((this.f46031d & 2097152) == 2097152) {
                    this.f46053z = Collections.unmodifiableList(this.f46053z);
                    this.f46031d &= -2097153;
                }
                r02.annotation_ = this.f46053z;
                if ((4194304 & i6) == 4194304) {
                    i7 |= 64;
                }
                r02.typeTable_ = this.A;
                if ((this.f46031d & 8388608) == 8388608) {
                    this.B = Collections.unmodifiableList(this.B);
                    this.f46031d &= -8388609;
                }
                r02.versionRequirement_ = this.B;
                if ((i6 & 16777216) == 16777216) {
                    i7 |= 128;
                }
                r02.versionRequirementTable_ = this.C;
                if ((this.f46031d & CommonNetImpl.FLAG_SHARE_JUMP) == 33554432) {
                    this.D = Collections.unmodifiableList(this.D);
                    this.f46031d &= -33554433;
                }
                r02.compilerPluginData_ = this.D;
                r02.bitField0_ = i7;
                return r02;
            }

            public b z0(Type type) {
                if ((this.f46031d & 65536) != 65536 || this.f46048u == Type.getDefaultInstance()) {
                    this.f46048u = type;
                } else {
                    this.f46048u = Type.newBuilder(this.f46048u).k(type).z();
                }
                this.f46031d |= 65536;
                return this;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46035h = list;
                this.f46036i = list;
                this.f46037j = list;
                this.f46038k = list;
                this.f46039l = list;
                this.f46040m = list;
                this.f46041n = list;
                this.f46042o = list;
                this.f46043p = list;
                this.f46044q = list;
                this.f46045r = list;
                this.f46046s = list;
                this.f46048u = Type.getDefaultInstance();
                this.f46050w = list;
                this.f46051x = list;
                this.f46052y = list;
                this.f46053z = list;
                this.A = TypeTable.getDefaultInstance();
                this.B = list;
                this.C = VersionRequirementTable.getDefaultInstance();
                this.D = list;
                w0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: c0, reason: merged with bridge method [inline-methods] */
            public Class h() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!t0()) {
                    return false;
                }
                for (int i6 = 0; i6 < r0(); i6++) {
                    if (!q0(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < n0(); i7++) {
                    if (!m0(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < b0(); i8++) {
                    if (!a0(i8).isInitialized()) {
                        return false;
                    }
                }
                for (int i9 = 0; i9 < Z(); i9++) {
                    if (!Y(i9).isInitialized()) {
                        return false;
                    }
                }
                for (int i10 = 0; i10 < g0(); i10++) {
                    if (!f0(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < l0(); i11++) {
                    if (!k0(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < p0(); i12++) {
                    if (!o0(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < e0(); i13++) {
                    if (!d0(i13).isInitialized()) {
                        return false;
                    }
                }
                if (u0() && !h0().isInitialized()) {
                    return false;
                }
                for (int i14 = 0; i14 < j0(); i14++) {
                    if (!i0(i14).isInitialized()) {
                        return false;
                    }
                }
                for (int i15 = 0; i15 < V(); i15++) {
                    if (!U(i15).isInitialized()) {
                        return false;
                    }
                }
                if (v0() && !s0().isInitialized()) {
                    return false;
                }
                for (int i16 = 0; i16 < X(); i16++) {
                    if (!W(i16).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            public b x(Iterable<? extends Annotation> iterable) {
                C();
                a.AbstractC0905a.a(iterable, this.f46053z);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: x0, reason: merged with bridge method [inline-methods] */
            public b k(Class r32) {
                if (r32 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r32.hasFlags()) {
                    D0(r32.getFlags());
                }
                if (r32.hasFqName()) {
                    E0(r32.getFqName());
                }
                if (r32.hasCompanionObjectName()) {
                    C0(r32.getCompanionObjectName());
                }
                if (!r32.typeParameter_.isEmpty()) {
                    if (this.f46035h.isEmpty()) {
                        this.f46035h = r32.typeParameter_;
                        this.f46031d &= -9;
                    } else {
                        S();
                        this.f46035h.addAll(r32.typeParameter_);
                    }
                }
                if (!r32.supertype_.isEmpty()) {
                    if (this.f46036i.isEmpty()) {
                        this.f46036i = r32.supertype_;
                        this.f46031d &= -17;
                    } else {
                        Q();
                        this.f46036i.addAll(r32.supertype_);
                    }
                }
                if (!r32.supertypeId_.isEmpty()) {
                    if (this.f46037j.isEmpty()) {
                        this.f46037j = r32.supertypeId_;
                        this.f46031d &= -33;
                    } else {
                        P();
                        this.f46037j.addAll(r32.supertypeId_);
                    }
                }
                if (!r32.nestedClassName_.isEmpty()) {
                    if (this.f46038k.isEmpty()) {
                        this.f46038k = r32.nestedClassName_;
                        this.f46031d &= -65;
                    } else {
                        M();
                        this.f46038k.addAll(r32.nestedClassName_);
                    }
                }
                if (!r32.contextReceiverType_.isEmpty()) {
                    if (this.f46039l.isEmpty()) {
                        this.f46039l = r32.contextReceiverType_;
                        this.f46031d &= -129;
                    } else {
                        G();
                        this.f46039l.addAll(r32.contextReceiverType_);
                    }
                }
                if (!r32.contextReceiverTypeId_.isEmpty()) {
                    if (this.f46040m.isEmpty()) {
                        this.f46040m = r32.contextReceiverTypeId_;
                        this.f46031d &= -257;
                    } else {
                        F();
                        this.f46040m.addAll(r32.contextReceiverTypeId_);
                    }
                }
                if (!r32.constructor_.isEmpty()) {
                    if (this.f46041n.isEmpty()) {
                        this.f46041n = r32.constructor_;
                        this.f46031d &= -513;
                    } else {
                        E();
                        this.f46041n.addAll(r32.constructor_);
                    }
                }
                if (!r32.function_.isEmpty()) {
                    if (this.f46042o.isEmpty()) {
                        this.f46042o = r32.function_;
                        this.f46031d &= -1025;
                    } else {
                        I();
                        this.f46042o.addAll(r32.function_);
                    }
                }
                if (!r32.property_.isEmpty()) {
                    if (this.f46043p.isEmpty()) {
                        this.f46043p = r32.property_;
                        this.f46031d &= -2049;
                    } else {
                        N();
                        this.f46043p.addAll(r32.property_);
                    }
                }
                if (!r32.typeAlias_.isEmpty()) {
                    if (this.f46044q.isEmpty()) {
                        this.f46044q = r32.typeAlias_;
                        this.f46031d &= -4097;
                    } else {
                        R();
                        this.f46044q.addAll(r32.typeAlias_);
                    }
                }
                if (!r32.enumEntry_.isEmpty()) {
                    if (this.f46045r.isEmpty()) {
                        this.f46045r = r32.enumEntry_;
                        this.f46031d &= -8193;
                    } else {
                        H();
                        this.f46045r.addAll(r32.enumEntry_);
                    }
                }
                if (!r32.sealedSubclassFqName_.isEmpty()) {
                    if (this.f46046s.isEmpty()) {
                        this.f46046s = r32.sealedSubclassFqName_;
                        this.f46031d &= -16385;
                    } else {
                        O();
                        this.f46046s.addAll(r32.sealedSubclassFqName_);
                    }
                }
                if (r32.hasInlineClassUnderlyingPropertyName()) {
                    F0(r32.getInlineClassUnderlyingPropertyName());
                }
                if (r32.hasInlineClassUnderlyingType()) {
                    z0(r32.getInlineClassUnderlyingType());
                }
                if (r32.hasInlineClassUnderlyingTypeId()) {
                    G0(r32.getInlineClassUnderlyingTypeId());
                }
                if (!r32.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.f46050w.isEmpty()) {
                        this.f46050w = r32.multiFieldValueClassUnderlyingName_;
                        this.f46031d &= -262145;
                    } else {
                        J();
                        this.f46050w.addAll(r32.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!r32.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.f46051x.isEmpty()) {
                        this.f46051x = r32.multiFieldValueClassUnderlyingType_;
                        this.f46031d &= -524289;
                    } else {
                        L();
                        this.f46051x.addAll(r32.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!r32.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.f46052y.isEmpty()) {
                        this.f46052y = r32.multiFieldValueClassUnderlyingTypeId_;
                        this.f46031d &= -1048577;
                    } else {
                        K();
                        this.f46052y.addAll(r32.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (!r32.annotation_.isEmpty()) {
                    if (this.f46053z.isEmpty()) {
                        this.f46053z = r32.annotation_;
                        this.f46031d &= -2097153;
                    } else {
                        C();
                        this.f46053z.addAll(r32.annotation_);
                    }
                }
                if (r32.hasTypeTable()) {
                    A0(r32.getTypeTable());
                }
                if (!r32.versionRequirement_.isEmpty()) {
                    if (this.B.isEmpty()) {
                        this.B = r32.versionRequirement_;
                        this.f46031d &= -8388609;
                    } else {
                        T();
                        this.B.addAll(r32.versionRequirement_);
                    }
                }
                if (r32.hasVersionRequirementTable()) {
                    B0(r32.getVersionRequirementTable());
                }
                if (!r32.compilerPluginData_.isEmpty()) {
                    if (this.D.isEmpty()) {
                        this.D = r32.compilerPluginData_;
                        this.f46031d &= -33554433;
                    } else {
                        D();
                        this.D.addAll(r32.compilerPluginData_);
                    }
                }
                t(r32);
                l(i().d(r32.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public Class build() {
                Class z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void w0() {
            }
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.supertype_ = list;
            this.supertypeId_ = list;
            this.nestedClassName_ = list;
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.constructor_ = list;
            this.function_ = list;
            this.property_ = list;
            this.typeAlias_ = list;
            this.enumEntry_ = list;
            this.sealedSubclassFqName_ = list;
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = list;
            this.multiFieldValueClassUnderlyingType_ = list;
            this.multiFieldValueClassUnderlyingTypeId_ = list;
            this.annotation_ = list;
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = list;
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
            this.compilerPluginData_ = list;
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            Class r02 = new Class(true);
            defaultInstance = r02;
            r02.initFields();
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(Class r12) {
            return newBuilder().k(r12);
        }

        public static Class parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.b(inputStream, fVar);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public CompilerPluginData getCompilerPluginData(int i6) {
            return this.compilerPluginData_.get(i6);
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public Constructor getConstructor(int i6) {
            return this.constructor_.get(i6);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public Type getContextReceiverType(int i6) {
            return this.contextReceiverType_.get(i6);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Class h() {
            return defaultInstance;
        }

        public EnumEntry getEnumEntry(int i6) {
            return this.enumEntry_.get(i6);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int i6) {
            return this.function_.get(i6);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public Type getMultiFieldValueClassUnderlyingType(int i6) {
            return this.multiFieldValueClassUnderlyingType_.get(i6);
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i6) {
            return this.property_.get(i6);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.flags_) : 0;
            int i7 = 0;
            for (int i8 = 0; i8 < this.supertypeId_.size(); i8++) {
                i7 += CodedOutputStream.q(this.supertypeId_.get(i8).intValue());
            }
            int i9 = p5 + i7;
            if (!getSupertypeIdList().isEmpty()) {
                i9 = i9 + 1 + CodedOutputStream.q(i7);
            }
            this.supertypeIdMemoizedSerializedSize = i7;
            if ((this.bitField0_ & 2) == 2) {
                i9 += CodedOutputStream.p(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i9 += CodedOutputStream.p(4, this.companionObjectName_);
            }
            for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
                i9 += CodedOutputStream.t(5, this.typeParameter_.get(i10));
            }
            for (int i11 = 0; i11 < this.supertype_.size(); i11++) {
                i9 += CodedOutputStream.t(6, this.supertype_.get(i11));
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.nestedClassName_.size(); i13++) {
                i12 += CodedOutputStream.q(this.nestedClassName_.get(i13).intValue());
            }
            int i14 = i9 + i12;
            if (!getNestedClassNameList().isEmpty()) {
                i14 = i14 + 1 + CodedOutputStream.q(i12);
            }
            this.nestedClassNameMemoizedSerializedSize = i12;
            for (int i15 = 0; i15 < this.constructor_.size(); i15++) {
                i14 += CodedOutputStream.t(8, this.constructor_.get(i15));
            }
            for (int i16 = 0; i16 < this.function_.size(); i16++) {
                i14 += CodedOutputStream.t(9, this.function_.get(i16));
            }
            for (int i17 = 0; i17 < this.property_.size(); i17++) {
                i14 += CodedOutputStream.t(10, this.property_.get(i17));
            }
            for (int i18 = 0; i18 < this.typeAlias_.size(); i18++) {
                i14 += CodedOutputStream.t(11, this.typeAlias_.get(i18));
            }
            for (int i19 = 0; i19 < this.enumEntry_.size(); i19++) {
                i14 += CodedOutputStream.t(13, this.enumEntry_.get(i19));
            }
            int i20 = 0;
            for (int i21 = 0; i21 < this.sealedSubclassFqName_.size(); i21++) {
                i20 += CodedOutputStream.q(this.sealedSubclassFqName_.get(i21).intValue());
            }
            int i22 = i14 + i20;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i22 = i22 + 2 + CodedOutputStream.q(i20);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i20;
            if ((this.bitField0_ & 8) == 8) {
                i22 += CodedOutputStream.p(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i22 += CodedOutputStream.t(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i22 += CodedOutputStream.p(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i23 = 0; i23 < this.contextReceiverType_.size(); i23++) {
                i22 += CodedOutputStream.t(20, this.contextReceiverType_.get(i23));
            }
            int i24 = 0;
            for (int i25 = 0; i25 < this.contextReceiverTypeId_.size(); i25++) {
                i24 += CodedOutputStream.q(this.contextReceiverTypeId_.get(i25).intValue());
            }
            int i26 = i22 + i24;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i26 = i26 + 2 + CodedOutputStream.q(i24);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i24;
            int i27 = 0;
            for (int i28 = 0; i28 < this.multiFieldValueClassUnderlyingName_.size(); i28++) {
                i27 += CodedOutputStream.q(this.multiFieldValueClassUnderlyingName_.get(i28).intValue());
            }
            int i29 = i26 + i27;
            if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                i29 = i29 + 2 + CodedOutputStream.q(i27);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i27;
            for (int i30 = 0; i30 < this.multiFieldValueClassUnderlyingType_.size(); i30++) {
                i29 += CodedOutputStream.t(23, this.multiFieldValueClassUnderlyingType_.get(i30));
            }
            int i31 = 0;
            for (int i32 = 0; i32 < this.multiFieldValueClassUnderlyingTypeId_.size(); i32++) {
                i31 += CodedOutputStream.q(this.multiFieldValueClassUnderlyingTypeId_.get(i32).intValue());
            }
            int i33 = i29 + i31;
            if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                i33 = i33 + 2 + CodedOutputStream.q(i31);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i31;
            for (int i34 = 0; i34 < this.annotation_.size(); i34++) {
                i33 += CodedOutputStream.t(25, this.annotation_.get(i34));
            }
            if ((this.bitField0_ & 64) == 64) {
                i33 += CodedOutputStream.t(30, this.typeTable_);
            }
            int i35 = 0;
            for (int i36 = 0; i36 < this.versionRequirement_.size(); i36++) {
                i35 += CodedOutputStream.q(this.versionRequirement_.get(i36).intValue());
            }
            int size = i33 + i35 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.t(32, this.versionRequirementTable_);
            }
            for (int i37 = 0; i37 < this.compilerPluginData_.size(); i37++) {
                size += CodedOutputStream.t(33, this.compilerPluginData_.get(i37));
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getSupertype(int i6) {
            return this.supertype_.get(i6);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int i6) {
            return this.typeAlias_.get(i6);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int i6) {
            return this.typeParameter_.get(i6);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getTypeParameterCount(); i6++) {
                if (!getTypeParameter(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getSupertypeCount(); i7++) {
                if (!getSupertype(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getContextReceiverTypeCount(); i8++) {
                if (!getContextReceiverType(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i9 = 0; i9 < getConstructorCount(); i9++) {
                if (!getConstructor(i9).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i10 = 0; i10 < getFunctionCount(); i10++) {
                if (!getFunction(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getPropertyCount(); i11++) {
                if (!getProperty(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getTypeAliasCount(); i12++) {
                if (!getTypeAlias(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getEnumEntryCount(); i13++) {
                if (!getEnumEntry(i13).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i14 = 0; i14 < getMultiFieldValueClassUnderlyingTypeCount(); i14++) {
                if (!getMultiFieldValueClassUnderlyingType(i14).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i15 = 0; i15 < getAnnotationCount(); i15++) {
                if (!getAnnotation(i15).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i16 = 0; i16 < getCompilerPluginDataCount(); i16++) {
                if (!getCompilerPluginData(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Class(GeneratedMessageLite.c<Class, ?> cVar) {
            super(cVar);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.s0(18);
                codedOutputStream.s0(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.supertypeId_.size(); i6++) {
                codedOutputStream.f0(this.supertypeId_.get(i6).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.e0(4, this.companionObjectName_);
            }
            for (int i7 = 0; i7 < this.typeParameter_.size(); i7++) {
                codedOutputStream.h0(5, this.typeParameter_.get(i7));
            }
            for (int i8 = 0; i8 < this.supertype_.size(); i8++) {
                codedOutputStream.h0(6, this.supertype_.get(i8));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.s0(58);
                codedOutputStream.s0(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i9 = 0; i9 < this.nestedClassName_.size(); i9++) {
                codedOutputStream.f0(this.nestedClassName_.get(i9).intValue());
            }
            for (int i10 = 0; i10 < this.constructor_.size(); i10++) {
                codedOutputStream.h0(8, this.constructor_.get(i10));
            }
            for (int i11 = 0; i11 < this.function_.size(); i11++) {
                codedOutputStream.h0(9, this.function_.get(i11));
            }
            for (int i12 = 0; i12 < this.property_.size(); i12++) {
                codedOutputStream.h0(10, this.property_.get(i12));
            }
            for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
                codedOutputStream.h0(11, this.typeAlias_.get(i13));
            }
            for (int i14 = 0; i14 < this.enumEntry_.size(); i14++) {
                codedOutputStream.h0(13, this.enumEntry_.get(i14));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.s0(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                codedOutputStream.s0(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i15 = 0; i15 < this.sealedSubclassFqName_.size(); i15++) {
                codedOutputStream.f0(this.sealedSubclassFqName_.get(i15).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.h0(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i16 = 0; i16 < this.contextReceiverType_.size(); i16++) {
                codedOutputStream.h0(20, this.contextReceiverType_.get(i16));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.s0(170);
                codedOutputStream.s0(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i17 = 0; i17 < this.contextReceiverTypeId_.size(); i17++) {
                codedOutputStream.f0(this.contextReceiverTypeId_.get(i17).intValue());
            }
            if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                codedOutputStream.s0(178);
                codedOutputStream.s0(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (int i18 = 0; i18 < this.multiFieldValueClassUnderlyingName_.size(); i18++) {
                codedOutputStream.f0(this.multiFieldValueClassUnderlyingName_.get(i18).intValue());
            }
            for (int i19 = 0; i19 < this.multiFieldValueClassUnderlyingType_.size(); i19++) {
                codedOutputStream.h0(23, this.multiFieldValueClassUnderlyingType_.get(i19));
            }
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                codedOutputStream.s0(MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
                codedOutputStream.s0(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (int i20 = 0; i20 < this.multiFieldValueClassUnderlyingTypeId_.size(); i20++) {
                codedOutputStream.f0(this.multiFieldValueClassUnderlyingTypeId_.get(i20).intValue());
            }
            for (int i21 = 0; i21 < this.annotation_.size(); i21++) {
                codedOutputStream.h0(25, this.annotation_.get(i21));
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.h0(30, this.typeTable_);
            }
            for (int i22 = 0; i22 < this.versionRequirement_.size(); i22++) {
                codedOutputStream.e0(31, this.versionRequirement_.get(i22).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.h0(32, this.versionRequirementTable_);
            }
            for (int i23 = 0; i23 < this.compilerPluginData_.size(); i23++) {
                codedOutputStream.h0(33, this.compilerPluginData_.get(i23));
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Class(boolean z5) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        private Class(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            int i6;
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            int i7 = 0;
            while (!z5) {
                try {
                    int K2 = eVar.K();
                    switch (K2) {
                        case 0:
                            z5 = true;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.s();
                        case 16:
                            if ((i7 & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i7 |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(eVar.s()));
                        case 18:
                            int j6 = eVar.j(eVar.A());
                            if ((i7 & 32) != 32 && eVar.e() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i7 |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.supertypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j6);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = eVar.s();
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = eVar.s();
                        case 42:
                            if ((i7 & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i7 |= 8;
                            }
                            this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                        case 50:
                            if ((i7 & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i7 |= 16;
                            }
                            this.supertype_.add(eVar.u(Type.PARSER, fVar));
                        case 56:
                            if ((i7 & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i7 |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                        case 58:
                            int j7 = eVar.j(eVar.A());
                            if ((i7 & 64) != 64 && eVar.e() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i7 |= 64;
                            }
                            while (eVar.e() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j7);
                            break;
                        case 66:
                            if ((i7 & 512) != 512) {
                                this.constructor_ = new ArrayList();
                                i7 |= 512;
                            }
                            this.constructor_.add(eVar.u(Constructor.PARSER, fVar));
                        case 74:
                            if ((i7 & 1024) != 1024) {
                                this.function_ = new ArrayList();
                                i7 |= 1024;
                            }
                            this.function_.add(eVar.u(Function.PARSER, fVar));
                        case 82:
                            if ((i7 & 2048) != 2048) {
                                this.property_ = new ArrayList();
                                i7 |= 2048;
                            }
                            this.property_.add(eVar.u(Property.PARSER, fVar));
                        case 90:
                            if ((i7 & 4096) != 4096) {
                                this.typeAlias_ = new ArrayList();
                                i7 |= 4096;
                            }
                            this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
                        case 106:
                            if ((i7 & 8192) != 8192) {
                                this.enumEntry_ = new ArrayList();
                                i7 |= 8192;
                            }
                            this.enumEntry_.add(eVar.u(EnumEntry.PARSER, fVar));
                        case 128:
                            if ((i7 & 16384) != 16384) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i7 |= 16384;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                        case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                            int j8 = eVar.j(eVar.A());
                            if ((i7 & 16384) != 16384 && eVar.e() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i7 |= 16384;
                            }
                            while (eVar.e() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j8);
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                            this.bitField0_ |= 8;
                            this.inlineClassUnderlyingPropertyName_ = eVar.s();
                        case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                            Type.b builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                            Type type = (Type) eVar.u(Type.PARSER, fVar);
                            this.inlineClassUnderlyingType_ = type;
                            if (builder != null) {
                                builder.k(type);
                                this.inlineClassUnderlyingType_ = builder.z();
                            }
                            this.bitField0_ |= 16;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                            this.bitField0_ |= 32;
                            this.inlineClassUnderlyingTypeId_ = eVar.s();
                        case 162:
                            if ((i7 & 128) != 128) {
                                this.contextReceiverType_ = new ArrayList();
                                i7 |= 128;
                            }
                            this.contextReceiverType_.add(eVar.u(Type.PARSER, fVar));
                        case 168:
                            if ((i7 & 256) != 256) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i7 |= 256;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                        case 170:
                            int j9 = eVar.j(eVar.A());
                            if ((i7 & 256) != 256 && eVar.e() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i7 |= 256;
                            }
                            while (eVar.e() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j9);
                            break;
                        case 176:
                            if ((i7 & 262144) != 262144) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                i7 |= 262144;
                            }
                            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(eVar.s()));
                        case 178:
                            int j10 = eVar.j(eVar.A());
                            if ((i7 & 262144) != 262144 && eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                i7 |= 262144;
                            }
                            while (eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                            if ((i7 & 524288) != 524288) {
                                this.multiFieldValueClassUnderlyingType_ = new ArrayList();
                                i7 |= 524288;
                            }
                            this.multiFieldValueClassUnderlyingType_.add(eVar.u(Type.PARSER, fVar));
                        case 192:
                            if ((i7 & 1048576) != 1048576) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                i7 |= 1048576;
                            }
                            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(eVar.s()));
                        case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                            int j11 = eVar.j(eVar.A());
                            if ((i7 & 1048576) != 1048576 && eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                i7 |= 1048576;
                            }
                            while (eVar.e() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j11);
                            break;
                        case 202:
                            if ((i7 & 2097152) != 2097152) {
                                this.annotation_ = new ArrayList();
                                i7 |= 2097152;
                            }
                            this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                        case 242:
                            TypeTable.b builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                            TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                            this.typeTable_ = typeTable;
                            if (builder2 != null) {
                                builder2.k(typeTable);
                                this.typeTable_ = builder2.o();
                            }
                            this.bitField0_ |= 64;
                        case 248:
                            if ((i7 & 8388608) != 8388608) {
                                this.versionRequirement_ = new ArrayList();
                                i7 |= 8388608;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                        case 250:
                            int j12 = eVar.j(eVar.A());
                            if ((i7 & 8388608) != 8388608 && eVar.e() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i7 |= 8388608;
                            }
                            while (eVar.e() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j12);
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                            VersionRequirementTable.b builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                            VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                            this.versionRequirementTable_ = versionRequirementTable;
                            if (builder3 != null) {
                                builder3.k(versionRequirementTable);
                                this.versionRequirementTable_ = builder3.o();
                            }
                            this.bitField0_ |= 128;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME /* 266 */:
                            if ((i7 & CommonNetImpl.FLAG_SHARE_JUMP) != 33554432) {
                                this.compilerPluginData_ = new ArrayList();
                                i7 |= CommonNetImpl.FLAG_SHARE_JUMP;
                            }
                            List<CompilerPluginData> list = this.compilerPluginData_;
                            i6 = CommonNetImpl.FLAG_SHARE_JUMP;
                            try {
                                try {
                                    list.add(eVar.u(CompilerPluginData.PARSER, fVar));
                                } catch (InvalidProtocolBufferException e6) {
                                    e = e6;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e7) {
                                    e = e7;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                }
                            } catch (Throwable th) {
                                th = th;
                                if ((i7 & 32) == 32) {
                                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                                }
                                if ((i7 & 8) == 8) {
                                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                                }
                                if ((i7 & 16) == 16) {
                                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                                }
                                if ((i7 & 64) == 64) {
                                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                                }
                                if ((i7 & 512) == 512) {
                                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                                }
                                if ((i7 & 1024) == 1024) {
                                    this.function_ = Collections.unmodifiableList(this.function_);
                                }
                                if ((i7 & 2048) == 2048) {
                                    this.property_ = Collections.unmodifiableList(this.property_);
                                }
                                if ((i7 & 4096) == 4096) {
                                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                                }
                                if ((i7 & 8192) == 8192) {
                                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                                }
                                if ((i7 & 16384) == 16384) {
                                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                                }
                                if ((i7 & 128) == 128) {
                                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                                }
                                if ((i7 & 256) == 256) {
                                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                                }
                                if ((i7 & 262144) == 262144) {
                                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                                }
                                if ((i7 & 524288) == 524288) {
                                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                                }
                                if ((i7 & 1048576) == 1048576) {
                                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                                }
                                if ((i7 & 2097152) == 2097152) {
                                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                                }
                                if ((i7 & 8388608) == 8388608) {
                                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                                }
                                if ((i7 & i6) == 33554432) {
                                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
                        default:
                            if (parseUnknownField(eVar, K, fVar, K2)) {
                            }
                            z5 = true;
                    }
                } catch (InvalidProtocolBufferException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                } catch (Throwable th3) {
                    th = th3;
                    i6 = CommonNetImpl.FLAG_SHARE_JUMP;
                }
            }
            if ((i7 & 32) == 32) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
            }
            if ((i7 & 8) == 8) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i7 & 16) == 16) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
            }
            if ((i7 & 64) == 64) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
            }
            if ((i7 & 512) == 512) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
            }
            if ((i7 & 1024) == 1024) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if ((i7 & 2048) == 2048) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if ((i7 & 4096) == 4096) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            if ((i7 & 8192) == 8192) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
            }
            if ((i7 & 16384) == 16384) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
            }
            if ((i7 & 128) == 128) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
            }
            if ((i7 & 256) == 256) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
            }
            if ((i7 & 262144) == 262144) {
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
            }
            if ((i7 & 524288) == 524288) {
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
            }
            if ((i7 & 1048576) == 1048576) {
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
            }
            if ((i7 & 2097152) == 2097152) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if ((i7 & 8388608) == 8388608) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            if ((i7 & CommonNetImpl.FLAG_SHARE_JUMP) == 33554432) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
            }
            try {
                K.J();
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                this.unknownFields = t5.e();
                throw th4;
            }
            this.unknownFields = t5.e();
            makeExtensionsImmutable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CompilerPluginData extends GeneratedMessageLite implements e {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<CompilerPluginData> PARSER = new a();
        private static final CompilerPluginData defaultInstance;
        private int bitField0_;
        private kotlin.reflect.jvm.internal.impl.protobuf.d data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int pluginId_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<CompilerPluginData> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public CompilerPluginData d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new CompilerPluginData(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<CompilerPluginData, b> implements e {

            /* renamed from: b, reason: collision with root package name */
            private int f46054b;

            /* renamed from: c, reason: collision with root package name */
            private int f46055c;

            /* renamed from: d, reason: collision with root package name */
            private kotlin.reflect.jvm.internal.impl.protobuf.d f46056d = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.CompilerPluginData.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.CompilerPluginData.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.CompilerPluginData) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.CompilerPluginData) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.CompilerPluginData.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            public CompilerPluginData o() {
                CompilerPluginData compilerPluginData = new CompilerPluginData(this);
                int i6 = this.f46054b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                compilerPluginData.pluginId_ = this.f46055c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                compilerPluginData.data_ = this.f46056d;
                compilerPluginData.bitField0_ = i7;
                return compilerPluginData;
            }

            public boolean t() {
                return (this.f46054b & 2) == 2;
            }

            public boolean u() {
                return (this.f46054b & 1) == 1;
            }

            public b z(int i6) {
                this.f46054b |= 1;
                this.f46055c = i6;
                return this;
            }

            private b() {
                v();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!u() || !t()) {
                    return false;
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public CompilerPluginData build() {
                CompilerPluginData o5 = o();
                if (o5.isInitialized()) {
                    return o5;
                }
                throw a.AbstractC0905a.f(o5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b p() {
                return q().k(o());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public CompilerPluginData h() {
                return CompilerPluginData.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b k(CompilerPluginData compilerPluginData) {
                if (compilerPluginData == CompilerPluginData.getDefaultInstance()) {
                    return this;
                }
                if (compilerPluginData.hasPluginId()) {
                    z(compilerPluginData.getPluginId());
                }
                if (compilerPluginData.hasData()) {
                    y(compilerPluginData.getData());
                }
                l(i().d(compilerPluginData.unknownFields));
                return this;
            }

            public b y(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
                dVar.getClass();
                this.f46054b |= 2;
                this.f46056d = dVar;
                return this;
            }

            private void v() {
            }
        }

        private void initFields() {
            this.pluginId_ = 0;
            this.data_ = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            CompilerPluginData compilerPluginData = new CompilerPluginData(true);
            defaultInstance = compilerPluginData;
            compilerPluginData.initFields();
        }

        public static CompilerPluginData getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(CompilerPluginData compilerPluginData) {
            return newBuilder().k(compilerPluginData);
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.d getData() {
            return this.data_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public CompilerPluginData h() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<CompilerPluginData> getParserForType() {
            return PARSER;
        }

        public int getPluginId() {
            return this.pluginId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.pluginId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.e(2, this.data_);
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasPluginId() {
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
            if (!hasPluginId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasData()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private CompilerPluginData(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.pluginId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.S(2, this.data_);
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private CompilerPluginData(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private CompilerPluginData(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                this.pluginId_ = eVar.s();
                            } else if (K2 != 18) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.data_ = eVar.l();
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
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements f {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> PARSER = new a();
        private static final Constructor defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private List<CompilerPluginData> compilerPluginData_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Constructor> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Constructor d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Constructor(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Constructor, b> implements f {

            /* renamed from: d, reason: collision with root package name */
            private int f46057d;

            /* renamed from: e, reason: collision with root package name */
            private int f46058e = 6;

            /* renamed from: f, reason: collision with root package name */
            private List<ValueParameter> f46059f;

            /* renamed from: g, reason: collision with root package name */
            private List<Integer> f46060g;

            /* renamed from: h, reason: collision with root package name */
            private List<CompilerPluginData> f46061h;

            /* renamed from: i, reason: collision with root package name */
            private List<Annotation> f46062i;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < M(); i6++) {
                    if (!L(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < J(); i7++) {
                    if (!I(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < H(); i8++) {
                    if (!G(i8).isInitialized()) {
                        return false;
                    }
                }
                return s();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46057d & 16) != 16) {
                    this.f46062i = new ArrayList(this.f46062i);
                    this.f46057d |= 16;
                }
            }

            private void D() {
                if ((this.f46057d & 8) != 8) {
                    this.f46061h = new ArrayList(this.f46061h);
                    this.f46057d |= 8;
                }
            }

            private void E() {
                if ((this.f46057d & 2) != 2) {
                    this.f46059f = new ArrayList(this.f46059f);
                    this.f46057d |= 2;
                }
            }

            private void F() {
                if ((this.f46057d & 4) != 4) {
                    this.f46060g = new ArrayList(this.f46060g);
                    this.f46057d |= 4;
                }
            }

            public Annotation G(int i6) {
                return this.f46062i.get(i6);
            }

            public int H() {
                return this.f46062i.size();
            }

            public CompilerPluginData I(int i6) {
                return this.f46061h.get(i6);
            }

            public int J() {
                return this.f46061h.size();
            }

            public ValueParameter L(int i6) {
                return this.f46059f.get(i6);
            }

            public int M() {
                return this.f46059f.size();
            }

            public b Q(int i6) {
                this.f46057d |= 1;
                this.f46058e = i6;
                return this;
            }

            public Constructor z() {
                Constructor constructor = new Constructor(this);
                int i6 = (this.f46057d & 1) != 1 ? 0 : 1;
                constructor.flags_ = this.f46058e;
                if ((this.f46057d & 2) == 2) {
                    this.f46059f = Collections.unmodifiableList(this.f46059f);
                    this.f46057d &= -3;
                }
                constructor.valueParameter_ = this.f46059f;
                if ((this.f46057d & 4) == 4) {
                    this.f46060g = Collections.unmodifiableList(this.f46060g);
                    this.f46057d &= -5;
                }
                constructor.versionRequirement_ = this.f46060g;
                if ((this.f46057d & 8) == 8) {
                    this.f46061h = Collections.unmodifiableList(this.f46061h);
                    this.f46057d &= -9;
                }
                constructor.compilerPluginData_ = this.f46061h;
                if ((this.f46057d & 16) == 16) {
                    this.f46062i = Collections.unmodifiableList(this.f46062i);
                    this.f46057d &= -17;
                }
                constructor.annotation_ = this.f46062i;
                constructor.bitField0_ = i6;
                return constructor;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46059f = list;
                this.f46060g = list;
                this.f46061h = list;
                this.f46062i = list;
                N();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public Constructor h() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: O, reason: merged with bridge method [inline-methods] */
            public b k(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    Q(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.f46059f.isEmpty()) {
                        this.f46059f = constructor.valueParameter_;
                        this.f46057d &= -3;
                    } else {
                        E();
                        this.f46059f.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.f46060g.isEmpty()) {
                        this.f46060g = constructor.versionRequirement_;
                        this.f46057d &= -5;
                    } else {
                        F();
                        this.f46060g.addAll(constructor.versionRequirement_);
                    }
                }
                if (!constructor.compilerPluginData_.isEmpty()) {
                    if (this.f46061h.isEmpty()) {
                        this.f46061h = constructor.compilerPluginData_;
                        this.f46057d &= -9;
                    } else {
                        D();
                        this.f46061h.addAll(constructor.compilerPluginData_);
                    }
                }
                if (!constructor.annotation_.isEmpty()) {
                    if (this.f46062i.isEmpty()) {
                        this.f46062i = constructor.annotation_;
                        this.f46057d &= -17;
                    } else {
                        C();
                        this.f46062i.addAll(constructor.annotation_);
                    }
                }
                t(constructor);
                l(i().d(constructor.unknownFields));
                return this;
            }

            public b x(Iterable<? extends Annotation> iterable) {
                C();
                a.AbstractC0905a.a(iterable, this.f46062i);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public Constructor build() {
                Constructor z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void N() {
            }
        }

        private void initFields() {
            this.flags_ = 6;
            List list = Collections.EMPTY_LIST;
            this.valueParameter_ = list;
            this.versionRequirement_ = list;
            this.compilerPluginData_ = list;
            this.annotation_ = list;
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(Constructor constructor) {
            return newBuilder().k(constructor);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public CompilerPluginData getCompilerPluginData(int i6) {
            return this.compilerPluginData_.get(i6);
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Constructor h() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.flags_) : 0;
            for (int i7 = 0; i7 < this.valueParameter_.size(); i7++) {
                p5 += CodedOutputStream.t(2, this.valueParameter_.get(i7));
            }
            for (int i8 = 0; i8 < this.annotation_.size(); i8++) {
                p5 += CodedOutputStream.t(3, this.annotation_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.versionRequirement_.size(); i10++) {
                i9 += CodedOutputStream.q(this.versionRequirement_.get(i10).intValue());
            }
            int size = p5 + i9 + (getVersionRequirementList().size() * 2);
            for (int i11 = 0; i11 < this.compilerPluginData_.size(); i11++) {
                size += CodedOutputStream.t(32, this.compilerPluginData_.get(i11));
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public ValueParameter getValueParameter(int i6) {
            return this.valueParameter_.get(i6);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
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
            for (int i6 = 0; i6 < getValueParameterCount(); i6++) {
                if (!getValueParameter(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getCompilerPluginDataCount(); i7++) {
                if (!getCompilerPluginData(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getAnnotationCount(); i8++) {
                if (!getAnnotation(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Constructor(GeneratedMessageLite.c<Constructor, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.flags_);
            }
            for (int i6 = 0; i6 < this.valueParameter_.size(); i6++) {
                codedOutputStream.h0(2, this.valueParameter_.get(i6));
            }
            for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
                codedOutputStream.h0(3, this.annotation_.get(i7));
            }
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                codedOutputStream.e0(31, this.versionRequirement_.get(i8).intValue());
            }
            for (int i9 = 0; i9 < this.compilerPluginData_.size(); i9++) {
                codedOutputStream.h0(32, this.compilerPluginData_.get(i9));
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Constructor(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                this.flags_ = eVar.s();
                            } else if (K2 == 18) {
                                if ((i6 & 2) != 2) {
                                    this.valueParameter_ = new ArrayList();
                                    i6 |= 2;
                                }
                                this.valueParameter_.add(eVar.u(ValueParameter.PARSER, fVar));
                            } else if (K2 == 26) {
                                if ((i6 & 16) != 16) {
                                    this.annotation_ = new ArrayList();
                                    i6 |= 16;
                                }
                                this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                            } else if (K2 == 248) {
                                if ((i6 & 4) != 4) {
                                    this.versionRequirement_ = new ArrayList();
                                    i6 |= 4;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                            } else if (K2 == 250) {
                                int j6 = eVar.j(eVar.A());
                                if ((i6 & 4) != 4 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i6 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j6);
                            } else if (K2 != 258) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                if ((i6 & 8) != 8) {
                                    this.compilerPluginData_ = new ArrayList();
                                    i6 |= 8;
                                }
                                this.compilerPluginData_.add(eVar.u(CompilerPluginData.PARSER, fVar));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i6 & 2) == 2) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i6 & 16) == 16) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i6 & 4) == 4) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    if ((i6 & 8) == 8) {
                        this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
            if ((i6 & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if ((i6 & 16) == 16) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if ((i6 & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            if ((i6 & 8) == 8) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
    public static final class Contract extends GeneratedMessageLite implements g {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> PARSER = new a();
        private static final Contract defaultInstance;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Contract> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Contract d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Contract(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<Contract, b> implements g {

            /* renamed from: b, reason: collision with root package name */
            private int f46063b;

            /* renamed from: c, reason: collision with root package name */
            private List<Effect> f46064c = Collections.EMPTY_LIST;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < v(); i6++) {
                    if (!u(i6).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46063b & 1) != 1) {
                    this.f46064c = new ArrayList(this.f46064c);
                    this.f46063b |= 1;
                }
            }

            public Contract o() {
                Contract contract = new Contract(this);
                if ((this.f46063b & 1) == 1) {
                    this.f46064c = Collections.unmodifiableList(this.f46064c);
                    this.f46063b &= -2;
                }
                contract.effect_ = this.f46064c;
                return contract;
            }

            public Effect u(int i6) {
                return this.f46064c.get(i6);
            }

            public int v() {
                return this.f46064c.size();
            }

            private b() {
                w();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public Contract build() {
                Contract o5 = o();
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
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public Contract h() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b k(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.f46064c.isEmpty()) {
                        this.f46064c = contract.effect_;
                        this.f46063b &= -2;
                    } else {
                        s();
                        this.f46064c.addAll(contract.effect_);
                    }
                }
                l(i().d(contract.unknownFields));
                return this;
            }

            private void w() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effect_ = Collections.EMPTY_LIST;
        }

        public static b newBuilder(Contract contract) {
            return newBuilder().k(contract);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Contract h() {
            return defaultInstance;
        }

        public Effect getEffect(int i6) {
            return this.effect_.get(i6);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        public List<Effect> getEffectList() {
            return this.effect_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.effect_.size(); i8++) {
                i7 += CodedOutputStream.t(1, this.effect_.get(i8));
            }
            int size = i7 + this.unknownFields.size();
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
            for (int i6 = 0; i6 < getEffectCount(); i6++) {
                if (!getEffect(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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

        private Contract(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.effect_.size(); i6++) {
                codedOutputStream.h0(1, this.effect_.get(i6));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private Contract(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Contract(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int K2 = eVar.K();
                            if (K2 != 0) {
                                if (K2 != 10) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    if (!z6) {
                                        this.effect_ = new ArrayList();
                                        z6 = true;
                                    }
                                    this.effect_.add(eVar.u(Effect.PARSER, fVar));
                                }
                            }
                            z5 = true;
                        } catch (IOException e6) {
                            throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e7) {
                        throw e7.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.effect_ = Collections.unmodifiableList(this.effect_);
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
            if (z6) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
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
    public static final class Effect extends GeneratedMessageLite implements h {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> PARSER = new a();
        private static final Effect defaultInstance;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum EffectType implements h.a {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);

            private static h.b<EffectType> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<EffectType> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public EffectType a(int i6) {
                    return EffectType.valueOf(i6);
                }
            }

            public static EffectType valueOf(int i6) {
                if (i6 == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i6 == 1) {
                    return CALLS;
                }
                if (i6 != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            EffectType(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum InvocationKind implements h.a {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);

            private static h.b<InvocationKind> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<InvocationKind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public InvocationKind a(int i6) {
                    return InvocationKind.valueOf(i6);
                }
            }

            public static InvocationKind valueOf(int i6) {
                if (i6 == 0) {
                    return AT_MOST_ONCE;
                }
                if (i6 == 1) {
                    return EXACTLY_ONCE;
                }
                if (i6 != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            InvocationKind(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Effect> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Effect d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Effect(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<Effect, b> implements h {

            /* renamed from: b, reason: collision with root package name */
            private int f46065b;

            /* renamed from: c, reason: collision with root package name */
            private EffectType f46066c = EffectType.RETURNS_CONSTANT;

            /* renamed from: d, reason: collision with root package name */
            private List<Expression> f46067d = Collections.EMPTY_LIST;

            /* renamed from: e, reason: collision with root package name */
            private Expression f46068e = Expression.getDefaultInstance();

            /* renamed from: f, reason: collision with root package name */
            private InvocationKind f46069f = InvocationKind.AT_MOST_ONCE;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < w(); i6++) {
                    if (!v(i6).isInitialized()) {
                        return false;
                    }
                }
                return !x() || t().isInitialized();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46065b & 2) != 2) {
                    this.f46067d = new ArrayList(this.f46067d);
                    this.f46065b |= 2;
                }
            }

            public Effect o() {
                Effect effect = new Effect(this);
                int i6 = this.f46065b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                effect.effectType_ = this.f46066c;
                if ((this.f46065b & 2) == 2) {
                    this.f46067d = Collections.unmodifiableList(this.f46067d);
                    this.f46065b &= -3;
                }
                effect.effectConstructorArgument_ = this.f46067d;
                if ((i6 & 4) == 4) {
                    i7 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.f46068e;
                if ((i6 & 8) == 8) {
                    i7 |= 4;
                }
                effect.kind_ = this.f46069f;
                effect.bitField0_ = i7;
                return effect;
            }

            public Expression t() {
                return this.f46068e;
            }

            public Expression v(int i6) {
                return this.f46067d.get(i6);
            }

            public int w() {
                return this.f46067d.size();
            }

            public boolean x() {
                return (this.f46065b & 4) == 4;
            }

            public b z(Expression expression) {
                if ((this.f46065b & 4) != 4 || this.f46068e == Expression.getDefaultInstance()) {
                    this.f46068e = expression;
                } else {
                    this.f46068e = Expression.newBuilder(this.f46068e).k(expression).o();
                }
                this.f46065b |= 4;
                return this;
            }

            private b() {
                y();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b k(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    C(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.f46067d.isEmpty()) {
                        this.f46067d = effect.effectConstructorArgument_;
                        this.f46065b &= -3;
                    } else {
                        s();
                        this.f46067d.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    z(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    D(effect.getKind());
                }
                l(i().d(effect.unknownFields));
                return this;
            }

            public b C(EffectType effectType) {
                effectType.getClass();
                this.f46065b |= 1;
                this.f46066c = effectType;
                return this;
            }

            public b D(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.f46065b |= 8;
                this.f46069f = invocationKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public Effect build() {
                Effect o5 = o();
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
            public Effect h() {
                return Effect.getDefaultInstance();
            }

            private void y() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.EMPTY_LIST;
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static b newBuilder(Effect effect) {
            return newBuilder().k(effect);
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Effect h() {
            return defaultInstance;
        }

        public Expression getEffectConstructorArgument(int i6) {
            return this.effectConstructorArgument_.get(i6);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public List<Expression> getEffectConstructorArgumentList() {
            return this.effectConstructorArgument_;
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.i(1, this.effectType_.getNumber()) : 0;
            for (int i8 = 0; i8 < this.effectConstructorArgument_.size(); i8++) {
                i7 += CodedOutputStream.t(2, this.effectConstructorArgument_.get(i8));
            }
            if ((this.bitField0_ & 2) == 2) {
                i7 += CodedOutputStream.t(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i7 += CodedOutputStream.i(4, this.kind_.getNumber());
            }
            int size = i7 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKind() {
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
            for (int i6 = 0; i6 < getEffectConstructorArgumentCount(); i6++) {
                if (!getEffectConstructorArgument(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Effect(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.W(1, this.effectType_.getNumber());
            }
            for (int i6 = 0; i6 < this.effectConstructorArgument_.size(); i6++) {
                codedOutputStream.h0(2, this.effectConstructorArgument_.get(i6));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.h0(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.W(4, this.kind_.getNumber());
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private Effect(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Effect(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            char c6 = 0;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 8) {
                                int n6 = eVar.n();
                                EffectType valueOf = EffectType.valueOf(n6);
                                if (valueOf == null) {
                                    K.s0(K2);
                                    K.s0(n6);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.effectType_ = valueOf;
                                }
                            } else if (K2 == 18) {
                                if ((c6 & 2) != 2) {
                                    this.effectConstructorArgument_ = new ArrayList();
                                    c6 = 2;
                                }
                                this.effectConstructorArgument_.add(eVar.u(Expression.PARSER, fVar));
                            } else if (K2 == 26) {
                                Expression.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                Expression expression = (Expression) eVar.u(Expression.PARSER, fVar);
                                this.conclusionOfConditionalEffect_ = expression;
                                if (builder != null) {
                                    builder.k(expression);
                                    this.conclusionOfConditionalEffect_ = builder.o();
                                }
                                this.bitField0_ |= 2;
                            } else if (K2 != 32) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                int n7 = eVar.n();
                                InvocationKind valueOf2 = InvocationKind.valueOf(n7);
                                if (valueOf2 == null) {
                                    K.s0(K2);
                                    K.s0(n7);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf2;
                                }
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((c6 & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            if ((c6 & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements i {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> PARSER = new a();
        private static final EnumEntry defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<EnumEntry> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public EnumEntry d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new EnumEntry(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<EnumEntry, b> implements i {

            /* renamed from: d, reason: collision with root package name */
            private int f46070d;

            /* renamed from: e, reason: collision with root package name */
            private int f46071e;

            /* renamed from: f, reason: collision with root package name */
            private List<Annotation> f46072f = Collections.EMPTY_LIST;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < E(); i6++) {
                    if (!D(i6).isInitialized()) {
                        return false;
                    }
                }
                return s();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46070d & 2) != 2) {
                    this.f46072f = new ArrayList(this.f46072f);
                    this.f46070d |= 2;
                }
            }

            public Annotation D(int i6) {
                return this.f46072f.get(i6);
            }

            public int E() {
                return this.f46072f.size();
            }

            public b J(int i6) {
                this.f46070d |= 1;
                this.f46071e = i6;
                return this;
            }

            public EnumEntry z() {
                EnumEntry enumEntry = new EnumEntry(this);
                int i6 = (this.f46070d & 1) != 1 ? 0 : 1;
                enumEntry.name_ = this.f46071e;
                if ((this.f46070d & 2) == 2) {
                    this.f46072f = Collections.unmodifiableList(this.f46072f);
                    this.f46070d &= -3;
                }
                enumEntry.annotation_ = this.f46072f;
                enumEntry.bitField0_ = i6;
                return enumEntry;
            }

            private b() {
                G();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public EnumEntry h() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: H, reason: merged with bridge method [inline-methods] */
            public b k(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    J(enumEntry.getName());
                }
                if (!enumEntry.annotation_.isEmpty()) {
                    if (this.f46072f.isEmpty()) {
                        this.f46072f = enumEntry.annotation_;
                        this.f46070d &= -3;
                    } else {
                        C();
                        this.f46072f.addAll(enumEntry.annotation_);
                    }
                }
                t(enumEntry);
                l(i().d(enumEntry.unknownFields));
                return this;
            }

            public b x(Annotation annotation) {
                annotation.getClass();
                C();
                this.f46072f.add(annotation);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public EnumEntry build() {
                EnumEntry z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void G() {
            }
        }

        private void initFields() {
            this.name_ = 0;
            this.annotation_ = Collections.EMPTY_LIST;
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(EnumEntry enumEntry) {
            return newBuilder().k(enumEntry);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public EnumEntry h() {
            return defaultInstance;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.name_) : 0;
            for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
                p5 += CodedOutputStream.t(2, this.annotation_.get(i7));
            }
            int extensionsSerializedSize = p5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
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
            for (int i6 = 0; i6 < getAnnotationCount(); i6++) {
                if (!getAnnotation(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private EnumEntry(GeneratedMessageLite.c<EnumEntry, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.name_);
            }
            for (int i6 = 0; i6 < this.annotation_.size(); i6++) {
                codedOutputStream.h0(2, this.annotation_.get(i6));
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private EnumEntry(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            char c6 = 0;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            } else if (K2 != 18) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                if ((c6 & 2) != 2) {
                                    this.annotation_ = new ArrayList();
                                    c6 = 2;
                                }
                                this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((c6 & 2) == 2) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
            if ((c6 & 2) == 2) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
    public static final class Expression extends GeneratedMessageLite implements j {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> PARSER = new a();
        private static final Expression defaultInstance;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int valueParameterReference_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum ConstantValue implements h.a {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);

            private static h.b<ConstantValue> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<ConstantValue> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public ConstantValue a(int i6) {
                    return ConstantValue.valueOf(i6);
                }
            }

            public static ConstantValue valueOf(int i6) {
                if (i6 == 0) {
                    return TRUE;
                }
                if (i6 == 1) {
                    return FALSE;
                }
                if (i6 != 2) {
                    return null;
                }
                return NULL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            ConstantValue(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Expression> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Expression d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Expression(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<Expression, b> implements j {

            /* renamed from: b, reason: collision with root package name */
            private int f46073b;

            /* renamed from: c, reason: collision with root package name */
            private int f46074c;

            /* renamed from: d, reason: collision with root package name */
            private int f46075d;

            /* renamed from: e, reason: collision with root package name */
            private ConstantValue f46076e = ConstantValue.TRUE;

            /* renamed from: f, reason: collision with root package name */
            private Type f46077f = Type.getDefaultInstance();

            /* renamed from: g, reason: collision with root package name */
            private int f46078g;

            /* renamed from: h, reason: collision with root package name */
            private List<Expression> f46079h;

            /* renamed from: i, reason: collision with root package name */
            private List<Expression> f46080i;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46073b & 32) != 32) {
                    this.f46079h = new ArrayList(this.f46079h);
                    this.f46073b |= 32;
                }
            }

            private void t() {
                if ((this.f46073b & 64) != 64) {
                    this.f46080i = new ArrayList(this.f46080i);
                    this.f46073b |= 64;
                }
            }

            public boolean A() {
                return (this.f46073b & 8) == 8;
            }

            public b E(Type type) {
                if ((this.f46073b & 8) != 8 || this.f46077f == Type.getDefaultInstance()) {
                    this.f46077f = type;
                } else {
                    this.f46077f = Type.newBuilder(this.f46077f).k(type).z();
                }
                this.f46073b |= 8;
                return this;
            }

            public b G(int i6) {
                this.f46073b |= 1;
                this.f46074c = i6;
                return this;
            }

            public b H(int i6) {
                this.f46073b |= 16;
                this.f46078g = i6;
                return this;
            }

            public b I(int i6) {
                this.f46073b |= 2;
                this.f46075d = i6;
                return this;
            }

            public Expression o() {
                Expression expression = new Expression(this);
                int i6 = this.f46073b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                expression.flags_ = this.f46074c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                expression.valueParameterReference_ = this.f46075d;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                expression.constantValue_ = this.f46076e;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                expression.isInstanceType_ = this.f46077f;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                expression.isInstanceTypeId_ = this.f46078g;
                if ((this.f46073b & 32) == 32) {
                    this.f46079h = Collections.unmodifiableList(this.f46079h);
                    this.f46073b &= -33;
                }
                expression.andArgument_ = this.f46079h;
                if ((this.f46073b & 64) == 64) {
                    this.f46080i = Collections.unmodifiableList(this.f46080i);
                    this.f46073b &= -65;
                }
                expression.orArgument_ = this.f46080i;
                expression.bitField0_ = i7;
                return expression;
            }

            public Expression u(int i6) {
                return this.f46079h.get(i6);
            }

            public int v() {
                return this.f46079h.size();
            }

            public Type x() {
                return this.f46077f;
            }

            public Expression y(int i6) {
                return this.f46080i.get(i6);
            }

            public int z() {
                return this.f46080i.size();
            }

            private b() {
                List<Expression> list = Collections.EMPTY_LIST;
                this.f46079h = list;
                this.f46080i = list;
                B();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b k(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    G(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    I(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    F(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    E(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    H(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.f46079h.isEmpty()) {
                        this.f46079h = expression.andArgument_;
                        this.f46073b &= -33;
                    } else {
                        s();
                        this.f46079h.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.f46080i.isEmpty()) {
                        this.f46080i = expression.orArgument_;
                        this.f46073b &= -65;
                    } else {
                        t();
                        this.f46080i.addAll(expression.orArgument_);
                    }
                }
                l(i().d(expression.unknownFields));
                return this;
            }

            public b F(ConstantValue constantValue) {
                constantValue.getClass();
                this.f46073b |= 4;
                this.f46076e = constantValue;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (A() && !x().isInitialized()) {
                    return false;
                }
                for (int i6 = 0; i6 < v(); i6++) {
                    if (!u(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < z(); i7++) {
                    if (!y(i7).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public Expression build() {
                Expression o5 = o();
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public Expression h() {
                return Expression.getDefaultInstance();
            }

            private void B() {
            }
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            List<Expression> list = Collections.EMPTY_LIST;
            this.andArgument_ = list;
            this.orArgument_ = list;
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(Expression expression) {
            return newBuilder().k(expression);
        }

        public Expression getAndArgument(int i6) {
            return this.andArgument_.get(i6);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public List<Expression> getAndArgumentList() {
            return this.andArgument_;
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Expression h() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int i6) {
            return this.orArgument_.get(i6);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public List<Expression> getOrArgumentList() {
            return this.orArgument_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.i(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.t(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.p(5, this.isInstanceTypeId_);
            }
            for (int i7 = 0; i7 < this.andArgument_.size(); i7++) {
                p5 += CodedOutputStream.t(6, this.andArgument_.get(i7));
            }
            for (int i8 = 0; i8 < this.orArgument_.size(); i8++) {
                p5 += CodedOutputStream.t(7, this.orArgument_.get(i8));
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasValueParameterReference() {
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
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getAndArgumentCount(); i6++) {
                if (!getAndArgument(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getOrArgumentCount(); i7++) {
                if (!getOrArgument(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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

        private Expression(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.W(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.h0(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(5, this.isInstanceTypeId_);
            }
            for (int i6 = 0; i6 < this.andArgument_.size(); i6++) {
                codedOutputStream.h0(6, this.andArgument_.get(i6));
            }
            for (int i7 = 0; i7 < this.orArgument_.size(); i7++) {
                codedOutputStream.h0(7, this.orArgument_.get(i7));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private Expression(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Expression(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                this.flags_ = eVar.s();
                            } else if (K2 == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = eVar.s();
                            } else if (K2 == 24) {
                                int n6 = eVar.n();
                                ConstantValue valueOf = ConstantValue.valueOf(n6);
                                if (valueOf == null) {
                                    K.s0(K2);
                                    K.s0(n6);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = valueOf;
                                }
                            } else if (K2 == 34) {
                                Type.b builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                Type type = (Type) eVar.u(Type.PARSER, fVar);
                                this.isInstanceType_ = type;
                                if (builder != null) {
                                    builder.k(type);
                                    this.isInstanceType_ = builder.z();
                                }
                                this.bitField0_ |= 8;
                            } else if (K2 == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = eVar.s();
                            } else if (K2 == 50) {
                                if ((i6 & 32) != 32) {
                                    this.andArgument_ = new ArrayList();
                                    i6 |= 32;
                                }
                                this.andArgument_.add(eVar.u(PARSER, fVar));
                            } else if (K2 != 58) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                if ((i6 & 64) != 64) {
                                    this.orArgument_ = new ArrayList();
                                    i6 |= 64;
                                }
                                this.orArgument_.add(eVar.u(PARSER, fVar));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i6 & 32) == 32) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if ((i6 & 64) == 64) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            if ((i6 & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if ((i6 & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements k {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Function> PARSER = new a();
        private static final Function defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<ValueParameter> contextParameter_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private List<Annotation> extensionReceiverAnnotation_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Function> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Function d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Function(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Function, b> implements k {

            /* renamed from: d, reason: collision with root package name */
            private int f46081d;

            /* renamed from: g, reason: collision with root package name */
            private int f46084g;

            /* renamed from: i, reason: collision with root package name */
            private int f46086i;

            /* renamed from: j, reason: collision with root package name */
            private List<TypeParameter> f46087j;

            /* renamed from: k, reason: collision with root package name */
            private Type f46088k;

            /* renamed from: l, reason: collision with root package name */
            private int f46089l;

            /* renamed from: m, reason: collision with root package name */
            private List<Type> f46090m;

            /* renamed from: n, reason: collision with root package name */
            private List<Integer> f46091n;

            /* renamed from: o, reason: collision with root package name */
            private List<ValueParameter> f46092o;

            /* renamed from: p, reason: collision with root package name */
            private List<ValueParameter> f46093p;

            /* renamed from: q, reason: collision with root package name */
            private TypeTable f46094q;

            /* renamed from: r, reason: collision with root package name */
            private List<Integer> f46095r;

            /* renamed from: s, reason: collision with root package name */
            private Contract f46096s;

            /* renamed from: t, reason: collision with root package name */
            private List<CompilerPluginData> f46097t;

            /* renamed from: u, reason: collision with root package name */
            private List<Annotation> f46098u;

            /* renamed from: v, reason: collision with root package name */
            private List<Annotation> f46099v;

            /* renamed from: e, reason: collision with root package name */
            private int f46082e = 6;

            /* renamed from: f, reason: collision with root package name */
            private int f46083f = 6;

            /* renamed from: h, reason: collision with root package name */
            private Type f46085h = Type.getDefaultInstance();

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: n0, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b C() {
                return new b();
            }

            private void D() {
                if ((this.f46081d & 65536) != 65536) {
                    this.f46098u = new ArrayList(this.f46098u);
                    this.f46081d |= 65536;
                }
            }

            private void E() {
                if ((this.f46081d & 32768) != 32768) {
                    this.f46097t = new ArrayList(this.f46097t);
                    this.f46081d |= 32768;
                }
            }

            private void F() {
                if ((this.f46081d & 1024) != 1024) {
                    this.f46092o = new ArrayList(this.f46092o);
                    this.f46081d |= 1024;
                }
            }

            private void G() {
                if ((this.f46081d & 512) != 512) {
                    this.f46091n = new ArrayList(this.f46091n);
                    this.f46081d |= 512;
                }
            }

            private void H() {
                if ((this.f46081d & 256) != 256) {
                    this.f46090m = new ArrayList(this.f46090m);
                    this.f46081d |= 256;
                }
            }

            private void I() {
                if ((this.f46081d & 131072) != 131072) {
                    this.f46099v = new ArrayList(this.f46099v);
                    this.f46081d |= 131072;
                }
            }

            private void J() {
                if ((this.f46081d & 32) != 32) {
                    this.f46087j = new ArrayList(this.f46087j);
                    this.f46081d |= 32;
                }
            }

            private void K() {
                if ((this.f46081d & 2048) != 2048) {
                    this.f46093p = new ArrayList(this.f46093p);
                    this.f46081d |= 2048;
                }
            }

            private void L() {
                if ((this.f46081d & 8192) != 8192) {
                    this.f46095r = new ArrayList(this.f46095r);
                    this.f46081d |= 8192;
                }
            }

            public Function A() {
                Function function = new Function(this);
                int i6 = this.f46081d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                function.flags_ = this.f46082e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                function.oldFlags_ = this.f46083f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                function.name_ = this.f46084g;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                function.returnType_ = this.f46085h;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                function.returnTypeId_ = this.f46086i;
                if ((this.f46081d & 32) == 32) {
                    this.f46087j = Collections.unmodifiableList(this.f46087j);
                    this.f46081d &= -33;
                }
                function.typeParameter_ = this.f46087j;
                if ((i6 & 64) == 64) {
                    i7 |= 32;
                }
                function.receiverType_ = this.f46088k;
                if ((i6 & 128) == 128) {
                    i7 |= 64;
                }
                function.receiverTypeId_ = this.f46089l;
                if ((this.f46081d & 256) == 256) {
                    this.f46090m = Collections.unmodifiableList(this.f46090m);
                    this.f46081d &= -257;
                }
                function.contextReceiverType_ = this.f46090m;
                if ((this.f46081d & 512) == 512) {
                    this.f46091n = Collections.unmodifiableList(this.f46091n);
                    this.f46081d &= -513;
                }
                function.contextReceiverTypeId_ = this.f46091n;
                if ((this.f46081d & 1024) == 1024) {
                    this.f46092o = Collections.unmodifiableList(this.f46092o);
                    this.f46081d &= -1025;
                }
                function.contextParameter_ = this.f46092o;
                if ((this.f46081d & 2048) == 2048) {
                    this.f46093p = Collections.unmodifiableList(this.f46093p);
                    this.f46081d &= -2049;
                }
                function.valueParameter_ = this.f46093p;
                if ((i6 & 4096) == 4096) {
                    i7 |= 128;
                }
                function.typeTable_ = this.f46094q;
                if ((this.f46081d & 8192) == 8192) {
                    this.f46095r = Collections.unmodifiableList(this.f46095r);
                    this.f46081d &= -8193;
                }
                function.versionRequirement_ = this.f46095r;
                if ((i6 & 16384) == 16384) {
                    i7 |= 256;
                }
                function.contract_ = this.f46096s;
                if ((this.f46081d & 32768) == 32768) {
                    this.f46097t = Collections.unmodifiableList(this.f46097t);
                    this.f46081d &= -32769;
                }
                function.compilerPluginData_ = this.f46097t;
                if ((this.f46081d & 65536) == 65536) {
                    this.f46098u = Collections.unmodifiableList(this.f46098u);
                    this.f46081d &= -65537;
                }
                function.annotation_ = this.f46098u;
                if ((this.f46081d & 131072) == 131072) {
                    this.f46099v = Collections.unmodifiableList(this.f46099v);
                    this.f46081d &= -131073;
                }
                function.extensionReceiverAnnotation_ = this.f46099v;
                function.bitField0_ = i7;
                return function;
            }

            public Annotation M(int i6) {
                return this.f46098u.get(i6);
            }

            public int N() {
                return this.f46098u.size();
            }

            public CompilerPluginData O(int i6) {
                return this.f46097t.get(i6);
            }

            public int P() {
                return this.f46097t.size();
            }

            public ValueParameter Q(int i6) {
                return this.f46092o.get(i6);
            }

            public int R() {
                return this.f46092o.size();
            }

            public Type S(int i6) {
                return this.f46090m.get(i6);
            }

            public int T() {
                return this.f46090m.size();
            }

            public Contract U() {
                return this.f46096s;
            }

            public Annotation W(int i6) {
                return this.f46099v.get(i6);
            }

            public int X() {
                return this.f46099v.size();
            }

            public Type Y() {
                return this.f46088k;
            }

            public Type Z() {
                return this.f46085h;
            }

            public TypeParameter a0(int i6) {
                return this.f46087j.get(i6);
            }

            public int b0() {
                return this.f46087j.size();
            }

            public TypeTable c0() {
                return this.f46094q;
            }

            public ValueParameter d0(int i6) {
                return this.f46093p.get(i6);
            }

            public int e0() {
                return this.f46093p.size();
            }

            public boolean f0() {
                return (this.f46081d & 16384) == 16384;
            }

            public boolean g0() {
                return (this.f46081d & 4) == 4;
            }

            public boolean h0() {
                return (this.f46081d & 64) == 64;
            }

            public boolean i0() {
                return (this.f46081d & 8) == 8;
            }

            public boolean j0() {
                return (this.f46081d & 4096) == 4096;
            }

            public b l0(Contract contract) {
                if ((this.f46081d & 16384) != 16384 || this.f46096s == Contract.getDefaultInstance()) {
                    this.f46096s = contract;
                } else {
                    this.f46096s = Contract.newBuilder(this.f46096s).k(contract).o();
                }
                this.f46081d |= 16384;
                return this;
            }

            public b o0(Type type) {
                if ((this.f46081d & 64) != 64 || this.f46088k == Type.getDefaultInstance()) {
                    this.f46088k = type;
                } else {
                    this.f46088k = Type.newBuilder(this.f46088k).k(type).z();
                }
                this.f46081d |= 64;
                return this;
            }

            public b p0(Type type) {
                if ((this.f46081d & 8) != 8 || this.f46085h == Type.getDefaultInstance()) {
                    this.f46085h = type;
                } else {
                    this.f46085h = Type.newBuilder(this.f46085h).k(type).z();
                }
                this.f46081d |= 8;
                return this;
            }

            public b q0(TypeTable typeTable) {
                if ((this.f46081d & 4096) != 4096 || this.f46094q == TypeTable.getDefaultInstance()) {
                    this.f46094q = typeTable;
                } else {
                    this.f46094q = TypeTable.newBuilder(this.f46094q).k(typeTable).o();
                }
                this.f46081d |= 4096;
                return this;
            }

            public b r0(int i6) {
                this.f46081d |= 1;
                this.f46082e = i6;
                return this;
            }

            public b s0(int i6) {
                this.f46081d |= 4;
                this.f46084g = i6;
                return this;
            }

            public b t0(int i6) {
                this.f46081d |= 2;
                this.f46083f = i6;
                return this;
            }

            public b u0(int i6) {
                this.f46081d |= 128;
                this.f46089l = i6;
                return this;
            }

            public b v0(int i6) {
                this.f46081d |= 16;
                this.f46086i = i6;
                return this;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46087j = list;
                this.f46088k = Type.getDefaultInstance();
                this.f46090m = list;
                this.f46091n = list;
                this.f46092o = list;
                this.f46093p = list;
                this.f46094q = TypeTable.getDefaultInstance();
                this.f46095r = list;
                this.f46096s = Contract.getDefaultInstance();
                this.f46097t = list;
                this.f46098u = list;
                this.f46099v = list;
                k0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b p() {
                return C().k(A());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: V, reason: merged with bridge method [inline-methods] */
            public Function h() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!g0()) {
                    return false;
                }
                if (i0() && !Z().isInitialized()) {
                    return false;
                }
                for (int i6 = 0; i6 < b0(); i6++) {
                    if (!a0(i6).isInitialized()) {
                        return false;
                    }
                }
                if (h0() && !Y().isInitialized()) {
                    return false;
                }
                for (int i7 = 0; i7 < T(); i7++) {
                    if (!S(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < R(); i8++) {
                    if (!Q(i8).isInitialized()) {
                        return false;
                    }
                }
                for (int i9 = 0; i9 < e0(); i9++) {
                    if (!d0(i9).isInitialized()) {
                        return false;
                    }
                }
                if (j0() && !c0().isInitialized()) {
                    return false;
                }
                if (f0() && !U().isInitialized()) {
                    return false;
                }
                for (int i10 = 0; i10 < P(); i10++) {
                    if (!O(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < N(); i11++) {
                    if (!M(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < X(); i12++) {
                    if (!W(i12).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m0, reason: merged with bridge method [inline-methods] */
            public b k(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    r0(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    t0(function.getOldFlags());
                }
                if (function.hasName()) {
                    s0(function.getName());
                }
                if (function.hasReturnType()) {
                    p0(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    v0(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.f46087j.isEmpty()) {
                        this.f46087j = function.typeParameter_;
                        this.f46081d &= -33;
                    } else {
                        J();
                        this.f46087j.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    o0(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    u0(function.getReceiverTypeId());
                }
                if (!function.contextReceiverType_.isEmpty()) {
                    if (this.f46090m.isEmpty()) {
                        this.f46090m = function.contextReceiverType_;
                        this.f46081d &= -257;
                    } else {
                        H();
                        this.f46090m.addAll(function.contextReceiverType_);
                    }
                }
                if (!function.contextReceiverTypeId_.isEmpty()) {
                    if (this.f46091n.isEmpty()) {
                        this.f46091n = function.contextReceiverTypeId_;
                        this.f46081d &= -513;
                    } else {
                        G();
                        this.f46091n.addAll(function.contextReceiverTypeId_);
                    }
                }
                if (!function.contextParameter_.isEmpty()) {
                    if (this.f46092o.isEmpty()) {
                        this.f46092o = function.contextParameter_;
                        this.f46081d &= -1025;
                    } else {
                        F();
                        this.f46092o.addAll(function.contextParameter_);
                    }
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.f46093p.isEmpty()) {
                        this.f46093p = function.valueParameter_;
                        this.f46081d &= -2049;
                    } else {
                        K();
                        this.f46093p.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    q0(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.f46095r.isEmpty()) {
                        this.f46095r = function.versionRequirement_;
                        this.f46081d &= -8193;
                    } else {
                        L();
                        this.f46095r.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    l0(function.getContract());
                }
                if (!function.compilerPluginData_.isEmpty()) {
                    if (this.f46097t.isEmpty()) {
                        this.f46097t = function.compilerPluginData_;
                        this.f46081d &= -32769;
                    } else {
                        E();
                        this.f46097t.addAll(function.compilerPluginData_);
                    }
                }
                if (!function.annotation_.isEmpty()) {
                    if (this.f46098u.isEmpty()) {
                        this.f46098u = function.annotation_;
                        this.f46081d &= -65537;
                    } else {
                        D();
                        this.f46098u.addAll(function.annotation_);
                    }
                }
                if (!function.extensionReceiverAnnotation_.isEmpty()) {
                    if (this.f46099v.isEmpty()) {
                        this.f46099v = function.extensionReceiverAnnotation_;
                        this.f46081d &= -131073;
                    } else {
                        I();
                        this.f46099v.addAll(function.extensionReceiverAnnotation_);
                    }
                }
                t(function);
                l(i().d(function.unknownFields));
                return this;
            }

            public b x(Iterable<? extends Annotation> iterable) {
                D();
                a.AbstractC0905a.a(iterable, this.f46098u);
                return this;
            }

            public b y(Iterable<? extends Annotation> iterable) {
                I();
                a.AbstractC0905a.a(iterable, this.f46099v);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public Function build() {
                Function A = A();
                if (A.isInitialized()) {
                    return A;
                }
                throw a.AbstractC0905a.f(A);
            }

            private void k0() {
            }
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.contextParameter_ = list;
            this.valueParameter_ = list;
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = list;
            this.contract_ = Contract.getDefaultInstance();
            this.compilerPluginData_ = list;
            this.annotation_ = list;
            this.extensionReceiverAnnotation_ = list;
        }

        public static b newBuilder() {
            return b.C();
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(Function function) {
            return newBuilder().k(function);
        }

        public static Function parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.b(inputStream, fVar);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public CompilerPluginData getCompilerPluginData(int i6) {
            return this.compilerPluginData_.get(i6);
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public ValueParameter getContextParameter(int i6) {
            return this.contextParameter_.get(i6);
        }

        public int getContextParameterCount() {
            return this.contextParameter_.size();
        }

        public Type getContextReceiverType(int i6) {
            return this.contextReceiverType_.get(i6);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public Contract getContract() {
            return this.contract_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Function h() {
            return defaultInstance;
        }

        public Annotation getExtensionReceiverAnnotation(int i6) {
            return this.extensionReceiverAnnotation_.get(i6);
        }

        public int getExtensionReceiverAnnotationCount() {
            return this.extensionReceiverAnnotation_.size();
        }

        public List<Annotation> getExtensionReceiverAnnotationList() {
            return this.extensionReceiverAnnotation_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 2) == 2 ? CodedOutputStream.p(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.p(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.t(3, this.returnType_);
            }
            for (int i7 = 0; i7 < this.typeParameter_.size(); i7++) {
                p5 += CodedOutputStream.t(4, this.typeParameter_.get(i7));
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.t(5, this.receiverType_);
            }
            for (int i8 = 0; i8 < this.valueParameter_.size(); i8++) {
                p5 += CodedOutputStream.t(6, this.valueParameter_.get(i8));
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.p(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                p5 += CodedOutputStream.p(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                p5 += CodedOutputStream.p(9, this.flags_);
            }
            for (int i9 = 0; i9 < this.contextReceiverType_.size(); i9++) {
                p5 += CodedOutputStream.t(10, this.contextReceiverType_.get(i9));
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.contextReceiverTypeId_.size(); i11++) {
                i10 += CodedOutputStream.q(this.contextReceiverTypeId_.get(i11).intValue());
            }
            int i12 = p5 + i10;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i12 = i12 + 1 + CodedOutputStream.q(i10);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i10;
            for (int i13 = 0; i13 < this.annotation_.size(); i13++) {
                i12 += CodedOutputStream.t(12, this.annotation_.get(i13));
            }
            for (int i14 = 0; i14 < this.contextParameter_.size(); i14++) {
                i12 += CodedOutputStream.t(13, this.contextParameter_.get(i14));
            }
            if ((this.bitField0_ & 128) == 128) {
                i12 += CodedOutputStream.t(30, this.typeTable_);
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.versionRequirement_.size(); i16++) {
                i15 += CodedOutputStream.q(this.versionRequirement_.get(i16).intValue());
            }
            int size = i12 + i15 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.t(32, this.contract_);
            }
            for (int i17 = 0; i17 < this.compilerPluginData_.size(); i17++) {
                size += CodedOutputStream.t(33, this.compilerPluginData_.get(i17));
            }
            for (int i18 = 0; i18 < this.extensionReceiverAnnotation_.size(); i18++) {
                size += CodedOutputStream.t(34, this.extensionReceiverAnnotation_.get(i18));
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeParameter getTypeParameter(int i6) {
            return this.typeParameter_.get(i6);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int i6) {
            return this.valueParameter_.get(i6);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getTypeParameterCount(); i6++) {
                if (!getTypeParameter(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i7 = 0; i7 < getContextReceiverTypeCount(); i7++) {
                if (!getContextReceiverType(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getContextParameterCount(); i8++) {
                if (!getContextParameter(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i9 = 0; i9 < getValueParameterCount(); i9++) {
                if (!getValueParameter(i9).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasContract() && !getContract().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getCompilerPluginDataCount(); i10++) {
                if (!getCompilerPluginData(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getAnnotationCount(); i11++) {
                if (!getAnnotation(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getExtensionReceiverAnnotationCount(); i12++) {
                if (!getExtensionReceiverAnnotation(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Function(GeneratedMessageLite.c<Function, ?> cVar) {
            super(cVar);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.e0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.h0(3, this.returnType_);
            }
            for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
                codedOutputStream.h0(4, this.typeParameter_.get(i6));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.h0(5, this.receiverType_);
            }
            for (int i7 = 0; i7 < this.valueParameter_.size(); i7++) {
                codedOutputStream.h0(6, this.valueParameter_.get(i7));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.e0(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(9, this.flags_);
            }
            for (int i8 = 0; i8 < this.contextReceiverType_.size(); i8++) {
                codedOutputStream.h0(10, this.contextReceiverType_.get(i8));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.s0(90);
                codedOutputStream.s0(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i9 = 0; i9 < this.contextReceiverTypeId_.size(); i9++) {
                codedOutputStream.f0(this.contextReceiverTypeId_.get(i9).intValue());
            }
            for (int i10 = 0; i10 < this.annotation_.size(); i10++) {
                codedOutputStream.h0(12, this.annotation_.get(i10));
            }
            for (int i11 = 0; i11 < this.contextParameter_.size(); i11++) {
                codedOutputStream.h0(13, this.contextParameter_.get(i11));
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.h0(30, this.typeTable_);
            }
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                codedOutputStream.e0(31, this.versionRequirement_.get(i12).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.h0(32, this.contract_);
            }
            for (int i13 = 0; i13 < this.compilerPluginData_.size(); i13++) {
                codedOutputStream.h0(33, this.compilerPluginData_.get(i13));
            }
            for (int i14 = 0; i14 < this.extensionReceiverAnnotation_.size(); i14++) {
                codedOutputStream.h0(34, this.extensionReceiverAnnotation_.get(i14));
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Function(boolean z5) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:40:0x032e  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x033a  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0346  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0352  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x035e  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x036a  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0376  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0385  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0393  */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private Function(kotlin.reflect.jvm.internal.impl.protobuf.e r22, kotlin.reflect.jvm.internal.impl.protobuf.f r23) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                Method dump skipped, instructions count: 1168
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.<init>(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum MemberKind implements h.a {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);

        private static h.b<MemberKind> internalValueMap = new a();
        private final int value;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a implements h.b<MemberKind> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MemberKind a(int i6) {
                return MemberKind.valueOf(i6);
            }
        }

        public static MemberKind valueOf(int i6) {
            if (i6 == 0) {
                return DECLARATION;
            }
            if (i6 == 1) {
                return FAKE_OVERRIDE;
            }
            if (i6 == 2) {
                return DELEGATION;
            }
            if (i6 != 3) {
                return null;
            }
            return SYNTHESIZED;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        MemberKind(int i6, int i7) {
            this.value = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Modality implements h.a {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);

        private static h.b<Modality> internalValueMap = new a();
        private final int value;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a implements h.b<Modality> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Modality a(int i6) {
                return Modality.valueOf(i6);
            }
        }

        public static Modality valueOf(int i6) {
            if (i6 == 0) {
                return FINAL;
            }
            if (i6 == 1) {
                return OPEN;
            }
            if (i6 == 2) {
                return ABSTRACT;
            }
            if (i6 != 3) {
                return null;
            }
            return SEALED;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        Modality(int i6, int i7) {
            this.value = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements m {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Package> PARSER = new a();
        private static final Package defaultInstance;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Package> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Package d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Package(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Package, b> implements m {

            /* renamed from: d, reason: collision with root package name */
            private int f46100d;

            /* renamed from: e, reason: collision with root package name */
            private List<Function> f46101e;

            /* renamed from: f, reason: collision with root package name */
            private List<Property> f46102f;

            /* renamed from: g, reason: collision with root package name */
            private List<TypeAlias> f46103g;

            /* renamed from: h, reason: collision with root package name */
            private TypeTable f46104h;

            /* renamed from: i, reason: collision with root package name */
            private VersionRequirementTable f46105i;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < G(); i6++) {
                    if (!F(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < I(); i7++) {
                    if (!H(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < K(); i8++) {
                    if (!J(i8).isInitialized()) {
                        return false;
                    }
                }
                return (!M() || L().isInitialized()) && s();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b A() {
                return new b();
            }

            private void B() {
                if ((this.f46100d & 1) != 1) {
                    this.f46101e = new ArrayList(this.f46101e);
                    this.f46100d |= 1;
                }
            }

            private void C() {
                if ((this.f46100d & 2) != 2) {
                    this.f46102f = new ArrayList(this.f46102f);
                    this.f46100d |= 2;
                }
            }

            private void D() {
                if ((this.f46100d & 4) != 4) {
                    this.f46103g = new ArrayList(this.f46103g);
                    this.f46100d |= 4;
                }
            }

            public Function F(int i6) {
                return this.f46101e.get(i6);
            }

            public int G() {
                return this.f46101e.size();
            }

            public Property H(int i6) {
                return this.f46102f.get(i6);
            }

            public int I() {
                return this.f46102f.size();
            }

            public TypeAlias J(int i6) {
                return this.f46103g.get(i6);
            }

            public int K() {
                return this.f46103g.size();
            }

            public TypeTable L() {
                return this.f46104h;
            }

            public boolean M() {
                return (this.f46100d & 8) == 8;
            }

            public b Q(TypeTable typeTable) {
                if ((this.f46100d & 8) != 8 || this.f46104h == TypeTable.getDefaultInstance()) {
                    this.f46104h = typeTable;
                } else {
                    this.f46104h = TypeTable.newBuilder(this.f46104h).k(typeTable).o();
                }
                this.f46100d |= 8;
                return this;
            }

            public b R(VersionRequirementTable versionRequirementTable) {
                if ((this.f46100d & 16) != 16 || this.f46105i == VersionRequirementTable.getDefaultInstance()) {
                    this.f46105i = versionRequirementTable;
                } else {
                    this.f46105i = VersionRequirementTable.newBuilder(this.f46105i).k(versionRequirementTable).o();
                }
                this.f46100d |= 16;
                return this;
            }

            public Package y() {
                Package r02 = new Package(this);
                int i6 = this.f46100d;
                if ((i6 & 1) == 1) {
                    this.f46101e = Collections.unmodifiableList(this.f46101e);
                    this.f46100d &= -2;
                }
                r02.function_ = this.f46101e;
                if ((this.f46100d & 2) == 2) {
                    this.f46102f = Collections.unmodifiableList(this.f46102f);
                    this.f46100d &= -3;
                }
                r02.property_ = this.f46102f;
                if ((this.f46100d & 4) == 4) {
                    this.f46103g = Collections.unmodifiableList(this.f46103g);
                    this.f46100d &= -5;
                }
                r02.typeAlias_ = this.f46103g;
                int i7 = (i6 & 8) != 8 ? 0 : 1;
                r02.typeTable_ = this.f46104h;
                if ((i6 & 16) == 16) {
                    i7 |= 2;
                }
                r02.versionRequirementTable_ = this.f46105i;
                r02.bitField0_ = i7;
                return r02;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46101e = list;
                this.f46102f = list;
                this.f46103g = list;
                this.f46104h = TypeTable.getDefaultInstance();
                this.f46105i = VersionRequirementTable.getDefaultInstance();
                N();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public Package h() {
                return Package.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: O, reason: merged with bridge method [inline-methods] */
            public b k(Package r32) {
                if (r32 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r32.function_.isEmpty()) {
                    if (this.f46101e.isEmpty()) {
                        this.f46101e = r32.function_;
                        this.f46100d &= -2;
                    } else {
                        B();
                        this.f46101e.addAll(r32.function_);
                    }
                }
                if (!r32.property_.isEmpty()) {
                    if (this.f46102f.isEmpty()) {
                        this.f46102f = r32.property_;
                        this.f46100d &= -3;
                    } else {
                        C();
                        this.f46102f.addAll(r32.property_);
                    }
                }
                if (!r32.typeAlias_.isEmpty()) {
                    if (this.f46103g.isEmpty()) {
                        this.f46103g = r32.typeAlias_;
                        this.f46100d &= -5;
                    } else {
                        D();
                        this.f46103g.addAll(r32.typeAlias_);
                    }
                }
                if (r32.hasTypeTable()) {
                    Q(r32.getTypeTable());
                }
                if (r32.hasVersionRequirementTable()) {
                    R(r32.getVersionRequirementTable());
                }
                t(r32);
                l(i().d(r32.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public Package build() {
                Package y5 = y();
                if (y5.isInitialized()) {
                    return y5;
                }
                throw a.AbstractC0905a.f(y5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b p() {
                return A().k(y());
            }

            private void N() {
            }
        }

        public static b newBuilder() {
            return b.A();
        }

        static {
            Package r02 = new Package(true);
            defaultInstance = r02;
            r02.initFields();
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            List list = Collections.EMPTY_LIST;
            this.function_ = list;
            this.property_ = list;
            this.typeAlias_ = list;
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static b newBuilder(Package r12) {
            return newBuilder().k(r12);
        }

        public static Package parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.b(inputStream, fVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Package h() {
            return defaultInstance;
        }

        public Function getFunction(int i6) {
            return this.function_.get(i6);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i6) {
            return this.property_.get(i6);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.function_.size(); i8++) {
                i7 += CodedOutputStream.t(3, this.function_.get(i8));
            }
            for (int i9 = 0; i9 < this.property_.size(); i9++) {
                i7 += CodedOutputStream.t(4, this.property_.get(i9));
            }
            for (int i10 = 0; i10 < this.typeAlias_.size(); i10++) {
                i7 += CodedOutputStream.t(5, this.typeAlias_.get(i10));
            }
            if ((this.bitField0_ & 1) == 1) {
                i7 += CodedOutputStream.t(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i7 += CodedOutputStream.t(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i7 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeAlias getTypeAlias(int i6) {
            return this.typeAlias_.get(i6);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
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
            for (int i6 = 0; i6 < getFunctionCount(); i6++) {
                if (!getFunction(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getPropertyCount(); i7++) {
                if (!getProperty(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getTypeAliasCount(); i8++) {
                if (!getTypeAlias(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Package(GeneratedMessageLite.c<Package, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            for (int i6 = 0; i6 < this.function_.size(); i6++) {
                codedOutputStream.h0(3, this.function_.get(i6));
            }
            for (int i7 = 0; i7 < this.property_.size(); i7++) {
                codedOutputStream.h0(4, this.property_.get(i7));
            }
            for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
                codedOutputStream.h0(5, this.typeAlias_.get(i8));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.h0(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.h0(32, this.versionRequirementTable_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Package(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Package(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                            if (K2 == 26) {
                                if ((i6 & 1) != 1) {
                                    this.function_ = new ArrayList();
                                    i6 |= 1;
                                }
                                this.function_.add(eVar.u(Function.PARSER, fVar));
                            } else if (K2 == 34) {
                                if ((i6 & 2) != 2) {
                                    this.property_ = new ArrayList();
                                    i6 |= 2;
                                }
                                this.property_.add(eVar.u(Property.PARSER, fVar));
                            } else if (K2 != 42) {
                                if (K2 == 242) {
                                    TypeTable.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                    this.typeTable_ = typeTable;
                                    if (builder != null) {
                                        builder.k(typeTable);
                                        this.typeTable_ = builder.o();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (K2 != 258) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    VersionRequirementTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                                    this.versionRequirementTable_ = versionRequirementTable;
                                    if (builder2 != null) {
                                        builder2.k(versionRequirementTable);
                                        this.versionRequirementTable_ = builder2.o();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                if ((i6 & 4) != 4) {
                                    this.typeAlias_ = new ArrayList();
                                    i6 |= 4;
                                }
                                this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
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
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if ((i6 & 2) == 2) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if ((i6 & 4) == 4) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if ((i6 & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if ((i6 & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements l {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<PackageFragment> PARSER = new a();
        private static final PackageFragment defaultInstance;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<PackageFragment> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public PackageFragment d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new PackageFragment(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<PackageFragment, b> implements l {

            /* renamed from: d, reason: collision with root package name */
            private int f46106d;

            /* renamed from: e, reason: collision with root package name */
            private StringTable f46107e = StringTable.getDefaultInstance();

            /* renamed from: f, reason: collision with root package name */
            private QualifiedNameTable f46108f = QualifiedNameTable.getDefaultInstance();

            /* renamed from: g, reason: collision with root package name */
            private Package f46109g = Package.getDefaultInstance();

            /* renamed from: h, reason: collision with root package name */
            private List<Class> f46110h = Collections.EMPTY_LIST;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b A() {
                return new b();
            }

            private void B() {
                if ((this.f46106d & 8) != 8) {
                    this.f46110h = new ArrayList(this.f46110h);
                    this.f46106d |= 8;
                }
            }

            public Class C(int i6) {
                return this.f46110h.get(i6);
            }

            public int D() {
                return this.f46110h.size();
            }

            public Package F() {
                return this.f46109g;
            }

            public QualifiedNameTable G() {
                return this.f46108f;
            }

            public boolean H() {
                return (this.f46106d & 4) == 4;
            }

            public boolean I() {
                return (this.f46106d & 2) == 2;
            }

            public b M(Package r42) {
                if ((this.f46106d & 4) != 4 || this.f46109g == Package.getDefaultInstance()) {
                    this.f46109g = r42;
                } else {
                    this.f46109g = Package.newBuilder(this.f46109g).k(r42).y();
                }
                this.f46106d |= 4;
                return this;
            }

            public b N(QualifiedNameTable qualifiedNameTable) {
                if ((this.f46106d & 2) != 2 || this.f46108f == QualifiedNameTable.getDefaultInstance()) {
                    this.f46108f = qualifiedNameTable;
                } else {
                    this.f46108f = QualifiedNameTable.newBuilder(this.f46108f).k(qualifiedNameTable).o();
                }
                this.f46106d |= 2;
                return this;
            }

            public b O(StringTable stringTable) {
                if ((this.f46106d & 1) != 1 || this.f46107e == StringTable.getDefaultInstance()) {
                    this.f46107e = stringTable;
                } else {
                    this.f46107e = StringTable.newBuilder(this.f46107e).k(stringTable).o();
                }
                this.f46106d |= 1;
                return this;
            }

            public PackageFragment y() {
                PackageFragment packageFragment = new PackageFragment(this);
                int i6 = this.f46106d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                packageFragment.strings_ = this.f46107e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                packageFragment.qualifiedNames_ = this.f46108f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                packageFragment.package_ = this.f46109g;
                if ((this.f46106d & 8) == 8) {
                    this.f46110h = Collections.unmodifiableList(this.f46110h);
                    this.f46106d &= -9;
                }
                packageFragment.class__ = this.f46110h;
                packageFragment.bitField0_ = i7;
                return packageFragment;
            }

            private b() {
                J();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public PackageFragment h() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b k(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    O(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    N(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    M(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.f46110h.isEmpty()) {
                        this.f46110h = packageFragment.class__;
                        this.f46106d &= -9;
                    } else {
                        B();
                        this.f46110h.addAll(packageFragment.class__);
                    }
                }
                t(packageFragment);
                l(i().d(packageFragment.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (I() && !G().isInitialized()) {
                    return false;
                }
                if (H() && !F().isInitialized()) {
                    return false;
                }
                for (int i6 = 0; i6 < D(); i6++) {
                    if (!C(i6).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public PackageFragment build() {
                PackageFragment y5 = y();
                if (y5.isInitialized()) {
                    return y5;
                }
                throw a.AbstractC0905a.f(y5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b p() {
                return A().k(y());
            }

            private void J() {
            }
        }

        public static b newBuilder() {
            return b.A();
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(PackageFragment packageFragment) {
            return newBuilder().k(packageFragment);
        }

        public static PackageFragment parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.b(inputStream, fVar);
        }

        public Class getClass_(int i6) {
            return this.class__.get(i6);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public PackageFragment h() {
            return defaultInstance;
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int t5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.t(1, this.strings_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                t5 += CodedOutputStream.t(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                t5 += CodedOutputStream.t(3, this.package_);
            }
            for (int i7 = 0; i7 < this.class__.size(); i7++) {
                t5 += CodedOutputStream.t(4, this.class__.get(i7));
            }
            int extensionsSerializedSize = t5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStrings() {
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
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getClass_Count(); i6++) {
                if (!getClass_(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private PackageFragment(GeneratedMessageLite.c<PackageFragment, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.EMPTY_LIST;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.h0(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.h0(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.h0(3, this.package_);
            }
            for (int i6 = 0; i6 < this.class__.size(); i6++) {
                codedOutputStream.h0(4, this.class__.get(i6));
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private PackageFragment(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                StringTable.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                StringTable stringTable = (StringTable) eVar.u(StringTable.PARSER, fVar);
                                this.strings_ = stringTable;
                                if (builder != null) {
                                    builder.k(stringTable);
                                    this.strings_ = builder.o();
                                }
                                this.bitField0_ |= 1;
                            } else if (K2 == 18) {
                                QualifiedNameTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) eVar.u(QualifiedNameTable.PARSER, fVar);
                                this.qualifiedNames_ = qualifiedNameTable;
                                if (builder2 != null) {
                                    builder2.k(qualifiedNameTable);
                                    this.qualifiedNames_ = builder2.o();
                                }
                                this.bitField0_ |= 2;
                            } else if (K2 == 26) {
                                Package.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                Package r6 = (Package) eVar.u(Package.PARSER, fVar);
                                this.package_ = r6;
                                if (builder3 != null) {
                                    builder3.k(r6);
                                    this.package_ = builder3.y();
                                }
                                this.bitField0_ |= 4;
                            } else if (K2 != 34) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                if ((i6 & 8) != 8) {
                                    this.class__ = new ArrayList();
                                    i6 = 8;
                                }
                                this.class__.add(eVar.u(Class.PARSER, fVar));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i6 & 8) == 8) {
                        this.class__ = Collections.unmodifiableList(this.class__);
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
            if ((i6 & 8) == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
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
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements n {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Property> PARSER = new a();
        private static final Property defaultInstance;
        private List<Annotation> annotation_;
        private List<Annotation> backingFieldAnnotation_;
        private int bitField0_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<ValueParameter> contextParameter_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<Annotation> delegateFieldAnnotation_;
        private List<Annotation> extensionReceiverAnnotation_;
        private int flags_;
        private List<Annotation> getterAnnotation_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<Annotation> setterAnnotation_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Property> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Property d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Property(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Property, b> implements n {

            /* renamed from: d, reason: collision with root package name */
            private int f46111d;

            /* renamed from: g, reason: collision with root package name */
            private int f46114g;

            /* renamed from: i, reason: collision with root package name */
            private int f46116i;

            /* renamed from: j, reason: collision with root package name */
            private List<TypeParameter> f46117j;

            /* renamed from: k, reason: collision with root package name */
            private Type f46118k;

            /* renamed from: l, reason: collision with root package name */
            private int f46119l;

            /* renamed from: m, reason: collision with root package name */
            private List<Type> f46120m;

            /* renamed from: n, reason: collision with root package name */
            private List<Integer> f46121n;

            /* renamed from: o, reason: collision with root package name */
            private List<ValueParameter> f46122o;

            /* renamed from: p, reason: collision with root package name */
            private ValueParameter f46123p;

            /* renamed from: q, reason: collision with root package name */
            private int f46124q;

            /* renamed from: r, reason: collision with root package name */
            private int f46125r;

            /* renamed from: s, reason: collision with root package name */
            private List<Integer> f46126s;

            /* renamed from: t, reason: collision with root package name */
            private List<CompilerPluginData> f46127t;

            /* renamed from: u, reason: collision with root package name */
            private List<Annotation> f46128u;

            /* renamed from: v, reason: collision with root package name */
            private List<Annotation> f46129v;

            /* renamed from: w, reason: collision with root package name */
            private List<Annotation> f46130w;

            /* renamed from: x, reason: collision with root package name */
            private List<Annotation> f46131x;

            /* renamed from: y, reason: collision with root package name */
            private List<Annotation> f46132y;

            /* renamed from: z, reason: collision with root package name */
            private List<Annotation> f46133z;

            /* renamed from: e, reason: collision with root package name */
            private int f46112e = MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS;

            /* renamed from: f, reason: collision with root package name */
            private int f46113f = 2054;

            /* renamed from: h, reason: collision with root package name */
            private Type f46115h = Type.getDefaultInstance();

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: A0, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b J() {
                return new b();
            }

            private void K() {
                if ((this.f46111d & 65536) != 65536) {
                    this.f46128u = new ArrayList(this.f46128u);
                    this.f46111d |= 65536;
                }
            }

            private void L() {
                if ((this.f46111d & 1048576) != 1048576) {
                    this.f46132y = new ArrayList(this.f46132y);
                    this.f46111d |= 1048576;
                }
            }

            private void M() {
                if ((this.f46111d & 32768) != 32768) {
                    this.f46127t = new ArrayList(this.f46127t);
                    this.f46111d |= 32768;
                }
            }

            private void N() {
                if ((this.f46111d & 1024) != 1024) {
                    this.f46122o = new ArrayList(this.f46122o);
                    this.f46111d |= 1024;
                }
            }

            private void O() {
                if ((this.f46111d & 512) != 512) {
                    this.f46121n = new ArrayList(this.f46121n);
                    this.f46111d |= 512;
                }
            }

            private void P() {
                if ((this.f46111d & 256) != 256) {
                    this.f46120m = new ArrayList(this.f46120m);
                    this.f46111d |= 256;
                }
            }

            private void Q() {
                if ((this.f46111d & 2097152) != 2097152) {
                    this.f46133z = new ArrayList(this.f46133z);
                    this.f46111d |= 2097152;
                }
            }

            private void R() {
                if ((this.f46111d & 524288) != 524288) {
                    this.f46131x = new ArrayList(this.f46131x);
                    this.f46111d |= 524288;
                }
            }

            private void S() {
                if ((this.f46111d & 131072) != 131072) {
                    this.f46129v = new ArrayList(this.f46129v);
                    this.f46111d |= 131072;
                }
            }

            private void T() {
                if ((this.f46111d & 262144) != 262144) {
                    this.f46130w = new ArrayList(this.f46130w);
                    this.f46111d |= 262144;
                }
            }

            private void U() {
                if ((this.f46111d & 32) != 32) {
                    this.f46117j = new ArrayList(this.f46117j);
                    this.f46111d |= 32;
                }
            }

            private void V() {
                if ((this.f46111d & 16384) != 16384) {
                    this.f46126s = new ArrayList(this.f46126s);
                    this.f46111d |= 16384;
                }
            }

            public b B0(Type type) {
                if ((this.f46111d & 64) != 64 || this.f46118k == Type.getDefaultInstance()) {
                    this.f46118k = type;
                } else {
                    this.f46118k = Type.newBuilder(this.f46118k).k(type).z();
                }
                this.f46111d |= 64;
                return this;
            }

            public b C0(Type type) {
                if ((this.f46111d & 8) != 8 || this.f46115h == Type.getDefaultInstance()) {
                    this.f46115h = type;
                } else {
                    this.f46115h = Type.newBuilder(this.f46115h).k(type).z();
                }
                this.f46111d |= 8;
                return this;
            }

            public b D0(ValueParameter valueParameter) {
                if ((this.f46111d & 2048) != 2048 || this.f46123p == ValueParameter.getDefaultInstance()) {
                    this.f46123p = valueParameter;
                } else {
                    this.f46123p = ValueParameter.newBuilder(this.f46123p).k(valueParameter).z();
                }
                this.f46111d |= 2048;
                return this;
            }

            public b E0(int i6) {
                this.f46111d |= 1;
                this.f46112e = i6;
                return this;
            }

            public b F0(int i6) {
                this.f46111d |= 4096;
                this.f46124q = i6;
                return this;
            }

            public b G0(int i6) {
                this.f46111d |= 4;
                this.f46114g = i6;
                return this;
            }

            public Property H() {
                Property property = new Property(this);
                int i6 = this.f46111d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                property.flags_ = this.f46112e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                property.oldFlags_ = this.f46113f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                property.name_ = this.f46114g;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                property.returnType_ = this.f46115h;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                property.returnTypeId_ = this.f46116i;
                if ((this.f46111d & 32) == 32) {
                    this.f46117j = Collections.unmodifiableList(this.f46117j);
                    this.f46111d &= -33;
                }
                property.typeParameter_ = this.f46117j;
                if ((i6 & 64) == 64) {
                    i7 |= 32;
                }
                property.receiverType_ = this.f46118k;
                if ((i6 & 128) == 128) {
                    i7 |= 64;
                }
                property.receiverTypeId_ = this.f46119l;
                if ((this.f46111d & 256) == 256) {
                    this.f46120m = Collections.unmodifiableList(this.f46120m);
                    this.f46111d &= -257;
                }
                property.contextReceiverType_ = this.f46120m;
                if ((this.f46111d & 512) == 512) {
                    this.f46121n = Collections.unmodifiableList(this.f46121n);
                    this.f46111d &= -513;
                }
                property.contextReceiverTypeId_ = this.f46121n;
                if ((this.f46111d & 1024) == 1024) {
                    this.f46122o = Collections.unmodifiableList(this.f46122o);
                    this.f46111d &= -1025;
                }
                property.contextParameter_ = this.f46122o;
                if ((i6 & 2048) == 2048) {
                    i7 |= 128;
                }
                property.setterValueParameter_ = this.f46123p;
                if ((i6 & 4096) == 4096) {
                    i7 |= 256;
                }
                property.getterFlags_ = this.f46124q;
                if ((i6 & 8192) == 8192) {
                    i7 |= 512;
                }
                property.setterFlags_ = this.f46125r;
                if ((this.f46111d & 16384) == 16384) {
                    this.f46126s = Collections.unmodifiableList(this.f46126s);
                    this.f46111d &= -16385;
                }
                property.versionRequirement_ = this.f46126s;
                if ((this.f46111d & 32768) == 32768) {
                    this.f46127t = Collections.unmodifiableList(this.f46127t);
                    this.f46111d &= -32769;
                }
                property.compilerPluginData_ = this.f46127t;
                if ((this.f46111d & 65536) == 65536) {
                    this.f46128u = Collections.unmodifiableList(this.f46128u);
                    this.f46111d &= -65537;
                }
                property.annotation_ = this.f46128u;
                if ((this.f46111d & 131072) == 131072) {
                    this.f46129v = Collections.unmodifiableList(this.f46129v);
                    this.f46111d &= -131073;
                }
                property.getterAnnotation_ = this.f46129v;
                if ((this.f46111d & 262144) == 262144) {
                    this.f46130w = Collections.unmodifiableList(this.f46130w);
                    this.f46111d &= -262145;
                }
                property.setterAnnotation_ = this.f46130w;
                if ((this.f46111d & 524288) == 524288) {
                    this.f46131x = Collections.unmodifiableList(this.f46131x);
                    this.f46111d &= -524289;
                }
                property.extensionReceiverAnnotation_ = this.f46131x;
                if ((this.f46111d & 1048576) == 1048576) {
                    this.f46132y = Collections.unmodifiableList(this.f46132y);
                    this.f46111d &= -1048577;
                }
                property.backingFieldAnnotation_ = this.f46132y;
                if ((this.f46111d & 2097152) == 2097152) {
                    this.f46133z = Collections.unmodifiableList(this.f46133z);
                    this.f46111d &= -2097153;
                }
                property.delegateFieldAnnotation_ = this.f46133z;
                property.bitField0_ = i7;
                return property;
            }

            public b H0(int i6) {
                this.f46111d |= 2;
                this.f46113f = i6;
                return this;
            }

            public b J0(int i6) {
                this.f46111d |= 128;
                this.f46119l = i6;
                return this;
            }

            public b L0(int i6) {
                this.f46111d |= 16;
                this.f46116i = i6;
                return this;
            }

            public b M0(int i6) {
                this.f46111d |= 8192;
                this.f46125r = i6;
                return this;
            }

            public Annotation W(int i6) {
                return this.f46128u.get(i6);
            }

            public int X() {
                return this.f46128u.size();
            }

            public Annotation Y(int i6) {
                return this.f46132y.get(i6);
            }

            public int Z() {
                return this.f46132y.size();
            }

            public CompilerPluginData a0(int i6) {
                return this.f46127t.get(i6);
            }

            public int b0() {
                return this.f46127t.size();
            }

            public ValueParameter c0(int i6) {
                return this.f46122o.get(i6);
            }

            public int d0() {
                return this.f46122o.size();
            }

            public Type e0(int i6) {
                return this.f46120m.get(i6);
            }

            public int f0() {
                return this.f46120m.size();
            }

            public Annotation h0(int i6) {
                return this.f46133z.get(i6);
            }

            public int i0() {
                return this.f46133z.size();
            }

            public Annotation j0(int i6) {
                return this.f46131x.get(i6);
            }

            public int k0() {
                return this.f46131x.size();
            }

            public Annotation l0(int i6) {
                return this.f46129v.get(i6);
            }

            public int m0() {
                return this.f46129v.size();
            }

            public Type n0() {
                return this.f46118k;
            }

            public Type o0() {
                return this.f46115h;
            }

            public Annotation p0(int i6) {
                return this.f46130w.get(i6);
            }

            public int q0() {
                return this.f46130w.size();
            }

            public ValueParameter r0() {
                return this.f46123p;
            }

            public TypeParameter s0(int i6) {
                return this.f46117j.get(i6);
            }

            public int t0() {
                return this.f46117j.size();
            }

            public boolean u0() {
                return (this.f46111d & 4) == 4;
            }

            public boolean v0() {
                return (this.f46111d & 64) == 64;
            }

            public boolean w0() {
                return (this.f46111d & 8) == 8;
            }

            public boolean x0() {
                return (this.f46111d & 2048) == 2048;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46117j = list;
                this.f46118k = Type.getDefaultInstance();
                this.f46120m = list;
                this.f46121n = list;
                this.f46122o = list;
                this.f46123p = ValueParameter.getDefaultInstance();
                this.f46126s = list;
                this.f46127t = list;
                this.f46128u = list;
                this.f46129v = list;
                this.f46130w = list;
                this.f46131x = list;
                this.f46132y = list;
                this.f46133z = list;
                y0();
            }

            public b A(Iterable<? extends Annotation> iterable) {
                Q();
                a.AbstractC0905a.a(iterable, this.f46133z);
                return this;
            }

            public b B(Iterable<? extends Annotation> iterable) {
                R();
                a.AbstractC0905a.a(iterable, this.f46131x);
                return this;
            }

            public b C(Iterable<? extends Annotation> iterable) {
                S();
                a.AbstractC0905a.a(iterable, this.f46129v);
                return this;
            }

            public b D(Iterable<? extends Annotation> iterable) {
                T();
                a.AbstractC0905a.a(iterable, this.f46130w);
                return this;
            }

            public b E(Iterable<? extends Integer> iterable) {
                V();
                a.AbstractC0905a.a(iterable, this.f46126s);
                return this;
            }

            public b F(TypeParameter typeParameter) {
                typeParameter.getClass();
                U();
                this.f46117j.add(typeParameter);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Property build() {
                Property H = H();
                if (H.isInitialized()) {
                    return H;
                }
                throw a.AbstractC0905a.f(H);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public b p() {
                return J().k(H());
            }

            public b I0(Type type) {
                type.getClass();
                this.f46118k = type;
                this.f46111d |= 64;
                return this;
            }

            public b K0(Type type) {
                type.getClass();
                this.f46115h = type;
                this.f46111d |= 8;
                return this;
            }

            public b N0(ValueParameter valueParameter) {
                valueParameter.getClass();
                this.f46123p = valueParameter;
                this.f46111d |= 2048;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: g0, reason: merged with bridge method [inline-methods] */
            public Property h() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!u0()) {
                    return false;
                }
                if (w0() && !o0().isInitialized()) {
                    return false;
                }
                for (int i6 = 0; i6 < t0(); i6++) {
                    if (!s0(i6).isInitialized()) {
                        return false;
                    }
                }
                if (v0() && !n0().isInitialized()) {
                    return false;
                }
                for (int i7 = 0; i7 < f0(); i7++) {
                    if (!e0(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < d0(); i8++) {
                    if (!c0(i8).isInitialized()) {
                        return false;
                    }
                }
                if (x0() && !r0().isInitialized()) {
                    return false;
                }
                for (int i9 = 0; i9 < b0(); i9++) {
                    if (!a0(i9).isInitialized()) {
                        return false;
                    }
                }
                for (int i10 = 0; i10 < X(); i10++) {
                    if (!W(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < m0(); i11++) {
                    if (!l0(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < q0(); i12++) {
                    if (!p0(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < k0(); i13++) {
                    if (!j0(i13).isInitialized()) {
                        return false;
                    }
                }
                for (int i14 = 0; i14 < Z(); i14++) {
                    if (!Y(i14).isInitialized()) {
                        return false;
                    }
                }
                for (int i15 = 0; i15 < i0(); i15++) {
                    if (!h0(i15).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            public b x(Iterable<? extends Annotation> iterable) {
                K();
                a.AbstractC0905a.a(iterable, this.f46128u);
                return this;
            }

            public b y(Iterable<? extends Annotation> iterable) {
                L();
                a.AbstractC0905a.a(iterable, this.f46132y);
                return this;
            }

            public b z(Iterable<? extends Type> iterable) {
                P();
                a.AbstractC0905a.a(iterable, this.f46120m);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: z0, reason: merged with bridge method [inline-methods] */
            public b k(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    E0(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    H0(property.getOldFlags());
                }
                if (property.hasName()) {
                    G0(property.getName());
                }
                if (property.hasReturnType()) {
                    C0(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    L0(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.f46117j.isEmpty()) {
                        this.f46117j = property.typeParameter_;
                        this.f46111d &= -33;
                    } else {
                        U();
                        this.f46117j.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    B0(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    J0(property.getReceiverTypeId());
                }
                if (!property.contextReceiverType_.isEmpty()) {
                    if (this.f46120m.isEmpty()) {
                        this.f46120m = property.contextReceiverType_;
                        this.f46111d &= -257;
                    } else {
                        P();
                        this.f46120m.addAll(property.contextReceiverType_);
                    }
                }
                if (!property.contextReceiverTypeId_.isEmpty()) {
                    if (this.f46121n.isEmpty()) {
                        this.f46121n = property.contextReceiverTypeId_;
                        this.f46111d &= -513;
                    } else {
                        O();
                        this.f46121n.addAll(property.contextReceiverTypeId_);
                    }
                }
                if (!property.contextParameter_.isEmpty()) {
                    if (this.f46122o.isEmpty()) {
                        this.f46122o = property.contextParameter_;
                        this.f46111d &= -1025;
                    } else {
                        N();
                        this.f46122o.addAll(property.contextParameter_);
                    }
                }
                if (property.hasSetterValueParameter()) {
                    D0(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    F0(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    M0(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.f46126s.isEmpty()) {
                        this.f46126s = property.versionRequirement_;
                        this.f46111d &= -16385;
                    } else {
                        V();
                        this.f46126s.addAll(property.versionRequirement_);
                    }
                }
                if (!property.compilerPluginData_.isEmpty()) {
                    if (this.f46127t.isEmpty()) {
                        this.f46127t = property.compilerPluginData_;
                        this.f46111d &= -32769;
                    } else {
                        M();
                        this.f46127t.addAll(property.compilerPluginData_);
                    }
                }
                if (!property.annotation_.isEmpty()) {
                    if (this.f46128u.isEmpty()) {
                        this.f46128u = property.annotation_;
                        this.f46111d &= -65537;
                    } else {
                        K();
                        this.f46128u.addAll(property.annotation_);
                    }
                }
                if (!property.getterAnnotation_.isEmpty()) {
                    if (this.f46129v.isEmpty()) {
                        this.f46129v = property.getterAnnotation_;
                        this.f46111d &= -131073;
                    } else {
                        S();
                        this.f46129v.addAll(property.getterAnnotation_);
                    }
                }
                if (!property.setterAnnotation_.isEmpty()) {
                    if (this.f46130w.isEmpty()) {
                        this.f46130w = property.setterAnnotation_;
                        this.f46111d &= -262145;
                    } else {
                        T();
                        this.f46130w.addAll(property.setterAnnotation_);
                    }
                }
                if (!property.extensionReceiverAnnotation_.isEmpty()) {
                    if (this.f46131x.isEmpty()) {
                        this.f46131x = property.extensionReceiverAnnotation_;
                        this.f46111d &= -524289;
                    } else {
                        R();
                        this.f46131x.addAll(property.extensionReceiverAnnotation_);
                    }
                }
                if (!property.backingFieldAnnotation_.isEmpty()) {
                    if (this.f46132y.isEmpty()) {
                        this.f46132y = property.backingFieldAnnotation_;
                        this.f46111d &= -1048577;
                    } else {
                        L();
                        this.f46132y.addAll(property.backingFieldAnnotation_);
                    }
                }
                if (!property.delegateFieldAnnotation_.isEmpty()) {
                    if (this.f46133z.isEmpty()) {
                        this.f46133z = property.delegateFieldAnnotation_;
                        this.f46111d &= -2097153;
                    } else {
                        Q();
                        this.f46133z.addAll(property.delegateFieldAnnotation_);
                    }
                }
                t(property);
                l(i().d(property.unknownFields));
                return this;
            }

            private void y0() {
            }
        }

        public static b newBuilder() {
            return b.J();
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.contextParameter_ = list;
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = list;
            this.compilerPluginData_ = list;
            this.annotation_ = list;
            this.getterAnnotation_ = list;
            this.setterAnnotation_ = list;
            this.extensionReceiverAnnotation_ = list;
            this.backingFieldAnnotation_ = list;
            this.delegateFieldAnnotation_ = list;
        }

        public static b newBuilder(Property property) {
            return newBuilder().k(property);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Annotation getBackingFieldAnnotation(int i6) {
            return this.backingFieldAnnotation_.get(i6);
        }

        public int getBackingFieldAnnotationCount() {
            return this.backingFieldAnnotation_.size();
        }

        public List<Annotation> getBackingFieldAnnotationList() {
            return this.backingFieldAnnotation_;
        }

        public CompilerPluginData getCompilerPluginData(int i6) {
            return this.compilerPluginData_.get(i6);
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public ValueParameter getContextParameter(int i6) {
            return this.contextParameter_.get(i6);
        }

        public int getContextParameterCount() {
            return this.contextParameter_.size();
        }

        public Type getContextReceiverType(int i6) {
            return this.contextReceiverType_.get(i6);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Property h() {
            return defaultInstance;
        }

        public Annotation getDelegateFieldAnnotation(int i6) {
            return this.delegateFieldAnnotation_.get(i6);
        }

        public int getDelegateFieldAnnotationCount() {
            return this.delegateFieldAnnotation_.size();
        }

        public List<Annotation> getDelegateFieldAnnotationList() {
            return this.delegateFieldAnnotation_;
        }

        public Annotation getExtensionReceiverAnnotation(int i6) {
            return this.extensionReceiverAnnotation_.get(i6);
        }

        public int getExtensionReceiverAnnotationCount() {
            return this.extensionReceiverAnnotation_.size();
        }

        public List<Annotation> getExtensionReceiverAnnotationList() {
            return this.extensionReceiverAnnotation_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Annotation getGetterAnnotation(int i6) {
            return this.getterAnnotation_.get(i6);
        }

        public int getGetterAnnotationCount() {
            return this.getterAnnotation_.size();
        }

        public List<Annotation> getGetterAnnotationList() {
            return this.getterAnnotation_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 2) == 2 ? CodedOutputStream.p(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.p(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.t(3, this.returnType_);
            }
            for (int i7 = 0; i7 < this.typeParameter_.size(); i7++) {
                p5 += CodedOutputStream.t(4, this.typeParameter_.get(i7));
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.t(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                p5 += CodedOutputStream.t(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                p5 += CodedOutputStream.p(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                p5 += CodedOutputStream.p(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.p(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                p5 += CodedOutputStream.p(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                p5 += CodedOutputStream.p(11, this.flags_);
            }
            for (int i8 = 0; i8 < this.contextReceiverType_.size(); i8++) {
                p5 += CodedOutputStream.t(12, this.contextReceiverType_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.contextReceiverTypeId_.size(); i10++) {
                i9 += CodedOutputStream.q(this.contextReceiverTypeId_.get(i10).intValue());
            }
            int i11 = p5 + i9;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i11 = i11 + 1 + CodedOutputStream.q(i9);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i9;
            for (int i12 = 0; i12 < this.annotation_.size(); i12++) {
                i11 += CodedOutputStream.t(14, this.annotation_.get(i12));
            }
            for (int i13 = 0; i13 < this.getterAnnotation_.size(); i13++) {
                i11 += CodedOutputStream.t(15, this.getterAnnotation_.get(i13));
            }
            for (int i14 = 0; i14 < this.setterAnnotation_.size(); i14++) {
                i11 += CodedOutputStream.t(16, this.setterAnnotation_.get(i14));
            }
            for (int i15 = 0; i15 < this.contextParameter_.size(); i15++) {
                i11 += CodedOutputStream.t(17, this.contextParameter_.get(i15));
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.versionRequirement_.size(); i17++) {
                i16 += CodedOutputStream.q(this.versionRequirement_.get(i17).intValue());
            }
            int size = i11 + i16 + (getVersionRequirementList().size() * 2);
            for (int i18 = 0; i18 < this.compilerPluginData_.size(); i18++) {
                size += CodedOutputStream.t(32, this.compilerPluginData_.get(i18));
            }
            for (int i19 = 0; i19 < this.extensionReceiverAnnotation_.size(); i19++) {
                size += CodedOutputStream.t(33, this.extensionReceiverAnnotation_.get(i19));
            }
            for (int i20 = 0; i20 < this.backingFieldAnnotation_.size(); i20++) {
                size += CodedOutputStream.t(34, this.backingFieldAnnotation_.get(i20));
            }
            for (int i21 = 0; i21 < this.delegateFieldAnnotation_.size(); i21++) {
                size += CodedOutputStream.t(35, this.delegateFieldAnnotation_.get(i21));
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Annotation getSetterAnnotation(int i6) {
            return this.setterAnnotation_.get(i6);
        }

        public int getSetterAnnotationCount() {
            return this.setterAnnotation_.size();
        }

        public List<Annotation> getSetterAnnotationList() {
            return this.setterAnnotation_;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int i6) {
            return this.typeParameter_.get(i6);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getTypeParameterCount(); i6++) {
                if (!getTypeParameter(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i7 = 0; i7 < getContextReceiverTypeCount(); i7++) {
                if (!getContextReceiverType(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getContextParameterCount(); i8++) {
                if (!getContextParameter(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i9 = 0; i9 < getCompilerPluginDataCount(); i9++) {
                if (!getCompilerPluginData(i9).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i10 = 0; i10 < getAnnotationCount(); i10++) {
                if (!getAnnotation(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getGetterAnnotationCount(); i11++) {
                if (!getGetterAnnotation(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getSetterAnnotationCount(); i12++) {
                if (!getSetterAnnotation(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getExtensionReceiverAnnotationCount(); i13++) {
                if (!getExtensionReceiverAnnotation(i13).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i14 = 0; i14 < getBackingFieldAnnotationCount(); i14++) {
                if (!getBackingFieldAnnotation(i14).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i15 = 0; i15 < getDelegateFieldAnnotationCount(); i15++) {
                if (!getDelegateFieldAnnotation(i15).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Property(GeneratedMessageLite.c<Property, ?> cVar) {
            super(cVar);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.e0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.h0(3, this.returnType_);
            }
            for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
                codedOutputStream.h0(4, this.typeParameter_.get(i6));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.h0(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.h0(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.e0(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.e0(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.e0(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(11, this.flags_);
            }
            for (int i7 = 0; i7 < this.contextReceiverType_.size(); i7++) {
                codedOutputStream.h0(12, this.contextReceiverType_.get(i7));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.s0(106);
                codedOutputStream.s0(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i8 = 0; i8 < this.contextReceiverTypeId_.size(); i8++) {
                codedOutputStream.f0(this.contextReceiverTypeId_.get(i8).intValue());
            }
            for (int i9 = 0; i9 < this.annotation_.size(); i9++) {
                codedOutputStream.h0(14, this.annotation_.get(i9));
            }
            for (int i10 = 0; i10 < this.getterAnnotation_.size(); i10++) {
                codedOutputStream.h0(15, this.getterAnnotation_.get(i10));
            }
            for (int i11 = 0; i11 < this.setterAnnotation_.size(); i11++) {
                codedOutputStream.h0(16, this.setterAnnotation_.get(i11));
            }
            for (int i12 = 0; i12 < this.contextParameter_.size(); i12++) {
                codedOutputStream.h0(17, this.contextParameter_.get(i12));
            }
            for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
                codedOutputStream.e0(31, this.versionRequirement_.get(i13).intValue());
            }
            for (int i14 = 0; i14 < this.compilerPluginData_.size(); i14++) {
                codedOutputStream.h0(32, this.compilerPluginData_.get(i14));
            }
            for (int i15 = 0; i15 < this.extensionReceiverAnnotation_.size(); i15++) {
                codedOutputStream.h0(33, this.extensionReceiverAnnotation_.get(i15));
            }
            for (int i16 = 0; i16 < this.backingFieldAnnotation_.size(); i16++) {
                codedOutputStream.h0(34, this.backingFieldAnnotation_.get(i16));
            }
            for (int i17 = 0; i17 < this.delegateFieldAnnotation_.size(); i17++) {
                codedOutputStream.h0(35, this.delegateFieldAnnotation_.get(i17));
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Property(boolean z5) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x036f  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x037d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x038b  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0399  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x03a5  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x03b1  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x03bd  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x03c9  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x03d5  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x03e1  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x03ef  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x03fd  */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private Property(kotlin.reflect.jvm.internal.impl.protobuf.e r23, kotlin.reflect.jvm.internal.impl.protobuf.f r24) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                Method dump skipped, instructions count: 1332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.<init>(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements p {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> PARSER = new a();
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class QualifiedName extends GeneratedMessageLite implements o {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> PARSER = new a();
            private static final QualifiedName defaultInstance;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public enum Kind implements h.a {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);

                private static h.b<Kind> internalValueMap = new a();
                private final int value;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                static class a implements h.b<Kind> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Kind a(int i6) {
                        return Kind.valueOf(i6);
                    }
                }

                public static Kind valueOf(int i6) {
                    if (i6 == 0) {
                        return CLASS;
                    }
                    if (i6 == 1) {
                        return PACKAGE;
                    }
                    if (i6 != 2) {
                        return null;
                    }
                    return LOCAL;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                Kind(int i6, int i7) {
                    this.value = i7;
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedName> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public QualifiedName d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new QualifiedName(eVar, fVar);
                }

                a() {
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static final class b extends GeneratedMessageLite.b<QualifiedName, b> implements o {

                /* renamed from: b, reason: collision with root package name */
                private int f46134b;

                /* renamed from: d, reason: collision with root package name */
                private int f46136d;

                /* renamed from: c, reason: collision with root package name */
                private int f46135c = -1;

                /* renamed from: e, reason: collision with root package name */
                private Kind f46137e = Kind.PACKAGE;

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName$b");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b q() {
                    return new b();
                }

                public QualifiedName o() {
                    QualifiedName qualifiedName = new QualifiedName(this);
                    int i6 = this.f46134b;
                    int i7 = (i6 & 1) != 1 ? 0 : 1;
                    qualifiedName.parentQualifiedName_ = this.f46135c;
                    if ((i6 & 2) == 2) {
                        i7 |= 2;
                    }
                    qualifiedName.shortName_ = this.f46136d;
                    if ((i6 & 4) == 4) {
                        i7 |= 4;
                    }
                    qualifiedName.kind_ = this.f46137e;
                    qualifiedName.bitField0_ = i7;
                    return qualifiedName;
                }

                public boolean t() {
                    return (this.f46134b & 2) == 2;
                }

                public b y(int i6) {
                    this.f46134b |= 1;
                    this.f46135c = i6;
                    return this;
                }

                public b z(int i6) {
                    this.f46134b |= 2;
                    this.f46136d = i6;
                    return this;
                }

                private b() {
                    u();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    if (!t()) {
                        return false;
                    }
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public QualifiedName build() {
                    QualifiedName o5 = o();
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
                public QualifiedName h() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                public b k(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        y(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        z(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        x(qualifiedName.getKind());
                    }
                    l(i().d(qualifiedName.unknownFields));
                    return this;
                }

                public b x(Kind kind) {
                    kind.getClass();
                    this.f46134b |= 4;
                    this.f46137e = kind;
                    return this;
                }

                private void u() {
                }
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static b newBuilder() {
                return b.q();
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            public static b newBuilder(QualifiedName qualifiedName) {
                return newBuilder().k(qualifiedName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: getDefaultInstanceForType */
            public QualifiedName h() {
                return defaultInstance;
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i6 = this.memoizedSerializedSize;
                if (i6 != -1) {
                    return i6;
                }
                int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    p5 += CodedOutputStream.p(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    p5 += CodedOutputStream.i(3, this.kind_.getNumber());
                }
                int size = p5 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasShortName() {
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
                if (hasShortName()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private QualifiedName(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.i();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.e0(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.e0(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.W(3, this.kind_.getNumber());
                }
                codedOutputStream.m0(this.unknownFields);
            }

            private QualifiedName(boolean z5) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
                CodedOutputStream K = CodedOutputStream.K(t5, 1);
                boolean z5 = false;
                while (!z5) {
                    try {
                        try {
                            try {
                                int K2 = eVar.K();
                                if (K2 != 0) {
                                    if (K2 == 8) {
                                        this.bitField0_ |= 1;
                                        this.parentQualifiedName_ = eVar.s();
                                    } else if (K2 == 16) {
                                        this.bitField0_ |= 2;
                                        this.shortName_ = eVar.s();
                                    } else if (K2 != 24) {
                                        if (!parseUnknownField(eVar, K, fVar, K2)) {
                                        }
                                    } else {
                                        int n6 = eVar.n();
                                        Kind valueOf = Kind.valueOf(n6);
                                        if (valueOf == null) {
                                            K.s0(K2);
                                            K.s0(n6);
                                        } else {
                                            this.bitField0_ |= 4;
                                            this.kind_ = valueOf;
                                        }
                                    }
                                }
                                z5 = true;
                            } catch (IOException e6) {
                                throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e7) {
                            throw e7.setUnfinishedMessage(this);
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
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedNameTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public QualifiedNameTable d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<QualifiedNameTable, b> implements p {

            /* renamed from: b, reason: collision with root package name */
            private int f46138b;

            /* renamed from: c, reason: collision with root package name */
            private List<QualifiedName> f46139c = Collections.EMPTY_LIST;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < v(); i6++) {
                    if (!u(i6).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46138b & 1) != 1) {
                    this.f46139c = new ArrayList(this.f46139c);
                    this.f46138b |= 1;
                }
            }

            public QualifiedNameTable o() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this);
                if ((this.f46138b & 1) == 1) {
                    this.f46139c = Collections.unmodifiableList(this.f46139c);
                    this.f46138b &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.f46139c;
                return qualifiedNameTable;
            }

            public QualifiedName u(int i6) {
                return this.f46139c.get(i6);
            }

            public int v() {
                return this.f46139c.size();
            }

            private b() {
                w();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public QualifiedNameTable build() {
                QualifiedNameTable o5 = o();
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
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public QualifiedNameTable h() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b k(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.f46139c.isEmpty()) {
                        this.f46139c = qualifiedNameTable.qualifiedName_;
                        this.f46138b &= -2;
                    } else {
                        s();
                        this.f46139c.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                l(i().d(qualifiedNameTable.unknownFields));
                return this;
            }

            private void w() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.EMPTY_LIST;
        }

        public static b newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().k(qualifiedNameTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public QualifiedNameTable h() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i6) {
            return this.qualifiedName_.get(i6);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.qualifiedName_.size(); i8++) {
                i7 += CodedOutputStream.t(1, this.qualifiedName_.get(i8));
            }
            int size = i7 + this.unknownFields.size();
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
            for (int i6 = 0; i6 < getQualifiedNameCount(); i6++) {
                if (!getQualifiedName(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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

        private QualifiedNameTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.qualifiedName_.size(); i6++) {
                codedOutputStream.h0(1, this.qualifiedName_.get(i6));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private QualifiedNameTable(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int K2 = eVar.K();
                            if (K2 != 0) {
                                if (K2 != 10) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    if (!z6) {
                                        this.qualifiedName_ = new ArrayList();
                                        z6 = true;
                                    }
                                    this.qualifiedName_.add(eVar.u(QualifiedName.PARSER, fVar));
                                }
                            }
                            z5 = true;
                        } catch (IOException e6) {
                            throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e7) {
                        throw e7.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            if (z6) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
    public static final class StringTable extends GeneratedMessageLite implements q {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> PARSER = new a();
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private kotlin.reflect.jvm.internal.impl.protobuf.l string_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<StringTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public StringTable d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new StringTable(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<StringTable, b> implements q {

            /* renamed from: b, reason: collision with root package name */
            private int f46140b;

            /* renamed from: c, reason: collision with root package name */
            private kotlin.reflect.jvm.internal.impl.protobuf.l f46141c = kotlin.reflect.jvm.internal.impl.protobuf.k.f46511b;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46140b & 1) != 1) {
                    this.f46141c = new kotlin.reflect.jvm.internal.impl.protobuf.k(this.f46141c);
                    this.f46140b |= 1;
                }
            }

            public StringTable o() {
                StringTable stringTable = new StringTable(this);
                if ((this.f46140b & 1) == 1) {
                    this.f46141c = this.f46141c.c();
                    this.f46140b &= -2;
                }
                stringTable.string_ = this.f46141c;
                return stringTable;
            }

            private b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public StringTable build() {
                StringTable o5 = o();
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
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public StringTable h() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public b k(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.f46141c.isEmpty()) {
                        this.f46141c = stringTable.string_;
                        this.f46140b &= -2;
                    } else {
                        s();
                        this.f46141c.addAll(stringTable.string_);
                    }
                }
                l(i().d(stringTable.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = kotlin.reflect.jvm.internal.impl.protobuf.k.f46511b;
        }

        public static b newBuilder(StringTable stringTable) {
            return newBuilder().k(stringTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public StringTable h() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.string_.size(); i8++) {
                i7 += CodedOutputStream.f(this.string_.i(i8));
            }
            int size = i7 + getStringList().size() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i6) {
            return this.string_.get(i6);
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.q getStringList() {
            return this.string_;
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

        private StringTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.string_.size(); i6++) {
                codedOutputStream.S(1, this.string_.i(i6));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private StringTable(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int K2 = eVar.K();
                            if (K2 != 0) {
                                if (K2 != 10) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    kotlin.reflect.jvm.internal.impl.protobuf.d l6 = eVar.l();
                                    if (!z6) {
                                        this.string_ = new kotlin.reflect.jvm.internal.impl.protobuf.k();
                                        z6 = true;
                                    }
                                    this.string_.k(l6);
                                }
                            }
                            z5 = true;
                        } catch (IOException e6) {
                            throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e7) {
                        throw e7.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.string_ = this.string_.c();
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
            if (z6) {
                this.string_ = this.string_.c();
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
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements t {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Type> PARSER = new a();
        private static final Type defaultInstance;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Argument extends GeneratedMessageLite implements r {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public enum Projection implements h.a {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);

                private static h.b<Projection> internalValueMap = new a();
                private final int value;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                static class a implements h.b<Projection> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Projection a(int i6) {
                        return Projection.valueOf(i6);
                    }
                }

                public static Projection valueOf(int i6) {
                    if (i6 == 0) {
                        return IN;
                    }
                    if (i6 == 1) {
                        return OUT;
                    }
                    if (i6 == 2) {
                        return INV;
                    }
                    if (i6 != 3) {
                        return null;
                    }
                    return STAR;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                Projection(int i6, int i7) {
                    this.value = i7;
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public Argument d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }

                a() {
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements r {

                /* renamed from: b, reason: collision with root package name */
                private int f46142b;

                /* renamed from: c, reason: collision with root package name */
                private Projection f46143c = Projection.INV;

                /* renamed from: d, reason: collision with root package name */
                private Type f46144d = Type.getDefaultInstance();

                /* renamed from: e, reason: collision with root package name */
                private int f46145e;

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$b");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b q() {
                    return new b();
                }

                public b A(int i6) {
                    this.f46142b |= 4;
                    this.f46145e = i6;
                    return this;
                }

                public Type getType() {
                    return this.f46144d;
                }

                public Argument o() {
                    Argument argument = new Argument(this);
                    int i6 = this.f46142b;
                    int i7 = (i6 & 1) != 1 ? 0 : 1;
                    argument.projection_ = this.f46143c;
                    if ((i6 & 2) == 2) {
                        i7 |= 2;
                    }
                    argument.type_ = this.f46144d;
                    if ((i6 & 4) == 4) {
                        i7 |= 4;
                    }
                    argument.typeId_ = this.f46145e;
                    argument.bitField0_ = i7;
                    return argument;
                }

                public boolean t() {
                    return (this.f46142b & 2) == 2;
                }

                public b x(Type type) {
                    if ((this.f46142b & 2) != 2 || this.f46144d == Type.getDefaultInstance()) {
                        this.f46144d = type;
                    } else {
                        this.f46144d = Type.newBuilder(this.f46144d).k(type).z();
                    }
                    this.f46142b |= 2;
                    return this;
                }

                private b() {
                    u();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    if (t() && !getType().isInitialized()) {
                        return false;
                    }
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public Argument build() {
                    Argument o5 = o();
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
                public Argument h() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: v, reason: merged with bridge method [inline-methods] */
                public b k(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        y(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        x(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        A(argument.getTypeId());
                    }
                    l(i().d(argument.unknownFields));
                    return this;
                }

                public b y(Projection projection) {
                    projection.getClass();
                    this.f46142b |= 1;
                    this.f46143c = projection;
                    return this;
                }

                public b z(Type type) {
                    type.getClass();
                    this.f46144d = type;
                    this.f46142b |= 2;
                    return this;
                }

                private void u() {
                }
            }

            public static b newBuilder() {
                return b.q();
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().k(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: getDefaultInstanceForType */
            public Argument h() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i6 = this.memoizedSerializedSize;
                if (i6 != -1) {
                    return i6;
                }
                int i7 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.i(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i7 += CodedOutputStream.t(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i7 += CodedOutputStream.p(3, this.typeId_);
                }
                int size = i7 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasTypeId() {
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
                if (!hasType() || getType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.i();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.W(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.h0(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.e0(3, this.typeId_);
                }
                codedOutputStream.m0(this.unknownFields);
            }

            private Argument(boolean z5) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
                CodedOutputStream K = CodedOutputStream.K(t5, 1);
                boolean z5 = false;
                while (!z5) {
                    try {
                        try {
                            try {
                                int K2 = eVar.K();
                                if (K2 != 0) {
                                    if (K2 == 8) {
                                        int n6 = eVar.n();
                                        Projection valueOf = Projection.valueOf(n6);
                                        if (valueOf == null) {
                                            K.s0(K2);
                                            K.s0(n6);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.projection_ = valueOf;
                                        }
                                    } else if (K2 == 18) {
                                        b builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.k(type);
                                            this.type_ = builder.z();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (K2 != 24) {
                                        if (!parseUnknownField(eVar, K, fVar, K2)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.typeId_ = eVar.s();
                                    }
                                }
                                z5 = true;
                            } catch (IOException e6) {
                                throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e7) {
                            throw e7.setUnfinishedMessage(this);
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
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Type> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Type d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Type(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<Type, b> implements t {

            /* renamed from: d, reason: collision with root package name */
            private int f46146d;

            /* renamed from: f, reason: collision with root package name */
            private boolean f46148f;

            /* renamed from: g, reason: collision with root package name */
            private int f46149g;

            /* renamed from: i, reason: collision with root package name */
            private int f46151i;

            /* renamed from: j, reason: collision with root package name */
            private int f46152j;

            /* renamed from: k, reason: collision with root package name */
            private int f46153k;

            /* renamed from: l, reason: collision with root package name */
            private int f46154l;

            /* renamed from: m, reason: collision with root package name */
            private int f46155m;

            /* renamed from: o, reason: collision with root package name */
            private int f46157o;

            /* renamed from: q, reason: collision with root package name */
            private int f46159q;

            /* renamed from: r, reason: collision with root package name */
            private int f46160r;

            /* renamed from: e, reason: collision with root package name */
            private List<Argument> f46147e = Collections.EMPTY_LIST;

            /* renamed from: h, reason: collision with root package name */
            private Type f46150h = Type.getDefaultInstance();

            /* renamed from: n, reason: collision with root package name */
            private Type f46156n = Type.getDefaultInstance();

            /* renamed from: p, reason: collision with root package name */
            private Type f46158p = Type.getDefaultInstance();

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: Q, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < F(); i6++) {
                    if (!E(i6).isInitialized()) {
                        return false;
                    }
                }
                if (K() && !H().isInitialized()) {
                    return false;
                }
                if (!L() || I().isInitialized()) {
                    return (!J() || D().isInitialized()) && s();
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46146d & 1) != 1) {
                    this.f46147e = new ArrayList(this.f46147e);
                    this.f46146d |= 1;
                }
            }

            public Type D() {
                return this.f46158p;
            }

            public Argument E(int i6) {
                return this.f46147e.get(i6);
            }

            public int F() {
                return this.f46147e.size();
            }

            public Type H() {
                return this.f46150h;
            }

            public Type I() {
                return this.f46156n;
            }

            public boolean J() {
                return (this.f46146d & 2048) == 2048;
            }

            public boolean K() {
                return (this.f46146d & 8) == 8;
            }

            public boolean L() {
                return (this.f46146d & 512) == 512;
            }

            public b N(Type type) {
                if ((this.f46146d & 2048) != 2048 || this.f46158p == Type.getDefaultInstance()) {
                    this.f46158p = type;
                } else {
                    this.f46158p = Type.newBuilder(this.f46158p).k(type).z();
                }
                this.f46146d |= 2048;
                return this;
            }

            public b O(Type type) {
                if ((this.f46146d & 8) != 8 || this.f46150h == Type.getDefaultInstance()) {
                    this.f46150h = type;
                } else {
                    this.f46150h = Type.newBuilder(this.f46150h).k(type).z();
                }
                this.f46146d |= 8;
                return this;
            }

            public b R(Type type) {
                if ((this.f46146d & 512) != 512 || this.f46156n == Type.getDefaultInstance()) {
                    this.f46156n = type;
                } else {
                    this.f46156n = Type.newBuilder(this.f46156n).k(type).z();
                }
                this.f46146d |= 512;
                return this;
            }

            public b T(int i6) {
                this.f46146d |= 4096;
                this.f46159q = i6;
                return this;
            }

            public b U(int i6) {
                this.f46146d |= 32;
                this.f46152j = i6;
                return this;
            }

            public b V(int i6) {
                this.f46146d |= 8192;
                this.f46160r = i6;
                return this;
            }

            public b W(int i6) {
                this.f46146d |= 4;
                this.f46149g = i6;
                return this;
            }

            public b Y(int i6) {
                this.f46146d |= 16;
                this.f46151i = i6;
                return this;
            }

            public b Z(boolean z5) {
                this.f46146d |= 2;
                this.f46148f = z5;
                return this;
            }

            public b b0(int i6) {
                this.f46146d |= 1024;
                this.f46157o = i6;
                return this;
            }

            public b c0(int i6) {
                this.f46146d |= 256;
                this.f46155m = i6;
                return this;
            }

            public b d0(int i6) {
                this.f46146d |= 64;
                this.f46153k = i6;
                return this;
            }

            public b e0(int i6) {
                this.f46146d |= 128;
                this.f46154l = i6;
                return this;
            }

            public Type z() {
                Type type = new Type(this);
                int i6 = this.f46146d;
                if ((i6 & 1) == 1) {
                    this.f46147e = Collections.unmodifiableList(this.f46147e);
                    this.f46146d &= -2;
                }
                type.argument_ = this.f46147e;
                int i7 = (i6 & 2) != 2 ? 0 : 1;
                type.nullable_ = this.f46148f;
                if ((i6 & 4) == 4) {
                    i7 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.f46149g;
                if ((i6 & 8) == 8) {
                    i7 |= 4;
                }
                type.flexibleUpperBound_ = this.f46150h;
                if ((i6 & 16) == 16) {
                    i7 |= 8;
                }
                type.flexibleUpperBoundId_ = this.f46151i;
                if ((i6 & 32) == 32) {
                    i7 |= 16;
                }
                type.className_ = this.f46152j;
                if ((i6 & 64) == 64) {
                    i7 |= 32;
                }
                type.typeParameter_ = this.f46153k;
                if ((i6 & 128) == 128) {
                    i7 |= 64;
                }
                type.typeParameterName_ = this.f46154l;
                if ((i6 & 256) == 256) {
                    i7 |= 128;
                }
                type.typeAliasName_ = this.f46155m;
                if ((i6 & 512) == 512) {
                    i7 |= 256;
                }
                type.outerType_ = this.f46156n;
                if ((i6 & 1024) == 1024) {
                    i7 |= 512;
                }
                type.outerTypeId_ = this.f46157o;
                if ((i6 & 2048) == 2048) {
                    i7 |= 1024;
                }
                type.abbreviatedType_ = this.f46158p;
                if ((i6 & 4096) == 4096) {
                    i7 |= 2048;
                }
                type.abbreviatedTypeId_ = this.f46159q;
                if ((i6 & 8192) == 8192) {
                    i7 |= 4096;
                }
                type.flags_ = this.f46160r;
                type.bitField0_ = i7;
                return type;
            }

            private b() {
                M();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Type h() {
                return Type.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            public b k(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.f46147e.isEmpty()) {
                        this.f46147e = type.argument_;
                        this.f46146d &= -2;
                    } else {
                        C();
                        this.f46147e.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    Z(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    W(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    O(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    Y(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    U(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    d0(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    e0(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    c0(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    R(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    b0(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    N(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    T(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    V(type.getFlags());
                }
                t(type);
                l(i().d(type.unknownFields));
                return this;
            }

            public b S(Type type) {
                type.getClass();
                this.f46158p = type;
                this.f46146d |= 2048;
                return this;
            }

            public b X(Type type) {
                type.getClass();
                this.f46150h = type;
                this.f46146d |= 8;
                return this;
            }

            public b a0(Type type) {
                type.getClass();
                this.f46156n = type;
                this.f46146d |= 512;
                return this;
            }

            public b x(Argument.b bVar) {
                C();
                this.f46147e.add(bVar.build());
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public Type build() {
                Type z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void M() {
            }
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.argument_ = Collections.EMPTY_LIST;
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static b newBuilder(Type type) {
            return newBuilder().k(type);
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int i6) {
            return this.argument_.get(i6);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public Type h() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Type> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.p(1, this.flags_) : 0;
            for (int i7 = 0; i7 < this.argument_.size(); i7++) {
                p5 += CodedOutputStream.t(2, this.argument_.get(i7));
            }
            if ((this.bitField0_ & 1) == 1) {
                p5 += CodedOutputStream.b(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.t(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.p(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.p(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.p(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                p5 += CodedOutputStream.p(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                p5 += CodedOutputStream.t(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                p5 += CodedOutputStream.p(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                p5 += CodedOutputStream.p(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                p5 += CodedOutputStream.t(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                p5 += CodedOutputStream.p(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = p5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
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
            for (int i6 = 0; i6 < getArgumentCount(); i6++) {
                if (!getArgument(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Type(GeneratedMessageLite.c<Type, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.e0(1, this.flags_);
            }
            for (int i6 = 0; i6 < this.argument_.size(); i6++) {
                codedOutputStream.h0(2, this.argument_.get(i6));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.P(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.h0(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.e0(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.h0(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.e0(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.e0(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.h0(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.e0(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private Type(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Type(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int K2 = eVar.K();
                            switch (K2) {
                                case 0:
                                    z5 = true;
                                case 8:
                                    this.bitField0_ |= 4096;
                                    this.flags_ = eVar.s();
                                case 18:
                                    if (!z6) {
                                        this.argument_ = new ArrayList();
                                        z6 = true;
                                    }
                                    this.argument_.add(eVar.u(Argument.PARSER, fVar));
                                case 24:
                                    this.bitField0_ |= 1;
                                    this.nullable_ = eVar.k();
                                case 32:
                                    this.bitField0_ |= 2;
                                    this.flexibleTypeCapabilitiesId_ = eVar.s();
                                case 42:
                                    builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                    Type type = (Type) eVar.u(PARSER, fVar);
                                    this.flexibleUpperBound_ = type;
                                    if (builder != null) {
                                        builder.k(type);
                                        this.flexibleUpperBound_ = builder.z();
                                    }
                                    this.bitField0_ |= 4;
                                case 48:
                                    this.bitField0_ |= 16;
                                    this.className_ = eVar.s();
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.typeParameter_ = eVar.s();
                                case 64:
                                    this.bitField0_ |= 8;
                                    this.flexibleUpperBoundId_ = eVar.s();
                                case 72:
                                    this.bitField0_ |= 64;
                                    this.typeParameterName_ = eVar.s();
                                case 82:
                                    builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                    Type type2 = (Type) eVar.u(PARSER, fVar);
                                    this.outerType_ = type2;
                                    if (builder != null) {
                                        builder.k(type2);
                                        this.outerType_ = builder.z();
                                    }
                                    this.bitField0_ |= 256;
                                case 88:
                                    this.bitField0_ |= 512;
                                    this.outerTypeId_ = eVar.s();
                                case 96:
                                    this.bitField0_ |= 128;
                                    this.typeAliasName_ = eVar.s();
                                case 106:
                                    builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                    Type type3 = (Type) eVar.u(PARSER, fVar);
                                    this.abbreviatedType_ = type3;
                                    if (builder != null) {
                                        builder.k(type3);
                                        this.abbreviatedType_ = builder.z();
                                    }
                                    this.bitField0_ |= 1024;
                                case 112:
                                    this.bitField0_ |= 2048;
                                    this.abbreviatedTypeId_ = eVar.s();
                                default:
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                        z5 = true;
                                    }
                            }
                        } catch (IOException e6) {
                            throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e7) {
                        throw e7.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
            if (z6) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements s {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> PARSER = new a();
        private static final TypeAlias defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private List<CompilerPluginData> compilerPluginData_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeAlias> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public TypeAlias d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeAlias(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<TypeAlias, b> implements s {

            /* renamed from: d, reason: collision with root package name */
            private int f46161d;

            /* renamed from: e, reason: collision with root package name */
            private int f46162e = 6;

            /* renamed from: f, reason: collision with root package name */
            private int f46163f;

            /* renamed from: g, reason: collision with root package name */
            private List<TypeParameter> f46164g;

            /* renamed from: h, reason: collision with root package name */
            private Type f46165h;

            /* renamed from: i, reason: collision with root package name */
            private int f46166i;

            /* renamed from: j, reason: collision with root package name */
            private Type f46167j;

            /* renamed from: k, reason: collision with root package name */
            private int f46168k;

            /* renamed from: l, reason: collision with root package name */
            private List<Annotation> f46169l;

            /* renamed from: m, reason: collision with root package name */
            private List<Integer> f46170m;

            /* renamed from: n, reason: collision with root package name */
            private List<CompilerPluginData> f46171n;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: U, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b A() {
                return new b();
            }

            private void B() {
                if ((this.f46161d & 128) != 128) {
                    this.f46169l = new ArrayList(this.f46169l);
                    this.f46161d |= 128;
                }
            }

            private void C() {
                if ((this.f46161d & 512) != 512) {
                    this.f46171n = new ArrayList(this.f46171n);
                    this.f46161d |= 512;
                }
            }

            private void D() {
                if ((this.f46161d & 4) != 4) {
                    this.f46164g = new ArrayList(this.f46164g);
                    this.f46161d |= 4;
                }
            }

            private void E() {
                if ((this.f46161d & 256) != 256) {
                    this.f46170m = new ArrayList(this.f46170m);
                    this.f46161d |= 256;
                }
            }

            public Annotation F(int i6) {
                return this.f46169l.get(i6);
            }

            public int G() {
                return this.f46169l.size();
            }

            public CompilerPluginData H(int i6) {
                return this.f46171n.get(i6);
            }

            public int I() {
                return this.f46171n.size();
            }

            public Type K() {
                return this.f46167j;
            }

            public TypeParameter L(int i6) {
                return this.f46164g.get(i6);
            }

            public int M() {
                return this.f46164g.size();
            }

            public Type N() {
                return this.f46165h;
            }

            public boolean O() {
                return (this.f46161d & 32) == 32;
            }

            public boolean P() {
                return (this.f46161d & 2) == 2;
            }

            public boolean Q() {
                return (this.f46161d & 8) == 8;
            }

            public b S(Type type) {
                if ((this.f46161d & 32) != 32 || this.f46167j == Type.getDefaultInstance()) {
                    this.f46167j = type;
                } else {
                    this.f46167j = Type.newBuilder(this.f46167j).k(type).z();
                }
                this.f46161d |= 32;
                return this;
            }

            public b V(Type type) {
                if ((this.f46161d & 8) != 8 || this.f46165h == Type.getDefaultInstance()) {
                    this.f46165h = type;
                } else {
                    this.f46165h = Type.newBuilder(this.f46165h).k(type).z();
                }
                this.f46161d |= 8;
                return this;
            }

            public b W(int i6) {
                this.f46161d |= 64;
                this.f46168k = i6;
                return this;
            }

            public b X(int i6) {
                this.f46161d |= 1;
                this.f46162e = i6;
                return this;
            }

            public b Y(int i6) {
                this.f46161d |= 2;
                this.f46163f = i6;
                return this;
            }

            public b Z(int i6) {
                this.f46161d |= 16;
                this.f46166i = i6;
                return this;
            }

            public TypeAlias y() {
                TypeAlias typeAlias = new TypeAlias(this);
                int i6 = this.f46161d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                typeAlias.flags_ = this.f46162e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                typeAlias.name_ = this.f46163f;
                if ((this.f46161d & 4) == 4) {
                    this.f46164g = Collections.unmodifiableList(this.f46164g);
                    this.f46161d &= -5;
                }
                typeAlias.typeParameter_ = this.f46164g;
                if ((i6 & 8) == 8) {
                    i7 |= 4;
                }
                typeAlias.underlyingType_ = this.f46165h;
                if ((i6 & 16) == 16) {
                    i7 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.f46166i;
                if ((i6 & 32) == 32) {
                    i7 |= 16;
                }
                typeAlias.expandedType_ = this.f46167j;
                if ((i6 & 64) == 64) {
                    i7 |= 32;
                }
                typeAlias.expandedTypeId_ = this.f46168k;
                if ((this.f46161d & 128) == 128) {
                    this.f46169l = Collections.unmodifiableList(this.f46169l);
                    this.f46161d &= -129;
                }
                typeAlias.annotation_ = this.f46169l;
                if ((this.f46161d & 256) == 256) {
                    this.f46170m = Collections.unmodifiableList(this.f46170m);
                    this.f46161d &= -257;
                }
                typeAlias.versionRequirement_ = this.f46170m;
                if ((this.f46161d & 512) == 512) {
                    this.f46171n = Collections.unmodifiableList(this.f46171n);
                    this.f46161d &= -513;
                }
                typeAlias.compilerPluginData_ = this.f46171n;
                typeAlias.bitField0_ = i7;
                return typeAlias;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46164g = list;
                this.f46165h = Type.getDefaultInstance();
                this.f46167j = Type.getDefaultInstance();
                this.f46169l = list;
                this.f46170m = list;
                this.f46171n = list;
                R();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public TypeAlias h() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: T, reason: merged with bridge method [inline-methods] */
            public b k(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    X(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    Y(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.f46164g.isEmpty()) {
                        this.f46164g = typeAlias.typeParameter_;
                        this.f46161d &= -5;
                    } else {
                        D();
                        this.f46164g.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    V(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    Z(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    S(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    W(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.f46169l.isEmpty()) {
                        this.f46169l = typeAlias.annotation_;
                        this.f46161d &= -129;
                    } else {
                        B();
                        this.f46169l.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.f46170m.isEmpty()) {
                        this.f46170m = typeAlias.versionRequirement_;
                        this.f46161d &= -257;
                    } else {
                        E();
                        this.f46170m.addAll(typeAlias.versionRequirement_);
                    }
                }
                if (!typeAlias.compilerPluginData_.isEmpty()) {
                    if (this.f46171n.isEmpty()) {
                        this.f46171n = typeAlias.compilerPluginData_;
                        this.f46161d &= -513;
                    } else {
                        C();
                        this.f46171n.addAll(typeAlias.compilerPluginData_);
                    }
                }
                t(typeAlias);
                l(i().d(typeAlias.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!P()) {
                    return false;
                }
                for (int i6 = 0; i6 < M(); i6++) {
                    if (!L(i6).isInitialized()) {
                        return false;
                    }
                }
                if (Q() && !N().isInitialized()) {
                    return false;
                }
                if (O() && !K().isInitialized()) {
                    return false;
                }
                for (int i7 = 0; i7 < G(); i7++) {
                    if (!F(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < I(); i8++) {
                    if (!H(i8).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public TypeAlias build() {
                TypeAlias y5 = y();
                if (y5.isInitialized()) {
                    return y5;
                }
                throw a.AbstractC0905a.f(y5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b p() {
                return A().k(y());
            }

            private void R() {
            }
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = list;
            this.versionRequirement_ = list;
            this.compilerPluginData_ = list;
        }

        public static b newBuilder() {
            return b.A();
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(TypeAlias typeAlias) {
            return newBuilder().k(typeAlias);
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public CompilerPluginData getCompilerPluginData(int i6) {
            return this.compilerPluginData_.get(i6);
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public TypeAlias h() {
            return defaultInstance;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.name_);
            }
            for (int i7 = 0; i7 < this.typeParameter_.size(); i7++) {
                p5 += CodedOutputStream.t(3, this.typeParameter_.get(i7));
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.t(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.p(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.t(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.p(7, this.expandedTypeId_);
            }
            for (int i8 = 0; i8 < this.annotation_.size(); i8++) {
                p5 += CodedOutputStream.t(8, this.annotation_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.versionRequirement_.size(); i10++) {
                i9 += CodedOutputStream.q(this.versionRequirement_.get(i10).intValue());
            }
            int size = p5 + i9 + (getVersionRequirementList().size() * 2);
            for (int i11 = 0; i11 < this.compilerPluginData_.size(); i11++) {
                size += CodedOutputStream.t(32, this.compilerPluginData_.get(i11));
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeParameter getTypeParameter(int i6) {
            return this.typeParameter_.get(i6);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getTypeParameterCount(); i6++) {
                if (!getTypeParameter(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i7 = 0; i7 < getAnnotationCount(); i7++) {
                if (!getAnnotation(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getCompilerPluginDataCount(); i8++) {
                if (!getCompilerPluginData(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private TypeAlias(GeneratedMessageLite.c<TypeAlias, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.name_);
            }
            for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
                codedOutputStream.h0(3, this.typeParameter_.get(i6));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.h0(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.h0(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(7, this.expandedTypeId_);
            }
            for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
                codedOutputStream.h0(8, this.annotation_.get(i7));
            }
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                codedOutputStream.e0(31, this.versionRequirement_.get(i8).intValue());
            }
            for (int i9 = 0; i9 < this.compilerPluginData_.size(); i9++) {
                codedOutputStream.h0(32, this.compilerPluginData_.get(i9));
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private TypeAlias(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            Type.b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                ?? r5 = 128;
                if (!z5) {
                    try {
                        try {
                            int K2 = eVar.K();
                            switch (K2) {
                                case 0:
                                    z5 = true;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.flags_ = eVar.s();
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.name_ = eVar.s();
                                case 26:
                                    if ((i6 & 4) != 4) {
                                        this.typeParameter_ = new ArrayList();
                                        i6 |= 4;
                                    }
                                    this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                case 34:
                                    builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                    Type type = (Type) eVar.u(Type.PARSER, fVar);
                                    this.underlyingType_ = type;
                                    if (builder != null) {
                                        builder.k(type);
                                        this.underlyingType_ = builder.z();
                                    }
                                    this.bitField0_ |= 4;
                                case 40:
                                    this.bitField0_ |= 8;
                                    this.underlyingTypeId_ = eVar.s();
                                case 50:
                                    builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                    Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                    this.expandedType_ = type2;
                                    if (builder != null) {
                                        builder.k(type2);
                                        this.expandedType_ = builder.z();
                                    }
                                    this.bitField0_ |= 16;
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.expandedTypeId_ = eVar.s();
                                case 66:
                                    if ((i6 & 128) != 128) {
                                        this.annotation_ = new ArrayList();
                                        i6 |= 128;
                                    }
                                    this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                                case 248:
                                    if ((i6 & 256) != 256) {
                                        this.versionRequirement_ = new ArrayList();
                                        i6 |= 256;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                case 250:
                                    int j6 = eVar.j(eVar.A());
                                    if ((i6 & 256) != 256 && eVar.e() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        i6 |= 256;
                                    }
                                    while (eVar.e() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j6);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    if ((i6 & 512) != 512) {
                                        this.compilerPluginData_ = new ArrayList();
                                        i6 |= 512;
                                    }
                                    this.compilerPluginData_.add(eVar.u(CompilerPluginData.PARSER, fVar));
                                default:
                                    r5 = parseUnknownField(eVar, K, fVar, K2);
                                    if (r5 == 0) {
                                        z5 = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e6) {
                            throw e6.setUnfinishedMessage(this);
                        } catch (IOException e7) {
                            throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if ((i6 & 4) == 4) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i6 & 128) == r5) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i6 & 256) == 256) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        if ((i6 & 512) == 512) {
                            this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
                } else {
                    if ((i6 & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i6 & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i6 & 256) == 256) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    if ((i6 & 512) == 512) {
                        this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
                    return;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements u {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> PARSER = new a();
        private static final TypeParameter defaultInstance;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum Variance implements h.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);

            private static h.b<Variance> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<Variance> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Variance a(int i6) {
                    return Variance.valueOf(i6);
                }
            }

            public static Variance valueOf(int i6) {
                if (i6 == 0) {
                    return IN;
                }
                if (i6 == 1) {
                    return OUT;
                }
                if (i6 != 2) {
                    return null;
                }
                return INV;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            Variance(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeParameter> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public TypeParameter d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeParameter(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<TypeParameter, b> implements u {

            /* renamed from: d, reason: collision with root package name */
            private int f46172d;

            /* renamed from: e, reason: collision with root package name */
            private int f46173e;

            /* renamed from: f, reason: collision with root package name */
            private int f46174f;

            /* renamed from: g, reason: collision with root package name */
            private boolean f46175g;

            /* renamed from: h, reason: collision with root package name */
            private Variance f46176h = Variance.INV;

            /* renamed from: i, reason: collision with root package name */
            private List<Type> f46177i;

            /* renamed from: j, reason: collision with root package name */
            private List<Integer> f46178j;

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46172d & 32) != 32) {
                    this.f46178j = new ArrayList(this.f46178j);
                    this.f46172d |= 32;
                }
            }

            private void D() {
                if ((this.f46172d & 16) != 16) {
                    this.f46177i = new ArrayList(this.f46177i);
                    this.f46172d |= 16;
                }
            }

            public Type F(int i6) {
                return this.f46177i.get(i6);
            }

            public int G() {
                return this.f46177i.size();
            }

            public boolean H() {
                return (this.f46172d & 1) == 1;
            }

            public boolean I() {
                return (this.f46172d & 2) == 2;
            }

            public b M(int i6) {
                this.f46172d |= 1;
                this.f46173e = i6;
                return this;
            }

            public b N(int i6) {
                this.f46172d |= 2;
                this.f46174f = i6;
                return this;
            }

            public b O(boolean z5) {
                this.f46172d |= 4;
                this.f46175g = z5;
                return this;
            }

            public TypeParameter z() {
                TypeParameter typeParameter = new TypeParameter(this);
                int i6 = this.f46172d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                typeParameter.id_ = this.f46173e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                typeParameter.name_ = this.f46174f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                typeParameter.reified_ = this.f46175g;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                typeParameter.variance_ = this.f46176h;
                if ((this.f46172d & 16) == 16) {
                    this.f46177i = Collections.unmodifiableList(this.f46177i);
                    this.f46172d &= -17;
                }
                typeParameter.upperBound_ = this.f46177i;
                if ((this.f46172d & 32) == 32) {
                    this.f46178j = Collections.unmodifiableList(this.f46178j);
                    this.f46172d &= -33;
                }
                typeParameter.upperBoundId_ = this.f46178j;
                typeParameter.bitField0_ = i7;
                return typeParameter;
            }

            private b() {
                List list = Collections.EMPTY_LIST;
                this.f46177i = list;
                this.f46178j = list;
                J();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public TypeParameter h() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b k(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    M(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    N(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    O(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    P(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.f46177i.isEmpty()) {
                        this.f46177i = typeParameter.upperBound_;
                        this.f46172d &= -17;
                    } else {
                        D();
                        this.f46177i.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.f46178j.isEmpty()) {
                        this.f46178j = typeParameter.upperBoundId_;
                        this.f46172d &= -33;
                    } else {
                        C();
                        this.f46178j.addAll(typeParameter.upperBoundId_);
                    }
                }
                t(typeParameter);
                l(i().d(typeParameter.unknownFields));
                return this;
            }

            public b P(Variance variance) {
                variance.getClass();
                this.f46172d |= 8;
                this.f46176h = variance;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!H() || !I()) {
                    return false;
                }
                for (int i6 = 0; i6 < G(); i6++) {
                    if (!F(i6).isInitialized()) {
                        return false;
                    }
                }
                if (!s()) {
                    return false;
                }
                return true;
            }

            public b x(Type type) {
                type.getClass();
                D();
                this.f46177i.add(type);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public TypeParameter build() {
                TypeParameter z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void J() {
            }
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            List list = Collections.EMPTY_LIST;
            this.upperBound_ = list;
            this.upperBoundId_ = list;
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(TypeParameter typeParameter) {
            return newBuilder().k(typeParameter);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public TypeParameter h() {
            return defaultInstance;
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.id_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.b(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.i(4, this.variance_.getNumber());
            }
            for (int i7 = 0; i7 < this.upperBound_.size(); i7++) {
                p5 += CodedOutputStream.t(5, this.upperBound_.get(i7));
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.upperBoundId_.size(); i9++) {
                i8 += CodedOutputStream.q(this.upperBoundId_.get(i9).intValue());
            }
            int i10 = p5 + i8;
            if (!getUpperBoundIdList().isEmpty()) {
                i10 = i10 + 1 + CodedOutputStream.q(i8);
            }
            this.upperBoundIdMemoizedSerializedSize = i8;
            int extensionsSerializedSize = i10 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getUpperBound(int i6) {
            return this.upperBound_.get(i6);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getUpperBoundCount(); i6++) {
                if (!getUpperBound(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private TypeParameter(GeneratedMessageLite.c<TypeParameter, ?> cVar) {
            super(cVar);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.P(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.W(4, this.variance_.getNumber());
            }
            for (int i6 = 0; i6 < this.upperBound_.size(); i6++) {
                codedOutputStream.h0(5, this.upperBound_.get(i6));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.s0(50);
                codedOutputStream.s0(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i7 = 0; i7 < this.upperBoundId_.size(); i7++) {
                codedOutputStream.f0(this.upperBoundId_.get(i7).intValue());
            }
            newExtensionWriter.a(1000, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private TypeParameter(boolean z5) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
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
                                this.id_ = eVar.s();
                            } else if (K2 == 16) {
                                this.bitField0_ |= 2;
                                this.name_ = eVar.s();
                            } else if (K2 == 24) {
                                this.bitField0_ |= 4;
                                this.reified_ = eVar.k();
                            } else if (K2 == 32) {
                                int n6 = eVar.n();
                                Variance valueOf = Variance.valueOf(n6);
                                if (valueOf == null) {
                                    K.s0(K2);
                                    K.s0(n6);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.variance_ = valueOf;
                                }
                            } else if (K2 == 42) {
                                if ((i6 & 16) != 16) {
                                    this.upperBound_ = new ArrayList();
                                    i6 |= 16;
                                }
                                this.upperBound_.add(eVar.u(Type.PARSER, fVar));
                            } else if (K2 == 48) {
                                if ((i6 & 32) != 32) {
                                    this.upperBoundId_ = new ArrayList();
                                    i6 |= 32;
                                }
                                this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                            } else if (K2 != 50) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                int j6 = eVar.j(eVar.A());
                                if ((i6 & 32) != 32 && eVar.e() > 0) {
                                    this.upperBoundId_ = new ArrayList();
                                    i6 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.upperBoundId_.add(Integer.valueOf(eVar.s()));
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
                    if ((i6 & 16) == 16) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if ((i6 & 32) == 32) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if ((i6 & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
    public static final class TypeTable extends GeneratedMessageLite implements v {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> PARSER = new a();
        private static final TypeTable defaultInstance;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public TypeTable d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeTable(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<TypeTable, b> implements v {

            /* renamed from: b, reason: collision with root package name */
            private int f46179b;

            /* renamed from: c, reason: collision with root package name */
            private List<Type> f46180c = Collections.EMPTY_LIST;

            /* renamed from: d, reason: collision with root package name */
            private int f46181d = -1;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i6 = 0; i6 < u(); i6++) {
                    if (!getType(i6).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46179b & 1) != 1) {
                    this.f46180c = new ArrayList(this.f46180c);
                    this.f46179b |= 1;
                }
            }

            public Type getType(int i6) {
                return this.f46180c.get(i6);
            }

            public TypeTable o() {
                TypeTable typeTable = new TypeTable(this);
                int i6 = this.f46179b;
                if ((i6 & 1) == 1) {
                    this.f46180c = Collections.unmodifiableList(this.f46180c);
                    this.f46179b &= -2;
                }
                typeTable.type_ = this.f46180c;
                int i7 = (i6 & 2) != 2 ? 0 : 1;
                typeTable.firstNullable_ = this.f46181d;
                typeTable.bitField0_ = i7;
                return typeTable;
            }

            public int u() {
                return this.f46180c.size();
            }

            public b y(int i6) {
                this.f46179b |= 2;
                this.f46181d = i6;
                return this;
            }

            private b() {
                v();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public TypeTable build() {
                TypeTable o5 = o();
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
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public TypeTable h() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b k(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.f46180c.isEmpty()) {
                        this.f46180c = typeTable.type_;
                        this.f46179b &= -2;
                    } else {
                        s();
                        this.f46180c.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    y(typeTable.getFirstNullable());
                }
                l(i().d(typeTable.unknownFields));
                return this;
            }

            private void v() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Collections.EMPTY_LIST;
            this.firstNullable_ = -1;
        }

        public static b newBuilder(TypeTable typeTable) {
            return newBuilder().k(typeTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public TypeTable h() {
            return defaultInstance;
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.type_.size(); i8++) {
                i7 += CodedOutputStream.t(1, this.type_.get(i8));
            }
            if ((this.bitField0_ & 1) == 1) {
                i7 += CodedOutputStream.p(2, this.firstNullable_);
            }
            int size = i7 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Type getType(int i6) {
            return this.type_.get(i6);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
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
            for (int i6 = 0; i6 < getTypeCount(); i6++) {
                if (!getType(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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

        private TypeTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.type_.size(); i6++) {
                codedOutputStream.h0(1, this.type_.get(i6));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(2, this.firstNullable_);
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private TypeTable(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        int K2 = eVar.K();
                        if (K2 != 0) {
                            if (K2 == 10) {
                                if (!z6) {
                                    this.type_ = new ArrayList();
                                    z6 = true;
                                }
                                this.type_.add(eVar.u(Type.PARSER, fVar));
                            } else if (K2 != 16) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = eVar.s();
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.type_ = Collections.unmodifiableList(this.type_);
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
            if (z6) {
                this.type_ = Collections.unmodifiableList(this.type_);
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
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements w {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> PARSER = new a();
        private static final ValueParameter defaultInstance;
        private Annotation.Argument.Value annotationParameterDefaultValue_;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ValueParameter> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public ValueParameter d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new ValueParameter(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.c<ValueParameter, b> implements w {

            /* renamed from: d, reason: collision with root package name */
            private int f46182d;

            /* renamed from: e, reason: collision with root package name */
            private int f46183e;

            /* renamed from: f, reason: collision with root package name */
            private int f46184f;

            /* renamed from: h, reason: collision with root package name */
            private int f46186h;

            /* renamed from: j, reason: collision with root package name */
            private int f46188j;

            /* renamed from: g, reason: collision with root package name */
            private Type f46185g = Type.getDefaultInstance();

            /* renamed from: i, reason: collision with root package name */
            private Type f46187i = Type.getDefaultInstance();

            /* renamed from: k, reason: collision with root package name */
            private List<Annotation> f46189k = Collections.EMPTY_LIST;

            /* renamed from: l, reason: collision with root package name */
            private Annotation.Argument.Value f46190l = Annotation.Argument.Value.getDefaultInstance();

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b B() {
                return new b();
            }

            private void C() {
                if ((this.f46182d & 64) != 64) {
                    this.f46189k = new ArrayList(this.f46189k);
                    this.f46182d |= 64;
                }
            }

            public Annotation D(int i6) {
                return this.f46189k.get(i6);
            }

            public int E() {
                return this.f46189k.size();
            }

            public Annotation.Argument.Value F() {
                return this.f46190l;
            }

            public Type H() {
                return this.f46187i;
            }

            public boolean I() {
                return (this.f46182d & 128) == 128;
            }

            public boolean J() {
                return (this.f46182d & 2) == 2;
            }

            public boolean K() {
                return (this.f46182d & 4) == 4;
            }

            public boolean L() {
                return (this.f46182d & 16) == 16;
            }

            public b N(Annotation.Argument.Value value) {
                if ((this.f46182d & 128) != 128 || this.f46190l == Annotation.Argument.Value.getDefaultInstance()) {
                    this.f46190l = value;
                } else {
                    this.f46190l = Annotation.Argument.Value.newBuilder(this.f46190l).k(value).p();
                }
                this.f46182d |= 128;
                return this;
            }

            public b Q(Type type) {
                if ((this.f46182d & 4) != 4 || this.f46185g == Type.getDefaultInstance()) {
                    this.f46185g = type;
                } else {
                    this.f46185g = Type.newBuilder(this.f46185g).k(type).z();
                }
                this.f46182d |= 4;
                return this;
            }

            public b R(Type type) {
                if ((this.f46182d & 16) != 16 || this.f46187i == Type.getDefaultInstance()) {
                    this.f46187i = type;
                } else {
                    this.f46187i = Type.newBuilder(this.f46187i).k(type).z();
                }
                this.f46182d |= 16;
                return this;
            }

            public b T(int i6) {
                this.f46182d |= 1;
                this.f46183e = i6;
                return this;
            }

            public b U(int i6) {
                this.f46182d |= 2;
                this.f46184f = i6;
                return this;
            }

            public b W(int i6) {
                this.f46182d |= 8;
                this.f46186h = i6;
                return this;
            }

            public b Y(int i6) {
                this.f46182d |= 32;
                this.f46188j = i6;
                return this;
            }

            public Type getType() {
                return this.f46185g;
            }

            public ValueParameter z() {
                ValueParameter valueParameter = new ValueParameter(this);
                int i6 = this.f46182d;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                valueParameter.flags_ = this.f46183e;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                valueParameter.name_ = this.f46184f;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                valueParameter.type_ = this.f46185g;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                valueParameter.typeId_ = this.f46186h;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                valueParameter.varargElementType_ = this.f46187i;
                if ((i6 & 32) == 32) {
                    i7 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.f46188j;
                if ((this.f46182d & 64) == 64) {
                    this.f46189k = Collections.unmodifiableList(this.f46189k);
                    this.f46182d &= -65;
                }
                valueParameter.annotation_ = this.f46189k;
                if ((i6 & 128) == 128) {
                    i7 |= 64;
                }
                valueParameter.annotationParameterDefaultValue_ = this.f46190l;
                valueParameter.bitField0_ = i7;
                return valueParameter;
            }

            private b() {
                M();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b p() {
                return B().k(z());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ValueParameter h() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: O, reason: merged with bridge method [inline-methods] */
            public b k(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    T(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    U(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    Q(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    W(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    R(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    Y(valueParameter.getVarargElementTypeId());
                }
                if (!valueParameter.annotation_.isEmpty()) {
                    if (this.f46189k.isEmpty()) {
                        this.f46189k = valueParameter.annotation_;
                        this.f46182d &= -65;
                    } else {
                        C();
                        this.f46189k.addAll(valueParameter.annotation_);
                    }
                }
                if (valueParameter.hasAnnotationParameterDefaultValue()) {
                    N(valueParameter.getAnnotationParameterDefaultValue());
                }
                t(valueParameter);
                l(i().d(valueParameter.unknownFields));
                return this;
            }

            public b S(Annotation.Argument.Value value) {
                value.getClass();
                this.f46190l = value;
                this.f46182d |= 128;
                return this;
            }

            public b V(Type type) {
                type.getClass();
                this.f46185g = type;
                this.f46182d |= 4;
                return this;
            }

            public b X(Type type) {
                type.getClass();
                this.f46187i = type;
                this.f46182d |= 16;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!J()) {
                    return false;
                }
                if (K() && !getType().isInitialized()) {
                    return false;
                }
                if (L() && !H().isInitialized()) {
                    return false;
                }
                for (int i6 = 0; i6 < E(); i6++) {
                    if (!D(i6).isInitialized()) {
                        return false;
                    }
                }
                if ((I() && !F().isInitialized()) || !s()) {
                    return false;
                }
                return true;
            }

            public b x(Iterable<? extends Annotation> iterable) {
                C();
                a.AbstractC0905a.a(iterable, this.f46189k);
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public ValueParameter build() {
                ValueParameter z5 = z();
                if (z5.isInitialized()) {
                    return z5;
                }
                throw a.AbstractC0905a.f(z5);
            }

            private void M() {
            }
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
            this.annotation_ = Collections.EMPTY_LIST;
            this.annotationParameterDefaultValue_ = Annotation.Argument.Value.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.B();
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(ValueParameter valueParameter) {
            return newBuilder().k(valueParameter);
        }

        public Annotation getAnnotation(int i6) {
            return this.annotation_.get(i6);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Annotation.Argument.Value getAnnotationParameterDefaultValue() {
            return this.annotationParameterDefaultValue_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public ValueParameter h() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.t(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.t(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.p(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.p(6, this.varargElementTypeId_);
            }
            for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
                p5 += CodedOutputStream.t(7, this.annotation_.get(i7));
            }
            if ((this.bitField0_ & 64) == 64) {
                p5 += CodedOutputStream.t(8, this.annotationParameterDefaultValue_);
            }
            int extensionsSerializedSize = p5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasAnnotationParameterDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i6 = 0; i6 < getAnnotationCount(); i6++) {
                if (!getAnnotation(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasAnnotationParameterDefaultValue() && !getAnnotationParameterDefaultValue().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private ValueParameter(GeneratedMessageLite.c<ValueParameter, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.h0(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.h0(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(6, this.varargElementTypeId_);
            }
            for (int i6 = 0; i6 < this.annotation_.size(); i6++) {
                codedOutputStream.h0(7, this.annotation_.get(i6));
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.h0(8, this.annotationParameterDefaultValue_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.m0(this.unknownFields);
        }

        private ValueParameter(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                this.flags_ = eVar.s();
                            } else if (K2 != 16) {
                                if (K2 == 26) {
                                    Type.b builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                    Type type = (Type) eVar.u(Type.PARSER, fVar);
                                    this.type_ = type;
                                    if (builder != null) {
                                        builder.k(type);
                                        this.type_ = builder.z();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (K2 == 34) {
                                    Type.b builder2 = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                    Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                    this.varargElementType_ = type2;
                                    if (builder2 != null) {
                                        builder2.k(type2);
                                        this.varargElementType_ = builder2.z();
                                    }
                                    this.bitField0_ |= 16;
                                } else if (K2 == 40) {
                                    this.bitField0_ |= 8;
                                    this.typeId_ = eVar.s();
                                } else if (K2 == 48) {
                                    this.bitField0_ |= 32;
                                    this.varargElementTypeId_ = eVar.s();
                                } else if (K2 == 58) {
                                    if ((i6 & 64) != 64) {
                                        this.annotation_ = new ArrayList();
                                        i6 = 64;
                                    }
                                    this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                                } else if (K2 != 66) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    Annotation.Argument.Value.b builder3 = (this.bitField0_ & 64) == 64 ? this.annotationParameterDefaultValue_.toBuilder() : null;
                                    Annotation.Argument.Value value = (Annotation.Argument.Value) eVar.u(Annotation.Argument.Value.PARSER, fVar);
                                    this.annotationParameterDefaultValue_ = value;
                                    if (builder3 != null) {
                                        builder3.k(value);
                                        this.annotationParameterDefaultValue_ = builder3.p();
                                    }
                                    this.bitField0_ |= 64;
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.name_ = eVar.s();
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e6) {
                        throw e6.setUnfinishedMessage(this);
                    } catch (IOException e7) {
                        throw new InvalidProtocolBufferException(e7.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i6 & 64) == 64) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
            if ((i6 & 64) == 64) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
    public static final class VersionRequirement extends GeneratedMessageLite implements x {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> PARSER = new a();
        private static final VersionRequirement defaultInstance;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum Level implements h.a {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);

            private static h.b<Level> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<Level> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Level a(int i6) {
                    return Level.valueOf(i6);
                }
            }

            public static Level valueOf(int i6) {
                if (i6 == 0) {
                    return WARNING;
                }
                if (i6 == 1) {
                    return ERROR;
                }
                if (i6 != 2) {
                    return null;
                }
                return HIDDEN;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            Level(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum VersionKind implements h.a {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);

            private static h.b<VersionKind> internalValueMap = new a();
            private final int value;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static class a implements h.b<VersionKind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public VersionKind a(int i6) {
                    return VersionKind.valueOf(i6);
                }
            }

            public static VersionKind valueOf(int i6) {
                if (i6 == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i6 == 1) {
                    return COMPILER_VERSION;
                }
                if (i6 != 2) {
                    return null;
                }
                return API_VERSION;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            VersionKind(int i6, int i7) {
                this.value = i7;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirement> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public VersionRequirement d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirement(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<VersionRequirement, b> implements x {

            /* renamed from: b, reason: collision with root package name */
            private int f46191b;

            /* renamed from: c, reason: collision with root package name */
            private int f46192c;

            /* renamed from: d, reason: collision with root package name */
            private int f46193d;

            /* renamed from: f, reason: collision with root package name */
            private int f46195f;

            /* renamed from: g, reason: collision with root package name */
            private int f46196g;

            /* renamed from: e, reason: collision with root package name */
            private Level f46194e = Level.ERROR;

            /* renamed from: h, reason: collision with root package name */
            private VersionKind f46197h = VersionKind.LANGUAGE_VERSION;

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
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            public b A(int i6) {
                this.f46191b |= 2;
                this.f46193d = i6;
                return this;
            }

            public VersionRequirement o() {
                VersionRequirement versionRequirement = new VersionRequirement(this);
                int i6 = this.f46191b;
                int i7 = (i6 & 1) != 1 ? 0 : 1;
                versionRequirement.version_ = this.f46192c;
                if ((i6 & 2) == 2) {
                    i7 |= 2;
                }
                versionRequirement.versionFull_ = this.f46193d;
                if ((i6 & 4) == 4) {
                    i7 |= 4;
                }
                versionRequirement.level_ = this.f46194e;
                if ((i6 & 8) == 8) {
                    i7 |= 8;
                }
                versionRequirement.errorCode_ = this.f46195f;
                if ((i6 & 16) == 16) {
                    i7 |= 16;
                }
                versionRequirement.message_ = this.f46196g;
                if ((i6 & 32) == 32) {
                    i7 |= 32;
                }
                versionRequirement.versionKind_ = this.f46197h;
                versionRequirement.bitField0_ = i7;
                return versionRequirement;
            }

            public b w(int i6) {
                this.f46191b |= 8;
                this.f46195f = i6;
                return this;
            }

            public b y(int i6) {
                this.f46191b |= 16;
                this.f46196g = i6;
                return this;
            }

            public b z(int i6) {
                this.f46191b |= 1;
                this.f46192c = i6;
                return this;
            }

            private b() {
                t();
            }

            public b B(VersionKind versionKind) {
                versionKind.getClass();
                this.f46191b |= 32;
                this.f46197h = versionKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public VersionRequirement build() {
                VersionRequirement o5 = o();
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
            public VersionRequirement h() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b k(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    z(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    A(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    x(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    w(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    y(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    B(versionRequirement.getVersionKind());
                }
                l(i().d(versionRequirement.unknownFields));
                return this;
            }

            public b x(Level level) {
                level.getClass();
                this.f46191b |= 4;
                this.f46194e = level;
                return this;
            }

            private void t() {
            }
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        public static b newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().k(versionRequirement);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public VersionRequirement h() {
            return defaultInstance;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int p5 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.p(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                p5 += CodedOutputStream.p(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                p5 += CodedOutputStream.i(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                p5 += CodedOutputStream.p(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                p5 += CodedOutputStream.p(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                p5 += CodedOutputStream.i(6, this.versionKind_.getNumber());
            }
            int size = p5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
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

        private VersionRequirement(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.W(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.W(6, this.versionKind_.getNumber());
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private VersionRequirement(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        private VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
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
                                this.version_ = eVar.s();
                            } else if (K2 == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = eVar.s();
                            } else if (K2 == 24) {
                                int n6 = eVar.n();
                                Level valueOf = Level.valueOf(n6);
                                if (valueOf == null) {
                                    K.s0(K2);
                                    K.s0(n6);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = valueOf;
                                }
                            } else if (K2 == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = eVar.s();
                            } else if (K2 == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = eVar.s();
                            } else if (K2 != 48) {
                                if (!parseUnknownField(eVar, K, fVar, K2)) {
                                }
                            } else {
                                int n7 = eVar.n();
                                VersionKind valueOf2 = VersionKind.valueOf(n7);
                                if (valueOf2 == null) {
                                    K.s0(K2);
                                    K.s0(n7);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = valueOf2;
                                }
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
    public static final class VersionRequirementTable extends GeneratedMessageLite implements y {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> PARSER = new a();
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirementTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public VersionRequirementTable d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(eVar, fVar);
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends GeneratedMessageLite.b<VersionRequirementTable, b> implements y {

            /* renamed from: b, reason: collision with root package name */
            private int f46198b;

            /* renamed from: c, reason: collision with root package name */
            private List<VersionRequirement> f46199c = Collections.EMPTY_LIST;

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0905a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b e(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.d(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b.e(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$b");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b q() {
                return new b();
            }

            private void s() {
                if ((this.f46198b & 1) != 1) {
                    this.f46199c = new ArrayList(this.f46199c);
                    this.f46198b |= 1;
                }
            }

            public VersionRequirementTable o() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this);
                if ((this.f46198b & 1) == 1) {
                    this.f46199c = Collections.unmodifiableList(this.f46199c);
                    this.f46198b &= -2;
                }
                versionRequirementTable.requirement_ = this.f46199c;
                return versionRequirementTable;
            }

            private b() {
                u();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public VersionRequirementTable build() {
                VersionRequirementTable o5 = o();
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
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public VersionRequirementTable h() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public b k(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.f46199c.isEmpty()) {
                        this.f46199c = versionRequirementTable.requirement_;
                        this.f46198b &= -2;
                    } else {
                        s();
                        this.f46199c.addAll(versionRequirementTable.requirement_);
                    }
                }
                l(i().d(versionRequirementTable.unknownFields));
                return this;
            }

            private void u() {
            }
        }

        public static b newBuilder() {
            return b.q();
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.requirement_ = Collections.EMPTY_LIST;
        }

        public static b newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().k(versionRequirementTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: getDefaultInstanceForType */
        public VersionRequirementTable h() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i6 = this.memoizedSerializedSize;
            if (i6 != -1) {
                return i6;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.requirement_.size(); i8++) {
                i7 += CodedOutputStream.t(1, this.requirement_.get(i8));
            }
            int size = i7 + this.unknownFields.size();
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

        private VersionRequirementTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.i();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i6 = 0; i6 < this.requirement_.size(); i6++) {
                codedOutputStream.h0(1, this.requirement_.get(i6));
            }
            codedOutputStream.m0(this.unknownFields);
        }

        private VersionRequirementTable(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f46469a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private VersionRequirementTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b t5 = kotlin.reflect.jvm.internal.impl.protobuf.d.t();
            CodedOutputStream K = CodedOutputStream.K(t5, 1);
            boolean z5 = false;
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int K2 = eVar.K();
                            if (K2 != 0) {
                                if (K2 != 10) {
                                    if (!parseUnknownField(eVar, K, fVar, K2)) {
                                    }
                                } else {
                                    if (!z6) {
                                        this.requirement_ = new ArrayList();
                                        z6 = true;
                                    }
                                    this.requirement_.add(eVar.u(VersionRequirement.PARSER, fVar));
                                }
                            }
                            z5 = true;
                        } catch (IOException e6) {
                            throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e7) {
                        throw e7.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z6) {
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            if (z6) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
    public enum Visibility implements h.a {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);

        private static h.b<Visibility> internalValueMap = new a();
        private final int value;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a implements h.b<Visibility> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Visibility a(int i6) {
                return Visibility.valueOf(i6);
            }
        }

        public static Visibility valueOf(int i6) {
            if (i6 == 0) {
                return INTERNAL;
            }
            if (i6 == 1) {
                return PRIVATE;
            }
            if (i6 == 2) {
                return PROTECTED;
            }
            if (i6 == 3) {
                return PUBLIC;
            }
            if (i6 == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i6 != 5) {
                return null;
            }
            return LOCAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        Visibility(int i6, int i7) {
            this.value = i7;
        }
    }
}
