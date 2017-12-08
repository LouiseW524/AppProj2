SET mongod_exe=C:\"Program Files"\MongoDB\Server\3.4\bin\mongod.exe
SET username=Public
SET data_folder=C:\Users\%username%\MongoDB\data
RMDIR %data_folder% /S /Q
MKDIR %data_folder%
%mongod_exe% --dbpath %data_folder%
pause
