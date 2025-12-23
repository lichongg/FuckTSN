package xyz.adscope.ad.model.impl.db;

import xyz.adscope.common.v2.model.annotation.DataBaseNode;
import xyz.adscope.common.v2.persistent.db.IBaseDatabaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdvertisingDBModel extends IBaseDatabaseModel {

    /* renamed from: a, reason: collision with root package name */
    @DataBaseNode(column = "cacheKey")
    private String f55425a;

    /* renamed from: b, reason: collision with root package name */
    @DataBaseNode(column = "cacheTime")
    private String f55426b;

    /* renamed from: c, reason: collision with root package name */
    @DataBaseNode(column = "expireTime")
    private String f55427c;

    /* renamed from: d, reason: collision with root package name */
    @DataBaseNode(column = "cacheData")
    private String f55428d;

    public void a(long j6) {
        this.f55426b = j6 + "";
    }

    public void b(String str) {
        this.f55425a = str;
    }

    public String a() {
        return this.f55428d;
    }

    public void b(long j6) {
        this.f55427c = j6 + "";
    }

    public void a(String str) {
        this.f55428d = str;
    }
}
