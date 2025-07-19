package daily._2025_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1233_RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {

    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> folderList = new ArrayList<>(Arrays.asList(folder));

        int left = 0;

        while (left < folderList.size() - 1) {
            String parentFolder = folderList.get(left);
            int parentFolderLength = parentFolder.length();
            int right = left + 1;
            left++;

            if (parentFolderLength >= folderList.get(right).length()) {
                continue;
            }

            while (right < folderList.size()) {
                String subFolder = folderList.get(right);
                if (parentFolder.equals(subFolder.substring(0, parentFolderLength))
                        && "/".equals(subFolder.substring(parentFolderLength, parentFolderLength + 1))
                ) {
                    folderList.remove(right);
                } else {
                    break;
                }
            }
        }

        return folderList;
    }
}
