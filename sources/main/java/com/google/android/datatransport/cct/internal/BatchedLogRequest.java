package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@Encodable
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BatchedLogRequest {
    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<LogRequest> getLogRequests();

    @NonNull
    public static BatchedLogRequest create(@NonNull List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    @NonNull
    public static DataEncoder createDataEncoder() {
        return new JsonDataEncoderBuilder().configureWith(AutoBatchedLogRequestEncoder.CONFIG).ignoreNullValues(true).build();
    }
}
