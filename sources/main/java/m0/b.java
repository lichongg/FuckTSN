package m0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(tableName = OptionalModuleUtils.FACE)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = 3)
    private long f49693a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull
    private String f49694b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull
    private String f49695c;

    /* renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "facePath", typeAffinity = 2)
    @NotNull
    private String f49696d;

    /* renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "coordinates", typeAffinity = 2)
    @Nullable
    private String f49697e;

    /* renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "timeStamp", typeAffinity = 2)
    @Nullable
    private String f49698f;

    public b(long j6, @NotNull String identify, @NotNull String type, @NotNull String facePath, @Nullable String str, @Nullable String str2) {
        g0.p(identify, "identify");
        g0.p(type, "type");
        g0.p(facePath, "facePath");
        this.f49693a = j6;
        this.f49694b = identify;
        this.f49695c = type;
        this.f49696d = facePath;
        this.f49697e = str;
        this.f49698f = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f49693a == bVar.f49693a && g0.g(this.f49694b, bVar.f49694b) && g0.g(this.f49695c, bVar.f49695c) && g0.g(this.f49696d, bVar.f49696d) && g0.g(this.f49697e, bVar.f49697e) && g0.g(this.f49698f, bVar.f49698f);
    }

    public static /* synthetic */ b h(b bVar, long j6, String str, String str2, String str3, String str4, String str5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = bVar.f49693a;
        }
        long j7 = j6;
        if ((i6 & 2) != 0) {
            str = bVar.f49694b;
        }
        String str6 = str;
        if ((i6 & 4) != 0) {
            str2 = bVar.f49695c;
        }
        String str7 = str2;
        if ((i6 & 8) != 0) {
            str3 = bVar.f49696d;
        }
        String str8 = str3;
        if ((i6 & 16) != 0) {
            str4 = bVar.f49697e;
        }
        String str9 = str4;
        if ((i6 & 32) != 0) {
            str5 = bVar.f49698f;
        }
        return bVar.g(j7, str6, str7, str8, str9, str5);
    }

    public final long a() {
        return this.f49693a;
    }

    @NotNull
    public final String b() {
        return this.f49694b;
    }

    @NotNull
    public final String c() {
        return this.f49695c;
    }

    @NotNull
    public final String d() {
        return this.f49696d;
    }

    @Nullable
    public final String e() {
        return this.f49697e;
    }

    @Nullable
    public final String f() {
        return this.f49698f;
    }

    @NotNull
    public final b g(long j6, @NotNull String identify, @NotNull String type, @NotNull String facePath, @Nullable String str, @Nullable String str2) {
        g0.p(identify, "identify");
        g0.p(type, "type");
        g0.p(facePath, "facePath");
        return new b(j6, identify, type, facePath, str, str2);
    }

    @NotNull
    public final String getType() {
        return this.f49695c;
    }

    public int hashCode() {
        int a6 = ((((((androidx.camera.camera2.internal.compat.params.e.a(this.f49693a) * 31) + this.f49694b.hashCode()) * 31) + this.f49695c.hashCode()) * 31) + this.f49696d.hashCode()) * 31;
        String str = this.f49697e;
        int hashCode = (a6 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f49698f;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Nullable
    public final String i() {
        return this.f49697e;
    }

    @NotNull
    public final String j() {
        return this.f49696d;
    }

    public final long k() {
        return this.f49693a;
    }

    @NotNull
    public final String l() {
        return this.f49694b;
    }

    @Nullable
    public final String m() {
        return this.f49698f;
    }

    public final void n(@Nullable String str) {
        this.f49697e = str;
    }

    public final void o(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49696d = str;
    }

    public final void p(long j6) {
        this.f49693a = j6;
    }

    public final void q(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49694b = str;
    }

    public final void r(@Nullable String str) {
        this.f49698f = str;
    }

    public final void s(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49695c = str;
    }

    @NotNull
    public String toString() {
        return "FaceDb(id=" + this.f49693a + ", identify=" + this.f49694b + ", type=" + this.f49695c + ", facePath=" + this.f49696d + ", coordinates=" + this.f49697e + ", timeStamp=" + this.f49698f + ")";
    }

    public /* synthetic */ b(long j6, String str, String str2, String str3, String str4, String str5, int i6, v vVar) {
        this((i6 & 1) != 0 ? 0L : j6, str, str2, str3, str4, str5);
    }
}
