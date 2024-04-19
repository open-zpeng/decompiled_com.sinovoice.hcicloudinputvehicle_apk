package com.sinovoice.hcicloudsdk.common.tts;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class TtsConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class BasicConfig {
        public static final String PARAM_KEY_AUDIO_FORMAT = "audioFormat";
        public static final String PARAM_KEY_DIGIT_MODE = "digitMode";
        public static final String PARAM_KEY_ENG_MODE = "engMode";
        public static final String PARAM_KEY_INTERVAL = "interval";
        public static final String PARAM_KEY_PITCH = "pitch";
        public static final String PARAM_KEY_PUNC_MODE = "puncMode";
        public static final String PARAM_KEY_SPEED = "speed";
        public static final String PARAM_KEY_TAG_MODE = "tagmode";
        public static final String PARAM_KEY_TEMPO = "tempo";
        public static final String PARAM_KEY_VOLUME = "volume";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ALAW_16K8BIT = "alaw16k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ALAW_8K8BIT = "alaw8k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_AUTO = "auto";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_MP3 = "mp3";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_11K16BIT = "pcm11k16bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_11K8BIT = "pcm11k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_16K16BIT = "pcm16k16bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_16K8BIT = "pcm16k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_8K16BIT = "pcm8k16bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_PCM_8K8BIT = "pcm8k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ULAW_16K8BIT = "ulaw16k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_ULAW_8K8BIT = "ulaw8k8bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_VOX_6K4BIT = "vox6k4bit";
        public static final String VALUE_OF_PARAM_AUDIO_FORMAT_VOX_8K4BIT = "vox8k4bit";
        public static final String VALUE_OF_PARAM_DIGIT_MODE_AUTO_NUMBER = "auto_number";
        public static final String VALUE_OF_PARAM_DIGIT_MODE_AUTO_TELEGRAM = "auto_telegram";
        public static final String VALUE_OF_PARAM_DIGIT_MODE_NUMBER = "number";
        public static final String VALUE_OF_PARAM_DIGIT_MODE_TELEGRAM = "telegram";
        public static final String VALUE_OF_PARAM_ENG_MODE_AUTO = "auto";
        public static final String VALUE_OF_PARAM_ENG_MODE_ENGLISH = "english";
        public static final String VALUE_OF_PARAM_ENG_MODE_LETTER = "letter";
        public static final String VALUE_OF_PARAM_PUNC_MODE_OFF = "off";
        public static final String VALUE_OF_PARAM_PUNC_MODE_OFF_RTN = "off_rtn";
        public static final String VALUE_OF_PARAM_PUNC_MODE_ON = "on";
        public static final String VALUE_OF_PARAM_PUNC_MODE_ON_RTN = "on_rtn";
    }

    /* loaded from: classes.dex */
    public static final class EncodeConfig {
        public static final String PARAM_KEY_ENCLEVEL = "enclevel";
        public static final String PARAM_KEY_ENCODE = "encode";
        public static final String VALUE_OF_PARAM_ENCODE_NONE = "none";
        public static final String VALUE_OF_PARAM_ENCODE_OPUS = "opus";
        public static final String VALUE_OF_PARAM_ENCODE_SPEEX = "speex";
    }

    /* loaded from: classes.dex */
    public static final class LocalAdavanceConfig {
        public static final String PARAM_KEY_MIX_SOUND = "mixSound";
        public static final String PARAM_KEY_NAME_POLY_PHONE = "namePolyphone";
        public static final String PARAM_KEY_SOUND_EFFECT = "soundEffect";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_BASE = "base";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_CHORUS = "chorus";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_ECHO = "echo";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_NEARFAR = "nearfar";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_REVERB = "reverb";
        public static final String VALUE_OF_PARAM_SOUND_EFFECT_ROBOT = "robot";
    }

    /* loaded from: classes.dex */
    public static final class LocalV5AdavanceConfig {
        public static final String PARAM_KEY_SILENCE_MODE = "silenceMode";
        public static final String PARAM_KEY_SPEED_MODE = "speedMode";
    }

    /* loaded from: classes.dex */
    public static final class LocalV6AdavanceConfig {
        public static final String PARAM_KEY_GAIN_FACTOR = "gainFactor";
        public static final String PARAM_KEY_SPECIAL_ONE = "specialOne";
        public static final String PARAM_KEY_SPECIAL_TWO = "specialTwo";
        public static final String PARAM_KEY_SPEED_UP = "speedUp";
        public static final String PARAM_KEY_SYMBOL_FILTER = "symbolFilter";
    }

    /* loaded from: classes.dex */
    public static final class PrivateCloudConfig {
        public static final String PARAM_KEY_PROPERTY = "property";
    }

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
        public static final String PARAM_KEY_RES_PREFIX = "resPrefix";
    }
}
