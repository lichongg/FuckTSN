package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MemberKind {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ MemberKind[] $VALUES;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.d flag;
    public static final MemberKind DECLARATION = new MemberKind("DECLARATION", 0, 0);
    public static final MemberKind FAKE_OVERRIDE = new MemberKind("FAKE_OVERRIDE", 1, 1);
    public static final MemberKind DELEGATION = new MemberKind("DELEGATION", 2, 2);
    public static final MemberKind SYNTHESIZED = new MemberKind("SYNTHESIZED", 3, 3);

    private static final /* synthetic */ MemberKind[] $values() {
        return new MemberKind[]{DECLARATION, FAKE_OVERRIDE, DELEGATION, SYNTHESIZED};
    }

    static {
        MemberKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<MemberKind> getEntries() {
        return $ENTRIES;
    }

    public static MemberKind valueOf(String str) {
        return (MemberKind) Enum.valueOf(MemberKind.class, str);
    }

    public static MemberKind[] values() {
        return (MemberKind[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.km.internal.d getFlag$kotlin_metadata() {
        return this.flag;
    }

    private MemberKind(String str, int i6, int i7) {
        b.d<ProtoBuf.MemberKind> MEMBER_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46221p;
        g0.o(MEMBER_KIND, "MEMBER_KIND");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.d(MEMBER_KIND, i7);
    }
}
