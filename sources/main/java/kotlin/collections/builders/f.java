package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f implements Externalizable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f43625b = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private Map<?, ?> f43626a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public f(@NotNull Map<?, ?> map) {
        g0.p(map, "map");
        this.f43626a = map;
    }

    private final Object readResolve() {
        return this.f43626a;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        g0.p(input, "input");
        byte readByte = input.readByte();
        if (readByte != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        Map h6 = i1.h(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            h6.put(input.readObject(), input.readObject());
        }
        this.f43626a = i1.d(h6);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        g0.p(output, "output");
        output.writeByte(0);
        output.writeInt(this.f43626a.size());
        for (Map.Entry<?, ?> entry : this.f43626a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public f() {
        this(i1.z());
    }
}
