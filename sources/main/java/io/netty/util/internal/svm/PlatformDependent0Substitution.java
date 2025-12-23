package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetClass(className = "io.netty.util.internal.PlatformDependent0")
/* loaded from: D:\Downloads\app\classes8.dex */
final class PlatformDependent0Substitution {

    @RecomputeFieldValue(declClassName = "java.nio.Buffer", kind = RecomputeFieldValue.Kind.FieldOffset, name = "address")
    @Alias
    private static long ADDRESS_FIELD_OFFSET;

    private PlatformDependent0Substitution() {
    }
}
