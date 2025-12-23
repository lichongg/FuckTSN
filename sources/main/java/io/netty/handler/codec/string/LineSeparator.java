package io.netty.handler.codec.string;

import com.snail.antifake.deviceid.e;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class LineSeparator {
    public static final LineSeparator DEFAULT = new LineSeparator(StringUtil.NEWLINE);
    public static final LineSeparator UNIX = new LineSeparator(e.f37542d);
    public static final LineSeparator WINDOWS = new LineSeparator(g.f50795q);
    private final String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineSeparator)) {
            return false;
        }
        String str = this.value;
        String str2 = ((LineSeparator) obj).value;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.value;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return ByteBufUtil.hexDump(this.value.getBytes(CharsetUtil.UTF_8));
    }

    public String value() {
        return this.value;
    }

    public LineSeparator(String str) {
        this.value = (String) ObjectUtil.checkNotNull(str, "lineSeparator");
    }
}
