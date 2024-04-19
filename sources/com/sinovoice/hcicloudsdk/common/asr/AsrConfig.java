package com.sinovoice.hcicloudsdk.common.asr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class AsrConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class AudioConfig {
        public static final String PARAM_KEY_AUDIO_FORMAT = "audioFormat";
        public static final String PARAM_KEY_ENCODE = "encode";
        public static final String PARAM_KEY_ENCODE_LEVEL = "enclevel";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ALAW_16K8BIT = "alaw16k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ALAW_8K8BIT = "alaw8k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_16K16BIT = "pcm16k16bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_8K16BIT = "pcm8k16bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ULAW_16K8BIT = "ulaw16k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ULAW_8K8BIT = "ulaw8k8bit";
        public static final String VALUE_OF_PARAM_ENCODE_ALAW = "alaw";
        public static final String VALUE_OF_PARAM_ENCODE_NONE = "none";
        public static final String VALUE_OF_PARAM_ENCODE_OPUS = "opus";
        public static final String VALUE_OF_PARAM_ENCODE_SPEEX = "speex";
        public static final String VALUE_OF_PARAM_ENCODE_ULAW = "ulaw";
    }

    /* loaded from: classes.dex */
    public static final class GrammarConfig {
        public static final String PARAM_KEY_GRAMMAR_ID = "grammarId";
        public static final String PARAM_KEY_GRAMMAR_TYPE = "grammarType";
        public static final String PARAM_KEY_IS_FILE = "isFile";
        public static final String VALUE_OF_PARAM_GRAMMAR_TYPE_ID = "id";
        public static final String VALUE_OF_PARAM_GRAMMAR_TYPE_JSGF = "jsgf";
        public static final String VALUE_OF_PARAM_GRAMMAR_TYPE_WORD_LIST = "wordlist";
    }

    /* loaded from: classes.dex */
    public static final class ResultConfig {
        public static final String PARAM_KEY_ADD_PUNC = "addPunc";
        public static final String PARAM_KEY_CAND_NUM = "candNum";
        public static final String PARAM_KEY_DOMAIN = "domain";
        public static final String PARAM_KEY_INTENTION = "intention";
        public static final String PARAM_KEY_NEED_CONTENT = "needContent";
        public static final String PARAM_KEY_PROPERTY = "property";
    }

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
        public static final String PARAM_KEY_DIALOG_MODE = "dialogMode ";
        public static final String PARAM_KEY_INTENTION = "intention";
        public static final String PARAM_KEY_MAX_SECONDS = "maxSeconds";
        public static final String PARAM_KEY_NET_TIMEOUT = "netTimeout ";
        public static final String PARAM_KEY_REALTIME = "realtime";
        public static final String PARAM_KEY_RES_PREFIX = "resPrefix";
    }

    /* loaded from: classes.dex */
    public static final class VadConfig {
        public static final String PARAM_KEY_VAD_HEAD = "vadHead";
        public static final String PARAM_KEY_VAD_SEG = "vadseg";
        public static final String PARAM_KEY_VAD_SWITCH = "vadSwitch";
        public static final String PARAM_KEY_VAD_TAIL = "vadTail";
        public static final String PARAM_KEY_VAD_THRESHOLD = "vadThreshold";
    }
}
