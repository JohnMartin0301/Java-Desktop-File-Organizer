# 🗂️ Java Desktop File Organizer - Final Project for Computer Programming (First-Year Level)
![Program](https://github.com/user-attachments/assets/65b7c561-da72-4385-83be-90cf5c6ba94d)


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
![Desktop](https://github.com/user-attachments/assets/ac4a7dea-c818-4fcf-a475-3d57a27e0996)

## Running the program:
![Running the program](https://github.com/user-attachments/assets/754bfe2d-5329-46f4-916b-fa222a7f7172)

## Console outputs:
![Console outputs](https://github.com/user-attachments/assets/d735efbd-c0a8-486d-aa24-b7adf6d5920e)

## Documents folder:
![Docs](https://github.com/user-attachments/assets/23c1b34d-76ce-4f9b-8f5e-1b1a32892a3b)

## Pictures folder:
![pics](https://github.com/user-attachments/assets/2c43fff7-6bbe-4a8a-bf07-8f67a26f6c85)

## Music folder:
![music](https://github.com/user-attachments/assets/c1d90850-2c4c-419b-b759-2b05b719c1e9)

## Desktop (Organized/Cleaned):
![Desktop(cleaned)](https://github.com/user-attachments/assets/b2acf55b-caf1-4efa-b5eb-95662ca3abef)



## 💡 Author

**John Martin** – Computer Engineering Student  
This project was created during my first year and helped me understand how to work with file handling in Java.

---

## 📃 License

This project is free to use and modify for learning or personal use.
