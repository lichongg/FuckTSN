package cn.jiguang.bp;

import java.util.UUID;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2461a = new e(new UUID(0, 0));

    /* renamed from: b, reason: collision with root package name */
    private final UUID f2462b;

    public e() {
        this(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f2462b.compareTo(((e) obj).f2462b) == 0;
    }

    public e(UUID uuid) {
        this.f2462b = uuid == null ? UUID.randomUUID() : uuid;
    }

    public int hashCode() {
        return this.f2462b.hashCode();
    }

    public String toString() {
        return this.f2462b.toString().replace("-", "");
    }
}
