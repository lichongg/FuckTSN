package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.a;
import kotlin.enums.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CaptureStatus {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ CaptureStatus[] $VALUES;
    public static final CaptureStatus FOR_SUBTYPING = new CaptureStatus("FOR_SUBTYPING", 0);
    public static final CaptureStatus FOR_INCORPORATION = new CaptureStatus("FOR_INCORPORATION", 1);
    public static final CaptureStatus FROM_EXPRESSION = new CaptureStatus("FROM_EXPRESSION", 2);

    private static final /* synthetic */ CaptureStatus[] $values() {
        return new CaptureStatus[]{FOR_SUBTYPING, FOR_INCORPORATION, FROM_EXPRESSION};
    }

    static {
        CaptureStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = c.c($values);
    }

    public static CaptureStatus valueOf(String str) {
        return (CaptureStatus) Enum.valueOf(CaptureStatus.class, str);
    }

    public static CaptureStatus[] values() {
        return (CaptureStatus[]) $VALUES.clone();
    }

    private CaptureStatus(String str, int i6) {
    }
}
