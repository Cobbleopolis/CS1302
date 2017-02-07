@echo off

SET E_CODE=0

IF [%1] == [] (
    SET E_CODE=1
    GOTO EXIT
)

SET ZIP_SUFFIX=LoganThompson-Section8
SET SEVEN_Z="C:\Program Files\7-Zip\7z"
SET ZIP_NAME=%1-%ZIP_SUFFIX%.zip

CD %1

IF EXIST %ZIP_NAME% DEL %ZIP_NAME%

IF EXIST %ZIP_NAME% (
    SET E_CODE=2
    GOTO EXIT
)

%SEVEN_Z% a %ZIP_NAME% src -r -tzip
%SEVEN_Z% a %ZIP_NAME% output -r -tzip
%SEVEN_Z% a %ZIP_NAME% input -r -tzip
LABEL Exit
CD %~dp0
EXIT /B %E_CODE%