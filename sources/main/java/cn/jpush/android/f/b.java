package cn.jpush.android.f;

import android.annotation.TargetApi;
import java.util.Objects;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f3643a;

    /* renamed from: b, reason: collision with root package name */
    public long f3644b;

    @TargetApi(19)
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f3644b == bVar.f3644b && Objects.equals(this.f3643a, bVar.f3643a)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public final int hashCode() {
        return Objects.hash(this.f3643a, Long.valueOf(this.f3644b));
    }

    public b(String str, long j6) {
        this.f3643a = str;
        this.f3644b = j6;
    }
}
