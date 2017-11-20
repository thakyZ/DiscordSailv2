package com.github.vaerys.templates;

import com.github.vaerys.commands.CommandObject;
import com.github.vaerys.main.Utility;
import com.github.vaerys.objects.XEmbedBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public abstract class TagObject {

    private int priority;
    public String name;
    public String prefix;
    public String suffix;
    public String splitter;
    public String desc;
    public String usage;
    public int requiredArgs;
    List<String> types = new ArrayList<>();

    public TagObject(int priority, String... types) {
        this.priority = priority;
        requiredArgs = argsRequired();
        name = tagName();
        prefix = prefix();
        suffix = suffix();
        splitter = splitter();
        desc = desc();
        usage = usage();
        this.types = Arrays.asList(types);
    }

    public int getPriority() {
        return priority;
    }

    public abstract String execute(String from, CommandObject command, String args);

    public abstract String tagName();

    public abstract int argsRequired();

    public abstract String usage();

    public abstract String desc();

    public boolean isPassive() {
        return false;
    }

    public boolean cont(String from) {
        if (requiredArgs != 0) {
            String toRegex = Utility.escapeRegex(prefix) + ".*?" + Utility.escapeRegex(suffix);
            return Pattern.compile(toRegex).matcher(from).find();
        } else {
            return Pattern.compile(Utility.escapeRegex(prefix)).matcher(from).find();
        }
    }

    public String contents(String from) {
        if (requiredArgs != 0) {
            String subString = StringUtils.substringBetween(from, prefix, suffix);
            if (subString != null) {
                return subString;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public List<String> getSplit(String args) {
        String toSplit = contents(args);
        String[] isSplit = toSplit.split(splitter);
        if (isSplit.length == 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(toSplit.split(splitter));
    }

    public String removeFirst(String from, String args) {
        return StringUtils.replaceOnce(from, args, "");
    }

    public String removeAll(String from, String args) {
        return from.replace(args, "");
    }

    public String replaceFirst(String from, String replace, String withThis) {
        return StringUtils.replaceOnce(from, replace, withThis);
    }

    public String replaceFirstTag(String from, String withThis) {
        if (requiredArgs == 0) {
            return StringUtils.replaceOnce(from, prefix, withThis);
        } else {
            return StringUtils.replaceOnce(from, prefix + contents(from) + suffix, withThis);
        }
    }

    public String removeFirstTag(String from) {
        if (requiredArgs == 0) {
            return StringUtils.replaceOnce(from, prefix, "");
        } else {
            String toRemove = prefix + contents(from) + suffix;
            return StringUtils.replaceOnce(from, toRemove, "");
        }
    }

    public String replaceAllTag(String from, String withThis) {
        if (requiredArgs == 0) {
            return from.replace(prefix, withThis);
        } else {
            return from.replace(prefix + contents(from) + suffix, withThis);
        }
    }

    public String removeAllTag(String from) {
        if (requiredArgs == 0) {
            return from.replace(prefix, "");
        } else {
            return from.replace(prefix + contents(from) + suffix, "");
        }
    }

    public String splitter() {
        return ";;";
    }

    public String prefix() {
        if (requiredArgs == 0) {
            return name;
        } else {
            return name + "{";
        }
    }

    public String suffix() {
        if (requiredArgs == 0) {
            return "";
        } else {
            return "}";
        }
    }

    public String handleTag(String from, CommandObject command, String args) {
        if (from == null) from = "";
        while (cont(from)) {
            int absoluteArgs = Math.abs(requiredArgs);
            if (requiredArgs == 0) {
                from = execute(from, command, args);
            } else if (requiredArgs < 0 && getSplit(from).size() >= absoluteArgs) {
                from = execute(from, command, args);
            } else if (requiredArgs == getSplit(from).size()) {
                from = execute(from, command, args);
            } else {
                from = replaceFirstTag(from, "#ERROR#:" + name);
            }
            if (from == null) from = "";
        }
        return from;
    }

    public XEmbedBuilder getInfo(CommandObject command) {
        XEmbedBuilder builder = new XEmbedBuilder();
        builder.withTitle(name);
        builder.withColor(command.client.color);
        StringBuilder descContents = new StringBuilder();
        descContents.append(desc);


        if (isPassive()) {
            descContents.append("\n\n**This tag cannot be used in commands and is passively run on every command.**");
        } else if (requiredArgs != 0) {
            descContents.append("\n**Usage:** " + "`" + prefix + usage + suffix + "`");
        } else {
            descContents.append("\n**Usage:** `" + name + "`");
        }
        descContents.append("\n\n**Types:** " + Utility.listFormatter(types, true));
        builder.withDesc(descContents.toString());
        return builder;
    }

    public String validate() {
        StringBuilder response = new StringBuilder();
        boolean isErrored = false;
        response.append("\n>> Begin Error Report: " + this.getClass().getName() + " <<\n");
        if (name == null || name.isEmpty()) {
            response.append("> NAME IS EMPTY.\n");
            isErrored = true;
        }
        if (desc == null || desc.isEmpty()) {
            response.append("> DESCRIPTION IS EMPTY.\n");
            isErrored = true;
        }
        if (requiredArgs != 0 && (usage == null || usage.isEmpty())) {
            response.append("> USAGE IS EMPTY WHEN ARGS IS REQUIRED.\n");
            isErrored = true;
        }
        response.append(">> End Error Report <<");
        if (isErrored) {
            return response.toString();
        } else {
            return null;
        }
    }

    public List<String> getTypes() {
        return types;
    }
}