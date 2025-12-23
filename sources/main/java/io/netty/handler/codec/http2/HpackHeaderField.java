package io.netty.handler.codec.http2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class HpackHeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HpackHeaderField)) {
            return false;
        }
        HpackHeaderField hpackHeaderField = (HpackHeaderField) obj;
        return (HpackUtil.equalsConstantTime(this.value, hpackHeaderField.value) & HpackUtil.equalsConstantTime(this.name, hpackHeaderField.name)) != 0;
    }

    final int size() {
        return this.name.length() + this.value.length() + 32;
    }

    public String toString() {
        return ((Object) this.name) + ": " + ((Object) this.value);
    }

    HpackHeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, CommonNetImpl.NAME);
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, "value");
    }

    static long sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() + charSequence2.length() + 32;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
