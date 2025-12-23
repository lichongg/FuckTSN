package v0;

import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;

/* loaded from: D:\Downloads\app\classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f54682a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f54683b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f54684c = "";

    /* renamed from: d, reason: collision with root package name */
    private EnterFromMerge f54685d = EnterFromMerge.NO_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private EnterMethod f54686e = EnterMethod.NO_VALUE;

    /* renamed from: f, reason: collision with root package name */
    private ActionType f54687f = ActionType.CLICK;

    /* renamed from: g, reason: collision with root package name */
    private long f54688g = 0;

    public b a(ActionType actionType) {
        this.f54687f = actionType;
        return this;
    }

    public b b(String str) {
        this.f54683b = str;
        return this;
    }

    public c c() {
        return new c(this.f54682a, this.f54683b, this.f54684c, this.f54685d, this.f54686e, this.f54687f, this.f54688g);
    }

    public b d(long j6) {
        this.f54688g = j6;
        return this;
    }

    public b e(EnterFromMerge enterFromMerge) {
        this.f54685d = enterFromMerge;
        return this;
    }

    public b f(EnterMethod enterMethod) {
        this.f54686e = enterMethod;
        return this;
    }

    public b g(String str) {
        this.f54684c = str;
        return this;
    }

    public b h(long j6) {
        this.f54682a = j6;
        return this;
    }
}
