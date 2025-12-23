package com.beizi.fusion.model;

import com.beizi.fusion.model.JsonResolver;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TaskConfig {

    @JsonNode(key = "checkInterval")
    private long checkInterval;

    @JsonNode(key = "configVersion")
    private String configVersion;

    @JsonNode(key = "id")
    private String id;

    @JsonNode(key = "job")
    private String job;

    @JsonNode(key = "url")
    private String url;

    @JsonNode(key = "version")
    private String version;

    public static List<TaskConfig> arrayTaskConfigFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskConfig.1
            }.getType());
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static TaskConfig objectFromData(String str) {
        try {
            return (TaskConfig) JsonResolver.fromJson(str, TaskConfig.class);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public String getId() {
        return this.id;
    }

    public String getJob() {
        return this.job;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCheckInterval(long j6) {
        this.checkInterval = j6;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setJob(String str) {
        this.job = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static TaskConfig objectFromData(String str, String str2) {
        try {
            return (TaskConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), TaskConfig.class);
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static List<TaskConfig> arrayTaskConfigFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.TaskConfig.2
            }.getType());
        } catch (JSONException e6) {
            e6.printStackTrace();
            return new ArrayList();
        } catch (Exception e7) {
            e7.printStackTrace();
            return new ArrayList();
        }
    }
}
