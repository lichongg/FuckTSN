package xyz.adscope.amps.model.config.response;

import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.model.inter.IDeepCopyModel;
import xyz.adscope.common.tool.utils.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdSourceNoticeRuleModel implements IDeepCopyModel<AdSourceNoticeRuleModel> {
    private String add;
    private List<String> priceGapScope;
    private String random;
    private String subtract;

    public AdSourceNoticeRuleModel() {
    }

    private AdSourceNoticeRuleModel(AdSourceNoticeRuleModel adSourceNoticeRuleModel) {
        this.add = adSourceNoticeRuleModel.getAdd();
        this.subtract = adSourceNoticeRuleModel.getSubtract();
        this.random = adSourceNoticeRuleModel.getRandom();
        this.priceGapScope = deepCopyPriceGapScopeList(adSourceNoticeRuleModel.getPriceGapScope());
    }

    private List<String> deepCopyPriceGapScopeList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public AdSourceNoticeRuleModel deepCopy() {
        return new AdSourceNoticeRuleModel(this);
    }

    public String getAdd() {
        return this.add;
    }

    public List<String> getPriceGapScope() {
        return this.priceGapScope;
    }

    public String getRandom() {
        return this.random;
    }

    public String getSubtract() {
        return this.subtract;
    }

    public void setAdd(String str) {
        this.add = str;
    }

    public void setPriceGapScope(List<String> list) {
        this.priceGapScope = list;
    }

    public void setRandom(String str) {
        this.random = str;
    }

    public void setSubtract(String str) {
        this.subtract = str;
    }

    public String toString() {
        return "{\"add\":\"" + this.add + "\", \"subtract\":\"" + this.subtract + "\", \"random\":\"" + this.random + "\", \"priceGapScope\":" + StringUtil.ListToString(this.priceGapScope) + '}';
    }
}
