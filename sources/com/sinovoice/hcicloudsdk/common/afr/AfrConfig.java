package com.sinovoice.hcicloudsdk.common.afr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class AfrConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_ATTRIBUTE_MODE_EYE_MOUTH = "eyemouth";
        public static final String PARAM_KEY_ATTRIBUTE_MODE_GENDER = "gender";
        public static final String PARAM_KEY_ATTRIBUTE_MODE_GLASSES = "glasses";
        public static final String PARAM_KEY_ATTRIBUTE_MODE_POSE = "pose";
        public static final String PARAM_KEY_ATTRIBUTE_MODE_SKIN = "skin";
        public static final String PARAM_KEY_AUTO_SCALE = "autoScale";
        public static final String PARAM_KEY_AUTO_SCALE_NO = "no";
        public static final String PARAM_KEY_AUTO_SCALE_YES = "yes";
        public static final String PARAM_KEY_CAND_NUM = "candNum";
        public static final String PARAM_KEY_CAP_KEY = "capKey";
        public static final String PARAM_KEY_DETECT_MINFACESIZE = "minFaceSize";
        public static final String PARAM_KEY_DETECT_MODE = "detectMode";
        public static final String PARAM_KEY_DETECT_MODE_ALL_FACE = "allface";
        public static final String PARAM_KEY_DETECT_MODE_ONE_FACE = "oneface";
        public static final String PARAM_KEY_DETECT_THRESHOLD = "detectThreshold";
        public static final String PARAM_KEY_EXTRACT_FEAT_MODE = "extractFeatMode";
        public static final String PARAM_KEY_EXTRACT_FEAT_MODE_ENHANCED = "enhanced";
        public static final String PARAM_KEY_EXTRACT_FEAT_MODE_NORMAL = "normal";
        public static final String PARAM_KEY_FACE_ID = "faceId";
        public static final String PARAM_KEY_LOCAL_PROCESS = "localProcess";
        public static final String PARAM_KEY_MAX_SCALE_SIZE = "maxScaleSize";
        public static final String PARAM_KEY_RES_PREFIX = "resPrefix";
        public static final String PARAM_KEY_SCALE_FACTOR = "scaleFactor";
        public static final String PARAM_KEY_THRESHOLD = "threshold";
        public static final String PARAM_KEY_USER_MODEL_PATH = "userModelPath";
    }

    /* loaded from: classes.dex */
    public static final class UserConfig {
        public static final String PARAM_KEY_GROUP_ID = "groupId";
        public static final String PARAM_KEY_USER_ID = "userId";
    }
}
