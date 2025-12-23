package androidx.room.util;

import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FtsTableInfoKt {
    public static final boolean equalsCommon(@NotNull FtsTableInfo ftsTableInfo, @Nullable Object obj) {
        g0.p(ftsTableInfo, "<this>");
        if (ftsTableInfo == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo2 = (FtsTableInfo) obj;
        if (g0.g(ftsTableInfo.name, ftsTableInfo2.name) && g0.g(ftsTableInfo.columns, ftsTableInfo2.columns)) {
            return g0.g(ftsTableInfo.options, ftsTableInfo2.options);
        }
        return false;
    }

    public static final int hashCodeCommon(@NotNull FtsTableInfo ftsTableInfo) {
        g0.p(ftsTableInfo, "<this>");
        return (((ftsTableInfo.name.hashCode() * 31) + ftsTableInfo.columns.hashCode()) * 31) + ftsTableInfo.options.hashCode();
    }

    @NotNull
    public static final String toStringCommon(@NotNull FtsTableInfo ftsTableInfo) {
        g0.p(ftsTableInfo, "<this>");
        return u.x("\n            |FtsTableInfo {\n            |   name = '" + ftsTableInfo.name + "',\n            |   columns = {" + TableInfoKt.formatString(f0.v5(ftsTableInfo.columns)) + "\n            |   options = {" + TableInfoKt.formatString(f0.v5(ftsTableInfo.options)) + "\n            |}\n        ", null, 1, null);
    }
}
