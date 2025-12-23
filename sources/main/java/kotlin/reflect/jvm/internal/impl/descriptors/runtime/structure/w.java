package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w extends y implements y3.n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Field f45037a;

    @Override // y3.n
    public boolean x() {
        return false;
    }

    public w(@NotNull Field member) {
        kotlin.jvm.internal.g0.p(member, "member");
        this.f45037a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.y
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Field N() {
        return this.f45037a;
    }

    @Override // y3.n
    @NotNull
    public e0 getType() {
        e0.a aVar = e0.f45001a;
        Type genericType = N().getGenericType();
        kotlin.jvm.internal.g0.o(genericType, "getGenericType(...)");
        return aVar.a(genericType);
    }

    @Override // y3.n
    public boolean H() {
        return N().isEnumConstant();
    }
}
