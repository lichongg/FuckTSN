package xyz.adscope.amps.model.config.response;

import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.model.inter.IDeepCopyModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FilterModel implements IDeepCopyModel<FilterModel> {
    private List<FrequencyModel> frequency;
    private long minLoadTime;

    public FilterModel() {
    }

    private FilterModel(FilterModel filterModel) {
        this.minLoadTime = filterModel.getMinLoadTime();
        this.frequency = deepCopyFrequencyList(filterModel.getFrequency());
    }

    private List<FrequencyModel> deepCopyFrequencyList(List<FrequencyModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrequencyModel frequencyModel : list) {
            if (frequencyModel != null) {
                arrayList.add(frequencyModel.deepCopy());
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public FilterModel deepCopy() {
        return new FilterModel(this);
    }

    public List<FrequencyModel> getFrequency() {
        return this.frequency;
    }

    public long getMinLoadTime() {
        return this.minLoadTime;
    }

    public void setFrequency(List<FrequencyModel> list) {
        this.frequency = list;
    }

    public void setMinLoadTime(long j6) {
        this.minLoadTime = j6;
    }

    public String toString() {
        return "{\"minLoadTime\":" + this.minLoadTime + ", \"frequency\":" + this.frequency + '}';
    }
}
