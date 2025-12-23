package xyz.adscope.amps.model.config.response;

import xyz.adscope.amps.model.inter.IDeepCopyModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FrequencyModel implements IDeepCopyModel<FrequencyModel> {
    private int count;
    private String event;
    private long time;

    public FrequencyModel() {
        this.event = "";
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public FrequencyModel deepCopy() {
        return new FrequencyModel(this);
    }

    public int getCount() {
        return this.count;
    }

    public String getEvent() {
        return this.event;
    }

    public long getTime() {
        return this.time;
    }

    public void setCount(int i6) {
        this.count = i6;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setTime(long j6) {
        this.time = j6;
    }

    public String toString() {
        return "{\"time\":" + this.time + ", \"event\":\"" + this.event + "\", \"count\":" + this.count + '}';
    }

    private FrequencyModel(FrequencyModel frequencyModel) {
        this.event = "";
        this.time = frequencyModel.getTime();
        this.event = frequencyModel.getEvent();
        this.count = frequencyModel.getCount();
    }
}
