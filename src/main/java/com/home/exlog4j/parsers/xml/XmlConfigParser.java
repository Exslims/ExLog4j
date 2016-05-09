package com.home.exlog4j.parsers.xml;

import com.home.exlog4j.Level;
import com.home.exlog4j.config.ExConfig;
import com.home.exlog4j.config.appenders.Appender;
import com.home.exlog4j.config.appenders.console.ConsoleAppender;
import com.home.exlog4j.config.appenders.file.FileAppender;
import com.home.exlog4j.config.appenders.file.builder.FileAppenderBuilder;
import com.home.exlog4j.parsers.Parser;
import com.home.exlog4j.parsers.xml.stubs.ConfigurationStub;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


/**
 *
 */
public class XmlConfigParser implements Parser {


        private HashMap<String , Function<ConfigurationStub.Profile.Appender,Appender>> functionHashMap;

        public XmlConfigParser() {
            this.functionHashMap = new HashMap<>();

            this.functionHashMap.put("file" , (appender)-> {

                ConfigurationStub.Profile.Appender.File file = appender.getFile();

                Boolean autoFlush = Boolean.valueOf(file.getAutoFlush());
                String fileName = file.getFileName();
                String maxFileSize = file.getMaxFileSize();
                String maxBufferSize =  file.getMaxBufferSize();

                return  new FileAppenderBuilder().
                        setFileName(fileName).
                        setAutoFlush(autoFlush).
                        setMaxFileSize(extractBytes(maxFileSize)).
                        setMaxBufferSize(extractBytes(maxBufferSize)).
                        setPattern(appender.getPattern()).
                        build();
            });

            this.functionHashMap.put("console" , (appender)-> new ConsoleAppender(appender.getPattern()));
        }

        @Override
        public HashMap<String, ExConfig> getConfigs(String path) {
            HashMap<String, ExConfig> configHashMap = new LinkedHashMap<>();
            Optional<ConfigurationStub> configurationStub = this.deserializeConfiguration(path);

            configurationStub.ifPresent((config) -> {
                for (ConfigurationStub.Profile profile : config.getProfile()) {
                    List<Appender> appenderList = new ArrayList<>();
                    for (ConfigurationStub.Profile.Appender appenderStub : profile.getAppender()) {
                        String appenderType = appenderStub.getType();
                       appenderList.add(
                               this.functionHashMap.get(appenderType).apply(appenderStub)
                       );
                    }
                    ExConfig exConfig = new ExConfig(Level.ALL.toString(), appenderList);
                    configHashMap.put(profile.getName(), exConfig);
                }
            });
            return configHashMap;
        }


        private Optional<ConfigurationStub> deserializeConfiguration(String path) {
            Optional<ConfigurationStub> optional = Optional.empty();
            try {
                File file = new File(path);
                JAXBContext jaxbContext = JAXBContext.newInstance(ConfigurationStub.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                optional = Optional.ofNullable((ConfigurationStub) jaxbUnmarshaller.unmarshal(file));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return optional;
        }

        private long extractBytes(String rawValue) {
            String unit = rawValue.substring(rawValue.length()-2 , rawValue.length());
            Long extracted = Long.valueOf(rawValue.substring(0,rawValue.length()-2));
            switch (unit) {
                case "MB": {
                    extracted *= FileAppender.MB;
                    break;
                }
                case "KB": {
                    extracted *= FileAppender.KB;
                    break;
                }

                default: {
                    extracted *= FileAppender.KB;
                    break;
                }
            }
//            System.out.println("Raw  = " + rawValue);
//            System.out.println("Unit = " + unit);
//            System.out.println("Extracted = " + extracted);
            return extracted;
        }

//        private boolean isInEnum(String value) {
//            return Arrays.stream(NodeName.values()).
//                    anyMatch(element -> element.name().equals(value));
//        }
}