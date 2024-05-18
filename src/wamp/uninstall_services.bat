NET STOP wampapache
.\bin\apache\apache2.4.4\bin\httpd.exe -k uninstall -n wampapache
NET STOP wampmysqld 
.\bin\mysql\mysql5.6.12\bin\mysqld.exe --remove wampmysqld
wampmanager.exe -quit -id={wampserver}