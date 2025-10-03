# 📱 Project Manager App

A simple **Jetpack Compose** based project management app.

---

## ✨ Features
- ➕ **Add Project**: Enter Title, Description, and Image URL  
- 📄 **Project Detail**: View details of a project  
- 📚 **Project Library**: Browse all projects with **Edit / Delete** options  
- ℹ️ **About Screen**: Shows basic app information  

---

## 🖼 Wireframe
Visual layout of the 4 main screens:  

![Wireframe](images/wireframe.png)

---

## 🔄 User Flow
1. **Add Project**  
   - User enters Title, Description, and Image URL  
   - Clicks **Add** → navigates to Project Detail  

2. **Project Detail**  
   - Displays Title, Description, and Image  

3. **Project Library**  
   - Shows list of projects  
   - **Edit** → opens Project Detail  
   - **Delete** → removes the project  

4. **About**  
   - Shows app info  

---

## 🛠 Tech Stack
- **Language**: Kotlin  
- **UI**: Jetpack Compose + Material 3  
- **Navigation**: Navigation Compose  
- **Image Loading**: Coil (AsyncImage for URLs)  

---

## 🚀 Setup
1. Clone the repo:
   ```bash
   git clone https://github.com/linyueCS-IT/project-manager.git
