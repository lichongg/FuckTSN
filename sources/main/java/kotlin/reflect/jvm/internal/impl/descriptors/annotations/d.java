package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f44646a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f44647b;

    /* renamed from: c, reason: collision with root package name */
    private final e1 f44648c;

    private static /* synthetic */ void b(int i6) {
        String str = (i6 == 3 || i6 == 4 || i6 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 3 || i6 == 4 || i6 == 5) ? 2 : 3];
        if (i6 == 1) {
            objArr[0] = "valueArguments";
        } else if (i6 == 2) {
            objArr[0] = SocialConstants.PARAM_SOURCE;
        } else if (i6 == 3 || i6 == 4 || i6 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i6 == 3) {
            objArr[1] = "getType";
        } else if (i6 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i6 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i6 != 3 && i6 != 4 && i6 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 3 && i6 != 4 && i6 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public d(@NotNull t0 t0Var, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map, @NotNull e1 e1Var) {
        if (t0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (e1Var == null) {
            b(2);
        }
        this.f44646a = t0Var;
        this.f44647b = map;
        this.f44648c = e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map = this.f44647b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e1 getSource() {
        e1 e1Var = this.f44648c;
        if (e1Var == null) {
            b(5);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public t0 getType() {
        t0 t0Var = this.f44646a;
        if (t0Var == null) {
            b(3);
        }
        return t0Var;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.m.f46581h.O(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return c.a.a(this);
    }
}
