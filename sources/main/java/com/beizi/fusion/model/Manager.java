package com.beizi.fusion.model;

import com.beizi.fusion.model.JsonResolver;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Manager {

    @JsonNode(key = "adSpaces")
    private List<AdSpacesBean> adSpaces;

    @JsonNode(key = "configVersion")
    private String configVersion;

    @JsonNode(key = "init")
    private InitBean init;

    @JsonNode(key = "openSDKId")
    private String openSDKId;

    @JsonNode(key = "openSensor")
    private int openSensor;

    @JsonNode(key = "personalRecommend")
    private int personalRecommend;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class InitBean {

        @JsonNode(key = "workers")
        private List<String> workers;

        public static List<InitBean> arrayInitBeanFromData(String str) {
            try {
                return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<InitBean>>() { // from class: com.beizi.fusion.model.Manager.InitBean.1
                }.getType());
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }

        public static InitBean objectFromData(String str) {
            try {
                return (InitBean) JsonResolver.fromJson(str, InitBean.class);
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }

        public List<String> getWorkers() {
            return this.workers;
        }

        public void setWorkers(List<String> list) {
            this.workers = list;
        }

        public String toString() {
            return "InitBean{workers=" + this.workers + '}';
        }

        public static InitBean objectFromData(String str, String str2) {
            try {
                return (InitBean) JsonResolver.fromJson(new JSONObject(str).getString(str), InitBean.class);
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            } catch (Exception e7) {
                e7.printStackTrace();
                return null;
            }
        }

        public static List<InitBean> arrayInitBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<InitBean>>() { // from class: com.beizi.fusion.model.Manager.InitBean.2
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

    public static List<Manager> arrayManagerBeanFromData(String str) {
        try {
            return (List) JsonResolver.fromJson(str, new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.Manager.1
            }.getType());
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static Manager objectFromData(String str) {
        try {
            return (Manager) JsonResolver.fromJson(str, Manager.class);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public List<AdSpacesBean> getAdSpaces() {
        return this.adSpaces;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public InitBean getInit() {
        return this.init;
    }

    public String getOpenSDKId() {
        return this.openSDKId;
    }

    public int getOpenSensor() {
        return this.openSensor;
    }

    public int getPersonalRecommend() {
        return this.personalRecommend;
    }

    public void setAdSpaces(List<AdSpacesBean> list) {
        this.adSpaces = list;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setInit(InitBean initBean) {
        this.init = initBean;
    }

    public void setOpenSDKId(String str) {
        this.openSDKId = str;
    }

    public void setOpenSensor(int i6) {
        this.openSensor = i6;
    }

    public void setPersonalRecommend(int i6) {
        this.personalRecommend = i6;
    }

    public String toString() {
        return "Manager{configVersion='" + this.configVersion + "', init=" + this.init + ", adSpaces=" + this.adSpaces + '}';
    }

    public static Manager objectFromData(String str, String str2) {
        try {
            return (Manager) JsonResolver.fromJson(new JSONObject(str).getString(str), Manager.class);
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static List<Manager> arrayManagerBeanFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) JsonResolver.fromJson(jSONObject.getJSONArray(str2).toString(), new JsonResolver.TypeToken<ArrayList<Manager>>() { // from class: com.beizi.fusion.model.Manager.2
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
