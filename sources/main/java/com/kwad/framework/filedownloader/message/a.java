package com.kwad.framework.filedownloader.message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C0660a extends MessageSnapshot implements a {
        private final MessageSnapshot aoE;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot yL() {
            return this.aoE;
        }

        public C0660a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.wJ() == -3) {
                this.aoE = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ())));
        }
    }

    MessageSnapshot yL();
}
