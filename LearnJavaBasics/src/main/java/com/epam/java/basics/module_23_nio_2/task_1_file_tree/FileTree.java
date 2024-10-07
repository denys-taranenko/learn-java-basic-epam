package com.epam.java.basics.module_23_nio_2.task_1_file_tree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.list;

public class FileTree {

    public Optional<String> tree(Path path) {
        if (path == null || !Files.exists(path)) return Optional.empty();
        if (Files.isRegularFile(path)) {
            return Optional.of(path.getFileName() + " " + getFileSize(path) + " bytes");
        }
        if (Files.isDirectory(path)) {
            return Optional.of(directoryTree(path, new ArrayList<>()));
        }
        return Optional.empty();
    }

    private String directoryTree(Path directory, List<Boolean> lastFolders) {
        StringBuilder directoryRepresentation = new StringBuilder();

        if (!lastFolders.isEmpty()) {
            directoryRepresentation.append(!(lastFolders.getLast()) ? "├─ " : "└─ ");
        }
        directoryRepresentation.append(directory.getFileName()).append(" ").append(folderSize(directory));

        try {
            var files = list(directory).toArray(Path[]::new);
            int count = files.length;

            files = sortFiles(files);
            for (int i = 0; i < count; i++) {
                directoryRepresentation.append("\n");
                for (Boolean lastFolder : lastFolders) {
                    if (lastFolder) {
                        directoryRepresentation.append("   ");
                    } else {
                        directoryRepresentation.append("│  ");
                    }
                }

                if (Files.isRegularFile(files[i])) {
                    directoryRepresentation.append(i + 1 == count ? "└" : "├")
                            .append("─ ")
                            .append(files[i].getFileName())
                            .append(" ")
                            .append(getFileSize(files[i]))
                            .append(" bytes");
                } else {
                    ArrayList<Boolean> list = new ArrayList<>(lastFolders);
                    list.add(i + 1 == count);
                    directoryRepresentation.append(directoryTree(files[i], list));
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return directoryRepresentation.toString();
    }

    private long getFolderSize(Path folder) {
        long size = 0;
        try {
            var files = list(folder).toArray(Path[]::new);

            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    size += getFileSize(file);
                } else {
                    size += getFolderSize(file);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return size;
    }

    private String folderSize(Path folder) {
        return getFolderSize(folder) + " bytes";
    }

    private Path[] sortFiles(Path[] folder) {
        List<Path> sorted = new ArrayList<>();

        for (Path path : folder) {
            if (Files.isDirectory(path)) sorted.add(path);
        }

        for (Path path : folder) {
            if (Files.isRegularFile(path)) sorted.add(path);
        }
        return sorted.toArray(new Path[0]);
    }

    private long getFileSize(Path file) {
        try {
            return Files.size(file);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
