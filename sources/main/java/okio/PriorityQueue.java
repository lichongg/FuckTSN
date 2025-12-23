package okio;

import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/PriorityQueue\n*L\n1#1,504:1\n499#1,3:505\n499#1,3:508\n499#1,3:511\n499#1,3:514\n*S KotlinDebug\n*F\n+ 1 AsyncTimeout.kt\nokio/PriorityQueue\n*L\n408#1:505,3\n441#1:508,3\n474#1:511,3\n484#1:514,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PriorityQueue {

    @JvmField
    @NotNull
    public AsyncTimeout[] array = new AsyncTimeout[8];

    @JvmField
    public int size;

    private final int compareTo(AsyncTimeout asyncTimeout, AsyncTimeout asyncTimeout2) {
        g0.p(asyncTimeout, "<this>");
        return g0.u(0L, asyncTimeout2.timeoutNanos() - asyncTimeout.timeoutNanos());
    }

    private final void heapifyDown(int i6, AsyncTimeout asyncTimeout) {
        AsyncTimeout asyncTimeout2;
        while (true) {
            int i7 = i6 << 1;
            int i8 = i7 + 1;
            int i9 = this.size;
            if (i8 > i9) {
                if (i7 > i9) {
                    break;
                }
                asyncTimeout2 = this.array[i7];
                g0.m(asyncTimeout2);
            } else {
                asyncTimeout2 = this.array[i7];
                g0.m(asyncTimeout2);
                AsyncTimeout asyncTimeout3 = this.array[i8];
                g0.m(asyncTimeout3);
                if (g0.u(0L, asyncTimeout3.timeoutNanos() - asyncTimeout2.timeoutNanos()) >= 0) {
                    asyncTimeout2 = asyncTimeout3;
                }
            }
            if (g0.u(0L, asyncTimeout2.timeoutNanos() - asyncTimeout.timeoutNanos()) <= 0) {
                break;
            }
            int i10 = asyncTimeout2.index;
            asyncTimeout2.index = i6;
            this.array[i6] = asyncTimeout2;
            i6 = i10;
        }
        this.array[i6] = asyncTimeout;
        asyncTimeout.index = i6;
    }

    private final void heapifyUp(int i6, AsyncTimeout asyncTimeout) {
        while (true) {
            int i7 = i6 >> 1;
            if (i7 == 0) {
                break;
            }
            AsyncTimeout asyncTimeout2 = this.array[i7];
            g0.m(asyncTimeout2);
            if (g0.u(0L, asyncTimeout.timeoutNanos() - asyncTimeout2.timeoutNanos()) <= 0) {
                break;
            }
            asyncTimeout2.index = i6;
            this.array[i6] = asyncTimeout2;
            i6 = i7;
        }
        this.array[i6] = asyncTimeout;
        asyncTimeout.index = i6;
    }

    public final void add(@NotNull AsyncTimeout node) {
        g0.p(node, "node");
        int i6 = this.size + 1;
        this.size = i6;
        AsyncTimeout[] asyncTimeoutArr = this.array;
        if (i6 == asyncTimeoutArr.length) {
            AsyncTimeout[] asyncTimeoutArr2 = new AsyncTimeout[i6 * 2];
            n.K0(asyncTimeoutArr, asyncTimeoutArr2, 0, 0, 0, 14, null);
            this.array = asyncTimeoutArr2;
        }
        heapifyUp(i6, node);
    }

    @Nullable
    public final AsyncTimeout first() {
        return this.array[1];
    }

    public final void remove(@NotNull AsyncTimeout node) {
        g0.p(node, "node");
        int i6 = node.index;
        if (i6 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i7 = this.size;
        AsyncTimeout asyncTimeout = this.array[i7];
        g0.m(asyncTimeout);
        node.index = -1;
        this.array[i7] = null;
        this.size = i7 - 1;
        if (node == asyncTimeout) {
            return;
        }
        int u5 = g0.u(0L, asyncTimeout.timeoutNanos() - node.timeoutNanos());
        if (u5 == 0) {
            this.array[i6] = asyncTimeout;
            asyncTimeout.index = i6;
        } else if (u5 < 0) {
            heapifyDown(i6, asyncTimeout);
        } else {
            heapifyUp(i6, asyncTimeout);
        }
    }
}
