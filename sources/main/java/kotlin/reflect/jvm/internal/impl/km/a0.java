package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public KmVersionRequirementVersionKind f45109a;

    /* renamed from: b, reason: collision with root package name */
    public KmVersionRequirementLevel f45110b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Integer f45111c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private String f45112d;

    /* renamed from: e, reason: collision with root package name */
    public z f45113e;

    @Nullable
    public final Integer a() {
        return this.f45111c;
    }

    @NotNull
    public final KmVersionRequirementVersionKind b() {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.f45109a;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        g0.S("kind");
        return null;
    }

    @NotNull
    public final KmVersionRequirementLevel c() {
        KmVersionRequirementLevel kmVersionRequirementLevel = this.f45110b;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        g0.S("level");
        return null;
    }

    @Nullable
    public final String d() {
        return this.f45112d;
    }

    @NotNull
    public final z e() {
        z zVar = this.f45113e;
        if (zVar != null) {
            return zVar;
        }
        g0.S("version");
        return null;
    }

    public final void f(@Nullable Integer num) {
        this.f45111c = num;
    }

    public final void g(@NotNull KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        g0.p(kmVersionRequirementVersionKind, "<set-?>");
        this.f45109a = kmVersionRequirementVersionKind;
    }

    public final void h(@NotNull KmVersionRequirementLevel kmVersionRequirementLevel) {
        g0.p(kmVersionRequirementLevel, "<set-?>");
        this.f45110b = kmVersionRequirementLevel;
    }

    public final void i(@Nullable String str) {
        this.f45112d = str;
    }

    public final void j(@NotNull z zVar) {
        g0.p(zVar, "<set-?>");
        this.f45113e = zVar;
    }

    @NotNull
    public String toString() {
        return "KmVersionRequirement(kind=" + b() + ", level=" + c() + ", version=" + e() + ", errorCode=" + this.f45111c + ", message=" + this.f45112d + ')';
    }
}
