package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.y;
import y3.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m implements p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final k f45690a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f45691b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45692c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<y, Integer> f45693d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<y, b1> f45694e;

    public m(@NotNull k c6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull z typeParameterOwner, int i6) {
        g0.p(c6, "c");
        g0.p(containingDeclaration, "containingDeclaration");
        g0.p(typeParameterOwner, "typeParameterOwner");
        this.f45690a = c6;
        this.f45691b = containingDeclaration;
        this.f45692c = i6;
        this.f45693d = kotlin.reflect.jvm.internal.impl.utils.a.d(typeParameterOwner.getTypeParameters());
        this.f45694e = c6.e().c(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b1 c(m mVar, y typeParameter) {
        g0.p(typeParameter, "typeParameter");
        Integer num = mVar.f45693d.get(typeParameter);
        if (num == null) {
            return null;
        }
        return new b1(c.k(c.d(mVar.f45690a, mVar), mVar.f45691b.getAnnotations()), typeParameter, mVar.f45692c + num.intValue(), mVar.f45691b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.p
    @Nullable
    public j1 a(@NotNull y javaTypeParameter) {
        g0.p(javaTypeParameter, "javaTypeParameter");
        b1 invoke = this.f45694e.invoke(javaTypeParameter);
        return invoke != null ? invoke : this.f45690a.f().a(javaTypeParameter);
    }
}
