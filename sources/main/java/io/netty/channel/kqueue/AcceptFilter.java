package io.netty.channel.kqueue;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AcceptFilter {
    static final AcceptFilter PLATFORM_UNSUPPORTED = new AcceptFilter("", "");
    private final String filterArgs;
    private final String filterName;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AcceptFilter)) {
            return false;
        }
        AcceptFilter acceptFilter = (AcceptFilter) obj;
        return this.filterName.equals(acceptFilter.filterName) && this.filterArgs.equals(acceptFilter.filterArgs);
    }

    public String filterArgs() {
        return this.filterArgs;
    }

    public String filterName() {
        return this.filterName;
    }

    public int hashCode() {
        return ((this.filterName.hashCode() + 31) * 31) + this.filterArgs.hashCode();
    }

    public String toString() {
        return this.filterName + ", " + this.filterArgs;
    }

    public AcceptFilter(String str, String str2) {
        this.filterName = (String) ObjectUtil.checkNotNull(str, "filterName");
        this.filterArgs = (String) ObjectUtil.checkNotNull(str2, "filterArgs");
    }
}
