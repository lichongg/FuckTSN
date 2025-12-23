package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "StringUtil")
@SourceDebugExtension({"SMAP\nStringUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1611#2,9:84\n1863#2:93\n1864#2:95\n1620#2:96\n1#3:94\n*S KotlinDebug\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n*L\n64#1:84,9\n64#1:93\n64#1:95\n64#1:96\n64#1:94\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class StringUtil {

    @JvmField
    @NotNull
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Nullable
    public static final List<Integer> splitToIntList(@Nullable String str) {
        List l52;
        Integer num;
        if (str == null || (l52 = u.l5(str, new char[]{io.netty.util.internal.StringUtil.COMMA}, false, 0, 6, null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = l52.iterator();
        while (it.hasNext()) {
            try {
                num = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException unused) {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    public static final void appendPlaceholders(@NotNull StringBuilder builder, int i6) {
        g0.p(builder, "builder");
        for (int i7 = 0; i7 < i6; i7++) {
            builder.append("?");
            if (i7 < i6 - 1) {
                builder.append(",");
            }
        }
    }

    @Nullable
    public static final String joinIntoString(@Nullable List<Integer> list) {
        if (list != null) {
            return f0.r3(list, ",", null, null, 0, null, null, 62, null);
        }
        return null;
    }

    @Deprecated(message = "No longer used by generated code")
    @NotNull
    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Deprecated(message = "No longer used by generated code")
    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }
}
