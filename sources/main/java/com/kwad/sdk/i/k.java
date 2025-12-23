package com.kwad.sdk.i;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class k implements b {
    public JSONObject aTd = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.aTd;
    }

    @NonNull
    public final String toString() {
        return this.aTd.toString();
    }

    public k(String str, String str2, i iVar) {
        JSONObject MZ = h.Nd().Nh().MZ();
        Iterator<String> keys = MZ.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c.a(MZ, next, MZ.opt(next));
        }
        c.putValue(this.aTd, "customKey", str);
        c.putValue(this.aTd, "customValue", str2);
        c.putValue(this.aTd, "timestamp", iVar.aTa);
        c.putValue(this.aTd, "actionId", this.actionId);
    }
}
