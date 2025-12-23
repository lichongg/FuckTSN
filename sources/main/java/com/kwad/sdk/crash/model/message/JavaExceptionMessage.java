package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class JavaExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -2410125079234148135L;

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected String getTypePrefix() {
        return "";
    }

    public JavaExceptionMessage() {
        this.mExceptionType = 1;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }
}
