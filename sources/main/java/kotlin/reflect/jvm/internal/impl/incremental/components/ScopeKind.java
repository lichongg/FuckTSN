package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.enums.a;
import kotlin.enums.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ScopeKind {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ScopeKind[] $VALUES;
    public static final ScopeKind PACKAGE = new ScopeKind("PACKAGE", 0);
    public static final ScopeKind CLASSIFIER = new ScopeKind("CLASSIFIER", 1);

    private static final /* synthetic */ ScopeKind[] $values() {
        return new ScopeKind[]{PACKAGE, CLASSIFIER};
    }

    static {
        ScopeKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = c.c($values);
    }

    public static ScopeKind valueOf(String str) {
        return (ScopeKind) Enum.valueOf(ScopeKind.class, str);
    }

    public static ScopeKind[] values() {
        return (ScopeKind[]) $VALUES.clone();
    }

    private ScopeKind(String str, int i6) {
    }
}
