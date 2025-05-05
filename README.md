# Task-Manager

#How to Use Task manager App
To run the application, open and your terminal in the root of the project, then run thr following:
mvn javafx:run

Application Features
Add Task

Click the "Add Task" button.

Enter the task name, description, and due date.

Click "Save" to add the task.

Edit Task

Select a task from the list.

Click the "Edit Task" button.

Make changes and click "Save."

View Task Details

Double-click any task in the list to open a window displaying its full details.

Delete Task 

Select a task and click the "Delete" button to remove it from the list.


#How to Run the Script
 
To run the setup script, open and your terminal in the root of the project, then run thr following:
./setup.sh

This will:
Launch the JavaFX application

Run unit tests

Package the app into an executable .jar

Copy the JAR file into the website's download folder

Install Node.js dependencies

Launch the local website server with Node.js

Upload the website to my EC2 instance


#Deployment

Created and configured an EC2 instance using Amazon Linux 2023 (Free Tier eligible).

Generated a new key pair (.pem) for secure SSH access to the virtual server.

Connected to the EC2 instance via SSH using the terminal and the private key.

Installed essential tools including Git, Node.js, and npm on the EC2 instance.

Cloned the GitHub repository containing the Task Manager project into the EC2 environment.

Navigated to the website directory, installed Node.js dependencies with npm install, and launched the web server using node app.js.

Opened port 8080 in the EC2 security group to allow external access to the hosted website.

