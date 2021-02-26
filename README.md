## MoonCalendar

The project implements a network application - a client-server cross-platform program and a database for it. <br>
The server receives requests from the client, processes them and responds with predictions for the current day from the database. <br>
The server is available at several addresses: <br>
`<url>/current` - to find out the current day, `<url>/day` - for day predictions and `<url>/pay` - for personal predictions. <br>
The client, built on the Android platform, sends requests to the server, receives a response and displays the text on the smartphone screen. <br>

In this project used N-tier architecture with DB layer, DAO layer, Service layer and Controllers layer. <br>

### Project Structure

The project has an N-tier structure and consists of the database layer, the DAO layer for
interaction with the database, the service layer which contains the business logic, and the
controllers layer.  

### Technologies Used

#### Server:

- Java 8
- JDBC
- PostgreSQL
- Servlet
- Apache Tomcat
- Apache Maven

#### Application:

- Android Studio
- Java 8
- Multithreading
- URLConnection
- Notifications
- Gradle

### Author

[Vadim Okulov](https://github.com/Vedroid)

### Preview:

| <img src="https://github.com/Vedroid/images-in-readme/blob/main/MoonCalendar/project_mooncalendar_mainactivity.png"/>  | <img src="https://github.com/Vedroid/images-in-readme/blob/main/MoonCalendar/project_mooncalendar_mainactivity_next.png"/>  | <img src="https://github.com/Vedroid/images-in-readme/blob/main/MoonCalendar/project_mooncalendar_enterbday.png"/>  | <img src="https://github.com/Vedroid/images-in-readme/blob/main/MoonCalendar/project_mooncalendar_personalprediction.png"/>  |
| ------------- | ------------- | ------------- | ------------- |
