package com.kwad.sdk.pngencrypt.chunk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class p extends PngChunk {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.aoB;
        if (str == null) {
            if (pVar.aoB != null) {
                return false;
            }
        } else if (!str.equals(pVar.aoB)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.aoB;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    protected p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }
}
