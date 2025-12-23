package cn.jpush.android.api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class InAppSlotParams {

    /* renamed from: a, reason: collision with root package name */
    public int f3494a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f3495b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f3496c = "";

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        InAppSlotParams f3497a = new InAppSlotParams();

        public InAppSlotParams build() {
            return this.f3497a;
        }

        public Builder setAdEvent(String str) {
            this.f3497a.f3496c = str;
            return this;
        }

        public Builder setAdSlot(String str) {
            this.f3497a.f3495b = str;
            return this;
        }

        public Builder setSequence(int i6) {
            this.f3497a.f3494a = i6;
            return this;
        }
    }

    public interface SLOT_KEY {
        public static final String EVENT = "event";
        public static final String SEQ = "sequence";
        public static final String SLOT = "slot";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static InAppSlotParams parseJSONString(String str) {
        InAppSlotParams inAppSlotParams = new InAppSlotParams();
        try {
            JSONObject jSONObject = new JSONObject(str);
            inAppSlotParams.f3494a = jSONObject.optInt(SLOT_KEY.SEQ, 0);
            inAppSlotParams.f3495b = jSONObject.optString(SLOT_KEY.SLOT, "");
            inAppSlotParams.f3496c = jSONObject.optString("event", "");
        } catch (Throwable unused) {
        }
        return inAppSlotParams;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SLOT_KEY.SEQ, this.f3494a);
            jSONObject.put(SLOT_KEY.SLOT, this.f3495b);
            jSONObject.put("event", this.f3496c);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "InAppSlotParams{sequence=" + this.f3494a + ", adSlot='" + this.f3495b + "', adEvent='" + this.f3496c + "'}";
    }
}
