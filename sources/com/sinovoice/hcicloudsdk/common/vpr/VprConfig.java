package com.sinovoice.hcicloudsdk.common.vpr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class VprConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class AudioConfig {
        public static final String PARAM_KEY_ACTION_TYPE = "actionType";
        public static final String PARAM_KEY_AUDIO_FORMAT = "audioFormat";
        public static final String PARAM_KEY_ENCODE = "encode";
        public static final String PARAM_KEY_ENCODE_LEVEL = "enclevel";
        public static final String PARAM_KEY_IDENTIFY = "identify";
        public static final String PARAM_KEY_INDEX = "index";
        public static final String PARAM_KEY_PROPERTY = "property";
        public static final String PARAM_KEY_VAD_HEAD = "vadhead";
        public static final String PARAM_KEY_VAD_SEG = "vadseg";
        public static final String PARAM_KEY_VAD_SWITCH = "vadswitch";
        public static final String PARAM_KEY_VAD_TAIL = "vadtail";
        public static final String PARAM_KEY_VAD_THRESHOLD = "vadthreshold";
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
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
        public static final String PARAM_KEY_RES_PREFIX = "resprefix";
        public static final String PARAM_KEY_USER_MODEL_PATH = "usermodelpath";
    }

    /* loaded from: classes.dex */
    public static final class UserConfig {
        public static final String PARAM_KEY_GROUP_ID = "groupid";
        public static final String PARAM_KEY_USER_ID = "userId";
        public static final String PARM_KEY_REAL_TIME = "realtime";
    }
}
