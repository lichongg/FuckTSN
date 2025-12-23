package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public int pid() {
        return this.pid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("UserCredentials[pid=");
        sb.append(this.pid);
        sb.append("; uid=");
        sb.append(this.uid);
        sb.append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sb.append(iArr[0]);
            for (int i6 = 1; i6 < this.gids.length; i6++) {
                sb.append(", ");
                sb.append(this.gids[i6]);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public int uid() {
        return this.uid;
    }

    PeerCredentials(int i6, int i7, int... iArr) {
        this.pid = i6;
        this.uid = i7;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }
}
