package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AvailableProcessorsHolder {
        private int availableProcessors;

        @SuppressForbidden(reason = "to obtain default number of available processors")
        synchronized int availableProcessors() {
            try {
                if (this.availableProcessors == 0) {
                    setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.availableProcessors;
        }

        synchronized void setAvailableProcessors(int i6) {
            ObjectUtil.checkPositive(i6, "availableProcessors");
            int i7 = this.availableProcessors;
            if (i7 != 0) {
                throw new IllegalStateException(String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", Integer.valueOf(i7), Integer.valueOf(i6)));
            }
            this.availableProcessors = i6;
        }

        AvailableProcessorsHolder() {
        }
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    public static void setAvailableProcessors(int i6) {
        holder.setAvailableProcessors(i6);
    }

    private NettyRuntime() {
    }
}
