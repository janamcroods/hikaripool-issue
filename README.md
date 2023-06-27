To Reproduce “Unable to acquire JDBC Connection” issue in Local.
Just update property file with your database connection.
Hit below API from Jmeter N times, Here N= Number of Maximum Poolsize you have defined in property file.
http://localhost:8080/users/{userName}/document
