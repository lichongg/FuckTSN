package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.tool.utils.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BlackRuleModel {
    private List<String> blackList;

    public List<String> getBlackList() {
        return this.blackList;
    }

    public void setBlackList(List<String> list) {
        this.blackList = list;
    }

    public String toString() {
        return "{\"blackList\":" + StringUtil.ListToString(this.blackList) + '}';
    }
}
