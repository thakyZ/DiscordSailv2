package Main;

/**
 * Created by Vaerys on 03/08/2016.
 */
public class Constants {

    //Command prefix constants
    public static final String PREFIX_COMMAND = "$";
    public static final String PREFIX_CC = "$$";
    public static final String PREFIX_INDENT = "    ";
    public static final String PREFIX_EDT_LOGGER_INDENT = "                                     ";

    //-------Command Constants---------

    //Type Constants
    public static final String TYPE_GENERAL = "General";
    public static final String TYPE_ADMIN = "Admin";
    public static final String TYPE_ROLE_SELECT = "Role";
    public static final String TYPE_SERVERS = "Servers";
    public static final String TYPE_CC = "CC";
    public static final String TYPE_HELP = "Help";

    //Channel Constants
    public static final String CHANNEL_ANY = "Any";
    public static final String CHANNEL_GENERAL = "General";
    public static final String CHANNEL_SERVERS = "Servers";
    public static final String CHANNEL_BOT_COMMANDS = "BotCommands";
    public static final String CHANNEL_SERVER_LOG = "ServerLog";
    public static final String CHANNEL_ADMIN_LOG = "AdminLog";
    public static final String CHANNEL_ADMIN = "Admin";
    public static final String CHANNEL_INFO = "Info";
    public static final String CHANNEL_SHITPOST = "ShitPost";
    //------------------------------------

    //Error Constants
    public static final String ERROR = "An Error Occurred";
    public static final String NULL_VARIABLE = "Null";
    public static final String ERROR_ROLE_NOT_FOUND = "> Role with that name not found.";
    public static final String ERROR_UPDATING_ROLE = "> An Error Occurred when trying to Update your roles.";

    //-------FilePath Constants--------

    //Directories
    public static final String DIRECTORY_STORAGE = "Storage/";
    public static final String DIRECTORY_BACKUPS = DIRECTORY_STORAGE + "Backups/";
    public static final String DIRECTORY_GLOBAL_IMAGES = DIRECTORY_STORAGE + "Images/";
    public static final String DIRECTORY_COMP = DIRECTORY_STORAGE + "Competition/";
    public static final String DIRECTORY_GUILD_IMAGES = "Images/";


    //Files
    public static final String FILE_TOKEN = DIRECTORY_STORAGE+"Token.txt";
    public static final String FILE_CUSTOM = "Custom_Commands.json";
    public static final String FILE_GUILD_CONFIG = "Guild_Config.json";
    public static final String FILE_SERVERS = "Servers.json";
    public static final String FILE_CHARACTERS = "Characters.json";
    public static final String FILE_INFO = "Info.txt";

    public static final String FILE_COMPETITION = DIRECTORY_COMP + "Competition.json";
}
