package xyz.adscope.amps.model.config.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SimilarStrategyModel {
    private String cacheTime;
    private int isOpen;
    private int isReport;
    private int similarity;

    public String getCacheTime() {
        return this.cacheTime;
    }

    public int getIsOpen() {
        return this.isOpen;
    }

    public int getIsReport() {
        return this.isReport;
    }

    public int getSimilarity() {
        return this.similarity;
    }

    public void setCacheTime(String str) {
        this.cacheTime = str;
    }

    public void setIsOpen(int i6) {
        this.isOpen = i6;
    }

    public void setIsReport(int i6) {
        this.isReport = i6;
    }

    public void setSimilarity(int i6) {
        this.similarity = i6;
    }

    public String toString() {
        return "{\"isOpen\":" + this.isOpen + ", \"cacheTime\":\"" + this.cacheTime + "\", \"similarity\":" + this.similarity + ", \"isReport\":" + this.isReport + "} ";
    }
}
