package com.home.exlog4j.config.appenders;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * %date{yyyy-MM-dd HH:mm:ss} %level %target %- %message
 * //todo position on log string + separate
 */
public class PatternLayout {
    private String pattern;
    private String separate;
    private SimpleDateFormat dateFormat;
    private Date date;

    private List<String> priority;

    public PatternLayout(String pattern) {
        this.pattern = pattern;
        parse();
    }
    public PatternLayout(){}

    private void parse() {
        priority = new LinkedList<String>();

        List<String> tokens = Arrays.asList(pattern.split("%"));
        for (String token :tokens) {
            token = token.trim();
            if (token.startsWith("date")){
                dateFormat = new SimpleDateFormat(token.substring(5,token.indexOf("}",5)));
                priority.add("date");
            }else if(token.startsWith("level")){
                priority.add("level");
            }else if(token.startsWith("target")){
                priority.add("target");
            }else if(token.startsWith("message")){
                priority.add("message");
            }else if (!token.equals("")){
                priority.add("separate");
                separate = token;
            }
        }
    }

    public String getFormattedMessage(String level,String message, String target){
        StringBuilder builder = new StringBuilder();
        for (String next : priority) {
            if(next.equals("date")){
                if(date == null) {
                    builder.append(dateFormat.format(new Date()));
                }else builder.append(dateFormat.format(date));
                builder.append(" ");
            }else if(next.equals("level")){
                builder.append(level);
                builder.append(" ");
            }else if(next.equals("target")){
                builder.append(target);
                builder.append(" ");
            }else if(next.equals("message")){
                builder.append(message);
                builder.append(" ");
            }else if(next.equals("separate")){
                builder.append(separate);
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public String getPattern() {
        return pattern;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
        parse();
    }
}
