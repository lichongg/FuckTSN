package com.scwang.smartrefresh.layout.constant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum RefreshState {
    None(0, false),
    PullDownToRefresh(1, true),
    PullToUpLoad(2, true),
    PullDownCanceled(1, false),
    PullUpCanceled(2, false),
    ReleaseToRefresh(1, true),
    ReleaseToLoad(2, true),
    ReleaseToTwoLevel(1, true),
    TwoLevelReleased(1, false),
    RefreshReleased(1, false),
    LoadReleased(2, false),
    Refreshing(1, false, true),
    Loading(2, false, true),
    TwoLevel(1, false, true),
    RefreshFinish(1, false),
    LoadFinish(2, false),
    TwoLevelFinish(1, false);

    public final boolean draging;
    public final boolean opening;
    private final int role;

    RefreshState(int i6, boolean z5) {
        this.role = i6;
        this.draging = z5;
        this.opening = false;
    }

    public boolean isFooter() {
        return this.role == 2;
    }

    public boolean isHeader() {
        return this.role == 1;
    }

    RefreshState(int i6, boolean z5, boolean z6) {
        this.role = i6;
        this.draging = z5;
        this.opening = z6;
    }
}
