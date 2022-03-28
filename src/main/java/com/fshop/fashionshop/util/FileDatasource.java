package com.fshop.fashionshop.util;

import java.io.File;
import java.nio.file.Path;

public class FileDatasource {

    private File dataFolder = null;

    public FileDatasource() {
        createDataFolder();

    }

    private void createDataFolder() {

        dataFolder = new File(new File("").getAbsolutePath() + File.separator + FileConstants.DATA_FOLDER_NAME);

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        } else if (dataFolder.exists() && !dataFolder.isDirectory()) {
            dataFolder.mkdir();
        }

    }

    public String createProductFolder(String folderName) {
        File imageFolder = new File(
                new File("").getAbsolutePath() +
                        File.separator
                        + FileConstants.DATA_FOLDER_NAME
                        + File.separator
                        + folderName);

        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }
        return imageFolder.getPath();
    }


}
