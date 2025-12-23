package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class LogResponse {
    private static final String LOG_TAG = "LogResponseInternal";

    public abstract long getNextRequestWaitMillis();

    static LogResponse create(long j6) {
        return new AutoValue_LogResponse(j6);
    }

    @NonNull
    public static LogResponse fromJson(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? create(Long.parseLong(jsonReader.nextString())) : create(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }
}
