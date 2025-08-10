@echo off
setlocal
setlocal enabledelayedexpansion

echo ============================================
echo Compiling MusicLibraryApplication...

cd /d "%~dp0"

:: ensure output dir
if not exist "out" mkdir "out"


REM Set the base path where JavaFX SDK folders are stored
set JAVAFX_BASE=C:\javafx

REM Find the first folder in the base path that starts with "javafx-sdk"
for /d %%i in ("%JAVAFX_BASE%\javafx-sdk*") do (
    set JAVAFX_DIR=%%i
    goto found
)
:found

:: compile (keep your fixed JavaFX path)
javac --module-path "%USERPROFILE%\Documents\%JAVAFX_DIR%\lib" ^
      --add-modules javafx.controls,javafx.fxml ^
      -d "out" src\MusicLibraryApplication\*.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

:: copy root to out after compilation succeeds
set FILES=Collection CollectionFile CollectionFile.dat
for %%F in (%FILES%) do (
    if exist "%%~F" (
        echo Copying %%~F -> out\
        copy /Y "%%~F" "out\%%~nxF" >nul
    )
)

echo Done Compiling
