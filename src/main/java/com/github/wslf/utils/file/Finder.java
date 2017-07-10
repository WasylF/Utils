package com.github.wslf.utils.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Wsl_F
 */
public class Finder {

    private ArrayList<String> pathToString(List<Path> list) {
        ArrayList<String> result = new ArrayList<>(list.size());
        for (Path path : list) {
            result.add(path.toAbsolutePath().toString());
        }

        return result;
    }

    /**
     * Getting list of all subfolders.
     *
     * @param folderPath parent folder for subfolders that we are looking for
     * @param maxDepth maximum depth of subfolders, use "-1" to get all
     * subfolders. 0 -> empty list, 1 -> subfolders only of given folder.
     * @return List of paths to all subfolders of given folder
     */
    public ArrayList<Path> getSubFolders(Path folderPath, int maxDepth) throws IOException {
        if (maxDepth == 0) {
            return new ArrayList<>();
        }
        try {
            List<Path> subdirectories = Files.walk(folderPath, 1)
                    .filter(Files::isDirectory)
                    .collect(Collectors.toList());
            subdirectories.remove(0);
            ArrayList<Path> result = new ArrayList<>(subdirectories);
            for (Path path : subdirectories) {
                result.addAll(getSubFolders(path, maxDepth - 1));
            }
            return result;
        } catch (IOException ex) {
            System.err.println("Error while getting subfolders of folder: "
                    + folderPath.toString() + "\n" + ex.getMessage() + "\n");
            throw ex;
        }
    }

    /**
     * Getting all files in given folder.
     *
     * @param folderPath path to the folder
     * @return list of all files that given folder has contained
     */
    public ArrayList<Path> getFiles(Path folderPath) throws IOException {
        try {
            List<Path> files = Files.walk(folderPath, 1)
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            return new ArrayList<>(files);
        } catch (IOException ex) {
            System.err.println("Error while getting subfolders of folder: "
                    + folderPath.toString() + "\n" + ex.getMessage() + "\n");
            throw ex;
        }
    }

    /**
     * Getting files with specific extensions in given folder.
     *
     * @param folderPath path to the folder
     * @param extensions list extensions of files
     * @return list of files that given folder has contained
     */
    public ArrayList<Path> getFiles(Path folderPath, List<String> extensions) throws IOException {
        ArrayList<Path> files = getFiles(folderPath);
        ArrayList<Path> result = new ArrayList<>();
        for (Path file : files) {
            String fName = file.getFileName().toString();
            for (String ext : extensions) {
                if (fName.endsWith(ext)) {
                    result.add(file);
                }
            }
        }

        return result;
    }

    /**
     * Getting list of all subfolders.
     *
     * @param folder parent folder for subfolders that we are looking for
     * @param maxDepth maximum depth of subfolders, use "-1" to get all
     * subfolders. 0 -> empty list, 1 -> subfolders only of given folder.
     * @return List of paths to all subfolders of given folder
     */
    public ArrayList<String> getSubFolders(String folder, int maxDepth) throws IOException {
        return pathToString(getSubFolders(Paths.get(folder), maxDepth));
    }

    /**
     * Getting all files in given folder.
     *
     * @param folderPath path to the folder
     * @return list of all files that given folder has contained
     */
    public ArrayList<String> getFiles(String folderPath) throws IOException {
        return pathToString(getFiles(Paths.get(folderPath)));
    }

    /**
     * Getting files with specific extensions in given folder.
     *
     * @param folderPath path to the folder
     * @param extensions list extensions of files
     * @return list of files that given folder has contained
     */
    public ArrayList<String> getFiles(String folderPath, List<String> extensions) throws IOException {
        return pathToString(getFiles(Paths.get(folderPath), extensions));
    }
}
