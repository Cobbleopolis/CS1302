@echo off

SET E_CODE=0

SET ZIP_SUFFIX=LoganThompson-Section8
SET SEVEN_Z="C:\Program Files\7-Zip\7z"
SET ZIP_NAME=%1-%ZIP_SUFFIX%.zip

CD %1

IF EXIST %ZIP_NAME% DEL %ZIP_NAME%

%SEVEN_Z% a %ZIP_NAME% src -r -tzip
%SEVEN_Z% a %ZIP_NAME% output -r -tzip
%SEVEN_Z% a %ZIP_NAME% outputs -r -tzip
%SEVEN_Z% a %ZIP_NAME% input -r -tzip
%SEVEN_Z% a %ZIP_NAME% inputs -r -tzip
CD %~dp0