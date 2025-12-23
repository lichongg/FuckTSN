package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface DataEncoder {
    @NonNull
    String encode(@NonNull Object obj);

    void encode(@NonNull Object obj, @NonNull Writer writer) throws IOException;
}
