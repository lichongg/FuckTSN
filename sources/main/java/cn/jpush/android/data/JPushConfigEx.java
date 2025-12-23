package cn.jpush.android.data;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushConfigEx extends JPushConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f3620a;

    /* renamed from: b, reason: collision with root package name */
    private String f3621b;

    /* renamed from: c, reason: collision with root package name */
    private String f3622c;

    /* renamed from: d, reason: collision with root package name */
    private String f3623d;

    public JPushConfigEx() {
    }

    public JPushConfigEx(JPushConfig jPushConfig) {
        setjAppKey(jPushConfig.getjAppKey());
        setMzAppId(jPushConfig.getMzAppId());
        setMzAppKey(jPushConfig.getMzAppKey());
        setOppoAppId(jPushConfig.getOppoAppId());
        setOppoAppKey(jPushConfig.getOppoAppKey());
        setOppoAppSecret(jPushConfig.getOppoAppSecret());
        setXmAppId(jPushConfig.getXmAppId());
        setXmAppKey(jPushConfig.getXmAppKey());
    }

    public String getHonorAppId() {
        return this.f3621b;
    }

    public String getHwAppId() {
        return this.f3620a;
    }

    public String getVivoAppId() {
        return this.f3623d;
    }

    public String getVivoAppKey() {
        return this.f3622c;
    }

    public void setHonorAppId(String str) {
        this.f3621b = str;
    }

    public void setHwAppId(String str) {
        this.f3620a = str;
    }

    public void setVivoAppId(String str) {
        this.f3623d = str;
    }

    public void setVivoAppKey(String str) {
        this.f3622c = str;
    }
}
