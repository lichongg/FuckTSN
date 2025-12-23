package xyz.adscope.amps.control.filter.inter;

import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IFilterInterface {
    void addFilterEvent(AMPSFrequencyEventModel aMPSFrequencyEventModel);

    boolean channelFilter(AdSourceModel adSourceModel);

    boolean platformFilter();
}
