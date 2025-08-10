echo Running MusicLibraryApplication...

setlocal enabledelayedexpansion

REM Set the base path where JavaFX SDK folders are stored
set JAVAFX_BASE=C:\javafx

REM Find the first folder in the base path that starts with "javafx-sdk"
for /d %%i in ("%JAVAFX_BASE%\javafx-sdk*") do (
    set JAVAFX_DIR=%%i
    goto found
)

cd out
java --module-path "%USERPROFILE%\Documents\%JAVAFX_DIR%\lib" ^
     --add-modules javafx.controls,javafx.fxml ^
     -cp . MusicLibraryApplication.MusicLibraryApplication

echo.
echo Done!
pause
