# Final Capstone
**Description** <br />
First project practicing Agile methodologies with three team members, the goal was to make a web application that was mobile-friendly for users to search for nearby restaurants. The application mimics the popular swipe left feature and allows users to build a preference list of liked restaurants.

## Steps to get the application up and running
1. Setting up database <br />
```shell
cd final-capstone\java\database
./create.sh
```
### Database users

The database superuser—meaning `postgres`—must only be used for database administration. It must not be used by applications. As such, two database users are created for the capstone application to use as described below:

| Username | Description |
| -------- | ----------- |
| `final_capstone_owner` | This user is the schema owner. It has full access—meaning granted all privileges—to all database objects within the `capstone` schema and also has privileges to create new schema objects. This user can be used to connect to the database from PGAdmin for administrative purposes. |
| `final_capstone_appuser` | The application uses this user to make connections to the database. This user is granted `SELECT`, `INSERT`, `UPDATE`, and `DELETE` privileges for all database tables and can `SELECT` from all sequences. The application datasource has been configured to connect using this user. |
2. Start Java backend <br />
- IntelliJ: navigate to `final-capstone\src\main\java\com\techelevator\Application.java` and click 'Run'
- Go to your browser and go to `http://localhost:8081'
<br />
3. Start React frontend 
```shell
cd final-capstone\fronend
npm install
npm start
```
- Go to your browser and go to `http://localhost:3000'
<br />
## Figma Prototype
<br />
<img  alt="Prototype of Home page and Sign in" width="100%" style="padding-right:10px;" src="https://github.com/melissakipp/Yummily/blob/main/java/src/main/resources/images/prototype_home&login.jpg" />
<br />
<br />
![prototype(create&search).jpg](https://github.com/melissakipp/Yummily/blob/main/java/src/main/resources/images/prototype_create%26search.jpg)

*Transfer from GitLabs to GitHub*