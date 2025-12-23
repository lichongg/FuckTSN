package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e implements g, j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f46796a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e f46797b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f46798c;

    public e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @Nullable e eVar) {
        g0.p(classDescriptor, "classDescriptor");
        this.f46796a = classDescriptor;
        this.f46797b = eVar == null ? this : eVar;
        this.f46798c = classDescriptor;
    }

    public boolean equals(@Nullable Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f46796a;
        e eVar = obj instanceof e ? (e) obj : null;
        return g0.g(dVar, eVar != null ? eVar.f46796a : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h
    @NotNull
    public e1 getType() {
        e1 s5 = this.f46796a.s();
        g0.o(s5, "getDefaultType(...)");
        return s5;
    }

    public int hashCode() {
        return this.f46796a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.j
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d m() {
        return this.f46796a;
    }

    @NotNull
    public String toString() {
        return "Class{" + getType() + '}';
    }
}
