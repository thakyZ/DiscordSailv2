package com.github.vaerys.enums;

/**
 * used to differentiate the different command types
 *
 * @author C0bra5
 */
public enum SAILType {
    //command types

    ADMIN("Admin"),
    CC("CC"),
    COMPETITION("Comp"),
    CHARACTER("Chars"),
    CREATOR("Creator"),
    DM("DM"),
    GENERAL("General"),
    GROUPS("Groups"),
    HELP("Help"),
    CUSTOM_JOIN_MESSAGES("JoinMessages"),
//    MENTION("Mention"),
    MOD_TOOLS("ModTools"),
    PIXEL("Pixels"),
    ROLE_SELECT("Role"),
    SERVERS("Servers"),
    SLASH("Slash"),
    SETUP("Setup"),
    LOGGING("Logging"),

    //module types
    ART_PINNING("ArtPinning"),
    PROFILES("Profiles"),
    MOD_MUTE("ModMute"),
    READ_RULES_REWARDS("RuleCode"),

    //Toggle types
    ADMIN_LOGGING("AdminLogging"),
    AUTO_ART_PINNING("AutoArtPinning"),
    CHANNEL_LOGGING("ChannelLogging"),
    COMP_ENTRIES("CompEntries"),
    DAILY_MESSAGE("DailyMessage"),
    DEBUG_MODE("DebugMode"),
    DELETE_LOGGING("DeleteLogging"),
    DENY_INVITES("DenyInvites"),
    DONT_LOG_BOT("DontLogBot"),
    EDIT_LOGGING("EditLogging"),
    EXTEND_EDIT_LOG("ExtendEditLog"),
    GENERAL_LOGGING("GeneralLogging"),
    JOIN_LEAVE_LOGGING("JoinLeaveLogging"),
    JOIN_SERVER_MESSAGES("WelcomeMessages"),
    LIKE_ART("LikeArt"),
    MENTION_SPAM("MentionSpam"),
    MUTE_REPEAT_OFFENDER("MuteRepeatOffender"),
    RATE_LIMITING("RateLimiting"),
    REACT_TO_LEVEL_UP("ReactToLevelUp"),
    ROLE_IS_TOGGLE("RoleIsToggle"),
    SELF_DESTRUCT_LEVEL_UPS("SelfDestructLevelUps"),
    SHITPOST_FILTERING("ShitpostFiltering"),
    STOP_SPAM_WALLS("StopSpamWalls"),
    USER_INFO_SHOWS_DATE("UserInfoShowsDate"),
    USER_ROLE_LOGGING("UserRoleLogging"),
    USE_TIME_STAMPS("UseTimeStamps"),
    VOTING("Voting"),
    XP_DECAY("XpDecay"),
    XP_GAIN("XpGain"),
    CHECK_NEW_USERS("CheckNewUsers"),
    SEND_JOIN_MESSAGES("SendJoinMessages"),
    BAN_LOGGING("BanLogging"),
    KICK_LOGGING("KickLogging"),
    ADMIN_CC("AdminCC");

    private String name;

    SAILType(String name) {
        this.name = name;
    }

    public static SAILType get(String type) {
        for (SAILType c : values()) {
            if (c.toString().equalsIgnoreCase(type)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
