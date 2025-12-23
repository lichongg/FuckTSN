package xyz.adscope.amps.model.config.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SortAdSourceModel {
    private AdSourceModel adSourceModel;
    private int ecpm;
    private boolean isCandidate;
    private boolean isHitWeight;

    public AdSourceModel getAdSourceModel() {
        return this.adSourceModel;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public boolean isCandidate() {
        return this.isCandidate;
    }

    public boolean isHitWeight() {
        return this.isHitWeight;
    }

    public void setAdSourceModel(AdSourceModel adSourceModel) {
        this.adSourceModel = adSourceModel;
    }

    public void setCandidate(boolean z5) {
        this.isCandidate = z5;
    }

    public void setEcpm(int i6) {
        this.ecpm = i6;
    }

    public void setHitWeight(boolean z5) {
        this.isHitWeight = z5;
    }

    public SortAdSourceModel(AdSourceModel adSourceModel, int i6, boolean z5) {
        this.adSourceModel = adSourceModel;
        this.ecpm = i6;
        this.isHitWeight = adSourceModel.isHitWeight();
        this.isCandidate = z5;
    }
}
