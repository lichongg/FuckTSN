package com.scwang.smartrefresh.layout.constant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);

    public final boolean notifyed;

    public DimensionStatus notifyed() {
        return !this.notifyed ? values()[ordinal() + 1] : this;
    }

    public DimensionStatus unNotify() {
        if (!this.notifyed) {
            return this;
        }
        DimensionStatus dimensionStatus = values()[ordinal() - 1];
        return !dimensionStatus.notifyed ? dimensionStatus : DefaultUnNotify;
    }

    DimensionStatus(boolean z5) {
        this.notifyed = z5;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        if (ordinal() >= dimensionStatus.ordinal()) {
            if ((this.notifyed && CodeExact != this) || ordinal() != dimensionStatus.ordinal()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean gteReplaceWith(DimensionStatus dimensionStatus) {
        if (ordinal() >= dimensionStatus.ordinal()) {
            return true;
        }
        return false;
    }
}
