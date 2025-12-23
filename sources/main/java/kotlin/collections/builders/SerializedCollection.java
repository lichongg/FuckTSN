package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SerializedCollection implements Externalizable {

    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @NotNull
    private Collection<?> collection;
    private final int tag;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public SerializedCollection(@NotNull Collection<?> collection, int i6) {
        g0.p(collection, "collection");
        this.collection = collection;
        this.tag = i6;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        List b6;
        g0.p(input, "input");
        byte readByte = input.readByte();
        int i6 = readByte & 1;
        if ((readByte & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        int i7 = 0;
        if (i6 == 0) {
            List k6 = f0.k(readInt);
            while (i7 < readInt) {
                k6.add(input.readObject());
                i7++;
            }
            b6 = f0.b(k6);
        } else {
            if (i6 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i6 + '.');
            }
            Set e6 = u1.e(readInt);
            while (i7 < readInt) {
                e6.add(input.readObject());
                i7++;
            }
            b6 = u1.a(e6);
        }
        this.collection = b6;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        g0.p(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public SerializedCollection() {
        this(f0.J(), 0);
    }
}
