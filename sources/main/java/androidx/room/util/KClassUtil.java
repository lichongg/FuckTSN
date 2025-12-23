package androidx.room.util;

import androidx.annotation.RestrictTo;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "KClassUtil")
/* loaded from: D:\Downloads\app\classes.dex */
public final class KClassUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <T, C> T findAndInstantiateDatabaseImpl(@NotNull Class<C> klass, @NotNull String suffix) {
        String str;
        String str2;
        g0.p(klass, "klass");
        g0.p(suffix, "suffix");
        Package r02 = klass.getPackage();
        if (r02 == null || (str = r02.getName()) == null) {
            str = "";
        }
        String canonicalName = klass.getCanonicalName();
        g0.m(canonicalName);
        if (str.length() != 0) {
            canonicalName = canonicalName.substring(str.length() + 1);
            g0.o(canonicalName, "substring(...)");
        }
        String str3 = u.w2(canonicalName, '.', '_', false, 4, null) + suffix;
        try {
            if (str.length() == 0) {
                str2 = str3;
            } else {
                str2 = str + '.' + str3;
            }
            Class<?> cls = Class.forName(str2, true, klass.getClassLoader());
            g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return (T) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str3 + " does not exist. Is Room annotation processor correctly configured?", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName(), e7);
        } catch (InstantiationException e8) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName(), e8);
        }
    }

    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }
}
