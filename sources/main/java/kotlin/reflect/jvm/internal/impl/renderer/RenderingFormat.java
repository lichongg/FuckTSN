package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class RenderingFormat {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ RenderingFormat[] $VALUES;
    public static final RenderingFormat PLAIN = new RenderingFormat("PLAIN", 0) { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.b
        {
            kotlin.jvm.internal.v vVar = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            g0.p(string, "string");
            return string;
        }
    };
    public static final RenderingFormat HTML = new RenderingFormat("HTML", 1) { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.a
        {
            kotlin.jvm.internal.v vVar = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            g0.p(string, "string");
            return kotlin.text.u.x2(kotlin.text.u.x2(string, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    };

    private static final /* synthetic */ RenderingFormat[] $values() {
        return new RenderingFormat[]{PLAIN, HTML};
    }

    public /* synthetic */ RenderingFormat(String str, int i6, kotlin.jvm.internal.v vVar) {
        this(str, i6);
    }

    @NotNull
    public abstract String escape(@NotNull String str);

    static {
        RenderingFormat[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    private RenderingFormat(String str, int i6) {
    }

    public static RenderingFormat valueOf(String str) {
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, str);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }
}
