# 🗂️ Java Desktop File Organizer - Final Project for Computer Programming (First-Year Level)

![Screenshot (285)](https://github.com/user-attachments/assets/90c5027e-41f5-44de-9297-1a8b616a28ff)

A simple Java program that automatically organizes files on your Desktop into their proper folders based on file type. It helps clean up your Desktop by moving audio, video, image, and document files into specific folders.

---

## 📌 What It Does

- Scans your Desktop for files
- Identifies the file type (audio, video, image, or document)
- Moves each file to the right folder:
  - 🎵 **Audio Files** → `Music/` or `Music/SFX/` (if file size is small or name contains "SFX")
  - 🎬 **Video Files** → `Videos/`
  - 🖼️ **Image Files** → `Pictures/`
  - 📄 **Documents** → `Documents/`
- Skips folders and unknown file types
- Prints a summary of how many files were moved or skipped

---

## 📁 Example Folders

Make sure these folders exist on your computer (or they will be created automatically by the program):

```
C:\Users\Name\Desktop        <-- Your source folder (Desktop)  
C:\Users\Name\Music          <-- For large music files  
C:\Users\Name\Music\SFX      <-- For sound effects or small audio  
C:\Users\Name\Videos         <-- For video files  
C:\Users\Name\Pictures       <-- For images  
C:\Users\Name\Documents      <-- For documents  
```

---

## 🧠 How It Works

1. It checks every file on the Desktop.
2. Based on the file extension (like `.mp3`, `.jpg`, `.pdf`, etc.), it decides where to move it.
3. It uses the `Files.move()` method with overwrite enabled.
4. It skips any folders or files with unknown extensions.

---

## 🛠️ How to Run

1. Make sure you have **Java installed**.
2. Copy and paste the code into a file called `DesktopOrganizer.java`.
3. Open a terminal or command prompt.
4. Compile the code:
   ```bash
   javac DesktopOrganizer.java
   ```
5. Run the program:
   ```bash
   java DesktopOrganizer
   ```

---

## 🔒 Notes

- This only processes regular files, not directories.
- It can **overwrite** files with the same name in the destination.
- You can change the folder paths in the code to match your system.

---

##📦 File Types Supported

| Type     | Extensions                              |
|----------|-----------------------------------------|
| Audio    | `.m4a`, `.flac`, `.mp3`, `.wav`, `.wma`, `.aac` |
| Video    | `.webm`, `.mpg`, `.mp4`, `.avi`, `.mov`, `.mkv` |
| Image    | `.jpg`, `.jpeg`, `.png`, `.gif`, `.bmp`         |
| Document | `.pdf`, `.doc`, `.docx`, `.txt`                 |

---

## 📌 Sample Output (Console)

```
=== DESKTOP ORGANIZER DEBUG MODE ===  
Source directory: C:\Users\John\Desktop  
Found 10 items in desktop  
Processing: sample.mp3  
   Type: FILE  
   Size: 2538723 bytes  
   Extension: '.mp3'  
   File type: AUDIO  
   Target directory: C:\Users\John\Music\SFX  
   MOVED SUCCESSFULLY  
...  
SUMMARY:  
   Files moved: 6  
   Files skipped: 4  
   Total processed: 10  
=== PROCESS COMPLETED ===
```

---

## Demo:
## Desktop with different files:
![Screenshot 2025-06-21 151519](https://github.com/user-attachments/assets/d3ca1e82-8b9c-41ad-b638-448b3b165c7d)

#@ Running the program:
![Screenshot (287)](https://github.com/user-attachments/assets/a8d5a6b2-20ab-4363-8915-74dd9c0b1039)

## Console outputs:
![Screenshot 2025-06-21 151503](https://github.com/user-attachments/assets/521e8291-f6cc-4feb-a6f8-4f06d03d9aee)

## Documents folder:
![Screenshot 2025-06-21 151705](https://github.com/user-attachments/assets/fbcac333-eaf2-4d87-a1ff-b68be36832c6)

## Pictures folder:
![Screenshot 2025-06-21 151634](https://github.com/user-attachments/assets/c3f5c23f-a6f9-4e39-823d-5cafa7d61d53)

## Music folder:
![Screenshot 2025-06-21 151614](https://github.com/user-attachments/assets/a45b338e-3768-4899-aa12-76221ef42aca)

## Desktop (Organized/Cleaned):
![Screenshot 2025-06-21 151519](https://github.com/user-attachments/assets/debaecbd-0650-4403-91e3-df293a6d422a)


## 💡 Author

**John Martin** – Computer Engineering Student  
This project was created during my first year and helped me understand how to work with file handling in Java.

---

## 📃 License

This project is free to use and modify for learning or personal use.
