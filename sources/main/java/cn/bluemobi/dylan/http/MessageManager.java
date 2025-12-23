package cn.bluemobi.dylan.http;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MessageManager {
    private static volatile MessageManager messageManager;
    private boolean useEnglishLanguage = false;
    private MessageModel showMessageModel = MessageModel.OTHER_STATUS;
    private String errorMessage = "网络繁忙";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum MessageModel {
        All,
        OTHER_STATUS,
        NO
    }

    public static MessageManager getMessageManager() {
        if (messageManager == null) {
            synchronized (MessageManager.class) {
                try {
                    if (messageManager == null) {
                        messageManager = new MessageManager();
                    }
                } finally {
                }
            }
        }
        return messageManager;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public MessageModel getShowMessageModel() {
        return this.showMessageModel;
    }

    public boolean isUseEnglishLanguage() {
        return this.useEnglishLanguage;
    }

    public MessageManager setErrorMessage(String str) {
        this.errorMessage = str;
        return this;
    }

    public MessageManager setShowMessageModel(MessageModel messageModel) {
        this.showMessageModel = messageModel;
        return messageManager;
    }

    public MessageManager setUseEnglishLanguage(boolean z5) {
        this.useEnglishLanguage = z5;
        return messageManager;
    }

    private MessageManager() {
    }
}
