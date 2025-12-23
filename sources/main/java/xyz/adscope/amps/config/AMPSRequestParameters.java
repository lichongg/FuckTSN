package xyz.adscope.amps.config;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSRequestParameters {
    private int adCount;
    private Map<String, Object> customExtraParameters;
    private String extraData;
    private int height;
    private String jsonObject;
    private String loadType;
    private String spaceId;
    private int timeOut;
    private String userId;
    private int width;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private Map<String, Object> customExtraParameters;
        private String extraData;
        private int height;
        private String spaceId;
        private String userId;
        private int width;
        private int timeOut = 5000;
        private int adCount = 1;

        public AMPSRequestParameters build() {
            AMPSRequestParameters aMPSRequestParameters = new AMPSRequestParameters();
            aMPSRequestParameters.setSpaceId(this.spaceId);
            aMPSRequestParameters.setWidth(this.width);
            aMPSRequestParameters.setHeight(this.height);
            aMPSRequestParameters.setUserId(this.userId);
            aMPSRequestParameters.setExtraData(this.extraData);
            aMPSRequestParameters.setTimeOut(this.timeOut);
            aMPSRequestParameters.setAdCount(this.adCount);
            aMPSRequestParameters.setCustomExtraParameters(this.customExtraParameters);
            return aMPSRequestParameters;
        }

        public Builder setAdCount(int i6) {
            this.adCount = i6;
            return this;
        }

        public Builder setCustomExtraParameters(Map<String, Object> map) {
            this.customExtraParameters = map;
            return this;
        }

        public Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public Builder setHeight(int i6) {
            this.height = i6;
            return this;
        }

        public Builder setSpaceId(String str) {
            this.spaceId = str;
            return this;
        }

        public Builder setTimeOut(int i6) {
            this.timeOut = i6;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setWidth(int i6) {
            this.width = i6;
            return this;
        }
    }

    public int getAdCount() {
        return this.adCount;
    }

    public Map<String, Object> getCustomExtraParameters() {
        return this.customExtraParameters;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public int getHeight() {
        return this.height;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public String getLoadType() {
        return this.loadType;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAdCount(int i6) {
        this.adCount = i6;
    }

    public void setCustomExtraParameters(Map<String, Object> map) {
        this.customExtraParameters = map;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setHeight(int i6) {
        this.height = i6;
    }

    public void setJsonObject(String str) {
        this.jsonObject = str;
    }

    public void setLoadType(String str) {
        this.loadType = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setTimeOut(int i6) {
        this.timeOut = i6;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWidth(int i6) {
        this.width = i6;
    }
}
