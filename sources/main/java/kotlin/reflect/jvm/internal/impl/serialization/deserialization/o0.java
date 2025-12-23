package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47048a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f47049b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f47050c;

        static {
            int[] iArr = new int[ProtoBuf.MemberKind.values().length];
            try {
                iArr[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f47048a = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            try {
                iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f47049b = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            try {
                iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f47050c = iArr3;
        }
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s a(@NotNull n0 n0Var, @Nullable ProtoBuf.Visibility visibility) {
        kotlin.jvm.internal.g0.p(n0Var, "<this>");
        switch (visibility == null ? -1 : a.f47050c[visibility.ordinal()]) {
            case 1:
                kotlin.reflect.jvm.internal.impl.descriptors.s INTERNAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f44947d;
                kotlin.jvm.internal.g0.o(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE = kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a;
                kotlin.jvm.internal.g0.o(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE_TO_THIS = kotlin.reflect.jvm.internal.impl.descriptors.r.f44945b;
                kotlin.jvm.internal.g0.o(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                kotlin.reflect.jvm.internal.impl.descriptors.s PROTECTED = kotlin.reflect.jvm.internal.impl.descriptors.r.f44946c;
                kotlin.jvm.internal.g0.o(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                kotlin.reflect.jvm.internal.impl.descriptors.s PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
                kotlin.jvm.internal.g0.o(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                kotlin.reflect.jvm.internal.impl.descriptors.s LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f44949f;
                kotlin.jvm.internal.g0.o(LOCAL, "LOCAL");
                return LOCAL;
            default:
                kotlin.reflect.jvm.internal.impl.descriptors.s PRIVATE2 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a;
                kotlin.jvm.internal.g0.o(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    @NotNull
    public static final CallableMemberDescriptor.Kind b(@NotNull n0 n0Var, @Nullable ProtoBuf.MemberKind memberKind) {
        kotlin.jvm.internal.g0.p(n0Var, "<this>");
        int i6 = memberKind == null ? -1 : a.f47048a[memberKind.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? CallableMemberDescriptor.Kind.DECLARATION : CallableMemberDescriptor.Kind.SYNTHESIZED : CallableMemberDescriptor.Kind.DELEGATION : CallableMemberDescriptor.Kind.FAKE_OVERRIDE : CallableMemberDescriptor.Kind.DECLARATION;
    }
}
