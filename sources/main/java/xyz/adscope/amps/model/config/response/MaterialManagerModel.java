package xyz.adscope.amps.model.config.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class MaterialManagerModel {
    private int imageCount;
    private String maxSize;
    private String minSize;
    private int random;
    private SimilarStrategyModel similarStrategy;
    private String url;
    private String waitTime;

    public int getImageCount() {
        return this.imageCount;
    }

    public String getMaxSize() {
        return this.maxSize;
    }

    public String getMinSize() {
        return this.minSize;
    }

    public int getRandom() {
        return this.random;
    }

    public SimilarStrategyModel getSimilarStrategy() {
        return this.similarStrategy;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWaitTime() {
        return this.waitTime;
    }

    public void setImageCount(int i6) {
        this.imageCount = i6;
    }

    public void setMaxSize(String str) {
        this.maxSize = str;
    }

    public void setMinSize(String str) {
        this.minSize = str;
    }

    public void setRandom(int i6) {
        this.random = i6;
    }

    public void setSimilarStrategy(SimilarStrategyModel similarStrategyModel) {
        this.similarStrategy = similarStrategyModel;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWaitTime(String str) {
        this.waitTime = str;
    }

    public String toString() {
        return "{\"url\":\"" + this.url + "\", \"random\":" + this.random + ", \"imageCount\":" + this.imageCount + ", \"waitTime\":\"" + this.waitTime + "\", \"maxSize\":\"" + this.maxSize + "\", \"minSize\":\"" + this.minSize + "\", \"similarStrategy\":" + this.similarStrategy + "} ";
    }
}
