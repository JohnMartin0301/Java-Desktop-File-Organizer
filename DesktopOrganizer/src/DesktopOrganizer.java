import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DesktopOrganizer {

    public static void main(String[] args) {
        // Define source and destination directories
        String sourceDir = "C:\\Users\\John\\Desktop";
        String destDirSFX = "C:\\Users\\John\\Music\\SFX";
        String destDirMusic = "C:\\Users\\John\\Music";
        String destDirVideo = "C:\\Users\\John\\Videos";
        String destDirImage = "C:\\Users\\John\\Pictures";
        String destDirDocuments = "C:\\Users\\John\\Documents";

        System.out.println("=== DESKTOP ORGANIZER DEBUG MODE ===");
        System.out.println("Source directory: " + sourceDir);
        
        // Check if source directory exists
        File sourceDirectory = new File(sourceDir);
        if (!sourceDirectory.exists()) {
            System.out.println("ERROR: Source directory does not exist!");
            return;
        }
        
        if (!sourceDirectory.canRead()) {
            System.out.println("ERROR: Cannot read from source directory!");
            return;
        }

        File[] files = sourceDirectory.listFiles();

        if (files == null) {
            System.out.println("ERROR: Could not list files in source directory!");
            return;
        }

        System.out.println("Found " + files.length + " items in desktop");
        System.out.println("================================");

        int movedCount = 0;
        int skippedCount = 0;

        for (File file : files) {
            System.out.println("\nProcessing: " + file.getName());
            System.out.println("   Type: " + (file.isFile() ? "FILE" : file.isDirectory() ? "DIRECTORY" : "OTHER"));
            
            if (file.isFile()) {
                System.out.println("   Size: " + file.length() + " bytes");
                
                String fileName = file.getName();
                String fileExtension = getFileExtension(fileName);
                System.out.println("   Extension: '" + fileExtension + "'");

                String targetDir = null;
                String fileType = "UNKNOWN";

                if (isAudioFile(fileExtension)) {
                    fileType = "AUDIO";
                    targetDir = (file.length() < 10_000_000 || fileName.contains("SFX")) ? destDirSFX : destDirMusic;
                } else if (isVideoFile(fileExtension)) {
                    fileType = "VIDEO";
                    targetDir = destDirVideo;
                } else if (isImageFile(fileExtension)) {
                    fileType = "IMAGE";
                    targetDir = destDirImage;
                } else if (isDocumentFile(fileExtension)) {
                    fileType = "DOCUMENT";
                    targetDir = destDirDocuments;
                }

                System.out.println("   File type: " + fileType);

                if (targetDir != null) {
                    System.out.println("   Target directory: " + targetDir);
                    
                    try {
                        moveFile(file, targetDir);
                        System.out.println("   MOVED SUCCESSFULLY");
                        movedCount++;
                    } catch (Exception e) {
                        System.out.println("   MOVE FAILED: " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("   SKIPPED (unknown file type)");
                    skippedCount++;
                }
            } else {
                System.out.println("   SKIPPED (not a regular file)");
                skippedCount++;
            }
        }

        System.out.println("\n================================");
        System.out.println("SUMMARY:");
        System.out.println("   Files moved: " + movedCount);
        System.out.println("   Files skipped: " + skippedCount);
        System.out.println("   Total processed: " + files.length);
        System.out.println("=== PROCESS COMPLETED ===");
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex).toLowerCase();
        }
        return "";
    }

    private static void moveFile(File sourceFile, String destinationDirectory) throws IOException {
        // Create destination directory if it doesn't exist
        File destDir = new File(destinationDirectory);
        if (!destDir.exists()) {
            System.out.println("   Creating directory: " + destinationDirectory);
            boolean created = destDir.mkdirs();
            if (!created) {
                throw new IOException("Failed to create destination directory: " + destinationDirectory);
            }
        }

        // Check if we can write to destination directory
        if (!destDir.canWrite()) {
            throw new IOException("Cannot write to destination directory: " + destinationDirectory);
        }

        Path sourcePath = sourceFile.toPath();
        Path destinationPath = new File(destinationDirectory, sourceFile.getName()).toPath();
        
        // Check if destination file already exists
        if (Files.exists(destinationPath)) {
            System.out.println("   File already exists at destination, will overwrite");
        }
        
        System.out.println("   Moving from: " + sourcePath);
        System.out.println("   Moving to: " + destinationPath);
        
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }

    private static boolean isAudioFile(String extension) {
        String[] audioExtensions = { ".m4a", ".flac", ".mp3", ".wav", ".wma", ".aac" };
        for (String ext : audioExtensions) {
            if (extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVideoFile(String extension) {
        String[] videoExtensions = { ".webm", ".mpg", ".mp4", ".avi", ".mov", ".mkv" };
        for (String ext : videoExtensions) {
            if (extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isImageFile(String extension) {
        String[] imageExtensions = { ".jpg", ".jpeg", ".png", ".gif", ".bmp" };
        for (String ext : imageExtensions) {
            if (extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDocumentFile(String extension) {
        String[] documentExtensions = { ".pdf", ".doc", ".docx", ".txt" };
        for (String ext : documentExtensions) {
            if (extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }
}