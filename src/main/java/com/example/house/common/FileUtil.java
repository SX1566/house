package com.example.house.common;

import java.io.*;
import java.util.Properties;

public class FileUtil {

    public static byte[] getBytesByFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);) {
                byte[] b = new byte[1000];
                int len;
                while ((len = fis.read(b)) != -1) {
                    bos.write(b, 0, len);
                }
                return bos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 加载配置文件
     *
     * @return Properties
     */
    public static Properties readProperties() {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        String configPath = System.getProperty("user.dir");
        try {
            bufferedReader = new BufferedReader(new FileReader(configPath + "\\config.properties"));
            properties.load(bufferedReader);
        } catch (FileNotFoundException e) {
            System.out.println("未读取到配置文件");
        } catch (IOException e) {
            System.out.println("加载配置文件出错");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
