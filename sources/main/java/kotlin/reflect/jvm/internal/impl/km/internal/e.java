package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f45179a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f45180b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j f45181c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f45182d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final e f45183e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<Object> f45184f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<Integer, Integer> f45185g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<p> f45186h;

    public e(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d strings, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h types, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j versionRequirements, boolean z5, @Nullable e eVar, @NotNull List<? extends Object> contextExtensions) {
        g0.p(strings, "strings");
        g0.p(types, "types");
        g0.p(versionRequirements, "versionRequirements");
        g0.p(contextExtensions, "contextExtensions");
        this.f45179a = strings;
        this.f45180b = types;
        this.f45181c = versionRequirements;
        this.f45182d = z5;
        this.f45183e = eVar;
        this.f45184f = contextExtensions;
        this.f45185g = new LinkedHashMap();
        this.f45186h = p.f45189a.c();
    }

    @NotNull
    public final String a(int i6) {
        return f.a(this.f45179a, i6);
    }

    @NotNull
    public final String b(int i6) {
        return this.f45179a.getString(i6);
    }

    @NotNull
    public final List<p> c() {
        return this.f45186h;
    }

    public final boolean d() {
        return this.f45182d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d e() {
        return this.f45179a;
    }

    @Nullable
    public final Integer f(int i6) {
        Integer num = this.f45185g.get(Integer.valueOf(i6));
        if (num != null) {
            return num;
        }
        e eVar = this.f45183e;
        if (eVar != null) {
            return eVar.f(i6);
        }
        return null;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h g() {
        return this.f45180b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j h() {
        return this.f45181c;
    }

    @NotNull
    public final e i(@NotNull List<ProtoBuf.TypeParameter> typeParameters) {
        g0.p(typeParameters, "typeParameters");
        e eVar = new e(this.f45179a, this.f45180b, this.f45181c, this.f45182d, this, this.f45184f);
        for (ProtoBuf.TypeParameter typeParameter : typeParameters) {
            eVar.f45185g.put(Integer.valueOf(typeParameter.getName()), Integer.valueOf(typeParameter.getId()));
        }
        return eVar;
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j jVar, boolean z5, e eVar, List list, int i6, v vVar) {
        this(dVar, hVar, jVar, z5, (i6 & 16) != 0 ? null : eVar, (i6 & 32) != 0 ? f0.J() : list);
    }
}
