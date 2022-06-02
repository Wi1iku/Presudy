echo Iniciar presudydb
sqlite3.exe Presudy.db ".mode column" ".header on" ".read cmd.sql"
sqlite3.exe Presudy.db

