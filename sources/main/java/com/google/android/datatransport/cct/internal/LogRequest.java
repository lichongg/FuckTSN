package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class LogRequest {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract LogRequest build();

        @NonNull
        public abstract Builder setClientInfo(@Nullable ClientInfo clientInfo);

        @NonNull
        public abstract Builder setLogEvents(@Nullable List<LogEvent> list);

        @NonNull
        abstract Builder setLogSource(@Nullable Integer num);

        @NonNull
        abstract Builder setLogSourceName(@Nullable String str);

        @NonNull
        public abstract Builder setQosTier(@Nullable QosTier qosTier);

        @NonNull
        public abstract Builder setRequestTimeMs(long j6);

        @NonNull
        public abstract Builder setRequestUptimeMs(long j6);

        @NonNull
        public Builder setSource(int i6) {
            return setLogSource(Integer.valueOf(i6));
        }

        @NonNull
        public Builder setSource(@NonNull String str) {
            return setLogSourceName(str);
        }
    }

    @Nullable
    public abstract ClientInfo getClientInfo();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<LogEvent> getLogEvents();

    @Nullable
    public abstract Integer getLogSource();

    @Nullable
    public abstract String getLogSourceName();

    @Nullable
    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();

    @NonNull
    public static Builder builder() {
        return new AutoValue_LogRequest.Builder();
    }
}
