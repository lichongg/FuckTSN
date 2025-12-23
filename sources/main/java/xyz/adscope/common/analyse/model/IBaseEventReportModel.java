package xyz.adscope.common.analyse.model;

import xyz.adscope.common.v2.model.IBaseEventModel;
import xyz.adscope.common.v2.model.IBaseMacrosMappingModel;
import xyz.adscope.common.v2.model.IDeepCopyModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseEventReportModel extends IBaseMacrosMappingModel implements IDeepCopyModel, IBaseEventModel {
    protected final IStringEventEnum event;

    @Override // xyz.adscope.common.v2.model.IBaseEventModel
    public String getEventCode() {
        IStringEventEnum iStringEventEnum = this.event;
        return iStringEventEnum != null ? iStringEventEnum.getEventCode() : "";
    }

    public IBaseEventReportModel(IStringEventEnum iStringEventEnum) {
        this.event = iStringEventEnum;
    }
}
