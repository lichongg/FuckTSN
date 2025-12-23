package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.tool.utils.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LogEventModel {
    private List<String> codes;
    private String count;
    private List<String> level;
    private String sample;
    private String time;
    private String uploadUrl;

    public List<String> getCodes() {
        return this.codes;
    }

    public String getCount() {
        return this.count;
    }

    public List<String> getLevel() {
        return this.level;
    }

    public String getSample() {
        return this.sample;
    }

    public String getTime() {
        return this.time;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void setCodes(List<String> list) {
        this.codes = list;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setLevel(List<String> list) {
        this.level = list;
    }

    public void setSample(String str) {
        this.sample = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
    }

    public String toString() {
        return "{\"codes\":" + StringUtil.ListToString(this.codes) + ", \"level\":" + StringUtil.ListToString(this.level) + ", \"uploadUrl\":\"" + this.uploadUrl + "\", \"count\":\"" + this.count + "\", \"time\":\"" + this.time + "\", \"sample\":\"" + this.sample + "\"}";
    }
}
