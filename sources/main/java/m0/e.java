package m0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(indices = {@Index(unique = true, value = {"userId", "type"})}, primaryKeys = {"userId", "type"}, tableName = "sports_set")
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @ColumnInfo(name = "userId", typeAffinity = 2)
    @NotNull
    private String f49737a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull
    private String f49738b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "content", typeAffinity = 2)
    @NotNull
    private String f49739c;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return g0.g(this.f49737a, eVar.f49737a) && g0.g(this.f49738b, eVar.f49738b) && g0.g(this.f49739c, eVar.f49739c);
    }

    public e(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        g0.p(userId, "userId");
        g0.p(type, "type");
        g0.p(getSetting, "getSetting");
        this.f49737a = userId;
        this.f49738b = type;
        this.f49739c = getSetting;
    }

    public static /* synthetic */ e e(e eVar, String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = eVar.f49737a;
        }
        if ((i6 & 2) != 0) {
            str2 = eVar.f49738b;
        }
        if ((i6 & 4) != 0) {
            str3 = eVar.f49739c;
        }
        return eVar.d(str, str2, str3);
    }

    @NotNull
    public final String a() {
        return this.f49737a;
    }

    @NotNull
    public final String b() {
        return this.f49738b;
    }

    @NotNull
    public final String c() {
        return this.f49739c;
    }

    @NotNull
    public final e d(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        g0.p(userId, "userId");
        g0.p(type, "type");
        g0.p(getSetting, "getSetting");
        return new e(userId, type, getSetting);
    }

    @NotNull
    public final String f() {
        return this.f49739c;
    }

    @NotNull
    public final String g() {
        return this.f49737a;
    }

    @NotNull
    public final String getType() {
        return this.f49738b;
    }

    public final void h(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49739c = str;
    }

    public int hashCode() {
        return (((this.f49737a.hashCode() * 31) + this.f49738b.hashCode()) * 31) + this.f49739c.hashCode();
    }

    public final void i(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49738b = str;
    }

    public final void j(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49737a = str;
    }

    @NotNull
    public String toString() {
        return "SportsSetDb(userId=" + this.f49737a + ", type=" + this.f49738b + ", getSetting=" + this.f49739c + ")";
    }
}
