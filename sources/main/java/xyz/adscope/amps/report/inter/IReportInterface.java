package xyz.adscope.amps.report.inter;

import java.util.List;
import xyz.adscope.amps.model.AMPSCycleModel;
import xyz.adscope.amps.report.model.request.AMPSReportRequestModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IReportInterface {
    void deleteLog(List<AMPSReportRequestModel> list);

    void reportAdLog(AMPSCycleModel aMPSCycleModel, String str);

    void reportInitLog(String str, String str2);

    void saveLog(AMPSReportRequestModel aMPSReportRequestModel);

    void uploadLog(AMPSReportRequestModel aMPSReportRequestModel);
}
