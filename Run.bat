@echo off
setlocal enabledelayedexpansion

echo Running MusicLibraryApplication...

:: 1. Set the correct absolute path to the FX lib folder
set "FX_LIB=C:\Program Files (x86)\javafx\javafx-sdk\lib"

:: 2. Enter the output directory where your compiled .class files are
if exist "out" (
    cd out
) else (
    echo [ERROR] 'out' folder not found. Please compile the project first.
    pause
    exit /b 1
)

:: 3. Run the application
:: Note: We removed %USERPROFILE% because FX_LIB is already an absolute path.
java --module-path "%FX_LIB%" ^
     --add-modules javafx.controls,javafx.fxml ^
     -cp . MusicLibraryApplication.MusicLibraryApplication

echo.
echo Done!
pause