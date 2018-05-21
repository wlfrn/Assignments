# Please search for - how to install gdrive in ubuntu at olivermarshall.net and install it
# the below program is for taking backup of mysql databases and upload it to google drive



hostname="127.0.0.1"
user="root"
password="ttpl@123"
dbname="ASSIGNMENT_SQL"
table="STATION BST view_stats" # add space seperated table name,comma seperated will not work
now=$(date +"%Y-%B-%d")"-"$dbname



# this command will dump the mysql databases according 
# to the given dbname and table names into backup.sql file
mysqldump --host=$hostname --user=$user --password=$password $dbname $table > backup.sql



# this will create a zip file
zip $now.zip backup.sql



# this command will delete the temporary backup file
rm backup.sql



# this command will upload zip file into google drive
gdrive upload $now.zip


# this command will delete the zip file
rm $now.zip



# if we are accessing the gdrive for first time,
# it will ask for verification code after running this script file
# Open the given link from command line and paste it into
# browser, choose our google account
# click on allow button
# after clicking,token will be generated
# copy and paste the token into asked verification code in command line
# the token needs to be generated for first time only and 
# after that uploading will be done on the basis of same token







# to change username
# rm -rf ~/.gdrive
# run this script, it will ask for verification code
# Open the given link from command line and paste it into
# browser, choose our account
# click on allow button
# after clicking,token will be generated
# copy and paste the token into asked code in command line
