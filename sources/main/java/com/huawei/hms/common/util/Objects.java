package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Objects {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f33124a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f33125b;

        public ToStringHelper(Object obj) {
            this.f33125b = Preconditions.checkNotNull(obj);
            this.f33124a = new ArrayList();
        }

        public /* synthetic */ ToStringHelper(Object obj, a aVar) {
            this(obj);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f33125b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f33124a.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append(this.f33124a.get(i6));
                if (i6 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            this.f33124a.add(str2 + ContainerUtils.KEY_VALUE_DELIMITER + valueOf);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static /* synthetic */ class a {
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj, null);
    }

    public Objects() {
        throw new AssertionError("illegal argument");
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
