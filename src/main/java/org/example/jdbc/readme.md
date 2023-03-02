# run h2 database locally
## Embedded
1. Download JAR file from the source
   http://www.h2database.com/html/cheatSheet.html
2. Open folder with JAR
3. Start H2 on your local env via command
```shell
java -jar h2-<YOUR H2 VERSION HERE>.jar
```
for example my jar name is **h2-2.1.214.jar**
```shell
java -jar h2-2.1.214.jar
```
4. Connect to db, create USERS table and add some data
5. Disconect from DB to release connection

## Server mode
1. http://www.h2database.com/html/cheatSheet.html
2. start H2 in a server mode
```shell
java -cp h2-2.1.214.jar org.h2.tools.Server
```
