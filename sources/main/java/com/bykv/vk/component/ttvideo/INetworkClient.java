package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public interface INetworkClient {

    /* renamed from: com.bykv.vk.component.ttvideo.INetworkClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Keep
    public static class Result {
        public final String body;
        public final int code;

        /* renamed from: e, reason: collision with root package name */
        public final Exception f22833e;
        public final String header;
        public final JSONObject response;

        @Keep
        public static class Builder {
            String body;
            int code;

            /* renamed from: e, reason: collision with root package name */
            Exception f22834e;
            String header;
            JSONObject response;

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
            }

            public Result build() {
                return new Result(this, null);
            }

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setCode(int i6) {
                this.code = i6;
                return this;
            }

            public Builder setException(Exception exc) {
                this.f22834e = exc;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }
        }

        /* synthetic */ Result(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.f22833e = builder.f22834e;
            this.code = builder.code;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }
    }

    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);
}
