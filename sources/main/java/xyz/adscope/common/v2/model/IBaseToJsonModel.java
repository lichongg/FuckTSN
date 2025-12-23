package xyz.adscope.common.v2.model;

import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IBaseToJsonModel implements IJsonMappingModel {
    protected String parseToJsonString() {
        return JsonUtil.entry2JsonString(this);
    }

    @Override // xyz.adscope.common.v2.model.IJsonMappingModel
    public String toJsonString() {
        return parseToJsonString();
    }
}
