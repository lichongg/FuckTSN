package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JsonReader extends IReader<JSONObject> {
    /* JADX WARN: Type inference failed for: r0v0, types: [T, org.json.JSONObject] */
    @Override // com.umeng.socialize.net.dplus.cache1.IReader
    public void create(String str) {
        try {
            this.result = new JSONObject(str);
        } catch (JSONException e6) {
            SLog.error(e6);
        }
    }

    public JsonReader(String str) {
        super(str);
    }
}
