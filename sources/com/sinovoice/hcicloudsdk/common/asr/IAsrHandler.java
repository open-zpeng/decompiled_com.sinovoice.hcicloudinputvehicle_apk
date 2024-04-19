package com.sinovoice.hcicloudsdk.common.asr;
/* loaded from: classes.dex */
public interface IAsrHandler {
    public static final int CANCELLED = 1;
    public static final int END_OF_INPUT = 0;
    public static final int END_OF_VOICE = 4;
    public static final int ERROR = 2;
    public static final int EXCEPTION = 5;
    public static final int NO_VOICE_INPUT = 3;

    /* loaded from: classes.dex */
    public static class Skeleton implements IAsrHandler {
        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public boolean onEndOfVoice(AsrCommon asrCommon) {
            return false;
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onError(AsrCommon asrCommon, String str, int i) {
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onException(AsrCommon asrCommon, Exception exc) {
            exc.printStackTrace();
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onFinish(AsrCommon asrCommon, int i) {
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public boolean onNoVoiceInput(AsrCommon asrCommon, int i) {
            return false;
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onResult(AsrCommon asrCommon, AsrResult asrResult) {
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onStart(AsrCommon asrCommon) {
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onVoiceBegin(AsrCommon asrCommon) {
        }

        @Override // com.sinovoice.hcicloudsdk.common.asr.IAsrHandler
        public void onVoiceEnd(AsrCommon asrCommon) {
        }
    }

    boolean onEndOfVoice(AsrCommon asrCommon);

    void onError(AsrCommon asrCommon, String str, int i);

    void onException(AsrCommon asrCommon, Exception exc);

    void onFinish(AsrCommon asrCommon, int i);

    boolean onNoVoiceInput(AsrCommon asrCommon, int i);

    void onResult(AsrCommon asrCommon, AsrResult asrResult);

    void onStart(AsrCommon asrCommon);

    void onVoiceBegin(AsrCommon asrCommon);

    void onVoiceEnd(AsrCommon asrCommon);
}
