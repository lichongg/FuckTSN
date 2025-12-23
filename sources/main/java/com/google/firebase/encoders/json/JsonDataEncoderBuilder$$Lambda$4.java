package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class JsonDataEncoderBuilder$$Lambda$4 implements ValueEncoder {
    private static final JsonDataEncoderBuilder$$Lambda$4 instance = new JsonDataEncoderBuilder$$Lambda$4();

    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ValueEncoderContext valueEncoderContext) {
        valueEncoderContext.add((String) obj);
    }

    private JsonDataEncoderBuilder$$Lambda$4() {
    }
}
