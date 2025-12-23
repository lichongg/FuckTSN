package xyz.adscope.ad.publish;

import xyz.adscope.ad.publish.loc.ASNPLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IASNPCustomController {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum UnderageTag {
        UNKNOWN(-1),
        ADULT(0),
        UNDERAGE(1);


        /* renamed from: a, reason: collision with root package name */
        private final int f55839a;

        public int getCode() {
            return this.f55839a;
        }

        UnderageTag(int i6) {
            this.f55839a = i6;
        }
    }

    public ASNPLocation getASNPLocation() {
        return null;
    }

    public boolean isCanGatherOAID() {
        return true;
    }

    public boolean isCanUpdateLocation() {
        return true;
    }

    public boolean isCanUseSensor() {
        return true;
    }

    public boolean isSupportPersonalized() {
        return true;
    }

    public String getGAID() {
        return "";
    }

    public String getOAID() {
        return "";
    }

    public UnderageTag getUnderageTag() {
        return UnderageTag.UNKNOWN;
    }
}
