package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.acse.ottn.l3;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AnnotationUseSiteTarget {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES;

    @NotNull
    private final String renderName;
    public static final AnnotationUseSiteTarget ALL = new AnnotationUseSiteTarget("ALL", 0, null, 1, null);
    public static final AnnotationUseSiteTarget FIELD = new AnnotationUseSiteTarget("FIELD", 1, null, 1, null);
    public static final AnnotationUseSiteTarget FILE = new AnnotationUseSiteTarget("FILE", 2, null, 1, null);
    public static final AnnotationUseSiteTarget PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 3, null, 1, null);
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 4, l3.f4736f);
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 5, l3.f4738h);
    public static final AnnotationUseSiteTarget RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 6, null, 1, null);
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 7, "param");
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 8, "setparam");
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 9, "delegate");

    private AnnotationUseSiteTarget(String str, int i6, String str2) {
        this.renderName = str2 == null ? f4.a.f(name()) : str2;
    }

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{ALL, FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    static {
        AnnotationUseSiteTarget[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static AnnotationUseSiteTarget valueOf(String str) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, str);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i6, String str2, int i7, v vVar) {
        this(str, i6, (i7 & 1) != 0 ? null : str2);
    }
}
