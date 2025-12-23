package androidx.room.util;

import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewInfoKt {
    public static final boolean equalsCommon(@NotNull ViewInfo viewInfo, @Nullable Object obj) {
        g0.p(viewInfo, "<this>");
        if (viewInfo == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo2 = (ViewInfo) obj;
        if (g0.g(viewInfo.name, viewInfo2.name)) {
            String str = viewInfo.sql;
            if (str != null ? g0.g(str, viewInfo2.sql) : viewInfo2.sql == null) {
                return true;
            }
        }
        return false;
    }

    public static final int hashCodeCommon(@NotNull ViewInfo viewInfo) {
        g0.p(viewInfo, "<this>");
        int hashCode = viewInfo.name.hashCode() * 31;
        String str = viewInfo.sql;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public static final String toStringCommon(@NotNull ViewInfo viewInfo) {
        g0.p(viewInfo, "<this>");
        return u.x("\n            |ViewInfo {\n            |   name = '" + viewInfo.name + "',\n            |   sql = '" + viewInfo.sql + "'\n            |}\n        ", null, 1, null);
    }
}
