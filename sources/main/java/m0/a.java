package m0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(indices = {@Index(unique = true, value = {"deviceId"})}, primaryKeys = {"deviceId"}, tableName = "environment")
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @ColumnInfo(name = "deviceId", typeAffinity = 2)
    @NotNull
    private String f49690a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "safe", typeAffinity = 2)
    @Nullable
    private String f49691b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "oppo", typeAffinity = 2)
    @Nullable
    private String f49692c;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g0.g(this.f49690a, aVar.f49690a) && g0.g(this.f49691b, aVar.f49691b) && g0.g(this.f49692c, aVar.f49692c);
    }

    public a(@NotNull String deviceId, @Nullable String str, @Nullable String str2) {
        g0.p(deviceId, "deviceId");
        this.f49690a = deviceId;
        this.f49691b = str;
        this.f49692c = str2;
    }

    public static /* synthetic */ a e(a aVar, String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = aVar.f49690a;
        }
        if ((i6 & 2) != 0) {
            str2 = aVar.f49691b;
        }
        if ((i6 & 4) != 0) {
            str3 = aVar.f49692c;
        }
        return aVar.d(str, str2, str3);
    }

    @NotNull
    public final String a() {
        return this.f49690a;
    }

    @Nullable
    public final String b() {
        return this.f49691b;
    }

    @Nullable
    public final String c() {
        return this.f49692c;
    }

    @NotNull
    public final a d(@NotNull String deviceId, @Nullable String str, @Nullable String str2) {
        g0.p(deviceId, "deviceId");
        return new a(deviceId, str, str2);
    }

    @NotNull
    public final String f() {
        return this.f49690a;
    }

    @Nullable
    public final String g() {
        return this.f49692c;
    }

    @Nullable
    public final String h() {
        return this.f49691b;
    }

    public int hashCode() {
        int hashCode = this.f49690a.hashCode() * 31;
        String str = this.f49691b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f49692c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void i(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49690a = str;
    }

    public final void j(@Nullable String str) {
        this.f49692c = str;
    }

    public final void k(@Nullable String str) {
        this.f49691b = str;
    }

    @NotNull
    public String toString() {
        return "EnvironmentDb(deviceId=" + this.f49690a + ", safe=" + this.f49691b + ", oppo=" + this.f49692c + ")";
    }
}
