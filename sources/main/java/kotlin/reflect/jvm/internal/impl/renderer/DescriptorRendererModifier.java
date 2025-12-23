package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import xyz.adscope.common.network.cookie.db.Field;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDescriptorRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,331:1\n3829#2:332\n4344#2,2:333\n*S KotlinDebug\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n*L\n325#1:332\n325#1:333,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DescriptorRendererModifier {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES;

    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL;

    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;

    @NotNull
    public static final a Companion;
    private final boolean includeByDefault;
    public static final DescriptorRendererModifier VISIBILITY = new DescriptorRendererModifier("VISIBILITY", 0, true);
    public static final DescriptorRendererModifier MODALITY = new DescriptorRendererModifier("MODALITY", 1, true);
    public static final DescriptorRendererModifier OVERRIDE = new DescriptorRendererModifier("OVERRIDE", 2, true);
    public static final DescriptorRendererModifier ANNOTATIONS = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
    public static final DescriptorRendererModifier INNER = new DescriptorRendererModifier("INNER", 4, true);
    public static final DescriptorRendererModifier MEMBER_KIND = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
    public static final DescriptorRendererModifier DATA = new DescriptorRendererModifier("DATA", 6, true);
    public static final DescriptorRendererModifier INLINE = new DescriptorRendererModifier("INLINE", 7, true);
    public static final DescriptorRendererModifier EXPECT = new DescriptorRendererModifier("EXPECT", 8, true);
    public static final DescriptorRendererModifier ACTUAL = new DescriptorRendererModifier("ACTUAL", 9, true);
    public static final DescriptorRendererModifier CONST = new DescriptorRendererModifier("CONST", 10, true);
    public static final DescriptorRendererModifier LATEINIT = new DescriptorRendererModifier("LATEINIT", 11, true);
    public static final DescriptorRendererModifier FUN = new DescriptorRendererModifier("FUN", 12, true);
    public static final DescriptorRendererModifier VALUE = new DescriptorRendererModifier(Field.VALUE, 13, true);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    static {
        DescriptorRendererModifier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : values) {
            if (descriptorRendererModifier.includeByDefault) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = f0.f6(arrayList);
        ALL = kotlin.collections.n.Fz(values());
    }

    public static DescriptorRendererModifier valueOf(String str) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, str);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }

    private DescriptorRendererModifier(String str, int i6, boolean z5) {
        this.includeByDefault = z5;
    }
}
