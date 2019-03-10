Project prisonSchool

Default url: http://localhost:8080/PrisonSchool/swagger-ui.html

Database setup:

    You need a MySqlDatabase to run this app
    -Download MySql database and tools from: https://dev.mysql.com/downloads/installer/
    
    -Install developer defaults.
        -If the run MySql server on system startup (or something similar) box is unchecked
            You can manually start a server via MySql Workbench Administration tab, Startup/Shutdown menu

    In MySql Workbench
        -Add prisonschool schema (cylinder icon with + sign),
        -Add default user : springuser, PW:ThePassword in Server menu; Users and privileges ,
        -Or use your own, but then
            don't forget to modify the application.properties file accordingly,
        -MySql uses default system timezone configuration, which can cause an error on startup
           You can set timezone by running the following command: "SET @@global.time_zone='+01:00';" (- CET winter time)

Initial Commit!