SET mongod_exe=C:\"Program Files"\MongoDB\Server\3.4\bin\mongod.exe
SET username=Conor
REM Data folder has to exist before running the script
SET data_folder=C:\Users\%username%\MongoDB\data
%mongod_exe% --dbpath %data_folder%
pause
