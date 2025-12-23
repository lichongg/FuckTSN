package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";

    /* renamed from: a, reason: collision with root package name */
    private String f36692a;

    /* renamed from: b, reason: collision with root package name */
    private String f36693b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f36694c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f36695a;

        /* renamed from: b, reason: collision with root package name */
        private String f36696b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, null);
        }

        public Builder setCustomData(String str) {
            this.f36695a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f36696b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f36694c = new JSONObject();
        this.f36692a = builder.f36695a;
        this.f36693b = builder.f36696b;
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String getCustomData() {
        return this.f36692a;
    }

    public JSONObject getOptions() {
        return this.f36694c;
    }

    public String getUserId() {
        return this.f36693b;
    }
}
