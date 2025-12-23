package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i6, String str, String str2, String str3);

    void visitIincInsn(int i6, int i7);

    void visitInsn(int i6);

    void visitIntInsn(int i6, int i7);

    void visitJumpInsn(int i6, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i6, int i7);

    void visitMethodInsn(int i6, String str, String str2, String str3);

    void visitTypeInsn(int i6, String str);

    void visitVarInsn(int i6, int i7);
}
