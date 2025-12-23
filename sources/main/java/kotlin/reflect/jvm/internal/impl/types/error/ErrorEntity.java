package kotlin.reflect.jvm.internal.impl.types.error;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ErrorEntity {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ ErrorEntity[] $VALUES;

    @NotNull
    private final String debugText;
    public static final ErrorEntity ERROR_CLASS = new ErrorEntity("ERROR_CLASS", 0, "<Error class: %s>");
    public static final ErrorEntity ERROR_FUNCTION = new ErrorEntity("ERROR_FUNCTION", 1, "<Error function>");
    public static final ErrorEntity ERROR_SCOPE = new ErrorEntity("ERROR_SCOPE", 2, "<Error scope>");
    public static final ErrorEntity ERROR_MODULE = new ErrorEntity("ERROR_MODULE", 3, "<Error module>");
    public static final ErrorEntity ERROR_PROPERTY = new ErrorEntity("ERROR_PROPERTY", 4, "<Error property>");
    public static final ErrorEntity ERROR_TYPE = new ErrorEntity("ERROR_TYPE", 5, "[Error type: %s]");
    public static final ErrorEntity PARENT_OF_ERROR_SCOPE = new ErrorEntity("PARENT_OF_ERROR_SCOPE", 6, "<Fake parent for error lexical scope>");

    private static final /* synthetic */ ErrorEntity[] $values() {
        return new ErrorEntity[]{ERROR_CLASS, ERROR_FUNCTION, ERROR_SCOPE, ERROR_MODULE, ERROR_PROPERTY, ERROR_TYPE, PARENT_OF_ERROR_SCOPE};
    }

    static {
        ErrorEntity[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static ErrorEntity valueOf(String str) {
        return (ErrorEntity) Enum.valueOf(ErrorEntity.class, str);
    }

    public static ErrorEntity[] values() {
        return (ErrorEntity[]) $VALUES.clone();
    }

    @NotNull
    public final String getDebugText() {
        return this.debugText;
    }

    private ErrorEntity(String str, int i6, String str2) {
        this.debugText = str2;
    }
}
