# MultiClientProgram - Java Messaging Application

A Java-based multi-client messaging application built with Swing GUI that allows users to register, login, and communicate in real-time through a centralized server.

## Project Overview

This is a client-server messaging application that provides:
- User registration and authentication system
- Real-time messaging between multiple clients
- User management and active user tracking
- File-based user data storage
- Modern Swing-based graphical user interface

## Project Structure

```
MultiClientProgram/
├── src/
│   ├── chat/           # Core messaging functionality
│   │   ├── Client.java     # Client-side messaging logic
│   │   ├── Server.java     # Server-side message handling
│   │   ├── Client.form     # Client GUI form
│   │   └── Server.form     # Server GUI form
│   ├── GUI/            # User interface components
│   │   ├── FirstPage.java      # Main landing page
│   │   ├── LogInPage.java      # User login interface
│   │   ├── RegisterForm.java   # User registration interface
│   │   ├── MenuPage.java       # Main menu after login
│   │   ├── ClientsList.java    # Active users list
│   │   └── EditPage.java       # User profile editing
│   ├── Identities/      # User management
│   │   ├── User.java        # User data model
│   │   └── ManageUser.java  # User operations
│   └── Commons/         # Shared utilities
│       ├── Common.java      # Common constants
│       └── TxtFileManager.java # File operations
├── Users.txt           # User data storage
├── build.xml          # Ant build configuration
└── manifest.mf        # JAR manifest file
```

## Features

### Core Functionality
- **Multi-client Support**: Multiple users can connect simultaneously
- **Real-time Messaging**: Instant message delivery between clients
- **User Authentication**: Secure login and registration system
- **Active User Tracking**: Server maintains list of online users
- **User Management**: Profile creation and editing capabilities

### Technical Features
- **Socket-based Communication**: TCP/IP networking for reliable message delivery
- **Thread-safe Operations**: Concurrent user management with thread safety
- **File-based Storage**: Persistent user data using text files
- **Swing GUI**: Modern and intuitive user interface
- **NetBeans Integration**: Built with NetBeans IDE support

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (recommended for development)
- Ant build tool (included with NetBeans)

## Installation and Setup

### Option 1: Using NetBeans IDE
1. Open NetBeans IDE
2. Select "Open Project" from the File menu
3. Navigate to the MultiClientProgram directory and select it
4. The project will be loaded with all dependencies configured

### Option 2: Command Line Build
1. Ensure you have Ant installed
2. Open terminal/command prompt in the project directory
3. Run the build command:
   ```bash
   ant build
   ```

## Running the Application

### Starting the Server
1. Run the Server class from the `src/chat/` package
2. The server will start on port 2089
3. The server GUI will display active users and connection status

### Starting Clients
1. Run the FirstPage class from the `src/GUI/` package
2. Choose between "Sign In" (registration) or "Login"
3. Complete the authentication process
4. Access the messaging interface

## Usage Instructions

### For New Users
1. Click "Sign In" on the main page
2. Fill in the registration form with your details
3. Submit to create your account
4. Login with your credentials

### For Existing Users
1. Click "Login" on the main page
2. Enter your username and password
3. Access the messaging interface

### Messaging
1. After login, you'll see the main menu
2. Select "Chat" to open the messaging interface
3. View active users in the clients list
4. Send messages that will be delivered to all online users

## Configuration

### Server Configuration
- Default port: 2089 (configurable in Server.java)
- User data file: Users.txt
- Message format: UTF-8 encoding

### Client Configuration
- Server connection: localhost:2089 (default)
- GUI theme: System default
- Message history: Real-time display

## File Descriptions

- **Users.txt**: Stores user registration data
- **client-sent.txt**: Logs client messages (if enabled)
- **manifest.mf**: JAR file manifest for deployment
- **build.xml**: Ant build script for project compilation

## Development Notes

### Architecture
- **Client-Server Model**: Centralized server with multiple clients
- **Threading**: Separate threads for message handling and user management
- **GUI Framework**: Java Swing for cross-platform compatibility
- **Data Persistence**: Text file-based storage for simplicity

### Key Classes
- **Server**: Handles client connections and message routing
- **Client**: Manages client-side messaging and GUI
- **User**: Data model for user information
- **ManageUser**: User authentication and management operations

## Troubleshooting

### Common Issues
1. **Port Already in Use**: Change the port number in Server.java
2. **Connection Refused**: Ensure server is running before starting clients
3. **User Already Registered**: Use a different username for registration
4. **GUI Not Displaying**: Check Java version compatibility

### Debug Mode
- Server logs connection events and message activity
- Client displays connection status and error messages
- Check console output for detailed error information

## Contributing

This project is structured for easy modification and extension:
- Add new GUI components in the `src/GUI/` package
- Extend messaging features in the `src/chat/` package
- Modify user management in the `src/Identities/` package
- Update common utilities in the `src/Commons/` package
 
